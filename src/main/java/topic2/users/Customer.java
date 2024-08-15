package topic2.users;

import topic2.maps.Cart;
import topic2.products.Product;

public class Customer extends User {

    private Cart cart;
    private String address;

    public Customer(int id, String name, String email, String address) {
        super(id, name, email);
        this.cart = new Cart();
        this.address =  address;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
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
