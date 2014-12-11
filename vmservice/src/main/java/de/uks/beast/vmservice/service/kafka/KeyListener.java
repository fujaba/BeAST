package de.uks.beast.vmservice.service.kafka;

import java.util.ArrayList;

import de.uks.beast.vmservice.service.model.HasKey;

public interface KeyListener {
	
	@SuppressWarnings("rawtypes")
	public void onNewKeys(ArrayList<HasKey> keys);
	
}
