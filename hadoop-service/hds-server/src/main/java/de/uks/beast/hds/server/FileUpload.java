/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uks.beast.hds.server;

import org.glassfish.jersey.media.multipart.*;

import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author valentyn
 */
@Path("files")
public class FileUpload {
    
    // root directory for file upload.
    // each job should eventualy have a subfolder here.
    private static final String FILES_ROOT_DIR = ""; // TODO add path
    
    // • Send the file first in a multipart/form-data POST, and return an ID to the client. 
    // The client then sends the metadata with the ID, and the server re-associates the file and the metadata.
    // or
    // • Send the metadata first, and return an ID to the client. 
    // The client then sends the file with the ID, and the server re-associates the file and the metadata.
    
//    @POST
////    @Path("/upload")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response fileUpload(
//            @FormDataParam("file") InputStream fis,
//            @FormDataParam("file") FormDataContentDisposition fileDetails,
//            @FormDataParam("path") String path) {
//        
//        return Response.status(Response.Status.OK).entity("File uploaded.").build();
//    }
    
}
