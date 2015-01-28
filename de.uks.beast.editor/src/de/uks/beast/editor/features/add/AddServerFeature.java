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

import de.uks.beast.editor.features.util.PropertyUtil;
import static de.uks.beast.editor.util.Messages.*;

public class AddServerFeature extends AbstractAddShapeFeature implements AbstractShapeManager
{
	
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= IColorConstant.BLACK;
	
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	private static final IColorConstant	E_CLASS_BACKGROUND		= new ColorConstant(187, 218, 247);
	
	
	
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
		
		// define a default size for the shape
		final int width = 100;
		final int height = 80;
		final IGaService gaService = Graphiti.getGaService();
		
		// create and set graphics algorithm
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
		roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width*2, height);
		
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
		final Shape lineShape = createShape(peCreateService, containerShape);
		
		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(lineShape, new int[] { 0, 20, width, 20 });
		polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY NAME
		// create shape for text
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		final Text nameText = createTextShape(gaService, nameTextShape, 5, 0, width, 20, server.getName());
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		
		// create link and wire it
		link(nameTextShape, server);
		
		// SHAPE FOR RESOURCE STATS
		final Shape statsShape = createShape(peCreateService, containerShape);
		final Text statsText = createTextShape(gaService, statsShape, -5, 0, width, 20, "[CPU:_% | RAM:_%]");
		statsText.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
		//
		
		// SHAPE FOR PROPERTY IP
		// create shape for text
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		createTextShape(gaService, ipTextShape, 0, 20, width, 20, server.getIp());
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		
		// create link and wire it
		link(ipTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_AMOUNT
		// create shape for text
		final Shape cpuAmountTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		createTextShape(gaService, cpuAmountTextShape, 0, 30, width, 20, String.valueOf(server.getCpuAmount()));
		PropertyUtil.setAttributeShape(cpuAmountTextShape, CPU_AMOUNT);
		
		// create link and wire it
		link(cpuAmountTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_TYPE
		// create shape for text
		final Shape cpuTypeTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		createTextShape(gaService, cpuTypeTextShape, 0, 40, width, 20, server.getCpuType());
		PropertyUtil.setAttributeShape(cpuTypeTextShape, CPU_TYPE);
		
		// create link and wire it
		link(cpuTypeTextShape, server);
		
		//SHAPE FOR PROPERTY RAM
		// create shape for text
		final Shape ramTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		createTextShape(gaService, ramTextShape, 0, 50, width, 20, String.valueOf(server.getRam()));
		PropertyUtil.setAttributeShape(ramTextShape, RAM);
		
		// create link and wire it
		link(ramTextShape, server);
		
		//SHAPE FOR PROPERTY DISK_SPACE
		// create shape for text
		final Shape diskSpaceTextShape = createShape(peCreateService, containerShape);
		// create and set text graphics algorithm
		createTextShape(gaService, diskSpaceTextShape, 0, 60, width, 20, String.valueOf(server.getDiskSpace()));
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
