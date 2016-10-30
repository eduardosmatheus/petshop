package services;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import mocking.RaceList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import model.Race;

@Path("/races")
public class RacesService {
    
    /**
     * Primary data source.
     */
    private final CopyOnWriteArrayList<Race> races = RaceList.getInstance();
    
    private final ObjectMapper mapper = new ObjectMapper();
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAll() throws IOException {
        if(races.isEmpty()) {
            return Response.status(Status.NO_CONTENT)
                    .build();
        }

        CopyOnWriteArrayList<Race> gen = mapper.convertValue(races, CopyOnWriteArrayList.class);
        races.stream()
        .forEach(r -> {
            try {
                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(r));
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        });
        
        return Response.ok(gen, MediaType.APPLICATION_JSON).build();
    }
}
