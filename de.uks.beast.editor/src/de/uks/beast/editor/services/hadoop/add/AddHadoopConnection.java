package de.uks.beast.editor.services.hadoop.add;

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

public class AddHadoopConnection extends AbstractAddFeature
{
	private static final IColorConstant	LINE_COLOR_HADOOP_CONNECTION	= new ColorConstant(0, 255, 0);
	
	
	
	public AddHadoopConnection(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canAdd(final IAddContext context)
	{
		if (context instanceof IAddConnectionContext)
		{
			return true;
		}
		return false;
	}
	
	
	
	@Override
	public PictogramElement add(final IAddContext context)
	{
		final IAddConnectionContext addConContext = (IAddConnectionContext) context;
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// CONNECTION WITH POLYLINE
		final Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());
		
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(2);
		polyline.setForeground(manageColor(LINE_COLOR_HADOOP_CONNECTION));
				
		return connection;
	}
	
}
