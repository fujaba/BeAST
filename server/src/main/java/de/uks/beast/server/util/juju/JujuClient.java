package de.uks.beast.server.util.juju;

import java.util.List;

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
     * @return # of the added machine or -1 if failed.
     * @info
     * http://askubuntu.com/questions/469618/juju-deployment-error-on-manually-provisioned-machine
     */
    public static int addMachine(String userAtHost) {
    	final List<Integer> before = JujuStatusParser.getMachineIdsList(status().getMessage());
        RuntimeExec.run("juju add-machine ssh:" + userAtHost);
        final List<Integer> after = JujuStatusParser.getMachineIdsList(status().getMessage());
        
        after.removeAll(before);
        
        if (after.size() == 1) {
            return after.get(0);
        }

        return -1;
    }
    
    /**
     * destroy machine #
     * @return
     */
    public static RuntimeOutput destroyMachine(int number) {
    	return RuntimeExec.run("juju destroy-machine " + number);
    }
    
    /**
     * Add a relation between two services
     * @param service1: &lt;service1&gt;[:&lt;relation name1&gt;], e.g. hadoop-master:namenode
     * @param service2: &lt;service2&gt;[:&lt;relation name2&gt;], e.g. hadoop-slave:datanode
     * <p>
     * usage: juju add-relation [options] &lt;service1&gt;[:&lt;relation name1&gt;] &lt;service2&gt;[:&lt;relation name2&gt;] </br>
     * example 1: juju add-relation hadoop-master:namenode hadoop-slave:datanode </br>
	 * example 2: juju add-relation hadoop-master:jobtracker hadoop-slave:tasktracker </br>
	 * </p>
     * @return
     */
    public static RuntimeOutput addRelation(String service1, String service2) {
    	return RuntimeExec.run("juju add-relation " + service1 + " " + service2);
    }
    
    /**
     * Remove a relation between two services
     * @param service1
     * @param service2
     */
    public static void destroyRelation(String service1,String service2) {
    	RuntimeExec.run("juju destroy-relation " + service1 + " " + service2);
    }
    
    /**
     * Shows what's going on
     * @return
     */
    public static RuntimeOutput status() {
    	return RuntimeExec.run("juju status");
    }
    
    /**
     * Explicitly make service publically available
     * @param servicename
     */
    public static void expose(String servicename) {
    	RuntimeExec.run("juju expose " + servicename);
    }
    
    /**
     * Return the firewall settings and make a service non-public again
     * @param servicename
     */
    public static void unexpose(String servicename) {
    	RuntimeExec.run("juju unexpose " + servicename);
    }

}
