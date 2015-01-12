package de.uks.beast.editor.features.add;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public interface AbstractShapeManager
{
	public Shape createShape(final IPeCreateService peCreateService, final ContainerShape containerShape);
	
	
	
	public Text createTextShape(final IGaService gaService, final GraphicsAlgorithmContainer gaContainer, final int x,
			final int y, final int width, final int height, final String content);
	
}