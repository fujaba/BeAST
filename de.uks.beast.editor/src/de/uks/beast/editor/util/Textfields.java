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
	HADOOP_MASTER_NAME_FIELD					(5,		0,		90,		20,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_TITEL),
	HADOOP_MASTER_LIMIT_CPU_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_LIMIT_CPU_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_RESERVATION_CPU_LABEL_FIELD	(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_RESERVATION_CPU_PROP_FIELD	(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_LIMIT_MEM_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_LIMIT_MEM_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_RESERVATION_MEM_LABEL_FIELD	(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	HADOOP_MASTER_RESERVATION_MEM_PROP_FIELD	(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_MASTER_PROPERTY),
	
	HADOOP_SLAVE_NAME_FIELD						(5,		0,		90,		20,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_TITEL),
	HADOOP_SLAVE_LIMIT_CPU_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_LIMIT_CPU_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_RESERVATION_CPU_LABEL_FIELD	(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_RESERVATION_CPU_PROP_FIELD		(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_LIMIT_MEM_LABEL_FIELD			(5,		25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_LIMIT_MEM_PROP_FIELD			(105,	25,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_RESERVATION_MEM_LABEL_FIELD	(5,		40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	HADOOP_SLAVE_RESERVATION_MEM_PROP_FIELD		(105,	40,		100,	15,		Orientation.ALIGNMENT_LEFT,		Fonts.HADOOP_SLAVE_PROPERTY),
	
	NETWORK_NAME_FIELD							(5,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.NETWORK_TITEL),
	
	CONTROL_CENTER_NAME_FIELD					(5,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.NETWORK_TITEL),
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
