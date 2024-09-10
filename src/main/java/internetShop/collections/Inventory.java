package internetShop.collections;

import internetShop.exceptions.InvalidCredentialException;
import internetShop.exceptions.ProductInInventoryException;
import internetShop.products.Conditionable;
import internetShop.products.Priceable;
import internetShop.products.Product;
import internetShop.products.Priceable;
import internetShop.users.Admin;

import java.util.*;


public class Inventory extends ProductMap {

    public void addProduct(Product product, Admin admin) throws InvalidCredentialException, ProductInInventoryException {
        if (admin.verifyCredentials()) {
            if (isProductInInventory(product)){
                throw new ProductInInventoryException("Product already in inventory with id: " +  product.getId());
            }
            getProducts().put(product.getId(), product);
        }
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
}
