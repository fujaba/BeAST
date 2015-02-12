package de.uks.beast.editor.provider;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

import de.uks.beast.editor.services.hadoop.provider.HadoopFeatureProvider;

public class EditorDiagramTypeProvider extends AbstractDiagramTypeProvider
{
	
	private IToolBehaviorProvider[]	serviceFeatureProviders;
	private static EditorDiagramTypeProvider provider;
	
	public EditorDiagramTypeProvider()
	{
		super();
		provider = this;
		setFeatureProvider(new EditorFeatureProvider(this));
	}
	
	
	
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders()
	{
		if (serviceFeatureProviders == null)
		{
			serviceFeatureProviders = new IToolBehaviorProvider[] { new HadoopFeatureProvider(this) };
		}
		
		return serviceFeatureProviders;
	}
	
	public static Diagram getCurrentDiagram() {
		return provider.getDiagram();
	}
	
}
