package de.uks.beast.vmservice.service.kafka;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.uks.beast.vmservice.service.model.HasKey;

@SuppressWarnings("rawtypes")
public class MessageSerializer implements Encoder<HasKey> {

	public MessageSerializer(VerifiableProperties props) {}
	
	public byte[] toBytes(HasKey msg) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(msg).getBytes();
        } catch (JsonProcessingException e) {
            //TODO
        }
        return "".getBytes();
	}
	
}
