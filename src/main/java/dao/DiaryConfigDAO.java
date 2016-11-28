package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.DiaryConfig;

public class DiaryConfigDAO implements Persistible<DiaryConfig> {
    
    private static final Maker<DiaryConfig> diaryConfigMaker =  
            (conexao) -> new DiaryConfig(
                    conexao.get("id", Integer.class), 
                    conexao.get("agenda", Integer.class), 
                    new PersonDAO().findOne(conexao.get("person_id", Integer.class)),
                    conexao.get("hours_capacity", Integer.class));
            
    @Override
    public DiaryConfig findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from diary_config where id = ?", id);
        conexao.executeQuery();
        DiaryConfig result = conexao.next() ? diaryConfigMaker.make(conexao) : null;
        conexao.close();
        return result;
    }

    @Override
    public List<DiaryConfig> all() {
        ConnectionApi conexao = new ConnectionApi("select * from diary_config");
        conexao.executeQuery();
        List<DiaryConfig> diary_config = new ArrayList<>();
        while(conexao.next())
            diary_config.add(diaryConfigMaker.make(conexao));
        conexao.close();
        return diary_config;
    }

    @Override
    public boolean create(DiaryConfig entity) {
        ConnectionApi conexao = new ConnectionApi("insert into diary_config (agenda, ) values (?)");
        final int result = conexao.executeUpdate();
        conexao.close();
        return result > 0;
    }

    @Override
    public DiaryConfig update(DiaryConfig entity) {
        ConnectionApi conexao = new ConnectionApi("update diary_config "
                + "set agenda = ?, hours_capacity = ? where id = ?", 
                entity.getAgenda(), entity.getHoursCapacity(), entity.getId());
        final int rowsAffected = conexao.executeUpdate();
        conexao.close();
        return rowsAffected > 0 ? entity : null;
    }

    @Override
    public boolean delete(DiaryConfig entity) {
        ConnectionApi conexao = new ConnectionApi("delete from diary_config where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate();
        conexao.close();
        return rowsAffected > 0;
    }
}
