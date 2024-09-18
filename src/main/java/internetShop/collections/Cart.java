package internetShop.collections;

import internetShop.products.Product;

import java.util.ArrayList;

public class Cart extends ProductMap {

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : getProducts().values()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void addProduct(Product product) {
        getProducts().put(product.getId(), product);
    }

    public void addProduct(int id, Inventory inventory) {
        Product product = inventory.getProduct(id);
        if (product != null) {
            getProducts().put(product.getId(), product);
        }
    }

    public void removeProduct(Product product) {
        getProducts().remove(product.getId());
    }

    public void clear(){
        getProducts().clear();
    }

    public boolean isEmpty(){
        return getProducts().isEmpty();
    }

    @Override
    public String toString() {
        return "Cart: " + super.toString();
    }

}
