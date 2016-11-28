package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Schedule;

public class ScheduleDAO implements Persistible<Schedule> {
    
    private static final Maker<Schedule> especieMaker
            = (conexao) -> new Schedule(
                    conexao.get("id", Integer.class), 
                    new DiaryConfigDAO().findOne(conexao.get("diary_config_id", Integer.class)),
                    conexao.get("schedule_date", Date.class),
                    conexao.get("schedule_time", Integer.class),
                    new AnimalDAO().findOne(conexao.get("animal_id", Integer.class)),
                    conexao.get("observations", String.class));

    @Override
    public Schedule findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from schedule where id = ?", id);
        conexao.executeQuery();
        Schedule result = conexao.next() ? especieMaker.make(conexao) : null;
        conexao.close();
        return result;
    }

    @Override
    public List<Schedule> all() {
        ConnectionApi conexao = new ConnectionApi("select * from schedule");
        conexao.executeQuery();
        List<Schedule> schedule = new ArrayList<>();
        while (conexao.next()) {
            schedule.add(especieMaker.make(conexao));
        }
        conexao.close();
        return schedule;
    }

    @Override
    public boolean create(Schedule entity) {
        ConnectionApi conexao = new ConnectionApi("insert into schedule "
                + "(diary_config_id, schedule_date, animal_id, observations) values (?, ?, ?, ?, ?)", 
                entity.getConfigurations().getId(), entity.getDate(), 
                entity.getAnimal().getId(), entity.getObservations());
        final int result = conexao.executeUpdate();
        conexao.close();
        return result > 0;
    }

    @Override
    public Schedule update(Schedule entity) {
        ConnectionApi conexao = new ConnectionApi("update schedule "
                + "set schedule_date = ?, "
                + "    observations = ? "
                + "where id = ?", entity.getDate(), entity.getObservations(), entity.getId());
        conexao.executeUpdate();
        conexao.close();
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Schedule entity) {
        ConnectionApi conexao = new ConnectionApi("delete from schedule where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate();
        conexao.close();
        return rowsAffected > 0;
    }
}
