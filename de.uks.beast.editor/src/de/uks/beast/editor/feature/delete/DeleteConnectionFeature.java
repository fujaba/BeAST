package de.uks.beast.editor.feature.delete;

import model.ControlCenter;
import model.HadoopMaster;
import model.HadoopSlave;
import model.Network;

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
		
		if (start instanceof HadoopMaster && end instanceof Network)
		{
			final HadoopMaster hm = (HadoopMaster) start;
			final Network network = (Network) end;
			
			if (hm.getNetwork().equals(network))
			{
				hm.setNetwork(null);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof Network && end instanceof HadoopMaster)
		{
			final HadoopMaster hm = (HadoopMaster) end;
			final Network network = (Network) start;
			
			if (network.getServices().contains(hm))
			{
				network.getServices().remove(hm);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof HadoopMaster && end instanceof HadoopSlave)
		{
			final HadoopMaster hm = (HadoopMaster) start;
			final HadoopSlave hs = (HadoopSlave) end;
			
			if (hm.getHadoopSlaves().contains(hs))
			{
				hm.getHadoopSlaves().remove(hs);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof HadoopSlave && end instanceof HadoopMaster)
		{
			final HadoopMaster hm = (HadoopMaster) end;
			final HadoopSlave hs = (HadoopSlave) start;
			
			if (hs.getHadoopMasters().contains(hm))
			{
				hs.getHadoopMasters().remove(hm);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof ControlCenter && end instanceof HadoopMaster)
		{
			final ControlCenter cc = (ControlCenter) start;
			final HadoopMaster hm = (HadoopMaster) end;
			
			if (cc.getMasterNodes().contains(hm))
			{
				cc.getMasterNodes().remove(hm);
			}
			
			setDoneChanges(true);
		}
		else if (start instanceof HadoopMaster && end instanceof ControlCenter)
		{
			final ControlCenter cc = (ControlCenter) end;
			final HadoopMaster hm = (HadoopMaster) start;
			
			if (cc.getMasterNodes().contains(hm))
			{
				cc.getMasterNodes().remove(hm);
			}
			
			setDoneChanges(true);
		}
		
		super.delete(context);
		
	}
	
}
