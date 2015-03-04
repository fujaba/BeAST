package de.uks.beast.server.util.juju;

public class JujuClient {

    /**
     * Deploy a service.
     *
     * @param servicename
     * @return
     */
    public static RuntimeOutput deploy(String servicename) {
        return RuntimeExec.run("juju deploy " + servicename);
    }

    /**
     * Deploy a service with specified alias.
     *
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @return
     */
    public static RuntimeOutput deploy(String servicename, String alias) {
        return RuntimeExec.run("juju deploy " + servicename + " " + alias);
    }

    /**
     * Deploy servicename to a specific machine #.
     *
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @param machineNumber
     * @return
     */
    public static RuntimeOutput deploy(String servicename, int machineNumber) {
        return RuntimeExec.run("juju deploy " + servicename + " --to " + machineNumber);
    }
    
    /**
     * Deploy servicename to a specific machine #.
     *
     * @param servicename
     * @param alias is optional (eg. juju deploy hadoop hadoop-master)
     * @param machineNumber
     * @return
     */
    public static RuntimeOutput deploy(String servicename, String alias, int machineNumber) {
        return RuntimeExec.run("juju deploy " + servicename + " " + alias + " --to " + machineNumber);
    }

    /**
     * Add manual provisioned machine
     *
     * @param userAtHost e.g. [user@]host
     * @return # of the added machine
     * @info
     * http://askubuntu.com/questions/469618/juju-deployment-error-on-manually-provisioned-machine
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
