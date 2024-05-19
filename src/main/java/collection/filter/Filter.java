package collection.filter;

public interface Filter<T> {
    T apply(T t);
}
