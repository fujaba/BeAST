package de.uks.beast.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valentyn on 27/11/14.
 */
public class Network {

	private String name;
	private String ip;
	private String subnetmask;
	private String gateway;

    private List<Server> servers;

    public String getName() {
		return name;
	}
    
    public String getIp() {
		return ip;
	}
    
    public String getSubnetmask() {
		return subnetmask;
	}
    
    public String getGateway() {
		return gateway;
	}

    public List<Server> getServers() {
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
    
    public void setName(String name) {
		this.name = name;
	}
    
    public void setIp(String ip) {
		this.ip = ip;
	}
    
    public void setSubnetmask(String subnetmask) {
		this.subnetmask = subnetmask;
	}
    
    public void setGateway(String gateway) {
		this.gateway = gateway;
	}
   
}
