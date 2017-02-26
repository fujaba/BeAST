package de.uks.beast.editor.feature.delete;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import de.uks.beast.editor.util.NameCache;
import model.HadoopMaster;
import model.HadoopSlave;
import model.Service;

public class DeleteServiceFeature extends DefaultDeleteFeature
{
	private String						nameToDelete	= null;
	private Class<? extends EObject>	cacheClass		= null;
	
	
	
	public DeleteServiceFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canDelete(final IDeleteContext context)
	{
		final Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		if (object instanceof HadoopMaster)
		{
			final Service s = (Service) getBusinessObjectForPictogramElement(context.getPictogramElement());
			if (NameCache.isRegistered(HadoopMaster.class, s.getName()))
			{
				nameToDelete = s.getName();
				cacheClass = HadoopMaster.class;
				return true;
			}
			
		}
		else if (object instanceof HadoopSlave)
		{
			final Service s = (Service) getBusinessObjectForPictogramElement(context.getPictogramElement());
			if (NameCache.isRegistered(HadoopSlave.class, s.getName()))
			{
				nameToDelete = s.getName();
				cacheClass = HadoopSlave.class;
				return true;
			}
		}
		return super.canDelete(context);
	}
	
	
	
	@Override
	public void postDelete(final IDeleteContext context)
	{
		if (nameToDelete != null && cacheClass != null)
		{
			NameCache.remove(cacheClass, nameToDelete);
		}
		super.postDelete(context);
	}
	
}
