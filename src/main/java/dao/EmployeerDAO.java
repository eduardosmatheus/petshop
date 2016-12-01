package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List; 
import model.Employeer;

public class EmployeerDAO implements Persistible<Employeer> {
 
    private static final Maker<Employeer> employeerMaker =  
            (conexao) -> new Employeer(conexao.get("id", Integer.class), conexao.get("name", String.class),
             conexao.get("cpf", String.class), conexao.get("phone", String.class),
                conexao.get("email", String.class),
            new AppointmentConfigDAO().findOne(conexao.get("id", Integer.class)));
            
    @Override
    public Employeer findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from employeer where id = ?", id);
        conexao.executeQuery();
        Employeer result = conexao.next() ? employeerMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Employeer> all() {
        ConnectionApi conexao = new ConnectionApi("select * from employeer");
        conexao.executeQuery();
        List<Employeer> breeds = new ArrayList<>();
        while(conexao.next())
            breeds.add(employeerMaker.make(conexao)); 
        return breeds;
    } 
 
    public boolean create(Employeer entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into employeer (name, cpf, phone, email) values (?,?,?,?)", 
            entity.getName(), entity.getCpf(), entity.getPhone(), entity.getEmail())); 
        entity.getAppointmentConfig().setEmployeers_id(entity.getId());
        if(entity.getId() > 0) {
            AppointmentConfigDAO apDAO = new AppointmentConfigDAO();
            return apDAO.create(entity.getAppointmentConfig());
        }
        return false;
    }

    @Override
    public Employeer update(Employeer entity) {
        ConnectionApi conexao = new ConnectionApi("update employeer "
                + "set name = ?, cpf = ?, phone=?, email=? where id = ?", 
            entity.getName(), entity.getCpf(), 
            entity.getPhone(), entity.getEmail(), 
            entity.getId());
        conexao.executeUpdate(); 
        AppointmentConfigDAO apDao = new AppointmentConfigDAO();
        apDao.update(entity.getAppointmentConfig());
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Employeer entity) {
        AppointmentConfigDAO apDao = new AppointmentConfigDAO();
        apDao.delete(entity.getAppointmentConfig());
        
        ConnectionApi conexao = new ConnectionApi("delete from employeer where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0; 
    }
}
