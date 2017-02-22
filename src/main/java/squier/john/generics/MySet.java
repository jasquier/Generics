package squier.john.generics;

/**
 * Created by johnsquier on 2/22/17.
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
        return null;
    }
}
