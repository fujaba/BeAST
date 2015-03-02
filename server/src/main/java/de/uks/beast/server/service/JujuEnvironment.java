package de.uks.beast.server.service;

import java.util.List;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.vm.InstanceConnection;

public class JujuEnvironment extends ServiceEnvironment {

	public JujuEnvironment(BeastService service) {
		super(service);
	}

	@Override
	public void setup() {
		//TODO bootstrap environment if needed
	}

	@Override
	public void setupInstances(List<? extends ConnectionInfo> cons) {
		for (ConnectionInfo connectionInfo : cons) { //TODO async
			//connect to instance and add juju key
			InstanceConnection con = new InstanceConnection(service.getRemoteLogger(), connectionInfo);
			con.authenticate();
			con.insertKeyToAuthorizedKeys(service.get("juju-public-key"));
			
			//connect to instance and install juju agent
			
		}
	}
	
	@Override
	public void startService(String serviceName, List<String> constraints) {
		//start service on given machine 
	}

}
