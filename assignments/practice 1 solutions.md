# Practice 1 Solutions

## Exercise 1: ArrayBasics

```java
package practice;

import java.util.Arrays;

public class ArrayBasics {

    // Returns a new array of length n where a[i] == i.
    public static int[] identity(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }

    // Returns how many times x appears in a.
    public static int count(int[] a, int x) {
        int total = 0;
        for (int value : a) {
            if (value == x) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = identity(6);
        System.out.println(Arrays.toString(a));

        int[] b = {0, 0, 0, 1, 2, 2, 2, 2};
        System.out.println(count(b, 2));
        System.out.println(count(b, 7));
    }
}
```

**Why the indexed loop in `identity` but for-each in `count`?** `identity` writes into the array, so it needs the index `i`. `count` only reads values, so for-each is simpler. A for-each loop can't modify the array, because `value` is a copy.

**Returning an array.** The return type `int[]` works like any other type. The caller gets a reference to the same array the method created.

## Exercise 2: Labels

```java
package practice;

import java.util.Arrays;

public class Labels {

    private int[] labels;

    // Creates n labels, where element i starts with label i.
    public Labels(int n) {
        labels = new int[n];
        for (int i = 0; i < n; i++) {
            labels[i] = i;
        }
    }

    // Returns the label of element i.
    public int get(int i) {
        return labels[i];
    }

    // Changes every x in the array to y.
    public void replaceAll(int x, int y) {
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] == x) {
                labels[i] = y;
            }
        }
    }

    // Returns how many different labels are currently in use.
    public int countDistinct() {
        boolean[] seen = new boolean[labels.length];
        int distinct = 0;
        for (int i = 0; i < labels.length; i++) {
            int label = labels[i];
            if (!seen[label]) {
                seen[label] = true;
                distinct++;
            }
        }
        return distinct;
    }

    public String toString() {
        return Arrays.toString(labels);
    }

    public static void main(String[] args) {
        Labels L = new Labels(8);
        System.out.println(L);
        System.out.println(L.countDistinct());

        L.replaceAll(1, 0);
        L.replaceAll(2, 0);
        L.replaceAll(5, 4);
        System.out.println(L);
        System.out.println(L.get(2));
        System.out.println(L.countDistinct());
    }
}
```

**Declaring vs. creating the array.** `private int[] labels;` only declares the field. The array doesn't exist until the constructor runs `labels = new int[n];`. Writing `int[] labels = new int[n];` inside the constructor is a common bug: it creates a new local variable that hides the field, and the field stays `null`.

**Why `println(L)` works.** When you print an object, Java calls its `toString()` method. Without one, you'd see something like `practice.Labels@1b6d3586`.

**The `seen` trick.** A `boolean[]` starts out all `false`. Using each label as an index into `seen` lets you check "have I counted this one already?" in one step.

## Exercise 3: Pointers

```java
package practice;

public class Pointers {

    private int[] next;

    public Pointers(int[] next) {
        this.next = next;
    }

    // Follows next[] starting from i until reaching an element that
    // points to itself, and returns that element.
    public int follow(int i) {
        while (next[i] != i) {
            i = next[i];
        }
        return i;
    }

    // Returns how many hops follow(i) takes.
    public int steps(int i) {
        int counter = 0;
        while (next[i] != i) {
            i = next[i];
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 5, 5, 5};
        Pointers p = new Pointers(arr);
        System.out.println(p.follow(0) + " " + p.steps(0));
        System.out.println(p.follow(3) + " " + p.steps(3));
        System.out.println(p.follow(1) + " " + p.steps(1));

        int[] tall = {0, 0, 1, 2, 3, 4};
        Pointers t = new Pointers(tall);
        System.out.println(t.follow(5) + " " + t.steps(5));
    }
}
```

**Why `this.next = next`?** The parameter and the field are both named `next`. Inside the constructor, plain `next` means the parameter, so `this.next` is needed to reach the field. Writing `next = next;` compiles but does nothing, and the field stays `null`.

**Why a `while` loop?** You don't know in advance how many steps it takes, so you loop until the stopping condition holds. That's the classic case for `while` over `for`.

**Changing `i` is safe.** Java passes `int` parameters by value, so reassigning `i` inside the method doesn't affect the caller's variable.

**The array is shared, not copied.** The constructor stores a reference to the caller's array. If `main` later changed `arr[1]`, `p` would see the change. That's fine here, but it's worth knowing.

## Exercise 4: PairReader

```java
package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PairReader {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("pairs.txt"));
        int n = in.nextInt();
        System.out.println("n = " + n);

        int pairs = 0;
        while (in.hasNextInt()) {
            int p = in.nextInt();
            int q = in.nextInt();
            System.out.println("pair: " + p + " " + q);
            pairs++;
        }
        System.out.println(pairs + " pairs");
        in.close();
    }
}
```

**`nextInt()` ignores line breaks.** It skips any whitespace, including newlines, and reads the next number. So you don't need to read line by line and split. Just call `nextInt()` twice per pair.

**Why `throws FileNotFoundException`?** Java requires you to acknowledge that opening a file might fail. Adding `throws` to `main` is the simplest way. Without it, the code won't compile.

**"FileNotFoundException" when you run it?** Eclipse looks for `pairs.txt` in the project's root folder, the one that contains `src`. Move the file there, not into `src` or the package folder.

