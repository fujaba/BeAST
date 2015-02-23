package de.uks.beast.editor.util;

import java.util.List;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;

public class PaletteCompartmentEntry extends org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry
{
	private final List<AbstractCreateFeature>			createObjectFeatures;
	private final List<AbstractCreateConnectionFeature>	createConnectionFeatures;
	
	
	
	protected PaletteCompartmentEntry(final String label, final String iconId,
			final List<AbstractCreateFeature> createObjectFeatures,
			final List<AbstractCreateConnectionFeature> createConnectionFeatures, final boolean initialOpen)
	{
		super(label, iconId);
		this.createObjectFeatures = createObjectFeatures;
		this.createConnectionFeatures = createConnectionFeatures;
		this.setInitiallyOpen(initialOpen);
	}
	
	
	
	public static PaletteCompartmentEntryBuilder builder()
	{
		return new PaletteCompartmentEntryBuilder();
	}
	
	
	
	/**
	 * @return the createObjectFeatures
	 */
	public List<AbstractCreateFeature> getCreateObjectFeatures()
	{
		return createObjectFeatures;
	}
	
	
	
	protected void addAllToolEntries()
	{
		if (!createObjectFeatures.isEmpty())
		{
			for (final ICreateFeature cf : createObjectFeatures)
			{
				final ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(cf.getCreateName(),
						cf.getCreateDescription(), StringConstants.PALETTE_ENTRY_IMAGE.getImageID(), cf.getCreateLargeImageId(),
						cf);
				this.addToolEntry(objectCreationToolEntry);
				
			}
		}
		if (!createConnectionFeatures.isEmpty())
		{
			for (final ICreateConnectionFeature cf : createConnectionFeatures)
			{
				final ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(
						cf.getCreateName(), cf.getCreateDescription(), StringConstants.PALETTE_ENTRY_IMAGE.getImageID(),
						cf.getCreateLargeImageId());
				connectionCreationToolEntry.addCreateConnectionFeature(cf);
				this.addToolEntry(connectionCreationToolEntry);
			}
		}
		
	}
	
	
	
	/**
	 * @return the createConnectionFeatures
	 */
	public List<AbstractCreateConnectionFeature> getCreateConnectionFeatures()
	{
		return createConnectionFeatures;
	}
	
}
