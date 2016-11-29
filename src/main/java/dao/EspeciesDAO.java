package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.Especie;

public class EspeciesDAO implements Persistible<Especie> {

    private static final Maker<Especie> especieMaker =  
            (conexao) -> new Especie(conexao.get("id", Integer.class), conexao.get("description", String.class));
            
    @Override
    public Especie findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from especies where id = ?", id);
        conexao.executeQuery();
        Especie result = conexao.next() ? especieMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Especie> all() {
        ConnectionApi conexao = new ConnectionApi("select * from especies");
        conexao.executeQuery();
        List<Especie> especies = new ArrayList<>();
        while(conexao.next())
            especies.add(especieMaker.make(conexao));
        return especies;
    }

    @Override
    public boolean create(Especie entity) {
        ConnectionApi conexao = new ConnectionApi("insert into especies (description) values (?)", entity.getDescription());
        final int result = conexao.executeUpdate();
        entity.setId(result);
        return result > 0;
    }

    @Override
    public Especie update(Especie entity) {
        ConnectionApi conexao = new ConnectionApi("update especies "
                + "set description = ? where id = ?", entity.getDescription(), entity.getId());
        if(conexao.executeUpdate() > 0)
            return entity;
        
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Especie entity) {
        ConnectionApi conexao = new ConnectionApi("delete from especies where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0;
    }
}
