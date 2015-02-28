package de.uks.beast.editor.util;

public enum Images
{
	//@formatter:off
	PALETTE_ENTRY_IMAGE			("icons/category_icon.png",						"de.uks.beast.editor.palette_entry"),
	LOCATION_PALETTE_IMAGE		("icons/location_b.jpg",						"de.uks.beast.editor.location_palette"),
	SERVER_PALETTE_IMAGE		("icons/server_b.jpg",							"de.uks.beast.editor.server_palette"),
	NETWORK_PALETTE_IMAGE		("icons/network_d.png",							"de.uks.beast.editor.network_palette"),
	CONNECTION_PALETTE_IMAGE	("icons/ethernet_a.jpg",						"de.uks.beast.editor.ethernet_connection_palette"),
	
	HADOOP_PALETTE_IMAGE		("icons/hadoop_category_icon.png",				"de.uks.beast.editor.hadoop_palette"),
	HADOOP_MASTER_OBJECT_IMAGE	("icons/hadoop_master.png",						"de.uks.beast.editor.hadoop_master_object"),
	HADOOP_SLAVE_OBJECT_IMAGE	("icons/hadoop_slave.png",						"de.uks.beast.editor.hadoop_slave_object"),
	
	MYSQL_PALETTE_IMAGE			("icons/mysql_category_icon.png",				"de.uks.beast.editor.mysql_palette"),
	MYSQL_OBJECT_IMAGE			("icons/mysql.png",								"de.uks.beast.editor.mysql_object"),
	
	MONGO_DB_PALETTE_IMAGE		("icons/mongo_db_category_icon.png",			"de.uks.beast.editor.mongo_db_palette"),
	MONGO_DB_OBJECT_IMAGE		("icons/mongo_db.png",							"de.uks.beast.editor.mongo_db_object"),
	
	WORDPRESS_PALETTE_IMAGE		("icons/wordpress_category_icon.png",			"de.uks.beast.editor.wordpress_palette"),
	WORDPRESS_OBJECT_IMAGE		("icons/wordpress.png",							"de.uks.beast.editor.wordpress_object"),
	
	CASSANDRA_PALETTE_IMAGE		("icons/cassandra_category_icon.png",			"de.uks.beast.editor.cassandra_palette"),
	CASSANDRA_OBJECT_IMAGE		("icons/cassandra.png",							"de.uks.beast.editor.cassandra_object"),
	;//@formatter:on
	
	private final String	imagePath;
	private final String	imageID;
	
	
	
	private Images(final String imagePath, final String imageID)
	{
		this.imagePath = imagePath;
		this.imageID = imageID;
	}
	
	
	
	/**
	 * @return the imagePath
	 */
	public String getImagePath()
	{
		return imagePath;
	}
	
	
	
	/**
	 * @return the imageID
	 */
	public String getImageID()
	{
		return imageID;
	}
	
}
