package internetShop.collections;

import internetShop.exceptions.InvalidCredentialException;
import internetShop.exceptions.ProductInInventoryException;
import internetShop.interfaces.Conditionable;
import internetShop.interfaces.Priceable;
import internetShop.products.Product;
import internetShop.users.Admin;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;


public class Inventory extends ProductMap {

    public void addProduct(Product product, Admin admin) throws InvalidCredentialException, ProductInInventoryException {
        if (admin.verifyCredentials()) {
            if (isProductInInventory(product)){
                throw new ProductInInventoryException("Product already in inventory with id: " +  product.getId());
            }
            getProducts().put(product.getId(), product);
        }
    }

    public Product getProduct(int id){
        return getProducts().get(id);
    }

    public Stream<Product> getProductStream(){
        return getProducts().values().stream();
    }

    public static Stream<Product> sortProductsByPrice(Stream<Product> stream){
        return stream.sorted(Comparator.comparing(Product::getPrice));
    }

    public static Stream<Product> sortProductsByCondition(Stream<Product> stream){
        return stream.sorted(Comparator.comparing(Product::getCondition));

    }

    public static Stream<Product> filterProductsByPriceMax(Stream<Product> stream, double maxPrice) {
        Predicate<Product> byPrice = product -> product.getPrice() < maxPrice;
        return stream.filter(byPrice);
    }

    public static void printProductNames(Stream<Product> stream) {
        Function<Product, String> toName = Product::getName;
        List<String> productList = stream.map(toName).toList();
        for (String productString : productList){
            System.out.println(productString);
        }
    }

    public static void printAllProductDetails(Stream<Product> stream) {
        Consumer<Product> printDetails = product -> System.out.println(product);
        stream.forEach(printDetails);
    }

    public void applyDiscount(double discountPercentage) {
        UnaryOperator<Product> applyDiscount = product -> {
            double discountedPrice = product.getPrice() * (1 - discountPercentage / 100);
            product.changePrice(discountedPrice);
            return product;
        };

        getProducts().values().stream()
                .map(applyDiscount)
                .forEach(product -> System.out.println("Discounted product: " + product));
    }

    public PriorityQueue<Product> getPriorityQueueByPrice(){
        PriorityQueue<Product> queue = new PriorityQueue<>(getProducts().values().size(), Priceable::compare);
        queue.addAll(getProducts().values());
        return queue;
    }

    public PriorityQueue<Product> getPriorityQueueByCondition(){
        PriorityQueue<Product> queue = new PriorityQueue<>(getProducts().values().size(), Conditionable::compare);
        queue.addAll(getProducts().values());
        return queue;
    }

    public Vector<Product> getVectorByPrice(){
        Vector<Product> list = new Vector<>(getProducts().values());
        list.sort(Priceable::compare);
        return list;
    }

    public Vector<Product> getVectorByCondition(){
        Vector<Product> list = new Vector<>(getProducts().values());
        list.sort(Conditionable::compare);
        return list;
    }

    private boolean isProductInInventory(Product product) {
        return getProducts().containsKey(product.getId());
    }

    public void removeProduct(Product product) throws ProductInInventoryException {
        if (!isProductInInventory(product)){
            throw new ProductInInventoryException("Product not found with id: " + product.getId());
        }
        getProducts().remove(product.getId());
    }

    public void removeProduct(int id) throws ProductInInventoryException {
        if (!getProducts().containsKey(id)){
            throw new ProductInInventoryException("Product not found with id: " + id);
        }
        getProducts().remove(id);
    }
}
