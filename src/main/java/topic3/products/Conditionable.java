package topic3.products;

public interface Conditionable {
    Condition getCondition();

    static int conditionValue(Condition condition) {
        return switch (condition) {
            case NEW -> 0;
            case EXCELLENT -> 1;
            case GOOD -> 2;
            case WORN -> 3;
            case WELL_WORN -> 4;
        };
    }

    default int compareCondition(Conditionable conditionable) {
        return Integer.compare(conditionValue(getCondition()), conditionValue(conditionable.getCondition()));
    }


}
