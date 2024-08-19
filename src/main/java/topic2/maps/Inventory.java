package topic2.maps;

import topic2.products.Product;
import topic2.users.Admin;

public class Inventory extends ProductMap {

    public void addProduct(Product product, Admin admin) {
        if (admin.verifyCredentials() && !isProductInInventory(product)) {
            products.put(product.getId(), product);
        }
    }

    private boolean isProductInInventory(Product product) {
        return products.containsKey(product.getId());
    }
}
