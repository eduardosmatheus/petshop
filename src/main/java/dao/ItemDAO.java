package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Item;

public class ItemDAO implements Persistible<Item> {

    private static final Maker<Item> itensMaker = (conexao) -> {
        Item item = new Item();
        item.setId(conexao.get("id", Integer.class));
        item.setDescription(conexao.get("description", String.class));
        item.setPrice(conexao.get("price", Double.class));
        item.setStockAmount(conexao.get("stock_amount", Double.class));        
        return item;
    }; 

    @Override
    public Item findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from itens where id = ?", id);
        conexao.executeQuery();
        Item result = conexao.next() ? itensMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<Item> all() {
        ConnectionApi conexao = new ConnectionApi("select * from itens ");
        conexao.executeQuery();
        List<Item> itens = new ArrayList<>();
        while (conexao.next()) {
            itens.add(itensMaker.make(conexao));
        } 
        return itens;
    }

    @Override
    public boolean create(Item entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into itens  (description, price, stock_amount) values (?,?,?)",
            entity.getDescription(), entity.getPrice(), entity.getStockAmount()));
        return entity.getId() > 0;
    }

    @Override
    public Item update(Item entity) {
        ConnectionApi conexao = new ConnectionApi("update itens  "
                + "set description = ?, price=?, stock_amount=? where id = ?",
        entity.getDescription(), entity.getPrice(), entity.getStockAmount(), entity.getId());
        conexao.executeUpdate(); 
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(Item entity) {
        ConnectionApi conexao = new ConnectionApi("delete from itens  where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0;
    }
     
}
