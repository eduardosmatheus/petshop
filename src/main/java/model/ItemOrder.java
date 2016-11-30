package model;

public class ItemOrder {
    private int id;
    private Item item;
    private double amount;
    private double unitPrice;

    public ItemOrder() {
    }

    public ItemOrder(int id, Item item, double amount, double unitPrice) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
