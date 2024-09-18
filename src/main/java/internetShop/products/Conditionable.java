package internetShop.products;

public interface Conditionable {
    Condition getCondition();

    default int compare(Conditionable conditionable) {
        return Integer.compare(getCondition().getValue(), conditionable.getCondition().getValue());
    }
}
