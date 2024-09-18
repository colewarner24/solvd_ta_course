package internetShop.products;

import internetShop.Identifiable;
import internetShop.exceptions.InvalidProductException;
import internetShop.utility.IDManager;

public abstract class Product implements Identifiable, Priceable, Conditionable {
    private int id;
    private String name;
    private double price;
    private Condition condition;
    private static IDManager idManager = new IDManager();

    public Product(String name, double price, String condition) throws InvalidProductException {
        this(idManager.assignId(), name, price, Condition.valueOfIgnoreCase(condition));  // Call the other constructor with assigned ID
    }

    public Product(String name, double price, Condition condition) throws InvalidProductException {
        this(idManager.assignId(), name, price, condition);  // Call the other constructor with assigned ID
    }

    public Product(int id, String name, double price, Condition condition) throws InvalidProductException {

        if (id < 0 ){
            throw new InvalidProductException("Invalid product id");
        }
        if (name == null || name.isEmpty()){
            throw new InvalidProductException("Invalid product name");
        }
        if (price < 0){
            throw new InvalidProductException("Invalid product price");
        }
        if (condition == null){
            throw new InvalidProductException("Invalid product condition");
        }
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