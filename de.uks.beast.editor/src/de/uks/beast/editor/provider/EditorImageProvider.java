package de.uks.beast.editor.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

import de.uks.beast.editor.util.StringConstants;
import static de.uks.beast.editor.util.StringConstants.*;

public class EditorImageProvider extends AbstractImageProvider
{
	
	@Override
	protected void addAvailableImages()
	{
		
		addImages(LOCATION_PALETTE_IMAGE, SERVER_PALETTE_IMAGE, NETWORK_PALETTE_IMAGE, CONNECTION_PALETTE_IMAGE,
				HADOOP_PALETTE_IMAGE, HADOOP_MASTER_OBJECT_IMAGE, HADOOP_SLAVE_OBJECT_IMAGE, CASSANDRA_PALETTE_IMAGE,
				CASSANDRA_OBJECT_IMAGE, MYSQL_PALETTE_IMAGE, MYSQL_OBJECT_IMAGE, WORDPRESS_PALETTE_IMAGE, WORDPRESS_OBJECT_IMAGE,
				MONGO_DB_PALETTE_IMAGE, MONGO_DB_OBJECT_IMAGE, PALETTE_ENTRY_IMAGE);
	}
	
	
	
	private void addImages(final StringConstants... constants)
	{
		for (final StringConstants entry : constants)
		{
			if (entry != null)
			{
				addImageFilePath(entry.getImageID(), entry.getImagePath());
			}
		}
	}
	
}
