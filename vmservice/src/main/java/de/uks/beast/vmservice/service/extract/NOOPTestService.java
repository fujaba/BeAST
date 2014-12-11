package de.uks.beast.vmservice.service.extract;

import de.uks.beast.vmservice.service.model.StringStringPair;

public class NOOPTestService extends ExtractorService {

	@Override
	public void extract() {
		this.keys.clear();
		this.keys.add(new StringStringPair("NOOP", "TEST"));
	}

}
