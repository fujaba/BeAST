package de.uks.beast.editor.features.add;

import static de.uks.beast.editor.util.Constants.*;
import model.Rack;
import model.Server;

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
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.uks.beast.editor.features.util.PropertyUtil;

public class AddServerFeature extends AbstractAddShapeFeature implements AbstractShapeFactory
{
	
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= IColorConstant.BLACK;
	
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	private static final IColorConstant	E_CLASS_BACKGROUND		= new ColorConstant(187, 218, 247);
	
	private static final int			WIDTH_PROPERTY			= 50;
	
	private static final int			WIDTH_LABEL				= 100;
	
	private static final int			HEIGHT_PROPERTY			= 20;
	
	private static final int			HEIGHT_LABEL			= 20;
	
	private static final int			Y_PARTING_LINE			= 20;
	
	private static final int			X0_PARTING_LINE			= 0;
	
	private static final int			X_PROPERTY				= 5;
	
	
	
	public AddServerFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof Server)
		{
			if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Rack)
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	@Override
	public PictogramElement add(final IAddContext context)
	{
		final Server server = (Server) context.getNewObject();
		final ContainerShape targetDiagram = (ContainerShape) context.getTargetContainer();
		
		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		PropertyUtil.setObjectShape(containerShape, SERVER);
		
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
		if (server.eResource() == null)
		{
			getDiagram().eResource().getContents().add(server);
		}
		// create link and wire it
		link(containerShape, server);
		
		// SHAPE FOR PROPERTY NAME
		// create shape for text
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, X_PROPERTY, 0, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				server.getName());
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		
		// create link and wire it
		link(nameTextShape, server);
		
		// SHAPE FOR RESOURCE STAT RAM
		final Shape ramStatTextShape = createShape(peCreateService, containerShape);
		final Text ramStatText = createTextShape(gaService, ramStatTextShape, X_PROPERTY - 5, 0, 1, HEIGHT_PROPERTY, "100");
		ramStatText.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
		PropertyUtil.setAttributeShape(ramStatTextShape, RAM_STAT);
		
		// create link and wire it
		//link(ramStatTextShape, server);
		
		// SHAPE FOR RESOURCE STAT CPU
		final Shape cpuStatTextShape = createShape(peCreateService, containerShape);
		final Text cpuStatText = createTextShape(gaService, cpuStatTextShape, ramStatText.getX() - 20, 0, 1, HEIGHT_PROPERTY,
				"80");
		cpuStatText.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
		PropertyUtil.setAttributeShape(cpuStatTextShape, CPU_STAT);
		
		// create link and wire it
		//link(cpuStatTextShape, server);
		
		final Shape statsLabelShape = createShape(peCreateService, containerShape);
		final Text statsLabelText = createTextShape(gaService, statsLabelShape, cpuStatText.getX() - 18, 0, 10, HEIGHT_LABEL,
				"CPU [%]/RAM [%]: ");
		statsLabelText.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
		
		// SHAPE WITH LINE
		// create shape for line
		final Shape lineShape = createShape(peCreateService, containerShape);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY IP
		// create shape for text
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ipLabelText = createTextShape(gaService, ipLabelShape, X_PROPERTY, 20, WIDTH_LABEL, HEIGHT_LABEL,
				IP_LABEL.text());
		createTextShape(gaService, ipTextShape, ipLabelText.getWidth(), 20, WIDTH_PROPERTY, HEIGHT_PROPERTY, server.getIp());
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		
		// create link and wire it
		link(ipTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_AMOUNT
		// create shape for text
		final Shape cpuAmountTextShape = createShape(peCreateService, containerShape);
		final Shape cpuAmountLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text cpuAmountLabelText = createTextShape(gaService, cpuAmountLabelShape, X_PROPERTY, 30, WIDTH_LABEL,
				HEIGHT_LABEL, CPU_AMOUNT_LABEL.text());
		createTextShape(gaService, cpuAmountTextShape, cpuAmountLabelText.getWidth(), 30, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				String.valueOf(server.getCpuAmount()));
		PropertyUtil.setAttributeShape(cpuAmountTextShape, CPU_AMOUNT);
		
		// create link and wire it
		link(cpuAmountTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_TYPE
		// create shape for text
		final Shape cpuTypeTextShape = createShape(peCreateService, containerShape);
		final Shape cpuTypeLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text cpuTypeLabelText = createTextShape(gaService, cpuTypeLabelShape, X_PROPERTY, 40, WIDTH_LABEL, HEIGHT_LABEL,
				CPU_TYPE.text());
		createTextShape(gaService, cpuTypeTextShape, cpuTypeLabelText.getWidth(), 40, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				server.getCpuType());
		PropertyUtil.setAttributeShape(cpuTypeTextShape, CPU_TYPE);
		
		// create link and wire it
		link(cpuTypeTextShape, server);
		
		//SHAPE FOR PROPERTY RAM
		// create shape for text
		final Shape ramTextShape = createShape(peCreateService, containerShape);
		final Shape ramLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ramLabelText = createTextShape(gaService, ramLabelShape, X_PROPERTY, 50, WIDTH_LABEL, HEIGHT_LABEL,
				RAM_LABEL.text());
		createTextShape(gaService, ramTextShape, ramLabelText.getWidth(), 50, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				String.valueOf(server.getRam()));
		PropertyUtil.setAttributeShape(ramTextShape, RAM);
		
		// create link and wire it
		link(ramTextShape, server);
		
		//SHAPE FOR PROPERTY DISK_SPACE
		// create shape for text
		final Shape diskSpaceTextShape = createShape(peCreateService, containerShape);
		final Shape diskSpaceLabelShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text diskSpaceLabelText = createTextShape(gaService, diskSpaceLabelShape, X_PROPERTY, 60, WIDTH_LABEL,
				HEIGHT_LABEL, DISKSPACE_LABEL.text());
		createTextShape(gaService, diskSpaceTextShape, diskSpaceLabelText.getWidth(), 60, WIDTH_PROPERTY, HEIGHT_PROPERTY,
				String.valueOf(server.getDiskSpace()));
		PropertyUtil.setAttributeShape(diskSpaceTextShape, DISKSPACE);
		
		// create link and wire it
		link(diskSpaceTextShape, server);
		
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
