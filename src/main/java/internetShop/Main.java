package internetShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

import internetShop.collections.Cart;
import internetShop.collections.Inventory;
import internetShop.collections.Payments;
import internetShop.exceptions.*;
import internetShop.payments.Payment;
import internetShop.products.*;
import internetShop.users.Admin;
import internetShop.users.Customer;

import static internetShop.collections.Inventory.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Payments payments = new Payments();
        Scanner scanner;
        System.out.println(Arrays.toString(args));
        if (args.length == 0) {
            scanner = new Scanner(System.in);
        } else {
            try{
                File file = FileUtils.getFile(args[0]);
                scanner = new Scanner(file);
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
                return;
            }
        }

        boolean exit = false;

        System.out.println("Welcome to Cole's Internet Shop!");
        while (!exit) {
            System.out.println("Please login");
            System.out.println("Are you a customer or an admin?");
            String action = scanner.nextLine();

            try {
                switch (action) {
                    case "customer" -> {
                        System.out.print("Please enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Please enter your email: ");
                        String email = scanner.nextLine();
                        System.out.println("Please enter your address");
                        String address = scanner.nextLine();
                        Customer customer = new Customer(name, email, address);
                        customerMenu(scanner, customer, inventory, payments);
                    }
                    case "admin" -> {
                        System.out.print("Please enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Please enter your email: ");
                        String password = scanner.nextLine();
                        System.out.print("Please enter your credentials: ");
                        String credentials = scanner.nextLine();
                        Admin admin = new Admin(name, password, credentials);
                        adminMenu(scanner, admin, inventory, payments);
                    }
                    case "exit" -> exit = true;
                    default -> System.out.println("Invalid user type");
                }
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    public static void customerMenu(Scanner scanner, Customer customer, Inventory inventory, Payments payments) throws EmptyCartException, ProductInInventoryException, PaymentNotPaidException {
        boolean exit = false;
        System.out.println("Welcome " + customer.getName() + "!");
        while (!exit){
            System.out.println("What would you like to do?");
            System.out.println("1. View inventory");
            System.out.println("2. Add product to cart");
            System.out.println("3. Remove product from cart");
            System.out.println("4. View cart");
            System.out.println("5. Checkout");
            System.out.println("6. Logout");
            int choice = scanner.nextInt();
            Product product = null;
            int id = 0;
            switch (choice) {
                case 1:
                    inventoryMenu(scanner, inventory);
                    break;
                case 2:
                    System.out.println("What is the id of the product you would like to add?");
                    id = scanner.nextInt();
                    product = inventory.getProduct(id);
                    customer.addToCart(product);
                    System.out.println(product + "added to cart");
                    break;
                case 3:
                    System.out.println("What is the id of the product you would like to remove?");
                    id = scanner.nextInt();
                    product = inventory.getProduct(id);
                    customer.removeFromCart(product);
                    System.out.println(product + "removed from cart");
                    break;
                case 4:
                    System.out.println(customer.getCart());
                    break;
                case 5:
                    Payment payment = new Payment();
                    Cart cart = customer.getCart();
                    if (payment.checkout(customer, inventory)) {
                        payments.addPayment(payment);
                        System.out.println("Payment successful");
                        System.out.println("Shipping items " + cart + " to " + customer.getAddress());
                    } else {
                        System.out.println("Payment failed");
                    }
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void adminMenu(Scanner scanner, Admin admin, Inventory inventory, Payments payments) throws InvalidProductException, InvalidCredentialException, ProductInInventoryException {

        boolean exit = false;
        System.out.println("Welcome Admin!");
        while (!exit){
            System.out.println("What would you like to do?");
            System.out.println("1. Add product to inventory");
            System.out.println("2. Remove product from inventory");
            System.out.println("3. View inventory");
            System.out.println("4. View payments");
            System.out.print("5. Add Discount");
            System.out.println("6. Reflection Update");
            System.out.println("7. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Is the product a Shirt, Pants, Accessory, or Shoe?");
                    scanner.nextLine();
                    String productType = scanner.nextLine();
                    addProduct(scanner, productType, inventory, admin);
                    break;
                case 2:
                    System.out.println("What is the id of the product you would like to remove?");
                    int id = scanner.nextInt();
                    inventory.removeProduct(id);
                    System.out.println("Product: " + id + " removed from inventory");
                    break;
                case 3:
                    inventoryMenu(scanner, inventory);
                    break;
                case 4:
                    paymentMenu(scanner, payments);
                    break;
                case 5:
                    System.out.println("What is the discount percentage?");
                    double discount = scanner.nextDouble();
                    inventory.applyDiscount(discount);
                    System.out.println("Discount applied");
                    break;
                case 6:
                    admin.reflectPaymentClass();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void addProduct(Scanner scanner, String productType, Inventory inventory, Admin admin) throws InvalidProductException, InvalidCredentialException, ProductInInventoryException {
        System.out.print("Please enter the product name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product product = null;
        String size;
        String condition;
        switch (Type.valueOfIgnoreCase(productType)) {
            case SHIRT:
                System.out.print("Please enter the product size " + Size.optionsString() + ": ");
                size = scanner.nextLine();
                System.out.print("Please enter the product condition: ");
                condition = scanner.nextLine();
                product = new Shirt(name, price, size, condition);
                break;
            case PANTS:
                System.out.print("Please enter the product size " + Size.optionsString() + ": ");
                size = scanner.nextLine();
                System.out.print("Please enter the product condition " + Condition.optionsString() + ": ");
                condition = scanner.nextLine();
                product = new Pants(name, price, size, condition);
                break;
            case ACCESSORY:
                System.out.print("Please enter the product condition " + Condition.optionsString() + ": ");
                condition = scanner.nextLine();
                System.out.print("Please enter accessory type: ");
                String accessoryType = scanner.nextLine();
                product = new Accessory(name, price, condition, accessoryType);
                break;
            case SHOE:
                System.out.print("Please enter the shoe size: ");
                int sizeInt = scanner.nextInt();
                System.out.print("Please enter the product condition " + Condition.optionsString() + ": ");
                condition = scanner.nextLine();
                product = new Shoe(name, price, sizeInt, condition);
                break;
            default:
                System.out.println("Invalid product descriptors");
                return;
        }
        inventory.addProduct(product, admin);
        System.out.println(product + " added to inventory");
    }

    public static void inventoryMenu(Scanner scanner, Inventory inventory) {
        System.out.println(inventory);
        System.out.println("Additional options? (y/n)");
        scanner.nextLine();
        String choice = scanner.nextLine();
        if (choice.equals("n")) {
            return;
        }
        Stream<Product> productStream = inventory.getProductStream();
        System.out.println("Max Price: (double or none)");
        try{
            double maxPrice = scanner.nextDouble();
            productStream = filterProductsByPriceMax(productStream, maxPrice);
        }
        catch (InputMismatchException ignored){ }

        System.out.println("Sort by Price (p default) or Condition (c)");
        scanner.nextLine();
        String sort = scanner.nextLine();
        if (sort.equals("c")){
            productStream = sortProductsByCondition(productStream);
        }
        else{
            productStream = sortProductsByPrice(productStream);
        }

        System.out.println("verbose? (y/n)");
        String verbose = scanner.nextLine();
        System.out.println(verbose);
        if (verbose.equals("y")) {
            printAllProductDetails(productStream);
        }
        else {
            printProductNames(productStream);
        }
    }

    public static void paymentMenu(Scanner scanner, Payments payments) {
        payments.printAllPaymentDetails();
        System.out.println("Total Revenue Earned: " + payments.getTotalAmount());
    }
}

