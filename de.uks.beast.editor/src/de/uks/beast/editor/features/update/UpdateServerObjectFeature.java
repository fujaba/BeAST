package de.uks.beast.editor.features.update;

import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.uks.beast.editor.features.util.manager.ServerPictogramManager;
import static de.uks.beast.editor.features.util.message.Message.*;

public class UpdateServerObjectFeature extends AbstractUpdateFeature
{
	// retrieve values from pictogram model
	private String	pictogramName		= null;
	private String	pictogramIp			= null;
	private String	pictogramCpuAmount	= null;
	private String	pictogramCpuType	= null;
	private String	pictogramRam		= null;
	private String	pictogramDiskSpace	= null;
	
	// retrieve values from business model
	private String	businessName		= null;
	private String	businessIp			= null;
	private String	businessCpuAmount	= null;
	private String	businessCpuType		= null;
	private String	businessRam			= null;
	private String	businessDiskSpace	= null;
	
	
	
	public UpdateServerObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canUpdate(final IUpdateContext context)
	{
		// return true, if linked business object is a EClass
		final Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		return (bo instanceof Server);
	}
	
	
	
	//TODO: NPE when you open an existing editor view because shapeList is empty then
	@Override
	public IReason updateNeeded(final IUpdateContext context)
	{
		final PictogramElement pictogramElement = context.getPictogramElement();
		
		if (pictogramElement instanceof ContainerShape)
		{
			final ContainerShape cs = (ContainerShape) pictogramElement;
			
			for (final Shape shape : cs.getChildren())
			{
				if (shape.getGraphicsAlgorithm() instanceof Text)
				{
					final Text text = (Text) shape.getGraphicsAlgorithm();
					
					if (ServerPictogramManager.get(NAME).equals(text))
					{
						pictogramName = text.getValue();
					}
					else if (ServerPictogramManager.get(IP).equals(text))
					{
						pictogramIp = text.getValue();
					}
					else if (ServerPictogramManager.get(CPU_AMOUNT).equals(text))
					{
						pictogramCpuAmount = text.getValue();
					}
					else if (ServerPictogramManager.get(CPU_TYPE).equals(text))
					{
						pictogramCpuType = text.getValue();
					}
					else if (ServerPictogramManager.get(RAM).equals(text))
					{
						pictogramRam = text.getValue();
					}
					else if (ServerPictogramManager.get(DISKSPACE).equals(text))
					{
						pictogramDiskSpace = text.getValue();
					}
				}
			}
		}
		
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Server)
		{
			final Server server = (Server) bo;
			businessName = server.getName();
			businessIp = server.getIp();
			businessCpuAmount = String.valueOf(server.getCpuAmount());
			businessCpuType = server.getCpuType();
			businessRam = String.valueOf(server.getRam());
			businessDiskSpace = String.valueOf(server.getDiskSpace());
			
		}
		
		if (ServerPictogramManager.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
		}
		else if (ServerPictogramManager.updateNeeded(pictogramIp, businessIp))
		{
			return Reason.createTrueReason(IP_TRUE_REASON.text());
		}
		else if (ServerPictogramManager.updateNeeded(pictogramCpuAmount, businessCpuAmount))
		{
			return Reason.createTrueReason(CPU_AMOUNT_TRUE_REASON.text());
		}
		else if (ServerPictogramManager.updateNeeded(pictogramCpuType, businessCpuType))
		{
			return Reason.createTrueReason(CPU_TYPE_TRUE_REASON.text());
		}
		else if (ServerPictogramManager.updateNeeded(pictogramRam, businessRam))
		{
			return Reason.createTrueReason(RAM_TRUE_REASON.text());
		}
		else if (ServerPictogramManager.updateNeeded(pictogramDiskSpace, businessDiskSpace))
		{
			return Reason.createTrueReason(DISKSPACE_TRUE_REASON.text());
		}
		else
		{
			return Reason.createFalseReason();
		}
	}
	
	
	
	@Override
	public boolean update(final IUpdateContext context)
	{
		
		final PictogramElement pictogramElement = context.getPictogramElement();
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Server)
		{
			final Server server = (Server) bo;
			businessName = server.getName();
			businessIp = server.getIp();
			businessCpuAmount = String.valueOf(server.getCpuAmount());
			businessCpuType = server.getCpuType();
			businessRam = String.valueOf(server.getRam());
			businessDiskSpace = String.valueOf(server.getDiskSpace());
		}
		
		// Set values in pictogram model
		if (pictogramElement instanceof ContainerShape)
		{
			final ContainerShape cs = (ContainerShape) pictogramElement;
			
			for (final Shape shape : cs.getChildren())
			{
				if (shape.getGraphicsAlgorithm() instanceof Text)
				{
					final Text text = (Text) shape.getGraphicsAlgorithm();
					
					if (ServerPictogramManager.get(NAME).equals(text))
					{
						text.setValue(businessName);
					}
					else if (ServerPictogramManager.get(IP).equals(text))
					{
						text.setValue(businessIp);
					}
					else if (ServerPictogramManager.get(CPU_AMOUNT).equals(text))
					{
						text.setValue(businessCpuAmount);
					}
					else if (ServerPictogramManager.get(CPU_TYPE).equals(text))
					{
						text.setValue(businessCpuType);
					}
					else if (ServerPictogramManager.get(RAM).equals(text))
					{
						text.setValue(businessRam);
					}
					else if (ServerPictogramManager.get(DISKSPACE).equals(text))
					{
						text.setValue(businessDiskSpace);
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
}
