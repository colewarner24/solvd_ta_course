package topic2.payments;

import topic2.products.Product;
import topic2.maps.Cart;
import topic2.users.Customer;

public class Shipping {

    private String name;
    private String address;
    private static final double SHIPPING_TAX = 0.05;

    public Shipping(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public double getShippingCost(double total) {
        return total * SHIPPING_TAX;
    }

    public boolean ship(Customer customer) {
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            return false;
        }
        for (Product product : cart.getProducts().values()) {
            System.out.println("Shipping " + product.getName() + " to " + customer.getAddress());
        }
        return true;
    }
}
