package de.uks.beast.editor.feature.add;

import static de.uks.beast.editor.util.Properties.*;
import model.HadoopSlave;

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

public class AddHadoopSlaveFeature extends AbstractAddShapeFeature implements AbstractShapeFactory {

	private static final int Y_PARTING_LINE = 20;

	private static final int X0_PARTING_LINE = 0;

	public AddHadoopSlaveFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if (context.getNewObject() instanceof HadoopSlave) {
			if (context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(final IAddContext context) {
		final HadoopSlave hadoopSlave = (HadoopSlave) context.getNewObject();
		final ContainerShape parentContainer = (ContainerShape) context.getTargetContainer();

		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(parentContainer, true);
		PropertyUtil.setObjectShape(containerShape, TYPE_HADOOP_SLAVE);

		final IGaService gaService = Graphiti.getGaService();

		final RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(containerShape, 5, 5);
		roundedRectangle
				.setStyle(StyleUtil.getBlueWhiteGlossStyleForObject(getDiagram(), StyleUtil.HADOOP_SLAVE_STYLE_ID));
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(),
				context.getHeight());

		if (hadoopSlave.eResource() == null) {
			getDiagram().eResource().getContents().add(hadoopSlave);
		}
		link(containerShape, hadoopSlave);

		final Color color = manageColor(Colors.HADOOP_SLAVE_TEXT_FOREGROUND);

		// SHAPE FOR PROPERTY NAME
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		final Text nameText = Textfields.HADOOP_SLAVE_NAME_FIELD.addTo(getDiagram(), nameTextShape,
				hadoopSlave.getName(), color);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		link(nameTextShape, hadoopSlave);

		// SHAPE WITH LINE
		final Shape lineShape = createShape(peCreateService, containerShape);
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.HADOOP_SLAVE_FOREGROUND));
		polyline.setLineWidth(2);

		// SHAPE FOR PROPERTY limitCpu
		final Shape limitCpuTextShape = createShape(peCreateService, containerShape);
		final Shape limitCpuLabelShape = createShape(peCreateService, containerShape);
		Textfields.HADOOP_SLAVE_LIMIT_CPU_LABEL_FIELD.addTo(getDiagram(), limitCpuLabelShape, LIMIT_CPU_LABEL.get(),
				color);
		Textfields.HADOOP_SLAVE_LIMIT_CPU_PROP_FIELD.addTo(getDiagram(), limitCpuTextShape, hadoopSlave.getLimitCpu(),
				color);
		PropertyUtil.setAttributeShape(limitCpuTextShape, LIMIT_CPU);
		link(limitCpuTextShape, hadoopSlave);

		// SHAPE FOR PROPERTY reservationCpu
		final Shape reservationCpuTextShape = createShape(peCreateService, containerShape);
		final Shape reservationCpuLabelShape = createShape(peCreateService, containerShape);
		Textfields.HADOOP_SLAVE_RESERVATION_CPU_LABEL_FIELD.addTo(getDiagram(), reservationCpuLabelShape,
				RESERVATION_CPU_LABEL.get(), color);
		Textfields.HADOOP_SLAVE_RESERVATION_CPU_PROP_FIELD.addTo(getDiagram(), reservationCpuTextShape,
				hadoopSlave.getReservationCpu(), color);
		PropertyUtil.setAttributeShape(reservationCpuTextShape, RESERVATION_CPU);
		link(reservationCpuTextShape, hadoopSlave);

		// SHAPE FOR PROPERTY limitMem
		final Shape limitMemTextShape = createShape(peCreateService, containerShape);
		final Shape limitMemLabelShape = createShape(peCreateService, containerShape);
		Textfields.HADOOP_SLAVE_LIMIT_MEM_LABEL_FIELD.addTo(getDiagram(), limitMemLabelShape, LIMIT_MEM_LABEL.get(),
				color);
		Textfields.HADOOP_SLAVE_LIMIT_MEM_PROP_FIELD.addTo(getDiagram(), limitMemTextShape, hadoopSlave.getLimitMem(),
				color);
		PropertyUtil.setAttributeShape(limitMemTextShape, LIMIT_MEM);
		link(limitMemTextShape, hadoopSlave);

		// SHAPE FOR PROPERTY reservationMem
		final Shape reservationMemTextShape = createShape(peCreateService, containerShape);
		final Shape reservationMemLabelShape = createShape(peCreateService, containerShape);
		Textfields.HADOOP_SLAVE_RESERVATION_MEM_LABEL_FIELD.addTo(getDiagram(), reservationMemLabelShape,
				RESERVATION_MEM_LABEL.get(), color);
		Textfields.HADOOP_SLAVE_RESERVATION_MEM_PROP_FIELD.addTo(getDiagram(), reservationMemTextShape,
				hadoopSlave.getReservationMem(), color);
		PropertyUtil.setAttributeShape(reservationMemTextShape, RESERVATION_MEM);
		link(reservationMemTextShape, hadoopSlave);

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
	public Shape createShape(final IPeCreateService peCreateService, final ContainerShape containerShape) {
		return peCreateService.createShape(containerShape, false);
	}

	@Override
	public Text createPropertyTextShape(final IGaService gaService, final GraphicsAlgorithmContainer gaContainer,
			final int x, final int y, final int width, final int height, final String content) {
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.HADOOP_SLAVE_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.HADOOP_SLAVE_PROPERTY.getName(),
				Fonts.HADOOP_SLAVE_PROPERTY.getSize(), Fonts.HADOOP_SLAVE_PROPERTY.isItalic(),
				Fonts.HADOOP_SLAVE_PROPERTY.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);

		return text;
	}

	@Override
	public Text createTitleTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y,
			int width, int height, String content) {
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.HADOOP_SLAVE_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.HADOOP_SLAVE_TITEL.getName(),
				Fonts.HADOOP_SLAVE_TITEL.getSize(), Fonts.HADOOP_SLAVE_TITEL.isItalic(),
				Fonts.HADOOP_SLAVE_TITEL.isBold()));
		text.setWidth(width);
		// gaService.setLocationAndSize(text, x, y, width, height);

		return text;
	}

}
