package services;

import dao.EspeciesDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Especie;

@Path("especies")
public class EspeciesService {

    @Context
    private EspeciesDAO dao;
    
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("id") int id) {
        Especie especie = dao.findOne(id);
        if(especie == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(especie).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Especie> especies = dao.all();
        if(especies.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(especies).build();
    }
   
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String especieDescription) {
        Especie e = new Especie();
        e.setDescription(especieDescription);
        boolean created = dao.create(e);
        if(created)
            return Response.status(Response.Status.CREATED).entity(e).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Especie existing) {
        Especie updated = dao.update(existing);
        if(updated != null)
            return Response.ok(updated).build();
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
}
