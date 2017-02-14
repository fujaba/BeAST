package de.uks.beast.editor.feature.update;

import static de.uks.beast.editor.util.Properties.CPU_CORES;
import static de.uks.beast.editor.util.Properties.IP;
import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Strings.CPU_CORES_TRUE_REASON;
import static de.uks.beast.editor.util.Strings.IP_TRUE_REASON;
import static de.uks.beast.editor.util.Strings.NAME_TRUE_REASON;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.uks.beast.editor.util.PropertyUtil;

public class UpdateServiceObjectFeature extends AbstractUpdateFeature
{
	// retrieve values from pictogram model
	private String	pictogramName	= null;
	private String	pictogramAttr_0	= null;
	private String	pictogramAttr_1	= null;
	
	// retrieve values from business model
	private String	businessName	= null;
	private String	businessAttr_0	= null;
	private String	businessAttr_1	= null;
	
	
	
	public UpdateServiceObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canUpdate(final IUpdateContext context)
	{
		// return true, if linked business object is a EClass
		final Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		return (bo instanceof Service);
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
						pictogramAttr_0 = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_CORES))
					{
						pictogramAttr_1 = text.getValue();
					}
				}
			}
		}
		
		final Object object = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (object instanceof Service)
		{
			final Service service = (Service) object;
			businessName = service.getName();
			businessAttr_0 = service.getAtribute_0();
			businessAttr_1 = service.getAtribute_1();
			
		}
		
		if (PropertyUtil.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramAttr_0, businessAttr_0))
		{
			return Reason.createTrueReason(IP_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramAttr_1, businessAttr_1))
		{
			return Reason.createTrueReason(CPU_CORES_TRUE_REASON.text());
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
		
		if (object instanceof Service)
		{
			final Service service = (Service) object;
			businessName = service.getName();
			businessAttr_0 = service.getAtribute_0();
			businessAttr_1 = service.getAtribute_1();
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
						text.setValue(businessAttr_0);
					}
					else if (PropertyUtil.isAttributeShape(shape, CPU_CORES))
					{
						text.setValue(businessAttr_1);
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
}
