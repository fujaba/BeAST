package de.uks.beast.editor.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class EditorImageProvider extends AbstractImageProvider
{
	protected static final String	PREFIX			= "de.uks.beast.editor.";
	
	public static final String		HADOOP_MASTER_IMAGE	= PREFIX + "hadoopMaster";
	
	
	
	@Override
	protected void addAvailableImages()
	{
		addImageFilePath(HADOOP_MASTER_IMAGE, "icons/hadoopMaster.jpg");
	}
	
}
