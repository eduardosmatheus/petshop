package services;

import dao.AnimalDAO;
import java.util.List;
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
import model.Animal;

@Path("animals")
public class AnimalsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Animal> animals = new AnimalDAO().all();
        return Response.ok(animals, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Animal res = new AnimalDAO().all().stream().filter(i -> i.getId() == id).findFirst().orElse(null);
        if(res != null)
            return Response.ok(res, MediaType.APPLICATION_JSON).build();
        
        return Response.status(Response.Status.NOT_FOUND).build();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Animal animal) { 
        AnimalDAO dao = new AnimalDAO();
        if(dao.create(animal))
            return Response.status(Response.Status.CREATED)
                .entity(animal).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Animal animal) {
        AnimalDAO dao = new AnimalDAO();
        Animal result = dao.update(animal);
        if(result == null) 
            return Response.noContent()
                .build();
        
        return Response.ok(animal)
            .build(); 
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") final int id) { 
        AnimalDAO dao = new AnimalDAO(); 
        Animal r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Animal removido com sucesso!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
}
