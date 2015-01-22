package de.uks.beast.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.Network;

public class XMLParser {
	
	private static Logger logger = LogManager.getLogger(XMLParser.class); 

	public static Hardware parseHardwareConfig(String srvconfig) {
		File configFile = new File(srvconfig);
		return parseHardwareConfig(configFile);
	}

	/**
	 * Extracts the model information out of the .diagram file
	 * @param srvconfig Absolute path to .diagram file
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Hardware parseHardwareConfig(File configFile) {
		Hardware hwconf = new Hardware();
		
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser newSAXParser = saxParserFactory.newSAXParser();
			XMLReader reader = newSAXParser.getXMLReader();

			InputStream in = new FileInputStream(configFile);
			try {
			    InputSource is = new InputSource(in);
			    is.setSystemId(configFile.getAbsolutePath());
			    reader.parse(is);
			} finally {
			    in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Network currentNetwork = null;
//		for (Iterator i = root.elementIterator(); i.hasNext();) {
//			Element element = (Element) i.next();
//			if (element.asXML().startsWith("<model:")) {
//				if (element.getName().equals("Network")) {
//					Network network = new Network();
//					network.setName(element.attributeValue("name"));
//					network.setIp(element.attributeValue("ip"));
//					network.setSubnetmask(element.attributeValue("subnetmask"));
//					network.setGateway(element.attributeValue("gateway"));
//					hwconf.addToNetworks(network);
//					
//					for (Object o : element.elements()) {
//						Element child = (Element) o;
//						Server server = new Server();
//						server.setHost(child.attributeValue("host"));
//						server.setCpu(Integer.parseInt(child.attributeValue("cpu")));
//						server.setRam(Integer.parseInt(child.attributeValue("ram")));
//						server.setDiskSpace(Integer.parseInt(child.attributeValue("diskSpace")));
//						server.setNetwork(currentNetwork);
//						network.addToServer(server);
//					}
//					
//				} 
//			}
//		}
		
		return hwconf;
	}

}
