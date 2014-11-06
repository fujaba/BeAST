package de.uks.beast.api.model;

import java.util.ArrayList;

public class Hardware {

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
