package de.uks.beast.server.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class ProcBuilderExec {

    void execCommand(List<String> command) {

        try {
            final ProcessBuilder pb = new ProcessBuilder(command);
            final Map<String, String> env = pb.environment();
            final Process process = pb.start();
            
            final InputStream is = process.getInputStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            String line;
            
            while ((line = br.readLine()) != null) {
                // TODO: logger
                System.out.println(line);
            }

            // Wait to get exit value
            try {
                int exitValue = process.waitFor();
                System.out.println("\n\nExit Value is " + exitValue);
            } catch (InterruptedException e) {
                System.err.println("Error.");
            }

        } catch (Exception e) {
            System.out.println("Exception in ProcBuilderExec");
        }
    }

}
