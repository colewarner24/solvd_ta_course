package topic2.maps;

import topic2.payments.Payment;

import java.util.HashMap;

public class PaymentMap {
    protected HashMap<Integer, Payment> payments;

    public PaymentMap() {
        payments = new HashMap<>();
    }

    public HashMap<Integer, Payment> getProducts() {
        return payments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Payment payments : payments.values()) {
            sb.append(payments.toString());
        }
        return sb.toString();
    }

    public void addPayment(Payment payment) {
        if (payment.isPaid()) {
            payments.put(payment.getId(), payment);
        }
    }
}