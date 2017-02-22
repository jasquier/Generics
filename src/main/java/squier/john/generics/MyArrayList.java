package squier.john.generics;

/**
 * @author John A. Squier
 * My implementaiton of a generic ArrayList using a GenericArray (from Thinking in Java).
 */
public class MyArrayList<E> {

    private GenericArray<E> array;
    private int arrayListSize;

    public MyArrayList() {
        array = new GenericArray<E>(0);
        arrayListSize = 0;
    }

    public MyArrayList(int startSize) {
        array = new GenericArray<E>(startSize);
        arrayListSize = startSize;
    }

    public int size() {
        return array.size();
    }

    public boolean add(E element) {
        boolean added = false;
        if ( array.isFull() ) {
            added = this.addToNewArrayThatIsLargerByOne(element);
        }
        else {
            added = this.addToFirstEmptyIndex(element);
        }
        arrayListSize = array.size();
        return added;
    }

    public boolean add(int index, E element) {
        return false;
    }

    public E get(int index) {
        if ( index < arrayListSize) {
            return array.get(index);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean addToNewArrayThatIsLargerByOne(E element) {
        GenericArray<E> copy = copyArrayAndIncreaseSizeByOne();

        boolean added = copy.put(array.size(), element);
        array = copy;

        return added;
    }

    private boolean addToFirstEmptyIndex(E element) {
        int indexToAddTo = array.getFirstEmptyIndex();

        boolean added = array.put(indexToAddTo, element);

        return added;
    }

    private GenericArray<E> copyArrayAndIncreaseSizeByOne() {
        GenericArray<E> temp = new GenericArray<E>(array.size()+1);
        for ( int i = 0; i < array.size(); i++ ) {
            temp.put(i, array.get(i));
        }
        return temp;
    }
}
