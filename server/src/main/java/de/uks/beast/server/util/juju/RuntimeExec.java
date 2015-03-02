package de.uks.beast.server.util.juju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeExec {

	final static Runtime r = Runtime.getRuntime();

	public static RuntimeOutput run(String command) {
		Process process = null;
		StringBuilder sb = new StringBuilder();

		try {
			process = r.exec(command);
			final BufferedReader is = new BufferedReader(new InputStreamReader(
					process.getInputStream()));

			String line;
			while ((line = is.readLine()) != null) {
				// System.out.println(line);
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.flush();
		try {
			process.waitFor(); // wait for process to complete
		} catch (InterruptedException e) {
			System.err.println(e); // Can't Happen
			return new RuntimeOutput(process.exitValue(), "Execution failed.");
		}
		System.err.println("Process done, exit status was "
				+ process.exitValue());

		return new RuntimeOutput(process.exitValue(), sb.toString());
	}

}
