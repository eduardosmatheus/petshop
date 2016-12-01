package services;

import dao.EspeciesDAO;
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
import model.Especie;

@Path("especies")
public class EspeciesService {
 
    
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("id") int id) {
        EspeciesDAO dao = new EspeciesDAO();
        Especie especie = dao.findOne(id);
        if(especie == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(especie).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        EspeciesDAO dao = new EspeciesDAO();
        List<Especie> especies = dao.all();
        return Response.ok(especies).build();
    }
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Especie especie) {
        EspeciesDAO dao = new EspeciesDAO();
        boolean created = dao.create(especie);
        if(created)
            return Response.status(Response.Status.CREATED)
                .entity(especie)
                .build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Especie existing) {
        EspeciesDAO dao = new EspeciesDAO();
        Especie updated = dao.update(existing);
        if(updated != null)
            return Response.ok(updated).build();
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") final int id) { 
        EspeciesDAO dao = new EspeciesDAO();
        Especie r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Raça removida com sucesso!").build();
        return Response.noContent().build();
    }
 
}
