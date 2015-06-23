package de.uks.beast.editor.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobFile;
import de.uks.beast.editor.util.OSChecker.OSType;

public class FileUtil
{
	private final static int	BUFFER		= 2048;
	private static final Logger	LOG			= LogManager.getLogger(FileUtil.class);
	private static String		separator	= "/";
	
	static
	{
		if (OSChecker.getOperatingSystemType().equals(OSType.Windows))
		{
			separator = "\\";
		}
	}
	
	
	
	public static boolean createZipFromJob(final Job job, String targetPlace)
	{
		//remove last symbol "separator" if exists
		if (targetPlace.endsWith(separator))
		{
			targetPlace = targetPlace.trim();
			targetPlace = targetPlace.substring(0, targetPlace.length() - 1);
		}
		try
		{
			final FileOutputStream dest = new FileOutputStream(new File(targetPlace + separator + job.getName() + ".zip"));
			final ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
			
			if (job.getJobFile() != null && Files.exists(job.getJobFile().getPath()))
			{
				addToArchive("jobFile", job.getJobFile(), out);
			}
			
			if (!job.getInputFiles().isEmpty())
			{
				for (final JobFile inputFile : job.getInputFiles())
				{
					if (Files.exists(inputFile.getPath()))
					{
						addToArchive("inputFiles", inputFile, out);
					}
				}
			}
			
			if (job.getOutputFile() != null && Files.exists(job.getOutputFile().getPath()))
			{
				addToArchive("outputFile", job.getOutputFile(), out);
			}
			
			out.flush();
			out.close();
		}
		catch (final IOException e)
		{
			LOG.error("createZipArchive threw exception: " + e.getMessage());
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	}
	
	
	
	private static void addToArchive(final String subDir, final JobFile jobFile, final ZipOutputStream zos) throws IOException
	{
		LOG.info("Writing '" + jobFile.getName() + "' to zip file");
		
		final File file = jobFile.getPath().toFile();
		final FileInputStream fis = new FileInputStream(file);
		final BufferedInputStream origin = new BufferedInputStream(fis, BUFFER);
		final ZipEntry zipEntry = new ZipEntry(subDir + separator + jobFile.getName());
		zos.putNextEntry(zipEntry);
		
		final byte[] bytes = new byte[BUFFER];
		int length;
		while ((length = origin.read(bytes)) >= 0)
		{
			zos.write(bytes, 0, length);
		}
		
		zos.closeEntry();
		fis.close();
	}
	
}
