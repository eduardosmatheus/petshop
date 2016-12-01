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
import model.Employeer;
import dao.EmployeerDAO;
import java.util.List;

@Path("employeers")
public class EmployeerService {
     
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { 
        EmployeerDAO dao = new EmployeerDAO();
        List<Employeer> employeers = dao.all();
        if(employeers.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(employeers, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        EmployeerDAO dao = new EmployeerDAO();
        Employeer r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Employeer employeer) { 
        EmployeerDAO dao = new EmployeerDAO(); 
        if(dao.create(employeer))
            return Response.status(Response.Status.CREATED)
                .entity(employeer).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Employeer employeer) {
        EmployeerDAO dao = new EmployeerDAO();
        Employeer result = dao.update(employeer);
        if(result == null) 
            return Response.noContent()
                .build();
        
        return Response.ok(result)
            .build(); 
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") final int id) { 
        EmployeerDAO dao = new EmployeerDAO(); 
        Employeer r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Empregado removido com sucesso!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}