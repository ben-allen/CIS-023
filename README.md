# CIS 23 – Data Structures and Algorithms

**Solano Community College — Spring 2026**

## Course Information

- **Instructor:** Ben Allen (please call me "Ben")
- **Office:** Room 516
- **Office Hours:** 1:30–2:30 PM, Monday through Thursday
- **Credit hours:** 3

## Course Overview

Data Structures and Algorithms introduces students to basic algorithms and problem-solving techniques using object-oriented programming as a tool. The course is intended for students who are comfortable programming in Java and will teach computation skills that will be helpful in computer science or engineering, as well as analytical skills that should be helpful in any field.

**Core topics include:**

- Abstraction: separating the interface for a data structure from its implementation
- Polymorphism: writing code that operates on data regardless of its type
- Practical implementations of fundamental and more advanced data structures (linked lists, hash-encoded storage, binary search trees, red-black trees, and heaps)
- Algorithms for organizing and manipulating data (including sorting, searching, and traversal algorithms), and how the structure of data informs the structure of an algorithm and vice versa
- Analyzing the space and time complexity of algorithms so we can reason about how our programs consume resources

We will explore standard Java libraries, Java generics, features such as the Java `Collection` interface, and exception handling in depth. Much of the course is project-based, with assignments stressing the design and implementation of data structures and algorithms appropriate to a particular problem. We will implement our data structures using object-oriented features of the Java programming language, such as interfaces and classes. Students will come away with an understanding of how to think about algorithms and data structures with the level of generality required to implement them in any programming language.

## Student Learning Outcomes

**Official Student Learning Outcomes:**

- Debug and test the coded solution for syntax and logic errors
- Construct programming language code to implement the solution of the problem
- Analyze a problem statement and design a solution for that problem
- Create and maintain data structures such as sequential and random access files, arrays, stacks, queues, linked lists, classes, etc. and design programs to search, sort, merge and update such structures
- Comprehend the factors involved with structured and object oriented programming
- Design, create, manipulate and maintain data structures and their related processing algorithms

Below are some more detailed learning objectives — these are what we will largely be targeting in the class:

1. Use object-oriented program design
2. Learn abstract data structures, analyze the complexity of algorithms, and design and implement efficient code
3. Describe the most commonly used algorithms for sorting and searching, including balanced search trees, hash tables, minimum spanning trees, and shortest paths
4. Describe the basic string operations, including sorting, searching, regular expression, and string compression

**Classroom Learning Objectives:** To achieve the SLOs, students will engage in activities that encourage them to do the following:

1. Analyze and solve complex problems by breaking down into smaller modules using object-oriented techniques
2. Analyze the complexity of algorithms, and design and implement efficient code
3. Understand the most commonly used algorithms for sorting, searching, graph traversals, and string manipulations
4. Write code using good coding practices

> **Note:** Often when working on the exercises and projects you will find yourself quite frustrated, with very few ideas on how to start developing a solution to the problem. Programming is a task that requires creativity and intuition, as is the analysis of algorithms. By persevering past your initial frustration, you will get practice with the types of creativity that computer science requires, and develop an intuition for what sorts of strategies you should use to produce algorithms to efficiently solve problems.

## Communication and Office Hours

Formal office hours this semester are from 1:30 PM to 2:30 PM on Mondays through Thursdays. If you can't come in person, email me if you'd like to set up a Zoom meeting. I will generally be available:

- At my formal office hours
- Between 2:30 PM and 4:00 PM Monday through Thursday
- (often) between 8:30 AM and 11:00 AM on Mondays through Thursdays

### Discord

I will also be available on the class Discord server, typically from about 8:00 AM to 6:00 PM. Unfortunately I will generally **not** be available for Zoom sessions after 4:00 PM or before 8:30 AM.

If you do not already have Discord installed on your computer or mobile device, you can get it [here](https://discord.com/). An invite link to the Discord is on Canvas; please do not share this link with people outside the class.

Please use the name you use face-to-face as your nickname on the Discord, and please do not share the link with anyone not in the class. I will kick out and ban anyone who I don't recognize as a student from my classes.

Regardless of the channel you're in, please keep your conversations friendly and inclusive. I will be very annoyed if students on the Discord (or in other class forums) use language or behavior that alienates, insults, or excludes your fellow classmates.

### Email

I will *try* to respond to emails sent during the week within 24 hours of the time they're sent, but I am very distractible. For emails sent over the weekend, I will respond on the following Monday. I encourage you to re-send emails if I haven't responded to them in a timely fashion — a small amount of extra credit will be given if I haven't responded in 48 workweek-hours, and you remind me about it.

## Recommended Text

*Algorithms*, Robert Sedgewick and Kevin Wayne — 4th edition (2011)

This is a **recommended** text, not a required one. However, I will be following the text's sequencing fairly closely, because it is — I'm not kidding — one of the few really, really good CS textbooks in the world. Each week will have recommended readings from the textbook, but these are *not* required. I will aim to get all of the material needed to succeed in this course into the weekly lecture videos that I will be putting up on the course site.

The book is definitely a "nice to have," and if you can afford it I strongly recommend buying it. However, **DO NOT SPEND A HUGE AMOUNT OF MONEY ON THIS BOOK.** It may be possible to find relatively cheap used copies online, as well as inexpensive digital copies. Any edition is fine; although computer *technology* changes quickly over time, the fundamentals of computer *science* remain the same.

### Additional texts if you're interested

**[*The Algorithm Design Manual*, Steven Skiena](https://www.algorist.com/)**

This is a remarkably clear and fun to read tour through several significant algorithms and how to prove their correctness. It was recommended to me by a Googler friend, who said that it's the book that people should read to prepare for Google interviews. I will likely be pulling some of the examples from this book for assignments in this class. Note: the examples in this text are in C, rather than Java — however, that shouldn't be too much of an impediment to understanding.

**[*Introduction to Algorithms*](https://mitpress.mit.edu/books/introduction-algorith), Cormen, Leiserson, Rivest, Stein**

The title to this book is *Introduction to Algorithms*, but literally no one calls it that — everyone says *CLRS*, after the initials of the authors. This is *the* canonical algorithms textbook, and contains some remarkably cutting-edge research presented in a relatively readable style. However, of all textbooks I've read it's the one that's most densely packed with information. I started using the Skiena book listed above when I found myself having trouble understanding CLRS — I'd see how Skiena describes something, make sure I understood that, and then go back to look at the more complete and rigorous explanation from CLRS. You can succeed in this class without ever setting eyes on CLRS, but if you find the material in this class compelling and you want to know what the cutting-edge research is, and you've got the math background to follow it, it's worth giving this one a shot.

## Required Software

We will be using [IntelliJ IDEA](https://www.jetbrains.com/idea/) in this class. Use the free community edition — the only reason to pay money for IntelliJ is if you're a large corporation.

If you already have extensive experience with another Java IDE, or if you're experienced with developing Java programs from the command line, it is perfectly fine for you to continue using your preferred environment. However, I won't be able to provide significant technical support, since most of the Java development I've done in my life has either been in IntelliJ or in specialized IDEs for developing Android programs.

### GitHub

Although course material will be mirrored to the class Canvas site, and although assignment turn-in will happen on Canvas, the GitHub repository set up for the class at [github.com/ben-allen/CIS-023](https://github.com/ben-allen/CIS-023) may be the easiest place to access course materials — generally as I develop new materials I will post them to GitHub and then mirror them on Canvas.

GitHub is the tool used by the vast majority of professional open-source software programmers, and getting comfortable with navigating GitHub repositories is a tremendously useful skill for people interested in working in industry — often one of the primary things that employers do before considering offering an interview is checking what applicants have put up on GitHub.

## Assignments and Grading

There will be major assignments every week to two weeks. Assignments will be made available at the start of each week, along with lecture videos and slides related to the assignments.

The Sedgewick book, from which most of my class materials are drawn, is in the Java programming language. Fortunately, Sedgewick uses a fairly small subset of the language, so deep knowledge of Java is not required — **so long as you have significant experience in at least one programming language.** In order to give everyone a solid foundation in just enough Java to keep from having to struggle with the language, the first **three** weeks of the class will largely focus on a quick overview of the Java programming language.

### Grading breakdown

Scores on assignments can be monitored on Canvas.

Fractional grades will be rounded up to the next whole number if the fractional part is greater than 0.5. For example, a grade of 89.6% would be rounded up to 90%. But a grade of 89.4% would be rounded down to 89%.

At the end of the semester, grades will be assigned based on the following percentages:

| Grade | Range |
|---|---|
| A | 90–100% |
| B | 80–89% |
| C | 70–79% |
| D | 60–69% |
| F | 0–59% |

### Late assignment policy

- Projects turned in **on time** get a 3% on-time bonus.
- Projects turned in **within three days** of the due date get full credit.
- Projects turned in **more than three days but less than ten days late** get a 10% penalty.
- Projects turned in **more than ten days late** get a 25% penalty.

### Extensions

Our students come from varied backgrounds and can have widely varying situations and necessities. If you have any unforeseen or extenuating circumstances that arise during the course and that may prevent you from completing course material in a timely fashion, please reach out to me so that we can discuss your situation. If you need an extension on one of the major assignments, **PLEASE ASK WELL IN ADVANCE.** I won't respond to requests for extensions the night before the assignment is due. (I'm not kidding here — I'll just ignore them.)

### Accommodations

Solano Community College is committed to providing equitable access to learning opportunities for all students. The Accessibility Services Center (ASC) works with students who have disabilities to determine and provide reasonable accommodations. If you have a disability, or think you may have a disability, and would like to request accommodations, please contact the ASC at (707) 864-7136 or [asc@solano.edu](mailto:asc@solano.edu). If you have already established accommodations with the ASC, please share your accommodation letter with me and discuss your needs as early in the semester as possible so that accommodations can be implemented in a timely fashion.

## Academic Dishonesty and Cheating

Please carefully read the policies and contact me if something is unclear.

- It **IS** reasonable (and a good idea!) to discuss your ideas and your programs with your classmates.
  - CS class study groups are where startups and worker-owned code co-ops are born.
- It is **NOT** reasonable to directly copy solutions from your classmates.
  - To avoid accidentally setting off my plagiarism detector, I recommend that you avoid looking directly at each other's code. Talk about how your code works, think up ideas to improve your code, but don't **show** your code.
- It is **NOT** reasonable (or a good idea) to copy-paste code from Stack Overflow or other similar sites.
  - In general, I don't recommend using Stack Overflow (and other similar sites) as references. Generally answers found on Stack Overflow are geared toward the needs of working professional programmers, and involve portions of the Java language that we will not cover in this class.
- If you directly copy someone else's code, the penalties will be severe. You will receive at minimum an F in the class.
- It is not a good idea to copy someone else's code and then make small tweaks to make it seem like original work. To make this type of plagiarism very difficult to do, I will be using a plagiarism detector that implements the ideas discussed in [this paper by former UC Berkeley (currently at Stanford) CS professor Alex Aiken](http://theory.stanford.edu/~aiken/publications/papers/sigmod03.pdf).

## Let's Talk About LLMs

So there are some things LLMs are really, really good at, and some things they are simply *awful* at. They are *very very good* at certain types of student exercises, particularly exercises associated with foundational computer science classes — this is because there is a very large amount of publicly-available code for these exercises. If you rely on them heavily, though, the problems come in down the road, when you're doing something that's either:

- More complicated than anything that's common on the internet, or
- In a less-commonly used programming language

at which point they become *extremely awful*. I do not recommend using them extensively in this class. If it's any incentive, I know from my experience in industry that people who have a solid algorithm design foundation are the ones with the most LLM-safe jobs, because, among other things, they're the ones who best understand how to spot and fix errors in LLM-generated code.

Also note that this class isn't about the assignments, it's about the *exercise* you get while working on the assignments. A forklift can lift more weight than you can. However, getting a workout requires lifting things with *your own muscles* instead of with a forklift.

