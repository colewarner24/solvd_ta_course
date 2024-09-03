package internetShop.collections;

import internetShop.exceptions.PaymentNotPaidException;
import internetShop.payments.Payment;

import java.util.LinkedList;

public class Payments {
    protected MyLinkedList<Payment> payments;

    public Payments() {
        payments = new MyLinkedList<>();
    }

    public MyLinkedList<Payment> getProducts() {
        return payments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Payment payment : payments){
            sb.append(payment.toString());
        }
        return sb.toString();
    }

    public void addPayment(Payment payment) throws PaymentNotPaidException {
        if (payment.isPaid()) {
            payments.add(payment);
        }
        else{
            throw new PaymentNotPaidException("Payment " + payment.getId() + " not paid");
        }
    }
}