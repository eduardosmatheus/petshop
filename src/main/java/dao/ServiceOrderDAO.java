package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.ServiceOrder;

public class ServiceOrderDAO implements Persistible<ServiceOrder> {
    
    private static final Maker<ServiceOrder> serviceOrderMaker = (conexao) -> {
        return new ServiceOrder(conexao.get("id", Integer.class), 
            new AppointmentDAO().findOne(conexao.get("appointments_id", Integer.class)), 
            new ItemOrderDAO().allFromOrder(conexao.get("id", Integer.class)),
            conexao.get("access_key", String.class), 
            conexao.get("price", Double.class));
    };

    @Override
    public ServiceOrder findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from service_order where id = ?", id);
        conexao.executeQuery();
        ServiceOrder result = conexao.next() ? serviceOrderMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<ServiceOrder> all() {
        ConnectionApi conexao = new ConnectionApi("select * from service_order ");
        conexao.executeQuery();
        List<ServiceOrder> serviceOrder = new ArrayList<>();
        while (conexao.next()) {
            serviceOrder.add(serviceOrderMaker.make(conexao));
        } 
        return serviceOrder;
    }

    @Override
    public boolean create(ServiceOrder entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into service_order (appointments_id, access_key, price) values (?,?,?)",
            entity.getAppointment().getId(), entity.getAccessKey(), entity.getPrice()));
        
        entity.getItens().forEach(new ItemOrderDAO()::create);
        new AppointmentDAO().create(entity.getAppointment());
        
        return entity.getId() > 0;
    }

    @Override
    public ServiceOrder update(ServiceOrder entity) {
        ConnectionApi conexao = new ConnectionApi("update service_order  "
                + "set appointments_id=?, access_key=?, price=? where id = ?",
        entity.getAppointment().getId(), entity.getAccessKey(), entity.getPrice());
        conexao.executeUpdate(); 
        
        entity.setAppointment(new AppointmentDAO().update(entity.getAppointment()));
        
        entity.setItens(entity.getItens()
            .stream()
            .map(new ItemOrderDAO()::update)
            .collect(Collectors.toList()));
        
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(ServiceOrder entity) {
        new AppointmentDAO().delete(entity.getAppointment());
        entity.getItens().forEach(new ItemOrderDAO()::delete);
        
        ConnectionApi conexao = new ConnectionApi("delete from service_order  where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0;
    }
    
    public double somatoriaDeLucros() {
        ConnectionApi conexao = new ConnectionApi("select sum(price) somatoria from service_order");
        conexao.executeQuery();
        double result = conexao.next() ? conexao.get("somatoria", Double.class) : 0d;
        return result;
    }
     
}
