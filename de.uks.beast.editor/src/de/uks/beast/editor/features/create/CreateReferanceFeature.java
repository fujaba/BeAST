package de.uks.beast.editor.features.create;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateReferanceFeature extends AbstractCreateConnectionFeature
{
	
	public CreateReferanceFeature(final IFeatureProvider fp)
	{
		super(fp, "Reference", "Create Reference");
		
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context)
	{
		
//		// return true if both anchors belong to an EClass
//		// and those EClasses are not identical
//		final EClass source = getEClass(context.getSourceAnchor());
//		final EClass target = getEClass(context.getTargetAnchor());
//		
//		if (source != null && target != null && source != target)
//		{
//			return true;
//		}
		return false;
	}
	
	
	
	@Override
	public Connection create(final ICreateConnectionContext context)
	{
		Connection newConnection = null;
		
//		// get EClasses which should be connected
//		final EClass source = getEClass(context.getSourceAnchor());
//		final EClass target = getEClass(context.getTargetAnchor());
//		
//		if (source != null && target != null)
//		{
//			// create new business object 
//			final EReference eReference = createEReference(source, target);
//			// add connection for business object
//			final AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
//			addContext.setNewObject(eReference);
//			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
//		}
		
		return newConnection;
	}
	
	
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context)
	{
//		// return true if start anchor belongs to a EClass
//		if (getEClass(context.getSourceAnchor()) != null)
//		{
//			return true;
//		}
		return false;
	}
	
	
	
	/**
	* Returns the EClass belonging to the anchor, or null if not available.
	*/
//	private EClass getEClass(final Anchor anchor)
//	{
//		if (anchor != null)
//		{
//			final Object object = getBusinessObjectForPictogramElement(anchor.getParent());
//			if (object instanceof EClass)
//			{
//				return (EClass) object;
//			}
//			
//		}
//		return null;
//	}
//	
//	
//	
//	/**
//	* Creates a EReference between two EClasses.
//	*/
//	private EReference createEReference(final EClass source, final EClass target)
//	{
//		final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
//		eReference.setName("new EReference");
//		eReference.setEType(target);
//		eReference.setLowerBound(0);
//		eReference.setUpperBound(1);
//		source.getEStructuralFeatures().add(eReference);
//		
//		return eReference;
//	}
	
}
