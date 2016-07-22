package de.uks.beast.editor.property.data;

import java.io.File;
import java.net.URL;

public class Uploader
{
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
//    LOG.info("{} :: {}", response.getStatusInfo(), response);*/
	
}
