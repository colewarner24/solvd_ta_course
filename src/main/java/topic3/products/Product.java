package topic3.products;

import topic3.Identifiable;

public abstract class Product implements Identifiable, Priceable, Conditionable {
    private int id;
    private String name;
    private double price;
    private Condition condition;

    public Product(int id, String name, double price, Condition condition) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void changePrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Product " + id + ": name=" + name + ", price=" + price + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product product)) {
            return false;
        }
        return product.getId() == id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}