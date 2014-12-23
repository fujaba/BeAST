package de.uks.beast.editor.features.add;

import model.Network;

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

import de.uks.beast.editor.features.util.manager.NetworkPictogramManager;
import static de.uks.beast.editor.features.util.message.Message.*;

public class AddNetworkComponentFeature extends AbstractAddFeature implements AbstractShapeManager
{
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= IColorConstant.BLACK;
	
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	private static final IColorConstant	E_CLASS_BACKGROUND		= new ColorConstant(187, 218, 247);
	
	
	
	public AddNetworkComponentFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof Network)
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
		final Network network = (Network) context.getNewObject();
		final Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		
		// define a default size for the shape
		final int width = 100;
		final int height = 50;
		final IGaService gaService = Graphiti.getGaService();
		RoundedRectangle roundedRectangle; // need to access it later
		
		// create and set graphics algorithm
		roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
		roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);
		
		// if added Class has no resource we add it to the resource
		// of the diagram
		// in a real scenario the business model would have its own resource
		if (network.eResource() == null)
		{
			getDiagram().eResource().getContents().add(network);
		}
		// create link and wire it
		link(containerShape, network);
		
		// SHAPE WITH LINE
		
		// create shape for line
		final Shape lineShape = peCreateService.createShape(containerShape, false);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape, new int[] { 0, 20, width, 20 });
		polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY NAME
		// create shape for text
		final Shape nameTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, 0, 0, width, 20, network.getName());
		NetworkPictogramManager.addToMap(NAME, nameText);
		
		// create link and wire it
		link(nameTextShape, network);
		
		// SHAPE FOR PROPERTY IP
		// create shape for text
		final Shape ipTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ipText = createTextShape(gaService, ipTextShape, 0, 20, width, 20, network.getIp());
		NetworkPictogramManager.addToMap(IP, ipText);
		
		// create link and wire it
		link(ipTextShape, network);
		
		//SHAPE FOR PROPERTY ID
		// create shape for text
		final Shape idTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text idText = createTextShape(gaService, idTextShape, 0, 30, width, 20, network.getId());
		NetworkPictogramManager.addToMap(ID, idText);
		
		// create link and wire it
		link(idTextShape, network);
		
		//SHAPE FOR PROPERTY SUBNET_MASK
		// create shape for text
		final Shape subnetMaskTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text subnetMaskText = createTextShape(gaService, subnetMaskTextShape, 0, 40, width, 20, network.getSubnetmask());
		NetworkPictogramManager.addToMap(SUBNET_MASK, subnetMaskText);
		
		// create link and wire it
		link(subnetMaskTextShape, network);
		
		//SHAPE FOR PROPERTY GATEWAY
		// create shape for text
		final Shape gatewayTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text gatewayText = createTextShape(gaService, gatewayTextShape, 0, 50, width, 20, network.getGateway());
		NetworkPictogramManager.addToMap(GATEWAY, gatewayText);
		
		// create link and wire it
		link(gatewayTextShape, network);
		
		//SHAPE FOR PROPERTY DNS
		// create shape for text
		final Shape dnsTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text dnsText = createTextShape(gaService, dnsTextShape, 0, 60, width, 20, network.getDns());
		NetworkPictogramManager.addToMap(DNS, dnsText);
		
		// create link and wire it
		link(dnsTextShape, network);
		
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
	public Shape createShapeFor(IPeCreateService peCreateService, ContainerShape containerShape)
	{
		return peCreateService.createShape(containerShape, false);
	}
	
	
	
	@Override
	public Text createTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
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
