package de.uks.beast.editor.diagram;

import model.Server;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.uks.beast.editor.features.AddServerFeature;
import de.uks.beast.editor.features.CreateServerFeature;
import de.uks.beast.editor.features.DirectEditServerFeature;
import de.uks.beast.editor.features.LayoutDomainObjectFeature;

public class EditorFeatureProvider extends DefaultFeatureProvider
{
	
	public EditorFeatureProvider(IDiagramTypeProvider dtp)
	{
		super(dtp);
	}
	
	
	
	@Override
	public ICreateFeature[] getCreateFeatures()
	{
		return new ICreateFeature[] { new CreateServerFeature(this, "Server", "Server representing hardware") };
	}
	
	
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures()
	{
		return new ICreateConnectionFeature[] {};
	}
	
	
	
	@Override
	public IAddFeature getAddFeature(IAddContext context)
	{
		
		if (context.getNewObject() instanceof Server)
		{
			return new AddServerFeature(this);
		}
		
		return super.getAddFeature(context);
	}
	
	
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context)
	{
		if (context.getPictogramElement() instanceof ContainerShape)
		{
			return new LayoutDomainObjectFeature(this);
		}
		
		return super.getLayoutFeature(context);
	}
	
	
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context)
	{
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof Server)
		{
			return new DirectEditServerFeature(this);
		}
		return super.getDirectEditingFeature(context);
	}
	
}
