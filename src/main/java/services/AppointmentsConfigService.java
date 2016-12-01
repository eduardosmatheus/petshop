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
import model.AppointmentConfig;
import dao.AppointmentConfigDAO;
import java.util.List;

@Path("appointmentconfig")
public class AppointmentsConfigService {
     
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { 
        AppointmentConfigDAO dao = new AppointmentConfigDAO();
        List<AppointmentConfig> appointmentconfig = dao.all();
        if(appointmentconfig.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(appointmentconfig, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        AppointmentConfigDAO dao = new AppointmentConfigDAO();
        AppointmentConfig r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(AppointmentConfig appointmentConfig) { 
        AppointmentConfigDAO dao = new AppointmentConfigDAO(); 
        if(dao.create(appointmentConfig))
            return Response.status(Response.Status.CREATED)
                .entity(appointmentConfig).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(AppointmentConfig appointmentConfig) {
        AppointmentConfigDAO dao = new AppointmentConfigDAO();
        AppointmentConfig result = dao.update(appointmentConfig);
        if(result == null) 
            return Response.noContent()
                .build();
        
        return Response.ok(appointmentConfig)
            .build(); 
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") final int id) { 
        AppointmentConfigDAO dao = new AppointmentConfigDAO(); 
        AppointmentConfig r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Configurações de agendamento removidas com sucesso!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}