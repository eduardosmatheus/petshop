package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Animal;

public class AnimalDAO implements Persistible<Animal> {

    private static final Maker<Animal> animalMaker = (conexao) -> {
        return Animal.buildAnimal(conexao.get("id", Integer.class),conexao.get("name", String.class), conexao.get("birth", Date.class),
            conexao.get("breeds_id", Integer.class), conexao.get("especies_id", Integer.class), conexao.get("customer_id", Integer.class), conexao.get("obs", String.class));
    }; 

    @Override
    public Animal findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from animal where id = ?", id);
        conexao.executeQuery();
        Animal result = conexao.next() ? animalMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Animal> all() {
        ConnectionApi conexao = new ConnectionApi("select * from animal ");
        conexao.executeQuery();
        List<Animal> animals = new ArrayList<>();
        while (conexao.next()) {
            animals.add(animalMaker.make(conexao));
        } 
        return animals;
    }

    @Override
    public boolean create(Animal entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into animal  (name, birth, obs, "
            + "especies_id, breeds_id, customer_id) values (?,?,?, ?,?,?)", 
            entity.getName(), entity.getBirth(), entity.getObs(), 
            entity.getEspecie().getId(), entity.getBreed().getId(), entity.getCustomer().getId()));
        return entity.getId() > 0;
    }

    @Override
    public Animal update(Animal entity) {
        ConnectionApi conexao = new ConnectionApi("update animal  "
                + "set name = ?, birth=?, obs=?, especies_id=?, breeds_id=?, customer_id=? where id = ?", 
            entity.getName(), entity.getBirth(), entity.getObs(), entity.getEspecie().getId(), entity.getBreed().getId(), entity.getCustomer().getId(),  entity.getId());
        conexao.executeUpdate(); 
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Animal entity) {
        ConnectionApi conexao = new ConnectionApi("delete from animal  where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0;
    }
    
    public List<Animal> findByOwner(int personId) {
        ConnectionApi conexao = new ConnectionApi("select * from animal where person_id = ?", personId);
        conexao.executeQuery();
        List<Animal> animals = new ArrayList<>();
        while (conexao.next()) {
            animals.add(animalMaker.make(conexao));
        } 
        return animals;
    }
}
