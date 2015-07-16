package de.uks.beast.hds.server;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.uks.beast.hds.server.resources.FileUpload;
import org.glassfish.grizzly.http.server.HttpServer;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.*;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class JobsTest extends JerseyTest {

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
        System.out.println("**** target uri: " + target.getUri());
    }

    @After public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("jobs").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }


    @Override protected Application configure() {
        return new ResourceConfig(FileUpload.class);
    }

    @Override protected void configureClient(ClientConfig clientConfig) {
        clientConfig.register(MultiPartFeature.class);
    }


    @Test public void testFileUpload() {
        System.out.println("**** Start file upload");

        // source file
        String FILE = "/BeAST-20140122.zip";
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
        System.out.println("**** " + response. getStatusInfo() + " " + response);

        response.close();
    }
}
