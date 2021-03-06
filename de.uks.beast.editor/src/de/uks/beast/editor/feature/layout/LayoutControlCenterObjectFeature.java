package de.uks.beast.editor.feature.layout;

import static de.uks.beast.editor.util.Dimensions.CONTROL_CENTER_INITIAL_HEIGHT;
import static de.uks.beast.editor.util.Dimensions.CONTROL_CENTER_INITIAL_WIDTH;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import model.ControlCenter;

public class LayoutControlCenterObjectFeature extends AbstractLayoutFeature implements ILayoutFeature
{
	
	public LayoutControlCenterObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canLayout(final ILayoutContext context)
	{
		// return true, if pictogram element is linked to an EClass
		final PictogramElement pe = context.getPictogramElement();
		
		if (!(pe instanceof ContainerShape))
		{
			return false;
		}
		
		final EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
		
		return businessObjects.size() == 1 && businessObjects.get(0) instanceof ControlCenter;
	}
	
	
	
	@Override
	public boolean layout(final ILayoutContext context)
	{
		boolean anythingChanged = false;
		final ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		final GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
		
		// height
		if (containerGa.getHeight() < CONTROL_CENTER_INITIAL_HEIGHT)
		{
			containerGa.setHeight(CONTROL_CENTER_INITIAL_HEIGHT);
			anythingChanged = true;
		}
		
		// width
		if (containerGa.getWidth() < CONTROL_CENTER_INITIAL_WIDTH)
		{
			containerGa.setWidth(CONTROL_CENTER_INITIAL_WIDTH);
			anythingChanged = true;
		}
		
		final int containerWidth = containerGa.getWidth();
		
		for (final Shape shape : containerShape.getChildren())
		{
			final GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
			final IGaService gaService = Graphiti.getGaService();
			final IDimension size = gaService.calculateSize(graphicsAlgorithm);
			if (containerWidth != size.getWidth())
			{
				if (graphicsAlgorithm instanceof Polyline)
				{
					final Polyline polyline = (Polyline) graphicsAlgorithm;
					final Point secondPoint = polyline.getPoints().get(1);
					final Point newSecondPoint = gaService.createPoint(containerWidth, secondPoint.getY());
					polyline.getPoints().set(1, newSecondPoint);
					anythingChanged = true;
				}
				else
				{
					gaService.setWidth(graphicsAlgorithm, containerWidth);
					anythingChanged = true;
				}
			}
		}
		return anythingChanged;
	}
	
}
