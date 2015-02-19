package de.uks.beast.editor.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

import static de.uks.beast.editor.util.StringConstants.*;

public class EditorImageProvider extends AbstractImageProvider
{
	
	@Override
	protected void addAvailableImages()
	{
		addImageFilePath(HADOOP_MASTER_IMAGE.getImageID(), HADOOP_MASTER_IMAGE.getImagePath());
		addImageFilePath(HADOOP_SLAVE_IMAGE.getImageID(), HADOOP_SLAVE_IMAGE.getImagePath());
	}
	
}
