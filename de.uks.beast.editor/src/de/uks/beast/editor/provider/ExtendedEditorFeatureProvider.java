package de.uks.beast.editor.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

import de.uks.beast.editor.feature.create.CreateConnectionFeature;
import de.uks.beast.editor.feature.create.CreateNetworkFeature;
import de.uks.beast.editor.feature.create.CreateRackFeature;
import de.uks.beast.editor.feature.create.CreateRoomFeature;
import de.uks.beast.editor.feature.create.CreateServerFeature;
import de.uks.beast.editor.feature.create.CreaterRouterFeature;
import de.uks.beast.editor.service.services.apache2.create.CreateApache2Feature;
import de.uks.beast.editor.service.services.cassandra.create.CreateCassandraFeature;
import de.uks.beast.editor.service.services.hadoop.create.CreateHadoopMasterFeature;
import de.uks.beast.editor.service.services.hadoop.create.CreateHadoopSlaveFeature;
import de.uks.beast.editor.service.services.jenkins.create.CreateJenkinsFeature;
import de.uks.beast.editor.service.services.mediawiki.create.CreateMediaWikiFeature;
import de.uks.beast.editor.service.services.mongodb.create.CreateMongoDBFeature;
import de.uks.beast.editor.service.services.mysql.create.CreateMySqlFeature;
import de.uks.beast.editor.service.services.relation.create.CreateServiceRelation;
import de.uks.beast.editor.service.services.tomcat.create.CreateTomcatFeature;
import de.uks.beast.editor.service.services.ubuntu.create.CreateUbuntuFeature;
import de.uks.beast.editor.service.services.wordpress.create.CreateWordPressFeature;
import de.uks.beast.editor.util.Images;
import de.uks.beast.editor.util.PaletteCompartmentEntry;
import static de.uks.beast.editor.util.Strings.*;

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
				.setName(LOCATION.text())
				.setIconID(Images.LOCATION_PALETTE_IMAGE.getImageID())
				.addAllCreateObjectFeature(
						new CreateRoomFeature(getFeatureProvider(), SERVER_ROOM.text(), SERVER_ROOM.description()))
				.addCreateObjectFeature(
						new CreateRackFeature(getFeatureProvider(), SERVER_RACK.text(), SERVER_RACK.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry serverEntry = PaletteCompartmentEntry
				.builder()
				.setName(SERVER.text())
				.setIconID(Images.SERVER_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateServerFeature(getFeatureProvider(), SERVER.text(), SERVER.description()))
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
				.addCreateObjectFeature(
						new CreaterRouterFeature(getFeatureProvider(), ROUTER.text(), ROUTER.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry ethernetEntry = PaletteCompartmentEntry
				.builder()
				.setName(ETHERNET.text())
				.setIconID(Images.CONNECTION_PALETTE_IMAGE.getImageID())
				.addCreateConnectionFeature(
						new CreateConnectionFeature(getFeatureProvider(), CONNECTION.text(),
								CONNECTION.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry serviceRelationEntry = PaletteCompartmentEntry
				.builder()
				.setName(SERVICE_RELATION.text())
				.setIconID(Images.SERVICE_RELATION.getImageID())
				.addCreateConnectionFeature(
						new CreateServiceRelation(getFeatureProvider(), SERVICE_RELATION.serviceName(), SERVICE_RELATION
										.description()))
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
		final PaletteCompartmentEntry cassandraEntry = PaletteCompartmentEntry
				.builder()
				.setName(CASSANDRA.text())
				.setIconID(Images.CASSANDRA_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateCassandraFeature(getFeatureProvider(), CASSANDRA.text(), CASSANDRA.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry mongoDBEntry = PaletteCompartmentEntry
				.builder()
				.setName(MONGO_DB.text())
				.setIconID(Images.MONGO_DB_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateMongoDBFeature(getFeatureProvider(), MONGO_DB.text(), MONGO_DB.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry mySqlEntry = PaletteCompartmentEntry
				.builder()
				.setName(MYSQL.text())
				.setIconID(Images.MYSQL_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateMySqlFeature(getFeatureProvider(), MYSQL.text(), MYSQL.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry wordPressEntry = PaletteCompartmentEntry
				.builder()
				.setName(WORDPRESS.text())
				.setIconID(Images.WORDPRESS_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateWordPressFeature(getFeatureProvider(), WORDPRESS.text(), WORDPRESS.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry ubuntuEntry = PaletteCompartmentEntry
				.builder()
				.setName(UBUNTU.text())
				.setIconID(Images.UBUNTU_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateUbuntuFeature(getFeatureProvider(), UBUNTU.text(), UBUNTU.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry apache2Entry = PaletteCompartmentEntry
				.builder()
				.setName(APACHE2.text())
				.setIconID(Images.APACHE2_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateApache2Feature(getFeatureProvider(), APACHE2.text(), APACHE2.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry jenkinsEntry = PaletteCompartmentEntry
				.builder()
				.setName(JENKINS.text())
				.setIconID(Images.JENKINS_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateJenkinsFeature(getFeatureProvider(), JENKINS.text(), JENKINS.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry mediaWikiEntry = PaletteCompartmentEntry
				.builder()
				.setName(MEDIAWIKI.text())
				.setIconID(Images.MEDIAWIKI_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateMediaWikiFeature(getFeatureProvider(), MEDIAWIKI.text(), MEDIAWIKI.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		final PaletteCompartmentEntry tomcatEntry = PaletteCompartmentEntry
				.builder()
				.setName(TOMCAT.text())
				.setIconID(Images.TOMCAT_PALETTE_IMAGE.getImageID())
				.addCreateObjectFeature(
						new CreateTomcatFeature(getFeatureProvider(), TOMCAT.text(), TOMCAT.description()))
				.setInitialOpen(false)
				.build();
		//@formatter:on
		
		//@formatter:off
		addAllEntries(
				allEntries, 
				locationEntry, 
				serverEntry, 
				networkEntry, 
				ethernetEntry, 
				serviceRelationEntry,
				hadoopEntry, 
				cassandraEntry,
				mongoDBEntry,
				mySqlEntry,
				wordPressEntry,
				ubuntuEntry, 
				apache2Entry,
				jenkinsEntry,
				mediaWikiEntry,
				tomcatEntry);
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
