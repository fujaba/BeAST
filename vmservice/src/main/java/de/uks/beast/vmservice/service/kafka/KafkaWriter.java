package de.uks.beast.vmservice.service.kafka;

import java.util.ArrayList;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import de.uks.beast.vmservice.service.model.HasKey;

@SuppressWarnings("rawtypes")
public class KafkaWriter implements KeyListener {

	private Producer<String, HasKey> producer;
	private String topic;

	public KafkaWriter(String broker, String topic) {
		this.topic = topic;
		
		Properties props = new Properties();
		 
		props.put("metadata.broker.list", broker);
		props.put("serializer.class", "de.uks.beast.vmservice.service.kafka.MessageSerializer");
		props.put("request.required.acks", "1");
		 
		ProducerConfig config = new ProducerConfig(props);
		producer = new Producer<String, HasKey>(config);
	}

	public void onNewKeys(ArrayList<HasKey> keys) {
		for (HasKey key : keys) {
			producer.send(new KeyedMessage<String, HasKey>(topic, key));
		}
	}

}
