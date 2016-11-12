package services;

import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Breed;
import repos.BreedsRepo;

@Path("breeds")
public class BreedsService {
    
    final BreedsRepo breedData = new BreedsRepo();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(breedData.all(), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Breed r = breedData.findOne(id);
        return Response.ok(r, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Breed race) {
        boolean added = breedData.BREEDS.add(race);
        if(added)
            return Response.status(Response.Status.CREATED).entity(race).build();
        
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Breed newRace) {
        Breed remaining = breedData.findOne(newRace.getId());
        Breed result = breedData.BREEDS.set(breedData.BREEDS.indexOf(remaining), newRace);
        if(result == null)
            return Response.noContent().build();
        return Response.ok(newRace).build();
    }
}