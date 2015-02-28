package de.uks.beast.editor.features.edit;

import model.Router;

import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import static de.uks.beast.editor.util.Strings.*;

public class DirectEditRouterFeature extends AbstractDirectEditingFeature implements IDirectEditingFeature
{
	
	public DirectEditRouterFeature(final IFeatureProvider fp)
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
		final Object bo = getBusinessObjectForPictogramElement(pe);
		final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		
		if (bo instanceof Router && ga instanceof Text)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	@Override
	public String getInitialValue(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Router router = (Router) getBusinessObjectForPictogramElement(pe);
		
		return router.getName();
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
	
	
	
	public void setValue(final String value, final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Router router = (Router) getBusinessObjectForPictogramElement(pe);
		router.setName(value);
		updatePictogramElement(((Shape) pe).getContainer());
	}
	
}
