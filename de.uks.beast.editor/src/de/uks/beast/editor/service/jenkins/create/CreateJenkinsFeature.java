package de.uks.beast.editor.service.jenkins.create;

import model.ModelFactory;
import model.Server;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import de.uks.beast.editor.util.Strings;

public class CreateJenkinsFeature extends AbstractCreateFeature
{
	
	public CreateJenkinsFeature(final IFeatureProvider fp, final String name, final String description)
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
		final Service service = ModelFactory.eINSTANCE.createJenkins();
		service.setName(Strings.JENKINS.text());
		
		final Server server = (Server) getBusinessObjectForPictogramElement(context.getTargetContainer());
		server.setService(service);
		
		addGraphicalRepresentation(context, service);
		getFeatureProvider().getDirectEditingInfo().setActive(false);
		
		return new Object[] { service };
	}
	
}