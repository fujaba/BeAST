package de.uks.beast.server.juju;

import de.uks.beast.server.util.RuntimeExec;
import de.uks.beast.server.util.RuntimeOutput;

import java.io.IOException;

public class Juju {
	
    /**
     * Deploy a service.
     *
     * @param servicename
     * @return
     * @throws IOException
     */
    public static RuntimeOutput deploy(String servicename) throws IOException {
        return deploy(servicename, "");
    }

    /**
     * Deploy a service with specified alias.
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @return
     * @throws IOException
     */
    public static RuntimeOutput deploy(String servicename, String alias) throws IOException {
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
    public static RuntimeOutput deploy(String servicename, String alias, int machineNumber) throws IOException {
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
        return -1;
    }
    
    /**
     * Add manual provisioned machine
     * @param userAtHost e.g. [user@]host
     * @return # of the added machine
     * @throws IOException
     * @info http://askubuntu.com/questions/469618/juju-deployment-error-on-manually-provisioned-machine
     */
    public static int addMachine(String userAtHost) throws IOException {
		final RuntimeOutput out = RuntimeExec.run("juju add-machine " + userAtHost);
		String message = out.getMessage();
		if (message.contains("created machine")) {
            return Integer.parseInt(message.replaceAll("[^\\d.]", ""));
        }
        return -1;
	}

}
