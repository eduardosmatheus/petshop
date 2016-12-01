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
import model.Item;
import dao.ItemDAO;
import java.util.List;

@Path("itens")
public class ItensService {
      
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { 
        ItemDAO dao = new ItemDAO();
        List<Item> itens = dao.all();
        if(itens.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(itens, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        ItemDAO dao = new ItemDAO();
        Item r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Item item) { 
        ItemDAO dao = new ItemDAO();  
        if(dao.create(item))
            return Response.status(Response.Status.CREATED)
                .entity(item).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Item item) {
        ItemDAO dao = new ItemDAO();
        Item result = dao.update(item);
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
        ItemDAO dao = new ItemDAO(); 
        Item r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Item da ordem de serviço removido com sucesso!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}