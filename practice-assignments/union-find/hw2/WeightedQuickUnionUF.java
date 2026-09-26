package hw2;

import java.util.Arrays;

// EXTRA CREDIT
public class WeightedQuickUnionUF {

    private int[] parent;  // the parent of each element
    private int[] size;    // size[r] = number of elements in the tree rooted at r
    private int count;     // the number of components

    // Creates n elements, 0 through n - 1, each in its own component.
    // Every element starts as the root of a tree of size 1.
    public WeightedQuickUnionUF(int n) {
        // TODO
    }

    // Returns the root of p's tree. (Same as in QuickUnionUF.)
    public int find(int p) {
        return 0; // TODO
    }

    // Returns true if p and q are in the same component.
    public boolean connected(int p, int q) {
        return false; // TODO
    }

    // Connects p and q. If they're already connected, does nothing.
    // Attaches the root of the smaller tree to the root of the larger tree,
    // then updates the larger root's size.
    public void union(int p, int q) {
        // TODO
    }

    // Returns the number of components.
    public int count() {
        return 0; // TODO
    }

    // Returns the parent array's contents, for debugging. (Already done.)
    public String toString() {
        return Arrays.toString(parent);
    }
}
