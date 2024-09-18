package internetShop.payments;

import java.io.Serializable;

public enum Status implements Serializable {
    NOT_PAID("Not Paid", 0),
    PENDING("Pending", 1),
    PAID("Paid", 2);

    private final String description;
    private final int value;

    Status(String description, int value) {
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

    public static String optionsString() {
        return "(Not Paid, Pending, Paid)";
    }

    public static Status valueOfIgnoreCase(String value) {
        if (value == null) {
            return null;
        }

        value = value.trim();

        for (Status status : Status.values()) {
            if (value.equalsIgnoreCase(status.toString())) {
                return status;
            }
        }

        return null;
    }
}
