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
import javax.ws.rs.core.Response.Status;

@Path("breeds")
public class BreedsService {
    
    private final BreedsDAO dao = new BreedsDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(dao.all(), MediaType.APPLICATION_JSON)
                //TO DO: Deve ter uma forma de padronizar isso pra toda response. (Problema com o CORS)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, HEAD")
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Breed r = dao.findOne(id);
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
                    .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, HEAD")
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String raceName) {
        Breed breed = new Breed();
        breed.setName(raceName);
        if(dao.create(breed))
            return Response.status(Response.Status.CREATED).entity(breed).build();
        return Response.status(Status.BAD_REQUEST).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Breed newRace) {
        Breed result = dao.update(newRace);
        if(result == null)
            return Response.status(Status.NOT_ACCEPTABLE).build();
        return Response.ok(newRace).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(Breed r) {
        if(dao.delete(r))
            return Response.ok(String.format("Breed %s deleted successfully!", r.getName())).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}