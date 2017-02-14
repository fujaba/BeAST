package de.uks.beast.editor.feature.edit;

import static de.uks.beast.editor.util.Properties.NAME;
import static de.uks.beast.editor.util.Strings.EMPTY_NAME_WARNING;
import static de.uks.beast.editor.util.Strings.LINE_BREAK_WARNING;
import static de.uks.beast.editor.util.Strings.WRONG_SYMBOL_WARNING;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.uks.beast.editor.util.PropertyUtil;

public class DirectEditServiceFeature extends AbstractDirectEditingFeature
{
	
	public DirectEditServiceFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public int getEditingType()
	{
		return TYPE_TEXT;
	}
	
	
	
	@Override
	public boolean canDirectEdit(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Object object = getBusinessObjectForPictogramElement(pe);
		final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		
		if (object instanceof Service && ga instanceof Text && PropertyUtil.isAttributeShape(pe, NAME))
		{
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public String getInitialValue(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Service service = (Service) getBusinessObjectForPictogramElement(pe);
		
		return service.getName();
	}
	
	
	
	@Override
	public String checkValueValid(final String value, final IDirectEditingContext context)
	{
		if (value.length() < 1)
		{
			return EMPTY_NAME_WARNING.text();
		}
		if (value.contains(" "))
		{
			return WRONG_SYMBOL_WARNING.text();
		}
		if (value.contains("\n"))
		{
			return LINE_BREAK_WARNING.text();
		}
		
		return null;
	}
	
	
	@Override
	public void setValue(final String value, final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Service server = (Service) getBusinessObjectForPictogramElement(pe);
		server.setName(value);
		updatePictogramElement(((Shape) pe).getContainer());
	}
	
}
