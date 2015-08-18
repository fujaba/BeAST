package de.uks.beast.editor.util.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class XMLReaderTest
{
	
	@Test
	public void testReadXmlMethod()
	{
		final Path testInput = Paths.get("forTest/xmlTest.xml");
		final Data data = XMLHandler.readXml(testInput);
		
		assertEquals("TestJob", data.getName());
		
		assertEquals("TestJobFile.txt", data.getJobFilePath());
		
		assertFalse(data.getInputFilesPaths().isEmpty());
		assertTrue(data.getInputFilesPaths().size() == 3);
		for (int i = 0; i < data.getInputFilesPaths().toArray().length; i++)
		{
			assertEquals("TestInputFile_" + i + ".txt", data.getInputFilesPaths().get(i));
			assertEquals("D:\\Home\\Test\\TestInputFile_" + i + ".txt",
					data.getSourcePathForItem(data.getInputFilesPaths().get(i)));
			assertEquals("C:\\test_" + i, data.getTargetPathForItem(data.getInputFilesPaths().get(i)));
		}
		
		assertEquals("C:\\test\\test", data.getOutputFilePath());
	}
	
}
