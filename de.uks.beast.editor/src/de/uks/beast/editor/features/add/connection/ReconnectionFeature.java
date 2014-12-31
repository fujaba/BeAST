package de.uks.beast.editor.features.add.connection;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;

public class ReconnectionFeature extends DefaultReconnectionFeature
{
	
	public ReconnectionFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canReconnect(final IReconnectionContext context)
	{
		//do not allow to reconnect
		return false;
	}
	
}
