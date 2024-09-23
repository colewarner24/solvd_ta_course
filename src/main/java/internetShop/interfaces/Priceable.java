package internetShop.interfaces;

public interface Priceable {
    double getPrice();

    default int compare(Priceable priceable) {
        return Double.compare(getPrice(), priceable.getPrice());
    }
}
