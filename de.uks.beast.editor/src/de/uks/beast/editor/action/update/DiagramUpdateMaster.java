package de.uks.beast.editor.action.update;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.api.kafka.InstanceInformation;
import de.uks.beast.api.kafka.KeyListener;

public class DiagramUpdateMaster implements KeyListener {

	private Diagram diagram;
	private HashMap<String, DiagramUpdateHandler> updateHandler;

	public DiagramUpdateMaster(Diagram diagram) {
		this.diagram = diagram;
		
		this.updateHandler = new HashMap<String, DiagramUpdateHandler>();
	}

	@Override
	public String onNewKey(InstanceInformation info) {
		DiagramUpdateHandler handler = updateHandler.get(info.getKey());
		
		if (handler != null) {
			handler.updateShape(info);
			return "OK";
		} 
		
		return "Could not find handler for key [" + info.getKey() + "]";
	}

	public Diagram getDiagram() {
		return diagram;
	}
	
}
