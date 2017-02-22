package squier.john.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class MyMapTest {

    MyMap<Integer, String> map;

    @Before
    public void setup() {
        map = new MyMap<>();
    }

    @Test(expected = ElementNotFoundException.class)
    public void getKeyThatIsNotInMapTest() {
        String value = map.get(2);
    }

    @Test
    public void getKeyThatIsInMapTest() {
    }

    @Test
    public void putTest() {
        map.put(1, "one");
        map.put(2, "two");

    }
}
