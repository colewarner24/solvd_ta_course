package topic5;

import internetShop.collections.Payments;
import internetShop.exceptions.*;
import internetShop.collections.Inventory;
import internetShop.payments.PayPalPayment;
import internetShop.payments.Payment;
import internetShop.products.*;
import internetShop.users.Admin;
import internetShop.users.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Starting logger");

        try (Admin admin = new Admin(1, "Cole", "19cowarner@gmail.com", "admin")) {

            Payments payments = new Payments();

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

            List<Product> vectorProducts = inventory.getVectorByPrice();
            LOGGER.info("Sorted product vector on price: {}", vectorProducts);

            PriorityQueue<Product> queueProducts = inventory.getPriorityQueueByCondition();
            LOGGER.info("Sorted product priority queue on condition: {}", queueProducts);

            Customer customer = new Customer(2, "John", "john@john.com", "1234 Main St.");

            customer.addToCart(product2);
            customer.addToCart(product4);

            LOGGER.info("Customer cart: {}", customer.getCart().getProductsAsList());

            Payment payment = new Payment(1);

            if (payment.checkout(customer, inventory)) {
                LOGGER.info("Payment successful");
                payments.addPayment(payment);
            } else {
                LOGGER.warn("Payment failed");
            }
            LOGGER.debug(payment);

            System.out.println(inventory.getProductMap());
            inventory.addProduct(product4, admin);
            customer.addToCart(product4);

            PayPalPayment payment2 = new PayPalPayment(2);
            if (payment2.checkout(customer, inventory)) {
                LOGGER.info("Payment successful");
                payments.addPayment(payment2);
            } else {
                LOGGER.warn("Payment failed");
            }
            LOGGER.debug(payment2);
        }
        catch (ProductInInventoryException | InvalidCredentialException | InvalidUserException e) {
            LOGGER.error(e.getMessage());
        }
        catch (Exception e) {
            LOGGER.fatal(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            LOGGER.info("Closing logger");
        }
    }
}