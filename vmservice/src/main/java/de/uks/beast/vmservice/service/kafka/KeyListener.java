package de.uks.beast.vmservice.service.kafka;

import java.util.ArrayList;

import de.uks.beast.vmservice.service.model.InstanceInformation;

public interface KeyListener {
	
	public void onNewKeys(ArrayList<InstanceInformation> keys);
	
}
