package internetShop.maps;

import internetShop.exceptions.InvalidCredentialException;
import internetShop.exceptions.ProductInInventoryException;
import internetShop.products.Product;
import internetShop.users.Admin;

public class Inventory extends ProductMap {

    public void addProduct(Product product, Admin admin) throws InvalidCredentialException, ProductInInventoryException {
        if (admin.verifyCredentials() && !isProductInInventory(product)) {
            products.put(product.getId(), product);
        }
    }

    private boolean isProductInInventory(Product product) throws ProductInInventoryException {

        if (products.containsKey(product.getId())){
            throw new ProductInInventoryException("Product already in inventory with id:  " + product.getId());
        }
        return false;
    }
}
