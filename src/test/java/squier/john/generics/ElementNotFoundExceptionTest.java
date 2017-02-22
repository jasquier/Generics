package squier.john.generics;

import org.junit.Before;

/**
 * @author John A. Squier
 */
public class ElementNotFoundExceptionTest {

    ElementNotFoundException elementNotFoundException;

    @Before
    public void setup() {
        elementNotFoundException = new ElementNotFoundException();
    }
}
