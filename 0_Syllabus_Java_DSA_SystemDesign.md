# 0 — Complete Java Developer Syllabus
## Java + DSA + System Design | Beginner → Google/Microsoft Interview Ready

> 📘 *References: Java The Complete Reference (Herbert Schildt) · DSA in Java (Lafore) · Grokking Algorithms · Cracking the Coding Interview · System Design Interview (Alex Xu)*

---

## 🗺️ Course Overview

```
┌─────────────────────────────────────────────────────────────────┐
│           COMPLETE JAVA DEVELOPER ROADMAP                       │
├─────────────────────────────────────────────────────────────────┤
│  PART 1 — Java Fundamentals          (Sections  1 –  6)        │
│  PART 2 — Object-Oriented Programming (Sections  7 – 12)       │
│  PART 3 — Core Java Intermediate     (Sections 13 – 17)        │
│  PART 4 — Advanced Java (Java 8–21)  (Sections 18 – 21)        │
│  PART 5 — Data Structures & Algorithms(Sections 22 – 33)       │
│  PART 6 — System Design              (Sections 34 – 37)        │
│  PART 7 — Interview Preparation      (Sections 38 – 40)        │
└─────────────────────────────────────────────────────────────────┘
  Total: 40 Sections | 200+ Topics | Google/Microsoft Target
```

---

# PART 1 — Java Fundamentals (Beginner)

---

## Section 1 — Introduction to Java ✅

| # | Topic | Status |
|---|-------|--------|
| 1.1 | What is Java? History & Features | ⏳ |
| 1.2 | JDK, JRE, JVM — differences & architecture | ⏳ |
| 1.3 | How Java code compiles and runs (bytecode, classloader) | ⏳ |
| 1.4 | Your first Java program — Hello World | ⏳ |
| 1.5 | Java versions & what's new (Java 8 → Java 21 LTS) | ⏳ |
| 1.6 | Setting up IntelliJ IDEA / VS Code / Eclipse | ⏳ |

---

## Section 2 — Variables & Data Types ✅

| # | Topic | Status |
|---|-------|--------|
| 2.1 | What is a variable — declaration, initialization, naming rules | ⏳ |
| 2.2 | Primitive data types — `int`, `float`, `double`, `char`, `boolean`, `byte`, `short`, `long` | ✅ |
| 2.3 | Non-primitive types — `String`, Arrays, Objects | ✅ |
| 2.4 | `var` keyword (Java 10+) — local type inference | ✅ |
| 2.5 | Constants — `final` keyword | ✅ |
| 2.6 | Scope of variables — local, instance, static | ✅ |
| 2.7 | Tricky questions on data types & overflow | ✅ |

---

## Section 3 — Operators ✅

| # | Topic | Status |
|---|-------|--------|
| 3.1 | Arithmetic operators — `+` `-` `*` `/` `%` | ✅ |
| 3.2 | Relational operators — `==` `!=` `>` `<` `>=` `<=` | ✅ |
| 3.3 | Logical operators — `&&` `\|\|` `!` | ✅ |
| 3.4 | Bitwise operators — `&` `\|` `^` `~` `<<` `>>` `>>>` | ✅ |
| 3.5 | Assignment operators — `=` `+=` `-=` `*=` `/=` `%=` `&=` `\|=` `^=` `<<=` `>>=` `>>>=` | ✅ |
| 3.6 | Ternary operator — `condition ? a : b` | ✅ |
| 3.7 | `instanceof` operator + pattern matching (Java 16+) | ✅ |
| 3.8 | Operator precedence & tricky expressions | ✅ |

---

## Section 4 — Control Flow ✅

| # | Topic | Status |
|---|-------|--------|
| 4.1 | `if`, `if-else`, `else-if` ladder | ✅ |
| 4.2 | Nested `if` | ✅ |
| 4.3 | `switch` statement (traditional) + fall-through | ✅ |
| 4.4 | `switch` expressions (Java 14+) — arrow syntax, `yield` | ✅ |
| 4.5 | `for` loop — variations, multiple variables | ✅ |
| 4.6 | `while` loop — sentinel, unknown count | ✅ |
| 4.7 | `do-while` loop — guaranteed first execution | ✅ |
| 4.8 | Enhanced `for-each` loop — arrays, collections | ✅ |
| 4.9 | `break`, `continue`, `return` | ✅ |
| 4.10 | Labeled loops — `break label`, `continue label` | ✅ |
| 4.11 | Tricky loop & control flow interview questions (15 Q&A) | ✅ |

---

## Section 5 — Strings

| # | Topic | Status |
|---|-------|--------|
| 5.1 | String class — creation, immutability, String pool | ⏳ |
| 5.2 | String methods — `length`, `charAt`, `substring`, `indexOf`, `contains`, `replace`, `split`, `trim`, `strip` | ⏳ |
| 5.3 | String comparison — `==` vs `equals()` vs `compareTo()` | ⏳ |
| 5.4 | `StringBuilder` and `StringBuffer` — mutable strings, performance | ⏳ |
| 5.5 | String formatting — `printf`, `format`, `formatted` | ⏳ |
| 5.6 | Regular expressions basics with `String.matches()`, `replaceAll()` | ⏳ |
| 5.7 | Tricky String interview questions (palindrome, anagram, reversal) | ⏳ |

---

## Section 6 — Arrays

| # | Topic | Status |
|---|-------|--------|
| 6.1 | 1D arrays — declaration, initialization, traversal | ⏳ |
| 6.2 | 2D arrays — matrices, row-major order | ⏳ |
| 6.3 | Jagged arrays | ⏳ |
| 6.4 | Array methods — `Arrays.sort()`, `Arrays.copyOf()`, `Arrays.fill()`, `Arrays.binarySearch()` | ⏳ |
| 6.5 | Passing arrays to methods — reference semantics | ⏳ |
| 6.6 | Varargs — `int... args` | ⏳ |
| 6.7 | Tricky array questions — rotation, duplicates, two-sum | ⏳ |

---

# PART 2 — Object-Oriented Programming

---

## Section 7 — Classes & Objects

| # | Topic | Status |
|---|-------|--------|
| 7.1 | Class anatomy — fields, methods, constructors | ⏳ |
| 7.2 | Creating objects — `new` keyword, heap vs stack | ⏳ |
| 7.3 | Constructors — default, parameterized, copy constructor | ⏳ |
| 7.4 | Constructor overloading & constructor chaining (`this()`) | ⏳ |
| 7.5 | `this` keyword — reference to current object | ⏳ |
| 7.6 | `static` keyword — static fields, static methods, static blocks | ⏳ |
| 7.7 | Access modifiers — `public`, `private`, `protected`, package-private | ⏳ |
| 7.8 | Getters, setters & encapsulation | ⏳ |
| 7.9 | Object class methods — `toString()`, `equals()`, `hashCode()` | ⏳ |

---

## Section 8 — Inheritance

| # | Topic | Status |
|---|-------|--------|
| 8.1 | `extends` keyword — IS-A relationship | ⏳ |
| 8.2 | Method overriding — `@Override` annotation | ⏳ |
| 8.3 | `super` keyword — calling parent constructor & methods | ⏳ |
| 8.4 | `final` class & `final` method — preventing inheritance/override | ⏳ |
| 8.5 | Multilevel inheritance — A → B → C | ⏳ |
| 8.6 | Why Java doesn't support multiple class inheritance (diamond problem) | ⏳ |
| 8.7 | Inheritance constructor chain — order of execution | ⏳ |
| 8.8 | Tricky inheritance interview questions | ⏳ |

---

## Section 9 — Polymorphism

| # | Topic | Status |
|---|-------|--------|
| 9.1 | Compile-time polymorphism — method overloading | ⏳ |
| 9.2 | Runtime polymorphism — method overriding + dynamic dispatch | ⏳ |
| 9.3 | Upcasting and downcasting | ⏳ |
| 9.4 | Covariant return types | ⏳ |
| 9.5 | Polymorphism with arrays and collections | ⏳ |
| 9.6 | Tricky overloading vs overriding questions | ⏳ |

---

## Section 10 — Abstraction

| # | Topic | Status |
|---|-------|--------|
| 10.1 | Abstract classes — `abstract` keyword | ⏳ |
| 10.2 | Interfaces — `interface`, `implements`, multiple interfaces | ⏳ |
| 10.3 | Default & static methods in interfaces (Java 8+) | ⏳ |
| 10.4 | Private methods in interfaces (Java 9+) | ⏳ |
| 10.5 | Abstract class vs Interface — when to use which | ⏳ |
| 10.6 | Functional interfaces — `@FunctionalInterface` | ⏳ |
| 10.7 | Sealed classes (Java 17+) | ⏳ |

---

## Section 11 — Encapsulation & Design Principles

| # | Topic | Status |
|---|-------|--------|
| 11.1 | Encapsulation deep dive — data hiding, JavaBeans convention | ⏳ |
| 11.2 | Immutable classes — how to create, why use them | ⏳ |
| 11.3 | SOLID principles — overview with Java examples | ⏳ |
| 11.4 | DRY, KISS, YAGNI principles | ⏳ |
| 11.5 | Record classes (Java 16+) — immutable data carriers | ⏳ |

---

## Section 12 — Inner Classes & Anonymous Classes

| # | Topic | Status |
|---|-------|--------|
| 12.1 | Static nested classes | ⏳ |
| 12.2 | Non-static (inner) classes | ⏳ |
| 12.3 | Local classes — defined inside methods | ⏳ |
| 12.4 | Anonymous classes — inline implementation | ⏳ |
| 12.5 | Lambda expressions vs anonymous classes | ⏳ |

---

# PART 3 — Core Java (Intermediate)

---

## Section 13 — Exception Handling

| # | Topic | Status |
|---|-------|--------|
| 13.1 | What are exceptions — checked vs unchecked | ⏳ |
| 13.2 | `try`, `catch`, `finally` — syntax and flow | ⏳ |
| 13.3 | Multiple catch blocks & exception hierarchy | ⏳ |
| 13.4 | `throw` and `throws` keywords | ⏳ |
| 13.5 | Custom exceptions — creating your own exception class | ⏳ |
| 13.6 | Try-with-resources (Java 7+) — `AutoCloseable` | ⏳ |
| 13.7 | Multi-catch (`catch (A \| B e)`) | ⏳ |
| 13.8 | Exception best practices — what to catch, what to rethrow | ⏳ |
| 13.9 | Tricky exception questions | ⏳ |

---

## Section 14 — Collections Framework

| # | Topic | Status |
|---|-------|--------|
| 14.1 | Collections hierarchy — `Collection`, `List`, `Set`, `Queue`, `Map` | ⏳ |
| 14.2 | `ArrayList` — dynamic array, internal resizing | ⏳ |
| 14.3 | `LinkedList` — doubly linked, as Deque | ⏳ |
| 14.4 | `HashMap` — hashing, buckets, load factor, Java 8 tree bins | ⏳ |
| 14.5 | `LinkedHashMap` — insertion-order map | ⏳ |
| 14.6 | `TreeMap` — sorted map, Red-Black tree | ⏳ |
| 14.7 | `HashSet`, `LinkedHashSet`, `TreeSet` | ⏳ |
| 14.8 | `PriorityQueue` — heap-based queue | ⏳ |
| 14.9 | `ArrayDeque` — stack and queue operations | ⏳ |
| 14.10 | `Collections` utility class — `sort`, `reverse`, `shuffle`, `min`, `max` | ⏳ |
| 14.11 | Iterators — `Iterator`, `ListIterator`, `ConcurrentModificationException` | ⏳ |
| 14.12 | Comparable vs Comparator — custom sorting | ⏳ |
| 14.13 | Choosing the right collection — decision guide | ⏳ |

---

## Section 15 — Generics

| # | Topic | Status |
|---|-------|--------|
| 15.1 | Why generics — type safety, no casting | ⏳ |
| 15.2 | Generic classes — `class Box<T>` | ⏳ |
| 15.3 | Generic methods | ⏳ |
| 15.4 | Bounded type parameters — `<T extends Number>` | ⏳ |
| 15.5 | Wildcards — `<?>`, `<? extends T>`, `<? super T>` | ⏳ |
| 15.6 | Type erasure — what happens at runtime | ⏳ |
| 15.7 | Generic interfaces | ⏳ |

---

## Section 16 — File I/O & Serialization

| # | Topic | Status |
|---|-------|--------|
| 16.1 | `File` class — create, delete, list files | ⏳ |
| 16.2 | `FileReader`, `FileWriter` — character streams | ⏳ |
| 16.3 | `BufferedReader`, `BufferedWriter` — efficient I/O | ⏳ |
| 16.4 | `FileInputStream`, `FileOutputStream` — byte streams | ⏳ |
| 16.5 | NIO.2 — `Path`, `Files`, `Paths` (Java 7+) | ⏳ |
| 16.6 | Serialization — `Serializable`, `ObjectOutputStream`, `transient` | ⏳ |
| 16.7 | Reading JSON / CSV files | ⏳ |

---

## Section 17 — Multithreading & Concurrency Basics

| # | Topic | Status |
|---|-------|--------|
| 17.1 | Process vs Thread — what is a thread | ⏳ |
| 17.2 | Creating threads — `Thread` class vs `Runnable` interface | ⏳ |
| 17.3 | Thread lifecycle — NEW, RUNNABLE, BLOCKED, WAITING, TERMINATED | ⏳ |
| 17.4 | `sleep()`, `join()`, `yield()` | ⏳ |
| 17.5 | Race conditions & thread safety | ⏳ |
| 17.6 | `synchronized` keyword — method and block | ⏳ |
| 17.7 | `volatile` keyword | ⏳ |
| 17.8 | `wait()`, `notify()`, `notifyAll()` — inter-thread communication | ⏳ |
| 17.9 | Deadlock — causes, detection, prevention | ⏳ |
| 17.10 | `ExecutorService` & thread pools — `Executors.newFixedThreadPool()` | ⏳ |

---

# PART 4 — Advanced Java (Java 8 – 21)

---

## Section 18 — Functional Programming (Java 8+)

| # | Topic | Status |
|---|-------|--------|
| 18.1 | Lambda expressions — syntax, use cases | ⏳ |
| 18.2 | Functional interfaces — `Function`, `Consumer`, `Supplier`, `Predicate` | ⏳ |
| 18.3 | Method references — `::` operator, 4 types | ⏳ |
| 18.4 | Streams API — `stream()`, `filter()`, `map()`, `reduce()`, `collect()` | ⏳ |
| 18.5 | Intermediate vs terminal stream operations | ⏳ |
| 18.6 | Collectors — `toList()`, `toMap()`, `groupingBy()`, `joining()` | ⏳ |
| 18.7 | `Optional<T>` — avoiding NullPointerException | ⏳ |
| 18.8 | Parallel streams — `parallelStream()` | ⏳ |
| 18.9 | Tricky streams & lambda interview questions | ⏳ |

---

## Section 19 — Modern Java Features

| # | Topic | Status |
|---|-------|--------|
| 19.1 | `var` type inference (Java 10) | ⏳ |
| 19.2 | Text blocks — multiline strings `"""` (Java 15) | ⏳ |
| 19.3 | Records (Java 16) — compact data classes | ⏳ |
| 19.4 | Sealed classes (Java 17) — restricted hierarchies | ⏳ |
| 19.5 | Pattern matching for `switch` (Java 21) | ⏳ |
| 19.6 | Virtual threads — Project Loom (Java 21) | ⏳ |
| 19.7 | `String` enhancements — `stripIndent()`, `translateEscapes()`, `repeat()` | ⏳ |

---

## Section 20 — Advanced Concurrency

| # | Topic | Status |
|---|-------|--------|
| 20.1 | `ReentrantLock` — explicit locking | ⏳ |
| 20.2 | `ReadWriteLock` — concurrent reads, exclusive write | ⏳ |
| 20.3 | `Semaphore`, `CountDownLatch`, `CyclicBarrier` | ⏳ |
| 20.4 | Atomic classes — `AtomicInteger`, `AtomicLong`, `AtomicReference` | ⏳ |
| 20.5 | Concurrent collections — `ConcurrentHashMap`, `CopyOnWriteArrayList` | ⏳ |
| 20.6 | `CompletableFuture` — async programming | ⏳ |
| 20.7 | `ForkJoinPool` — divide and conquer parallelism | ⏳ |
| 20.8 | Thread-safe singleton patterns | ⏳ |

---

## Section 21 — JVM Internals & Performance

| # | Topic | Status |
|---|-------|--------|
| 21.1 | JVM architecture — heap, stack, metaspace, code cache | ⏳ |
| 21.2 | Garbage collection — GC algorithms (G1, ZGC, Shenandoah) | ⏳ |
| 21.3 | Memory leaks — how they happen, how to detect | ⏳ |
| 21.4 | JIT compilation — hot spot optimization | ⏳ |
| 21.5 | Profiling tools — JVisualVM, JProfiler, async-profiler | ⏳ |
| 21.6 | `System.gc()`, `Runtime.getRuntime()` — memory info | ⏳ |
| 21.7 | Java performance best practices | ⏳ |

---

# PART 5 — Data Structures & Algorithms

---

## Section 22 — Complexity Analysis

| # | Topic | Status |
|---|-------|--------|
| 22.1 | Big-O notation — O(1), O(log n), O(n), O(n log n), O(n²), O(2ⁿ) | ⏳ |
| 22.2 | Big-Ω (best) and Big-Θ (average) notations | ⏳ |
| 22.3 | Space complexity analysis | ⏳ |
| 22.4 | Amortized complexity — ArrayList resizing example | ⏳ |
| 22.5 | Complexity of built-in Java operations (HashMap, Arrays.sort, etc.) | ⏳ |

---

## Section 23 — Arrays & Strings (DSA)

| # | Topic | Status |
|---|-------|--------|
| 23.1 | Two-pointer technique | ⏳ |
| 23.2 | Sliding window technique | ⏳ |
| 23.3 | Prefix sum & difference arrays | ⏳ |
| 23.4 | Kadane's algorithm — maximum subarray | ⏳ |
| 23.5 | Dutch National Flag — 3-way partition | ⏳ |
| 23.6 | Boyer-Moore majority vote | ⏳ |
| 23.7 | String algorithms — KMP, Rabin-Karp | ⏳ |
| 23.8 | Classic problems — two sum, trapping rain water, rotate array | ⏳ |

---

## Section 24 — Linked Lists

| # | Topic | Status |
|---|-------|--------|
| 24.1 | Singly linked list — node structure, insert, delete, traverse | ⏳ |
| 24.2 | Doubly linked list | ⏳ |
| 24.3 | Circular linked list | ⏳ |
| 24.4 | Floyd's cycle detection — fast & slow pointers | ⏳ |
| 24.5 | Reverse a linked list — iterative & recursive | ⏳ |
| 24.6 | Merge two sorted lists | ⏳ |
| 24.7 | Find middle of linked list | ⏳ |
| 24.8 | Classic problems — LRU cache, palindrome check, intersection | ⏳ |

---

## Section 25 — Stacks & Queues

| # | Topic | Status |
|---|-------|--------|
| 25.1 | Stack — array and linked list implementation | ⏳ |
| 25.2 | Queue — array and linked list implementation | ⏳ |
| 25.3 | Deque (double-ended queue) | ⏳ |
| 25.4 | Monotonic stack — next greater element | ⏳ |
| 25.5 | Classic problems — balanced parentheses, min stack, daily temperatures | ⏳ |
| 25.6 | Implement stack using queues & vice versa | ⏳ |

---

## Section 26 — Recursion & Backtracking

| # | Topic | Status |
|---|-------|--------|
| 26.1 | Recursion fundamentals — base case, recursive case, call stack | ⏳ |
| 26.2 | Recursion tree visualization | ⏳ |
| 26.3 | Tail recursion | ⏳ |
| 26.4 | Backtracking framework — choose, explore, unchoose | ⏳ |
| 26.5 | Classic recursion — factorial, fibonacci, power | ⏳ |
| 26.6 | Classic backtracking — N-Queens, Sudoku solver, permutations, subsets | ⏳ |
| 26.7 | Memoization — top-down DP intro | ⏳ |

---

## Section 27 — Sorting Algorithms

| # | Topic | Status |
|---|-------|--------|
| 27.1 | Bubble sort — O(n²) | ⏳ |
| 27.2 | Selection sort — O(n²) | ⏳ |
| 27.3 | Insertion sort — O(n²), best for nearly sorted | ⏳ |
| 27.4 | Merge sort — O(n log n), stable, divide & conquer | ⏳ |
| 27.5 | Quick sort — O(n log n) avg, pivot strategies | ⏳ |
| 27.6 | Heap sort — O(n log n), in-place | ⏳ |
| 27.7 | Counting sort, Radix sort, Bucket sort — O(n) linear | ⏳ |
| 27.8 | `Arrays.sort()` internals — Dual-Pivot Quicksort & TimSort | ⏳ |
| 27.9 | Sorting comparison table & when to use each | ⏳ |

---

## Section 28 — Searching Algorithms

| # | Topic | Status |
|---|-------|--------|
| 28.1 | Linear search — O(n) | ⏳ |
| 28.2 | Binary search — O(log n), iterative & recursive | ⏳ |
| 28.3 | Binary search on answer — monotonic functions | ⏳ |
| 28.4 | Ternary search | ⏳ |
| 28.5 | `Arrays.binarySearch()` in Java | ⏳ |
| 28.6 | Classic binary search problems — rotated array, first/last occurrence, peak element | ⏳ |

---

## Section 29 — Trees

| # | Topic | Status |
|---|-------|--------|
| 29.1 | Binary tree — node structure, traversals (inorder, preorder, postorder, level-order) | ⏳ |
| 29.2 | Binary Search Tree (BST) — insert, delete, search | ⏳ |
| 29.3 | BST validation & properties | ⏳ |
| 29.4 | AVL tree — self-balancing, rotations | ⏳ |
| 29.5 | Red-Black tree — concept (used in Java `TreeMap`) | ⏳ |
| 29.6 | Heap (min/max) — array implementation, `PriorityQueue` | ⏳ |
| 29.7 | Trie (prefix tree) — insert, search, startsWith | ⏳ |
| 29.8 | Segment tree — range query, range update | ⏳ |
| 29.9 | Fenwick tree (Binary Indexed Tree) | ⏳ |
| 29.10 | Classic problems — LCA, diameter, height, serialize/deserialize, kth smallest | ⏳ |

---

## Section 30 — Graphs

| # | Topic | Status |
|---|-------|--------|
| 30.1 | Graph representations — adjacency matrix, adjacency list | ⏳ |
| 30.2 | BFS — breadth-first search | ⏳ |
| 30.3 | DFS — depth-first search | ⏳ |
| 30.4 | Cycle detection — directed & undirected graphs | ⏳ |
| 30.5 | Topological sort — Kahn's algorithm, DFS method | ⏳ |
| 30.6 | Shortest path — Dijkstra's algorithm | ⏳ |
| 30.7 | Shortest path — Bellman-Ford (handles negative weights) | ⏳ |
| 30.8 | All-pairs shortest path — Floyd-Warshall | ⏳ |
| 30.9 | Minimum spanning tree — Prim's & Kruskal's algorithms | ⏳ |
| 30.10 | Union-Find (Disjoint Set Union) | ⏳ |
| 30.11 | Classic problems — number of islands, clone graph, word ladder | ⏳ |

---

## Section 31 — Hashing

| # | Topic | Status |
|---|-------|--------|
| 31.1 | Hash functions — properties, uniform distribution | ⏳ |
| 31.2 | Collision resolution — chaining vs open addressing | ⏳ |
| 31.3 | `HashMap` internals deep dive (Java 8+) | ⏳ |
| 31.4 | Rolling hash — Rabin-Karp | ⏳ |
| 31.5 | Classic problems — two sum, group anagrams, longest consecutive sequence | ⏳ |

---

## Section 32 — Dynamic Programming

| # | Topic | Status |
|---|-------|--------|
| 32.1 | What is DP — overlapping subproblems + optimal substructure | ⏳ |
| 32.2 | Top-down DP (memoization) | ⏳ |
| 32.3 | Bottom-up DP (tabulation) | ⏳ |
| 32.4 | 1D DP — fibonacci, climbing stairs, house robber | ⏳ |
| 32.5 | 2D DP — grid paths, edit distance, LCS | ⏳ |
| 32.6 | Knapsack problems — 0/1 knapsack, unbounded knapsack | ⏳ |
| 32.7 | Interval DP — matrix chain multiplication, burst balloons | ⏳ |
| 32.8 | DP on trees | ⏳ |
| 32.9 | DP on strings — palindrome partitioning, wildcard matching | ⏳ |
| 32.10 | Bitmask DP | ⏳ |
| 32.11 | Classic problems — coin change, longest increasing subsequence, word break | ⏳ |

---

## Section 33 — Greedy Algorithms

| # | Topic | Status |
|---|-------|--------|
| 33.1 | Greedy paradigm — when it works, when it doesn't | ⏳ |
| 33.2 | Activity selection problem | ⏳ |
| 33.3 | Huffman encoding | ⏳ |
| 33.4 | Fractional knapsack | ⏳ |
| 33.5 | Job sequencing with deadlines | ⏳ |
| 33.6 | Classic problems — jump game, meeting rooms, gas station | ⏳ |
| 33.7 | Greedy vs DP — how to decide which to use | ⏳ |

---

# PART 6 — System Design

---

## Section 34 — System Design Fundamentals

| # | Topic | Status |
|---|-------|--------|
| 34.1 | Vertical vs horizontal scaling | ⏳ |
| 34.2 | Load balancers — algorithms, L4 vs L7 | ⏳ |
| 34.3 | CDN — content delivery networks | ⏳ |
| 34.4 | Caching — strategies, eviction policies (LRU, LFU), Redis, Memcached | ⏳ |
| 34.5 | CAP theorem — Consistency, Availability, Partition tolerance | ⏳ |
| 34.6 | ACID vs BASE | ⏳ |
| 34.7 | SQL vs NoSQL — when to use which | ⏳ |
| 34.8 | Database sharding & replication | ⏳ |
| 34.9 | Consistent hashing | ⏳ |
| 34.10 | Message queues — Kafka, RabbitMQ, SQS | ⏳ |

---

## Section 35 — APIs & Communication

| # | Topic | Status |
|---|-------|--------|
| 35.1 | REST API design — methods, status codes, versioning | ⏳ |
| 35.2 | GraphQL — overview, vs REST | ⏳ |
| 35.3 | gRPC — protocol buffers, streaming | ⏳ |
| 35.4 | WebSockets — real-time bidirectional communication | ⏳ |
| 35.5 | API Gateway — rate limiting, auth, routing | ⏳ |
| 35.6 | Long polling vs SSE vs WebSockets | ⏳ |

---

## Section 36 — Distributed Systems Concepts

| # | Topic | Status |
|---|-------|--------|
| 36.1 | Microservices vs monolith — tradeoffs | ⏳ |
| 36.2 | Service discovery — Eureka, Consul | ⏳ |
| 36.3 | Circuit breaker pattern — Hystrix, Resilience4j | ⏳ |
| 36.4 | Distributed transactions — SAGA pattern, 2PC | ⏳ |
| 36.5 | Event-driven architecture — event sourcing, CQRS | ⏳ |
| 36.6 | Bloom filter — probabilistic membership test | ⏳ |
| 36.7 | Rate limiting algorithms — token bucket, leaky bucket | ⏳ |
| 36.8 | Distributed ID generation — Snowflake, UUID | ⏳ |

---

## Section 37 — Classic System Design Problems (Alex Xu)

| # | Topic | Status |
|---|-------|--------|
| 37.1 | Design URL Shortener (TinyURL) | ⏳ |
| 37.2 | Design Twitter / News Feed | ⏳ |
| 37.3 | Design WhatsApp / Chat System | ⏳ |
| 37.4 | Design YouTube / Video Streaming | ⏳ |
| 37.5 | Design Uber / Ride Sharing | ⏳ |
| 37.6 | Design Google Drive / File Storage | ⏳ |
| 37.7 | Design Rate Limiter | ⏳ |
| 37.8 | Design Notification System | ⏳ |
| 37.9 | Design Search Autocomplete | ⏳ |
| 37.10 | Design Distributed Cache | ⏳ |

---

# PART 7 — Interview Preparation

---

## Section 38 — Google Interview Prep

| # | Topic | Status |
|---|-------|--------|
| 38.1 | Google interview format — phone screen, onsite, rounds | ⏳ |
| 38.2 | Google-style problems — L-shaped, open-ended, follow-ups | ⏳ |
| 38.3 | Top 20 Google coding problems (LeetCode tagged) | ⏳ |
| 38.4 | Behavioral questions at Google — STAR method, Googleyness | ⏳ |
| 38.5 | Google system design expectations by level (L4/L5/L6) | ⏳ |

---

## Section 39 — Microsoft Interview Prep

| # | Topic | Status |
|---|-------|--------|
| 39.1 | Microsoft interview format — recruiter, tech phone, virtual onsite | ⏳ |
| 39.2 | Microsoft-style problems — emphasis on practical, debugging | ⏳ |
| 39.3 | Top 20 Microsoft coding problems (LeetCode tagged) | ⏳ |
| 39.4 | Behavioral questions at Microsoft — growth mindset, collaboration | ⏳ |
| 39.5 | Microsoft system design expectations (SDE I / SDE II / Senior) | ⏳ |

---

## Section 40 — Mock Interviews & Patterns

| # | Topic | Status |
|---|-------|--------|
| 40.1 | 14 coding patterns to recognize — sliding window, two pointers, fast/slow, merge intervals, cyclic sort, BFS/DFS, two heaps, subsets, modified binary search, bitwise XOR, top-K elements, k-way merge, 0/1 knapsack, topological sort | ⏳ |
| 40.2 | How to approach any LeetCode problem — 5-step framework | ⏳ |
| 40.3 | Communicating during coding interviews — think out loud | ⏳ |
| 40.4 | 10 full mock interview problems with walkthroughs | ⏳ |
| 40.5 | Resume tips for Google / Microsoft | ⏳ |
| 40.6 | Negotiating the offer | ⏳ |

---

## 📊 Progress Tracker

```
PART 1 — Java Fundamentals
  Section 1  Introduction          [ ] [ ] [ ] [ ] [ ] [ ]          0/6
  Section 2  Variables & Types     [✅][✅][✅][✅][✅][✅][✅]     7/7
  Section 3  Operators             [✅][✅][✅][✅][✅][✅][✅][✅]  8/8
  Section 4  Control Flow          [✅][✅][✅][✅][✅][✅][✅][✅]
                                   [✅][✅][✅]                      11/11
  Section 5  Strings               [ ] [ ] [ ] [ ] [ ] [ ] [ ]      0/7
  Section 6  Arrays                [ ] [ ] [ ] [ ] [ ] [ ] [ ]      0/7

PART 2 — OOP                                                         0/36
PART 3 — Core Java Intermediate                                      0/55
PART 4 — Advanced Java                                               0/35
PART 5 — DSA                                                         0/75
PART 6 — System Design                                               0/34
PART 7 — Interview Prep                                              0/20
──────────────────────────────────────────────────────────────────────────
TOTAL COMPLETED:  26 / 300+ topics
```

---

## 📚 Reference Books Mapped to Sections

| Book | Covers |
|------|--------|
| 📗 Java: The Complete Reference — Herbert Schildt | Sections 1–21 (Java Fundamentals → Advanced) |
| 📘 Data Structures & Algorithms in Java — Robert Lafore | Sections 22–33 (DSA) |
| 📙 Grokking Algorithms — Aditya Bhargava | Sections 22, 27, 28, 30, 32, 33 (Visual DSA) |
| 📕 Cracking the Coding Interview — Gayle McDowell | Sections 23–33, 38–40 (DSA + Interview) |
| 📔 System Design Interview Vol. 1 & 2 — Alex Xu | Sections 34–37 (System Design) |

---

## 🎯 Study Plan Recommendations

```
BEGINNER PATH (3–4 months)
  Week  1–2   Section 1–2  (Java basics, variables, types)
  Week  3–4   Section 3–4  (Operators, control flow)
  Week  5–6   Section 5–6  (Strings, arrays)
  Week  7–10  Section 7–12 (OOP — classes, inheritance, polymorphism)
  Week 11–14  Section 13–17 (Exceptions, collections, generics, I/O)

INTERMEDIATE PATH (2–3 months)
  Week  1–4   Section 18–21 (Java 8+, streams, lambdas, concurrency)
  Week  5–8   Section 22–28 (DSA — arrays, lists, stacks, sorting, searching)
  Week  9–12  Section 29–31 (Trees, graphs, hashing)

ADVANCED / INTERVIEW PATH (2–3 months)
  Week  1–4   Section 32–33 (DP, greedy)
  Week  5–8   Section 34–37 (System design)
  Week  9–12  Section 38–40 (Interview prep, mock problems)
```

---

## ⚡ Quick Reference: File Index

| File | Section | Topics |
|------|---------|--------|
| `Primitive_Data_Types.md` | 2.2 | int, float, double, char, boolean, byte, short, long |
| `Non_Primitive_Types.md` | 2.3 | String, Arrays, Objects |
| `Var_keyword.md` | 2.4 | var (Java 10+) |
| `2.5_Constants_Final_Keyword.md` | 2.5 | final, constants |
| `Scope_of_Variables.md` | 2.6 | local, instance, static scope |
| `2.7_Tricky_DataTypes_Overflow.md` | 2.7 | overflow, tricky Q&A |
| `3.1_Arithmetic_Operators.md` | 3.1 | + - * / % |
| `3.2_Relational_Operators.md` | 3.2 | == != > < >= <= |
| `3.3_Logical_Operators.md` | 3.3 | && \|\| ! |
| `3.4_Bitwise_Operators.md` | 3.4 | & \| ^ ~ << >> >>> |
| `3.5_Assignment_Operators.md` | 3.5 | = += -= *= /= %= etc. |
| `3.6_Ternary_Operator.md` | 3.6 | condition ? a : b |
| `3.7_instanceof_Operator.md` | 3.7 | instanceof, pattern matching |
| `3.8_Operator_Precedence.md` | 3.8 | precedence table, tricky expressions |
| `4_ControlFlow.md` | 4.1–4.11 | if/else, switch, for, while, do-while, for-each, break, continue, labels |

---

*Complete Java Developer Course — Beginner → Google/Microsoft Interview Ready*
*Updated as topics are completed. ✅ = done, ⏳ = pending*
