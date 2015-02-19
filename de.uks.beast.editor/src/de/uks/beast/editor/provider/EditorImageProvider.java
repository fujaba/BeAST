package de.uks.beast.editor.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

import static de.uks.beast.editor.util.Constants.*;

public class EditorImageProvider extends AbstractImageProvider
{
	
	@Override
	protected void addAvailableImages()
	{
		addImageFilePath(HADOOP_MASTER_IMAGE_PATH.getImageID(), HADOOP_MASTER_IMAGE_PATH.getImagePath());
		addImageFilePath(HADOOP_SLAVE_IMAGE_PATH.getImageID(), HADOOP_SLAVE_IMAGE_PATH.getImagePath());
	}
	
}
