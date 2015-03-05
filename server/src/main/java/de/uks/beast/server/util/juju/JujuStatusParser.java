package de.uks.beast.server.util.juju;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JujuStatusParser {
	
//	parseMachineIds("\"0\": agent-state: started. \"2\": hello. \"3\": hello");
	
	private static final String STR_MACHINES = "machines:";
	private static final String STR_SERVICES = "services:";
	
	private List<Integer> machineIds;
	private int numberOfMachines;
	

	private void parse(String message) {
	}
	
	public static List<Integer> getMachineIdsList(String message) {
		Pattern p = Pattern.compile("\"\\d+\":");
		Matcher m = p.matcher(message);
		List<Integer> ids = new ArrayList<>();
		while (m.find()) {
			ids.add(Integer.parseInt(m.group().replaceAll("[^\\d.]", "")));
		}
		return ids;
	}
	
	public List<Integer> getMachineIds() {
		return machineIds;
	}
	
	public void setMachineIds(List<Integer> machineIds) {
		this.machineIds = machineIds;
	}
	
	private void addMachineId(Integer id) {
		machineIds.add(id);
	}
	
}
