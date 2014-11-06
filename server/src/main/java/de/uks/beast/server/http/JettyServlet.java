package de.uks.beast.server.http;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.eclipse.jetty.server.Server;

public class JettyServlet implements Daemon {

	public static void main(String[] args) {
		Server server = new Server(9999);
		
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void destroy() {
		
	}

	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		
	}

	public void start() throws Exception {
		main(null);
	}

	public void stop() throws Exception {
		
	}
	
}
