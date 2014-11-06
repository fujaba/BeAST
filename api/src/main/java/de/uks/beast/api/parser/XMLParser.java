package de.uks.beast.api.parser;

import java.io.File;
import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import de.uks.beast.api.BeastTestScenario;
import de.uks.beast.api.model.Hardware;

public class XMLParser {
	
	private static Logger logger = LogManager.getLogger(BeastTestScenario.class); 

	/**
	 * Extracts the model information out of the .diagram file
	 * @param srvconfig Absolute path to .diagram file
	 * @return
	 */
	public static Hardware parseHardwareConfig(String srvconfig) {
		File configFile = new File(srvconfig);
		
		SAXReader reader = new SAXReader();
		Document document = null;
        
		try {
			document = reader.read(configFile);
		} catch (DocumentException e) {
			logger.error("Could not read .diagram file", e);
		}
        
		Element root = document.getRootElement();
		
		for (@SuppressWarnings("rawtypes")
		Iterator i = root.elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			System.out.println(element);
		}

		return null;
	}

}
