package services;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mocking.EspecieList;
import model.Especie;

@Path("especies")
public class EspecieService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        CopyOnWriteArraySet<Especie> especies = EspecieList.getInstance();
        return Response.ok(especies, MediaType.APPLICATION_JSON).build();
    }
}
