package services;

import dao.AppointmentDAO;
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
import dao.ServiceOrderDAO;
import java.util.List;
import model.Appointment;
import model.ServiceOrder;

@Path("orders")
public class ServiceOrderService { 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { 
        ServiceOrderDAO dao = new ServiceOrderDAO();
        List<ServiceOrder> serviceOrderm = dao.all();
        if(serviceOrderm.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(serviceOrderm, MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        ServiceOrderDAO dao = new ServiceOrderDAO();
        ServiceOrder r = dao.findOne(id); 
        if(r != null)
            return Response.ok(r, MediaType.APPLICATION_JSON)
                    .build();
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ServiceOrder serviceOrder) { 
        ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
        if(serviceOrderDAO.create(serviceOrder))
            return Response.status(Response.Status.CREATED)
                .entity(serviceOrder).build();
        return Response.status(Response.Status.BAD_REQUEST)
            .build(); 
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(ServiceOrder appointmentConfig) {
        ServiceOrderDAO dao = new ServiceOrderDAO();
        ServiceOrder result = dao.update(appointmentConfig);
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
        AppointmentDAO daoAppoint = new AppointmentDAO(); 
        ServiceOrderDAO daoService = new ServiceOrderDAO();
        ServiceOrder r = daoService.findOne(id);
        if(daoAppoint.alterarSituacao(r.getAppointment().getId(), 2))
            return Response.ok("Ordem de serviço cancelada com sucesso!")
                .build();
        return Response.status(Response.Status.NOT_FOUND)
            .build();
    }
    
}