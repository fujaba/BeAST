package de.uks.beast.editor.diagram;

import model.Rack;
import model.RoutingComponent;
import model.Server;
import model.Switch;

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

import de.uks.beast.editor.features.DirectEditServerFeature;
import de.uks.beast.editor.features.LayoutDomainObjectFeature;
import de.uks.beast.editor.features.add.AddRackFeature;
import de.uks.beast.editor.features.add.AddRoutingComponentFeature;
import de.uks.beast.editor.features.add.AddServerFeature;
import de.uks.beast.editor.features.add.AddSwitchFeature;
import de.uks.beast.editor.features.create.CreateRackFeature;
import de.uks.beast.editor.features.create.CreateRoutingComponentFeature;
import de.uks.beast.editor.features.create.CreateServerFeature;
import de.uks.beast.editor.features.create.CreateSwitchFeature;

public class EditorFeatureProvider extends DefaultFeatureProvider
{
	
	public EditorFeatureProvider(final IDiagramTypeProvider dtp)
	{
		super(dtp);
	}
	
	
	
	@Override
	public ICreateFeature[] getCreateFeatures()
	{
		final ICreateFeature[] features = { new CreateServerFeature(this, "Server", "Server representing hardware"),
				new CreateRackFeature(this, "Rack", "Rack has many Server"),
				new CreateRoutingComponentFeature(this, "RoutingComponent", "this is a routing component"),
				new CreateSwitchFeature(this, "Switch", "This is s switch") };
		
		return features;
	}
	
	
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures()
	{
		return new ICreateConnectionFeature[] {};
	}
	
	
	
	@Override
	public IAddFeature getAddFeature(final IAddContext context)
	{
		
		if (context.getNewObject() instanceof Server)
		{
			return new AddServerFeature(this);
		}
		else if (context.getNewObject() instanceof Rack)
		{
			return new AddRackFeature(this);
		}
		else if (context.getNewObject() instanceof RoutingComponent)
		{
			return new AddRoutingComponentFeature(this);
		}
		else if (context.getNewObject() instanceof Switch)
		{
			return new AddSwitchFeature(this);
		}
		
		return super.getAddFeature(context);
	}
	
	
	
	@Override
	public ILayoutFeature getLayoutFeature(final ILayoutContext context)
	{
		if (context.getPictogramElement() instanceof ContainerShape)
		{
			return new LayoutDomainObjectFeature(this);
		}
		
		return super.getLayoutFeature(context);
	}
	
	
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof Server)
		{
			return new DirectEditServerFeature(this);
		}
		
		return super.getDirectEditingFeature(context);
	}
	
}
