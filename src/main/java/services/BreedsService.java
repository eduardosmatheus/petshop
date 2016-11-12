package services;

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
import repos.BreedsDAO;

@Path("breeds")
public class BreedsService {
    
    private final BreedsDAO dao = new BreedsDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(dao.all(), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Breed r = dao.findOne(id);
        return Response.ok(r, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String raceName) {
        Breed f = new Breed();
        f.setName(raceName);
        if(dao.create(f))
            return Response.status(Response.Status.CREATED).entity(f).build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Breed newRace) {
        Breed result = dao.update(newRace);
        /*Breed remaining = breedData.findOne(newRace.getId());
        Breed result = breedData.BREEDS.set(breedData.BREEDS.indexOf(remaining), newRace);*/
        if(result == null)
            return Response.noContent().build();
        return Response.ok(newRace).build();
    }
}