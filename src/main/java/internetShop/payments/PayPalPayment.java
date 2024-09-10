package internetShop.payments;

public class PayPalPayment extends Payment {

    private String payPalId;

    public PayPalPayment(int id) {
        super(id);
    }

    public String getPayPalId() {
        return payPalId;
    }

    public void setPayPalId(String payPalId) {
        this.payPalId = payPalId;
    }

    @Override
    public void processPayment(double total) {
        // Send payment data to paypal
        System.out.println("Redirecting to PayPal");
        System.out.println("Processing payment of " + total + " on " + this.date + " with PayPal");
        this.payPalId = "PAYPAL-1234";
    }
}
