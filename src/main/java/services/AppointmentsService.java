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
import model.Appointment;
import dao.AppointmentDAO;
import dao.ServiceOrderDAO;
import java.util.List;
import model.ServiceOrder;

@Path("appointments")
public class AppointmentsService { 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { 
        AppointmentDAO dao = new AppointmentDAO();
        List<Appointment> appointmentconfig = dao.all();
        if(appointmentconfig.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(appointmentconfig, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        AppointmentDAO dao = new AppointmentDAO();
        Appointment r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Appointment appointmentConfig) { 
        AppointmentDAO dao = new AppointmentDAO(); 
        if(dao.create(appointmentConfig))
            return Response.status(Response.Status.CREATED)
                .entity(appointmentConfig).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("id") int id) {
        AppointmentDAO daoAppoint = new AppointmentDAO();  
        if(daoAppoint.alterarSituacao(id, 1)) 
            return Response.noContent()
                .build();
        
        return Response.ok("Agendamento concluido com sucesso!")
            .build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") final int id) { 
        AppointmentDAO dao = new AppointmentDAO(); 
        Appointment r = dao.findOne(id);
        if(dao.delete(r))
            return Response.ok("Agendamento removido com sucesso!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}