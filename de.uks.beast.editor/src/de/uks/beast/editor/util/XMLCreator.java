package de.uks.beast.editor.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobInterface;

public class XMLCreator
{
	
	private static Document createDocument() throws ParserConfigurationException
	{
		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		return docBuilder.newDocument();
	}
	
	private static enum Elements
	{
		//@formatter:off
		JOB				("job"),
		NAME			("name"),
		JOB_FILE		("jobFile"),
		INPUT_FILES		("inputFiles"),
		INPUT_FILE		("inputFile"),
		SOURCE_PATH		("sourcePath"),
		TARGET_PATH		("targetPath"),
		OUTPUT_FILE		("outputFile"),
		PATH			("path"),
		;//@formatter:on
		
		private final String	msg;
		
		
		
		private Elements(final String msg)
		{
			this.msg = msg;
		}
	}
	
	
	
	public static void createConfigFileFrom(final Job job)
	{
		try
		{
			final Document doc = createDocument();
			
			final Element rootElement = doc.createElement(Elements.JOB.msg);
			doc.appendChild(rootElement);
			
			final Attr jobName = doc.createAttribute(Elements.NAME.msg);
			jobName.setValue(job.getName());
			rootElement.setAttributeNode(jobName);
			
			final Element jobFile = doc.createElement(Elements.JOB_FILE.msg);
			rootElement.appendChild(jobFile);
			
			final Attr jobFileName = doc.createAttribute(Elements.NAME.msg);
			jobFileName.setValue(job.getJobFile().getName());
			jobFile.setAttributeNode(jobFileName);
			
			final Element inputFiles = doc.createElement(Elements.INPUT_FILES.msg);
			rootElement.appendChild(inputFiles);
			
			for (final JobInterface ji : job.getInputFiles())
			{
				final Element inputFile = doc.createElement(Elements.INPUT_FILE.msg);
				inputFiles.appendChild(inputFile);
				
				final Attr inputFileName = doc.createAttribute(Elements.NAME.msg);
				inputFileName.setValue(ji.getName());
				inputFile.setAttributeNode(inputFileName);
				
				final Element inputFileSource = doc.createElement(Elements.SOURCE_PATH.msg);
				inputFileSource.appendChild(doc.createTextNode(ji.getPath().toString()));
				inputFile.appendChild(inputFileSource);
				
				final Element inputFileTarget = doc.createElement(Elements.TARGET_PATH.msg);
				inputFileTarget.appendChild(doc.createTextNode(ji.unzipTo().toString()));
				inputFile.appendChild(inputFileTarget);
			}
			
			final Element jobOutputFile = doc.createElement(Elements.OUTPUT_FILE.msg);
			rootElement.appendChild(jobOutputFile);
			
			final Attr jobOutputName = doc.createAttribute(Elements.PATH.msg);
			jobOutputName.setValue(job.getOutputFile().getPath().toString());
			jobOutputFile.setAttributeNode(jobOutputName);
			
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(doc);
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			final StreamResult result = new StreamResult(Configs.CONFIG_XML.getPath().toFile());
			
			transformer.transform(source, result);
		}
		catch (ParserConfigurationException | TransformerException e)
		{
			e.printStackTrace();
		}
	}
	
}
