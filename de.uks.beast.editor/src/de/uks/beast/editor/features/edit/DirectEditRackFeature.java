package de.uks.beast.editor.features.edit;

import model.Rack;

import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class DirectEditRackFeature extends AbstractDirectEditingFeature
		implements IDirectEditingFeature {

	public DirectEditRackFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
	
	@Override
	public boolean canDirectEdit(final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = getBusinessObjectForPictogramElement(pe);
		final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		
		if (bo instanceof Rack && ga instanceof Text)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Rack rack = (Rack) getBusinessObjectForPictogramElement(pe);
		
		return rack.getName();
	}
	
	@Override
	public String checkValueValid(final String value, final IDirectEditingContext context)
	{
		if (value.length() < 1) {
			return "Please enter any text as class name.";
		}
		if (value.contains(" ")) {
			return "Spaces are not allowed in class names.";
		}
		if (value.contains("\n")) {
			return "Line breakes are not allowed in class names.";
		}
		
		return null;
	}
	
	
	
	public void setValue(final String value, final IDirectEditingContext context)
	{
		final PictogramElement pe = context.getPictogramElement();
		final Rack rack = (Rack) getBusinessObjectForPictogramElement(pe);
		rack.setName(value);
		updatePictogramElement(((Shape) pe).getContainer());
	}

}
