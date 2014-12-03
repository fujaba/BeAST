package de.uks.beast.editor.features.add;

import model.Room;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
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
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class AddRoomFeature extends AbstractAddShapeFeature
{
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= IColorConstant.BLACK;
	
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	private static final IColorConstant	E_CLASS_BACKGROUND		= new ColorConstant(187, 218, 247);
	
	
	
	public AddRoomFeature(IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(IAddContext context)
	{
		System.out.println("########## " + getDiagram().getDiagramTypeId());
		
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
	public PictogramElement add(IAddContext context)
	{
		final Room room = (Room) context.getNewObject();
		final Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		
		// define a default size for the shape
		final int width = 100;
		final int height = 50;
		final IGaService gaService = Graphiti.getGaService();
		
		// create and set graphics algorithm
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
		roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);
		
		// if added Class has no resource we add it to the resource
		// of the diagram
		// in a real scenario the business model would have its own resource
		if (room.eResource() == null)
		{
			getDiagram().eResource().getContents().add(room);
		}
		// create link and wire it
		link(containerShape, room);
		
		// SHAPE WITH LINE
		
		// create shape for line
		final Shape lineShape = peCreateService.createShape(containerShape, false);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape, new int[] { 0, 20, width, 20 });
		polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE WITH TEXT
		
		// create shape for text
		final Shape textShape = peCreateService.createShape(containerShape, false);
		
		// create and set text graphics algorithm
		final Text text = gaService.createText(textShape, room.getType());
		text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(text, 0, 0, width, 20);
		
		// create link and wire it
		link(textShape, room);
		
		final IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(containerShape);
		directEditingInfo.setPictogramElement(textShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		
		// add a chopbox anchor to the shape 
		peCreateService.createChopboxAnchor(containerShape);
		
		// call the layout feature
		layoutPictogramElement(containerShape);
		
		return containerShape;
	}
	
}
