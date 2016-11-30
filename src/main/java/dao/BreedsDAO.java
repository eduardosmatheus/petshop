package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.Breed;

public class BreedsDAO implements Persistible<Breed> {

    private static final Maker<Breed> breedMaker =  
            (conexao) -> new Breed(conexao.get("id", Integer.class), conexao.get("name", String.class));
            
    @Override
    public Breed findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from breeds where id = ?", id);
        conexao.executeQuery();
        Breed result = conexao.next() ? breedMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Breed> all() {
        ConnectionApi conexao = new ConnectionApi("select * from breeds");
        conexao.executeQuery();
        List<Breed> breeds = new ArrayList<>();
        while(conexao.next())
            breeds.add(breedMaker.make(conexao)); 
        return breeds;
    } 
 
    public boolean create(Breed entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into breeds (name) values (?)", entity.getName())); 
        return entity.getId() > 0;
    }

    @Override
    public Breed update(Breed entity) {
        ConnectionApi conexao = new ConnectionApi("update breeds "
                + "set name = ? where id = ?", entity.getName(), entity.getId());
        conexao.executeUpdate(); 
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Breed entity) {
        ConnectionApi conexao = new ConnectionApi("delete from breeds where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0; 
    }
}
