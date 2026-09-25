# Homework 2: Union-Find

In this assignment you'll:

* implement the two union-find algorithms from the lectures:
    - quick-find 
    - quick-union
* trace them by hand. 

This assignment builds directly on [Java Primer and Practice](https://ben-allen.github.io/CIS-023/assignments/practice%201.html): `Labels` becomes quick-find, and `Pointers` becomes quick-union's `find`.

## Setup

- Create a package called `hw2` in your project's `src` folder.
- Download the starter files `QuickFindUF.java`, `QuickUnionUF.java`, `UFClient.java`, and (for the extra credit) `WeightedQuickUnionUF.java`, and put them in `hw2`. Each part you need to write is marked `// TODO`. The `toString()` methods are already written, so you can print a union-find object to see its array while you debug.
- Download `uf.txt` and put it in your project's root folder, not in `src`.


The files you'll be completeing are `QuickFindUF.java`, `QuickUnionUF.java`, and (if you're interestd) `WeightedQuickUnionUF.java`. 

`UFClient` is provided complete, and you shouldn't change it. Use it to test your classes. For each pair, if `p` and `q` aren't already connected, it unions them and prints the pair. At the end, it prints the number of components.

Everything you need to know to complete this assignment can be found on the [union-find slideset](https://github.com/ben-allen/CIS-023/blob/main/slides/cis%20023%20-%20union-find.pdf)


### The union rule

For both algorithms in this assignment, `union(p, q)` changes **p's side** to match **q's side**:

- In quick-find, every element with p's component id gets q's component id.
- In quick-union, p's root is set to point to q's root.

The lecture slides happen to use the opposite choice in the quick-find example. Either choice works in general, but use this rule here so everyone's arrays (and traces) come out the same.

## Part 1: QuickFindUF

Fill in the methods in `QuickFindUF.java`. The array `id` stores each element's component id, just like `Labels` in [Java Primer and Practice](https://ben-allen.github.io/CIS-023/assignments/practice%201.html).

```java
public QuickFindUF(int n)               // n elements, each in its own component
public int find(int p)                  // returns p's component id
public boolean connected(int p, int q)  // returns true if p and q are connected
public void union(int p, int q)         // does nothing if already connected
public int count()                      // returns the number of components
```

The field `count` tracks the number of components. It starts at `n`, and each union that actually merges two components lowers it by one. Keeping a running count is much faster than recounting distinct ids every time `count()` is called.

Hint: in `union`, save `find(p)` and `find(q)` in variables *before* the loop. If you call `find(p)` inside the loop, its answer changes partway through, once you've relabeled `id[p]`.

## Part 2: QuickUnionUF

Fill in the methods in `QuickUnionUF.java`. It has the same methods as `QuickFindUF`, but the array `parent` stores each element's parent in a tree. An element whose parent is itself is a root.

- `find(p)` follows parents from `p` up to the root and returns the root. This is `follow` from [Java Primer and Practice](https://ben-allen.github.io/CIS-023/assignments/practice%201.html).
- `union(p, q)` finds both roots. If they're different, it sets p's root to point to q's root. Only one array entry changes.
- `connected` and `count` work the same way as in quick-find.

## Part 3: Test with UFClient

`UFClient` reads `uf.txt`, which uses the same format as `pairs.txt` from [Java Primer and Practice](https://ben-allen.github.io/CIS-023/assignments/practice%201.html):

```
10
1 2
3 4
5 6
2 4
7 8
1 3
6 9
8 5
4 1
```


The client is known to be correct, so if your output doesn't match the expected output below, the bug is in your `QuickUnionUF` (or `QuickFindUF`), not in the client.

Expected output:

```
1 2
3 4
5 6
2 4
7 8
6 9
8 5
3 components
```

Try swapping in `QuickFindUF` instead (you can do this by changing the line where a `QuickUnionUF` object is created to create a `QuickFindUF` object instead). The output should be identical, because both algorithms answer the same questions and differ only in how they store the answers.

## Part 4: Trace by hand

Start with 6 elements, `0` through `5`, each in its own component, and apply these unions in order:

```
union(0, 1)
union(2, 3)
union(0, 3)
union(4, 5)
union(5, 2)
```

In a plain text file called `trace.txt`, answer the following.

1. For **quick-find**, write the `id` array after each union.
2. For **quick-union**, write the `parent` array after each union.
3. In the final quick-union array, how many steps does `find(4)` take to reach the root? Which elements does it pass through?
4. When you run `UFClient`, the pairs `1 3` and `4 1` don't print. Why not? For each one, name the earlier unions that explain it. A sentence or two each is plenty.

Use this format for questions 1 and 2, one line per union:

```
Quick-find:
union(0, 1): [1, 1, 2, 3, 4, 5]
union(2, 3): ...
```

(The first line is done for you as an example. It's the same for both algorithms.)

Work these out by hand first, following the union rule from Setup. Once you're done, you're welcome to check your answers by running the unions and printing your objects. The goal is to understand what each algorithm does to the array, and running code only confirms answers you've already worked out.

## Extra credit: WeightedQuickUnionUF

Fill in the starter file `WeightedQuickUnionUF.java`. It has the same methods as `QuickUnionUF`, plus a second array, `size`, that tracks how many elements are in the tree rooted at each element. `find`, `connected`, and `count` work exactly as in `QuickUnionUF`, so you can reuse your code from Part 2.

- In the constructor, every `size[i]` starts at `1`.
- In `union`, attach the root of the **smaller** tree to the root of the larger one, then add the smaller tree's size to the larger tree's root. If the sizes are equal, either choice is fine.

With `UFClient` switched to `WeightedQuickUnionUF`, the output should still match Part 3 exactly.

## Points

This assignment is worth 25 points, plus up to 4 points of extra credit.

| Part | Points |
| --- | --- |
| Part 1: QuickFindUF | 9 |
| Part 2: QuickUnionUF | 9 |
| Part 4: Trace | 7 |
| Extra credit: WeightedQuickUnionUF | +4 |

## Submission checklist

- [ ] All `.java` files start with `package hw2;` and are in the `hw2` package. `hw2` should be lowercase
- [ ] Each program compiles and runs without errors
- [ ] `union` follows the rule from Setup: p's side changes to match q's
- [ ] Running the provided `UFClient` gives output that matches Part 3 exactly
- [ ] You've also run `UFClient` with `QuickFindUF` confirmed the output is identical, and changed it back to `QuickUnionUF`
- [ ] `trace.txt` answers all four questions in the format shown
- [ ] Upload these files individually: `QuickFindUF.java`, `QuickUnionUF.java`, `trace.txt`, and `WeightedQuickUnionUF.java` if you did the extra credit. You don't need to upload `UFClient.java`.

