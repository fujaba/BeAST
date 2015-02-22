package de.uks.beast.editor.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

import de.uks.beast.editor.util.StringConstants;
import static de.uks.beast.editor.util.StringConstants.*;

public class EditorImageProvider extends AbstractImageProvider
{
	
	@Override
	protected void addAvailableImages()
	{
//		addImageFilePath(LOCATION_CATEGORY_IMAGE.getImageID(), LOCATION_CATEGORY_IMAGE.getImagePath());
//		
//		addImageFilePath(CONNECTION_CATGEGORY_IMAGE.getImageID(), CONNECTION_CATGEGORY_IMAGE.getImagePath());
//		
//		addImageFilePath(HADOOP_CATGEGORY_IMAGE.getImageID(), HADOOP_CATGEGORY_IMAGE.getImagePath());
//		addImageFilePath(HADOOP_MASTER_IMAGE.getImageID(), HADOOP_MASTER_IMAGE.getImagePath());
//		addImageFilePath(HADOOP_SLAVE_IMAGE.getImageID(), HADOOP_SLAVE_IMAGE.getImagePath());
//		
//		addImageFilePath(CASSANDRA_CATEGORY_IMAGE.getImageID(), CASSANDRA_CATEGORY_IMAGE.getImagePath());
//		addImageFilePath(CASSANDRA_IMAGE.getImageID(), CASSANDRA_IMAGE.getImagePath());
//		
//		addImageFilePath(MYSQL_CATEGORY_IMAGE.getImageID(), MYSQL_CATEGORY_IMAGE.getImagePath());
//		addImageFilePath(MYSQL_IMAGE.getImageID(), MYSQL_IMAGE.getImagePath());
//		
//		addImageFilePath(WORDPRESS_CATEGORY_IMAGE.getImageID(), WORDPRESS_CATEGORY_IMAGE.getImagePath());
//		addImageFilePath(WORDPRESS_IMAGE.getImageID(), WORDPRESS_IMAGE.getImagePath());
//		
//		addImageFilePath(MONGO_DB_CATEGORY_IMAGE.getImageID(), MONGO_DB_CATEGORY_IMAGE.getImagePath());
//		addImageFilePath(MONGO_DB_IMAGE.getImageID(), MONGO_DB_IMAGE.getImagePath());
		
		addImage(LOCATION_PALETTE_IMAGE, SERVER_PALETTE_IMAGE, NETWORK_PALETTE_IMAGE, CONNECTION_PALETTE_IMAGE, HADOOP_PALETTE_IMAGE, HADOOP_MASTER_OBJECT_IMAGE,
				HADOOP_SLAVE_OBJECT_IMAGE, CASSANDRA_PALETTE_IMAGE, CASSANDRA_OBJECT_IMAGE, MYSQL_PALETTE_IMAGE, MYSQL_OBJECT_IMAGE,
				WORDPRESS_PALETTE_IMAGE, WORDPRESS_OBJECT_IMAGE, MONGO_DB_PALETTE_IMAGE, MONGO_DB_OBJECT_IMAGE);
	}
	
	
	
	private void addImage(final StringConstants... constants)
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
