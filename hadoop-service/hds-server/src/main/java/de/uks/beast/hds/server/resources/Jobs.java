package de.uks.beast.hds.server.resources;

import de.uks.beast.hds.common.model.Job;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



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
            throw new UnsupportedOperationException("No job to submit.");
        }
        
        LOG.info("Submit a new job to run.");
        // TODO Submit a new job to run
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
