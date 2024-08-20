package topic3.products;

public class Shirt extends Product implements Conditionable, Sizable {

    private Size size;

    public Shirt(int id, String name, double price, Size size, Condition condition) {
        super(id, name, price, condition);
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