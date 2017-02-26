package de.uks.beast.editor.feature.update;

import static de.uks.beast.editor.util.Properties.LIMIT_CPU;
import static de.uks.beast.editor.util.Properties.LIMIT_MEM;
import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Properties.RESERVATION_CPU;
import static de.uks.beast.editor.util.Properties.RESERVATION_MEM;
import static de.uks.beast.editor.util.Strings.LIMIT_CPU_TRUE_REASON;
import static de.uks.beast.editor.util.Strings.LIMIT_MEM_TRUE_REASON;
import static de.uks.beast.editor.util.Strings.NAME_TRUE_REASON;
import static de.uks.beast.editor.util.Strings.RESERVATION_CPU_TRUE_REASON;
import static de.uks.beast.editor.util.Strings.RESERVATION_MEM_TRUE_REASON;

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
import model.HadoopMaster;
import model.HadoopSlave;
import model.Service;
import model.impl.HadoopMasterImpl;

public class UpdateServiceObjectFeature extends AbstractUpdateFeature
{
	
	private String	pictogramName			= null;
	private String	pictogramLimitCpu		= null;
	private String	pictogramReservationCpu	= null;
	private String	pictogramLimitMem		= null;
	private String	pictogramReservationMem	= null;
	
	private String	businessName			= null;
	private String	businessLimitCpu		= null;
	private String	businessReservationCpu	= null;
	private String	businessLimitMem		= null;
	private String	businessReservationMem	= null;
	
	
	
	public UpdateServiceObjectFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canUpdate(final IUpdateContext context)
	{
		final Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		if (o instanceof Service)
		{
			final Service s = (Service) o;
			
			if (NameCache.isRegistered(s.getClass(), s.getName()))
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
					else if (PropertyUtil.isAttributeShape(shape, LIMIT_CPU))
					{
						pictogramLimitCpu = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, RESERVATION_CPU))
					{
						pictogramReservationCpu = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, LIMIT_MEM))
					{
						pictogramLimitMem = text.getValue();
					}
					else if (PropertyUtil.isAttributeShape(shape, RESERVATION_MEM))
					{
						pictogramReservationMem = text.getValue();
					}
				}
			}
		}
		
		final Object object = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (object instanceof Service)
		{
			final Service service = (Service) object;
			businessName = service.getName();
			businessLimitCpu = service.getLimitCpu();
			businessReservationCpu = service.getReservationCpu();
			businessLimitMem = service.getLimitMem();
			businessReservationMem = service.getReservationMem();
			
		}
		
		if (PropertyUtil.updateNeeded(pictogramName, businessName))
		{
			return Reason.createTrueReason(NAME_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramLimitCpu, businessLimitCpu))
		{
			return Reason.createTrueReason(LIMIT_CPU_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramReservationCpu, businessReservationCpu))
		{
			return Reason.createTrueReason(RESERVATION_CPU_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramLimitMem, businessLimitMem))
		{
			return Reason.createTrueReason(LIMIT_MEM_TRUE_REASON.text());
		}
		else if (PropertyUtil.updateNeeded(pictogramReservationMem, businessReservationMem))
		{
			return Reason.createTrueReason(RESERVATION_MEM_TRUE_REASON.text());
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
			businessLimitCpu = service.getLimitCpu();
			businessReservationCpu = service.getReservationCpu();
			businessLimitMem = service.getLimitMem();
			businessReservationMem = service.getReservationMem();
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
						nameCachingFor(object, text.getValue(), businessName);
						text.setValue(businessName);
					}
					else if (PropertyUtil.isAttributeShape(shape, LIMIT_CPU))
					{
						text.setValue(businessLimitCpu);
					}
					else if (PropertyUtil.isAttributeShape(shape, RESERVATION_CPU))
					{
						text.setValue(businessReservationCpu);
					}
					else if (PropertyUtil.isAttributeShape(shape, LIMIT_MEM))
					{
						text.setValue(businessLimitMem);
					}
					else if (PropertyUtil.isAttributeShape(shape, RESERVATION_MEM))
					{
						text.setValue(businessReservationMem);
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
	
	
	private void nameCachingFor(final Object object, final String oldName, final String newName)
	{
		if (object instanceof HadoopMasterImpl)
		{
			NameCache.remove(HadoopMaster.class, oldName);
			NameCache.add(HadoopMaster.class, newName);
		}
		else
		{
			NameCache.remove(HadoopSlave.class, oldName);
			NameCache.add(HadoopSlave.class, newName);
		}
	}
	
}
