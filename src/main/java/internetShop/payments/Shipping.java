package internetShop.payments;

import internetShop.collections.Cart;
import internetShop.products.Product;
import internetShop.users.Customer;
import internetShop.exceptions.EmptyCartException;

public class Shipping {

    private String name;
    private String shippingAddress;
    private static final double SHIPPING_TAX = 0.05;

    public Shipping(String name, String shippingAddress) {
        this.name = name;
        this.shippingAddress = shippingAddress;
    }

    public double getShippingCost(double total) {
        return total * SHIPPING_TAX;
    }

    public void ship(Customer customer) throws EmptyCartException {
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty");
        }
        for (Product product : cart.getProducts().values()) {
            System.out.println("Shipping " + product.getName() + " to " + customer.getAddress());
        }
    }
}
