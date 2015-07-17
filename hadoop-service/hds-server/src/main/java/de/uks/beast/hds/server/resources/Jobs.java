package de.uks.beast.hds.server.resources;

import de.uks.beast.hds.common.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



/**
 * Root resource (exposed at "jobs" path)
 *
 * @author unik
 */
@Path("jobs")
public class Jobs {

    private static final Logger LOG = LoggerFactory.getLogger(Jobs.class);

    
    /**
     * List submitted jobs.
     * @return 
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String findJobs() {
        LOG.info("List submited jobs.");
        // TODO List submited jobs
        return "Got it!"; // for the test-case sake.
//        return "List submited jobs.";
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
}
