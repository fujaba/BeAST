package de.uks.beast.editor.provider;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.uks.beast.editor.feature.add.AddControlCenterFeature;
import de.uks.beast.editor.feature.add.AddHadoopMasterFeature;
import de.uks.beast.editor.feature.add.AddHadoopSlaveFeature;
import de.uks.beast.editor.feature.add.AddNetworkFeature;
import de.uks.beast.editor.feature.add.connection.AddConnectionFeature;
import de.uks.beast.editor.feature.add.connection.ReconnectionFeature;
import de.uks.beast.editor.feature.copy.CopyNetworkFeature;
import de.uks.beast.editor.feature.copy.CopyServiceFeature;
import de.uks.beast.editor.feature.delete.DeleteConnectionFeature;
import de.uks.beast.editor.feature.delete.DeleteControlCenterFeature;
import de.uks.beast.editor.feature.delete.DeleteNetworkFeature;
import de.uks.beast.editor.feature.delete.DeleteServiceFeature;
import de.uks.beast.editor.feature.edit.DirectEditNetworkFeature;
import de.uks.beast.editor.feature.edit.DirectEditServiceFeature;
import de.uks.beast.editor.feature.layout.LayoutControlCenterObjectFeature;
import de.uks.beast.editor.feature.layout.LayoutNetworkObjectFeature;
import de.uks.beast.editor.feature.layout.LayoutServiceObjectFeature;
import de.uks.beast.editor.feature.paste.UniversalPasteFeature;
import de.uks.beast.editor.feature.update.UpdateNetworkObjectFeature;
import de.uks.beast.editor.feature.update.UpdateServiceObjectFeature;
import model.ControlCenter;
import model.Network;
import model.Service;
import model.impl.HadoopMasterImpl;
import model.impl.HadoopSlaveImpl;

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
		if (context.getNewObject() instanceof Network)
		{
			return new AddNetworkFeature(this);
		}
		
		else if (context instanceof IAddConnectionContext)
		{
			return new AddConnectionFeature(this);
		}
		
		else if (context.getNewObject() instanceof ControlCenter)
		{
			return new AddControlCenterFeature(this);
		}
		
		else if (context.getNewObject() instanceof Service)
		{
			final Service service = (Service) context.getNewObject();
			
			if (service.getClass().equals(HadoopMasterImpl.class))
			{
				return new AddHadoopMasterFeature(this);
			}
			else if (service.getClass().equals(HadoopSlaveImpl.class))
			{
				return new AddHadoopSlaveFeature(this);
			}
		}
		
		return super.getAddFeature(context);
	}
	
	
	
	@Override
	public ILayoutFeature getLayoutFeature(final ILayoutContext context)
	{
		final PictogramElement pictogramElement = context.getPictogramElement();
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Service)
		{
			return new LayoutServiceObjectFeature(this);
		}
		else if (bo instanceof Network)
		{
			return new LayoutNetworkObjectFeature(this);
		}
		else if (bo instanceof ControlCenter)
		{
			return new LayoutControlCenterObjectFeature(this);
		}
		
		return super.getLayoutFeature(context);
	}
	
	
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Object object = getBusinessObjectForPictogramElement(pe);
		
		if (object instanceof Service)
		{
			return new DirectEditServiceFeature(this);
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
			
			if (bo instanceof Service)
			{
				return new UpdateServiceObjectFeature(this);
			}
			else if (bo instanceof Network)
			{
				return new UpdateNetworkObjectFeature(this);
			}
		}
		return super.getUpdateFeature(context);
	}
	
	
	
	@Override
	public ICopyFeature getCopyFeature(final ICopyContext context)
	{
		final PictogramElement[] pictogramElements = context.getPictogramElements();
		if (getBusinessObjectForPictogramElement(pictogramElements[0]) instanceof Service)
		{
			return new CopyServiceFeature(this);
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
	
	
	
	@Override
	public IDeleteFeature getDeleteFeature(final IDeleteContext context)
	{
		final Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (o instanceof Network)
		{
			return new DeleteNetworkFeature(this);
		}
		else if (o instanceof ControlCenter)
		{
			return new DeleteControlCenterFeature(this);
		}
		else if (o instanceof Service)
		{
			return new DeleteServiceFeature(this);
		}
		else if (context.getPictogramElement() instanceof Connection)
		{
			return new DeleteConnectionFeature(this);
		}
		return super.getDeleteFeature(context);
		
	}
	
}
