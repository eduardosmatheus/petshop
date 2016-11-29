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
import model.Customer;
import dao.CustomerDAO;
import java.util.List;

@Path("customers")
public class CustomerService {
     
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { 
        CustomerDAO dao = new CustomerDAO();
        List<Customer> customers = dao.all();
        if(customers.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customers, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        CustomerDAO dao = new CustomerDAO();
        Customer r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Customer customer) { 
        CustomerDAO dao = new CustomerDAO(); 
        if(dao.create(customer))
            return Response.status(Response.Status.CREATED)
                .entity(customer).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Customer newRace) {
        CustomerDAO dao = new CustomerDAO();
        Customer result = dao.update(newRace);
        if(result == null) 
            return Response.noContent()
                .build();
        
        return Response.ok(newRace)
            .build(); 
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") final int id) { 
        CustomerDAO dao = new CustomerDAO(); 
        Customer r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Customer deleted successfully!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}