---
title: "Homework 6: Binary Search Trees"
---

# Homework 6: Binary Search Trees

In this assignment you'll:

- warm up with `rank` and `select`, the two methods that use the size counts
- write `height`, and a method that checks whether a tree really is a BST
- write `deleteMax`, and a mirror-image version of Hibbard deletion
- see how much the order you insert keys in changes the shape of the tree
- trace a BST by hand

| | Due | What's due |
|---|---|---|
| Homework 6 | Wednesday, November 25 | Parts 1–5 |

## Starter code

Download [`hw6-starter.zip`](https://github.com/ben-allen/CIS-023/blob/main/assignments/bst/hw6-starter.zip) from the course repo. Open the link and click the download button (the downward arrow) near the top right of the file view. **Don't unzip it.**

## Setup

Same steps as Homework 5:

1. In Eclipse's Package Explorer, right-click your project's `src` folder and choose **Import…**
2. Choose **General → Archive File**, and click **Next**.
3. Click **Browse…** and select `hw6-starter.zip`.
4. Check that **Into folder** says *your project's name*`/src`.
5. Click **Finish**.

You should now see a package called `hw6` inside `src`, with three files in it:

| File | What it is |
|---|---|
| `BST.java` | The book's binary search tree, with a size count in every node. `get`, `put`, `min`, `max`, `deleteMin`, and `delete` are done. **You write the methods marked `TODO`.** |
| `HW6Client.java` | Tests Parts 1–3. |
| `HeightExperiment.java` | The experiment for Part 4. |

Right-click `HW6Client.java` and choose **Run As → Java Application**. Every test should say `FAIL` for now, ending with `0 of 13 tests passed`. That's expected.

**If your computer unzipped the file automatically**, drag the `hw6` folder onto your project's `src` folder in Eclipse, and choose **Copy files and folders**.

### The tree from the slides

Most of the tests start from the tree in the slides: put `S E A R C H E X A M P L E`, each letter with its position.

```
                 S
              /     \
            E         X
          /   \
         A     R
          \   /
           C H
              \
               M
              / \
             L   P
```

### Reading the test results

When a test checks the shape of a tree, it uses `shape()`, which writes a tree as `(left key:size right)`. A `.` is an empty subtree, and a leaf is just `key:size`. So `(. A:2 C:1)` means "A, with size 2, no left child, and C as its right child." The slide tree is:

```
(((. A:2 C:1) E:8 ((. H:4 (L:1 M:3 P:1)) R:5 .)) S:10 X:1)
```

That's hard to read when it's long. **`draw()` is easier.** It prints the tree sideways, with the root on the left and bigger keys on top, and each node's size in parentheses. Add a few lines like these to a `main` of your own when you want to see what your code did:

```java
BST<String, Integer> t = HW6Client.slideTree();
t.deletePredecessor("E");
t.draw();
```

### The rules

- **Every method you write is recursive**, like `put` and `delete`: a public method that calls a private one on `root`.
- **Any method that changes the tree has to keep the size counts right.** `put`, `deleteMin`, and `delete` all end with `x.size = 1 + size(x.left) + size(x.right);`. Yours will too.
- `BST.java` has a method called `rekeyForTesting`. `HW6Client` uses it to break a tree on purpose for Part 2. Don't call it yourself.
- `HW6Client` is known to be correct. If a test fails, the bug is in your code, not the client.

### Where this differs from the book

- **`height` counts nodes, not links.** An empty tree has height 0, and one node has height 1. The book's `BST.java` counts links, so its heights are one less (and an empty tree is −1). Counting nodes makes the height equal to the most compares a search hit can take: 1 + the depth of the deepest node, like the slides.
- **`deletePredecessor` isn't in the book.** The book's `delete` (and the slides') always replaces a deleted node with its successor. Part 3 is the mirror image.
- The book's `deleteMin` and `deleteMax` throw an exception on an empty tree. Here they do nothing.
- `shape()`, `draw()`, and `rekeyForTesting` were added for this assignment.

---

## Part 1 (warm-up): `rank` and `select`

**These two methods are on the slides.** Before you look back at them, try working out the logic yourself, using the slide tree and a pencil. That's the real warm-up. If you get stuck, go back to the slides; that's what they're for.

### `rank(key)`

`rank(key)` is the number of keys in the table that are **smaller** than `key`. It works whether or not `key` is in the table: in the slide tree, `rank(N)` is 6 (A, C, E, H, L, and M are smaller).

Start at the root. At each node, compare `key` to the node's key. There are three cases. Ask: which smaller keys can I count without looking any further, and where could the rest be?

- **`key` is smaller.** Then `key` is smaller than everything in the right subtree too.
- **`key` is bigger.** How many keys in this node's left subtree are smaller than `key`? (You don't need to visit them: the size count tells you.) What about the node itself?
- **`key` equals the node's key.** Which of the keys around it are smaller?

An empty subtree has no keys smaller than anything.

### `select(k)`

`select(k)` is the opposite: the key with rank `k`, the key that has exactly `k` smaller keys. `select(0)` is the smallest key, and `select(size() - 1)` is the largest. Your private `select` returns the **node**, and the public one (already written) gets its key.

At each node, let `t` be the size of the node's left subtree. That's how many keys in this subtree are smaller than the node's key. So:

- If `t` is more than `k`, which subtree is the key in?
- If `t` equals `k`, you've found it.
- If `t` is less than `k`, the key is in the right subtree. But the right subtree doesn't know about the keys you're skipping. Which keys are they, and how many? What rank are you looking for once you get there?

Run `HW6Client`. Tests 1 and 2 should pass.

**If you're stuck:**

| If you see... | Check... |
|---|---|
| Test 1 gives `3 2 0 8` | what you count when `key` is bigger. The node itself is smaller than `key`, so it counts too: `1 + ...` |
| Test 1 gives `3 1 0 2` | that you count the whole left subtree, `size(x.left)`, when `key` is bigger |
| Test 1 gives `6 3 1 10` | the "equal" case. `rank(A)` is 0: nothing in the tree is smaller than A. The key itself doesn't count |
| Test 2 has `null` in it | the "less than" case. When you go right, you skip `t + 1` keys: the left subtree and the node itself. Look for `k - t - 1` |

## Part 2: `height` and `isBST`

### `height()`

The height of a tree is the number of **nodes** on the longest path from the root down to a leaf. An empty tree has height 0, and one node has height 1. The slide tree has height 6 (S, E, R, H, M, then L or P).

Think recursively: if you knew the heights of a node's two subtrees, what's the height of the tree rooted at that node?

### `isBST()`

`put` keeps a tree in symmetric order: every key in a node's left subtree is smaller than the node's key, and every key in its right subtree is bigger. But `put` isn't the only code that can change a tree. A buggy delete, or a key that changes after it's been inserted (remember the slide where H became Z?), can break symmetric order, and then `get` stops finding keys that are really there. `isBST()` checks.

**The tempting version is wrong.** It's tempting to check each node against its two children, and then check the subtrees the same way. But look at this: if `C` changes to `F` in the slide tree,

```
         E
       /   \
      A     R
       \
        F
```

`F` is bigger than its parent `A`, so it's in the right place compared with `A`. But it's in `E`'s **left** subtree, and it's bigger than `E`. `get("F")` would go right at `E` and never find it.

So every node has to fit between **bounds** set by all of its ancestors, not just its parent. That's what the private method's `lo` and `hi` parameters are for: every key in the subtree rooted at `x` must be strictly between `lo` and `hi`. A `null` means "no limit on that side." The public method starts with no limits at all: `isBST(root, null, null)`.

```
isBST(x, lo, hi):
    if x is null: return true                   (an empty tree is a BST)
    if lo is not null and x.key <= lo: return false
    if hi is not null and x.key >= hi: return false
    check x's left subtree:  everything in it must be between lo and x.key
    check x's right subtree: everything in it must be between x.key and hi
    return true only if both checks are true
```

Write the last three lines as two recursive calls. Use `compareTo` for `<=` and `>=`: `x.key.compareTo(lo) <= 0` means `x.key <= lo`.

Run `HW6Client`. Tests 3–6 should pass.

**If you're stuck:**

| If you see... | Check... |
|---|---|
| Test 3 gives `-1 0 5 9` | that an empty tree has height 0. You're counting links, like the book. This assignment counts nodes |
| Test 3 gives `0 0 0 0` | that you add 1 for the node itself |
| Test 6 fails with `true true`, and tests 4 and 5 pass | that you're passing bounds down, not comparing each node with its children. This is the tempting version above |
| Tests 4–6 fail, and test 4 gives `false true` | which bounds go to which side. The **left** subtree gets `(lo, x.key)`, and the **right** gets `(x.key, hi)` |
| Test 4 gives `false false` | that `isBST` returns `true` for an empty subtree |

## Part 3: `deleteMax` and `deletePredecessor`

### `deleteMax()`

`deleteMax` removes the largest key. It's the mirror image of `deleteMin`, which is already in `BST.java`: swap every `left` for `right`, and every `right` for `left`. Read `deleteMin` first, and make sure you can explain each of its lines. (Why does it return `x.right` when there's no left child, and not `null`?)

### `deletePredecessor(key)`

The slides' `delete` is Hibbard deletion. When the node to delete has two children, it's replaced by its **successor**: the smallest key in its right subtree. That's `delete` in `BST.java`.

`deletePredecessor` is the mirror image. When the node to delete has two children, it's replaced by its **predecessor**: the **largest** key in its **left** subtree. Everything else is the same as `delete`:

- If `key` isn't in the tree, nothing changes.
- If the node has no left child, return its right child (and the other way around). This handles leaves too.
- On the way back up, every node fixes its size count.

Start by copying `delete` into `deletePredecessor` (changing the call `delete(...)` to `deletePredecessor(...)`). Then change only the two-children case. In `delete`, those lines are:

```java
Node t = x;
x = min(t.right);                 // successor
x.right = deleteMin(t.right);     // take it out
x.left = t.left;                  // move it in
```

Mirror each line. **Keep them in the same order.** Remember the slide that asked what happens if you swap lines 11 and 12? The same thing will happen here.

Test 10 is the slides' "Your turn": `deletePredecessor(E)` puts C in E's place. Run `HW6Client`. Tests 7–13 should pass, and the last line should say `13 of 13 tests passed`. Test 13 makes 20,000 random changes to a tree and checks it against Java's own `TreeMap` after each one, so if only test 13 fails, its message tells you which operation went wrong.

**If you're stuck:**

| If you see... | Check... |
|---|---|
| Test 7's result is the whole slide tree, unchanged | that you store what the recursive call returns: `x.right = deleteMax(x.right);` |
| Test 7's result is `.` (an empty tree) | what `deleteMax` returns when `x` has no right child. The largest key can have a left subtree, and that subtree has to stay: return `x.left`, not `null` |
| Tests 10, 11, and 13 fail, and the sizes are too big (`C:8`, `S:10`) | that `deleteMax` updates `x.size`, like `deleteMin` |
| Test 8 has the right shape, but the sizes are too big | that `deletePredecessor` updates `x.size` on the way back up |
| Test 8's result is the slide tree, unchanged | that you store what the recursive calls return: `x.left = deletePredecessor(x.left, key);`, and the same on the right |
| Test 9 loses C too: `((. E:6 ...` | the one-child cases. If the left child is null, return the **right** one: that's the child that's actually there |
| Tests 10 and 11 give `StackOverflowError` | your tree has a loop in it: some node is its own ancestor. Check that you use `max(t.left)`, not `min`; that `x.left` gets `deleteMax(t.left)`, not `t.left`; and that the `deleteMax` line comes **before** `x.right = t.right` |
| Test 12 gives `NullPointerException` | the key that isn't in the tree. `deletePredecessor` needs `if (x == null) return null;` at the top, just like `delete` |

## Part 4: Insertion order and height

Run `HeightExperiment`. It puts the same keys (the integers 0 to n − 1) into a BST in four different orders, and prints the height of each tree:

- **sorted**: 0, 1, 2, …
- **reversed**: n − 1, n − 2, …
- **shuffled**: a random order (the same random order every time)
- **balanced**: the middle key first, then the middle of each half, and so on

It can take up to a minute, and it'll print zeros until your `height` works. (Question 2 explains why it's slow.)

In a plain text file called `heights.txt`, answer the following.

1. Paste the output into the file.
2. Draw the tree you get from putting `1 2 3 4 5` in that order. About how many compares does it take to build a tree like this from n keys in sorted order? Why did the experiment take so long?
3. The balanced column matches lg(n + 1) exactly. Why? (Hint: how many nodes fit on each level of a tree, if every level is full?) The shuffled trees are taller than that, but how much taller, compared with sorted?
4. The balanced order makes the best possible tree. So why can't a symbol table just put its keys in that order? Think about how a program actually uses a symbol table.

## Part 5: Trace a BST by hand

In a plain text file called `bsttrace.txt`, answer the following. Start with an empty BST and put these keys, in this order:

```
N G T C J Q W A E H L K R
```

1. Draw the tree, with each node's size. Use `draw()`'s sideways format, or a picture you draw by hand and photograph (save it as `bsttrace.jpg` or `bsttrace.png`). What is its height?
2. Find `rank(M)` and `select(7)`. For each, list the nodes you visit, and what you add (for `rank`) or what `k` becomes (for `select`) at each one.
3. Do `deletePredecessor(N)`. Which key takes N's place? What happens to that key's old child? Draw the tree after the delete, with sizes.
4. Which nodes' sizes changed in question 3? Why only those?

Work these out by hand first. Then you're welcome to check your answers with `draw()`, `rank()`, `select()`, and `deletePredecessor()`.

## Points

This assignment is worth 20 points.

| Part | Points |
|---|---|
| Part 1 (warm-up): `rank` and `select` (tests 1–2) | 2 |
| Part 2: `height` (test 3) | 2 |
| Part 2: `isBST` (tests 4–6) | 4 |
| Part 3: `deleteMax` and `deletePredecessor` (tests 7–13) | 7 |
| Part 4: `heights.txt` | 2 |
| Part 5: `bsttrace.txt` | 3 |

## Submission checklist

- [ ] `BST.java` starts with `package hw6;` and is in the `hw6` package. `hw6` should be lowercase
- [ ] Every method you wrote is recursive
- [ ] Running `HW6Client` shows `13 of 13 tests passed`
- [ ] `heights.txt` includes your `HeightExperiment` output and answers questions 2–4
- [ ] `bsttrace.txt` answers questions 1–4 (plus a picture, if you drew the trees by hand)
- [ ] Upload these files individually: `BST.java`, `heights.txt`, and `bsttrace.txt`
