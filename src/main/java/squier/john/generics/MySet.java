package squier.john.generics;

/**
 * @author John A. Squier
 * Many of the methods in MySet rely on already tested methods in MyArrayList.
 */
public class MySet<E> {

    private MyArrayList<E> list;

    public MySet() {
        list = new MyArrayList<>();
    }

    public boolean add(E element) {
        if ( list.contains(element) ) {
            return false;
        }
        else {
            list.add(element);
            return true;
        }
    }

    public void clear() {
        list.clear();
    }

    public boolean contains(E element) {
        return list.contains(element);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean remove(E element) {
        return list.remove(element);
    }

    public int size() {
        return list.size();
    }

    public Object[] toArray() {
        return list.toArray();
    }
}
