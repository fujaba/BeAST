package de.uks.beast.editor.services.hadoop.add;

import model.HadoopMaster;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import de.uks.beast.editor.util.Constants;

public class AddHadoopMasterFeature extends AbstractAddShapeFeature
{
	
	public AddHadoopMasterFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context.getNewObject() instanceof HadoopMaster)
		{
			if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Server)
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
		final ContainerShape targetDiagram = (ContainerShape) context.getTargetContainer();
		
		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		
		final IGaService gaService = Graphiti.getGaService();
		
		final Image image = gaService.createImage(containerShape, Constants.HADOOP_MASTER_IMAGE_PATH.getImageID());
		gaService.setLocationAndSize(image, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		// if added Class has no resource we add it to the resource
		// of the diagram
		// in a real scenario the business model would have its own resource
		if (hadoopMaster.eResource() == null)
		{
			getDiagram().eResource().getContents().add(hadoopMaster);
		}
		// create link and wire it
		link(containerShape, hadoopMaster);
		
		// add a chopbox anchor to the shape 
		final ChopboxAnchor anchor = peCreateService.createChopboxAnchor(containerShape);
		link(anchor, containerShape);
		
		// call the layout feature
		layoutPictogramElement(containerShape);
		
		return containerShape;
	}
	
}
