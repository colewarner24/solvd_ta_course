package internetShop.products;

import internetShop.exceptions.InvalidProductException;

public class Accessory extends Product {
    AccessoryType accessoryType;

    public Accessory(String name, double price, String condition, String accessoryType) throws InvalidProductException {
        super(name, price, condition);
        AccessoryType type = AccessoryType.valueOfIgnoreCase(accessoryType);
        if (type == null) {
            throw new InvalidProductException("Invalid accessory type");
        }
        this.accessoryType = type;
    }

    public Accessory(int id, String name, double price, Condition condition, AccessoryType accessoryType) throws InvalidProductException {
        super(id, name, price, condition);
        this.accessoryType = accessoryType;
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
