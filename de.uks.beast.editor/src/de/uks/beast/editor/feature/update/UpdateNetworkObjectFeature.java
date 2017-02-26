package de.uks.beast.editor.feature.update;

import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Strings.NAME_TRUE_REASON;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.uks.beast.editor.util.NameCache;
import de.uks.beast.editor.util.PropertyUtil;
import model.Network;

public class UpdateNetworkObjectFeature extends AbstractUpdateFeature
{
	private String	pictogramName	= null;
	private String	businessName	= null;
	
	
	
	public UpdateNetworkObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canUpdate(final IUpdateContext context)
	{
		final Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		if (bo instanceof Network)
		{
			final Network network = (Network) bo;
			
			if (NameCache.isRegistered(network.getClass(), network.getName()))
			{
				return false;
			}
			return true;
		}
		
		return false;
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
				}
			}
		}
		
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Network)
		{
			final Network network = (Network) bo;
			businessName = network.getName();
		}
		
		if (PropertyUtil.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
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
						NameCache.remove(Network.class, text.getValue());
						text.setValue(businessName);
						NameCache.add(Network.class, businessName);
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
}
