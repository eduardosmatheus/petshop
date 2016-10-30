package helper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.grizzly.http.server.HttpServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import petshop.Main;

public class PetshopTestHelper {

    protected HttpServer server;
    protected WebTarget target;

    @BeforeClass
    public void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @AfterClass
    public void tearDown() throws Exception {
        server.shutdownNow();
    }
}
