package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.Breed;

public class BreedsDAO implements Persistible<Breed> {

    private static final Maker<Breed> breedMaker =  
            (conexao) -> new Breed(conexao.get("id", Integer.class), conexao.get("description", String.class));
            
    @Override
    public Breed findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from breeds where id = ?", id);
        conexao.executeQuery();
        Breed result = conexao.next() ? breedMaker.make(conexao) : null;
        conexao.close();
        return result;
    }

    @Override
    public List<Breed> all() {
        ConnectionApi conexao = new ConnectionApi("select * from breeds");
        conexao.executeQuery();
        List<Breed> breeds = new ArrayList<>();
        while(conexao.next())
            breeds.add(breedMaker.make(conexao));
        conexao.close();
        return breeds;
    }

    @Override
    public boolean create(Breed entity) {
        ConnectionApi conexao = new ConnectionApi("insert into breeds (description) values (?)", entity.getName());
        final int result = conexao.executeUpdate();
        conexao.close();
        return result > 0;
    }

    @Override
    public Breed update(Breed entity) {
        ConnectionApi conexao = new ConnectionApi("update breeds "
                + "set description = ? where id = ?", entity.getName(), entity.getId());
        conexao.executeUpdate();
        conexao.close();
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Breed entity) {
        ConnectionApi conexao = new ConnectionApi("delete from breeds where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate();
        conexao.close();
        return rowsAffected > 0;
    }
}
