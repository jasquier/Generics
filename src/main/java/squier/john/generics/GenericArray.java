package squier.john.generics;

import java.lang.reflect.Array;

/**
 * @author John A. Squier
 * Inspiration drawn from "Thinking in Java" by Bruce Eckel.
 */
public class GenericArray<T> {

    private T[] myArray;

    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> type, int size) {
        myArray = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        myArray[index] = item;
    }

    public T get(int index) {
        return myArray[index];
    }

    public int size() {
        return myArray.length;
    }
}
