package de.uks.beast.editor.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobInterface;
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
	
	
	
	public static String getSpecificFileSeparator()
	{
		return separator;
	}
	
	
	
	public static IStatus createZipFromJob(final Job job, String targetPlace, final IProgressMonitor monitor)
	{
		final AtomicInteger fileCounter = new AtomicInteger(1);
		//remove last symbol "separator" if exists
		if (targetPlace.endsWith(separator))
		{
			targetPlace = targetPlace.trim();
			targetPlace = targetPlace.substring(0, targetPlace.length() - 1);
		}
		try
		{
			// set total number of work units
			monitor.beginTask("Zipping" + job.getFileCount() + " files...", job.getFileCount());
			
			final FileOutputStream dest = new FileOutputStream(new File(targetPlace + separator + job.getName() + ".zip"));
			final ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
			
			out.setLevel(Deflater.BEST_COMPRESSION);
			
			if (job.getJobFile() != null && Files.exists(job.getJobFile().getPath()))
			{
				if (monitor.isCanceled())
				{
					out.close();
					throw new IOException("Zipping was canceled!");
				}
				monitor.subTask(fileCounter.get() + "/" + job.getFileCount() + " - " + job.getJobFile().getName());
				addToArchive("jobFile", job.getJobFile(), out);
				monitor.worked(1);
				fileCounter.incrementAndGet();
			}
			
			if (!job.getInputFiles().isEmpty())
			{
				for (final JobInterface ji : job.getInputFiles())
				{
					if (monitor.isCanceled())
					{
						out.close();
						throw new IOException("Zipping was canceled!");
					}
					if (Files.exists(ji.getPath()))
					{
						monitor.subTask(fileCounter.get() + "/" + job.getFileCount() + " - " + ji.getName());
						addToArchive("inputFiles", ji, out);
						monitor.worked(1);
						fileCounter.incrementAndGet();
					}
				}
			}
			
			if (job.getOutputFile() != null && Files.exists(job.getOutputFile().getPath()))
			{
				if (monitor.isCanceled())
				{
					out.close();
					throw new IOException("Zipping was canceled!");
				}
				monitor.subTask(fileCounter.get() + "/" + job.getFileCount() + " - " + job.getOutputFile().getName());
				addToArchive("outputFile", job.getOutputFile(), out);
				monitor.worked(1);
				fileCounter.incrementAndGet();
			}
			
			out.flush();
			out.close();
		}
		catch (final IOException e)
		{
			
			LOG.error("Error while zip creation: ", e);
			return Status.CANCEL_STATUS;
		}
		
		return Status.OK_STATUS;
	}
	
	
	
	private static void addToArchive(final String subDir, final JobInterface jobInterface, final ZipOutputStream zos)
			throws IOException
	{
		LOG.info("Writing '" + jobInterface.getName() + "' to zip file");
		
		final File file = jobInterface.getPath().toFile();
		final FileInputStream fis = new FileInputStream(file);
		final BufferedInputStream origin = new BufferedInputStream(fis, BUFFER);
		final ZipEntry zipEntry = new ZipEntry(subDir + separator + jobInterface.getName());
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