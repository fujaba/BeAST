package de.uks.beast.vmservice;

import java.util.Timer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.vmservice.rest.EmbeddedServer;
import de.uks.beast.vmservice.service.extract.ExtractorMaster;
import de.uks.beast.vmservice.service.extract.ExtractorService;
import de.uks.beast.vmservice.service.kafka.KafkaWriter;

public class VMService {

	private static Logger logger = LogManager.getLogger(VMService.class);
			
	public static void main(String[] args) {
		/*
		 * Extract VM information each [interval] seconds and write into
		 * kafka queue
		 */
		logger.info("Started VM service");
		Timer timer = new Timer();

		ExtractorMaster em = new ExtractorMaster(args[0], new KafkaWriter(args[1], args[2]));
		
		for (ExtractorService service : em.getServices()) {
			timer.schedule(service, 0, 2000);
		}
		
		new EmbeddedServer().startRESTServer();
	}
	
}
