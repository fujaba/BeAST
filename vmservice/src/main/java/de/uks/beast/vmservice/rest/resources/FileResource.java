package de.uks.beast.vmservice.rest.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;

@Path("/files")
public class FileResource {
	
	@POST
	@Path("/upload/{sessionID}")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	public Response putFile(@Context HttpServletRequest req, 
							@PathParam("sessionID") String sessionID, 
							@HeaderParam("Content-Disposition") String content, 
							InputStream fis) {
		
		String fileName = content.replace("attachment; filename=", "").replace("\"", "");
		File dir = new File("/tmp/beast/" + sessionID + "/");
		dir.mkdirs();
		File targetFile = new File("/tmp/beast/" + sessionID + "/" + fileName);
		try {
			FileUtils.copyInputStreamToFile(fis, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		return Response.ok().build();
	}
	
}
