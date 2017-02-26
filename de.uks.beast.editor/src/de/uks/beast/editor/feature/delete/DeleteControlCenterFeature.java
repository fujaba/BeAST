package de.uks.beast.editor.feature.delete;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import de.uks.beast.editor.util.NameCache;
import model.ControlCenter;

public class DeleteControlCenterFeature extends DefaultDeleteFeature
{
	
	public DeleteControlCenterFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canDelete(final IDeleteContext context)
	{
		final Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		if (object instanceof ControlCenter)
		{
			final ControlCenter cc = (ControlCenter) getBusinessObjectForPictogramElement(context.getPictogramElement());
			if (NameCache.isRegistered(ControlCenter.class, cc.getName()))
			{
				return true;
			}
			
		}
		return super.canDelete(context);
	}
	
	
	
	@Override
	public void delete(final IDeleteContext context)
	{
		final ControlCenter cc = (ControlCenter) getBusinessObjectForPictogramElement(context.getPictogramElement());
		NameCache.remove(cc.getClass(), cc.getName());
		
		super.delete(context);
	}
	
}
