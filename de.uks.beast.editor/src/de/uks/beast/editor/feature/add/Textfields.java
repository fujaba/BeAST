package de.uks.beast.editor.feature.add;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import de.uks.beast.editor.util.Fonts;

public enum Textfields
{
	//@formatter:off
	SERVER_NAME_FIELD			(5,		0,		50,		20,		Orientation.ALIGNMENT_LEFT,		Fonts.SERVER_TITEL),
	SERVER_RAM_FIELD			(5,		0,		20,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_CPU_FIELD			(25,	0,		20,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_RAM_CPU_FIELD		(45,	0,		97,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	
	SERVER_IP_FIELD				(0,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_CPU_CORES_FIELD		(0,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_MAX_RAM_FIELD		(0,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
	SERVER_DISK_SPACE_FIELD		(0,		0,		50,		20,		Orientation.ALIGNMENT_CENTER,	Fonts.SERVER_PROPERTY),
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
