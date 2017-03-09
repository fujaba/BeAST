package de.uks.beast.editor.remote;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

public class YamlWriter
{
	private static final Logger	LOG		= LogManager.getLogger(YamlWriter.class);
	
	private static final String	PREFIX	= "dockerConfig";
	private static final String	SUFFIX	= ".yaml";
	
	private Document			diagramXml;
	
	
	
	public YamlWriter(final File diagramFile)
	{
		this.diagramXml = parseXml(diagramFile);
		
		removeNotNeededStuff();
	}
	
	
	
	public void writeConfig(final YamlConfig config)
	{
		LOG.debug(format(diagramXml));
		
		final File file = create();
		if (file != null)
		{
			//TODO: write the config with the basic xml
		}
	}
	
	
	
	private void removeNotNeededStuff()
	{
		final Element root = diagramXml.getDocumentElement();
		final NodeList styleElement = diagramXml.getElementsByTagName("pi:Diagram");
		root.removeChild(styleElement.item(0));
	}
	
	
	
	private String format(final Document xml)
	{
		try
		{
			final Node document = xml.getDocumentElement();
			
			final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			final LSSerializer writer = impl.createLSSerializer();
			
			writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
			writer.getDomConfig().setParameter("xml-declaration", true);
			
			return writer.writeToString(document);
		}
		catch (final Exception e)
		{
			LOG.error("cannot format XML document", e);
			return "";
		}
	}
	
	
	
	private Document parseXml(final File file)
	{
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			return documentBuilder.parse(file);
		}
		catch (SAXException | IOException | ParserConfigurationException e)
		{
			LOG.error("cannot parse diagram xml", e);
			return null;
		}
	}
	
	
	
	private File create()
	{
		try
		{
			return Files.createTempFile(PREFIX, SUFFIX).toFile();
		}
		catch (final IOException e)
		{
			LOG.error("cannot write docker config file", e);
			return null;
		}
	}
	
}
