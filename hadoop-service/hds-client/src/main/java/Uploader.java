import com.sun.net.httpserver.HttpServer;

import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import java.io.File;
import java.nio.file.Path;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Valentyn Kukushkin.
 */
public class Uploader {

    private WebTarget target = null;
    public static final String BASE_URI = "http://localhost:8080/myapp/";


    public Uploader() {
        Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

        // URI to the server
        target = client.target(BASE_URI);
    }

    // create the client

    public void upload(Path filePath) {
//        LOG.info("Uploading new job file.");
//        String FILE = "/thinkdifferent.zip";
//        URL url = this.getClass().getResource(filePath);
        File data = filePath.toFile();

//        LOG.info("OK. The file is here.");

        MultiPart multiPart = new MultiPart();
        multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file", data, MediaType.APPLICATION_OCTET_STREAM_TYPE);
        multiPart.bodyPart(fileDataBodyPart);

        Response response = target.path("jobs").path("upload").request().post(
                Entity.entity(multiPart, multiPart.getMediaType()));

//        LOG.info("Uploader response status: {}", response.getStatus());
//        LOG.info("{} :: {}", response.getStatusInfo(), response);
    }
}
