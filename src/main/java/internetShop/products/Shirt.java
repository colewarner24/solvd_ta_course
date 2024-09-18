package internetShop.products;

import internetShop.exceptions.InvalidProductException;

public class Shirt extends Product implements Conditionable, Sizable {

    private Size size;

    public Shirt(String name, double price, String size, String condition) throws InvalidProductException {
        super(name, price, condition);
        this.size = Size.valueOfIgnoreCase(size);
    }

    public Shirt(int id, String name, double price, Size size, Condition condition) throws InvalidProductException {
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
        return "Shirt: " +
                "id=" + getId() +
                ", name='" + getName() +
                ", price=" + getPrice() +
                ", size='" + getSize() +
                ", condition='" + getCondition();
    }
}