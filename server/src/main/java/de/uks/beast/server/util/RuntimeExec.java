package de.uks.beast.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeExec {

    final static Runtime r = Runtime.getRuntime();

    public static int run(String command) throws IOException {
        final Process process = r.exec(command);
        final BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        String line;
        while ((line = is.readLine()) != null) {
            // TODO: logger
            System.out.println(line);
        }

        System.out.flush();
        try {
            process.waitFor(); // wait for process to complete
        } catch (InterruptedException e) {
            System.err.println(e); // Can't Happen
            return process.exitValue();
        }
        System.err.println("Process done, exit status was " + process.exitValue());
        return process.exitValue();
    }
    
}
