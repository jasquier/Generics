package squier.john.generics;

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
        if ( index == array.length-1 ) {
            array = grow(array.length-1);
        }
        else if ( index < array.length-1 ) {
            for ( int i = index; i < array.length-1; i++ ) {
                array[i] =  array[i+1];
                array = grow(array.length-1);
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return false;
    }

    public boolean remove(E element) {
        if ( contains(element) ) {
            remove(getFirstIndexOf(element));
        }
        else {
            throw new ElementNotFoundException();
        }
        return false;
    }

    public boolean set(int index, E element) {
        if ( index < array.length ) {
            array[index] = element;
            return true;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean contains(E element) {
        for ( int i = 0; i < array.length; i++ ) {
            if ( array[i] == element ) {
                return true;
            }
        }
        return false;
    }

    public boolean clear() {
        for ( int i = 0; i < array.length; i++ ) {
            array[i] = null;
        }
        return true;
    }

    public boolean isEmpty() {
        return getLastEmptyIndex() == array.length;
    }

    private int getFirstIndexOf(E element) {
        int index = 0;
        if ( contains(element) ) {
            for ( int i  = 0; i < array.length; i++ ) {
                if ( array[i] == element) {
                    return index;
                }
                else {
                    index++;
                }
            }
            return index;
        }
        else {
            throw new ElementNotFoundException();
        }
    }

    private int getFirstEmptyIndex() {
        int firstEmptyIndex = 0;
        while ( firstEmptyIndex < array.length && array[firstEmptyIndex] != null ) {
            firstEmptyIndex++;
        }
        return firstEmptyIndex;
    }

    private int getLastEmptyIndex() {
        int lastEmptyIndex = 0;
        while ( lastEmptyIndex < array.length && array[lastEmptyIndex] == null ) {
            lastEmptyIndex++;
        }
        return lastEmptyIndex;
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
