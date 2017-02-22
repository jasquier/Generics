package squier.john.generics;

import java.lang.reflect.TypeVariable;

/**
 * @author John A. Squier
 * My implementaiton of a generic ArrayList using a GenericArray (from Thinking in Java).
 */
public class MyArrayList<E> {

    private Object[] array;

    public MyArrayList() {
        array = new Object[0];
    }

    public MyArrayList(int startSize) {
        array = new Object[startSize];
    }

    public int size() {
        return array.length;
    }

    public boolean add(E element) {
        int firstEmptyIndex = getFirstEmptyIndex();
        if ( firstEmptyIndex < array.length ) {
            array[firstEmptyIndex] =  element;
        }
        else {
            array = grow(array.length+1);
            array[array.length-1] = element;
        }
        return true;
    }

    public boolean add(int index, E element) {
        if ( index < array.length ) {
            array[index] = element;
        }
        else {
            array = grow(array.length+(index));
            array[index] = element;
        }
        return true;
    }

    public E get(int index) {
        if ( index < array.length) {
            return (E)array[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(int index) {
        if ( index < array.length ) {

        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return false;
    }

    public boolean remove(E element) {

        return false;
    }

    private boolean addToNewArrayThatIsLargerByOne(E element) {
        Object[] dest = new Object[array.length + 1];
        copyArray(dest);
        array = dest;
        array[array.length-1] = element;
        return true;
    }

    private boolean addToFirstEmptyIndex(E element) {
        int indexToAddTo = getFirstEmptyIndex();
        array[indexToAddTo] = element;
        return true;
    }


    private int getFirstEmptyIndex() {
        int firstEmptyIndex = 0;
        while ( firstEmptyIndex < array.length && array[firstEmptyIndex] != null ) {
            firstEmptyIndex++;
        }
        return firstEmptyIndex;
    }

    private void copyArray(Object[] dest) {
        System.arraycopy(array, 0, dest, 0, array.length);
    }

    private Object[] grow(int newSize) {
        Object[] dest = new Object[newSize];
        if ( newSize < array.length ) {
            System.arraycopy(array, 0, dest, 0, dest.length);
        }
        else {
            copyArray(dest);
        }
        return dest;
    }
}
