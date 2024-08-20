package topic3.products;

public interface Priceable {
    double getPrice();

    default int comparePrice(Priceable priceable) {
        return Double.compare(getPrice(), priceable.getPrice());
    }
}
