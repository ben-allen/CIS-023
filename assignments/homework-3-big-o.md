## Big O Analysis

Write your answers in a document, numbered to match the questions. For question 10, paste your program's output into the same document. Show your work: a trace or a filled-in table counts as work.

### Counting operations

**1.** Consider this loop:

```java
int count = 0;
for (int i = 0; i < n; i++) {
    count++;
}
```

1. Trace the loop by hand for n = 5. How many times does `count++` run?
2. Fill in this table:

| n | times count++ runs |
| --- | --- |
| 10 |  |
| 100 |  |
| 1,000 |  |

3. Give the Big O of this loop.

**2.** Consider this loop:

```java
int count = 0;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        count++;
    }
}
```

1. Trace it for n = 3. How many times does `count++` run?
2. Fill in this table:

| n | times count++ runs |
| --- | --- |
| 3 |  |
| 10 |  |
| 100 |  |

3. Give the Big O of this loop.

**3.** Consider this loop:

```java
int count = 0;
while (n > 1) {
    n = n / 2;
    count++;
}
```

1. Trace it for n = 16. List the values n takes, and say how many times `count++` runs.
2. How many times does `count++` run when n starts at 1,024?
3. Give the Big O of this loop.

**4.** Consider this code:

```java
int count = 0;
for (int i = 0; i < n; i++) {
    count++;
}
for (int j = 0; j < n; j++) {
    count++;
}
```

1. How many times does `count++` run when n = 5? Write a formula for the count in terms of n.
2. Give the Big O, and explain in a sentence why the constant in your formula can be dropped.

### Simplifying

**5.** Give the Big O of each expression:

1. 3n² + 7n + 2
2. 4n + 10
3. n + log n

### Ordering growth rates

**6.** Put these in order from slowest-growing to fastest-growing:

n², log n, 2ⁿ, n, n log n

### Using the definition

Recall: f(n) is O(g(n)) if there exist constants c > 0 and n₀ such that f(n) ≤ c·g(n) for all n > n₀.

**7.** Show that 4n + 3 is O(n) by giving a value of c and a value of n₀ that work. Show why your pair works. (Hint: try c = 5, and find the values of n where 4n + 3 ≤ 5n.)

### Best case and worst case

**8.** Here is linear search, which looks for `target` in the array `a`:

```java
for (int i = 0; i < a.length; i++) {
    if (a[i] == target) {
        return i;
    }
}
return -1;
```

Let n be the length of the array.

1. How many comparisons (`a[i] == target`) does it make if `target` is the first item in the array?
2. How many comparisons does it make if `target` is not in the array at all?
3. Give the Big O in the best case and in the worst case.

### Tilde notation

**9.** For each expression, give its \~ approximation and its Big O:

1. 3n + 7
2. n²/2 + n

### Coding: a doubling experiment

**10.** Download `AssignmentCounter.java` and run it. It contains three methods:

```java
public static long mysteryA(int n) {
    long count = 0;
    for (int i = 0; i < n; i++) {
        count++;
    }
    return count;
}

public static long mysteryB(int n) {
    long count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            count++;
        }
    }
    return count;
}

public static long mysteryC(int n) {
    long count = 0;
    for (int i = 0; i < 1000; i++) {
        count++;
    }
    return count;
}
```

`main` prints each method's count for n = 1,000, 2,000, 4,000 and 8,000, along with the doubling ratio (each count divided by the count on the line above it).

1. Paste the output into your document.
2. Use the ratios and the table below to name each method's growth rate.
3. For each method, point to the feature of the code that explains its growth rate.

| doubling ratio | growth rate |
| --- | --- |
| about 1 (the count barely changes) | constant or log n |
| about 2 | n |
| a little more than 2 | n log n |
| about 4 | n² |
| about 8 | n³ |
