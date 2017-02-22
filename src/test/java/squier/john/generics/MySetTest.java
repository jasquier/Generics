package squier.john.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by johnsquier on 2/22/17.
 */
public class MySetTest {

    private MySet<Integer> seti;
    private MySet<String> sets;

    @Before
    public void setup() {
        seti = new MySet<>();
        sets = new MySet<>();
    }

    @Test
    public void addItemMultipleTimesToEnsureOnlyOneIsStoredTest() {
        boolean addedOnce = seti.add(10);
        boolean addedAgain = seti.add(10);
        int expectedSize = 1;

        int actualSize = seti.size();

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertTrue(addedOnce);
        Assert.assertFalse(addedAgain);
    }
}
