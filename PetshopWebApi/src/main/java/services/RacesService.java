package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("races")
public class RacesService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok().build();
    }
    
}
