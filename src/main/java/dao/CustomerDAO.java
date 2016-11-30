package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDAO implements Persistible<Customer> {
 
    private static final Maker<Customer> breedMaker =  
            (conexao) -> new Customer(conexao.get("id", Integer.class), conexao.get("name", String.class),
             conexao.get("cpf", String.class), conexao.get("phone", String.class),
                conexao.get("email", String.class));
            
    @Override
    public Customer findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from customer where id = ?", id);
        conexao.executeQuery();
        Customer result = conexao.next() ? breedMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Customer> all() {
        ConnectionApi conexao = new ConnectionApi("select * from customer");
        conexao.executeQuery();
        List<Customer> breeds = new ArrayList<>();
        while(conexao.next())
            breeds.add(breedMaker.make(conexao)); 
        return breeds;
    } 
 
    public boolean create(Customer entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into customer (name, cpf, phone, email) values (?,?,?,?)", 
            entity.getName(), entity.getCpf(), entity.getPhone(), entity.getEmail())); 
        return entity.getId() > 0;
    }

    @Override
    public Customer update(Customer entity) {
        ConnectionApi conexao = new ConnectionApi("update customer "
                + "set name = ?, cpf = ?, phone=?, email=? where id = ?", 
            entity.getName(), entity.getCpf(), 
            entity.getPhone(), entity.getEmail(), 
            entity.getId());
        conexao.executeUpdate(); 
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Customer entity) {
        ConnectionApi conexao = new ConnectionApi("delete from customer where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0; 
    }
}
