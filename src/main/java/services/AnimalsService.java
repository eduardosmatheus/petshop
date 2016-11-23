package services;

public class AnimalsService {

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Animal> animals = new AnimalDAO().all();
        return Response.ok(ANIMALS, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        try {
            Animal res = ANIMALS.stream().filter(i -> i.getId() == id).findFirst().get();
            return Response.ok(res, MediaType.APPLICATION_JSON).build();
        } catch (NoSuchElementException e) {
            return Response.ok("Animal not found!", MediaType.APPLICATION_JSON).build();
        }
    }*/
}
