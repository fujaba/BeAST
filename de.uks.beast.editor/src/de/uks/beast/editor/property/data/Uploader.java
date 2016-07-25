package de.uks.beast.editor.property.data;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.Status;

import de.uks.beast.editor.job.Job;

public class Uploader
{
	private Job	job;


	private Uploader(final Job job) {
		this.job = job;
	}
	
	public static Status upload(final Job job) {
		return new Uploader(job).run();
	}
	
	
	private Status run() {
		/*LOG.info("Uploading new job file.");
	    String FILE = "/thinkdifferent.zip";
	    URL url = this.getClass().getResource(FILE);
	    File data = new File(url.getFile());
	    

	    LOG.info("OK. The file is here.");

	    MultiPart multiPart = new MultiPart();
	    multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

	    FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file", data, MediaType.APPLICATION_OCTET_STREAM_TYPE);
	    multiPart.bodyPart(fileDataBodyPart);

	    Response response = target.path("jobs").path("upload").request().post(
	            Entity.entity(multiPart, multiPart.getMediaType()));

	    LOG.info("upload response status: {}", response.getStatus());
//	    LOG.info("{} :: {}", response.getStatusInfo(), response);*/
	    
	    return null;
	}
	
	
	
	
	
}
