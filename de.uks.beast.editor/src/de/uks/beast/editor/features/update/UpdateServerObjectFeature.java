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

import de.uks.beast.editor.features.util.ServerPictogramIdentifier;

public class UpdateServerObjectFeature extends AbstractUpdateFeature
{
	
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
	
	
	
	@Override
	public IReason updateNeeded(final IUpdateContext context)
	{
		// retrieve values from pictogram model
		String pictogramName = null;
		String pictogramIp = null;
		String pictogramCpuAmount = null;
		String pictogramCpuType = null;
		String pictogramRam = null;
		String pictogramDiskSpace = null;
		final PictogramElement pictogramElement = context.getPictogramElement();
		
		if (pictogramElement instanceof ContainerShape)
		{
			final ContainerShape cs = (ContainerShape) pictogramElement;
			
			for (final Shape shape : cs.getChildren())
			{
				if (shape.getGraphicsAlgorithm() instanceof Text)
				{
					final Text text = (Text) shape.getGraphicsAlgorithm();
					
					if (ServerPictogramIdentifier.get("name").equals(text))
					{
						pictogramName = text.getValue();
					}
					else if (ServerPictogramIdentifier.get("ip").equals(text))
					{
						pictogramIp = text.getValue();
					}
					else if (ServerPictogramIdentifier.get("cpuamount").equals(text))
					{
						pictogramCpuAmount = text.getValue();
					}
					else if (ServerPictogramIdentifier.get("cputype").equals(text))
					{
						pictogramCpuType = text.getValue();
					}
					else if (ServerPictogramIdentifier.get("ram").equals(text))
					{
						pictogramRam = text.getValue();
					}
					else if (ServerPictogramIdentifier.get("diskspace").equals(text))
					{
						pictogramDiskSpace = text.getValue();
					}
				}
			}
		}
		
		// retrieve values from business model
		String businessName = null;
		String businessIp = null;
		String businessCpuAmount = null;
		String businessCpuType = null;
		String businessRam = null;
		String businessDiskSpace = null;
		
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
		
		// update needed, if values are different
		final boolean updateNameNeeded = ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName
				.equals(businessName)));
		final boolean updateIpNeeded = ((pictogramIp == null && businessIp != null) || (pictogramIp != null && !pictogramIp
				.equals(businessIp)));
		final boolean updateCpuAmountNeeded = ((pictogramCpuAmount == null && businessCpuAmount != null) || (pictogramCpuAmount != null && !pictogramCpuAmount
				.equals(businessCpuAmount)));
		final boolean updateCpuTypeNeeded = ((pictogramCpuType == null && businessCpuType != null) || (pictogramCpuType != null && !pictogramCpuType
				.equals(businessCpuType)));
		final boolean updateRamNeeded = ((pictogramRam == null && businessRam != null) || (pictogramRam != null && !pictogramRam
				.equals(businessRam)));
		final boolean updateDiskSpaceNeeded = ((pictogramDiskSpace == null && businessDiskSpace != null) || (pictogramDiskSpace != null && !pictogramDiskSpace
				.equals(businessDiskSpace)));
		
		if (updateNameNeeded)
		{
			return Reason.createTrueReason("Name is out of date!");
		}
		else if (updateIpNeeded)
		{
			return Reason.createTrueReason("IP is out of date!");
		}
		else if (updateCpuAmountNeeded)
		{
			return Reason.createTrueReason("CPU amount is out of date!");
		}
		else if (updateCpuTypeNeeded)
		{
			return Reason.createTrueReason("CPU type is out of date!");
		}
		else if (updateRamNeeded)
		{
			return Reason.createTrueReason("RAM is out of date!");
		}
		else if (updateDiskSpaceNeeded)
		{
			return Reason.createTrueReason("Disk space is out of date!");
		}
		else
		{
			return Reason.createFalseReason();
		}
	}
	
	
	
	@Override
	public boolean update(final IUpdateContext context)
	{
		// retrieve values from business model
		String businessName = null;
		String businessIp = null;
		String businessCpuAmount = null;
		String businessCpuType = null;
		String businessRam = null;
		String businessDiskSpace = null;
		
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
					
					if (ServerPictogramIdentifier.get("name").equals(text))
					{
						text.setValue(businessName);
					}
					else if (ServerPictogramIdentifier.get("ip").equals(text))
					{
						text.setValue(businessIp);
					}
					else if (ServerPictogramIdentifier.get("cpuamount").equals(text))
					{
						text.setValue(businessCpuAmount);
					}
					else if (ServerPictogramIdentifier.get("cputype").equals(text))
					{
						text.setValue(businessCpuType);
					}
					else if (ServerPictogramIdentifier.get("ram").equals(text))
					{
						text.setValue(businessRam);
					}
					else if (ServerPictogramIdentifier.get("diskspace").equals(text))
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
