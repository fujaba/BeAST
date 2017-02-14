package de.uks.beast.editor.util;

import java.util.HashMap;
import java.util.Map;

public class NameReminder {

	private static final Map<String, NameFor> MAP = new HashMap<>();

	private NameReminder() {

	}

	public static void add(final String name, final NameFor nameFor) {
		if (!MAP.containsKey(name)) {
			MAP.put(name, nameFor);
		}
	}

	public static boolean nameAlreadySet(final String nameKey, final NameFor nameFor) {
		return MAP.containsKey(nameKey) && MAP.get(nameKey).equals(nameFor);
	}
	
	public static void remove(final String nameKey, final NameFor nameFor) {
		if(nameAlreadySet(nameKey, nameFor)) {
			MAP.remove(nameKey);
		}
	}

	public static enum NameFor {
		SERVER, ROUTER, NETWORK, GROUP;
	}
}
