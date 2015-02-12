package de.uks.beast.api.kafka;

import java.io.IOException;

import kafka.serializer.Decoder;

public class MessageSerializer implements Decoder<String> {

	@Override
	public String fromBytes(byte[] msg) {
		try {
			return new String(msg, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
