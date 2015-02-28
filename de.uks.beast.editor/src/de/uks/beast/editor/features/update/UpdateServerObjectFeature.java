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

import de.uks.beast.editor.features.util.PropertyUtil;
import static de.uks.beast.editor.util.Strings.*;

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
					
					if (PropertyUtil.isAttributeShape(shape, NAME))
					{
						pictogramName = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, IP))
					{
						pictogramIp = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_AMOUNT))
					{
						pictogramCpuAmount = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_TYPE))
					{
						pictogramCpuType = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, RAM))
					{
						pictogramRam = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, DISKSPACE))
					{
						pictogramDiskSpace = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, RAM_STAT))
					{
						continue;
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_STAT))
					{
						continue;
					}
				}
			}
		}
		
		final Object object = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (object instanceof Server)
		{
			final Server server = (Server) object;
			businessName = server.getName();
			businessIp = server.getIp();
			businessCpuAmount = String.valueOf(server.getCpuAmount());
			businessCpuType = server.getCpuType();
			businessRam = String.valueOf(server.getRam());
			businessDiskSpace = String.valueOf(server.getDiskSpace());
			
		}
		
		if (PropertyUtil.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramIp, businessIp))
		{
			return Reason.createTrueReason(IP_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramCpuAmount, businessCpuAmount))
		{
			return Reason.createTrueReason(CPU_AMOUNT_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramCpuType, businessCpuType))
		{
			return Reason.createTrueReason(CPU_TYPE_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramRam, businessRam))
		{
			return Reason.createTrueReason(RAM_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramDiskSpace, businessDiskSpace))
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
		final Object object = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (object instanceof Server)
		{
			final Server server = (Server) object;
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
					
					if (PropertyUtil.isAttributeShape(shape, NAME))
					{
						text.setValue(businessName);
					}
					else if (PropertyUtil.isAttributeShape(shape, IP))
					{
						text.setValue(businessIp);
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_AMOUNT))
					{
						text.setValue(businessCpuAmount);
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_TYPE))
					{
						text.setValue(businessCpuType);
					}
					else if (PropertyUtil.isAttributeShape(shape, RAM))
					{
						text.setValue(businessRam);
					}
					else if (PropertyUtil.isAttributeShape(shape, DISKSPACE))
					{
						text.setValue(businessDiskSpace);
					}
					else if (PropertyUtil.isAttributeShape(shape, RAM_STAT))
					{
						continue;
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_STAT))
					{
						continue;
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
}
