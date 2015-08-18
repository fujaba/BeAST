package de.uks.beast.editor.util.xml;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.uks.beast.editor.job.Job;
import de.uks.beast.editor.job.JobFile;
import de.uks.beast.editor.util.Configs;

public class XMLWriterTest
{
	private Job	job;
	
	
	
	@Before
	public void init()
	{
		job = Job.builder().setName("TestJob").setJobFile(new JobFile("TestJobFile", Paths.get(""), Paths.get("")))
				.setOutputFile(new JobFile("TestOutputFile", Paths.get("sourcePath"), Paths.get("targetPath")))
				.addInputFiles(new JobFile("TestInputFile", Paths.get("sourcePath"), Paths.get("targetPath"))).build();
	}
	
	
	
	@Test
	public void testWriteXmlMethod()
	{
		XMLHandler.writeXml(job);
		
		final Data data = XMLHandler.readXml(Configs.CONFIG_XML.getPath());
		
		assertEquals("TestJob", data.getName());
		
		assertEquals("TestJobFile", data.getJobFilePath());
		
		assertEquals("sourcePath", data.getOutputFilePath());
		
		assertFalse(data.getInputFilesPaths().isEmpty());
		assertTrue(data.getInputFilesPaths().size() == 1);
		assertEquals("TestInputFile", data.getInputFilesPaths().get(0));
		assertEquals("sourcePath", data.getSourcePathForItem(data.getInputFilesPaths().get(0)));
		assertEquals("targetPath", data.getTargetPathForItem(data.getInputFilesPaths().get(0)));
	}
	
	
	
	@After
	public void removeXml() throws IOException
	{
		Files.deleteIfExists(Configs.CONFIG_XML.getPath());
	}
	
}
