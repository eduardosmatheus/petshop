package services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mocking.BaseRepo;
import model.Race;

@Path("races")
public class RacesService implements Findable {
    
    private final CopyOnWriteArrayList<Race> RACES = BaseRepo.getRaces();
            
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findAll() {
        return Response.ok(RACES, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findById(@PathParam("id") int id) {
        List<Race> r = RACES.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
        return Response.ok(r, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    public Response create() {
        return null;
    }
}
