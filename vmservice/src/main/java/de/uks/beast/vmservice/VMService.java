package de.uks.beast.vmservice;

import java.util.Timer;

import de.uks.beast.vmservice.service.extract.ExtractorMaster;
import de.uks.beast.vmservice.service.extract.ExtractorService;
import de.uks.beast.vmservice.service.kafka.KafkaWriter;

public class VMService {

	public static void main(String[] args) {
		/*
		 * Extract VM information each [interval] seconds and write into
		 * kafka queue
		 */
		Timer timer = new Timer();
		
		ExtractorMaster em = new ExtractorMaster(new KafkaWriter(args[0], args[1]));
		
		for (ExtractorService service : em.getServices()) {
			timer.schedule(service, 0, 2000);
		}
		
	}
	
}
