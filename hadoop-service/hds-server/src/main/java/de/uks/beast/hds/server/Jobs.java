package de.uks.beast.hds.server;

import de.uks.beast.hds.common.model.Job;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Root resource (exposed at "jobs" path)
 */
@Path("jobs")
public class Jobs {

    private static final Logger LOG = LoggerFactory.getLogger(Jobs.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String findJobs() {
        LOG.info("List submited jobs.");
        // TODO List submited jobs
        LOG.info("->Got it!");
        return "Got it!";
//        return "List submited jobs.";
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJobById() {
        LOG.info("Find job by id");
        // TODO List submited jobs
        LOG.info("->Got it!");
        return "Got it!";
//        return "List submited jobs.";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String submitJob(final Job job) {
        
        if (job == null) {
            throw new UnsupportedOperationException("No job entered. Unable to submit.");
        }
        
        LOG.info("Submit a new job to run.");
        // TODO Submit a new job to run
        return "Submit a new job to run.";
    }
}
