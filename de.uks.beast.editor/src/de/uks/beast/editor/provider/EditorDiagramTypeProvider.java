package de.uks.beast.editor.provider;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class EditorDiagramTypeProvider extends AbstractDiagramTypeProvider
{
	
	private IToolBehaviorProvider[]	toolBehaviorProviders;
	
	
	
	public EditorDiagramTypeProvider()
	{
		super();
		setFeatureProvider(new EditorFeatureProvider(this));
	}
	
	
	
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders()
	{
		if (toolBehaviorProviders == null)
		{
			toolBehaviorProviders = new IToolBehaviorProvider[] { new EditorToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
	
}
