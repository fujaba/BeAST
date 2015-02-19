package de.uks.beast.editor.features.add;

import static de.uks.beast.editor.util.StringConstants.DNS;
import static de.uks.beast.editor.util.StringConstants.DNS_LABEL;
import static de.uks.beast.editor.util.StringConstants.GATEWAY;
import static de.uks.beast.editor.util.StringConstants.GATEWAY_LABEL;
import static de.uks.beast.editor.util.StringConstants.ID;
import static de.uks.beast.editor.util.StringConstants.ID_LABEL;
import static de.uks.beast.editor.util.StringConstants.IP;
import static de.uks.beast.editor.util.StringConstants.IP_LABEL;
import static de.uks.beast.editor.util.StringConstants.NAME;
import static de.uks.beast.editor.util.StringConstants.NETWORK;
import static de.uks.beast.editor.util.StringConstants.SUBNET_MASK;
import static de.uks.beast.editor.util.StringConstants.SUBNET_MASK_LABEL;
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

import de.uks.beast.editor.features.util.PropertyUtil;
import de.uks.beast.editor.util.ColorConstants;

public class AddNetworkFeature extends AbstractAddFeature implements AbstractShapeFactory
{
	
	private static final int	WIDTH_PROPERTY	= 50;
	
	private static final int	WIDTH_LABEL		= 100;
	
	private static final int	HEIGHT_PROPERTY	= 20;
	
	private static final int	HEIGHT_LABEL	= 20;
	
	private static final int	Y_PARTING_LINE	= 20;
	
	private static final int	X0_PARTING_LINE	= 0;
	
	private static final int	X_PROPERTY		= 5;
	
	
	
	public AddNetworkFeature(final IFeatureProvider fp)
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
		PropertyUtil.setObjectShape(containerShape, NETWORK);
		
		final IGaService gaService = Graphiti.getGaService();; // need to access it later
		
		// create and set graphics algorithm
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(ColorConstants.NETWORK_FOREGROUND));
		roundedRectangle.setBackground(manageColor(ColorConstants.NETWORK_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		// if added Class has no resource we add it to the resource
		// of the diagram
		// in a real scenario the business model would have its own resource
		if (network.eResource() == null)
		{
			getDiagram().eResource().getContents().add(network);
		}
		// create link and wire it
		link(containerShape, network);
		
		// SHAPE FOR PROPERTY NAME
		// create shape for text
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, X_PROPERTY, 0, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				network.getName());
		nameText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		
		// create link and wire it
		link(nameTextShape, network);
		
		// SHAPE WITH LINE
		// create shape for line
		final Shape lineShape = createShape(peCreateService, containerShape);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(ColorConstants.NETWORK_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY IP
		// create shape for text
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ipLabelText = createTextShape(gaService, ipLabelShape, X_PROPERTY, 20, WIDTH_LABEL, HEIGHT_LABEL,
				IP_LABEL.text());
		createTextShape(gaService, ipTextShape, ipLabelText.getWidth(), 20, WIDTH_PROPERTY, HEIGHT_PROPERTY, network.getIp());
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		
		// create link and wire it
		link(ipTextShape, network);
		
		//SHAPE FOR PROPERTY ID
		// create shape for text
		final Shape idTextShape = createShape(peCreateService, containerShape);
		final Shape idLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text idLabelText = createTextShape(gaService, idLabelShape, X_PROPERTY, 30, WIDTH_LABEL, HEIGHT_LABEL,
				ID_LABEL.text());
		createTextShape(gaService, idTextShape, idLabelText.getWidth(), 30, WIDTH_PROPERTY, HEIGHT_PROPERTY, network.getId());
		PropertyUtil.setAttributeShape(idTextShape, ID);
		
		// create link and wire it
		link(idTextShape, network);
		
		//SHAPE FOR PROPERTY SUBNET_MASK
		// create shape for text
		final Shape subnetMaskTextShape = createShape(peCreateService, containerShape);
		final Shape subnetMaskLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text subnetMaskLabelText = createTextShape(gaService, subnetMaskLabelShape, X_PROPERTY, 40, WIDTH_LABEL,
				HEIGHT_LABEL, SUBNET_MASK_LABEL.text());
		createTextShape(gaService, subnetMaskTextShape, subnetMaskLabelText.getWidth(), 40, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				network.getSubnetmask());
		PropertyUtil.setAttributeShape(subnetMaskTextShape, SUBNET_MASK);
		
		// create link and wire it
		link(subnetMaskTextShape, network);
		
		//SHAPE FOR PROPERTY GATEWAY
		// create shape for text
		final Shape gatewayTextShape = createShape(peCreateService, containerShape);
		final Shape gatewayLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text gatewayLabelText = createTextShape(gaService, gatewayLabelShape, X_PROPERTY, 50, WIDTH_LABEL, HEIGHT_LABEL,
				GATEWAY_LABEL.text());
		createTextShape(gaService, gatewayTextShape, gatewayLabelText.getWidth(), 50, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				network.getGateway());
		PropertyUtil.setAttributeShape(gatewayTextShape, GATEWAY);
		
		// create link and wire it
		link(gatewayTextShape, network);
		
		//SHAPE FOR PROPERTY DNS
		// create shape for text
		final Shape dnsTextShape = createShape(peCreateService, containerShape);
		final Shape dnsLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text dnsLabelText = createTextShape(gaService, dnsLabelShape, X_PROPERTY, 60, WIDTH_LABEL, HEIGHT_LABEL,
				DNS_LABEL.text());
		createTextShape(gaService, dnsTextShape, dnsLabelText.getWidth(), 60, WIDTH_PROPERTY, HEIGHT_PROPERTY, network.getDns());
		PropertyUtil.setAttributeShape(dnsTextShape, DNS);
		
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
	public Shape createShape(IPeCreateService peCreateService, ContainerShape containerShape)
	{
		return peCreateService.createShape(containerShape, false);
	}
	
	
	
	@Override
	public Text createTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(ColorConstants.NETWORK_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
