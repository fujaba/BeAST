package de.uks.beast.server.environment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.util.LoggingUtil;

public class OpenstackEnvironment implements BeastEnvironment {

	private static Logger logger = LogManager.getLogger(OpenstackEnvironment.class); 
	
	private OSClient os;
	private BeastService service;

	public OpenstackEnvironment(BeastService service) {
		this.service = service;
		
		try {
			this.os = OSFactory.builder()
					.endpoint(service.get("keystone"))
					.credentials(service.get("admin"), service.get("password"))
					.tenantName(service.get("tenant"))
					.authenticate();
		} catch (Exception e) {
			if (e.getMessage().equals("java.net.ConnectException: Connection refused")) {
				LoggingUtil.fatal(e, "Could not connect to keystone authentication service. Exiting.", logger);
			}
		}
		
	}

	public void createHardwareDefiniton(Hardware hwconf) {
		Flavor flavor = Builders.flavor()
				.name("Large Resources Template")
				.ram(4096)
				.vcpus(6)
				.disk(120)
				.rxtxFactor(1.2f)
				.build();

		flavor = os.compute().flavors().create(flavor);
		
		System.out.println(service);
	}

	public void startVirtualMachine() {

	}

}
