package tv.example;

import java.util.List;

public class ShoppingCart {
    private double total = 0;
    private List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.getPrice() * item.getQuantity();
    }

    public void removeItem(int id) {
        items.stream().filter(item -> item.getId() == id).findFirst().ifPresent(item -> {
            total -= item.getPrice() * item.getQuantity();
            items.remove(item);
        });
    }

    public void updateItem(Item item, int quantity) {
        int index = items.indexOf(item);
        Item itemToUpdate = items.get(index);
        double diff = itemToUpdate.getPrice() * Math.abs(itemToUpdate.getQuantity() - quantity);
        itemToUpdate.setQuantity(quantity);
        total += diff;
    }

    public double getTotal() {
        return total;
    }

    public void clearCart() {
        items.clear();
        total = 0;
    }

    public Item getInstance(int id, double price, int quantity) {
        return new Item(id, price, quantity);
    }

    private class Item {
        private int id;
        private double price;
        private int quantity;

        public Item(int id, double price, int quantity) {
            this.id = id;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}
