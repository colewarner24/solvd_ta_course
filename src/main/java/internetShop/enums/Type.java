package internetShop.enums;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

public enum Type implements Serializable {
    PANTS("Pants", "Clothing"),
    ACCESSORY("Accessory", "Fashion"),
    SHIRT("Shirt", "Clothing"),
    SHOE("Shoe", "Footwear");

    private final String displayName;
    private final String category;

    Type(String displayName, String category) {
        this.displayName = displayName;
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static String optionsString(){
        return "(Pants, Accessory, Shirt, Shoe)";
    }

    public static Type valueOfIgnoreCase(String value) {
        if (value == null) {
            return null;
        }

        value = StringUtils.trim(value);

        for (Type type : Type.values()) {
            if (value.equalsIgnoreCase(type.toString())) {
                return type;
            }
        }
        return null;
    }

    public static void printTypeDetails(Type type) {
        System.out.println("Type: " + type.name());
        System.out.println("Display Name: " + type.getDisplayName());
        System.out.println("Category: " + type.getCategory());
    }
}
