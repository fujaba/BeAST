package de.uks.beast.editor.services.hadoop.provider;

import static de.uks.beast.editor.util.Constants.SERVICE_HADOOP;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

import de.uks.beast.editor.services.hadoop.create.CreateHadoopConnection;
import de.uks.beast.editor.services.hadoop.create.CreateHadoopMasterFeature;
import de.uks.beast.editor.services.hadoop.create.CreateHadoopSlaveFeature;

public class HadoopFeatureProvider extends DefaultToolBehaviorProvider
{
	
	public HadoopFeatureProvider(final IDiagramTypeProvider diagramTypeProvider)
	{
		super(diagramTypeProvider);
	}
	
	
	
	@Override
	public IPaletteCompartmentEntry[] getPalette()
	{
		final List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();
		
		// add compartments from super class
		final IPaletteCompartmentEntry[] superCompartments = super.getPalette();
		
		for (int i = 0; i < superCompartments.length; i++)
		{
			ret.add(superCompartments[i]);
		}
		
		// add new compartment at the end of the existing compartments
		final PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry(SERVICE_HADOOP.text(), null);
		ret.add(compartmentEntry);
		
		// add all create-features to the new stack-entry
		final IFeatureProvider featureProvider = getFeatureProvider();
		
		final ICreateFeature[] createFeatures = { new CreateHadoopMasterFeature(featureProvider, "HadoopMaster", ""),
				new CreateHadoopSlaveFeature(featureProvider, "HadoopSlave", "") };
		
		for (final ICreateFeature cf : createFeatures)
		{
			final ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(cf.getCreateName(),
					cf.getCreateDescription(), cf.getCreateImageId(), cf.getCreateLargeImageId(), cf);
			compartmentEntry.addToolEntry(objectCreationToolEntry);
		}
		
		// add all create-connection-features to the new stack-entry
		final ICreateConnectionFeature[] createConnectionFeatures = { new CreateHadoopConnection(featureProvider,
				"HadoopConnection", "") };
		
		for (final ICreateConnectionFeature cf : createConnectionFeatures)
		{
			final ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(cf.getCreateName(),
					cf.getCreateDescription(), cf.getCreateImageId(), cf.getCreateLargeImageId());
			connectionCreationToolEntry.addCreateConnectionFeature(cf);
			compartmentEntry.addToolEntry(connectionCreationToolEntry);
		}
		
		return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
		
	}
}
