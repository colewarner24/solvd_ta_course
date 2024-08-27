package topic4;

import internetShop.exceptions.*;
import internetShop.maps.Inventory;
import internetShop.maps.PaymentMap;
import internetShop.payments.PayPalPayment;
import internetShop.payments.Payment;
import internetShop.products.*;
import internetShop.users.Admin;
import internetShop.users.Customer;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Starting logger");

        try (Admin admin = new Admin(1, "Cole", "19cowarner@gmail.com", "admin")) {

            PaymentMap paymentMap = new PaymentMap();

            Product product = null;
            Product product2 = null;
            Product product3 = null;
            Product product4 = null;
            Product product5 = null;
            Product product6 = null;
            try {
                product = new Shirt(1, "T-Shirt", 20.00, Size.L, Condition.NEW);
                product2 = new Pants(2, "Cargo Pants", 14.50, Size.M, Condition.WORN);
                product3 = new Shirt(3, "Sweatshirt", 25.00, Size.XL, Condition.EXCELLENT);
                product4 = new Accessory(4, "Necklace", 30.00, Condition.WELL_WORN);
                product5 = new Shoe(5, "Sneakers", 50.00, 13, Condition.GOOD);
                // throws exception
                product6 = new Shoe(6, "", 50.00, 13, Condition.GOOD);
            } catch (InvalidProductException e) {
                LOGGER.error((e.getMessage()));
            }

            Inventory inventory = new Inventory();

            try {
                inventory.addProduct(product, admin);
                inventory.addProduct(product2, admin);
                inventory.addProduct(product3, admin);
                inventory.addProduct(product4, admin);
                inventory.addProduct(product5, admin);
                //throws ProductInInventoryException exception
                //inventory.addProduct(product, admin);
            } catch (ProductInInventoryException | InvalidCredentialException e) {
                LOGGER.error(e.getMessage());
            }

            List<Product> products = new ArrayList<>(inventory.getProductMap().values());
            products.sort(Priceable::comparePrice);
            LOGGER.info("Sorted product list on price: {}", products);


            products.sort(Conditionable::compareCondition);
            LOGGER.info("Sorted product list on condition: {}", products);

            Customer customer = new Customer(2, "John", "john@john.com", "1234 Main St.");

            //will throw InvalidUserException exception
            Customer customer2 = new Customer(-1, "Amy", "amy@amy.com", "1234 Main St.");

            customer.addToCart(product2);

            LOGGER.info("Customer cart: {}", customer.getCart());

            Payment payment = new Payment(1);


            try {
                if (payment.checkout(customer)) {
                    LOGGER.info("Payment successful");
                    paymentMap.addPayment(payment);
                } else {
                    LOGGER.warn("Payment failed");
                }
                LOGGER.debug(payment);

                inventory.addProduct(product4, admin);
                customer.addToCart(product4);

                PayPalPayment payment2 = new PayPalPayment(2);
                if (payment2.checkout(customer)) {
                    LOGGER.info("Payment successful");
                    paymentMap.addPayment(payment2);
                } else {
                    LOGGER.warn("Payment failed");
                }
                LOGGER.debug(payment2);
            }
            catch (EmptyCartException e) {
                LOGGER.error(e.getMessage());
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new RuntimeException(e);
            }

        } catch (InvalidUserException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception e) {
            LOGGER.fatal(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            LOGGER.info("Closing logger");
        }
    }
}