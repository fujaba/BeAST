package de.uks.beast.server.environment;

import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

public class OpenstackEnvironment implements BeastEnvironment {

	private OSClient os;

	public OpenstackEnvironment() {
		OSFactory.builder()
				.endpoint("http://127.0.0.1:5000/v2.0")
				.credentials("admin", "sample")
				.tenantName("example-domain")
				.authenticate();
	}

	public void createHardwareDefiniton() {
		Flavor flavor = Builders.flavor()
				.name("Large Resources Template")
				.ram(4096)
				.vcpus(6)
				.disk(120)
				.rxtxFactor(1.2f)
				.build();

		flavor = os.compute().flavors().create(flavor);
	}

	public void startVirutalMachine() {

	}

}
