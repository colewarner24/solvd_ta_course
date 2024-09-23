package internetShop.interfaces;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
