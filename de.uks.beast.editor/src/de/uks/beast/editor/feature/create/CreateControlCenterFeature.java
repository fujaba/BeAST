package de.uks.beast.editor.feature.create;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.editor.util.NameCache;
import de.uks.beast.editor.util.NameCache.NameCounter;
import model.ControlCenter;
import model.ModelFactory;

public class CreateControlCenterFeature extends AbstractCreateFeature
{
	
	public CreateControlCenterFeature(final IFeatureProvider fp, final String name, final String description)
	{
		super(fp, name, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		if (context.getTargetContainer() instanceof Diagram)
		{
			for (EObject eo : getDiagram().eResource().getContents())
			{
				if (eo instanceof ControlCenter)
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final ControlCenter cc = ModelFactory.eINSTANCE.createControlCenter();
		String newDefaultName = cc.getName() + NameCache.DELIMITER + NameCounter.CONTROL_CENTER.getAvailableCounter();
		while (NameCache.isRegistered(ControlCenter.class, newDefaultName))
		{
			newDefaultName = cc.getName() + NameCache.DELIMITER + NameCounter.CONTROL_CENTER.getAvailableCounter();
		}
		NameCache.add(ControlCenter.class, newDefaultName);
		
		getDiagram().eResource().getContents().add(cc);
		addGraphicalRepresentation(context, cc);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { cc };
	}
	
}
