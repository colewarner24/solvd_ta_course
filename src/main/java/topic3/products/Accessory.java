package topic3.products;

public class Accessory extends Product {

    public Accessory(int id, String name, double price, Condition condition) {
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
