package internetShop.payments;
import internetShop.collections.Inventory;
import internetShop.exceptions.EmptyCartException;
import internetShop.collections.Cart;
import internetShop.exceptions.ProductInInventoryException;
import internetShop.products.Product;
import internetShop.users.Customer;
import internetShop.Identifiable;
import internetShop.utility.IDManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment implements Identifiable, Processable {
    protected int id;
    protected String date;
    protected double amount;
    protected Status status;
    private static IDManager idManager = new IDManager();

    public Payment(){
        this(idManager.assignId());
    }

    public Payment(int id) {
        this.id = id;
        this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
        this.amount = 0;
        this.status = Status.NOT_PAID;
    }

    public double getAmount() {
        return amount;
    }

    //enforce subclasses have to use this method
    public final boolean checkout(Customer customer, Inventory inventory) throws EmptyCartException, ProductInInventoryException {
        this.status = Status.PENDING;
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty");
        }
        Shipping shipping = new Shipping(customer.getAddress(), customer.getAddress());

        shipping.ship(customer);

        for (Product product : cart.getProducts().values()) {
            inventory.removeProduct(product);
        }
        customer.clearCart();
        this.amount = getTotal(cart, shipping);
        this.status = Status.PAID;

        return true;
    }

    public void processPayment(double total) {
        // Send payment data to a payment gateway
        System.out.println("Processing payment of " + total + " on " + date);
    }

    public boolean isPaid(){
        return status == Status.PAID;
    }

    public int getId() {
        return id;
    }

    public double getTotal(Cart cart, Shipping shipping){
        return cart.getTotalPrice() + shipping.getShippingCost(cart.getTotalPrice());
    }

    @Override
    public String toString() {
        if (status == Status.PAID) {
            return "Payment " + id + ": amount=" + amount + ", date=" + date + " \n";
        }
        else{
            return "Not paid\n";
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Payment payment)) {
            return false;
        }
        return payment.getId() == id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
