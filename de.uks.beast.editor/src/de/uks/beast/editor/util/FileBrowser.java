package de.uks.beast.editor.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.uks.beast.editor.util.OSChecker.OSType;

public class FileBrowser
{
	
	private final List<Path>	filePathes;
	private final FileDialog	fileDialog;
	
	
	
	public FileBrowser()
	{
		final Shell shell = new Shell();
		this.fileDialog = new FileDialog(shell, SWT.MULTI);
		this.filePathes = new ArrayList<>();
		
		configureFileDialog();
	}
	
	
	
	private void configureFileDialog()
	{
//		fileDialog.setFilterExtensions(new String[] { "*.jar", "*.zip", "*.rar", "*.txt", "*.*" });
//		fileDialog.setFilterNames(new String[] { "Any", "ZIP", "RAR", "TXT", "JAR" });
		fileDialog.setOverwrite(true);
	}
	
	
	
	public void openFileDialog()
	{
		fileDialog.open();
		
		saveSelection();
	}
	
	
	
	private void saveSelection()
	{
		for (final String fileName : fileDialog.getFileNames())
		{
			if (OSChecker.getOperatingSystemType().equals(OSType.Windows))
			{
				final String fileSeparator = System.getProperty("file.separator");
				final Path path = Paths.get(fileDialog.getFilterPath() + fileSeparator + fileName);
				
				if (Files.exists(path) && !filePathes.contains(path))
				{
					filePathes.add(path);
				}
			}
			else if (OSChecker.getOperatingSystemType().equals(OSType.Linux)
					|| OSChecker.getOperatingSystemType().equals(OSType.MacOS))
			{
				final String fileSeparator = "/";
				final Path path = Paths.get(fileDialog.getFilterPath() + fileSeparator + fileName);
				
				if (Files.exists(path) && !filePathes.contains(path))
				{
					filePathes.add(path);
				}
			}
		}
	}
	
	
	
	public List<Path> getFileList()
	{
		return filePathes;
	}
	
}
