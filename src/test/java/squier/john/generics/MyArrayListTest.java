package squier.john.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class MyArrayListTest {

    private MyArrayList<Integer> arrayList1;
    private MyArrayList<String> arrayList2;

    @Before
    public void setup() {
        arrayList1 = new MyArrayList<>();
        arrayList2 = new MyArrayList<>(10);
    }

    @Test
    public void oneArgConstructorCreatesArrayListOfCorrectSize() {
        int expected = 10;

        int actual = arrayList2.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAnIntegerToTheArrayListTest() {
        int expectedSizeBefore = 0;
        int expectedSizeAfter = 1;
        Integer expected = 10;

        int actualSizeBefore = arrayList1.size();
        arrayList1.add(10); // auto-boxing
        int actualSizeAfter = arrayList1.size();
        Integer actual = arrayList1.get(0);

        Assert.assertEquals(expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals(expectedSizeAfter, actualSizeAfter);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAStringToASize10ArrayListTest() {
        int expectedSizeBefore = 10;
        int expectedSizeAfter = 10;
        String expected = "hey";

        int actualSizeBefore = arrayList2.size();
        arrayList2.add("hey");
        int actualSizeAfter = arrayList2.size();
        String actual = arrayList2.get(0);

        Assert.assertEquals(expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals(expectedSizeAfter, actualSizeAfter);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ensureThatACopiedArrayListContainsAllElements() {
        arrayList1.add(0);
        arrayList1.add(1);

        Integer expectedElementZero = 0;
        Integer expectedElementOne = 1;

        Integer actualElementZero = arrayList1.get(0);
        Integer actualElementOne = arrayList1.get(1);

        Assert.assertEquals(expectedElementZero, actualElementZero);
        Assert.assertEquals(expectedElementOne, actualElementOne);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBounds() {
        arrayList1.get(100);
    }

    @Test
    public void addElementToIndex9WhenArrayListIsSizeOne() {
        arrayList1.add(0);
        int expectedSizeBefore = 1;
        int expectedSizeAfter = 10;
        Integer expectedIndexZero = 0;
        Integer expectedIndexNine = 9;

        int actualSizeBefore = arrayList1.size();
        arrayList1.add(9, 9);
        int actualSizeAfter = arrayList1.size();
        Integer actualIndexZero = arrayList1.get(0);
        Integer actualIndexNine = arrayList1.get(9);

        Assert.assertEquals(expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals(expectedSizeAfter, actualSizeAfter);
        Assert.assertEquals(expectedIndexZero, actualIndexZero);
        Assert.assertEquals(expectedIndexNine, actualIndexNine);
    }
}
