package de.uks.beast.editor.features.add;

import model.Router;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
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
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.uks.beast.editor.features.util.PropertyUtil;
import static de.uks.beast.editor.util.Constants.*;

public class AddRouterFeature extends AbstractAddFeature implements AbstractShapeFactory
{
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= IColorConstant.BLACK;
	
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	private static final IColorConstant	E_CLASS_BACKGROUND		= new ColorConstant(187, 218, 247);
	
	private static final int			WIDTH_PROPERTY			= 50;
	
	private static final int			WIDTH_LABEL				= 120;
	
	private static final int			HEIGHT_PROPERTY			= 20;
	
	private static final int			HEIGHT_LABEL			= 20;
	
	private static final int			Y_PARTING_LINE			= 20;
	
	private static final int			X0_PARTING_LINE			= 0;
	
	private static final int			X_PROPERTY				= 5;
	
	
	
	public AddRouterFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof Router)
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
		final Router router = (Router) context.getNewObject();
		final Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		PropertyUtil.setObjectShape(containerShape, ROUTER);
		
		final IGaService gaService = Graphiti.getGaService();
		
		// create and set graphics algorithm
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
		roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		// if added Class has no resource we add it to the resource
		// of the diagram
		// in a real scenario the business model would have its own resource
		if (router.eResource() == null)
		{
			getDiagram().eResource().getContents().add(router);
		}
		// create link and wire it
		link(containerShape, router);
		
		// SHAPE WITH LINE
		
		// create shape for line
		final Shape lineShape = createShape(peCreateService, containerShape);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY NAME
		// create shape for text
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, X_PROPERTY, 0, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				router.getName());
		nameText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		
		// create link and wire it
		link(nameTextShape, router);
		
		// SHAPE FOR PROPERTY IP
		// create shape for text
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ipLabelText = createTextShape(gaService, ipLabelShape, X_PROPERTY, 20, WIDTH_LABEL, HEIGHT_LABEL,
				IP_LABEL.text());
		createTextShape(gaService, ipTextShape, ipLabelText.getWidth(), 20, WIDTH_PROPERTY, HEIGHT_PROPERTY, router.getIp());
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		
		// create link and wire it
		link(ipTextShape, router);
		
		//SHAPE FOR PROPERTY ID
		// create shape for text
		final Shape idTextShape = createShape(peCreateService, containerShape);
		final Shape idLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text idLabelText = createTextShape(gaService, idLabelShape, X_PROPERTY, 30, WIDTH_LABEL, HEIGHT_LABEL,
				ID_LABEL.text());
		createTextShape(gaService, idTextShape, idLabelText.getWidth(), 30, WIDTH_PROPERTY, HEIGHT_PROPERTY, router.getId());
		PropertyUtil.setAttributeShape(idTextShape, ID);
		
		// create link and wire it
		link(idTextShape, router);
		
		//SHAPE FOR PROPERTY EXTERNAL_GATEWAY
		// create shape for text
		final Shape extGatewayTextShape = createShape(peCreateService, containerShape);
		final Shape extGatewayLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text extGatewayLabelText = createTextShape(gaService, extGatewayLabelShape, X_PROPERTY, 40, WIDTH_LABEL,
				HEIGHT_LABEL, EXTERNAL_GATEWAY_LABEL.text());
		createTextShape(gaService, extGatewayTextShape, extGatewayLabelText.getWidth(), 40, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				router.getExternalGateway());
		PropertyUtil.setAttributeShape(extGatewayTextShape, EXTERNAL_GATEWAY);
		
		// create link and wire it
		link(extGatewayTextShape, router);
		
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
		text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
