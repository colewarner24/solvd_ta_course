package internetShop.collections;

import internetShop.products.Product;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ProductMap extends HashMap<Integer, Product> {
    protected HashMap<Integer, Product> products;

    public ProductMap() {
        products = new HashMap<>();
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public ArrayList<Product> getProductsAsList() {
        return new ArrayList<>(products.values());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products.values()) {
            sb.append(product.toString());
        }
        return sb.toString();
    }

}