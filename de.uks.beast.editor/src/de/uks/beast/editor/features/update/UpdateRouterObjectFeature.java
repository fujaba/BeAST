package de.uks.beast.editor.features.update;

import static de.uks.beast.editor.features.util.message.Message.EXTERNAL_GATEWAY;
import static de.uks.beast.editor.features.util.message.Message.EXT_GATEWAY_TRUE_REASON;
import static de.uks.beast.editor.features.util.message.Message.ID;
import static de.uks.beast.editor.features.util.message.Message.ID_TRUE_REASON;
import static de.uks.beast.editor.features.util.message.Message.IP;
import static de.uks.beast.editor.features.util.message.Message.IP_TRUE_REASON;
import static de.uks.beast.editor.features.util.message.Message.NAME;
import static de.uks.beast.editor.features.util.message.Message.NAME_TRUE_REASON;
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

import de.uks.beast.editor.features.util.manager.RouterPictogramManager;

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
					
					if (RouterPictogramManager.get(NAME).equals(text))
					{
						pictogramName = text.getValue();
					}
					else if (RouterPictogramManager.get(IP).equals(text))
					{
						pictogramIp = text.getValue();
					}
					else if (RouterPictogramManager.get(ID).equals(text))
					{
						pictogramId = text.getValue();
					}
					else if (RouterPictogramManager.get(EXTERNAL_GATEWAY).equals(text))
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
		
		if (RouterPictogramManager.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
		}
		else if (RouterPictogramManager.updateNeeded(pictogramIp, businessIp))
		{
			return Reason.createTrueReason(IP_TRUE_REASON.text());
		}
		else if (RouterPictogramManager.updateNeeded(pictogramId, businessId))
		{
			return Reason.createTrueReason(ID_TRUE_REASON.text());
		}
		else if (RouterPictogramManager.updateNeeded(pictogramExtGateway, businessExtGateway))
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
					
					if (RouterPictogramManager.get(NAME).equals(text))
					{
						text.setValue(businessName);
					}
					else if (RouterPictogramManager.get(IP).equals(text))
					{
						text.setValue(businessIp);
					}
					else if (RouterPictogramManager.get(ID).equals(text))
					{
						text.setValue(businessId);
					}
					else if (RouterPictogramManager.get(EXTERNAL_GATEWAY).equals(text))
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
