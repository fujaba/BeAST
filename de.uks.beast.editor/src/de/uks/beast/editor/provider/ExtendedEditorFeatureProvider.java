package de.uks.beast.editor.provider;

import static de.uks.beast.editor.util.StringConstants.CASSANDRA;
import static de.uks.beast.editor.util.StringConstants.CASSANDRA_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.CONNECTION_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.HADOOP_CONNECTION;
import static de.uks.beast.editor.util.StringConstants.HADOOP_MASTER;
import static de.uks.beast.editor.util.StringConstants.HADOOP_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.HADOOP_SLAVE;
import static de.uks.beast.editor.util.StringConstants.HARDWARE_ETHERNET;
import static de.uks.beast.editor.util.StringConstants.HARDWARE_LOCATION;
import static de.uks.beast.editor.util.StringConstants.HARDWARE_NETWORK;
import static de.uks.beast.editor.util.StringConstants.HARDWARE_SERVER;
import static de.uks.beast.editor.util.StringConstants.LOCATION_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.MONGO_DB;
import static de.uks.beast.editor.util.StringConstants.MONGO_DB_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.NETWORK;
import static de.uks.beast.editor.util.StringConstants.NETWORK_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.ROUTER;
import static de.uks.beast.editor.util.StringConstants.SERVER;
import static de.uks.beast.editor.util.StringConstants.SERVER_PALETTE_IMAGE;
import static de.uks.beast.editor.util.StringConstants.SERVER_RACK;
import static de.uks.beast.editor.util.StringConstants.SERVER_ROOM;
import static de.uks.beast.editor.util.StringConstants.SERVICE_CASSANDRA;
import static de.uks.beast.editor.util.StringConstants.SERVICE_HADOOP;
import static de.uks.beast.editor.util.StringConstants.SERVICE_MONGODB;

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
import de.uks.beast.editor.services.mongodb.create.CreateMongoDBFeature;
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
				.setName(HARDWARE_LOCATION.text())
				.setIconID(LOCATION_PALETTE_IMAGE.getImageID())
				.addAllCreateObjectFeature(
						new CreateRoomFeature(getFeatureProvider(), SERVER_ROOM.text(), SERVER_ROOM.description()))
				.addCreateObjectFeature(
						new CreateRackFeature(getFeatureProvider(), SERVER_RACK.text(), SERVER_RACK.description()))
				.setInitialOpen(false)
				.build();
		locationEntry.setInitiallyOpen(false);
		
		
		final PaletteCompartmentEntry serverEntry = PaletteCompartmentEntry
				.builder()
				.setName(HARDWARE_SERVER.text())
				.setIconID(SERVER_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateServerFeature(getFeatureProvider(), SERVER.text(), SERVER.description()))
				.setInitialOpen(false)
				.build();
		
		final PaletteCompartmentEntry networkEntry = PaletteCompartmentEntry
				.builder()
				.setName(HARDWARE_NETWORK.text())
				.setIconID(NETWORK_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateNetworkFeature(getFeatureProvider(), NETWORK.text(), NETWORK.description()))
				.addCreateObjectFeature(
						new CreaterRouterFeature(getFeatureProvider(), ROUTER.text(), ROUTER.description()))
				.setInitialOpen(false)
				.build();
		
		final PaletteCompartmentEntry ethernetEntry = PaletteCompartmentEntry
				.builder()
				.setName(HARDWARE_ETHERNET.text())
				.setIconID(CONNECTION_PALETTE_IMAGE.getImageID())
				.addCreateConnectionFeature(
						new CreateConnectionFeature(getFeatureProvider(), StringConstants.CONNECTION.text(),
								StringConstants.CONNECTION.description()))
				.setInitialOpen(false)
				.build();
				
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
								.description()))
				.setInitialOpen(false)
				.build();
				
		final PaletteCompartmentEntry cassandraEntry = PaletteCompartmentEntry
				.builder()
				.setName(SERVICE_CASSANDRA.text())
				.setIconID(CASSANDRA_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateCassandraFeature(getFeatureProvider(), CASSANDRA.text(), CASSANDRA.description()))
				.setInitialOpen(false)
				.build();
		
		final PaletteCompartmentEntry mongoDBEntry = PaletteCompartmentEntry
				.builder()
				.setName(SERVICE_MONGODB.text())
				.setIconID(MONGO_DB_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateMongoDBFeature(getFeatureProvider(), MONGO_DB.text(), MONGO_DB.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		addAllEntries(allEntries, locationEntry, serverEntry, networkEntry, ethernetEntry, hadoopEntry, cassandraEntry,
				mongoDBEntry);
		
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
