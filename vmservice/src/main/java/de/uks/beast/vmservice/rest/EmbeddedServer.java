package de.uks.beast.vmservice.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;

import de.uks.beast.vmservice.service.kafka.KafkaWriter;

public class EmbeddedServer extends Thread {

	private KafkaWriter writer;

	public EmbeddedServer(KafkaWriter writer) {
		this.writer = writer;
	}

	@Override
	public void run() {
		startRESTServer();
	}
	
	public void startRESTServer() {
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server jettyServer = new Server(1143);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(
				org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, "de.uks.beast.vmservice.rest.resources");

		try {
			jettyServer.start();
			writer.info("Started REST server");
			jettyServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jettyServer.destroy();
		}
	}
	
}
