package internetShop.collections;

import internetShop.exceptions.InvalidCredentialException;
import internetShop.exceptions.ProductInInventoryException;
import internetShop.products.Conditionable;
import internetShop.products.Priceable;
import internetShop.products.Product;
import internetShop.products.Priceable;
import internetShop.users.Admin;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


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

    public List<Product> filterProductsByPriceMax(double maxPrice) {
        Predicate<Product> byPrice = product -> product.getPrice() < maxPrice;
        return getProducts().values().stream()
                .filter(byPrice)
                .collect(Collectors.toList());
    }

    public List<String> getProductNames() {
        Function<Product, String> toName = Product::getName;
        return getProducts().values().stream()
                .map(toName)
                .collect(Collectors.toList());
    }

    public List<String> getProductNames(double MaxPrice) {
        Function<Product, String> toName = Product::getName;
        return this.filterProductsByPriceMax(MaxPrice).stream()
                .map(toName)
                .collect(Collectors.toList());
    }

    public void printAllProductDetails(double maxPrice) {
        Consumer<Product> printDetails = product -> System.out.println(product);
        this.filterProductsByPriceMax(maxPrice).forEach(printDetails);
    }

    public void printAllProductDetails() {
        Consumer<Product> printDetails = product -> System.out.println(product);
        getProducts().values().forEach(printDetails);
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
