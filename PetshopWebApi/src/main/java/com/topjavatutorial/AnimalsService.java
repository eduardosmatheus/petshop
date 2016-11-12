package com.topjavatutorial;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mocking.BaseRepo;
import model.Animal;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("animals")
public class AnimalsService {
    
    private final CopyOnWriteArrayList<Animal> ANIMALS = BaseRepo.getAnimals();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        return Response.ok(ANIMALS, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Optional<Animal> res = ANIMALS.stream().filter(i -> i.getId() == id).findFirst();
        return Response.ok(res.get(), MediaType.APPLICATION_JSON).build();
    }
}
