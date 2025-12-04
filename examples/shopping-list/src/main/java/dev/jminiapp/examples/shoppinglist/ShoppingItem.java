package dev.jminiapp.examples.shoppinglist;

public class ShoppingItem {

    private String name;
    private int quantity;
    private boolean purchased;

    public ShoppingItem() { }

    public ShoppingItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.purchased = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
}
