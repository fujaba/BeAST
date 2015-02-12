package de.uks.beast.vmservice.service.kafka;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.uks.beast.vmservice.service.model.HasKey;

@SuppressWarnings("rawtypes")
public class MessageSerializer implements Encoder<HasKey> {

	private ObjectMapper objectMapper;

	public MessageSerializer(VerifiableProperties props) {
		this.objectMapper = new ObjectMapper();
	}
	
	public byte[] toBytes(HasKey msg) {
        try {
            return objectMapper.writeValueAsString(msg).getBytes();
        } catch (JsonProcessingException e) {
            //TODO
        }
        return "".getBytes();
	}
	
}
