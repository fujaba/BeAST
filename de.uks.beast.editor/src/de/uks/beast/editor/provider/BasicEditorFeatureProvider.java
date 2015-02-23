package de.uks.beast.editor.provider;

import model.HadoopMaster;
import model.HadoopSlave;
import model.Network;
import model.Rack;
import model.Room;
import model.Router;
import model.Server;
import model.Service;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.uks.beast.editor.features.add.AddNetworkFeature;
import de.uks.beast.editor.features.add.AddRackFeature;
import de.uks.beast.editor.features.add.AddRoomFeature;
import de.uks.beast.editor.features.add.AddRouterFeature;
import de.uks.beast.editor.features.add.AddServerFeature;
import de.uks.beast.editor.features.add.connection.AddConnectionFeature;
import de.uks.beast.editor.features.add.connection.ReconnectionFeature;
import de.uks.beast.editor.features.edit.DirectEditNetworkFeature;
import de.uks.beast.editor.features.edit.DirectEditRackFeature;
import de.uks.beast.editor.features.edit.DirectEditRoomFeature;
import de.uks.beast.editor.features.edit.DirectEditRouterFeature;
import de.uks.beast.editor.features.edit.DirectEditServerFeature;
import de.uks.beast.editor.features.layout.LayoutNetworkObjectFeature;
import de.uks.beast.editor.features.layout.LayoutRackObjectFeature;
import de.uks.beast.editor.features.layout.LayoutRoomObjectFeature;
import de.uks.beast.editor.features.layout.LayoutRouterObjectFeature;
import de.uks.beast.editor.features.layout.LayoutServerObjectFeature;
import de.uks.beast.editor.features.update.UpdateNetworkObjectFeature;
import de.uks.beast.editor.features.update.UpdateRackObjectFeature;
import de.uks.beast.editor.features.update.UpdateRoomObjectFeature;
import de.uks.beast.editor.features.update.UpdateRouterObjectFeature;
import de.uks.beast.editor.features.update.UpdateServerObjectFeature;
import de.uks.beast.editor.services.cassandra.add.AddCassandraFeature;
import de.uks.beast.editor.services.hadoop.add.AddHadoopConnection;
import de.uks.beast.editor.services.hadoop.add.AddHadoopMasterFeature;
import de.uks.beast.editor.services.hadoop.add.AddHadoopSlaveFeature;
import de.uks.beast.editor.services.mongodb.add.AddMongoDBFeature;
import de.uks.beast.editor.util.StringConstants;

public class BasicEditorFeatureProvider extends DefaultFeatureProvider
{
	
	public BasicEditorFeatureProvider(final IDiagramTypeProvider dtp)
	{
		super(dtp);
	}
	
	
	
	@Override
	public IReconnectionFeature getReconnectionFeature(final IReconnectionContext context)
	{
		return new ReconnectionFeature(this);
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
		else if (context.getNewObject() instanceof Network)
		{
			return new AddNetworkFeature(this);
		}
		else if (context.getNewObject() instanceof Router)
		{
			return new AddRouterFeature(this);
		}
		else if (context.getNewObject() instanceof Room)
		{
			return new AddRoomFeature(this);
		}
		
		//connections
		else if (context instanceof IAddConnectionContext)
		{
			final IAddConnectionContext cc = (IAddConnectionContext) context;
			
			if ((getBusinessObjectForPictogramElement(cc.getSourceAnchor().getParent()) instanceof HadoopMaster)
					&& (getBusinessObjectForPictogramElement(cc.getTargetAnchor().getParent()) instanceof HadoopSlave))
			{
				
				return new AddHadoopConnection(this);
			}
			else
			{
				return new AddConnectionFeature(this);
			}
		}
		
		//services
		else if (context.getNewObject() instanceof Service)
		{
			final Service service = (Service) context.getNewObject();
			
			if (service.getType().equals(StringConstants.HADOOP_MASTER.text()))
			{
				return new AddHadoopMasterFeature(this);
			}
			else if (service.getType().equals(StringConstants.HADOOP_SLAVE.text()))
			{
				return new AddHadoopSlaveFeature(this);
			}
			else if (service.getType().equals(StringConstants.CASSANDRA.text()))
			{
				return new AddCassandraFeature(this);
			}
			else if (service.getType().equals(StringConstants.MONGO_DB.text()))
			{
				return new AddMongoDBFeature(this);
			}
			
		}
		
		return super.getAddFeature(context);
	}
	
	
	
	@Override
	public ILayoutFeature getLayoutFeature(final ILayoutContext context)
	{
		final PictogramElement pictogramElement = context.getPictogramElement();
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Server)
		{
			return new LayoutServerObjectFeature(this);
		}
		else if (bo instanceof Rack)
		{
			return new LayoutRackObjectFeature(this);
		}
		else if (bo instanceof Room)
		{
			return new LayoutRoomObjectFeature(this);
		}
		else if (bo instanceof Network)
		{
			return new LayoutNetworkObjectFeature(this);
		}
		else if (bo instanceof Router)
		{
			return new LayoutRouterObjectFeature(this);
		}
		
		return super.getLayoutFeature(context);
	}
	
	
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Object object = getBusinessObjectForPictogramElement(pe);
		
		if (object instanceof Server)
		{
			return new DirectEditServerFeature(this);
		}
		else if (object instanceof Room)
		{
			return new DirectEditRoomFeature(this);
		}
		else if (object instanceof Rack)
		{
			return new DirectEditRackFeature(this);
		}
		else if (object instanceof Router)
		{
			return new DirectEditRouterFeature(this);
		}
		else if (object instanceof Network)
		{
			return new DirectEditNetworkFeature(this);
		}
		
		return super.getDirectEditingFeature(context);
	}
	
	
	
	@Override
	public IUpdateFeature getUpdateFeature(final IUpdateContext context)
	{
		final PictogramElement pictogramElement = context.getPictogramElement();
		
		if (pictogramElement instanceof ContainerShape)
		{
			final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			
			if (bo instanceof Room)
			{
				return new UpdateRoomObjectFeature(this);
			}
			else if (bo instanceof Rack)
			{
				return new UpdateRackObjectFeature(this);
			}
			else if (bo instanceof Server)
			{
				return new UpdateServerObjectFeature(this);
			}
			else if (bo instanceof Network)
			{
				return new UpdateNetworkObjectFeature(this);
			}
			else if (bo instanceof Router)
			{
				return new UpdateRouterObjectFeature(this);
			}
		}
		return super.getUpdateFeature(context);
	}
	
}
