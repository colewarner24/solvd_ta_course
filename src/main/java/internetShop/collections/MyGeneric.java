package internetShop.collections;

import internetShop.payments.Payment;

@FunctionalInterface
public interface MyGeneric<T, R> {
    R compute(MyLinkedList<Payment> t);
}
