package topic3.maps;

import topic3.products.Product;
import topic3.users.Admin;

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
