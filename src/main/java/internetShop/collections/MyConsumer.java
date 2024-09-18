package internetShop.collections;

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}
