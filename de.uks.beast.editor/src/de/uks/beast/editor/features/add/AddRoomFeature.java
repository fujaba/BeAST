package de.uks.beast.editor.features.add;

import model.Room;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import de.uks.beast.editor.features.util.PropertyUtil;
import de.uks.beast.editor.util.Colors;
import de.uks.beast.editor.util.Fonts;
import de.uks.beast.editor.util.Properties;

public class AddRoomFeature extends AbstractAddShapeFeature implements AbstractShapeFactory
{
	
	private static final int	WIDTH_PROPERTY	= 50;
	
	private static final int	HEIGHT_PROPERTY	= 20;
	
	private static final int	Y_PARTING_LINE	= 20;
	
	private static final int	X0_PARTING_LINE	= 0;
	
	private static final int	X_PROPERTY		= 5;
	
	
	
	public AddRoomFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof Room)
		{
			if (context.getTargetContainer() instanceof Diagram)
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	
	@Override
	public PictogramElement add(final IAddContext context)
	{
		final Room room = (Room) context.getNewObject();
		final Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		
		final IGaService gaService = Graphiti.getGaService();
		
		// create and set graphics algorithm
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(Colors.ROOM_FOREGROUND));
		roundedRectangle.setBackground(manageColor(Colors.ROOM_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		// if added Class has no resource we add it to the resource
		// of the diagram
		// in a real scenario the business model would have its own resource
		if (room.eResource() == null)
		{
			getDiagram().eResource().getContents().add(room);
		}
		// create link and wire it
		link(containerShape, room);
		
		// SHAPE WITH TEXT
		// create shape for text
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, X_PROPERTY, 0, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				room.getName());
		PropertyUtil.setAttributeShape(nameTextShape, Properties.NAME);
		
		// create link and wire it
		link(nameTextShape, room);
		
		// SHAPE WITH LINE
		// create shape for line
		final Shape lineShape = createShape(peCreateService, containerShape);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.ROOM_FOREGROUND));
		polyline.setLineWidth(2);
		
		final IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(containerShape);
		directEditingInfo.setPictogramElement(nameTextShape);
		directEditingInfo.setGraphicsAlgorithm(nameText);
		
		// add a chopbox anchor to the shape 
		peCreateService.createChopboxAnchor(containerShape);
		
		// call the layout feature
		layoutPictogramElement(containerShape);
		
		return containerShape;
	}
	
	
	
	@Override
	public Shape createShape(final IPeCreateService peCreateService, final ContainerShape containerShape)
	{
		return peCreateService.createShape(containerShape, false);
	}
	
	
	
	@Override
	public Text createTextShape(final IGaService gaService, final GraphicsAlgorithmContainer gaContainer, final int x,
			final int y, final int width, final int height, final String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.ROOM_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.ROOM_TITEL.getName(), Fonts.ROOM_TITEL.getSize(),
				Fonts.ROOM_TITEL.isItalic(), Fonts.ROOM_TITEL.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
