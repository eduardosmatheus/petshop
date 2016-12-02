package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Appointment;

public class AppointmentDAO implements Persistible<Appointment> {

    private static final Maker<Appointment> appointmentMaker =  
            (conexao) -> new Appointment(conexao.get("id", Integer.class), 
                new AppointmentConfigDAO().findOne(conexao.get("appointment_config_id", Integer.class)), 
                new AnimalDAO().findOne(conexao.get("animal_id", Integer.class)),
                conexao.get("date", Date.class), conexao.get("entryTime", Long.class), 
                conexao.get("outTime", Long.class), conexao.get("done", Integer.class), 
                conexao.get("obs", String.class));

    @Override
    public Appointment findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from appointments where id = ?", id);
        conexao.executeQuery();
        Appointment result = conexao.next() ? appointmentMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Appointment> all() {
        ConnectionApi conexao = new ConnectionApi("select * from appointments");
        conexao.executeQuery();
        List<Appointment> breeds = new ArrayList<>();
        while(conexao.next())
            breeds.add(appointmentMaker.make(conexao)); 
        return breeds;
    } 
 
    public boolean create(Appointment entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into appointments (appointment_config_id, animal_id, "
            + "date, entryTime, outTime, done, obs) "
            + "values (?,?,?,?,?,?,?)",
            entity.getAppointmentConfig().getId(), entity.getPet().getId(), entity.getDate(),
            entity.getEntryTime(), entity.getOutTime(), entity.getDone(), entity.getObs())); 
        return entity.getId() > 0;
    }

    @Override
    public Appointment update(Appointment entity) {
        ConnectionApi conexao = new ConnectionApi("update appointments "
                + "set appointment_config_id=?, animal_id=?, date=?, entryTime=?, outTime=?, done=?, obs=? where id = ?",
            entity.getAppointmentConfig().getId(), entity.getPet().getId(), entity.getDate(),
            entity.getEntryTime(), entity.getOutTime(), entity.getDone(), entity.getObs());
        conexao.executeUpdate(); 
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Appointment entity) {
        ConnectionApi conexao = new ConnectionApi("delete from appointments where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0; 
    }
}
