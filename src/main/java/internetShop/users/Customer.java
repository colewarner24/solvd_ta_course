package internetShop.users;

import internetShop.exceptions.InvalidUserException;
import internetShop.maps.Cart;
import internetShop.products.Product;

public class Customer extends User {

    private Cart cart;
    private String address;

    public Customer(int id, String name, String email, String address) throws InvalidUserException {
        super(id, name, email);
        if (address == null) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.cart = new Cart();
        this.address =  address;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        if (product == null) {
            return;
        }
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
        if (product == null) {
            return;
        }
        cart.removeProduct(product);
    }

    public void clearCart() {
        cart.clear();
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer " + getId() + ": name=" + getName() + ", email=" + getEmail() + "\n";
    }

}
