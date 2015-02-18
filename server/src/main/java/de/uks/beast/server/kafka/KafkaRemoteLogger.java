package de.uks.beast.server.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import de.uks.beast.model.InstanceInformation;

public class KafkaRemoteLogger {

	private static final String LOG = "LOG";
	
	private Producer<String, InstanceInformation> producer;
	private String topic;

	public KafkaRemoteLogger(String broker, String topic) {
		this.topic = topic;
		
		Properties props = new Properties();
		 
		props.put("metadata.broker.list", broker.substring(broker.indexOf("/") + 1));
		props.put("serializer.class", "de.uks.beast.server.kafka.MessageSerializer");
		props.put("request.required.acks", "1");
		 
		ProducerConfig config = new ProducerConfig(props);
		producer = new Producer<String, InstanceInformation>(config);
	}

	public void info(String msg) {
		producer.send(new KeyedMessage<String, InstanceInformation>(topic, new InstanceInformation("", LOG, msg)));
	}

}
