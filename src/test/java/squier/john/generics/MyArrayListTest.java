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
        arrayList1.add(new Integer(10));
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
    public void getElementThatHasAnIndexOutOfBounds() {
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

    @Test
    public void addElementToIndex1WhenArrayListIsSize10() {
        int expectedSizeBefore = 10;
        int expectedSizeAfter = 10;
        String expectedIndexOne = "one";

        int actualSizeBefore = arrayList2.size();
        arrayList2.add(1, "one");
        int actualSizeAfter = arrayList2.size();
        String actualIndexOne = arrayList2.get(1);

        Assert.assertEquals(expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals(expectedSizeAfter, actualSizeAfter);
        Assert.assertEquals(expectedIndexOne, actualIndexOne);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementFromIndexThatDoesNotExist() {
        arrayList1.remove(10);
    }

    @Test(expected = ElementNotFoundException.class)
    public void removeElementThatDoesNotExist() {
        arrayList2.remove("not there");
    }

    @Test
    public void removeTheLastElementByIndex() {
        arrayList1.add(10);
        arrayList1.remove(0);

        int expectedSize = 0;
        int actualSize = arrayList1.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeAnElementInTheMiddleByIndex() {
        arrayList1.add(0);
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.remove(1);
        int expectedSize = 2;
        Integer expectedIndexZero =  0;
        Integer expectedIndexOne = 2;

        int actualSize = arrayList1.size();
        Integer actualIndexZero = arrayList1.get(0);
        Integer actualIndexOne = arrayList1.get(1);

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedIndexZero, actualIndexZero);
        Assert.assertEquals(expectedIndexOne, actualIndexOne);
    }

    @Test
    public void removeAnElementByPassingItIn() {
        MyArrayList<String> temp =  new MyArrayList<>();
        temp.add("hey");

        int expectedSizeAfterAdd = 1;
        int actualSizeAfterAdd = temp.size();

        temp.remove("hey");

        int expectedSizeAfterRemove = 0;
        int actualSizeAfterRemove = temp.size();

        Assert.assertEquals(expectedSizeAfterAdd, actualSizeAfterAdd);
        Assert.assertEquals(expectedSizeAfterRemove, actualSizeAfterRemove);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void attemptToSetElementWithBadIndexTest() {
        arrayList1.set(100, 100);
    }

    @Test
    public void setElementTest() {
        arrayList2.set(5, "hey");
        String expectedElement = "hey";

        String actualElement = arrayList2.get(5);

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void arrayListDoesContainElement() {
        arrayList1.add(10);
        Assert.assertTrue(arrayList1.contains(10));
    }

    @Test
    public void arrayListDoesNotContainElement() {
        Assert.assertFalse(arrayList1.contains(10));
    }

    @Test
    public void clearTest() {
        arrayList1.add(1);
        arrayList1.clear();
        int expectedSize = 1;
        Integer expectedIndexZero = null;

        int actualSize = arrayList1.size();
        Integer actualIndexZero = arrayList1.get(0);

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedIndexZero, actualIndexZero);
    }

    @Test
    public void isEmptyTrueTest() {
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.clear();

        Assert.assertTrue(arrayList1.isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);

        Assert.assertFalse(arrayList1.isEmpty());
    }
}
