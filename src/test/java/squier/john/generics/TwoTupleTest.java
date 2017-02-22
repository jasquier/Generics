package squier.john.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class TwoTupleTest {

    TwoTuple<Integer, String> tuple1, tuple2, tuple3;

    @Before
    public void setup() {
        tuple1 = new TwoTuple<>(1, "one");
        tuple2 = new TwoTuple<>(1, "two");
        tuple3 = new TwoTuple<>(3, "three");
    }

    @Test
    public void tuplesEqualTest() {
        Assert.assertTrue(tuple1.equals(tuple2));
    }

    @Test
    public void tuplesNotEqualTest() {
        Assert.assertFalse(tuple1.equals(tuple3));
    }
}
