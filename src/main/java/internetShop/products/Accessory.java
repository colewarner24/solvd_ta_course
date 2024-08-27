package internetShop.products;

import internetShop.exceptions.InvalidProductException;

public class Accessory extends Product {

    public Accessory(int id, String name, double price, Condition condition) throws InvalidProductException {
        super(id, name, price, condition);
    }

    @Override
    public String toString() {
        return "Accessory: " +
                "id=" + getId() +
                ", name='" + getName() +
                ", price=" + getPrice() +
                ", condition=" + getCondition();
    }
}
