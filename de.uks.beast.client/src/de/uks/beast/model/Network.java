package de.uks.beast.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valentyn on 27/11/14.
 */
public class Network implements Serializable {

	private static final long serialVersionUID = 6167309346414855709L;
	
	private List<Server> servers;
	private String name;
	private String ip;
	private String subnetmask;
	private String gateway;
	private String dns;

    public Network() {
    	this.servers = new ArrayList<Server>();
    }

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

    public String getDns() {
		return dns;
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
    
    public void setDns(String dns) {
		this.dns = dns;
	}
   
}
