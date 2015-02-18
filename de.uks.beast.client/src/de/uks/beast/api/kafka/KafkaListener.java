package de.uks.beast.api.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.uks.beast.model.InstanceInformation;

public class KafkaListener extends Thread {

	private static Logger logger = LogManager.getLogger(KafkaListener.class);
	
	private ObjectMapper mapper;
	private KeyListener listener;
	private ConsumerConnector consumer;
	private String topic;

	public KafkaListener(KeyListener listener, String zookeeper, String topic) {
		this.mapper = new ObjectMapper();
		this.listener = listener;
		this.topic = topic;
		String groupID = "de.uks.beast";
		
		Properties props = new Properties();
		props.put("zookeeper.connect", zookeeper);
		props.put("group.id", groupID);
		props.put("serializer.class", "de.uks.beast.api.kafka.MessageSerializer");
		props.put("zk.sessiontimeout.ms", "400");
		props.put("zk.synctime.ms", "200");
		this.consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
	}
	
	@Override
	public void run() {
		pollChannel();
	}

	public void pollChannel() {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, new Integer(1));
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer
				.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		while (it.hasNext()) {
			listener.onNewKey(readMessage(it));
		}
		
		logger.info("should not happen");
	}

	private InstanceInformation readMessage(ConsumerIterator<byte[], byte[]> it) {
		MessageAndMetadata<byte[], byte[]> next = it.next();
		try {
			return mapper.readValue(next.message(), InstanceInformation.class);
		} catch (Exception e) {
			logger.error("Could not parse event", e);
			System.exit(0);
		}
		return null;
	}
}
