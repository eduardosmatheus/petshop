package dao;

import db.ConnectionApi;
import db.Maker;
import java.util.ArrayList;
import java.util.List;
import model.ItemOrder;

public class ItemOrderDAO implements Persistible<ItemOrder> {
    
    private static final Maker<ItemOrder> itemOrderMaker = (conexao) -> {
        return new ItemOrder(conexao.get("id", Integer.class), 
        new ItemDAO().findOne(conexao.get("itens_id", Integer.class)),
        conexao.get("amount", Double.class), conexao.get("unit_price", Double.class));
    };
        
    @Override
    public ItemOrder findOne(int id) {
        ConnectionApi conexao = new ConnectionApi("select * from itens_service_orders where id = ?", id);
        conexao.executeQuery();
        ItemOrder result = conexao.next() ? itemOrderMaker.make(conexao) : null; 
        return result;
    }

    @Override
    public List<ItemOrder> all() {
        ConnectionApi conexao = new ConnectionApi("select * from itens_service_orders ");
        conexao.executeQuery();
        List<ItemOrder> itemOrder = new ArrayList<>();
        while (conexao.next()) {
            itemOrder.add(itemOrderMaker.make(conexao));
        } 
        return itemOrder;
    } 
     
    public List<ItemOrder> allFromOrder(int order) {
        ConnectionApi conexao = new ConnectionApi("select * from itens_service_orders where service_order_id =? ", order);
        conexao.executeQuery();
        List<ItemOrder> itemOrder = new ArrayList<>();
        while (conexao.next()) {
            itemOrder.add(itemOrderMaker.make(conexao));
        } 
        return itemOrder;
    }

    @Override
    public boolean create(ItemOrder entity) {
        ConnectionApi conexao = new ConnectionApi();
        entity.setId(conexao.executeUpdate("insert into itens_service_orders (itens_id, amount, unit_price) values (?,?,?)",
            entity.getItem().getId(), entity.getAmount(), entity.getUnitPrice()));
        return entity.getId() > 0;
    }

    @Override
    public ItemOrder update(ItemOrder entity) {
        ConnectionApi conexao = new ConnectionApi("update itens_service_orders  "
                + "set itens_id=?, amount=?, unit_price=? where id = ?",
        entity.getItem().getId(), entity.getAmount(), entity.getUnitPrice());
        conexao.executeUpdate(); 
        return findOne(entity.getId());
    }

    @Override
    public boolean delete(ItemOrder entity) {
        ConnectionApi conexao = new ConnectionApi("delete from itens_service_orders where id = ?", entity.getId());
        final int rowsAffected = conexao.executeUpdate(); 
        return rowsAffected > 0;
    }
     
}
