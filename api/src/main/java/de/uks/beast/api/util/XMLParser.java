package de.uks.beast.api.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.Server;

public class XMLParser {
	
	private static Logger logger = LogManager.getLogger(XMLParser.class); 

	/**
	 * Extracts the model information out of the .diagram file
	 * @param srvconfig Absolute path to .diagram file
	 * @return
	 */
	public static Hardware parseHardwareConfig(String srvconfig) {
		File configFile = new File(srvconfig);
		
		if (!configFile.exists()) {
			LoggingUtil.fatal(new FileNotFoundException(srvconfig), 
					"Specified config file does not exist. Exiting", logger);
		}
		
		Hardware hwconf = new Hardware();
		
		SAXReader reader = new SAXReader();
		Document document = null;
        
		try {
			document = reader.read(configFile);
		} catch (DocumentException e) {
			logger.error("Could not read .diagram file", e);
		}
        
		Element root = document.getRootElement();
		
		for (@SuppressWarnings("rawtypes") Iterator i = root.elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			if (element.asXML().startsWith("<model:")) {
				if (element.getName().equals("Server")) {
					Server server = new Server();
					server.setHost(element.attributeValue("host"));
					server.setCpu(Integer.parseInt(element.attributeValue("cpu")));
					server.setRam(Integer.parseInt(element.attributeValue("ram")));
					server.setDiskSpace(Integer.parseInt(element.attributeValue("diskSpace")));
					hwconf.addToServer(server);
				}
			}
		}

		return hwconf;
	}

}
