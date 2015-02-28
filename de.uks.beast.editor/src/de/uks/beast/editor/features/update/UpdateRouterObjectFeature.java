package de.uks.beast.editor.features.update;

import model.Router;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.uks.beast.editor.features.util.PropertyUtil;
import static de.uks.beast.editor.util.Strings.*;

public class UpdateRouterObjectFeature extends AbstractUpdateFeature implements IUpdateFeature
{
	// retrieve values from pictogram model
	private String	pictogramName		= null;
	private String	pictogramIp			= null;
	private String	pictogramId			= null;
	private String	pictogramExtGateway	= null;
	
	// retrieve values from business model
	private String	businessName		= null;
	private String	businessIp			= null;
	private String	businessId			= null;
	private String	businessExtGateway	= null;
	
	
	
	public UpdateRouterObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canUpdate(final IUpdateContext context)
	{
		// return true, if linked business object is a EClass
		final Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		return (bo instanceof Router);
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
					else if (PropertyUtil.isAttributeShape(shape, EXTERNAL_GATEWAY))
					{
						pictogramExtGateway = text.getValue();
					}
					
				}
			}
		}
		
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Router)
		{
			final Router router = (Router) bo;
			businessName = router.getName();
			businessIp = router.getIp();
			businessId = router.getId();
			businessExtGateway = router.getExternalGateway();
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
		else if (PropertyUtil.updateNeeded(pictogramExtGateway, businessExtGateway))
		{
			return Reason.createTrueReason(EXT_GATEWAY_TRUE_REASON.text());
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
		
		if (bo instanceof Router)
		{
			final Router router = (Router) bo;
			businessName = router.getName();
			businessIp = router.getIp();
			businessId = router.getId();
			businessExtGateway = router.getExternalGateway();
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
					else if (PropertyUtil.isAttributeShape(shape, EXTERNAL_GATEWAY))
					{
						text.setValue(businessExtGateway);
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
}
