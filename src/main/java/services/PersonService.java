package services;

import dao.PersonDAO;
import java.util.List;
import java.util.stream.Collectors;
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
import model.Person;

@Path("people")
public class PersonService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Person> all = new PersonDAO().all();
        if(all.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(all).build();
    }
    
    @GET
    @Path("/id")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        Person customer = new PersonDAO().findOne(id);
        if(customer == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customer).build();
    }
    
    //TO DO: Melhorar esse método.
    @GET
    @Path("/{prefix}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findManyByPrefix(@PathParam("prefix") String prefix) {
        List<Person> allCustomers = new PersonDAO().all();
        List<Person> someCustomers = allCustomers.stream()
                .filter(a -> a.getName().startsWith(prefix))
                .collect(Collectors.toList());
        
        if(someCustomers.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(someCustomers).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Person customer) {
        Person changed = new PersonDAO().update(customer);
        if(changed == null)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        return Response.ok(changed).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Person customer) {
        boolean created = new PersonDAO().create(customer);
        if(!created)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        return Response.status(Response.Status.CREATED).build();
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(Person customer) {
        boolean deleted = new PersonDAO().delete(customer);
        if(deleted)
            return Response.ok(String.format("Customer %s - %s deleted successfully!", 
                    customer.getCpf(), customer.getName())).build();
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
}
