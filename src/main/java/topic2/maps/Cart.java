package topic2.maps;

import topic2.products.Product;

public class Cart extends ProductMap {

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products.values()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void removeProduct(Product product) {
        products.remove(product.getId());
    }

    public void clear(){
        products.clear();
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    @Override
    public String toString() {
        return "Cart: " + super.toString();
    }

}
