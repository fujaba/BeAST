package de.uks.beast.server.util.juju;

import java.io.IOException;

public class JujuClient {
	
    /**
     * Deploy a service.
     *
     * @param servicename
     * @return
     * @throws IOException
     */
    public static RuntimeOutput deploy(String servicename) {
    	 return RuntimeExec.run("juju deploy " + servicename);
    }

    /**
     * Deploy a service with specified subservice.
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @return
     * @throws IOException
     */
    public static RuntimeOutput deploy(String servicename, String subservice) {
        return RuntimeExec.run("juju deploy " + servicename + " " + subservice);
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
    public static RuntimeOutput deploy(String servicename, String subservice, int machineNumber) throws IOException {
        return RuntimeExec.run("juju deploy " + servicename + " " + subservice + " --to " + machineNumber);
    }
    
    /**
     * Add manual provisioned machine
     * @param userAtHost e.g. [user@]host
     * @return # of the added machine
     * @throws IOException
     * @info http://askubuntu.com/questions/469618/juju-deployment-error-on-manually-provisioned-machine
     */
    public static int addMachine(String userAtHost) {
		final RuntimeOutput out = RuntimeExec.run("juju add-machine ssh:" + userAtHost);
		String message = out.getMessage();
		if (message.contains("created machine")) {
            return Integer.parseInt(message.replaceAll("[^\\d.]", ""));
        }
        return -1;
	}

}
