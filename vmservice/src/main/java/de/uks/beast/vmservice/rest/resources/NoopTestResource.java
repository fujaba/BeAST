package de.uks.beast.vmservice.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/noop")
public class NoopTestResource {
	
	@GET
	@Path("/test")
	@Consumes(MediaType.TEXT_PLAIN)
	public String test() {
		return "success!!";
	}
	
}
