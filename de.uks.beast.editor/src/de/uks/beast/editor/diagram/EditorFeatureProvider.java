package de.uks.beast.editor.diagram;

import model.Network;
import model.Rack;
import model.Room;
import model.Router;
import model.RoutingComponent;
import model.Server;
import model.Switch;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.uks.beast.editor.features.LayoutDomainObjectFeature;
import de.uks.beast.editor.features.add.AddConnectionFeature;
import de.uks.beast.editor.features.add.AddNetworkComponentFeature;
import de.uks.beast.editor.features.add.AddRackFeature;
import de.uks.beast.editor.features.add.AddRoomFeature;

import de.uks.beast.editor.features.add.AddRouterFeature;
import de.uks.beast.editor.features.add.AddRoutingComponentFeature;
import de.uks.beast.editor.features.add.AddServerFeature;
import de.uks.beast.editor.features.add.AddSwitchFeature;
import de.uks.beast.editor.features.create.CreateConnectionFeature;
import de.uks.beast.editor.features.create.CreateNetworkComponentFeature;
import de.uks.beast.editor.features.create.CreateRackFeature;
import de.uks.beast.editor.features.create.CreateRoomFeature;

import de.uks.beast.editor.features.create.CreateRoutingComponentFeature;
import de.uks.beast.editor.features.create.CreateServerFeature;
import de.uks.beast.editor.features.create.CreateSwitchFeature;
import de.uks.beast.editor.features.create.CreaterRouterFeature;

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
				new CreateRackFeature(this, "Serverrack", "Rack has many Server"),
				new CreateRoutingComponentFeature(this, "RoutingComponent", "this is a routing component"),
				new CreateSwitchFeature(this, "Switch", "This is a switch"),
				new CreateNetworkComponentFeature(this, "Network", "This is a network"),
				new CreateRoomFeature(this, "Serverroom", "This is a Serverroom"),
				new CreaterRouterFeature(this, "Router", "This is a router") };
		
		return features;
	}
	
	
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures()
	{
		return new ICreateConnectionFeature[] { new CreateConnectionFeature(this, "Connection", "Create connection") };
	}
	
	
	
	@Override
	public IAddFeature getAddFeature(final IAddContext context)
	{
		//features
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
		else if (context.getNewObject() instanceof Network)
		{
			return new AddNetworkComponentFeature(this);
		}
		else if (context.getNewObject() instanceof Router)
		{
			return new AddRouterFeature(this);
		}

		else if (context instanceof IAddConnectionContext)
		{
			return new AddRoomFeature(this);
		}
		else if (context instanceof IAddConnectionContext)
		{

			return new AddConnectionFeature(this);
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
		final Object object = getBusinessObjectForPictogramElement(pe);
//		if (object instanceof Server)
//		{
//			return new DirectEditServerFeature(this);
//		}
		
		return super.getDirectEditingFeature(context);
	}
	
}
