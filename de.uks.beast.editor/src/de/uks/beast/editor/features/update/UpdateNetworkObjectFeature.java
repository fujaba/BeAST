package de.uks.beast.editor.features.update;

import static de.uks.beast.editor.util.Constants.DNS;
import static de.uks.beast.editor.util.Constants.DNS_TRUE_REASON;
import static de.uks.beast.editor.util.Constants.GATEWAY;
import static de.uks.beast.editor.util.Constants.GATEWAY_TRUE_REASON;
import static de.uks.beast.editor.util.Constants.ID;
import static de.uks.beast.editor.util.Constants.ID_TRUE_REASON;
import static de.uks.beast.editor.util.Constants.IP;
import static de.uks.beast.editor.util.Constants.IP_TRUE_REASON;
import static de.uks.beast.editor.util.Constants.NAME;
import static de.uks.beast.editor.util.Constants.NAME_TRUE_REASON;
import static de.uks.beast.editor.util.Constants.SUBNET_MASK;
import static de.uks.beast.editor.util.Constants.SUBNET_MASK_TRUE_REASON;
import model.Network;

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

public class UpdateNetworkObjectFeature extends AbstractUpdateFeature
{
	// retrieve values from pictogram model
	private String	pictogramName		= null;
	private String	pictogramIp			= null;
	private String	pictogramId			= null;
	private String	pictogramDns		= null;
	private String	pictogramGateway	= null;
	private String	pictogramSubnetMask	= null;
	
	// retrieve values from business model
	private String	businessName		= null;
	private String	businessIp			= null;
	private String	businessId			= null;
	private String	businessDns			= null;
	private String	businessGateway		= null;
	private String	businessSubnetMask	= null;
	
	
	
	public UpdateNetworkObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canUpdate(final IUpdateContext context)
	{
		// return true, if linked business object is a EClass
		final Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		return (bo instanceof Network);
	}
	
	
	
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
					else if (PropertyUtil.isAttributeShape(shape, ID))
					{
						pictogramId = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, DNS))
					{
						pictogramDns = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, GATEWAY))
					{
						pictogramGateway = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, SUBNET_MASK))
					{
						pictogramSubnetMask = text.getValue();
					}
				}
			}
		}
		
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Network)
		{
			final Network network = (Network) bo;
			businessName = network.getName();
			businessIp = network.getIp();
			businessId = network.getId();
			businessDns = network.getDns();
			businessGateway = network.getGateway();
			businessSubnetMask = network.getSubnetmask();
		}
		
		if (PropertyUtil.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramIp, businessIp))
		{
			return Reason.createTrueReason(IP_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramId, businessId))
		{
			return Reason.createTrueReason(ID_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramDns, businessDns))
		{
			return Reason.createTrueReason(DNS_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramGateway, businessGateway))
		{
			return Reason.createTrueReason(GATEWAY_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramSubnetMask, businessSubnetMask))
		{
			return Reason.createTrueReason(SUBNET_MASK_TRUE_REASON.text());
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
		
		if (bo instanceof Network)
		{
			final Network network = (Network) bo;
			businessName = network.getName();
			businessIp = network.getIp();
			businessId = network.getId();
			businessDns = network.getDns();
			businessGateway = network.getGateway();
			businessSubnetMask = network.getSubnetmask();
		}
		
		// Set name in pictogram model
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
					else if (PropertyUtil.isAttributeShape(shape, ID))
					{
						text.setValue(businessId);
					}
					else if (PropertyUtil.isAttributeShape(shape, DNS))
					{
						text.setValue(businessDns);
					}
					else if (PropertyUtil.isAttributeShape(shape, GATEWAY))
					{
						text.setValue(businessGateway);
					}
					else if (PropertyUtil.isAttributeShape(shape, SUBNET_MASK))
					{
						text.setValue(businessSubnetMask);
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
}
