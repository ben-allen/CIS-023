---
title: "Homework 4: Sorting"
---

# Homework 4: Sorting

In this assignment you'll:

- implement three sorting algorithms from the lectures:
  * insertion sort
  * mergesort
  * quicksort
- trace them by hand
- time them, and see what the difference between n² and n log n looks like on a real computer.

This assignment runs for two weeks and has a **checkpoint** halfway through.

| | Due | What's due |
|---|---|---|
| Checkpoint | Sunday, October 18 | Parts 1–3: insertion sort, mergesort, and their traces |
| Final | Sunday, October 25 | Parts 4–6: quicksort, its trace, a one-line mergesort speedup, and the timing experiment |

## A quick note

When you see a very long assignment prompt in a CS class, it can be a little intimidating at first. The secret, though, is that the *longer* the prompt is, the easier the assignment will be. This is because long prompts typically provide a great deal of scaffolding, which lets you focus on the course material. If you get overwhelmed, just follow the instructions in each section one by one -- each part is pretty straightforward.

## A second quick note

This is the first time I've used this assignment in this form. If you find the instructions on how to test your code confusing, send me an email and I'll:

1. Clarify the instructions for you
2. Update the assignment prompt to help other people get less confused


## Starter code
 
Download [`hw4-starter.zip`](https://github.com/ben-allen/CIS-023/blob/main/assignments/sorting/hw4-starter.zip) from the course repo. Open the link and click the download button (the downward arrow) near the top right of the file view. **Don't unzip it.** Eclipse will do that for you.
 
## Setup
 
1. In Eclipse's Package Explorer, right-click your project's `src` folder and choose **Import…**
2. Choose **General → Archive File**, and click **Next**.
3. Click **Browse…** and select `hw4-starter.zip`.
4. Check that **Into folder** says *your project's name*`/src`. If it doesn't, click **Browse…** next to it and pick your project's `src` folder.
5. Click **Finish**.
You should now see a package called `hw4` inside `src`, with seven files in it. To check that everything works, right-click `SortClient.java` and choose **Run As → Java Application**. Selection should say `OK`, and the other sorts should say `NOT SORTED`, since you haven't written them yet.
 
**If your computer unzipped the file automatically** (Safari on a Mac does this), you'll have a folder called `hw4` instead of a `.zip` file. Drag that `hw4` folder onto your project's `src` folder in Eclipse, and choose **Copy files and folders** when Eclipse asks.
 
**Yellow warning triangles are expected.** Eclipse marks every use of `Comparable` with a warning like "Comparable is a raw type." That comes from using `Comparable` the same way the book does. It's a warning, not an error, and your code will still run.

### The rules every sort follows

Read through `Selection.java` before you start. It's a complete sort written the way the book writes them, and your sorts should follow the same rules:

- **Every comparison goes through `less()`.** Don't call `compareTo` directly in your sort.
- **Every exchange goes through `exch()`** (in insertion sort and quicksort).
- **Sorts work on `Comparable[]`**, so the same code sorts letters, numbers, or anything else with a natural order.

Following these rules is what lets us count compares and exchanges, which is how the book measures how much work a sort does.

---

# Checkpoint (due Sunday, October 18)

## Part 1: Insertion sort

Fill in `sort` in `Insertion.java`.

Here's the pseudocode from the slides:

```
for i from 1 to n - 1:
    j = i
    while j > 0 and a[j] is less than a[j - 1]:
        exchange a[j] and a[j - 1]
        j = j - 1
```

Each pass takes the item at `a[i]` and slides it left, one exchange at a time, until the item to its left is no larger or it reaches the front. When pass `i` is done, `a[0..i]` is sorted.

**Turning the pseudocode into Java:**

- "is less than" is a call to `less(a[j], a[j - 1])`, and "exchange" is a call to `exch(a, j, j - 1)`. Don't use `compareTo` or `<` directly.
- `n` is `a.length`.
- "from 1 to n − 1" includes n − 1, so the loop condition is `i < n`.
- The `while` loop can be written as a `for` loop with both conditions in it: `for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)`. The order of the two conditions matters: `j > 0` has to be checked first, or `a[j - 1]` will be `a[-1]` when `j` is 0.

When you're done, run `SortClient`. The Insertion lines should say `OK`.

**If you're stuck:**

| If you see... | Check... |
|---|---|
| `ArrayIndexOutOfBoundsException: Index -1` | that `j > 0` comes *before* `less(...)` in the loop condition |
| `NOT SORTED`, and the array looks almost sorted | that the outer loop goes all the way to `i < n`, not `i < n - 1` |
| `NOT SORTED`, and the array hasn't changed at all | that you're comparing `a[j]` with `a[j - 1]` (neighbors), not `a[i]` with something |
| You want to watch it work | add `show(a);` as the last line inside the outer loop, run `SortClient`, then remove it |

## Part 2: Mergesort

Mergesort has two methods for you to write, and you'll write and test them one at a time.

The public `sort(a)` is already done: it creates the `aux` array once, then calls `sort(a, aux, 0, a.length - 1)`.

### Step 1: `merge`

Fill in `merge(a, aux, lo, mid, hi)` in `Merge.java`. It combines the two sorted halves `a[lo..mid]` and `a[mid+1..hi]` into one sorted subarray `a[lo..hi]`. Here's the pseudocode from the slides:

```
copy a[lo..hi] into aux[lo..hi]
i = lo          (next unused item in the left half)
j = mid + 1     (next unused item in the right half)
for k from lo to hi:
    if the left half is used up (i > mid):     a[k] = aux[j], then j = j + 1
    else if the right half is used up (j > hi): a[k] = aux[i], then i = i + 1
    else if aux[j] is less than aux[i]:         a[k] = aux[j], then j = j + 1
    else:                                       a[k] = aux[i], then i = i + 1
```

**Turning the pseudocode into Java:**

- "from lo to hi" includes `hi`, so both loops use `k <= hi`.
- The four cases are one `if` / `else if` / `else if` / `else` chain. Exactly one of them runs for each `k`.
- `a[k] = aux[j++];` copies `aux[j]` into `a[k]` and *then* adds 1 to `j`, all in one line. You're welcome to write it as two lines instead.
- The order of the four cases matters. If you compare `aux[j]` and `aux[i]` before checking whether a half is used up, you'll read past the end of that half. And because the last case takes from the left, equal items come out in their original order, which makes mergesort *stable*.

Then run `MergeTest`. It calls your `merge` by itself on six small examples and tells you which ones pass. Don't start Step 2 until it says `6 of 6 tests passed`.

**If you're stuck:**

| If you see... | Check... |
|---|---|
| `FAIL: index out of bounds` | that the two "used up" checks come *before* the `less` check |
| Test 5 fails, but the others pass | that your loops start at `lo` and end at `hi`, not `0` and `a.length - 1` |
| Test 6 (ties) fails, but the others pass | that you take from the right only when `less(aux[j], aux[i])` is true, and take from the left otherwise |
| A letter shows up twice and another is missing | that every case advances the index it took from (`i` or `j`), and only that one |

### Step 2: the recursive `sort`

Fill in `sort(a, aux, lo, hi)` in `Merge.java`:

```
if hi <= lo: return            (one item or none: already sorted)
mid = lo + (hi - lo) / 2
sort the left half,  a[lo..mid]
sort the right half, a[mid+1..hi]
merge the two halves
```

Each line of pseudocode is one line of Java. The two "sort" lines are calls to this same method, `sort(a, aux, ...)`, with a different `lo` and `hi`. That's the recursion.

Then run `SortClient`. The Merge lines should say `OK`.

**If you're stuck:**

| If you see... | Check... |
|---|---|
| `StackOverflowError` | that the first line returns when `hi <= lo`, and that the right half starts at `mid + 1`, not `mid` |
| `NOT SORTED`, and the array hasn't changed | that `sort` actually calls `merge` at the end |
| `MergeTest` passes but `SortClient` doesn't | that both recursive calls pass `aux` along, and use `lo, mid` and `mid + 1, hi` |

## Part 3: Test with SortClient, then trace by hand

Run `SortClient`. It sorts the letters `S O R T E X A M P L E` with each algorithm, sorts 10,000 random numbers with each algorithm, and checks the results.

At the checkpoint, Selection, Insertion, and Merge should all say `OK`. Quick will say `NOT SORTED`, and its partition check won't match yet. That's expected, since you'll write it in week two.

```
Sorting "S O R T E X A M P L E":
  Selection  [A, E, E, L, M, O, P, R, S, T, X]  OK
  Insertion  [A, E, E, L, M, O, P, R, S, T, X]  OK
  Merge      [A, E, E, L, M, O, P, R, S, T, X]  OK
  Quick      [...]  NOT SORTED

Sorting 10,000 random numbers:
  Selection  OK
  Insertion  OK
  Merge      OK
  Quick      NOT SORTED
```

`SortClient` is known to be correct, so if a sort you've written doesn't say `OK`, the bug is in your sort, not in the client. It also checks that no items were lost or copied twice along the way.

Then, in a plain text file called `trace.txt`, answer the following.

**Insertion sort.** Start with this array:

```
S O R T I N G
```

1. Write the array after each pass of the outer loop (each value of `i`). Use this format, one line per pass:

   ```
   i = 1: [O, S, R, T, I, N, G]
   i = 2: ...
   ```

   (The first line is done for you as an example.)

2. Which pass made no exchanges at all? In a sentence, explain why.
3. How many exchanges did insertion sort make in total?
4. An *inversion* is a pair of items that are out of order relative to each other. For example, `S` and `O` are an inversion, because `S` comes before `O` in the array but after it in sorted order. Count the inversions in the original array `S O R T I N G`. Compare your answer to question 3, and explain in a sentence or two why they match. (Hint: think about what one exchange of two adjacent, out-of-order items does to the number of inversions.)

**Mergesort.** Start with this array:

```
Q U E S T I O N
```

5. Write the array after each call to `merge`, with the call's `lo`, `mid`, and `hi`. Use this format, one line per call:

   ```
   merge(a, aux, 0, 0, 1): [Q, U, E, S, T, I, O, N]
   merge(a, aux, 2, 2, 3): ...
   ```

   (The first line is done for you. Notice that `Q` and `U` were already in order, so the array didn't change.)

6. How many times was `merge` called? How many times would it be called for an array of 16 items?
7. How many compares did the *last* merge make? Explain in a sentence why a merge of 8 items can never make more than 7 compares.

Work these out by hand first. Once you're done, you're welcome to check your arrays by adding print statements to your code. The goal is to understand what each algorithm does to the array, and running code only confirms answers you've already worked out.

---

# Final (due Sunday, October 25)

## Part 4: Quicksort

Fill in `partition` and the private `sort(a, lo, hi)` in `Quick.java`. The public `sort(a)` is already done: it shuffles the array, then calls `sort(a, 0, a.length - 1)`.

**`sort(a, lo, hi)`** sorts the subarray `a[lo..hi]`:

- If `hi <= lo`, return.
- Otherwise, partition: `int j = partition(a, lo, hi);`. Then sort `a[lo..j-1]` and sort `a[j+1..hi]`.

Notice that there's no merge step. Once partitioning puts `a[j]` in place, sorting the two sides finishes the job.

**`partition(a, lo, hi)`** uses `v = a[lo]` as the partitioning item, rearranges `a[lo..hi]`, and returns the index `j` where `v` ends up. Afterward, everything to the left of `j` is no greater than `v`, and everything to the right is no less than `v`.

1. Set `i = lo` and `j = hi + 1`.
2. Repeat:
   - Scan `i` to the right while `a[i]` is less than `v`. Stop if `i` reaches `hi`.
   - Scan `j` to the left while `v` is less than `a[j]`. Stop if `j` reaches `lo`.
   - If the pointers have crossed (`i >= j`), stop repeating.
   - Otherwise, `exch(a, i, j)`. Both items were on the wrong side, and now both are on the right side.
3. Put `v` into its final position with `exch(a, lo, j)`, and return `j`.

Hint: the book increments and decrements *before* each comparison, with `less(a[++i], v)` and `less(v, a[--j])`. That's why `i` starts at `lo` (not `lo + 1`) and `j` starts at `hi + 1` (not `hi`). Partition is the trickiest code in this assignment, so it's worth reading the book's version carefully and tracing it on paper before you type.

When you run `SortClient` now, all four sorts should say `OK`, and the partition check should match the expected line:

```
Partitioning "K R A T E L E P U I M Q C X O S":
  result: [E, C, A, I, E, K, L, P, U, T, M, Q, R, X, O, S], j = 5
  expect: [E, C, A, I, E, K, L, P, U, T, M, Q, R, X, O, S], j = 5
```

(This is the partitioning example from the book, so you can compare your code against the book's trace of it.)

**If you're stuck:**

| If you see... | Check... |
|---|---|
| The program never finishes (an infinite loop) | that you `break` out of the repeat loop when `i >= j`, and that `i` and `j` actually move on every scan |
| `ArrayIndexOutOfBoundsException` | the two stopping checks: `if (i == hi) break;` and `if (j == lo) break;` |
| The partition check gives the right array but the wrong `j` | that you return `j`, not `i`, after the final `exch(a, lo, j)` |
| `StackOverflowError` in `sort` | that the recursive calls are `sort(a, lo, j - 1)` and `sort(a, j + 1, hi)`, which leave out `a[j]` |

## Part 5: Trace partition by hand

In a plain text file called `partition.txt`, answer the following. Partition this array, with `lo = 0` and `hi = 9`:

```
P A R T I T I O N S
```

1. Write the array after each exchange, including the final `exch(a, lo, j)`. Use this format:

   ```
   exch(a, 2, 8): [P, A, N, T, I, T, I, O, R, S]
   exch(a, ...): ...
   ```

   (The first line is done for you.)

2. What value of `j` does `partition` return?
3. After partitioning, which item is guaranteed to be in its final sorted position? What are the two recursive calls quicksort makes next? Give each one's `lo` and `hi`.

## Part 6: One-line speedup, then the timing experiment

### Step 1: Skip merges that aren't needed

If the left half's largest item is no bigger than the right half's smallest item, the two halves are *already* in order, and merging them would change nothing. Mergesort can check for that and skip the merge.

In `Merge.java`, in your recursive `sort`, add this line right before the call to `merge`:

```java
if (!less(a[mid + 1], a[mid])) return;   // halves already in order: skip the merge
```

`a[mid]` is the largest item in the left half, and `a[mid + 1]` is the smallest item in the right half. The line says: if the right half's smallest item isn't less than the left half's largest, return without merging.

Run `SortClient` again to make sure Merge still says `OK`.

(Your answers to `trace.txt` are about mergesort *without* this line, just as it was traced in the slides. Don't change them.)

### Step 2: Run the experiment

Run `SortCompare`. It runs five doubling experiments, sorting arrays of size 1,000, 2,000, 4,000, and so on, and prints how long each sort took and the doubling ratio (each time divided by the time above it). It stops an experiment once a single sort takes more than a second. The whole run takes a minute or two.

The five experiments are:

- insertion sort on random input
- insertion sort on input that's already sorted
- mergesort on random input
- mergesort on input that's already sorted
- quicksort on random input

Your times will be different from everyone else's, since they depend on your computer. The ratios will also bounce around, especially for small n, where the times are tiny. Look at the trend over the last few rows of each table.

In a plain text file called `experiment.txt`, answer the following.

1. Paste the output into the file.
2. Use the ratios and this table (the same one from the Big O homework) to name the growth rate of each of the five experiments.

   | doubling ratio                     | growth rate       |
   | ---------------------------------- | ----------------- |
   | about 1 (the count barely changes) | constant or log n |
   | about 2                            | n                 |
   | a little more than 2               | n log n           |
   | about 4                            | n²                |
   | about 8                            | n³                |

3. Insertion sort on random input stopped well before 1,024,000 items. Use the last time in its table and its growth rate to **predict** how long it would take to sort 1,024,000 random items. Show your arithmetic. (Hint: each doubling multiplies the time by about 4. How many doublings is it from your last n to 1,024,000?) Give your answer in minutes, and compare it to how long mergesort took on 1,024,000 items.
4. Insertion sort was very fast on already-sorted input. Point to the part of your code in `Insertion.java` that explains why, and say in a sentence or two what happens there when the input is already sorted.
5. Mergesort on already-sorted input was much faster than on random input, because of the line you added in Step 1. When the input is already sorted, how many times does `merge` get called? In a sentence or two, explain why that makes the sort so much faster.
6. Mergesort and quicksort on random input have the same growth rate. Which one was faster on your computer? In a sentence, name one thing mergesort does that quicksort doesn't, that could account for the difference.

## Points

This assignment is worth 40 points.

| Part | Due | Points |
|---|---|---|
| Part 1: Insertion sort | Checkpoint | 6 |
| Part 2: Mergesort | Checkpoint | 9 |
| Part 3: `trace.txt` | Checkpoint | 8 |
| Part 4: Quicksort | Final | 7 |
| Part 5: `partition.txt` | Final | 4 |
| Part 6: Skip-the-merge line and `experiment.txt` | Final | 6 |

## Submission checklist

**Checkpoint (Sunday, October 18):**

- [ ] All `.java` files start with `package hw4;` and are in the `hw4` package. `hw4` should be lowercase
- [ ] Your sorts use `less()` for every comparison, and insertion sort uses `exch()` for every move
- [ ] Running `SortClient` shows `OK` for Selection, Insertion, and Merge
- [ ] `trace.txt` answers questions 1–7 in the formats shown
- [ ] Upload these files individually: `Insertion.java`, `Merge.java`, and `trace.txt`

**Final (Sunday, October 25):**

- [ ] Running `SortClient` shows `OK` for all four sorts, and the partition check matches
- [ ] `partition.txt` answers questions 1–3 in the format shown
- [ ] Your `Merge.java` has the skip-the-merge line from Part 6, and `SortClient` still says `OK`
- [ ] `experiment.txt` includes your `SortCompare` output and answers questions 2–6
- [ ] Upload these files individually: `Quick.java`, `Merge.java` (again, with the new line), `partition.txt`, and `experiment.txt`. If you fixed anything in `Insertion.java` after the checkpoint, upload it again too
