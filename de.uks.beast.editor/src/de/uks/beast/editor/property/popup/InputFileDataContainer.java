package de.uks.beast.editor.property.popup;

import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputFileDataContainer
{
	private final List<Path>	inputPaths;
	private final Path			unzipToPath;
	
	
	
	protected InputFileDataContainer(final List<Path> inputPaths, final Path unzipToPath)
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
		if (obj instanceof InputFileDataContainer)
		{
			final Set<Path> currentSet = new HashSet<>();
			currentSet.addAll(inputPaths);
			
			final Set<Path> setToCheck = new HashSet<>();
			setToCheck.addAll(((InputFileDataContainer) obj).getInputPaths());
			
			return (currentSet.equals(setToCheck) && ((InputFileDataContainer) obj).getUnzipToPath().equals(unzipToPath));
		}
		
		return false;
	}
	
}
