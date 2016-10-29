package services;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Race;

@Path("/races")
public class RacesService {
    
    private final CopyOnWriteArrayList<Race> races = RaceList.getInstance();

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String findAll() {
        return races.stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));
    }
}
