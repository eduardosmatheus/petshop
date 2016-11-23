package services;

import dao.CustomerDAO;
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
import model.Customer;

//@Path("people")
public class CustomerService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Customer> all = new CustomerDAO().all();
        if(all.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(all).build();
    }
    
    @GET
    @Path("/{cpf}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCpf(@PathParam("cpf") String cpf) {
        Customer customer = new CustomerDAO().findOne(cpf);
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
        List<Customer> allCustomers = new CustomerDAO().all();
        List<Customer> someCustomers = allCustomers.stream()
                .filter(a -> a.getName().startsWith(prefix))
                .collect(Collectors.toList());
        
        if(someCustomers.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(someCustomers).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Customer customer) {
        Customer changed = new CustomerDAO().update(customer);
        if(changed == null)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        return Response.ok(changed).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Customer customer) {
        boolean created = new CustomerDAO().create(customer);
        if(!created)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        return Response.status(Response.Status.CREATED).build();
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(Customer customer) {
        boolean deleted = new CustomerDAO().delete(customer);
        if(deleted)
            return Response.ok(String.format("Customer %s - %s deleted successfully!", 
                    customer.getCpf(), customer.getName())).build();
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
}
