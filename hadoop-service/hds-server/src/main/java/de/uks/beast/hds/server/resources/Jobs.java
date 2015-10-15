package de.uks.beast.hds.server.resources;

import de.uks.beast.hds.common.model.Job;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.*;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Root resource (exposed at "jobs" path)
 *
 * @author unik
 */
@Path("jobs")
public class Jobs {

    private static final Logger LOG = LoggerFactory.getLogger(Jobs.class);
    private static final String TARGET_FILES_ROOT_DIR = "/tmp/";
    private static final String JOBFILE_PREFIX = "beastjob_";
    
    /**
     * List submitted jobs.
     * @return
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findJobs() {
        LOG.info("List submited jobs.");
        java.nio.file.Path dir = Paths.get(TARGET_FILES_ROOT_DIR);
        final List<String> joblist = new ArrayList();
        // filter: show only files with 'JOBFILE_PREFIX' and of mime type 'application/zip'
        try (DirectoryStream<java.nio.file.Path> stream = Files.newDirectoryStream(dir, (JOBFILE_PREFIX + "*.zip"))) {
            for (java.nio.file.Path file: stream) {
                joblist.add(file.toString());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
        final GenericEntity<List<String>> entity = new GenericEntity<List<String>>(joblist) {};
        return Response.ok(entity).build();
    }
    
    /**
     * Get the job by provided id.
     * @param id
     * @return 
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJobById(@PathParam("id") String id) {
        LOG.info("Find job by id");
        // TODO List submited jobs
        return "Got it!";
//        return "List submited jobs.";
    }
    
    /**
     * Get the job status by provided id.
     * @param id
     * @return 
     */
    @GET
    @Path("{id}/status")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJobStatusById(@PathParam("id") String id) {
        LOG.info("Get the status of job by its id");
        return "Get the status of job by its id";
    }

    /**
     * Submit the job.
     * @param job
     * @return 
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String submitJob(final Job job) {
        
        if (job == null) {
			LOG.debug("Cannot submit a job because no valid Job provided.");
            return Response.status(Status.NOT_FOUND).build().toString();
        }
        
        LOG.info("Submit a new job to run.");
        // TODO handle job submition.
        return "Submit a new job to run.";
    }
    
    /**
     * Delete submitted job by provided id.
     * @param id
     * @return 
     */
    @DELETE
    @Path("{id}")
    public String deleteJobById(@PathParam("id") String id) {
        LOG.info("Delete the job with the id: " + id);
        return "Delete the job with the id";
    }

    /**
     * Upload job file (ZIP).
     * @param fis
     * @param fileDetails
     * @param path
     * @return
     */
    @POST @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response fileUpload(
            @FormDataParam("file") InputStream fis,
            @FormDataParam("file") FormDataContentDisposition fileDetails,
            @FormDataParam("path") String path) {

        final String destinationFileLocation = TARGET_FILES_ROOT_DIR + JOBFILE_PREFIX + fileDetails.getFileName();
//        try {
//            Files.createDirectories(Paths.get("/tmp/bjob_" + fileDetails.getFileName()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // save received file to local storage
        saveToDisk(fis, destinationFileLocation);

        // TODO unzip file to specified targets

        return Response.ok().entity("File uploaded to: " + destinationFileLocation).build();
    }


    /*
     * Helper
     */
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
