package internetShop.products;

import internetShop.exceptions.InvalidProductException;

public class Shoe extends Product implements Conditionable, Sizable {

    private Integer size;

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
