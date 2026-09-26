# Big O: Practice Set

This practice set is not graded. Solutions are provided so you can check your work. Write your answers in a document, numbered to match the questions. For question 11, paste your program's output into the same document.

### Counting operations

**1.** Consider this loop:

```java
int count = 0;
for (int i = 0; i < n; i += 2) {
    count++;
}
```

1. Trace the loop by hand for n = 8. List the values i takes, and say how many times `count++` runs.
2. Fill in this table:

| n | times count++ runs |
| --- | --- |
| 10 |  |
| 100 |  |
| 1,000 |  |

3. Write a formula for the count in terms of n, and give its Big O.

**2.** Consider this loop:

```java
int count = 0;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
        count++;
    }
}
```

1. Trace it for n = 4. For each value of i, how many times does the inner loop run? What is the total?
2. Fill in this table:

| n | times count++ runs |
| --- | --- |
| 4 |  |
| 5 |  |
| 10 |  |

3. The total is 0 + 1 + 2 + … + (n − 1), which equals n(n − 1)/2. What is its Big O?
4. The inner loop here is shorter than in a loop where j goes all the way to n. Does that change the Big O? Explain in a sentence or two.

**3.** Consider this loop:

```java
int count = 0;
for (int i = 0; i < n; i++) {
    int k = n;
    while (k > 1) {
        k = k / 2;
        count++;
    }
}
```

1. For n = 8, how many times does the inner `while` loop run each time it starts? What is the total count?
2. Repeat for n = 16.
3. Give the Big O of the total count, and explain it using the rule "nested loops multiply."

**4.** Consider this loop:

```java
int count = 0;
for (int i = 0; i < 1000; i++) {
    count++;
}
```

1. How many times does `count++` run when n = 10? When n = 1,000,000?
2. What is the Big O of this loop? Explain.

### Simplifying

**5.** Give the Big O of each expression:

1. 5n³ + 100n² + log n
2. n log n + 2n
3. 2ⁿ + n¹⁰
4. 42
5. n²/1000 + 50n

### Ordering growth rates

**6.** Put these in order from slowest-growing to fastest-growing:

n², log n, 2ⁿ, n, n log n, 1, n³

### Using the definition

Recall: f(n) is O(g(n)) if there exist constants c > 0 and n₀ such that f(n) ≤ c·g(n) for all n > n₀.

**7.** Show that 3n² + 10n + 5 is O(n²) by giving a value of c and a value of n₀ that work. Show why your pair works.

**8.** Explain why n³ is **not** O(n²). (Hint: look at the slides on why n² is not O(n).)

### Best case and worst case

**9.** Here is the algorithm for *insertion sort*, one of the first sorting algorithms that people typically think of:

```java
for (int i = 1; i < n; i++) {
    int j = i;
    while (j > 0 && a[j-1] > a[j]) {
        swap(a, j-1, j);
        j--;
    }
}
```

1. How many times does `swap` run on each of these arrays? \[1, 2, 3, 4, 5\], then \[2, 1, 3, 4, 5\], then \[5, 4, 3, 2, 1\].
2. Which of those arrays is the best case, and which is the worst case?
3. Give the Big O of insertion sort's running time in the best case and in the worst case.

### Tilde notation

**10.** For each expression, give its \~ approximation and its Big O:

1. n(n − 1)/2
2. 4n³ + n²
3. 3n + 7 + log n

### Coding: a doubling experiment

**11.** Download `PracticeCounter.java` and run it. It contains three methods:

```java
public static long mysteryA(int n) {
    long count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            count++;
        }
    }
    return count;
}

public static long mysteryB(int n) {
    long count = 0;
    for (int i = 0; i < n; i++) {
        int k = n;
        while (k > 1) {
            k = k / 2;
            count++;
        }
    }
    return count;
}

public static long mysteryC(int n) {
    long count = 0;
    for (int i = 1; i < n; i = i * 2) {
        count++;
    }
    return count;
}
```

`main` prints each method's count for n = 1,000, 2,000, 4,000 and 8,000.

1. Paste the output into your document.
2. For each method, compute the **doubling ratio**: the count at 2,000 divided by the count at 1,000, then 4,000 over 2,000, then 8,000 over 4,000.
3. Use your ratios and the table below to name each method's growth rate.
4. For each method, point to the feature of the code that explains its growth rate.

| doubling ratio | growth rate |
| --- | --- |
| about 1 (the count barely changes) | constant or log n |
| about 2 | n |
| a little more than 2 | n log n |
| about 4 | n² |
| about 8 | n³ |

## Practice set solutions

For the questions that ask for c and n₀, many different answers are correct. Any pair that makes the inequality true is a valid answer.

**1.**

1. i takes the values 0, 2, 4 and 6, so `count++` runs 4 times.
2. The counts are 5, 50 and 500.
3. The count is n/2 (for even n). That is O(n): the 1/2 is a constant factor, and we drop constant factors.

*Common mistake:* thinking that skipping values of i makes the loop O(log n). Skipping by a fixed amount (2 each time) only divides the work by a constant. Only halving or doubling gives log n.

**2.**

1. When i = 0 the inner loop runs 0 times; when i = 1, 1 time; when i = 2, 2 times; when i = 3, 3 times. The total is 0 + 1 + 2 + 3 = 6.
2. The counts are 6, 10 and 45.
3. n(n − 1)/2 = n²/2 − n/2, which is O(n²).
4. No. This loop does about half the work of the version where j goes to n, but "half" is a constant factor. When n doubles, the work still roughly quadruples.

*Common mistake:* assuming that a shorter inner loop means a faster growth rate. The inner loop still runs up to n − 1 times, on average about n/2 times, and n/2 is still proportional to n.

**3.**

1. For n = 8, k goes 8 → 4 → 2 → 1, so the inner loop runs 3 times each time it starts. The outer loop runs 8 times, so the total is 8 × 3 = 24.
2. For n = 16, k goes 16 → 8 → 4 → 2 → 1: 4 times. The total is 16 × 4 = 64.
3. O(n log n). The outer loop runs n times, and each time the inner halving loop runs about log n times. Nested loops multiply: n × log n.

**4.**

1. 1,000 times in both cases.
2. O(1). The number of steps does not depend on n at all, so it is constant.

*Common mistake:* assuming any loop means O(n). What matters is whether the number of times the loop runs depends on n.

**5.**

1. O(n³)
2. O(n log n)
3. O(2ⁿ). Exponential growth eventually beats any power of n. Here, 2ⁿ is larger than n¹⁰ for every n from 59 on.
4. O(1). A constant does not grow at all.
5. O(n²). Dividing by 1,000 is a constant factor. n²/1000 is smaller than 50n at first, but larger for every n past 50,000.

**6.** 1, log n, n, n log n, n², n³, 2ⁿ

**7.** Two example answers:

- **c = 18, n₀ = 1.** For n ≥ 1, we know n ≤ n² and 1 ≤ n². So 3n² + 10n + 5 ≤ 3n² + 10n² + 5n² = 18n². The inequality holds for every n ≥ 1.
- **c = 4, n₀ = 10.** We need 3n² + 10n + 5 ≤ 4n², which is the same as 10n + 5 ≤ n². At n = 10 this fails (105 > 100). At n = 11 it holds (115 ≤ 121), and it keeps holding because n² grows faster than 10n + 5.

A larger c lets you use a smaller n₀, and a smaller c needs a larger n₀. Both are correct.

**8.** For n³ to be O(n²), we would need a constant c with n³ ≤ c·n² for all large n. Dividing both sides by n², that is the same as n ≤ c. But whatever values of c and n₀ someone picks, we can choose an n larger than both, and then n ≤ c is false. So no pair works, and n³ is not O(n²).

**9.**

1. &#91;1, 2, 3, 4, 5\]: 0 swaps. \[2, 1, 3, 4, 5\]: 1 swap. \[5, 4, 3, 2, 1\]: 1 + 2 + 3 + 4 = 10 swaps.
2. The sorted array \[1, 2, 3, 4, 5\] is the best case. The reversed array \[5, 4, 3, 2, 1\] is the worst case.
3. Best case: O(n). The outer loop still runs n − 1 times, and the `while` test is checked once each time and fails immediately. Worst case: O(n²). Each item moves all the way to the front, for a total of n(n − 1)/2 swaps.

*Common mistake:* saying the best case is "when n is 1." Best and worst case are about which input of a given size n you get, not about the size itself.

**10.**

1. \~n²/2, O(n²)
2. \~4n³, O(n³)
3. \~3n, O(n)

**11.** The program prints:

| n | mysteryA | mysteryB | mysteryC |
| --- | --- | --- | --- |
| 1,000 | 499,500 | 9,000 | 10 |
| 2,000 | 1,999,000 | 20,000 | 11 |
| 4,000 | 7,998,000 | 44,000 | 12 |
| 8,000 | 31,996,000 | 96,000 | 13 |

Doubling ratios:

| method | 2,000 ÷ 1,000 | 4,000 ÷ 2,000 | 8,000 ÷ 4,000 | growth rate |
| --- | --- | --- | --- | --- |
| mysteryA | 4.00 | 4.00 | 4.00 | n² |
| mysteryB | 2.22 | 2.20 | 2.18 | n log n |
| mysteryC | 1.10 | 1.09 | 1.08 | log n |

- **mysteryA** is the loop from question 2: nested loops, O(n²).
- **mysteryB** is the loop from question 3: a halving loop inside an n-loop, O(n log n). Its ratio is a little more than 2 because the log n part also grows by 1 each time n doubles.
- **mysteryC** doubles i each pass, which is halving in reverse, so it is O(log n). Its count goes up by exactly 1 each time n doubles.

