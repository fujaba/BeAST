package de.uks.beast.editor.feature.add;

import static de.uks.beast.editor.util.Properties.*;
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
import de.uks.beast.editor.util.StyleUtil;
import de.uks.beast.editor.util.Textfields;

public class AddNetworkFeature extends AbstractAddFeature implements AbstractShapeFactory {

	private static final int Y_PARTING_LINE = 20;

	private static final int X0_PARTING_LINE = 0;

	public AddNetworkFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if (context.getNewObject() instanceof Network) {
			if (context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}

		return false;
	}

	@Override
	public PictogramElement add(final IAddContext context) {
		final Network network = (Network) context.getNewObject();
		final Diagram targetDiagram = (Diagram) context.getTargetContainer();

		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		PropertyUtil.setObjectShape(containerShape, TYPE_NETWORK);

		final IGaService gaService = Graphiti.getGaService();
		; // need to access it later

		final RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setStyle(StyleUtil.getRedWhiteStyleForObject(getDiagram(), StyleUtil.NETWORK_STYLE_ID));
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(),
				context.getHeight());

		final Color color = manageColor(Colors.NETWORK_TEXT_FOREGROUND);

		if (network.eResource() == null) {
			getDiagram().eResource().getContents().add(network);
		}
		link(containerShape, network);

		// SHAPE FOR PROPERTY NAME
		final Shape nameTextShape = createShape(peCreateService, containerShape);
		final Text nameText = Textfields.NETWORK_NAME_FIELD.addTo(getDiagram(), nameTextShape, network.getName(),
				color);
		PropertyUtil.setAttributeShape(nameTextShape, NAME);
		link(nameTextShape, network);

		// SHAPE WITH LINE
		final Shape lineShape = createShape(peCreateService, containerShape);
		final Polyline polyline = gaService.createPolyline(lineShape,
				new int[] { X0_PARTING_LINE, Y_PARTING_LINE, context.getWidth(), Y_PARTING_LINE });
		polyline.setForeground(manageColor(Colors.NETWORK_FOREGROUND));
		polyline.setLineWidth(2);

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
	public Shape createShape(IPeCreateService peCreateService, ContainerShape containerShape) {
		return peCreateService.createShape(containerShape, false);
	}

	@Override
	public Text createPropertyTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y,
			int width, int height, String content) {
		final Text text = gaService.createText(gaContainer, content);
		text.setForeground(manageColor(Colors.NETWORK_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageFont(getDiagram(), Fonts.NETWORK_PROPERTY.getName(),
				Fonts.NETWORK_PROPERTY.getSize(), Fonts.NETWORK_PROPERTY.isItalic(), Fonts.NETWORK_PROPERTY.isBold()));
		gaService.setLocationAndSize(text, x, y, width, height);

		return text;
	}

	@Override
	public Text createTitleTextShape(IGaService gaService, GraphicsAlgorithmContainer gaContainer, int x, int y,
			int width, int height, String content) {
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
