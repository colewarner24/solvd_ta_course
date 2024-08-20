package topic3.payments;

public class PayPalPayment extends Payment {

    private String payPalId;

    public PayPalPayment(int id) {
        super(id);
    }

    public String getPayPalId() {
        return payPalId;
    }

    @Override
    public boolean processPayment(double total) {
        // Send payment data to paypal
        System.out.println("Redirecting to PayPal");
        System.out.println("Processing payment of " + total + " on " + this.date + " with PayPal");
        this.payPalId = "PAYPAL-1234";
        return true;
    }
}
