# CIS 23 – Data Structures and Algorithms

**Solano Community College — Fall 2026**

## Course Information

- **Instructor:** Ben Allen (please call me "Ben")
- **Email:** **[TODO: email address]**
- **Office:** Room 516
- **Office Hours:** 1:30–2:30 PM Monday through Thursday, and 7:30–9:00 AM Fridays (see [Communication and Office Hours](#communication-and-office-hours))
- **Units:** 3

- **Class meeting time:** I will be recording videos for each week on Friday mornings, starting at 7:30 AM and going until 9:00 AM. I'll be recording these videos via Zoom, and if you're able to join I encourage you to -- it's a good time to ask questions. However, this is indeed an *asynchronous* course, and so "attendance" is in no way required. I will generally edit and post videos over the weekend.

## Course Overview

Data Structures and Algorithms introduces students to basic algorithms and problem-solving techniques using object-oriented programming as a tool. The course will teach computation skills that will be helpful in computer science or engineering, as well as analytical skills that should be helpful in any field.

The Sedgewick book, from which most of my class materials are drawn, is in the Java programming language. Fortunately, Sedgewick uses a fairly small subset of the language, so deep knowledge of Java is not required — **so long as you have significant experience in at least one programming language.** In order to give everyone a solid foundation in just enough Java to keep from having to struggle with the language, the first **three** weeks of the class will largely focus on a quick overview of the Java programming language.

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

**Course Learning Objectives:** To achieve the SLOs, the activities in this class will focus on helping you:

1. Use object-oriented design to analyze and solve complex problems by breaking them down into smaller modules
2. Learn abstract data structures, and implement them so that their interfaces are separate from their implementations
3. Analyze the complexity of algorithms, and design and implement efficient code
4. Understand and describe the most commonly used algorithms for sorting and searching, including balanced search trees and hash tables
5. Understand and describe common graph algorithms, including graph traversals, minimum spanning trees, and shortest paths
6. Understand and describe basic string operations, including sorting, searching, regular expressions, and string compression
7. Write code using good coding practices

> **Note:** Often when working on the exercises and projects you will find yourself quite frustrated, with very few ideas on how to start developing a solution to the problem. Programming is a task that requires creativity and intuition, as is the analysis of algorithms. By persevering past your initial frustration, you will get practice with the types of creativity that computer science requires, and develop an intuition for what sorts of strategies you should use to produce algorithms to efficiently solve problems.

## Communication and Office Hours

Office hours this semester are:

- **1:30–2:30 PM, Monday through Thursday.** You can come in person to Room 516 or join via Zoom.
- **7:30–9:00 AM, Fridays, via Zoom.** I'll generally be recording the weekly class videos for part of this time, so you may join mid-recording. Questions are welcome either way, both during recording and after.

The Zoom link for office hours is on Canvas. If neither time works for you, email me and we can set up a separate meeting.

### Discord

There is a class Discord for discussion of assignments and materials. I will be sporadically present on it, though email is the best way to contact me.

If you do not already have Discord installed on your computer or mobile device, you can get it [here](https://discord.com/). An invite link to the Discord is on Canvas; please do not share this link with anyone not in the class. I will kick out and ban anyone who I don't recognize as a student from my classes.

Please use the name you use face-to-face as your nickname on the Discord.

Regardless of the channel you're in, please keep your conversations friendly and inclusive. I will be very annoyed if students on the Discord (or in other class forums) use language or behavior that alienates, insults, or excludes your fellow classmates.

### Email

I will respond to emails sent during the week within 24 hours of the time they're sent, and generally faster than that for emails sent during the work day. For emails sent over the weekend, I will respond on the following Monday. I encourage you to re-send emails if I haven't responded to them in a timely fashion — I do confess, I am very distractible and sometimes miss emails. I will give a small amount of extra credit if I haven't responded in 48 workweek-hours, and you remind me about it.

## Recommended Text

*Algorithms*, Robert Sedgewick and Kevin Wayne — 4th edition (2011)

This is a **recommended** text, not a required one. However, I will be following the text's sequencing fairly closely, because it is — I'm not kidding — one of the few really, really good CS textbooks in the world. Each week will have recommended readings from the textbook, but these are *not* required. I will aim to get all of the material needed to succeed in this course into the weekly lecture videos that I will be putting up on the course site.

The book is definitely a "nice to have," and if you can afford it I strongly recommend buying it. However, **DO NOT SPEND A HUGE AMOUNT OF MONEY ON THIS BOOK.** It may be possible to find relatively cheap used copies online, as well as inexpensive digital copies. Any printing of the 4th edition is fine. Older editions (such as *Algorithms in C* or *Algorithms in C++*) cover much of the same material, but they aren't in Java and are organized differently, so they'll be harder to follow alongside the class.

### Additional texts if you're interested

These are texts that I've considered using as textbooks, but ultimately decided against. If you find yourself interested in algorithm design -- it's a difficult field, but a rewarding one -- these are some books that might be good next steps after this class.

**[*The Algorithm Design Manual*, Steven Skiena](https://www.algorist.com/)**

This is a remarkably clear and fun to read tour through several significant algorithms and how to prove their correctness. It was recommended to me by a Googler friend, who said that it's the book that people should read to prepare for Google interviews. I will likely be pulling some of the examples from this book for assignments in this class. Note: the examples in this text are in C, rather than Java — however, that shouldn't be too much of an impediment to understanding.

**[*Introduction to Algorithms*](https://mitpress.mit.edu/9780262046305/introduction-to-algorithms/), Cormen, Leiserson, Rivest, Stein**

The title to this book is *Introduction to Algorithms*, but literally no one calls it that — everyone says *CLRS*, after the initials of the authors. This is *the* canonical algorithms textbook, and a remarkably useful reference. However, of all textbooks I've read it's the one that's most densely packed with information.

The first Algorithms course I ever took in undergrad used CLRS. I referred to the Skiena book listed above when I found myself having trouble understanding CLRS — I'd see how Skiena describes something, make sure I understood that, and then go back to look at the more complete and rigorous explanation from CLRS. You can succeed in this class without ever setting eyes on CLRS -- it is a *very* difficult text -- but if you are extremely interested in the material and have a solid math background, it is very illuminating.

## Required Software

We will be using [Eclipse](https://www.eclipse.org/downloads/) in this class. They will ask you to donate money when you download it. It is not necessary, and you probably shouldn't do that.

If you already have extensive experience with another Java IDE, or if you're experienced with developing Java programs from the command line, it is perfectly fine for you to continue using your preferred environment. However, I won't be able to provide significant technical support for anything but Eclipse or IntelliJ, since most of the Java development I've done in my life has either been in Eclipse, IntelliJ, or in specialized IDEs for developing Android programs.

### GitHub

Although course material will be mirrored to the class Canvas site, and although assignment turn-in will happen on Canvas, the GitHub repository set up for the class at [github.com/ben-allen/CIS-023](https://github.com/ben-allen/CIS-023) may be the easiest place to access course materials — generally as I develop new materials I will post them to GitHub and then later mirror them on Canvas.

GitHub is the tool used by the vast majority of professional open-source software programmers, and getting comfortable with navigating GitHub repositories is a tremendously useful skill for people interested in working in industry — often one of the primary things that employers do before considering offering an interview is checking what applicants have put up on GitHub.

## Assignments and Grading

There will be major assignments every week to two weeks. Assignments will be made available at the start of each week, along with lecture videos and slides related to the assignments. 

### Grading breakdown

Scores on assignments can be monitored on Canvas. We do not have tests; assignments will be 100% of your grade. 

At the end of the semester, grades will be assigned based on the following percentages. I will round up all fractional grades:

| Grade | Range |
|---|---|
| A | 90–100% |
| B | 80–89% |
| C | 70–79% |
| D | 60–69% |
| F | 0–59% |

### Late assignment policy

- Projects turned in **on time** get a 3% on-time bonus.
- Projects turned in **up to three days** after the due date get full credit.
- Projects turned in **more than three days and up to ten days** after the due date get a 10% penalty.
- Projects turned in **more than ten days** after the due date get a 25% penalty.

### Extensions

Our students come from varied backgrounds and can have widely varying situations and necessities. If you have any unforeseen or extenuating circumstances that arise during the course and that may prevent you from completing course material in a timely fashion, please reach out to me so that we can discuss your situation. For anything you can see coming, if you need an extension on one of the major assignments, **PLEASE ASK WELL IN ADVANCE.** I won't respond to routine requests for extensions the night before the assignment is due.

### Accommodations

Solano Community College is committed to providing equitable access to learning opportunities for all students. The Accessibility Services Center (ASC) works with students who have disabilities to determine and provide reasonable accommodations. If you have a disability, or think you may have a disability, and would like to request accommodations, please contact the ASC at (707) 864-7136 or [asc@solano.edu](mailto:asc@solano.edu). If you have already established accommodations with the ASC, please share your accommodation letter with me and discuss your needs as early in the semester as possible so that accommodations can be implemented in a timely fashion.

## Academic Dishonesty and Cheating

Please carefully read the policies and contact me if something is unclear.

- It **IS** reasonable (and a good idea!) to discuss your ideas and your programs with your classmates.
- It is **NOT** reasonable to directly copy solutions from your classmates.
  - To avoid accidentally ending up with code that looks copied, I recommend that you avoid looking directly at each other's code. Talk about how your code works, think up ideas to improve your code, but don't **show** your code.
- It is **NOT** reasonable (or a good idea) to copy-paste code from Stack Overflow or other similar sites.
  - If you must use a *short* snippet of code from the Internet -- one or two lines at most -- **include a comment indicating where you got it from and how it works.** I reserve the right to ask questions to make sure you understand the code you've used.
  - Likewise, LLM-generated code can contain very advanced concepts and constructs. I do not ban the use of AI tools for this class, but when you use LLM code **include a comment indicating that it's LLM generated** that **explains in your own words how it works**.
  - It is not a good idea to copy someone else's code and then make small tweaks to make it seem like original work. Renaming variables and shuffling lines around hides copying much less well than people think. If you're curious why, [this paper co-authored by Stanford CS professor Alex Aiken](http://theory.stanford.edu/~aiken/publications/papers/sigmod03.pdf) describes "winnowing," the algorithm behind MOSS, a widely used code-plagiarism detector. It's a genuinely elegant piece of algorithm design.

## Let's talk about LLMs

There are some things LLMs are very good at, and some things they're much worse at. They are *very* good at certain types of student exercises -- anything that there's a large amount of publicly-available code that can be used to solve the problem. They get noticeably less reliable for work that is:

- More complicated or more unusual than what's common on the internet
- In a less-commonly used programming language or library
- Dependent on details of a large codebase that they can't see all of at once

When they fail in these situations, the failures are often *subtle*: code that looks right, runs, and is wrong in a way you won't catch unless you understand it.

**For my part:** I tend to use LLMs for certain rote/repetitive tasks. I often use them to correct accessibility-related errors and formatting inconsistencies in slide decks, and sometimes use them to do diagram layout for examples -- this is something they used to be not great at, but can now do impressively well. For fun I had an LLM check the document you're reading right now for inconsistencies, and allowed it to write the text in the paragraph above.

As far as coding with LLMs, I find them very useful for writing "boilerplate-heavy" code; for example, I "vibe-coded" the graphical user interface of the Karel the Robot tool that I use in many of my classes. Before this semester I used a text-based interface for this tool, because I could never quite find the time to write the JavaScript GUI. One reason I put it off until I could ask a machine to do it for me is that the part of the program that is the same in the text-based version as in the GUI version -- the code that actually interprets Karel commands -- is inherently interesting to me, and absolutely has to be 100% correct. On the other hand, I find the parts about getting (for example) the GUI text box pane to display in exactly the right place to be kind of boring. I am comfortable using this vibe-coded interface for the Karel tool, since it's not a huge disaster if there are glitches that I haven't noticed -- students can tell me when they find them, and then I can go in and fix the code by hand. I wouldn't be nearly as comfortable trusting the vibe-coded interface if I intended other instructors to use it, since I'm certain it has meaningful errors that haven't yet been spotted.

Additionally: if I didn't have extensive programming knowledge, I would have had a much harder time with the vibe-coding itself -- getting good results from automated code generation tools requires being able to clearly and concisely describe the problem, and also describe what's important to get right. When you vibe-code with concepts you *don't* already understand, you'll often get something that works -- at first. The trouble starts when it stops working, or when it works on the inputs you tried but not on the ones you didn't, and you can't tell why or how to fix it. At that point you're asking a machine to fix code that neither of you really understands, and that loop can eat an enormous amount of time (and tokens).

This is to say: LLMs are good at the boring part, which is pretty cool, and they're good at getting things *almost* right, which is sometimes all you need, and they're good if you can describe *exactly* what you want them to do, which requires real knowledge.

One 2025 study (by the research group METR) found that experienced developers working on large projects they knew well were about 19% *slower* when using AI tools -- while believing they'd been about 20% *faster*. The tools have improved since then, and more recent estimates tend to find gains that are real -- but far more modest than expected. One big reason: reviewing generated code for subtle errors takes time, and it takes most of the same knowledge of computer science and computer engineering that writing the code yourself does.

In short: it's a very, very good idea to learn the underlying concepts instead of just letting LLMs write code for you, because once you start writing programs above a certain level of complexity you will run into serious problems if you don't actually understand what the LLM generates.

Although your grades are derived from your responses to assignments, this class isn't *about* the assignments. Instead, it's about the exercise you get while working on the assignments. A forklift can lift more weight than you can. However, getting a workout requires lifting things with your own muscles instead of with a forklift.
