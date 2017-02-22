package squier.john.generics;

/**
 * @author John A. Squier
 */
public class MyMap<K,V> {

    private MyArrayList<TwoTuple<K,V>> keysAndValues;

    public MyMap() {
        keysAndValues = new MyArrayList<>();
    }

    public void clear() {
        keysAndValues.clear();
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public V put(K key, V value) {
        TwoTuple<K,V> entry = new TwoTuple<>(key, value);

        if ( keysAndValues.contains(entry) ) {
            // gotta change the value
            keysAndValues.set(keysAndValues.indexOf(entry), entry);
        }
        else {
            keysAndValues.add(entry);
        }
        return value;
    }

    public V get(K key) {
        int indexOfKey = keysAndValues.indexOf(new TwoTuple<>(key, null));
        System.out.println(indexOfKey);

        return null;
        //return keysAndValues.get(keysAndValues.indexOf(new TwoTuple(key, null))).second;
    }
}
