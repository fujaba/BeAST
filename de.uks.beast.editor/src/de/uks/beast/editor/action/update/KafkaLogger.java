package de.uks.beast.editor.action.update;

import de.uks.beast.editor.action.BeASTAction;

public class KafkaLogger {

	private BeASTAction action;

	public KafkaLogger(BeASTAction action) {
		this.action = action;
	}
	
	public void show(String value) {
		action.printToConsole(value);
	}

}
