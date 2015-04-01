package de.uks.beast.editor.feature.add;

import static de.uks.beast.editor.util.Properties.DNS;
import static de.uks.beast.editor.util.Properties.DNS_LABEL;
import static de.uks.beast.editor.util.Properties.GATEWAY;
import static de.uks.beast.editor.util.Properties.GATEWAY_LABEL;
import static de.uks.beast.editor.util.Properties.IP;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Properties.SUBNET_MASK;
import static de.uks.beast.editor.util.Properties.SUBNET_MASK_LABEL;
import static de.uks.beast.editor.util.Properties.TYPE_NETWORK;
import model.Network;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import de.uks.beast.editor.util.Colors;
import de.uks.beast.editor.util.Fonts;
import de.uks.beast.editor.util.PropertyUtil;
import de.uks.beast.editor.util.Textfields;

public class AddNetworkFeature extends AbstractAddFeature implements AbstractShapeFactory
{
	
	private static final int	Y_PARTING_LINE	= 20;
	
	private static final int	X0_PARTING_LINE	= 0;
	
	
	
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
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		PropertyUtil.setObjectShape(containerShape, TYPE_NETWORK);
		
		final IGaService gaService = Graphiti.getGaService();; // need to access it later
		
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(Colors.NETWORK_FOREGROUND));
		roundedRectangle.setBackground(manageColor(Colors.NETWORK_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		final Color color = manageColor(Colors.ROUTER_TEXT_FOREGROUND);
		
		if (network.eResource() == null)
		{
			getDiagram().eResource().getContents().add(network);
		}
		link(containerShape, network);
		
		// SHAPE FOR PROPERTY NAME
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		final Text nameText = Textfields.NETWORK_NAME_FIELD.addTo(getDiagram(), nameTextShape, network.getName(), color);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		link(nameTextShape, network);
		
		// SHAPE WITH LINE
		final Shape lineShape = createShape(peCreateService, containerShape);
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.NETWORK_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY IP
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		Textfields.NETWORK_IP_LABEL_FIELD.addTo(getDiagram(), ipLabelShape, IP_LABEL.get(), color);
		Textfields.NETWORK_IP_PROP_FIELD.addTo(getDiagram(), ipTextShape, network.getIp(), color);
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		link(ipTextShape, network);
		
		//SHAPE FOR PROPERTY SUBNET_MASK
		final Shape subnetMaskTextShape = createShape(peCreateService, containerShape);
		final Shape subnetMaskLabelShape = createShape(peCreateService, containerShape);
		Textfields.NETWORK_SUBNET_MASK_LABEL_FIELD.addTo(getDiagram(), subnetMaskLabelShape, SUBNET_MASK_LABEL.get(),
				color);
		Textfields.NETWORK_SUBNET_MASK_PROP_FIELD.addTo(getDiagram(), subnetMaskTextShape, network.getSubnetmask(), color);
		PropertyUtil.setAttributeShape(subnetMaskTextShape, SUBNET_MASK);
		link(subnetMaskTextShape, network);
		
		//SHAPE FOR PROPERTY GATEWAY
		final Shape gatewayTextShape = createShape(peCreateService, containerShape);
		final Shape gatewayLabelShape = createShape(peCreateService, containerShape);
		Textfields.NETWORK_GATEWAY_LABEL_FIELD.addTo(getDiagram(), gatewayLabelShape, GATEWAY_LABEL.get(), color);
		Textfields.NETWORK_GATEWAY_PROP_FIELD.addTo(getDiagram(), gatewayTextShape, network.getGateway(), color);
		PropertyUtil.setAttributeShape(gatewayTextShape, GATEWAY);
		link(gatewayTextShape, network);
		
		//SHAPE FOR PROPERTY DNS
		final Shape dnsTextShape = createShape(peCreateService, containerShape);
		final Shape dnsLabelShape = createShape(peCreateService, containerShape);
		Textfields.NETWORK_DNS_LABEL_FIELD.addTo(getDiagram(), dnsLabelShape, DNS_LABEL.get(), color);
		Textfields.NETWORK_DNS_PROP_FIELD.addTo(getDiagram(), dnsTextShape, network.getDns(), color);
		PropertyUtil.setAttributeShape(dnsTextShape, DNS);
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
	public Text createPropertyTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.NETWORK_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.NETWORK_PROPERTY.getName(), Fonts.NETWORK_PROPERTY.getSize(),
				Fonts.NETWORK_PROPERTY.isItalic(), Fonts.NETWORK_PROPERTY.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
	
	
	@Override
	public Text createTitleTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.NETWORK_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.NETWORK_TITEL.getName(), Fonts.NETWORK_TITEL.getSize(),
				Fonts.NETWORK_TITEL.isItalic(), Fonts.NETWORK_TITEL.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
