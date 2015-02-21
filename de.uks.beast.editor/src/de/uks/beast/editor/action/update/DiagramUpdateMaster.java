package de.uks.beast.editor.action.update;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.api.kafka.KeyListener;
import de.uks.beast.editor.action.BeASTAction;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;

public class DiagramUpdateMaster implements KeyListener {

	private static final String LOG = "LOG";
	
	private Diagram diagram;
	private KafkaLogger kafkaLogger;
	private HashMap<String, DiagramUpdateHandler> updateHandler;

	public DiagramUpdateMaster(BeASTAction action, Diagram diagram, Hardware model) {
		this.diagram = diagram;
		this.kafkaLogger = new KafkaLogger(action);
		
		this.updateHandler = new HashMap<String, DiagramUpdateHandler>();
		
		//TODO @Moritz: create List with server pictogram objects and overgive it to MemoryUsedHandler
		//TODO @Moritz: create List with server pictogram objects and overgive it to CPUUsedHandler
		
		//register handler here
		this.updateHandler.put("mem-used", new MemoryUsedHandler(diagram, model));
	}

	@Override
	public String onNewKey(InstanceInformation info) {
		if (info.getKey().equals(LOG)) {
			kafkaLogger.show(info.getValue());
			return "OK";
		}
		
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
