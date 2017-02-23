package de.uks.beast.editor.util;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.services.Graphiti;

public enum Images
{
	//@formatter:off
	PALETTE_ENTRY_IMAGE			("icons/compartment/category_icon.png",					"de.uks.beast.editor.palette_entry"),
	NETWORK_PALETTE_IMAGE		("icons/compartment/network_d.png",						"de.uks.beast.editor.network_palette"),
	CONTROL_CENTER_PALETTE_IMAGE("icons/compartment/control_center.png",				"de.uks.beast.editor.control_center_palette"),
	CONNECTION_PALETTE_IMAGE	("icons/compartment/ethernet_a.jpg",					"de.uks.beast.editor.ethernet_connection_palette"),
	
	HADOOP_PALETTE_IMAGE		("icons/compartment/hadoop_category_icon.png",			"de.uks.beast.editor.hadoop_palette"),
	HADOOP_MASTER_OBJECT_IMAGE	("icons/object/hadoop_master.png",						"de.uks.beast.editor.hadoop_master_object"),
	HADOOP_SLAVE_OBJECT_IMAGE	("icons/object/hadoop_slave.png",						"de.uks.beast.editor.hadoop_slave_object"),
	
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
