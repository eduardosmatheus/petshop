package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.Person;

public class PersonDAO implements Persistible<Person> {

    private static final Maker<Person> personMaker = 
            (c) -> new Person(c.get("id", Integer.class),
                    c.get("cpf", String.class),
                    c.get("name", String.class),
                    c.get("age", Long.class),
                    c.get("address", String.class),
                    c.get("phone", String.class));
    
    @Override
    public Person findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from people where id = ?", id);
        conexao.executeQuery();
        Person result = conexao.next() ? personMaker.make(conexao) : null;
        conexao.close();
        return result;
    }

    @Override
    public List<Person> all() {
        ConnectionApi conexao = new ConnectionApi("select * from people");
        conexao.executeQuery();
        List<Person> people = new ArrayList<>();
        while(conexao.next())
            people.add(personMaker.make(conexao));
        conexao.close();
        return people;
    }

    @Override
    public boolean create(Person entity) {
        ConnectionApi conexao = new ConnectionApi("insert into people "
                + "(cpf, name, age, address, phone) values (?, ?, ?, ?, ?)", 
                entity.getCpf(), entity.getName(), 
                entity.getAge(), entity.getAddress(), entity.getPhone());
        final int result = conexao.executeUpdate();
        conexao.close();
        if(result > 0) {
            if(!entity.getAnimals().isEmpty()){
                entity.getAnimals().forEach(animal -> {
                    ConnectionApi personsAnimals = new ConnectionApi(
                            "insert into person_animals (animal_id, person_id) "
                            + "values(?,?)", entity.getId(), animal.getId());
                    personsAnimals.executeUpdate();
                    personsAnimals.close();
                });                
            }
        }
        return result > 0;
    }

    @Override
    public Person update(Person entity) {
        ConnectionApi conexao = new ConnectionApi("update people "
                + "set cpf = ?, name = ?, age = ?, address = ?, phone = ?", 
                entity.getCpf(), entity.getName(), entity.getAge(), entity.getAddress());
        final int result = conexao.executeUpdate();
        conexao.close();
        return result > 0 ? entity : null;
    }

    @Override
    public boolean delete(Person entity) {
        ConnectionApi conexao = new ConnectionApi("delete from people where id = ?", entity.getId());
        final int result = conexao.executeUpdate();
        conexao.close();
        return result > 0;
    }
}
