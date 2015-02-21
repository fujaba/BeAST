package de.uks.beast.server.juju;

import de.uks.beast.server.util.RuntimeExec;
import de.uks.beast.server.util.RuntimeOutput;

import java.io.IOException;

public class Juju {

	// First step to initialize the juju environment.
    // public void bootstrap() throws IOException {
    // RuntimeExec.run("juju bootstrap");
    // }
	// Basic steps to intitialize hadoop.
    // public void deployHadoop() throws IOException {
    // RuntimeExec.run("juju deploy hadoop hadoop-master");
    // RuntimeExec.run("juju deploy hadoop hadoop-slave");
    //
    // // Define the relationships between the master and slave:
    // RuntimeExec.run("juju add-relation hadoop-master:namenode hadoop-slave:datanode");
    // RuntimeExec.run("juju add-relation hadoop-master:jobtracker hadoop-slave:tasktracker");
    // }
	
    /**
     * Deploy a service.
     *
     * @param servicename
     * @return
     * @throws IOException
     */
    public RuntimeOutput deploy(String servicename) throws IOException {
        return deploy(servicename, "");
    }

    /**
     * Deploy a service with specified alias.
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @return
     * @throws IOException
     */
    public RuntimeOutput deploy(String servicename, String alias) throws IOException {
        return RuntimeExec.run("juju deploy " + alias);
    }

    /**
     * Deploy servicename to a specific machine #.
     *
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @param machineNumber
     * @return
     * @throws IOException
     */
    public RuntimeOutput deploy(String servicename, String alias, int machineNumber) throws IOException {
        return RuntimeExec.run("juju deploy " + servicename + alias + "--to " + machineNumber);
    }

    /**
     * Add a blank machine that you can mess with
     *
     * @return # of created machine
     * @throws IOException
     */
    public static int addMachine() throws IOException {
        final RuntimeOutput out = RuntimeExec.run("juju add-machine");
        String message = out.getMessage();
        if (message.contains("created machine")) {
            return Integer.parseInt(message.replaceAll("[^\\d.]", ""));
        }
        return 0;
    }

}
