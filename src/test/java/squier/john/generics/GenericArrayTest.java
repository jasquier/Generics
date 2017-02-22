package squier.john.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class GenericArrayTest {

    private GenericArray<Integer> genericArrayI;
    private GenericArray<String> genericArrayS;

    @Before
    public void setup() {
        genericArrayI = new GenericArray<>(10);
        genericArrayS = new GenericArray<>(1);
    }

    @Test
    public void putAndGetAnIntegerInTheArrayTest() {
        int expectedSize = 10;
        Integer expected = 1;

        int actualSize = genericArrayI.size();
        genericArrayI.put(0, 1);
        Integer actual = genericArrayI.get(0);

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putAndGetAStringInTheArrayTest() {
        int expectedSize = 1;
        String expected = "test";

        int actualSize = genericArrayS.size();
        genericArrayS.put(0, "test");
        String actual = genericArrayS.get(0);

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void arrayIsNotFullTest() {
        boolean expected = false;

        boolean actual = genericArrayI.isFull();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void arrayIsFullTest() {
        boolean expected = true;

        genericArrayS.put(0, "");
        boolean actual = genericArrayS.isFull();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstEmptyIndexTest() {
        int expected = 0;

        int actual = genericArrayS.getFirstEmptyIndex();

        Assert.assertEquals(expected, actual);
    }
}
