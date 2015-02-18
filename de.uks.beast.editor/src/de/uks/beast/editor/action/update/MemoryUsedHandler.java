package de.uks.beast.editor.action.update;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;
import de.uks.beast.model.Server;

public class MemoryUsedHandler extends DiagramUpdateHandler {

	public MemoryUsedHandler(Diagram diagram, Hardware model) {
		super(diagram, model);
	}

	@Override
	public void updateShape(InstanceInformation info) {
		Server server = model.serverFromHostName(info.getHost());
		System.out.println("Update shape from server " + server.getHost() + ";"
				+ " RAM: " + Long.parseLong(info.getValue()) / (server.getRam() * 1000000) + "%");
	}

}
