package topic3.users;

import topic3.maps.Cart;
import topic3.products.Product;

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
