package de.uks.beast.editor.features.add;

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

import de.uks.beast.editor.features.util.ServerPictogramIdentifier;

public class AddServerFeature extends AbstractAddShapeFeature
{
	
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= IColorConstant.BLACK;
	
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	private static final IColorConstant	E_CLASS_BACKGROUND		= new ColorConstant(187, 218, 247);
	
	private static final String			ID_NAME					= "name";
	private static final String			ID_IP					= "ip";
	private static final String			ID_CPU_AMOUNT			= "cpuamount";
	private static final String			ID_CPU_TYPE				= "cputype";
	private static final String			ID_RAM					= "ram";
	private static final String			ID_DISKSPACE			= "diskspace";
	
	
	
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
		if (server.eResource() == null)
		{
			getDiagram().eResource().getContents().add(server);
		}
		// create link and wire it
		link(containerShape, server);
		
		// SHAPE WITH LINE
		// create shape for line
		final Shape lineShape = createShapeFor(peCreateService, containerShape);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape, new int[] { 0, 20, width, 20 });
		polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY NAME
		// create shape for text
		final Shape nameTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, 0, 0, width, 20, server.getName(), ID_NAME);
		ServerPictogramIdentifier.addToMap(ID_NAME, nameText);
		
		// create link and wire it
		link(nameTextShape, server);
		
		// SHAPE FOR PROPERTY IP
		// create shape for text
		final Shape ipTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ipText = createTextShape(gaService, ipTextShape, 0,20, width, 20, server.getIp(), ID_IP);
		ServerPictogramIdentifier.addToMap(ID_IP, ipText);
		
		// create link and wire it
		link(ipTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_AMOUNT
		// create shape for text
		final Shape cpuAmountTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text cpuAmountText = createTextShape(gaService, cpuAmountTextShape, 0, 30, width, 20,
				String.valueOf(server.getCpuAmount()), ID_CPU_AMOUNT);
		ServerPictogramIdentifier.addToMap(ID_CPU_AMOUNT, cpuAmountText);
		
		// create link and wire it
		link(cpuAmountTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_TYPE
		// create shape for text
		final Shape cpuTypeTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text cpuTypeText = createTextShape(gaService, cpuTypeTextShape, 0, 40, width, 20, server.getCpuType(), ID_CPU_TYPE);
		ServerPictogramIdentifier.addToMap(ID_CPU_TYPE, cpuTypeText);
		
		// create link and wire it
		link(cpuTypeTextShape, server);
		
		//SHAPE FOR PROPERTY RAM
		// create shape for text
		final Shape ramTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text ramText = createTextShape(gaService, ramTextShape, 0, 50, width, 20, String.valueOf(server.getRam()), ID_RAM);
		ServerPictogramIdentifier.addToMap(ID_RAM, ramText);
		
		// create link and wire it
		link(ramTextShape, server);
		
		//SHAPE FOR PROPERTY DISK_SPACE
		// create shape for text
		final Shape diskSpaceTextShape = createShapeFor(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text diskSpaceText = createTextShape(gaService, diskSpaceTextShape, 0, 60, width, 20,
				String.valueOf(server.getDiskSpace()), ID_DISKSPACE);
		ServerPictogramIdentifier.addToMap(ID_DISKSPACE, diskSpaceText);
		
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
	
	
	
	private Shape createShapeFor(final IPeCreateService peCreateService, final ContainerShape containerShape)
	{
		return peCreateService.createShape(containerShape, false);
	}
	
	
	
	private Text createTextShape(final IGaService gaService, final GraphicsAlgorithmContainer gaContainer, final int x,
			final int y, final int width, final int height, final String content, final String identifier)
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
