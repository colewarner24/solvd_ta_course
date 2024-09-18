package internetShop.collections;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
