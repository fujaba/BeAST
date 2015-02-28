package de.uks.beast.editor.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class PaletteCompartmentEntryBuilder
{
	private static final Logger							LOG							= LogManager
																							.getLogger(PaletteCompartmentEntryBuilder.class);
	
	private boolean										initialOpen					= true;
	private String										name						= "default";
	private String										iconID						= null;
	private final List<AbstractCreateFeature>			createObjectFeatures		= new ArrayList<>();
	private final List<AbstractCreateConnectionFeature>	createConnectionFeatures	= new ArrayList<>();
	
	
	
	protected PaletteCompartmentEntryBuilder()
	{
		
	}
	
	
	
	public PaletteCompartmentEntry build()
	{
		final PaletteCompartmentEntry entry = new PaletteCompartmentEntry(name, iconID, createObjectFeatures,
				createConnectionFeatures, initialOpen);
		entry.addAllToolEntries();
		LOG.debug("Build entry -> " + entry.toString());
		
		return entry;
		
	}
	
	
	
	public PaletteCompartmentEntryBuilder addCreateObjectFeature(final AbstractCreateFeature createFeature)
	{
		if (createFeature != null && !createObjectFeatures.contains(createFeature))
		{
			createObjectFeatures.add(createFeature);
		}
		
		return this;
	}
	
	
	
	public PaletteCompartmentEntryBuilder addCreateConnectionFeature(final AbstractCreateConnectionFeature createFeature)
	{
		if (createFeature != null && !createConnectionFeatures.contains(createFeature))
		{
			createConnectionFeatures.add(createFeature);
		}
		
		return this;
	}
	
	
	
	public PaletteCompartmentEntryBuilder addAllCreateObjectFeature(final AbstractCreateFeature... createFeatures)
	{
		for (final AbstractCreateFeature feature : createFeatures)
		{
			if (feature != null && !createObjectFeatures.contains(feature))
			{
				createObjectFeatures.add(feature);
			}
		}
		
		return this;
	}
	
	
	
	public PaletteCompartmentEntryBuilder addAllCreateConnectionFeature(final AbstractCreateConnectionFeature... createFeatures)
	{
		for (final AbstractCreateConnectionFeature feature : createFeatures)
		{
			if (feature != null && !createConnectionFeatures.contains(feature))
			{
				createConnectionFeatures.add(feature);
			}
		}
		
		return this;
	}
	
	
	
	/**
	 * @param name the name to set
	 */
	public PaletteCompartmentEntryBuilder setName(final String name)
	{
		this.name = name;
		
		return this;
	}
	
	
	
	/**
	 * @param iconID the iconID to set
	 */
	public PaletteCompartmentEntryBuilder setIconID(final String iconID)
	{
		this.iconID = iconID;
		
		return this;
	}
	
	
	
	/**
	 * @param initialOpen the initialOpen to set
	 */
	public PaletteCompartmentEntryBuilder setInitialOpen(final boolean initialOpen)
	{
		this.initialOpen = initialOpen;
		
		return this;
	}
	
}
