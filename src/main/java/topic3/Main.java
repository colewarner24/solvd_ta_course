package topic3;

import topic3.maps.Inventory;
import topic3.maps.PaymentMap;
import topic3.payments.PayPalPayment;
import topic3.payments.Payment;
import topic3.products.*;
import topic3.users.Admin;
import topic3.users.Customer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin(1, "Cole", "19cowarner@gmail.com", "admin");
        PaymentMap paymentMap = new PaymentMap();

        Product product = new Shirt(1, "T-Shirt", 20.00, Size.L, Condition.NEW);
        Product product2 = new Pants(2, "Cargo Pants", 14.50, Size.M, Condition.WORN);
        Product product3 = new Shirt(3, "Sweatshirt", 25.00, Size.XL, Condition.EXCELLENT);
        Product product4 = new Accessory(4, "Necklace", 30.00, Condition.WELL_WORN);
        Product product5 = new Shoe(5, "Sneakers", 50.00, 13, Condition.GOOD);

        Inventory inventory = new Inventory();

        inventory.addProduct(product, admin);
        inventory.addProduct(product2, admin);
        inventory.addProduct(product3, admin);
        inventory.addProduct(product4, admin);
        inventory.addProduct(product5, admin);

        List<Product> products = new ArrayList<>(inventory.getProductMap().values());
        products.sort(Priceable::comparePrice);
        System.out.println(products);

        products.sort(Conditionable::compareCondition);
        System.out.println(products);

        Customer customer = new Customer(2, "John", "john@john.com", "1234 Main St.");

        customer.addToCart(product2);

        System.out.println(customer.getCart());

        Payment payment = new Payment(1);
        if (payment.checkout(customer)) {
            System.out.println("Payment successful");
            paymentMap.addPayment(payment);
        } else{
            System.out.println("Payment failed");
        }
        System.out.println(payment);

        inventory.addProduct(product4, admin);
        customer.addToCart(product4);

        PayPalPayment payment2 = new PayPalPayment(2);
        if (payment2.checkout(customer)) {
            System.out.println("Payment successful");
            paymentMap.addPayment(payment2);
        } else{
            System.out.println("Payment failed");
        }
        System.out.println(payment2);

    }
}
