package de.uks.beast.editor.features.add;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class AddReferanceFeature extends AbstractAddFeature
{
	private static final IColorConstant	E_REFERENCE_FOREGROUND	= new ColorConstant(98, 131, 167);
	
	
	
	public AddReferanceFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		// return true if given business object is an EReference
		// note, that the context must be an instance of IAddConnectionContext
		if (context instanceof IAddConnectionContext && context.getNewObject() instanceof EReference)
		{
			return true;
		}
		return false;
	}
	
	
	
	@Override
	public PictogramElement add(final IAddContext context)
	{
		final IAddConnectionContext addConContext = (IAddConnectionContext) context;
		final EReference addedEReference = (EReference) context.getNewObject();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// CONNECTION WITH POLYLINE
		final Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());
		
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(2);
		polyline.setForeground(manageColor(E_REFERENCE_FOREGROUND));
		
		// create link and wire it
		link(connection, addedEReference);
		
		return connection;
	}
	
}
