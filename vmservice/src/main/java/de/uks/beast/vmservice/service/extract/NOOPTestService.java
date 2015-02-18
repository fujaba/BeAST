package de.uks.beast.vmservice.service.extract;

import de.uks.beast.vmservice.service.model.InstanceInformation;

public class NOOPTestService extends ExtractorService {

	public NOOPTestService(String host) {
		super(host);
	}

	@Override
	public void extract() {
		this.keys.clear();
		this.keys.add(new InstanceInformation(host, "NOOP", "TEST"));
	}

}
