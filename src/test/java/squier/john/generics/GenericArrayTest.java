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
        genericArrayI = new GenericArray<>(Integer.class, 10);
        genericArrayS = new GenericArray<>(String.class, 5);
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
        int expectedSize = 5;
        String expected = "test";

        int actualSize = genericArrayS.size();
        genericArrayS.put(4, "test");
        String actual = genericArrayS.get(4);

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expected, actual);
    }

}
