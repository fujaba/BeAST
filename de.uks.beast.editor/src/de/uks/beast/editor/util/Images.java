package de.uks.beast.editor.util;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.services.Graphiti;

public enum Images
{
	//@formatter:off
	PALETTE_ENTRY_IMAGE			("icons/compartment/category_icon.png",					"de.uks.beast.editor.palette_entry"),
	LOCATION_PALETTE_IMAGE		("icons/compartment/location_b.jpg",					"de.uks.beast.editor.location_palette"),
	SERVER_PALETTE_IMAGE		("icons/compartment/server_b.jpg",						"de.uks.beast.editor.server_palette"),
	NETWORK_PALETTE_IMAGE		("icons/compartment/network_d.png",						"de.uks.beast.editor.network_palette"),
	CONNECTION_PALETTE_IMAGE	("icons/compartment/ethernet_a.jpg",					"de.uks.beast.editor.ethernet_connection_palette"),
	
	HADOOP_PALETTE_IMAGE		("icons/compartment/hadoop_category_icon.png",			"de.uks.beast.editor.hadoop_palette"),
	HADOOP_MASTER_OBJECT_IMAGE	("icons/object/hadoop_master.png",						"de.uks.beast.editor.hadoop_master_object"),
	HADOOP_SLAVE_OBJECT_IMAGE	("icons/object/hadoop_slave.png",						"de.uks.beast.editor.hadoop_slave_object"),
	
	MYSQL_PALETTE_IMAGE			("icons/compartment/mysql_category_icon.png",			"de.uks.beast.editor.mysql_palette"),
	MYSQL_OBJECT_IMAGE			("icons/object/mysql.png",								"de.uks.beast.editor.mysql_object"),
	
	MONGO_DB_PALETTE_IMAGE		("icons/compartment/mongo_db_category_icon.png",		"de.uks.beast.editor.mongo_db_palette"),
	MONGO_DB_OBJECT_IMAGE		("icons/object/mongo_db.png",							"de.uks.beast.editor.mongo_db_object"),
	
	WORDPRESS_PALETTE_IMAGE		("icons/compartment/wordpress_category_icon.png",		"de.uks.beast.editor.wordpress_palette"),
	WORDPRESS_OBJECT_IMAGE		("icons/object/wordpress.png",							"de.uks.beast.editor.wordpress_object"),
	
	CASSANDRA_PALETTE_IMAGE		("icons/compartment/cassandra_category_icon.png",		"de.uks.beast.editor.cassandra_palette"),
	CASSANDRA_OBJECT_IMAGE		("icons/object/cassandra.png",							"de.uks.beast.editor.cassandra_object"),
	
	APACHE2_PALETTE_IMAGE		("icons/compartment/apache2_category_icon.png",			"de.uks.beast.editor.apache2_palette"),
	APACHE2_OBJECT_IMAGE		("icons/object/apache2.png",							"de.uks.beast.editor.apache2_object"),
	
	JENKINS_PALETTE_IMAGE		("icons/compartment/jenkins_category_icon.png",			"de.uks.beast.editor.jenkins_palette"),
	JENKINS_OBJECT_IMAGE		("icons/object/jenkins.png",							"de.uks.beast.editor.jenkins_object"),
	
	MEDIAWIKI_PALETTE_IMAGE		("icons/compartment/mediawiki_category_icon.png",		"de.uks.beast.editor.mediawiki_palette"),
	MEDIAWIKI_OBJECT_IMAGE		("icons/object/mediawiki.png",							"de.uks.beast.editor.mediawiki_object"),
	
	TOMCAT_PALETTE_IMAGE		("icons/compartment/tomcat_category_icon.png",			"de.uks.beast.editor.tomcat_palette"),
	TOMCAT_OBJECT_IMAGE			("icons/object/tomcat.png",								"de.uks.beast.editor.tomcat_object"),
	
	UBUNTU_PALETTE_IMAGE		("icons/compartment/ubuntu_category_icon.png",			"de.uks.beast.editor.ubuntu_palette"),
	UBUNTU_OBJECT_IMAGE			("icons/object/ubuntu.png",								"de.uks.beast.editor.ubuntu_object"),
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
	
	
	
	/**
	 * @return the image
	 */
	public Image getImageFor(final GraphicsAlgorithmContainer gaContainer)
	{
		return Graphiti.getGaService().createImage(gaContainer, imageID);
	}
	
}
