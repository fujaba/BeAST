package de.uks.beast.hds.server;

import de.uks.beast.hds.server.resources.FileUpload;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URL;
import java.util.List;

public class JobsTest extends JerseyTest {

    private static final Logger LOG = LoggerFactory.getLogger(JobsTest.class);

    private HttpServer server;
    private WebTarget target;

    @Before public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
//        Client client = ClientBuilder.newClient();
        Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // client.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = client.target(Main.BASE_URI);
        LOG.info("Service Base URI: {}", target.getUri());
    }

    @After public void tearDown() throws Exception {
        server.stop();
    }


    @Override protected Application configure() {
        return new ResourceConfig(FileUpload.class);
    }

    @Override protected void configureClient(ClientConfig clientConfig) {
        clientConfig.register(MultiPartFeature.class);
    }

    /*@Ignore
    @Test public void testFileUpload() {
        System.out.println("**** Start file upload");

        // source file
        String FILE = "/thinkdifferent.zip";
        URL url = this.getClass().getResource(FILE);
        File data = new File(url.getFile());

        // source file exists
        System.out.println("**** [source file exists]: " + data.exists());

        MultiPart multiPart = new MultiPart();
        multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file", data, MediaType.APPLICATION_OCTET_STREAM_TYPE);
        multiPart.bodyPart(fileDataBodyPart);
//        fileDataBodyPart.setContentDisposition(FormDataContentDisposition.name("file.zip").fileName(FILE).build());


        Response response = target.path("fileupload").request().post(
                Entity.entity(multiPart, multiPart.getMediaType()));

        System.out.println("**** upload response status: " + response.getStatus());
        System.out.println("**** " + response.getStatusInfo() + " " + response);

        response.close();
    }*/

    @Test public void testUpload() {
        LOG.info("Uploading new job file.");
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
//        LOG.info("{} :: {}", response.getStatusInfo(), response);
    }

    @Test public void testFindJobs() {
        LOG.info("List me all uploaded jobs.");
        final Response response = target.path("jobs").path("list").request().get();
        List list = response.readEntity(List.class);
        LOG.info("found ({}) job file(s).", list.size());
        LOG.info("Response: {}", list);
    }
 }
