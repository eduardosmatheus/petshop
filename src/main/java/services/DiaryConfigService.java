package services;

import dao.DiaryConfigDAO;
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
import model.DiaryConfig;

//@Path("diaryConfig")
public class DiaryConfigService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<DiaryConfig> configs = new DiaryConfigDAO().all();
        if(!configs.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(configs).build();
    }
    
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        DiaryConfig config = new DiaryConfigDAO().findOne(id);
        if(config == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(config).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(DiaryConfig config) {
        boolean created = new DiaryConfigDAO().create(config);
        if(!created)
            return Response.status(Response.Status.BAD_REQUEST).build();
        return Response.status(Response.Status.CREATED).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(DiaryConfig config) {
        DiaryConfig updated = new DiaryConfigDAO().update(config);
        if(updated == null)
            return Response.notModified().build();
        return Response.accepted(updated).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(DiaryConfig config) {
        boolean deleted = new DiaryConfigDAO().delete(config);
        if(!deleted)
            return Response.notModified().build();
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
