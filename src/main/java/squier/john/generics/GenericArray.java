package squier.john.generics;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;

/**
 * @author John A. Squier
 * Inspiration drawn from "Thinking in Java" by Bruce Eckel.
 */
public class GenericArray<T> {

    private Object[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int size) {
        array = new Object[size];
    }

    public boolean put(int index, T item) {
        array[index] = item;
        return true;
    }

    public T get(int index) {
        return (T)array[index];
    }

    public int size() {
        return array.length;
    }

    public boolean isFull() {
        return getFirstEmptyIndex() == array.length;
    }

    public int getFirstEmptyIndex() {
        int firstEmptyIndex = 0;
        while ( firstEmptyIndex < array.length && array[firstEmptyIndex] != null ) {
            firstEmptyIndex++;
        }
        return firstEmptyIndex;
    }
}
