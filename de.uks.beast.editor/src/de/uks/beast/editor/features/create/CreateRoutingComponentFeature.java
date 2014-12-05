//package de.uks.beast.editor.features.create;
//
//import model.ModelFactory;
//import model.RoutingComponent;
//
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.features.context.ICreateContext;
//import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
//import org.eclipse.graphiti.mm.pictograms.Diagram;
//
//public class CreateRoutingComponentFeature extends AbstractCreateFeature
//{
//	
//	public CreateRoutingComponentFeature(final IFeatureProvider fp, final String type, final String description)
//	{
//		super(fp, type, description);
//	}
//	
//	
//	
//	@Override
//	public boolean canCreate(final ICreateContext context)
//	{
//		return context.getTargetContainer() instanceof Diagram;
//	}
//	
//	
//	
//	@Override
//	public Object[] create(final ICreateContext context)
//	{
//		final RoutingComponent routingComponent = ModelFactory.eINSTANCE.createRoutingComponent();
//		getDiagram().eResource().getContents().add(routingComponent);
//		routingComponent.setType("RoutingComponent");;
//		addGraphicalRepresentation(context, routingComponent);
//		getFeatureProvider().getDirectEditingInfo().setActive(true);
//		
//		return new Object[] { routingComponent };
//	}
//}
