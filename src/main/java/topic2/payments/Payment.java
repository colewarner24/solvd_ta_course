package topic2.payments;
import topic2.maps.Cart;
import topic2.users.Customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment {
    private int id;
    private String date;
    private double amount;
    private Status status;

    enum Status {
        NOT_PAID, PENDING, PAID
    }

    public Payment(int id) {
        this.id = id;
        this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
        this.amount = 0;
        this.status = Status.NOT_PAID;
    }

    public boolean checkout(Customer customer) {
        this.status = Status.PENDING;
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            return false;
        }
        Shipping shipping = new Shipping(customer.getAddress(), customer.getAddress());

        double total = cart.getTotalPrice() + shipping.getShippingCost(cart.getTotalPrice());
        if (!processPayment(total)) {
            return false;
        }
        if (!shipping.ship(customer)) {
            return false;
        }
        customer.clearCart();
        this.amount = total;
        this.status = Status.PAID;

        return true;
    }

    public boolean processPayment(double total) {
        // Send payment data to a payment gateway
        System.out.println("Processing payment of " + total + " on " + date);
        return true;
    }

    public boolean isPaid(){
        return status == Status.PAID;
    }

    public int getId() {
        return id;
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
