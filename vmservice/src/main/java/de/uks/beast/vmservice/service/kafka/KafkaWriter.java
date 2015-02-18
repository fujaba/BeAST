package de.uks.beast.vmservice.service.kafka;

import java.util.ArrayList;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import de.uks.beast.vmservice.service.model.InstanceInformation;

public class KafkaWriter implements KeyListener {

	private Producer<String, InstanceInformation> producer;
	private String topic;

	public KafkaWriter(String broker, String topic) {
		this.topic = topic;
		
		Properties props = new Properties();
		 
		props.put("metadata.broker.list", broker);
		props.put("serializer.class", "de.uks.beast.vmservice.service.kafka.MessageSerializer");
		props.put("request.required.acks", "1");
		 
		ProducerConfig config = new ProducerConfig(props);
		producer = new Producer<String, InstanceInformation>(config);
	}

	public void onNewKeys(ArrayList<InstanceInformation> keys) {
		for (InstanceInformation key : keys) {
			producer.send(new KeyedMessage<String, InstanceInformation>(topic, key));
		}
	}

}
