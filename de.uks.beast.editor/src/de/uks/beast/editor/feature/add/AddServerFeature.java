package de.uks.beast.editor.feature.add;

import static de.uks.beast.editor.util.Properties.CPU_CORES;
import static de.uks.beast.editor.util.Properties.CPU_CORES_LABEL;
import static de.uks.beast.editor.util.Properties.CPU_STAT;
import static de.uks.beast.editor.util.Properties.DISKSPACE;
import static de.uks.beast.editor.util.Properties.DISKSPACE_LABEL;
import static de.uks.beast.editor.util.Properties.IP;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Properties.RAM;
import static de.uks.beast.editor.util.Properties.RAM_LABEL;
import static de.uks.beast.editor.util.Properties.RAM_STAT;
import static de.uks.beast.editor.util.Properties.TYPE_SERVER;
import model.Group;
import model.Server;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import de.uks.beast.editor.util.Colors;
import de.uks.beast.editor.util.Fonts;
import de.uks.beast.editor.util.Properties;
import de.uks.beast.editor.util.PropertyUtil;
import de.uks.beast.editor.util.Strings;

public class AddServerFeature extends AbstractAddShapeFeature implements AbstractShapeFactory
{
	
	private static final int	Y_PARTING_LINE	= 20;
	
	private static final int	X0_PARTING_LINE	= 0;
	
	
	
	public AddServerFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof Server)
		{
			if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Group)
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
		final ContainerShape parentContainer = (ContainerShape) context.getTargetContainer();
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(parentContainer, true);
		PropertyUtil.setObjectShape(containerShape, TYPE_SERVER);
		
		final IGaService gaService = Graphiti.getGaService();
		
		final RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground(manageColor(Colors.SERVER_FOREGROUND));
		roundedRectangle.setBackground(manageColor(Colors.SERVER_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		if (server.eResource() == null)
		{
			getDiagram().eResource().getContents().add(server);
		}
		link(containerShape, server);
		
		final Color color = manageColor(Colors.SERVER_TEXT_FOREGROUND);
		
		// SHAPE FOR PROPERTY NAME
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		final Text nameText = Textfields.SERVER_NAME_FIELD.addTo(getDiagram(), nameTextShape, server.getName(), color);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		link(nameTextShape, server);
		
		// SHAPE FOR RESOURCE STAT RAM
		final Shape ramStatTextShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_RAM_FIELD.addTo(getDiagram(), ramStatTextShape, "--", color);
		PropertyUtil.setAttributeShape(ramStatTextShape, RAM_STAT);
		link(ramStatTextShape, server);
		
		// SHAPE FOR RESOURCE STAT CPU
		final Shape cpuStatTextShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_CPU_FIELD.addTo(getDiagram(), cpuStatTextShape, "--", color);
		PropertyUtil.setAttributeShape(cpuStatTextShape, CPU_STAT);
		link(cpuStatTextShape, server);
		
		// SHAPE LABEL FOR CPU AND RAM
		final Shape statsLabelShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_RAM_CPU_FIELD.addTo(getDiagram(), statsLabelShape, Strings.STAT_LABEL_NAME.text(), color);
		PropertyUtil.setAttributeShape(statsLabelShape, Properties.STAT_LABEL);
		
		// SHAPE WITH LINE
		final Shape lineShape = createShape(peCreateService, containerShape);
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.SERVER_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY IP
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_IP_LABEL_FIELD.addTo(getDiagram(), ipLabelShape, IP_LABEL.get(), color);
		Textfields.SERVER_IP_PROP_FIELD.addTo(getDiagram(), ipTextShape, server.getIp(), color);
		PropertyUtil.setAttributeShape(ipTextShape, IP);
		link(ipTextShape, server);
		
		//SHAPE FOR PROPERTY CPU_AMOUNT
		final Shape cpuCoresTextShape = createShape(peCreateService, containerShape);
		final Shape cpuCoresLabelShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_CPU_CORES_LABEL_FIELD.addTo(getDiagram(), cpuCoresLabelShape, CPU_CORES_LABEL.get(), color);
		Textfields.SERVER_CPU_CORES_PROP_FIELD
				.addTo(getDiagram(), cpuCoresTextShape, String.valueOf(server.getCpuCores()), color);
		PropertyUtil.setAttributeShape(cpuCoresTextShape, CPU_CORES);
		link(cpuCoresTextShape, server);
		
		//SHAPE FOR PROPERTY RAM
		final Shape ramTextShape = createShape(peCreateService, containerShape);
		final Shape ramLabelShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_MAX_RAM_LABEL_FIELD.addTo(getDiagram(), ramLabelShape, RAM_LABEL.get(), color);
		Textfields.SERVER_MAX_RAM_PROP_FIELD.addTo(getDiagram(), ramTextShape, String.valueOf(server.getRam()), color);
		PropertyUtil.setAttributeShape(ramTextShape, RAM);
		link(ramTextShape, server);
		
		//SHAPE FOR PROPERTY DISK_SPACE
		final Shape diskSpaceTextShape = createShape(peCreateService, containerShape);
		final Shape diskSpaceLabelShape = createShape(peCreateService, containerShape);
		Textfields.SERVER_DISK_SPACE_LABEL_FIELD.addTo(getDiagram(), diskSpaceLabelShape, DISKSPACE_LABEL.get(), color);
		Textfields.SERVER_DISK_SPACE_PROP_FIELD.addTo(getDiagram(), diskSpaceTextShape, String.valueOf(server.getDiskSpace()),
				color);
		PropertyUtil.setAttributeShape(diskSpaceTextShape, DISKSPACE);
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
	public Text createPropertyTextShape(final IGaService gaService, final GraphicsAlgorithmContainer gaContainer, final int x,
			final int y, final int width, final int height, final String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.SERVER_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.SERVER_PROPERTY.getName(), Fonts.SERVER_PROPERTY.getSize(),
				Fonts.SERVER_PROPERTY.isItalic(), Fonts.SERVER_PROPERTY.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
	
	
	@Override
	public Text createTitleTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.SERVER_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.SERVER_TITEL.getName(), Fonts.SERVER_TITEL.getSize(),
				Fonts.SERVER_TITEL.isItalic(), Fonts.SERVER_TITEL.isBold()));
		text.setWidth(width);
		//gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
