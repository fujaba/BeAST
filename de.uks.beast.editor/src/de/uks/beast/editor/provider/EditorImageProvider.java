package de.uks.beast.editor.provider;

import static de.uks.beast.editor.util.Images.CASSANDRA_OBJECT_IMAGE;
import static de.uks.beast.editor.util.Images.CASSANDRA_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.CONNECTION_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.HADOOP_MASTER_OBJECT_IMAGE;
import static de.uks.beast.editor.util.Images.HADOOP_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.HADOOP_SLAVE_OBJECT_IMAGE;
import static de.uks.beast.editor.util.Images.LOCATION_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.MONGO_DB_OBJECT_IMAGE;
import static de.uks.beast.editor.util.Images.MONGO_DB_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.MYSQL_OBJECT_IMAGE;
import static de.uks.beast.editor.util.Images.MYSQL_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.NETWORK_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.PALETTE_ENTRY_IMAGE;
import static de.uks.beast.editor.util.Images.SERVER_PALETTE_IMAGE;
import static de.uks.beast.editor.util.Images.WORDPRESS_OBJECT_IMAGE;
import static de.uks.beast.editor.util.Images.WORDPRESS_PALETTE_IMAGE;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

import de.uks.beast.editor.util.Images;

public class EditorImageProvider extends AbstractImageProvider
{
	
	@Override
	protected void addAvailableImages()
	{
		
		//@formatter:off
		addImages(
				LOCATION_PALETTE_IMAGE, 
				SERVER_PALETTE_IMAGE, 
				NETWORK_PALETTE_IMAGE, 
				CONNECTION_PALETTE_IMAGE,
				
				HADOOP_PALETTE_IMAGE, 
				HADOOP_MASTER_OBJECT_IMAGE, 
				HADOOP_SLAVE_OBJECT_IMAGE, 
				
				CASSANDRA_PALETTE_IMAGE,
				CASSANDRA_OBJECT_IMAGE, 
				
				MYSQL_PALETTE_IMAGE, 
				MYSQL_OBJECT_IMAGE, 
				
				WORDPRESS_PALETTE_IMAGE, 
				WORDPRESS_OBJECT_IMAGE,
				
				MONGO_DB_PALETTE_IMAGE, 
				MONGO_DB_OBJECT_IMAGE, 
				
				PALETTE_ENTRY_IMAGE)
				;//@formatter:on
	}
	
	
	
	private void addImages(final Images... constants)
	{
		for (final Images entry : constants)
		{
			if (entry != null)
			{
				addImageFilePath(entry.getImageID(), entry.getImagePath());
			}
		}
	}
	
}
