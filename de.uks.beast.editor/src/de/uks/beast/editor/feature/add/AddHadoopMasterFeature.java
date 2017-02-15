package de.uks.beast.editor.feature.add;

import static de.uks.beast.editor.util.Properties.*;
import model.HadoopMaster;

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

public class AddHadoopMasterFeature extends AbstractAddShapeFeature implements AbstractShapeFactory
{
	
	private static final int	Y_PARTING_LINE	= 20;
	
	private static final int	X0_PARTING_LINE	= 0;
	
	
	
	public AddHadoopMasterFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof HadoopMaster)
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
		final HadoopMaster hadoopMaster = (HadoopMaster) context.getNewObject();
		final ContainerShape parentContainer = (ContainerShape) context.getTargetContainer();
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(parentContainer, true);
		PropertyUtil.setObjectShape(containerShape, TYPE_HADOOP_MASTER);
		
		final IGaService gaService = Graphiti.getGaService();
		
		final RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setStyle(StyleUtil.getBlueWhiteGlossStyleForObject(getDiagram(), StyleUtil.HADOOP_MASTER_STYLE_ID));
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		if (hadoopMaster.eResource() == null)
		{
			getDiagram().eResource().getContents().add(hadoopMaster);
		}
		link(containerShape, hadoopMaster);
		
		final Color color = manageColor(Colors.HADOOP_MASTER_TEXT_FOREGROUND);
		
		// SHAPE FOR PROPERTY NAME
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		final Text nameText = Textfields.HADOOP_MASTER_NAME_FIELD.addTo(getDiagram(), nameTextShape, hadoopMaster.getName(), color);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		link(nameTextShape, hadoopMaster);
		
		// SHAPE WITH LINE
		final Shape lineShape = createShape(peCreateService, containerShape);
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.HADOOP_MASTER_FOREGROUND));
		polyline.setLineWidth(2);
		
		// SHAPE FOR PROPERTY IP
		final Shape ipTextShape = createShape(peCreateService, containerShape);
		final Shape ipLabelShape = createShape(peCreateService, containerShape);
		Textfields.HADOOP_MASTER_ATTR_0_LABEL_FIELD.addTo(getDiagram(), ipLabelShape, ATTR_0_LABEL.get(), color);
		Textfields.HADOOP_MASTER_ATTR_0_PROP_FIELD.addTo(getDiagram(), ipTextShape, hadoopMaster.getAtribute_0(), color);
		PropertyUtil.setAttributeShape(ipTextShape, ATTR_0);
		link(ipTextShape, hadoopMaster);
		
		//SHAPE FOR PROPERTY CPU_AMOUNT
		final Shape cpuCoresTextShape = createShape(peCreateService, containerShape);
		final Shape cpuCoresLabelShape = createShape(peCreateService, containerShape);
		Textfields.HADOOP_MASTER_ATTR_1_LABEL_FIELD.addTo(getDiagram(), cpuCoresLabelShape, ATTR_1_LABEL.get(), color);
		Textfields.HADOOP_MASTER_ATTR_1_PROP_FIELD.addTo(getDiagram(), cpuCoresTextShape, hadoopMaster.getAtribute_1(), color);
		PropertyUtil.setAttributeShape(cpuCoresTextShape, ATTR_1);
		link(cpuCoresTextShape, hadoopMaster);
		
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
		text.setForeground(manageColor(Colors.HADOOP_MASTER_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.HADOOP_MASTER_PROPERTY.getName(), Fonts.HADOOP_MASTER_PROPERTY.getSize(),
				Fonts.HADOOP_MASTER_PROPERTY.isItalic(), Fonts.HADOOP_MASTER_PROPERTY.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
	
	
	@Override
	public Text createTitleTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y, int width,
			int height, String content)
	{
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.HADOOP_MASTER_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.HADOOP_MASTER_TITEL.getName(), Fonts.HADOOP_MASTER_TITEL.getSize(),
				Fonts.HADOOP_MASTER_TITEL.isItalic(), Fonts.HADOOP_MASTER_TITEL.isBold()));
		text.setWidth(width);
		//gaService.setLocationAndSize(text, x, y, width, height);
		
		return text;
	}
	
}
