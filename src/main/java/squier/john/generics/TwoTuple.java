package squier.john.generics;

/**
 * @author John A. Squier
 * From "Thinking in Java" by Bruce Eckel.
 */
public class TwoTuple<A,B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    // for a map we are only concerned if the keys are equal
    public boolean equals(TwoTuple other) {
        return this.first.equals(other.first);
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
