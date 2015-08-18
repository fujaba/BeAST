package de.uks.beast.editor.util.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLReader
{
	private static final String	NAME		= "name";
	private static final String	PATH		= "path";
	private static final String	JOB_FILE	= "jobFile";
	private static final String	JOB			= "job";
	private static final String	SOURCE_PATH	= "sourcePath";
	private static final String	TARGET_PATH	= "targetPath";
	private static final String	OUTPUT_FILE	= "outputFile";
	private static final String	INPUT_FILES	= "inputFiles";
	private static final String	INPUT_FILE	= "inputFile";
	
	
	
	private XMLReader()
	{
	}
	
	
	
	private static XMLEventReader createReader(final Path path) throws FileNotFoundException, XMLStreamException
	{
		final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		final InputStream in = new FileInputStream(path.toString());
		
		return inputFactory.createXMLEventReader(in);
	}
	
	
	
	protected static Data readXml(final Path configFile)
	{
		final Data data = new Data();
		try
		{
			final XMLEventReader eventReader = createReader(configFile);
			// read the XML document
			ExtendedItem extendedItem = null;
			
			while (eventReader.hasNext())
			{
				XMLEvent event = eventReader.nextEvent();
				
				//reads jobFile element
				if (event.isStartElement())
				{
					final StartElement startElement = event.asStartElement();
					
					if (startElement.getName().getLocalPart() == JOB)
					{
						final Attribute attribute = startElement.getAttributeByName(QName.valueOf(NAME));
						data.setName(attribute.getValue());
						continue;
					}
					// If we have an item element, we create a new item
					else if (startElement.getName().getLocalPart() == JOB_FILE)
					{
						final Attribute attribute = startElement.getAttributeByName(QName.valueOf(NAME));
						final Item item = new Item(attribute.getValue());
						data.setJobFile(item);
						continue;
					}
					else if (startElement.getName().getLocalPart() == INPUT_FILES)
					{
						continue;
					}
					else if (startElement.getName().getLocalPart() == INPUT_FILE)
					{
						final Attribute attribute = startElement.getAttributeByName(QName.valueOf(NAME));
						extendedItem = new ExtendedItem(attribute.getValue());
						continue;
					}
					else if (startElement.getName().getLocalPart() == SOURCE_PATH)
					{
						if (extendedItem != null)
						{
							event = eventReader.nextEvent();
							extendedItem.sourcePath = Paths.get(event.asCharacters().getData());
							continue;
						}
					}
					else if (startElement.getName().getLocalPart() == TARGET_PATH)
					{
						if (extendedItem != null)
						{
							event = eventReader.nextEvent();
							extendedItem.targetPath = Paths.get(event.asCharacters().getData());
							continue;
						}
					}
					
					else if (startElement.getName().getLocalPart() == OUTPUT_FILE)
					{
						final Attribute attribute = startElement.getAttributeByName(QName.valueOf(PATH));
						final Item item = new Item(attribute.getValue());
						data.setOutputFile(item);
						continue;
					}
				}
				// If we reach the end of an item element, we add it to the list
				else if (event.isEndElement())
				{
					final EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == INPUT_FILE)
					{
						data.addInputFile(extendedItem);
					}
				}
			}
		}
		
		catch (FileNotFoundException | XMLStreamException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	protected static class Item
	{
		private String	value;
		
		
		
		private Item(final String name)
		{
			this.value = name;
		}
		
		
		
		/**
		 * @return the value
		 */
		protected String getValue()
		{
			return value;
		}
		
	}
	
	protected static class ExtendedItem extends Item
	{
		private Path	sourcePath;
		private Path	targetPath;
		
		
		
		private ExtendedItem(final String name)
		{
			super(name);
		}
		
		
		
		/**
		 * @return the sourcePath
		 */
		protected Path getSourcePath()
		{
			return sourcePath;
		}
		
		
		
		/**
		 * @return the targetPath
		 */
		protected Path getTargetPath()
		{
			return targetPath;
		}
		
	}
	
}
