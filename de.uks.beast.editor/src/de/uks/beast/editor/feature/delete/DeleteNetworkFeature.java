package de.uks.beast.editor.feature.delete;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import de.uks.beast.editor.util.NameCache;
import model.Network;

public class DeleteNetworkFeature extends DefaultDeleteFeature
{
	private String nameToDelete = null;
	
	
	
	public DeleteNetworkFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canDelete(IDeleteContext context)
	{
		final Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		if (object instanceof Network)
		{
			final Network network = (Network) getBusinessObjectForPictogramElement(context.getPictogramElement());
			if (NameCache.isRegistered(Network.class, network.getName()))
			{
				nameToDelete = network.getName();
				return true;
			}
			
		}
		return super.canDelete(context);
	}
	
	
	
	@Override
	public void postDelete(IDeleteContext context)
	{
		if (nameToDelete != null)
		{
			NameCache.remove(Network.class, nameToDelete);
		}
		super.postDelete(context);
	}
	
}
