package de.uks.beast.editor.provider;

import model.Group;
import model.Network;
import model.Router;
import model.Server;
import model.Service;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.uks.beast.editor.feature.add.AddGroupFeature;
import de.uks.beast.editor.feature.add.AddNetworkFeature;
import de.uks.beast.editor.feature.add.AddRouterFeature;
import de.uks.beast.editor.feature.add.AddServerFeature;
import de.uks.beast.editor.feature.add.connection.AddConnectionFeature;
import de.uks.beast.editor.feature.add.connection.ReconnectionFeature;
import de.uks.beast.editor.feature.copy.CopyNetworkFeature;
import de.uks.beast.editor.feature.copy.CopyRouterFeature;
import de.uks.beast.editor.feature.copy.CopyServerFeature;
import de.uks.beast.editor.feature.edit.DirectEditGroupFeature;
import de.uks.beast.editor.feature.edit.DirectEditNetworkFeature;
import de.uks.beast.editor.feature.edit.DirectEditRouterFeature;
import de.uks.beast.editor.feature.edit.DirectEditServerFeature;
import de.uks.beast.editor.feature.layout.LayoutGroupObjectFeature;
import de.uks.beast.editor.feature.layout.LayoutNetworkObjectFeature;
import de.uks.beast.editor.feature.layout.LayoutRouterObjectFeature;
import de.uks.beast.editor.feature.layout.LayoutServerObjectFeature;
import de.uks.beast.editor.feature.paste.UniversalPasteFeature;
import de.uks.beast.editor.feature.update.UpdateGroupObjectFeature;
import de.uks.beast.editor.feature.update.UpdateNetworkObjectFeature;
import de.uks.beast.editor.feature.update.UpdateRouterObjectFeature;
import de.uks.beast.editor.feature.update.UpdateServerObjectFeature;
import de.uks.beast.editor.service.services.apache2.add.AddApache2Feature;
import de.uks.beast.editor.service.services.cassandra.add.AddCassandraFeature;
import de.uks.beast.editor.service.services.hadoop.add.AddHadoopMasterFeature;
import de.uks.beast.editor.service.services.hadoop.add.AddHadoopSlaveFeature;
import de.uks.beast.editor.service.services.jenkins.add.AddJenkinsFeature;
import de.uks.beast.editor.service.services.mediawiki.add.AddMediaWikiFeature;
import de.uks.beast.editor.service.services.mongodb.add.AddMongoDBFeature;
import de.uks.beast.editor.service.services.mysql.add.AddMySqlFeature;
import de.uks.beast.editor.service.services.relation.add.AddServiceRelation;
import de.uks.beast.editor.service.services.tomcat.add.AddTomcatFeature;
import de.uks.beast.editor.service.services.ubuntu.add.AddUbuntuFeature;
import de.uks.beast.editor.service.services.wordpress.add.AddWordPressFeature;
import de.uks.beast.editor.util.Strings;

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
		else if (context.getNewObject() instanceof Group)
		{
			return new AddGroupFeature(this);
		}
		else if (context.getNewObject() instanceof Network)
		{
			return new AddNetworkFeature(this);
		}
		else if (context.getNewObject() instanceof Router)
		{
			return new AddRouterFeature(this);
		}
		
		//connections
		else if (context instanceof IAddConnectionContext)
		{
			final IAddConnectionContext cc = (IAddConnectionContext) context;
			
			if ((getBusinessObjectForPictogramElement(cc.getSourceAnchor().getParent()) instanceof Service)
					&& (getBusinessObjectForPictogramElement(cc.getTargetAnchor().getParent()) instanceof Service))
			{
				return new AddServiceRelation(this);
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
			
			if (service.getName().equals(Strings.HADOOP_MASTER.text()))
			{
				return new AddHadoopMasterFeature(this);
			}
			else if (service.getName().equals(Strings.HADOOP_SLAVE.text()))
			{
				return new AddHadoopSlaveFeature(this);
			}
			else if (service.getName().equals(Strings.CASSANDRA.text()))
			{
				return new AddCassandraFeature(this);
			}
			else if (service.getName().equals(Strings.MONGO_DB.text()))
			{
				return new AddMongoDBFeature(this);
			}
			else if (service.getName().equals(Strings.MYSQL.text()))
			{
				return new AddMySqlFeature(this);
			}
			else if (service.getName().equals(Strings.WORDPRESS.text()))
			{
				return new AddWordPressFeature(this);
			}
			else if (service.getName().equals(Strings.UBUNTU.text()))
			{
				return new AddUbuntuFeature(this);
			}
			else if (service.getName().equals(Strings.APACHE2.text()))
			{
				return new AddApache2Feature(this);
			}
			else if (service.getName().equals(Strings.JENKINS.text()))
			{
				return new AddJenkinsFeature(this);
			}
			else if (service.getName().equals(Strings.MEDIAWIKI.text()))
			{
				return new AddMediaWikiFeature(this);
			}
			else if (service.getName().equals(Strings.TOMCAT.text()))
			{
				return new AddTomcatFeature(this);
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
		else if (bo instanceof Group)
		{
			return new LayoutGroupObjectFeature(this);
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
		else if (object instanceof Group)
		{
			return new DirectEditGroupFeature(this);
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
			
			if (bo instanceof Group)
			{
				return new UpdateGroupObjectFeature(this);
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
	
	
	
	@Override
	public ICopyFeature getCopyFeature(final ICopyContext context)
	{
		final PictogramElement[] pictogramElements = context.getPictogramElements();
		if (getBusinessObjectForPictogramElement(pictogramElements[0]) instanceof Router)
		{
			return new CopyRouterFeature(this);
		}
		else if (getBusinessObjectForPictogramElement(pictogramElements[0]) instanceof Server)
		{
			return new CopyServerFeature(this);
		}
		else if (getBusinessObjectForPictogramElement(pictogramElements[0]) instanceof Network)
		{
			return new CopyNetworkFeature(this);
		}
		
		return super.getCopyFeature(context);
	}
	
	
	
	@Override
	public IPasteFeature getPasteFeature(final IPasteContext context)
	{
		return new UniversalPasteFeature(this);
	}
}
