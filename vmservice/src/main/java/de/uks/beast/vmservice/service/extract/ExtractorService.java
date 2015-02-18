package de.uks.beast.vmservice.service.extract;

import java.util.ArrayList;
import java.util.TimerTask;

import org.hyperic.sigar.Sigar;

import de.uks.beast.vmservice.service.kafka.KeyListener;
import de.uks.beast.vmservice.service.model.InstanceInformation;

public abstract class ExtractorService extends TimerTask {

	protected ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
	
	protected Sigar sigar;
	protected String host;
	protected ArrayList<InstanceInformation> keys;
	
	public ExtractorService(String host) {
		this.sigar = new Sigar();
		this.host = host;
		this.keys = new ArrayList<InstanceInformation>();
	}
	
	public abstract void extract();
	
	@Override
	public void run() {
		extract();
		
		for (KeyListener listener : listeners) {
			listener.onNewKeys(keys);
		}
		
	}
	
	public ExtractorService withListener(KeyListener listener) {
        listeners.add(listener);
        return this;
    }
	
	public void addListener(KeyListener listener) {
        listeners.add(listener);
    }
	
	public ArrayList<InstanceInformation> getKeys() {
		return keys;
	}
	
}
