package de.uks.beast.server.environment;

import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;

public class OpenstackEnvironment implements BeastEnvironment {

	private OSClient os;
	private BeastService service;

	public OpenstackEnvironment(BeastService service) {
		this.service = service;
		
		this.os = OSFactory.builder()
			.endpoint(service.get("keystone"))
			.credentials(service.get("admin"), service.get("password"))
			.tenantName(service.get("tenant"))
			.authenticate();
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
