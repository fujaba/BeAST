package de.uks.beast.api.kafka;

import de.uks.beast.model.InstanceInformation;

public interface KeyListener {

	public String onNewKey(InstanceInformation info);

}
