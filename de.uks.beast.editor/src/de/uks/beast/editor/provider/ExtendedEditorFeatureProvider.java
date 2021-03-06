package de.uks.beast.editor.provider;

import static de.uks.beast.editor.util.Strings.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

import de.uks.beast.editor.feature.create.CreateConnectionFeature;
import de.uks.beast.editor.feature.create.CreateControlCenterFeature;
import de.uks.beast.editor.feature.create.CreateNetworkFeature;
import de.uks.beast.editor.feature.create.CreateHadoopMasterFeature;
import de.uks.beast.editor.feature.create.CreateHadoopSlaveFeature;
import de.uks.beast.editor.util.Images;
import de.uks.beast.editor.util.PaletteCompartmentEntry;

public class ExtendedEditorFeatureProvider extends DefaultToolBehaviorProvider
{
	
	public ExtendedEditorFeatureProvider(final IDiagramTypeProvider diagramTypeProvider)
	{
		super(diagramTypeProvider);
	}
	
	
	
	@Override
	public IPaletteCompartmentEntry[] getPalette()
	{
		final List<IPaletteCompartmentEntry> allEntries = new ArrayList<IPaletteCompartmentEntry>();
		
		//@formatter:off
				final PaletteCompartmentEntry controlCenterEntry = PaletteCompartmentEntry
						.builder()
						.setName(CONTROL_CENTER.text())
						.setIconID(Images.CONTROL_CENTER_PALETTE_IMAGE.getImageID())
						.addCreateObjectFeature(
								new CreateControlCenterFeature(getFeatureProvider(), CONTROL_CENTER.text(), CONTROL_CENTER.description()))
						.setInitialOpen(false)
						.build();
				//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry networkEntry = PaletteCompartmentEntry
				.builder()
				.setName(NETWORK.text())
				.setIconID(Images.NETWORK_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateNetworkFeature(getFeatureProvider(), NETWORK.text(), NETWORK.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry connectionEntry = PaletteCompartmentEntry
				.builder()
				.setName(CONNECTION.text())
				.setIconID(Images.CONNECTION_PALETTE_IMAGE.getImageID())
				.addCreateConnectionFeature(
						new CreateConnectionFeature(getFeatureProvider(), CONNECTION.text(),
								CONNECTION.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry hadoopEntry = PaletteCompartmentEntry
				.builder()
				.setName(HADOOP.text())
				.setIconID(Images.HADOOP_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateHadoopMasterFeature(getFeatureProvider(), HADOOP_MASTER.text(), HADOOP_MASTER.description()))
				.addCreateObjectFeature(
						new CreateHadoopSlaveFeature(getFeatureProvider(), HADOOP_SLAVE.text(), HADOOP_SLAVE.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		addAllEntries(
				allEntries, 
				networkEntry, 
				connectionEntry, 
				hadoopEntry,
				controlCenterEntry);
		//@formatter:on
		
		return allEntries.toArray(new IPaletteCompartmentEntry[allEntries.size()]);
	}
	
	
	
	private void addAllEntries(final List<IPaletteCompartmentEntry> entryList, final PaletteCompartmentEntry... entries)
	{
		for (final PaletteCompartmentEntry entry : entries)
		{
			if (entry != null)
			{
				entryList.add(entry);
			}
		}
	}
	
}
