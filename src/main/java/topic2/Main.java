package topic2;

import topic2.maps.Inventory;
import topic2.maps.PaymentMap;
import topic2.payments.Payment;
import topic2.products.Product;
import topic2.users.Admin;
import topic2.users.Customer;

public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin(1, "Cole", "19cowarner@gmail.com", "admin");
        PaymentMap paymentMap = new PaymentMap();

        Product product = new Product(1, "T-Shirt", 20.00);
        Product product2 = new Product(2, "Cargo Pants", 14.50);
        Product product3 = new Product(3, "Sweatshirt", 25.00);

        Inventory inventory = new Inventory();

        inventory.addProduct(product, admin);
        inventory.addProduct(product2, admin);
        inventory.addProduct(product3, admin);

        System.out.println(inventory);

        Customer customer = new Customer(2, "John", "john@john.com", "1234 Main St.");

        customer.addToCart(product2);

        System.out.println(customer.getCart());

        Payment payment = new Payment(1);
        payment.checkout(customer);
        paymentMap.addPayment(payment);

        System.out.println(payment);


    }
}
