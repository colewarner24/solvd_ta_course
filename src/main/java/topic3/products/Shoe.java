package topic3.products;

public class Shoe extends Product implements Conditionable, Sizable {

    private Integer size;

    public Shoe(int id, String name, double price, Integer size, Condition condition) {
        super(id, name, price, condition);
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
