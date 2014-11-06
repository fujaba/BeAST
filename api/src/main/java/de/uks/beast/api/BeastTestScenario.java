package de.uks.beast.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.api.model.Hardware;
import de.uks.beast.api.parser.XMLParser;

public abstract class BeastTestScenario {
	
	private static Logger logger = LogManager.getLogger(BeastTestScenario.class); 

	private BeastTestCollection tests;
	private String host;
	private int port = -1;
	private String srvconfig;

	public BeastTestScenario() {
		this.tests = new BeastTestCollection();
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
				scenario.withTests();
				scenario.setTestEnvironment();
				
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
		if (host == null && port == -1) {
			throw new RuntimeException("Could not determine host/port to" +
							" contact supervisor service. Set explicitly via useEnvironment method.");
		} else {
			
			searchConfigFile();
			
			if (srvconfig == null) {
				logger.error("Could not find any .srvconfig file");
				throw new RuntimeException("Could not find any .srvconfig file");
			}
			
			Hardware hwconf = XMLParser.parseHardwareConfig(srvconfig);
			
			logger.info("Executing environment ...");
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

	/**
	 * Specifies the system on which the test scenario is executed
	 * 
	 * @param host 	The IP of the host which is running the supervisor
	 * 				service
	 * @param port	The port on which the supervisor service is 
	 * 				listening for requests
	 */
	protected void useEnvironment(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	/**
	 * Specifies the .srvconfig file which is used for this test scenario.
	 * If not specified, the classpath is searched for a .srvconfig file.
	 * 
	 * @param srvconfig	Absoulte path to the .srvconfig file.
	 */
	protected void useEnvironment(String srvconfig) {
		this.srvconfig = srvconfig;
	}
	
	protected abstract void setTestEnvironment();
	protected abstract void withTests();

	public BeastTestCollection getTests() {
		return tests;
	}

}
