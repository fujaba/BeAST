package de.uks.beast.editor.feature.create;

import model.HadoopMaster;
import model.ModelFactory;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.editor.util.NameCache;
import de.uks.beast.editor.util.NameCache.NameCounter;

public class CreateHadoopMasterFeature extends AbstractCreateFeature
{
	
	public CreateHadoopMasterFeature(final IFeatureProvider fp, final String type, final String description)
	{
		super(fp, type, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		return context.getTargetContainer() instanceof Diagram;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final Service service = ModelFactory.eINSTANCE.createHadoopMaster();
		final String newDefaultName = service.getName() + "Master" + NameCache.DELIMITER + NameCounter.HADOOP_MASTER.getAvailableCounter();
		NameCache.add(HadoopMaster.class, newDefaultName);
		service.setName(newDefaultName);
		
		if (context.getTargetContainer() instanceof Diagram)
		{
			getDiagram().eResource().getContents().add(service);
		}
		
		addGraphicalRepresentation(context, service);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { service };
		
	}
	
}
