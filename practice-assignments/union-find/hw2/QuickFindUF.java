package hw2;

import java.util.Arrays;

public class QuickFindUF {

    private int[] id;   // the component id of each element
    private int count;   // the number of components

    // Creates n elements, 0 through n - 1, each in its own component.
    public QuickFindUF(int n) {
        // TODO
    }

    // Returns the component identifier for p.
    public int find(int p) {
        return 0; // TODO
    }

    // Returns true if p and q are in the same component.
    public boolean connected(int p, int q) {
        return false; // TODO
    }

    // Connects p and q. If they're already connected, does nothing.
    public void union(int p, int q) {
        // TODO
    }

    // Returns the number of components.
    public int count() {
        return 0; // TODO
    }

    // Returns the array's contents, for debugging. (Already done.)
    public String toString() {
        return Arrays.toString(id);
    }
}
