package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Animal;

public class AnimalDAO implements Persistible<Animal> {

    private static final Maker<Animal> animalMaker = (conexao) -> {
        Animal animal = new Animal();
        animal.setId(conexao.get("id", Integer.class));
        animal.setName(conexao.get("name", String.class));
        animal.setBirthday(conexao.get("birthday", Date.class));
        animal.setBreed(new BreedsDAO().findOne(conexao.get("breed_id", Integer.class)));
        animal.setEspecie(new EspeciesDAO().findOne(conexao.get("especie_id", Integer.class)));
        animal.setCustomer(new PersonDAO().findOne(conexao.get("person_id", Integer.class)));
        return animal;
    };

    @Override
    public Animal findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from animals where id = ?", id);
        conexao.executeQuery();
        Animal result = conexao.next() ? animalMaker.make(conexao) : null;
        conexao.close();
        return result;
    }

    @Override
    public List<Animal> all() {
        ConnectionApi conexao = new ConnectionApi("select * from animals");
        conexao.executeQuery();
        List<Animal> animals = new ArrayList<>();
        while (conexao.next()) {
            animals.add(animalMaker.make(conexao));
        }
        conexao.close();
        return animals;
    }

    @Override
    public boolean create(Animal entity) {
        ConnectionApi conexao = new ConnectionApi("insert into animals (description) values (?)", entity.getName());
        final int result = conexao.executeUpdate();
        conexao.close();
        return result > 0;
    }

    @Override
    public Animal update(Animal entity) {
        ConnectionApi conexao = new ConnectionApi("update animals "
                + "set description = ? where id = ?", entity.getName(), entity.getId());
        conexao.executeUpdate();
        conexao.close();
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Animal entity) {
        ConnectionApi conexao = new ConnectionApi("delete from animals where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate();
        conexao.close();
        return rowsAffected > 0;
    }
    
    public List<Animal> findByOwner(int personId) {
        ConnectionApi conexao = new ConnectionApi("select * from animals where person_id = ?", personId);
        conexao.executeQuery();
        List<Animal> animals = new ArrayList<>();
        while (conexao.next()) {
            animals.add(animalMaker.make(conexao));
        }
        conexao.close();
        return animals;
    }
}
