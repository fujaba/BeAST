package de.uks.beast.editor.services.hadoop.create;

import model.HadoopSlave;
import model.ModelFactory;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateHadoopSlaveFeature extends AbstractCreateFeature
{
	
	public CreateHadoopSlaveFeature(final IFeatureProvider fp, final String name, final String description)
	{
		super(fp, name, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Server)
		{
			final Server server = (Server) getBusinessObjectForPictogramElement(context.getTargetContainer());
			
			if (server.getService() == null)
			{
				return true;
			}
			
		}
		return false;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final HadoopSlave hadoopSlave = ModelFactory.eINSTANCE.createHadoopSlave();
		final Server server = (Server) getBusinessObjectForPictogramElement(context.getTargetContainer());
		server.setService(hadoopSlave);
		addGraphicalRepresentation(context, hadoopSlave);
		getFeatureProvider().getDirectEditingInfo().setActive(false);
		
		return new Object[] { hadoopSlave };
	}
	
}
