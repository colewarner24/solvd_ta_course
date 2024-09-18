package internetShop.products;

import java.io.Serializable;

public enum Condition implements Serializable {
    NEW("New", 0),
    EXCELLENT("Excellent", 1),
    GOOD("Good", 2),
    WORN("Worn", 3),
    WELL_WORN("Well Worn", 4);

    private final String description;
    private final int value;

    Condition(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return description;
    }

    public static String optionsString(){
        return "(New, Excellent, Good, Worn, Well Worn)";
    }

    public static Condition valueOfIgnoreCase(String value) {
        if (value == null) {
            return null;
        }

        value = value.trim();

        for (Condition condition : Condition.values()) {
            if (value.equalsIgnoreCase(condition.toString())) {
                return condition;
            }
        }

        return null;
    }
}
