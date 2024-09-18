package internetShop.products;

import java.io.Serializable;

public enum AccessoryType implements Serializable {
    WATCH("Watch", "Wristwear"),
    BELT("Belt", "Waistwear"),
    SUNGLASSES("Sunglasses", "Eyewear"),
    HAT("Hat", "Headwear"),
    JEWELRY("Jewelry", "Bodywear");

    private final String displayName;
    private final String category;

    AccessoryType(String displayName, String category) {
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

    public static String optionsString() {
        return "(Watch, Belt, Sunglasses, Hat, Jewelry)";
    }

    public static AccessoryType valueOfIgnoreCase(String value) {
        if (value == null) {
            return null;
        }

        value = value.trim();

        for (AccessoryType accessory : AccessoryType.values()) {
            if (value.equalsIgnoreCase(accessory.name()) || value.equalsIgnoreCase(accessory.toString())) {
                return accessory;
            }
        }
        return null;
    }

    public static void printAccessoryDetails(AccessoryType accessory) {
        System.out.println("Accessory: " + accessory.name());
        System.out.println("Display Name: " + accessory.getDisplayName());
        System.out.println("Category: " + accessory.getCategory());
    }
}
