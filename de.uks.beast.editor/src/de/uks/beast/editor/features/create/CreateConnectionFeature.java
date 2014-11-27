package de.uks.beast.editor.features.create;

import java.util.Iterator;

import model.Network;
import model.RoutingComponent;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateConnectionFeature extends AbstractCreateConnectionFeature {

	public CreateConnectionFeature(final IFeatureProvider fp,
			final String name, final String description) {
		super(fp, name, description);

	}

	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		// return true if both anchors belong to an EClass
		// and those EClasses are not identical
		final Object source = getBusinessObjectForPictogramElement(context
				.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context
				.getTargetPictogramElement());

		if (source instanceof Server && target instanceof RoutingComponent) {
			return true;
		} else if (target instanceof Server
				&& source instanceof RoutingComponent) {
			return true;
		} else if (source instanceof Server && target instanceof Network) {
			return true;
		} else if (target instanceof Server && source instanceof Network) {
			return true;
		}

		return false;
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		Connection newConnection = null;

		final Object source = getBusinessObjectForPictogramElement(context
				.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context
				.getTargetPictogramElement());

		if (source != null && target != null) {
			final AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(null);

			if (source instanceof Server && target instanceof RoutingComponent) 
			{
				((Server) source).getRoutingComponents().add((RoutingComponent) target);					
			} 
			else if (source instanceof RoutingComponent && target instanceof Server) 
			{
				((RoutingComponent) source).getServer().add((Server) target);
			}
			else if (source instanceof RoutingComponent && target instanceof Network) 
			{
				((RoutingComponent) source).setNetwork((Network) target);
			}
			else if (source instanceof Network && target instanceof RoutingComponent) 
			{
				((Network) source).setRouter((RoutingComponent) target);
			}
			

			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		}

		return newConnection;
	}

	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		final Object source = getBusinessObjectForPictogramElement(context
				.getSourcePictogramElement());
		if (source instanceof Server || source instanceof RoutingComponent || source instanceof Network) {
			return true;
		}

		return false;
	}

}
