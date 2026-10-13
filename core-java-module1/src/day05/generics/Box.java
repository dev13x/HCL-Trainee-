package day05.generics;

/*
 * Day 05 - Generic class with a single type parameter <T>
 * T is replaced by a concrete reference type (e.g., Box<Integer>, Box<String>) when instantiated.
 */
public class Box<T> {

    private T item;

    public Box(T item) {
        this.item = item;
    }

    public T getValue() {
        return item;
    }

    public void setValue(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Box[" + item + "]";
    }
}
