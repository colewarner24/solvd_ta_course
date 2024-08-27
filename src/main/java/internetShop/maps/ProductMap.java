package internetShop.maps;

import internetShop.products.Product;
import java.util.HashMap;

public abstract class ProductMap {
    protected HashMap<Integer, Product> products;

    public ProductMap() {
        products = new HashMap<>();
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public HashMap<Integer, Product> getProductMap() {
        return products;
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