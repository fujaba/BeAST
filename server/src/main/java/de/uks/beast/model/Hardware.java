package de.uks.beast.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hardware implements Serializable {

	private static final long serialVersionUID = 4032538762740451821L;

	private List<Network> networks;

	public Hardware() {
		this.networks = new ArrayList<>();
	}

	//
	// Accessors

	//
	public List<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}

	public void addToNetworks(Network network) {
		this.networks.add(network);
	}
}
