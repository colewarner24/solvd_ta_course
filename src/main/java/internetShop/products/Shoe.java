package internetShop.products;

import internetShop.enums.Condition;
import internetShop.exceptions.InvalidProductException;
import internetShop.interfaces.Conditionable;
import internetShop.interfaces.Sizable;

public class Shoe extends Product implements Conditionable, Sizable {

    private Integer size;

    public Shoe(String name, double price, Integer size, String condition) throws InvalidProductException {
        super(name, price, condition);
        if (size == null) {
            throw new InvalidProductException("Invalid product size");
        }
        this.size = size;
    }

    public Shoe(int id, String name, double price, Integer size, Condition condition) throws InvalidProductException {
        super(id, name, price, condition);
        if (size == null) {
            throw new InvalidProductException("Invalid product size");
        }
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Shoe: " +
                "id=" + getId() +
                ", name='" + getName() +
                ", price=" + getPrice() +
                ", size=" + getSize() +
                ", condition=" + getCondition();
    }
}
