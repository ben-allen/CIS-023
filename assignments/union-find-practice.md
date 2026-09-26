# Java Primer and Practice 1

## About this practice set

This is practice, not a graded assignment. It covers the Java you'll need for HW2 (union-find):
* arrays 
* loops
* methods
* classes with fields / instance variables 

This primer builds on the quick Java tour [slideset](https://github.com/ben-allen/CIS-023/blob/main/slides/java-classes-quick-tour.pdf). Classes, fields, constructors, `this`, public vs. private, references, and `null` are covered there, so the primer below only fills in what that session didn't: arrays, loops, static methods, and static vs. instance. Skim it, then do the four exercises. Each one builds a piece you'll reuse in HW2.

A solution sheet with explanations is posted separately. Try each exercise first, then check your work against it.

## Java primer: a translation guide

For classes, objects, references, and the rest of the basics, see the Java quick tour slides.

### Arrays

Arrays have a fixed size, chosen when you create them. There's no `append`. If you need a different size, you make a new array.

```java
int[] a = new int[5];      // five ints, all starting at 0
int[] b = {3, 1, 4};       // created with values
a[0] = 7;                  // set
int x = b[2];              // get
int n = a.length;          // length: no parentheses! This differs from how Strings work.
```

Reading or writing outside `0` to `length - 1` crashes with `ArrayIndexOutOfBoundsException`. There's no negative indexing like Python's `a[-1]`.

Printing an array directly gives you gibberish like `[I@1b6d3586`. To see the contents, use `Arrays.toString`:

```java
import java.util.Arrays;   // at the top, after the package line
...
System.out.println(Arrays.toString(a));   // [7, 0, 0, 0, 0]
```

Arrays are objects, so array variables hold references, just like `Book c = a;` in the Java quick tour slides. Assigning one array variable to another doesn't copy anything:

```java
int[] a = {1, 2, 3};
int[] b = a;      // no copy: a and b refer to the same array
b[0] = 99;
System.out.println(a[0]);   // 99
```

### Loops and conditionals

```java
for (int i = 0; i < a.length; i++) {   // C-style for loop
    a[i] = i * 2;
}

while (x != 0) {                         // while loop
    x = x / 2;
}

for (int value : a) {                    // for-each: like Python's "for value in a"
    System.out.println(value);
}

if (x > 3) { 
    ... 
} else if (x == 3) { 
    ... 
} else { 
    ... 
}
```

Logical operators are `&&`, meaning "and", `||`, meaning "or", and `!`, meaning "not"

The for-each loop gives you a copy of each value, so assigning to `value` does not change the array. When you need to modify an array, use the indexed `for` loop.

### Methods

A method declares its return type and the type of each parameter. Use `void` if it returns nothing.

```java
public static int square(int n) {
    return n * n;
}

public static void greet(String name) {
    System.out.println("Hi " + name);
}
```

### Printing objects: toString

When you print an object, Java calls its `toString()` method. Without one, you get something like `Book@1b6d3586`. Add a `toString()` to control what prints:

```java
public String toString() {
    return title + " (" + pages + " pages)";
}
```

### Static vs. instance: look before the dot

```java
Math.max(3, 7)          // 7: static, called on the class
Math.sqrt(16.0)         // 4.0
Math.abs(-5)            // 5
Arrays.toString(a)      // you've used this one already

a.getTitle()            // instance: called on an object
"Dune".length()         // instance: whose length? this String's
```

Look at what's before the dot. A capitalized class name means a static method, which works only with what you pass in. A variable, or a literal String (as in the `"Dune".length()` example) means an instance method, which works with that object's own data.

So the real difference is where the method gets its data. `a.getTitle()` has to ask "whose title?" and reads the fields of the object you called it on. `Math.max(3, 7)` doesn't depend on any particular thing's data, so everything it needs comes in through its parameters. Math is a pure toolbox: there's no such thing as "a Math object" and Java won't even let you write `new Math()`.

This explains two things that trip people up:

- **Why `main` is static.** When your program starts, no objects exist yet, so Java needs a method it can call without one.
- **The error "non-static method cannot be referenced from a static context."** If you call `get(2)` inside `main`, Java asks "get from *which* `Labels`?" There's no object, so it has no answer. Create one first with `new`, then call the method on it: `L.get(2)`.

The exercises show both kinds. Exercise 1 (`ArrayBasics`) is all static methods that take the array as a parameter. Exercise 2 (`Labels`) is all instance methods that use the array stored in the object.

### Common gotchas

| Gotcha | What to do |
| --- | --- |
| `7 / 2` is `3` (integer division) | Use `7 / 2.0` or `(double) 7 / 2` for `3.5` |
| Arrays use `.length`, Strings use `.length()` | No parentheses for arrays |
| Printing an array shows `[I@...` | Use `Arrays.toString(a)` |
| `int[] b = a;` doesn't copy the array | Both names refer to the same array |
| File code won't compile: "unreported exception FileNotFoundException" | Add `throws FileNotFoundException` to the method |

## Exercises

Create a package called `practice` and put all four classes in it. Each exercise lists the exact method signatures and the output your `main` should produce, so you can check yourself as you go.

### Exercise 1: ArrayBasics (arrays, loops, static methods)

Create a class `ArrayBasics` with these two static methods:

```java
public static int[] identity(int n)      // returns a new array of length n where a[i] == i
public static int count(int[] a, int x)  // returns how many times x appears in a
```

Then write a `main` that runs:

```java
int[] a = identity(6);
System.out.println(Arrays.toString(a));

int[] b = {0, 0, 0, 1, 2, 2, 2, 2};
System.out.println(count(b, 2));
System.out.println(count(b, 7));
```

Expected output:

```
[0, 1, 2, 3, 4, 5]
4
0
```

### Exercise 2: Labels (a class with an array field)

Create a class `Labels` that stores one `int` label per element in a private `int[]` field. It needs:

```java
public Labels(int n)                  // constructor: element i starts with label i
public int get(int i)                 // returns the label of element i
public void replaceAll(int x, int y)  // changes every x in the array to y
public int countDistinct()            // returns how many different labels are in use
public String toString()              // returns Arrays.toString of the array
```

You may assume that `replaceAll` is only ever called with a y between 0 and n - 1, so every label always stays in that range.

Hint for `countDistinct`: since all labels are between `0` and `n - 1`, a `boolean[]` of size `n` can record which ones you've seen.

Then write a `main` that runs:

```java
Labels L = new Labels(8);
System.out.println(L);
System.out.println(L.countDistinct());

L.replaceAll(1, 0);
L.replaceAll(2, 0);
L.replaceAll(5, 4);
System.out.println(L);
System.out.println(L.get(2));
System.out.println(L.countDistinct());
```

Expected output:

```
[0, 1, 2, 3, 4, 5, 6, 7]
8
[0, 0, 0, 3, 4, 4, 6, 7]
0
5
```

### Exercise 3: Pointers (following values through an array)

Create a class `Pointers` with a private `int[]` field called `next`. Each element `i` "points to" element `next[i]`. An element that points to itself is a stopping point.

```java
public Pointers(int[] next)  // constructor: store the given array in the field
public int follow(int i)     // start at i, keep moving to next[i] until you reach
                             // an element that points to itself; return that element
public int steps(int i)      // return how many moves follow(i) takes
```

For example, with `next = {0, 2, 0, 5, 5, 5}`, starting at `1` you move to `2`, then to `0`, and `0` points to itself. So `follow(1)` returns `0` and `steps(1)` returns `2`.

Then write a `main` that runs:

```java
int[] arr = {0, 2, 0, 5, 5, 5};
Pointers p = new Pointers(arr);
System.out.println(p.follow(0) + " " + p.steps(0));
System.out.println(p.follow(3) + " " + p.steps(3));
System.out.println(p.follow(1) + " " + p.steps(1));

int[] tall = {0, 0, 1, 2, 3, 4};
Pointers t = new Pointers(tall);
System.out.println(t.follow(5) + " " + t.steps(5));
```

Expected output:

```
0 0
5 1
0 2
0 5
```

### Exercise 4: PairReader (reading numbers from a file)

Create a file called `pairs.txt` in your project's root folder (not in `src`), containing:

```
6
1 2
4 5
3 5
2 0
```

The first number is `n`. Each line after it is a pair of numbers. Create a class `PairReader` whose `main` reads the file with a `Scanner`, prints `n`, prints each pair, and finally prints how many pairs there were.

Hint: `in.hasNextInt()` tells you whether there's another number to read.

Expected output:

```
n = 6
pair: 1 2
pair: 4 5
pair: 3 5
pair: 2 0
4 pairs
```

## Checklist and what's next

- [ ] All four classes are in the `practice` package and start with `package practice;`
- [ ] Each program's output matches the expected output exactly
- [ ] `pairs.txt` is in your project root, not in `src`

Watch `Labels` and `Pointers` in particular. In HW2 you'll meet them again under different names, as the two main approaches to union-find. The file in Exercise 4 uses the same format HW2's input files will use.

