package de.uks.beast.model;

/**
 * Created by valentyn on 02/12/14.
 */
public class NetworkCreator {

    protected Network network = new Network();

    public NetworkCreator withName(String networkName) {
        network.setNetworkName(networkName);
        return this;
    }

    public Network buid() {
        return network;
    }
}
