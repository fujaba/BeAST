package de.uks.beast.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.api.akka.AkkaRemoteController;
import de.uks.beast.api.util.LoggingUtil;
import de.uks.beast.api.util.XMLParser;
import de.uks.beast.model.Hardware;

public abstract class BeastTestScenario {
	
	private static Logger logger = LogManager.getLogger(BeastTestScenario.class); 

	private BeastTestCollection tests;
	private TestEnvironment environment;
	private String srvconfig;

	public BeastTestScenario() {
		this.tests = new BeastTestCollection();
		this.environment = new TestEnvironment();
	}

	public static void launch(String[] args) {
		StackTraceElement[] cause = Thread.currentThread().getStackTrace();
		boolean foundThisMethod = false;
		String callingClassName = null;
		for (StackTraceElement se : cause) {
			String className = se.getClassName();
			String methodName = se.getMethodName();
			if (foundThisMethod) {
				callingClassName = className;
				break;
			} else if (BeastTestScenario.class.getName().equals(className)
					&& "launch".equals(methodName)) {
				foundThisMethod = true;
			}
		}
		if (callingClassName == null) {
			throw new RuntimeException(
					"Error: unable to determine BeastTestScenario class");
		}
		try {
			@SuppressWarnings("rawtypes")
			Class theClass = Class.forName(callingClassName, true, Thread
					.currentThread().getContextClassLoader());
			if (BeastTestScenario.class.isAssignableFrom(theClass)) {
				@SuppressWarnings("unchecked")
				Class<? extends BeastTestScenario> appClass = theClass;
				
				// Setup of the test scenario
				BeastTestScenario scenario = appClass.newInstance();
				scenario.withTests(scenario.tests);
				scenario.setTestEnvironment(scenario.environment);
				
				// Execution of test scenario
				scenario.executeEnvironment();
			} else {
				throw new RuntimeException(
						"Error: "
								+ theClass
								+ " is not a subclass of de.uks.beast.api.BeastTestScenario");
			}
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void executeEnvironment() {
		if (environment.getHost() == null && 
				environment.getPort() == -1) {
			LoggingUtil.fatal("Could not determine host/port to" +
							" contact supervisor service. Set explicitly via useEnvironment method.", logger);
		} else {
			
			if (environment.getDiagramPath() == null) {
				searchConfigFile();
				
				if (srvconfig == null) {
					LoggingUtil.fatal("Could not find any .srvconfig file", logger);
				}
			} else {
				srvconfig = environment.getDiagramPath();
			}
			
			logger.info("Parsing hardware configuration");
			
			Hardware hwconf = XMLParser.parseHardwareConfig(srvconfig);
			
			logger.info("Connecting to akka remote server ...");
			
			AkkaRemoteController akkaControllerActor = new AkkaRemoteController(
					"akka.tcp://AkkaServer@" + environment.getHost() + ":" 
					+ environment.getPort() + "/user/ServerActor"
			);
			
			akkaControllerActor.send(hwconf);
			
			logger.info("Configuration sent successfully. Executing environment ...");
		}
	}
	
	private void searchConfigFile() {
		ArrayList<String> diagramPathes = new ArrayList<String>();
		recursiveSearch(new File(System.getProperty("user.dir")), diagramPathes);
		
		if (diagramPathes.size() == 1) {
			this.srvconfig = diagramPathes.get(0);
		} else if (diagramPathes.size() > 1) {
			logger.warn("Found more than one config file, using the first one");
			this.srvconfig = diagramPathes.get(0);
		}
	}

	private void recursiveSearch(File dir, ArrayList<String> pathes) {
		Collection<File> files = FileUtils.listFiles(dir,
				TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

		for (File f : files) {
			if (f.isFile()) {
				if (FilenameUtils.getExtension(f.getPath()).equals("diagram")) {
					pathes.add(f.getAbsolutePath());
				}
			} else {
				recursiveSearch(f, pathes);
			}
		}
		
	}
	
	protected abstract void setTestEnvironment(TestEnvironment environment);
	protected abstract void withTests(BeastTestCollection tests);

}
