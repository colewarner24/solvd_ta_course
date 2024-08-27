package internetShop.products;

import internetShop.exceptions.InvalidProductException;

public class Pants extends Product implements Conditionable, Sizable {

    private Size size;

    public Pants(int id, String name, double price, Size size, Condition condition) throws InvalidProductException {
        super(id, name, price, condition);
        if (size == null) {
            throw new InvalidProductException("Invalid product size");
        }
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Pants: " +
                "id=" + getId() +
                ", name='" + getName() +
                ", price=" + getPrice() +
                ", size='" + getCondition();
    }
}
