package de.uks.beast.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valentyn on 27/11/14.
 */
public class Network {

    //
    // Network
    private String networkName;
    private String networkId;
    private boolean adminStateUp;

    //
    // Subnet
    /**
     * You do not have to specify a subnet when you create a network,
     * but if you do not, any attached instance receives an Error status.
     */
    private String subnetName;
    private String subnetId;
    private String subnetIp;
    private String tenantId;

    //
    // Port
    private String portName;
    private String portId;

    //
    // Router

    private List<Server> servers;

    //
    // TODO create network

    //
    // TODO create subnet

    //
    // TODO create a router

    //
    // TODO delete network


    //
    // Accessors
    public String getNetworkName() {
        return networkName;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
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
}
