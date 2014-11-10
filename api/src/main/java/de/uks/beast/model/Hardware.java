package de.uks.beast.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Hardware implements Serializable {

	private static final long serialVersionUID = 4032538762740451821L;

	private ArrayList<Server> servers;
	
	public Hardware() {
		this.servers = new ArrayList<Server>();
	}
	
	public ArrayList<Server> getServers() {
		return servers;
	}
	
	public void setServers(ArrayList<Server> servers) {
		this.servers = servers;
	}
	
	public void addToServer(Server server) {
		if (!this.servers.contains(server)) {
			this.servers.add(server);
		}
	}
	
}
