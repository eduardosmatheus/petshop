package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Breed;
import dao.BreedsDAO;
import java.util.List;
import javax.ws.rs.OPTIONS;

@Path("breeds")
public class BreedsService {
    
    private BreedsDAO dao = new BreedsDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Breed> breeds = dao.all();
        if(breeds.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(breeds, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Breed r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Breed raceName) { 
        Breed f = new Breed();
        f.setName(raceName.getName());
        if(dao.create(f))
            return Response.status(Response.Status.CREATED)
                .entity(f).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Breed newRace) {
        Breed result = dao.update(newRace);
        if(result == null) 
            return Response.noContent()
                .build();
        
        return Response.ok(newRace)
            .build(); 
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(Breed r) {
        if(dao.delete(r))
            return Response.ok(String.format("Breed %s deleted successfully!", r.getName()))
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}