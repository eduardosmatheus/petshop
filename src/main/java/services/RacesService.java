package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import mocking.RaceList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import model.Race;
import petshop.Main;

@Path("/races")
public class RacesService {
    
    /**
     * Primary data source.
     */
    private final CopyOnWriteArrayList<Race> races = RaceList.getInstance();
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@QueryParam("descricao") String descricao) {
        int nextId = races.size() + 1;
        if(!races.add(new Race(nextId, descricao))){
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        URI newRaceUrl = URI.create(String.format(Main.BASE_URI+"races/%s", nextId));
        return Response.temporaryRedirect(newRaceUrl).build();
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAll() throws IOException {
        if(races.isEmpty()) {
            return Response.noContent().build();
        }
        CopyOnWriteArrayList<Race> allRaces = mapper.convertValue(races, CopyOnWriteArrayList.class);
        return Response.ok(allRaces, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readById(@PathParam("id") int id) {
        Race result = races.stream()
                .filter(r -> r.id == id)
                .collect(Collectors.toList()).get(0);
        return result != null
                ? Response.ok(mapper.convertValue(result, Race.class), MediaType.APPLICATION_JSON).build()
                : Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(
            @PathParam("id") int id,
            @PathParam("descricao") String descricao) {
        boolean removed = races.removeIf(r -> r.id == id);
        if (removed) {
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update() {
        
    }
    
}
