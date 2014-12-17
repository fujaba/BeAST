package de.uks.beast.editor.features.update;

import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class UpdateServerObjectFeature extends AbstractUpdateFeature implements
		IUpdateFeature {

	public UpdateServerObjectFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(final IUpdateContext context) {
        // return true, if linked business object is a EClass
        final Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
       
        return (bo instanceof Server);
    }
 
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        final PictogramElement pictogramElement = context.getPictogramElement();
        
        if (pictogramElement  instanceof ContainerShape) {
            final ContainerShape cs = (ContainerShape) pictogramElement;
            
            for (final Shape shape : cs.getChildren()) {
            	if (shape.getGraphicsAlgorithm() instanceof Text) {
                    final Text text = (Text) shape.getGraphicsAlgorithm();
                    pictogramName = text.getValue();
                }
            }
        }
 
        // retrieve name from business model
        String businessName = null;
        final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        
        if (bo instanceof Server) {
            final Server server = (Server) bo;
            businessName = server.getName();
        }
 
        // update needed, if names are different
        final boolean updateNameNeeded =
            ((pictogramName == null && businessName != null) || 
                (pictogramName != null && !pictogramName.equals(businessName)));
      
        if (updateNameNeeded) {
            return Reason.createTrueReason("Name is out of date");
        } else {
            return Reason.createFalseReason();
        }
    }
 
	@Override
	public boolean update(final IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        final PictogramElement pictogramElement = context.getPictogramElement();
        final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       
        if (bo instanceof Server) {
            final Server server = (Server) bo;
            businessName = server.getName();
        }
 
        // Set name in pictogram model
        if (pictogramElement instanceof ContainerShape) {
            final ContainerShape cs = (ContainerShape) pictogramElement;
            
            for (final Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    final Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    
                    return true;
                }
            }
        }
 
        return false;
    }

}
