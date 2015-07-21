package de.uks.beast.editor.feature.add;

import static de.uks.beast.editor.util.Properties.EXTERNAL_GATEWAY;
import static de.uks.beast.editor.util.Properties.EXTERNAL_GATEWAY_LABEL;
import static de.uks.beast.editor.util.Properties.ID;
import static de.uks.beast.editor.util.Properties.ID_LABEL;
import static de.uks.beast.editor.util.Properties.IP;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Properties.TYPE_ROUTER;
import model.Router;

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
import de.uks.beast.editor.util.StyleUtil;
import de.uks.beast.editor.util.Textfields;

public class AddRouterFeature extends AbstractAddFeature implements AbstractShapeFactory
{
	
	private static final int	Y_PARTING_LINE	= 20;
	
	private static final int	X0_PARTING_LINE	= 0;
	
	
	
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
		PropertyUtil.setObjectShape(containerShape, TYPE_ROUTER);
		
		final IGaService gaService = Graphiti.getGaService();
		
		// create and set graphics algorithm
		
		final RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setStyle(StyleUtil.getLimeWhiteStyleForObject(getDiagram(), StyleUtil.ROUTER_STYLE_ID));
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		final Color color = manageColor(Colors.ROUTER_TEXT_FOREGROUND);
		
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
		final Shape lineShape = createShape(peCreateService, containerShape);
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.ROUTER_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY NAME
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		final Text nameText = Textfields.ROUTER_NAME_FIELD.addTo(getDiagram(), nameTextShape, router.getName(), color);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		link(nameTextShape, router);
		
		// SHAPE FOR PROPERTY IP
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		Textfields.ROUTER_IP_LABEL_FIELD.addTo(getDiagram(), ipLabelShape, IP_LABEL.get(), color);
		Textfields.ROUTER_IP_PROP_FIELD.addTo(getDiagram(), ipTextShape, router.getIp(), color);
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		link(ipTextShape, router);
		
		//SHAPE FOR PROPERTY ID
		final Shape idTextShape = createShape(peCreateService, containerShape);
		final Shape idLabelShape = createShape(peCreateService, containerShape);
		Textfields.ROUTER_ID_LABEL_FIELD.addTo(getDiagram(), idLabelShape, ID_LABEL.get(), color);
		Textfields.ROUTER_ID_PROP_FIELD.addTo(getDiagram(), idTextShape, router.getId(), color);
		PropertyUtil.setAttributeShape(idTextShape, ID);
		link(idTextShape, router);
		
		//SHAPE FOR PROPERTY EXTERNAL_GATEWAY
		final Shape extGatewayTextShape = createShape(peCreateService, containerShape);
		final Shape extGatewayLabelShape = createShape(peCreateService, containerShape);
		Textfields.ROUTER_EXT_GATEWAY_LABEL_FIELD.addTo(getDiagram(), extGatewayLabelShape, EXTERNAL_GATEWAY_LABEL.get(), color);
		Textfields.ROUTER_EXT_GATEWAY_PROP_FIELD.addTo(getDiagram(), extGatewayTextShape, router.getExternalGateway(), color);
		PropertyUtil.setAttributeShape(extGatewayTextShape, EXTERNAL_GATEWAY);
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
	public Text createPropertyTextShape(final IGaService gaService, final GraphicsAlgorithmContainer gaContainer, final int x,
			final int y, final int width, final int height, final String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.ROUTER_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.ROUTER_PROPERTY.getName(), Fonts.ROUTER_PROPERTY.getSize(),
				Fonts.ROUTER_PROPERTY.isItalic(), Fonts.ROUTER_PROPERTY.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
	
	
	@Override
	public Text createTitleTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.ROUTER_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.ROUTER_TITEL.getName(), Fonts.ROUTER_TITEL.getSize(),
				Fonts.ROUTER_TITEL.isItalic(), Fonts.ROUTER_TITEL.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
