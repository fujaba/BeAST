package de.uks.beast.editor.services.hadoop.create;

import model.HadoopMaster;
import model.ModelFactory;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateHadoopMasterFeature extends AbstractCreateFeature
{
	
	public CreateHadoopMasterFeature(final IFeatureProvider fp, final String name, final String description)
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
		final HadoopMaster hadoopMaster = ModelFactory.eINSTANCE.createHadoopMaster();
		final Server server = (Server) getBusinessObjectForPictogramElement(context.getTargetContainer());
		server.setService(hadoopMaster);
		addGraphicalRepresentation(context, hadoopMaster);
		getFeatureProvider().getDirectEditingInfo().setActive(false);
		
		return new Object[] { hadoopMaster };
	}
	
}
