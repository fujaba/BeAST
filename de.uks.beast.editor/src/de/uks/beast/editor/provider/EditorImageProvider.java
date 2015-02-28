package de.uks.beast.editor.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

import de.uks.beast.editor.util.Images;

public class EditorImageProvider extends AbstractImageProvider
{
	
	@Override
	protected void addAvailableImages()
	{
		addImages(Images.values());
	}
	
	
	
	private void addImages(final Images[] images)
	{
		for (final Images entry : images)
		{
			if (entry != null)
			{
				addImageFilePath(entry.getImageID(), entry.getImagePath());
			}
		}
	}
	
}
