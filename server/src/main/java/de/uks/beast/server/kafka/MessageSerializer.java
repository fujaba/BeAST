package de.uks.beast.server.kafka;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.uks.beast.model.InstanceInformation;

public class MessageSerializer implements Encoder<InstanceInformation> {

	private ObjectMapper objectMapper;

	public MessageSerializer(VerifiableProperties props) {
		this.objectMapper = new ObjectMapper();
	}
	
	public byte[] toBytes(InstanceInformation msg) {
        try {
            return objectMapper.writeValueAsString(msg).getBytes();
        } catch (JsonProcessingException e) {
        }
        return "".getBytes();
	}
	
}
