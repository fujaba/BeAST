package de.uks.beast.editor.services.hadoop.provider;

import static de.uks.beast.editor.util.StringConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

import de.uks.beast.editor.features.create.CreateConnectionFeature;
import de.uks.beast.editor.features.create.CreateNetworkFeature;
import de.uks.beast.editor.features.create.CreateRackFeature;
import de.uks.beast.editor.features.create.CreateRoomFeature;
import de.uks.beast.editor.features.create.CreateServerFeature;
import de.uks.beast.editor.features.create.CreaterRouterFeature;
import de.uks.beast.editor.services.cassandra.create.CreateCassandraFeature;
import de.uks.beast.editor.services.hadoop.create.CreateHadoopConnection;
import de.uks.beast.editor.services.hadoop.create.CreateHadoopMasterFeature;
import de.uks.beast.editor.services.hadoop.create.CreateHadoopSlaveFeature;
import de.uks.beast.editor.util.PaletteCompartmentEntry;
import de.uks.beast.editor.util.StringConstants;

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
		final PaletteCompartmentEntry locationEntry = PaletteCompartmentEntry
				.builder()
				.setName("Location")
				.setIconID(LOCATION_PALETTE_IMAGE.getImageID())
				.addAllCreateObjectFeature(
						new CreateRoomFeature(getFeatureProvider(), SERVER_ROOM.text(), SERVER_ROOM.description()))
				.addCreateObjectFeature(
						new CreateRackFeature(getFeatureProvider(), SERVER_RACK.text(), SERVER_RACK.description())).build();
		
		final PaletteCompartmentEntry serverEntry = PaletteCompartmentEntry
				.builder()
				.setName("Server")
				.setIconID(SERVER_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(new CreateServerFeature(getFeatureProvider(), SERVER.text(), SERVER.description()))
				.build();
		
		final PaletteCompartmentEntry networkEntry = PaletteCompartmentEntry
				.builder()
				.setName("Network")
				.setIconID(NETWORK_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(new CreateNetworkFeature(getFeatureProvider(), NETWORK.text(), NETWORK.description()))
				.addCreateObjectFeature(new CreaterRouterFeature(getFeatureProvider(), ROUTER.text(), ROUTER.description()))
				.build();
		
		final PaletteCompartmentEntry ethernetEntry = PaletteCompartmentEntry
				.builder()
				.setName("Ethernet")
				.setIconID(CONNECTION_PALETTE_IMAGE.getImageID())
				.addCreateConnectionFeature(
						new CreateConnectionFeature(getFeatureProvider(), StringConstants.CONNECTION.text(),
								StringConstants.CONNECTION.description())).build();
				
		final PaletteCompartmentEntry hadoopEntry = PaletteCompartmentEntry
				.builder()
				.setName(SERVICE_HADOOP.text())
				.setIconID(HADOOP_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateHadoopMasterFeature(getFeatureProvider(), HADOOP_MASTER.text(), HADOOP_MASTER.description()))
				.addCreateObjectFeature(
						new CreateHadoopSlaveFeature(getFeatureProvider(), HADOOP_SLAVE.text(), HADOOP_SLAVE.description()))
				.addCreateConnectionFeature(
						new CreateHadoopConnection(getFeatureProvider(), HADOOP_CONNECTION.text(), HADOOP_CONNECTION
								.description())).build();
				
		final PaletteCompartmentEntry cassandraEntry = PaletteCompartmentEntry
				.builder()
				.setName(SERVICE_CASSANDRA.text())
				.setIconID(CASSANDRA_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateCassandraFeature(getFeatureProvider(), CASSANDRA.text(), CASSANDRA.description())).build();
		//@formatter:on
		
		allEntries.add(locationEntry);
		allEntries.add(serverEntry);
		allEntries.add(networkEntry);
		allEntries.add(ethernetEntry);
		allEntries.add(hadoopEntry);
		allEntries.add(cassandraEntry);
		
		return allEntries.toArray(new IPaletteCompartmentEntry[allEntries.size()]);
	}
	
}
