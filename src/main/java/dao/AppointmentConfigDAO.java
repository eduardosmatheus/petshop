package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.AppointmentConfig;

public class AppointmentConfigDAO implements Persistible<AppointmentConfig> {
 
    private static final Maker<AppointmentConfig> appointmentConfigMaker =  
            (conexao) -> new AppointmentConfig(conexao.get("id", Integer.class),  conexao.get("employeer_id", Integer.class),
                conexao.get("entryTime", Long.class), conexao.get("lunchTime", Long.class), 
                conexao.get("entryTimeAfterLunch", Long.class), conexao.get("homeTime", Long.class));

    @Override
    public AppointmentConfig findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from appointment_config where employeer_id = ?", id);
        conexao.executeQuery();
        AppointmentConfig result = conexao.next() ? appointmentConfigMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<AppointmentConfig> all() {
        ConnectionApi conexao = new ConnectionApi("select * from appointment_config");
        conexao.executeQuery();
        List<AppointmentConfig> breeds = new ArrayList<>();
        while(conexao.next())
            breeds.add(appointmentConfigMaker.make(conexao)); 
        return breeds;
    } 
 
    public boolean create(AppointmentConfig entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into appointment_config (employeer_id, entryTime, lunchTime, entryTimeAfterLunch, homeTime) "
            + "values (?,?,?,?,?)", entity.getEmployeers_id(),
            entity.getEntryTime(), entity.getLunchTime(), 
            entity.getEntryTimeAfterLunch(), entity.getHomeTime())); 
        return entity.getId() > 0;
    }

    @Override
    public AppointmentConfig update(AppointmentConfig entity) {
        ConnectionApi conexao = new ConnectionApi("update appointment_config "
                + "set entryTime=?, lunchTime=?, entryTimeAfterLunch=?, homeTime=? where employeer_id = ?",
            entity.getEntryTime(), entity.getLunchTime(), 
            entity.getEntryTimeAfterLunch(), entity.getHomeTime(), 
            entity.getEmployeers_id());
        conexao.executeUpdate(); 
        return findOne(entity.getEmployeers_id());
    }

    @Override
    public boolean delete(AppointmentConfig entity) {
        ConnectionApi conexao = new ConnectionApi("delete from appointment_config where employeer_id = ?", entity.getEmployeers_id());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0; 
    }
}
