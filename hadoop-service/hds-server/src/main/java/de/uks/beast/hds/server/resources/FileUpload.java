/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uks.beast.hds.server.resources;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

/**
 *
 * @author valentyn
 */

@Path("fileupload")
public class FileUpload {

    // root directory for file upload.
    // each job should eventualy have a subfolder here.
    // TODO set root directory for the zip file
    private static final String TARGET_FILES_ROOT_DIR = "/tmp/";

    // • Send the file first in a multipart/form-data POST, and return an ID to the client. 
    // The client then sends the metadata with the ID, and the server re-associates the file and the metadata.
    // or
    // • Send the metadata first, and return an ID to the client. 
    // The client then sends the file with the ID, and the server re-associates the file and the metadata.
    // http://localhost:8080/myapp/files/upload

    @POST /*@Path("upload")*/
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response fileUpload(
            @FormDataParam("file") InputStream fis,
            @FormDataParam("file") FormDataContentDisposition fileDetails,
            @FormDataParam("path") String path) {

        final String destinationFileLocation = TARGET_FILES_ROOT_DIR + fileDetails.getFileName();
//        System.out.println("**** [path]: " + path);

        System.out.println("**** [DESTINATION]: " + fileDetails.getFileName());
        
        // save received file to local storage
        saveToDisk(fis, destinationFileLocation);

        // TODO unzip file to specified targets
        
        return Response.status(Response.Status.OK).entity("File uploaded to: " + destinationFileLocation).build();
    }

    private void saveToDisk(InputStream uploadedInputStream, String uploadedFileLocation) {

        try {
            OutputStream out; // = new FileOutputStream(new File(uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
