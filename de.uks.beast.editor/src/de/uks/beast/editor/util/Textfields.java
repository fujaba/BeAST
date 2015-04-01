package de.uks.beast.editor.util;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

public enum Textfields
{
	//@formatter:off
	SERVER_NAME_FIELD				(5,		0,		50,		20,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_TITEL),
	SERVER_RAM_FIELD				(5,		0,		20,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_CPU_FIELD				(25,	0,		20,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_RAM_CPU_FIELD			(45,	0,		97,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_IP_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_IP_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_CPU_CORES_LABEL_FIELD	(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_CPU_CORES_PROP_FIELD		(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_MAX_RAM_LABEL_FIELD		(5,		55,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_MAX_RAM_PROP_FIELD		(105,	55,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_DISK_SPACE_LABEL_FIELD	(5,		70,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	SERVER_DISK_SPACE_PROP_FIELD	(105,	70,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_PROPERTY),
	
	ROUTER_NAME_FIELD				(5,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.ROUTER_TITEL),
	ROUTER_IP_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.ROUTER_PROPERTY),
	ROUTER_IP_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.ROUTER_PROPERTY),
	ROUTER_ID_LABEL_FIELD			(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.ROUTER_PROPERTY),
	ROUTER_ID_PROP_FIELD			(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.ROUTER_PROPERTY),
	ROUTER_EXT_GATEWAY_LABEL_FIELD	(5,		55,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.ROUTER_PROPERTY),
	ROUTER_EXT_GATEWAY_PROP_FIELD	(105,	55,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.ROUTER_PROPERTY),
	
	NETWORK_NAME_FIELD				(5,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.NETWORK_TITEL),
	NETWORK_IP_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_IP_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_SUBNET_MASK_LABEL_FIELD	(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_SUBNET_MASK_PROP_FIELD	(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_GATEWAY_LABEL_FIELD		(5,		55,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_GATEWAY_PROP_FIELD		(105,	55,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_DNS_LABEL_FIELD			(5,		70,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	NETWORK_DNS_PROP_FIELD			(105,	70,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.NETWORK_PROPERTY),
	;//@formatter:on
	
	final IGaService			gaService;
	private final int			moveForX;
	private final int			moveForY;
	private final int			width;
	private final int			height;
	private final Orientation	orientation;
	private final Fonts			font;
	
	
	
	private Textfields(final int moveForX, final int moveForY, final int width, final int height, final Orientation orientation,
			final Fonts font)
	{
		this.gaService = Graphiti.getGaService();
		this.moveForX = moveForX;
		this.moveForY = moveForY;
		this.width = width;
		this.height = height;
		this.orientation = orientation;
		this.font = font;
	}
	
	
	
	public Text addTo(final Diagram diagram, final GraphicsAlgorithmContainer gaContainer, final String value, final Color color)
	{
		final Text text = gaService.createText(gaContainer, value);
		text.setHorizontalAlignment(orientation);
		text.setForeground(color);
		text.setFont(gaService.manageFont(diagram, font.getName(), font.getSize(), font.isItalic(), font.isBold()));
		text.setX(moveForX);
		text.setY(moveForY);
		text.setWidth(width);
		text.setHeight(height);
		
		return text;
	}
	
	
	
	/**
	 * @return the moveForX
	 */
	public int moveForX()
	{
		return moveForX;
	}
	
	
	
	/**
	 * @return the moveForY
	 */
	public int moveForY()
	{
		return moveForY;
	}
	
	
	
	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}
	
}
