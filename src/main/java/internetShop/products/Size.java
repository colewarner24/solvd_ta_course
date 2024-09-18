package internetShop.products;

import java.io.Serializable;

public enum Size implements Serializable {
    XS("Extra Small", 1),
    S("Small", 2),
    M("Medium", 3),
    L("Large", 4),
    XL("Extra Large", 5),
    XXL("Double Extra Large", 6);

    private final String displayName;
    private final int sizeOrder;

    Size(String displayName, int sizeOrder) {
        this.displayName = displayName;
        this.sizeOrder = sizeOrder;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getSizeOrder() {
        return sizeOrder;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static int compare(Size size1, Size size2) {
        return Integer.compare(size1.getSizeOrder(), size2.getSizeOrder());
    }

    public static String optionsString() {
        return "(XS, S, M, L, XL, XXL)";
    }

    public static Size valueOfIgnoreCase(String value) {
        if (value == null) {
            return null;
        }

        value = value.trim();

        for (Size size : Size.values()) {
            if (value.equalsIgnoreCase(size.name()) || value.equalsIgnoreCase(size.toString())) {
                return size;
            }
        }
        return null;
    }

    public static void printSizeDetails(Size size) {
        System.out.println("Size: " + size.name());
        System.out.println("Display Name: " + size.getDisplayName());
        System.out.println("Size Order: " + size.getSizeOrder());
    }
}
