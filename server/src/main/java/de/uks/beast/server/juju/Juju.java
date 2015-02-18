package de.uks.beast.server.juju;

import de.uks.beast.server.util.RuntimeExec;
import java.io.IOException;

public class Juju {
    
    // First step to initialize the juju environment.
    public void bootstrap() throws IOException {
        RuntimeExec.run("juju bootstrap");
    }
    
    // Basic steps to intitialize hadoop.
    public void deployHadoop() throws IOException {
        RuntimeExec.run("juju deploy hadoop hadoop-master");
        RuntimeExec.run("juju deploy hadoop hadoop-slave");
        
        // Define the relationships between the master and slave:
        RuntimeExec.run("juju add-relation hadoop-master:namenode hadoop-slave:datanode");
        RuntimeExec.run("juju add-relation hadoop-master:jobtracker hadoop-slave:tasktracker");
    }
    
}
