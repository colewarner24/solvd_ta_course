package internetShop.collections;

import internetShop.exceptions.PaymentNotPaidException;
import internetShop.payments.Payment;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Payments {
    protected MyLinkedList<Payment> payments;

    public Payments() {
        payments = new MyLinkedList<>();
    }

    public MyLinkedList<Payment> getPayments() {
        return payments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Payment payment : payments) {
            sb.append(payment.toString());
        }
        return sb.toString();
    }

    public void addPayment(Payment payment) throws PaymentNotPaidException {
        if (payment.isPaid()) {
            payments.add(payment);
        } else {
            throw new PaymentNotPaidException("Payment " + payment.getId() + " not paid");
        }
    }

    public double getTotalAmount() {
        MyGeneric<LinkedList<Payment>, Double> totalAmount = (MyLinkedList<Payment> paymentList) ->
                paymentList.stream().mapToDouble(Payment::getAmount).sum();

        return totalAmount.compute(payments);
    }

    public LinkedList<Payment> filterPayments(MyPredicate<Payment> predicate) {
        return payments.stream()
                .filter(predicate::test)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void printAllPaymentDetails() {
        MyConsumer<Payment> printDetails = payment -> System.out.println(payment);
        payments.forEach(printDetails::accept);
    }

}