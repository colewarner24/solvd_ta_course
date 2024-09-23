package internetShop.interfaces;

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}
