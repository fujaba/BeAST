package de.uks.beast.vmservice.service.extract;

import java.util.ArrayList;

import de.uks.beast.vmservice.service.kafka.KeyListener;

public class ExtractorMaster {

	public ArrayList<ExtractorService> services;
	
	public ExtractorMaster(KeyListener listener) {
		this.services = new ArrayList<ExtractorService>();
		
		this.services.add(new NOOPTestService().withListener(listener));
//		this.services.add(new MemoryService().withListener(listener));
//		this.services.add(new CPUService().withListener(listener));
	}

	public ArrayList<ExtractorService> getServices() {
		return services;
	}
	
}
