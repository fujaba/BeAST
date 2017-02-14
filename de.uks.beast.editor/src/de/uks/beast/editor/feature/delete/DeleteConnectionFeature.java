package de.uks.beast.editor.feature.delete;

import model.Network;
import model.Router;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class DeleteConnectionFeature extends DefaultDeleteFeature
{
	
	public DeleteConnectionFeature(IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public void delete(IDeleteContext context)
	{
		setDoneChanges(false);
		
		final Connection connection = (Connection) context.getPictogramElement();
		final Object start = getBusinessObjectForPictogramElement(connection.getStart().getParent());
		final Object end = getBusinessObjectForPictogramElement(connection.getEnd().getParent());
		
		if (start instanceof Router && end instanceof Network)
		{
			final Router router = (Router) start;
			final Network network = (Network) end;
			
			if (router.getNetwork().contains(network))
			{
				router.getNetwork().remove(network);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof Network && end instanceof Router)
		{
			final Router router = (Router) end;
			final Network network = (Network) start;
			
			if (network.getRouter().contains(router))
			{
				network.getRouter().remove(router);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof Service && end instanceof Service)
		{
			final Service startService = (Service) start;
			final Service endService = (Service) end;
			
			if (startService.getServices().contains(endService))
			{
				startService.getServices().remove(endService);
			}
			if (endService.getServices().contains(startService))
			{
				endService.getServices().remove(startService);
			}
			
			setDoneChanges(true);
		}
		
		super.delete(context);
		
	}
	
}
