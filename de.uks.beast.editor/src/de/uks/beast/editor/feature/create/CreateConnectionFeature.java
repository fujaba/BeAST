package de.uks.beast.editor.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

import model.ControlCenter;
import model.HadoopMaster;
import model.HadoopSlave;
import model.Network;
import model.Service;

public class CreateConnectionFeature extends AbstractCreateConnectionFeature
{
	
	public CreateConnectionFeature(final IFeatureProvider fp, final String name, final String description)
	{
		super(fp, name, description);
		
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context)
	{
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source instanceof HadoopMaster && target instanceof Network)
		{
			final HadoopMaster hadoopMaster = (HadoopMaster) source;
			if (hadoopMaster.getNetwork() == null)
			{
				return true;
			}
			
		}
		else if (target instanceof HadoopMaster && source instanceof Network)
		{
			final HadoopMaster hadoopMaster = (HadoopMaster) target;
			final Network network = (Network) source;
			if (!network.getServices().contains(hadoopMaster))
			{
				return true;
			}
			
		}
		else if (source instanceof ControlCenter && target instanceof HadoopMaster)
		{
			final ControlCenter controlCenter = (ControlCenter) source;
			final HadoopMaster hadoopMaster = (HadoopMaster) target;
			if (!controlCenter.getMasterNodes().contains(hadoopMaster))
			{
				return true;
			}
		}
		else if (source instanceof HadoopMaster && target instanceof ControlCenter)
		{
			final ControlCenter controlCenter = (ControlCenter) target;
			final HadoopMaster hadoopMaster = (HadoopMaster) source;
			if (!controlCenter.getMasterNodes().contains(hadoopMaster))
			{
				return true;
			}
		}
		else if (source instanceof HadoopMaster && target instanceof HadoopSlave)
		{
			final HadoopMaster hm = (HadoopMaster) source;
			final HadoopSlave hs = (HadoopSlave) target;
			
			if (!hm.getHadoopSlaves().contains(hs))
			{
				return true;
			}
		}
		else if (target instanceof HadoopMaster && source instanceof HadoopSlave)
		{
			final HadoopSlave hs = (HadoopSlave) source;
			final HadoopMaster hm = (HadoopMaster) target;
			
			if (!hs.getHadoopMasters().contains(hm))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	
	@Override
	public Connection create(final ICreateConnectionContext context)
	{
		Connection newConnection = null;
		
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source != null && target != null)
		{
			final AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),
					context.getTargetAnchor());
			addContext.setNewObject(null);
			
			if (source instanceof HadoopMaster && target instanceof Network)
			{
				((HadoopMaster) source).setNetwork((Network) target);
			}
			else if (source instanceof Network && target instanceof HadoopMaster)
			{
				((Network) source).getServices().add((HadoopMaster) target);
			}
			else if (source instanceof ControlCenter && target instanceof HadoopMaster)
			{
				((ControlCenter) source).getMasterNodes().add((HadoopMaster) target);
			}
			else if (source instanceof HadoopMaster && target instanceof ControlCenter)
			{
				((ControlCenter) target).getMasterNodes().add((HadoopMaster) source);
			}
			else if (source instanceof HadoopMaster && target instanceof HadoopSlave)
			{
				((HadoopMaster) source).getHadoopSlaves().add((HadoopSlave) target);
			}
			else if (source instanceof HadoopSlave && target instanceof HadoopMaster)
			{
				((HadoopSlave) source).getHadoopMasters().add((HadoopMaster) target);
			}
			
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		}
		
		return newConnection;
	}
	
	
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context)
	{
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		if (source instanceof Network || source instanceof ControlCenter || source instanceof Service)
		{
			return true;
		}
		
		return false;
	}
	
}
