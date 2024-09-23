package internetShop.interfaces;

import internetShop.enums.Condition;

public interface Conditionable {
    Condition getCondition();

    default int compare(Conditionable conditionable) {
        return Integer.compare(getCondition().getValue(), conditionable.getCondition().getValue());
    }
}
