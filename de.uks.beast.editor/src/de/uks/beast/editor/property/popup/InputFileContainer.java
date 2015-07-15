package de.uks.beast.editor.property.popup;

import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputFileContainer
{
	private final List<Path>	inputPaths;
	private final Path			unzipToPath;
	
	
	
	protected InputFileContainer(final List<Path> inputPaths, final Path unzipToPath)
	{
		this.inputPaths = Collections.unmodifiableList(inputPaths);
		this.unzipToPath = unzipToPath;
	}
	
	
	
	/**
	 * @return the inputPaths
	 */
	public List<Path> getInputPaths()
	{
		return inputPaths;
	}
	
	
	
	/**
	 * @return the unzipToPath
	 */
	protected Path getUnzipToPath()
	{
		return unzipToPath;
	}
	
	
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof InputFileContainer)
		{
			final Set<Path> currentSet = new HashSet<>();
			currentSet.addAll(inputPaths);
			
			final Set<Path> setToCheck = new HashSet<>();
			setToCheck.addAll(((InputFileContainer) obj).getInputPaths());
			
			return (currentSet.equals(setToCheck) && ((InputFileContainer) obj).getUnzipToPath().equals(unzipToPath));
		}
		
		return false;
	}
	
}
