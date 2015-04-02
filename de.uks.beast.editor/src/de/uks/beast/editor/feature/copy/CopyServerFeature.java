package de.uks.beast.editor.feature.copy;

import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;

public class CopyServerFeature extends AbstractCopyFeature
{
	
	public CopyServerFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public void copy(final ICopyContext context)
	{
		// get the business-objects for all pictogram-elements
		// we already verified, that all business-objets are EClasses
		final PictogramElement[] pes = context.getPictogramElements();
		final Object[] bos = new Object[pes.length];
		
		for (int i = 0; i < pes.length; i++)
		{
			final PictogramElement pe = pes[i];
			
			bos[i] = getBusinessObjectForPictogramElement(pe);
		}
		// put all business objects to the clipboard
		putToClipboard(bos);
	}
	
	
	
	@Override
	public boolean canCopy(final ICopyContext context)
	{
		final PictogramElement[] pes = context.getPictogramElements();
		
		if (pes == null || pes.length == 0)
		{  // nothing selected
			return false;
		}
		
		// return true, if all selected elements are a EClasses
		for (final PictogramElement pe : pes)
		{
			final Object bo = getBusinessObjectForPictogramElement(pe);
			if (!(bo instanceof Server))
			{
				return false;
			}
		}
		return true;
	}
	
}
