# Java 01.1 — Data Types, Operators, Control Flow, Arrays

> **Series:** Java Revision → Topic 01 of 15  
> **Level:** Beginner → Interview + Production Ready  
> **Goal:** Understand the concept, know when and why to use it, and be able to apply it at work

---

## Table of Contents

1. [Data Types](#1-data-types)
2. [Operators](#2-operators)
3. [Control Flow](#3-control-flow)
4. [Arrays](#4-arrays)
5. [Real Company Use Cases](#5-real-company-use-cases)
6. [Interview Quick-Fire](#6-interview-quick-fire)
7. [Key Rules to Remember](#7-key-rules-to-remember)

---

## 1. Data Types

### 📌 What is a Data Type?

A **data type** tells Java:
- What **kind of value** a variable holds (number? text? true/false?)
- How much **memory** to allocate
- What **operations** are valid on it

Java is **statically typed** — you must declare the type at compile time. This means mistakes like adding a number to a boolean are caught **before the program runs**, not during — which is a huge advantage in large codebases.

> **Why does this matter at work?**  
> In a Spring Boot microservice, if your API receives a request with a field that should be `int` but gets a `String`, Java catches it immediately. Dynamically typed languages like Python would only catch this at runtime (potentially in production).

---

### 🧠 Two Categories: Primitive vs Reference

Before diving into specific types, understand the most important split in Java:

| | Primitive | Reference |
|---|---|---|
| Stores | The **actual value** | A **memory address** (pointer to the object) |
| Lives in | **Stack** (fast) | **Heap** (garbage collected) |
| Examples | `int`, `double`, `boolean`, `char` | `String`, arrays, any class |
| Default (class field) | `0`, `0.0`, `false`, `'\u0000'` | `null` |
| Copied by | Value | Reference (address) |

> **Why does this matter at work?**  
> This distinction is the root cause of some of the most common bugs — modifying a "copy" of a list only to find the original changed too. Understanding stack vs heap saves hours of debugging.

---

### Primitive Types — The 8 Building Blocks

#### Integer Types

```java
byte  b = 127;             // Range: -128 to 127 | 1 byte
                           // Use: binary data, file I/O, network streams

short s = 32_000;          // Range: -32,768 to 32,767 | 2 bytes
                           // Use: rarely used in modern Java

int   i = 2_000_000;       // Range: ±2.1 billion | 4 bytes
                           // Use: default choice for whole numbers (loop counters, IDs, counts)
                           // Note: underscores in numbers are legal and aid readability

long  l = 9_999_999_999L;  // Range: ±9.2 × 10^18 | 8 bytes | needs L suffix
                           // Use: timestamps (System.currentTimeMillis()), large financial values,
                           //      database auto-increment IDs, population counts
```

> **At work:** You use `int` for 90% of integer needs. Switch to `long` when dealing with epoch timestamps (`1714000000000L` in milliseconds), large transaction IDs, or anything that might exceed ~2 billion.

#### Decimal Types

```java
float  f = 3.14f;     // ~7 decimal digits precision | 4 bytes | needs f suffix
                      // Use: graphics/game coordinates, low-memory embedded systems
                      // Avoid for money! precision loss causes rounding errors

double d = 3.14159265358979;  // ~15 decimal digits precision | 8 bytes
                              // Use: scientific calculations, measurements
                              // Still avoid for money! Use BigDecimal instead
```

> **Real bug at work — never use float/double for money:**

```java
// This looks fine but produces wrong results
double price = 0.1 + 0.2;
System.out.println(price);          // Output: 0.30000000000000004 ← WRONG!
System.out.println(price == 0.3);   // Output: false ← billing bug!

// Fix: Use BigDecimal for financial calculations
import java.math.BigDecimal;
BigDecimal correct = new BigDecimal("0.1").add(new BigDecimal("0.2"));
System.out.println(correct);        // Output: 0.3 ← correct
// Rule: always pass BigDecimal values as Strings, not doubles
```

#### Character Type

```java
char c = 'A';                    // Single quotes | 2 bytes | stores Unicode (0 to 65535)

System.out.println((int) c);     // Output: 65  ← every char is secretly a number
System.out.println((char) 66);   // Output: B   ← cast int to char

// Char arithmetic — used in interview problems
char ch = 'a';
System.out.println(ch + 1);      // Output: 98 (int!) ← tricky: arithmetic promotes to int
System.out.println((char)(ch + 1)); // Output: b ← cast back to char

// Check if char is a digit or letter (useful in string parsing)
char x = '5';
System.out.println(Character.isDigit(x));   // Output: true
System.out.println(Character.isLetter(x));  // Output: false
System.out.println(Character.toUpperCase('a')); // Output: A
```

#### Boolean Type

```java
boolean isActive = true;
boolean isDeleted = false;

// Used everywhere: flags, conditions, feature toggles
boolean isEligible = (age >= 18 && !isDeleted && isActive);

// In Spring Boot — you'll see boolean in entity flags constantly
// @Column private boolean isActive = true;
```

---

### 🔴 Tricky: Default Values vs Local Variables

```java
public class DefaultValues {

    // ✅ Class-level (instance) fields — Java assigns defaults automatically
    int     classInt;      // default: 0
    double  classDouble;   // default: 0.0
    boolean classBool;     // default: false
    String  classStr;      // default: null
    int[]   classArr;      // default: null

    public void method() {
        // ❌ Local variables — NO defaults — you MUST initialize before reading
        int localInt;
        // System.out.println(localInt); // COMPILE ERROR: variable might not have been initialized

        int initialized = 10;
        System.out.println(initialized); // Output: 10 ✅
    }
}
```

> **Why this design?**  
> Local variables are on the stack. They're created and destroyed fast. Java forces you to initialize them to prevent using garbage memory values — which is a common source of bugs in C/C++. Class fields are on the heap and zeroed out by the JVM for safety.

---

### 🔴 Tricky: Integer Overflow — Silent and Dangerous

```java
int max = Integer.MAX_VALUE;   // 2,147,483,647
System.out.println(max + 1);   // Output: -2147483648 ← NO exception, silently wraps!

// Why? Because int is 32 bits. When you go past the max,
// the bits flip to the most negative number (two's complement)

// This has caused real-world disasters:
// - The 1996 Ariane 5 rocket explosion was caused by numeric overflow
// - Boeing 787 power system bugs were caused by overflow in 32-bit counters

// Fix: use long when overflow is possible
long safe = (long) max + 1;
System.out.println(safe);      // Output: 2147483648 ✅

// Check before adding (defensive programming)
if (Integer.MAX_VALUE - a >= b) {
    int result = a + b; // safe
}

// Or use Math.addExact() — throws ArithmeticException on overflow
int result = Math.addExact(Integer.MAX_VALUE, 1); // throws ArithmeticException ✅
```

---

### 🔴 Tricky: `==` vs `.equals()` for Strings — The #1 Java Gotcha

```java
// == compares MEMORY ADDRESSES (reference equality)
// .equals() compares CONTENT (value equality)

String a = "hello";         // goes into String Pool (shared memory)
String b = "hello";         // reuses same String Pool object
String c = new String("hello"); // creates a brand NEW object on heap

System.out.println(a == b);         // Output: true  ← same object in pool
System.out.println(a == c);         // Output: false ← different objects
System.out.println(a.equals(c));    // Output: true  ← same content ✅
System.out.println(a.equals(null)); // Output: false (safe — no NPE)

// Production-safe pattern — put the known value first to avoid NullPointerException
String status = getStatusFromDB(); // could be null
if ("ACTIVE".equals(status)) {     // safe even if status is null
    // proceed
}
// NEVER: if (status.equals("ACTIVE")) ← NullPointerException if status is null!
```

> **Where this bites you at work:**  
> Comparing user roles, status strings, or config values fetched from a database using `==` instead of `.equals()` can cause authorization bugs where users have the right role but the check fails intermittently.

---

### Type Casting

```java
// WIDENING (implicit) — smaller type → larger type, always safe
int i = 100;
long l = i;           // int → long, automatic
double d = i;         // int → double, automatic

// NARROWING (explicit) — larger type → smaller type, possible data loss
double pi = 3.99;
int truncated = (int) pi;
System.out.println(truncated); // Output: 3 ← TRUNCATED, not rounded!

// Tricky: byte overflow from cast
byte b = (byte) 130;
System.out.println(b); // Output: -126 ← 130 doesn't fit in byte, wraps!

// Tricky: String to int
String numStr = "42";
int num = Integer.parseInt(numStr);  // String → int
// Integer.parseInt("abc") → throws NumberFormatException — always wrap in try-catch!

// int to String
String s = String.valueOf(num);      // int → String ← preferred
String s2 = num + "";               // works but wasteful (creates extra objects)
String s3 = Integer.toString(num);  // also valid
```

---

## 2. Operators

### 📌 What are Operators?

Operators are **symbols that perform operations** on values (called operands). Java inherits most operators from C, but adds some Java-specific behaviors that trip people up.

---

### Arithmetic Operators

```java
int a = 10, b = 3;

System.out.println(a + b);   // 13 — addition
System.out.println(a - b);   // 7  — subtraction
System.out.println(a * b);   // 30 — multiplication
System.out.println(a / b);   // 3  ← INTEGER DIVISION — decimal truncated!
System.out.println(a % b);   // 1  — remainder (modulo)

// Fix integer division — cast at least one operand to double
System.out.println((double) a / b); // 3.3333333333333335
System.out.println(a / (double) b); // same result

// % (modulo) use cases at work:
// - Check even/odd: n % 2 == 0
// - Circular array indexing: index = (index + 1) % arr.length
// - Time: minutes = totalSeconds % 60
```

---

### 🔴 Tricky: Pre vs Post Increment — Interview Classic

```java
// POST-increment (x++): USE the current value, THEN increment
int x = 5;
int y = x++;                 // y = 5 (gets old value), THEN x becomes 6
System.out.println("y=" + y); // Output: y=5
System.out.println("x=" + x); // Output: x=6

// PRE-increment (++x): INCREMENT first, THEN use the value
int a = 5;
int b = ++a;                 // a becomes 6, THEN b = 6 (gets new value)
System.out.println("b=" + b); // Output: b=6
System.out.println("a=" + a); // Output: a=6

// Classic tricky question:
int i = 5;
System.out.println(i++ + ++i); // ?
// Step 1: i++ → uses 5, then i becomes 6
// Step 2: ++i → i becomes 7, uses 7
// Result: 5 + 7 = 12
System.out.println(i); // Output: 7
```

---

### Compound Assignment Operators

```java
int x = 10;
x += 5;   // x = x + 5  → 15
x -= 3;   // x = x - 3  → 12
x *= 2;   // x = x * 2  → 24
x /= 4;   // x = x / 4  → 6
x %= 4;   // x = x % 4  → 2

// Tricky: compound assignment has implicit cast
byte b = 10;
// b = b + 1;   // ❌ COMPILE ERROR: b+1 promotes to int, can't assign to byte
b += 1;         // ✅ compound assignment auto-casts back to byte
```

---

### Logical Operators & Short-Circuit Evaluation

```java
// AND (&&): both sides must be true
// OR  (||): at least one must be true
// NOT (!):  flips the boolean

int a = 5, b = 0;

// Short-circuit AND (&&): if LEFT is false, RIGHT is NEVER evaluated
if (b != 0 && (a / b > 2)) {     // b != 0 is false → stops here, NO division by zero
    System.out.println("condition met");
}
// Output: (nothing printed, but no exception either!) ✅

// Short-circuit OR (||): if LEFT is true, RIGHT is NEVER evaluated
if (b == 0 || (a / b > 2)) {     // b == 0 is true → stops, no division by zero
    System.out.println("safe");   // Output: safe
}

// Real-world usage — null check before method call:
String name = getUserName(); // could return null
if (name != null && name.length() > 0) { // safe — no NullPointerException
    process(name);
}

// With Optional (modern Java, preferred at work):
Optional.ofNullable(name)
        .filter(n -> !n.isEmpty())
        .ifPresent(n -> process(n));
```

> **Why short-circuit matters at work:**  
> In Spring Security, authorization checks are chained with `&&`. The first failing check stops the chain, preventing expensive operations. In database queries, null-checking before accessing nested objects avoids NPEs.

---

### Bitwise Operators

```java
// These operate on individual BITS of integers
// Crucial in: permissions, flags, cryptography, performance-sensitive code

int a = 5;   // binary: 00000101
int b = 3;   // binary: 00000011

System.out.println(a & b);   // 1   AND:  00000101 & 00000011 = 00000001
System.out.println(a | b);   // 7   OR:   00000101 | 00000011 = 00000111
System.out.println(a ^ b);   // 6   XOR:  00000101 ^ 00000011 = 00000110
System.out.println(~a);      // -6  NOT:  flips all bits (including sign bit)
System.out.println(a << 1);  // 10  Left shift  = multiply by 2 (fast!)
System.out.println(a >> 1);  // 2   Right shift = divide by 2   (fast!)
System.out.println(-8 >>> 1);// Unsigned right shift — no sign extension

// Real use case: Unix-style permission flags
int READ    = 4;  // 100
int WRITE   = 2;  // 010
int EXECUTE = 1;  // 001

int userPerms = READ | WRITE; // 110 = 6 (has read + write)

// Check if user has a specific permission:
boolean canRead    = (userPerms & READ)    != 0; // true
boolean canExecute = (userPerms & EXECUTE) != 0; // false

// Interview trick: check even/odd faster than %
System.out.println((7 & 1) == 1 ? "odd" : "even");  // Output: odd
System.out.println((8 & 1) == 1 ? "odd" : "even");  // Output: even

// XOR trick: swap without temp variable
int x = 5, y = 10;
x = x ^ y;  // x = 15 (XOR)
y = x ^ y;  // y = 5
x = x ^ y;  // x = 10
System.out.println(x + " " + y); // Output: 10 5

// Interview classic: find the one non-duplicate in array using XOR
int[] nums = {2, 3, 4, 3, 2};
int unique = 0;
for (int n : nums) unique ^= n; // all duplicates cancel out (a^a=0)
System.out.println(unique); // Output: 4
```

---

### Ternary Operator

```java
// Syntax: condition ? valueIfTrue : valueIfFalse
// Use: simple one-liner assignments, avoid for complex logic

int age = 20;
String label = (age >= 18) ? "adult" : "minor";
System.out.println(label); // Output: adult

// At work — API response building:
String status = isActive ? "ACTIVE" : "INACTIVE";
int    discount = isPremium ? 20 : 0;

// Nested ternary — readable limit: max 2 levels
int score = 75;
String grade = score >= 90 ? "A"
             : score >= 80 ? "B"
             : score >= 70 ? "C"
             : "F";
System.out.println(grade); // Output: C

// Avoid nested ternary beyond 2 levels — use if-else or switch instead
```

---

## 3. Control Flow

### 📌 What is Control Flow?

Control flow determines **the order in which statements execute**. Without it, a program would just run top-to-bottom, every time, the same way. Control flow lets you make decisions, repeat actions, and skip steps.

---

### if / else if / else

```java
// Use when: you need to make a decision based on a condition
// Real use case: validating an API request, checking user roles

int statusCode = 404;

if (statusCode == 200) {
    System.out.println("Success");
} else if (statusCode == 404) {
    System.out.println("Not Found");     // Output: Not Found
} else if (statusCode == 500) {
    System.out.println("Server Error");
} else {
    System.out.println("Unknown status: " + statusCode);
}

// At work — Spring Boot service method:
public String processPayment(Payment payment) {
    if (payment == null) {
        throw new IllegalArgumentException("Payment cannot be null");
    }
    if (!payment.isValid()) {
        return "INVALID";
    }
    if (payment.getAmount() > userCreditLimit) {
        return "DECLINED";
    }
    return processApproval(payment);
}
```

---

### switch Statement

```java
// Use when: one variable, many possible discrete values
// switch is faster than if-else chain when there are many cases (uses jump table internally)

String day = "MONDAY";

switch (day) {
    case "MONDAY":
    case "TUESDAY":
    case "WEDNESDAY":
    case "THURSDAY":
    case "FRIDAY":
        System.out.println("Weekday");   // Output: Weekday
        break;                           // ← ALWAYS add break unless fall-through is intentional
    case "SATURDAY":
    case "SUNDAY":
        System.out.println("Weekend");
        break;
    default:
        System.out.println("Invalid day");
}
```

### 🔴 Tricky: Fall-Through — Most Missed Concept in switch

```java
// Fall-through: when you forget break, execution CONTINUES into the next case
int x = 1;
switch (x) {
    case 1:
        System.out.println("one");    // prints ✅
        // NO break here — falls through!
    case 2:
        System.out.println("two");    // ALSO prints! ← unexpected
    case 3:
        System.out.println("three");  // ALSO prints!
        break;
    case 4:
        System.out.println("four");   // does NOT print (break above stopped it)
}
// Output:
// one
// two
// three

// INTENTIONAL fall-through use case (grouping cases):
switch (month) {
    case 12: case 1: case 2:
        System.out.println("Winter"); break;
    case 3: case 4: case 5:
        System.out.println("Spring"); break;
}
```

### Modern Switch Expression (Java 14+ — preferred at work)

```java
// Arrow syntax: no fall-through, no break needed, returns a value
String day = "MONDAY";

String type = switch (day) {
    case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
    case "SATURDAY", "SUNDAY" -> "Weekend";
    default -> throw new IllegalArgumentException("Invalid: " + day);
};
System.out.println(type); // Output: Weekday

// With yield (for multi-line case blocks):
int numLetters = switch (day) {
    case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
    case "TUESDAY" -> 7;
    case "THURSDAY", "SATURDAY" -> 8;
    default -> {
        System.out.println("Processing: " + day);
        yield day.length(); // yield returns value from block
    }
};
```

> **At work:** Java 17 Spring Boot projects use switch expressions heavily in service mappers and response builders. The compiler enforces exhaustiveness, reducing bugs.

---

### Loops

#### `for` loop — when you know the iteration count

```java
// Syntax: for (init; condition; update)
// Use: iterating arrays, processing a fixed range, retry N times

for (int i = 0; i < 5; i++) {
    System.out.print(i + " "); // Output: 0 1 2 3 4
}

// Reverse iteration:
for (int i = 4; i >= 0; i--) {
    System.out.print(i + " "); // Output: 4 3 2 1 0
}

// Step by 2:
for (int i = 0; i <= 10; i += 2) {
    System.out.print(i + " "); // Output: 0 2 4 6 8 10
}
```

#### `while` loop — when condition-driven

```java
// Use: polling, reading streams, retrying until success, unknown iteration count

// Read until EOF (common in file processing):
BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
String line;
while ((line = reader.readLine()) != null) {
    process(line);
}

// Retry logic with exponential backoff (common at work with external APIs):
int attempts = 0;
boolean success = false;
while (!success && attempts < 3) {
    try {
        callExternalAPI();
        success = true;
    } catch (Exception e) {
        attempts++;
        Thread.sleep(1000L * attempts); // wait 1s, 2s, 3s
    }
}
```

#### `do-while` loop — always runs at least once

```java
// Use: prompting for input, menu-driven programs, at least one validation pass

// Read user input at least once:
Scanner scanner = new Scanner(System.in);
int input;
do {
    System.out.print("Enter a number between 1-10: ");
    input = scanner.nextInt();
} while (input < 1 || input > 10); // re-prompt if invalid

// Simple example:
int j = 100;
do {
    System.out.println("This runs once: " + j);  // Output: This runs once: 100
} while (j < 5); // condition is false, but body already executed
```

#### Enhanced for (for-each) — clean, no index needed

```java
// Use: iterating collections and arrays when you don't need the index

int[] arr = {10, 20, 30, 40, 50};
for (int val : arr) {
    System.out.print(val + " "); // Output: 10 20 30 40 50
}

List<String> names = List.of("Alice", "Bob", "Charlie");
for (String name : names) {
    System.out.println("Processing: " + name);
}

// Limitation: you CANNOT modify the array/list during iteration
// and you don't have the index available
// For those needs, use the classic for loop
```

---

### break, continue, and Labeled break

```java
// break — exit the loop immediately
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.print(i + " "); // Output: 0 1 2 3 4
}

// continue — skip current iteration, jump to next
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;  // skip even numbers
    System.out.print(i + " ");  // Output: 1 3 5 7 9
}

// Labeled break — break out of OUTER loop from inside inner loop
// Use: searching in 2D matrix, graph traversal early exit
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
            break outer; // exits BOTH loops immediately
        }
        System.out.println(i + "," + j);
    }
}
// Output:
// 0,0
// 0,1
// 0,2
// 1,0
// (stops — does NOT print 1,1 or anything after)

// Real use case: search in a 2D grid
boolean found = false;
int foundRow = -1, foundCol = -1;

search:
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == target) {
            foundRow = row;
            foundCol = col;
            break search; // stop searching as soon as found
        }
    }
}
```

---

## 4. Arrays

### 📌 What is an Array?

An array is a **fixed-size, ordered collection of elements of the same type**, stored in **contiguous memory locations**. "Contiguous" means each element sits next to the previous one in memory — this is what makes array access by index so fast (O(1)).

> **When to use arrays at work:**
> - Processing a fixed number of items (days of week, months, HTTP status codes)
> - Performance-critical number crunching (algorithms, DSP)
> - Working with binary data (byte arrays for file I/O, network packets)
> - Backing structure for other data structures (ArrayList, HashMap use arrays internally)

> **When NOT to use arrays:**
> - When size changes at runtime → use `ArrayList`
> - When you need key-value access → use `HashMap`
> - When you need uniqueness → use `HashSet`

---

### Declaring and Creating Arrays

```java
// Style 1: declare size, fill later (all elements default to 0/null/false)
int[] scores = new int[5];     // [0, 0, 0, 0, 0]
scores[0] = 95;
scores[1] = 87;
// Index runs 0 to (length-1)

// Style 2: declare and initialize together
int[] nums = {10, 20, 30, 40, 50};        // ← preferred for known values

// Style 3: new keyword with values (useful when creating on the fly)
String[] roles = new String[]{"ADMIN", "USER", "VIEWER"};

// Accessing elements
System.out.println(nums[0]);               // Output: 10  ← first element
System.out.println(nums[nums.length - 1]); // Output: 50  ← last element (not nums[5]!)

// ArrayIndexOutOfBoundsException — most common runtime error with arrays
// nums[5] → throws exception because valid indices are 0, 1, 2, 3, 4

// Check length before access:
int index = 5;
if (index < nums.length) {
    System.out.println(nums[index]);
}
```

---

### 🔴 Deep Dive: Why Arrays are Reference Types — And Why It Matters

This is one of the most important concepts to understand. Let's go step by step.

**Step 1: What happens in memory when you create an array?**

```
int[] a = {1, 2, 3};
```

When this line runs, two things happen:
1. Java allocates space on the **Heap** for 3 integers: `[1][2][3]`
2. Java stores the **memory address** of that space in variable `a` on the **Stack**

So `a` doesn't "contain" `{1, 2, 3}` — it contains something like `0x4A3F` (an address pointing to where the data lives).

**Step 2: What happens when you assign one array to another?**

```java
int[] a = {1, 2, 3};
int[] b = a;          // b gets the same ADDRESS as a — NOT a copy of the data!
```

Now BOTH `a` and `b` point to the **same `[1][2][3]` in memory**.

```java
b[0] = 99;            // you changed the data at that address
System.out.println(a[0]); // Output: 99 ← a "sees" the change too!
```

This is called an **aliasing bug** — two variables pointing to the same data. Changing through one affects the other. This is a very common source of bugs in real applications.

**Step 3: How to actually copy an array**

```java
int[] a = {1, 2, 3};

// Method 1: Arrays.copyOf() — copy all or first N elements
int[] copy1 = Arrays.copyOf(a, a.length);

// Method 2: Arrays.copyOfRange() — copy a slice
int[] slice = Arrays.copyOfRange(a, 1, 3); // index 1 to 2 → {2, 3}

// Method 3: System.arraycopy() — fastest, used internally by Java
int[] copy3 = new int[a.length];
System.arraycopy(a, 0, copy3, 0, a.length); // (src, srcPos, dest, destPos, length)

// Method 4: .clone()
int[] copy4 = a.clone();

// Verify they are independent:
copy1[0] = 99;
System.out.println(a[0]);     // Output: 1 ← original unchanged ✅
System.out.println(copy1[0]); // Output: 99
```

**Step 4: Shallow Copy vs Deep Copy (important for 2D arrays)**

```java
// A "shallow copy" copies the outer array but NOT the inner arrays
// The inner arrays are still shared (same reference problem, one level deeper)

int[][] original = {{1, 2}, {3, 4}};
int[][] shallowCopy = Arrays.copyOf(original, original.length);

shallowCopy[0][0] = 99;             // modifies inner array!
System.out.println(original[0][0]); // Output: 99 ← original changed! Bug!

// Deep copy — you must copy each inner array manually
int[][] deepCopy = new int[original.length][];
for (int i = 0; i < original.length; i++) {
    deepCopy[i] = Arrays.copyOf(original[i], original[i].length);
}
deepCopy[0][0] = 42;
System.out.println(original[0][0]); // Output: 99 ← untouched ✅
```

> **Where this bites you at work:**  
> - Returning an internal array from a service — callers can modify your internal state  
> - Passing arrays to threads — concurrent modification without synchronization  
> - Caching arrays — cache gets mutated by consumers  
> - **Fix:** return a copy or use `Collections.unmodifiableList()` for lists

---

### Iterating Arrays

```java
int[] arr = {10, 20, 30, 40, 50};

// 1. Classic for — when you need the index
for (int i = 0; i < arr.length; i++) {
    System.out.printf("arr[%d] = %d%n", i, arr[i]);
}
// Output:
// arr[0] = 10
// arr[1] = 20 ... etc

// 2. Enhanced for — cleaner when you only need the value
for (int val : arr) {
    System.out.print(val + " "); // Output: 10 20 30 40 50
}

// 3. Arrays.stream() — functional style, used heavily in modern Java
int sum = Arrays.stream(arr).sum();
int max = Arrays.stream(arr).max().getAsInt();
int[] doubled = Arrays.stream(arr).map(x -> x * 2).toArray();

System.out.println(sum);                   // Output: 150
System.out.println(max);                   // Output: 50
System.out.println(Arrays.toString(doubled)); // Output: [20, 40, 60, 80, 100]
```

---

### Useful Arrays Utility Methods

```java
int[] arr = {5, 2, 8, 1, 9, 3};

// Printing — never use arr.toString()! It prints garbage like [I@1b6d3586
System.out.println(Arrays.toString(arr)); // Output: [5, 2, 8, 1, 9, 3]

// Sorting — in-place, uses dual-pivot quicksort (O(n log n))
Arrays.sort(arr);
System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 5, 8, 9]

// Binary search — ONLY works on sorted arrays, returns index or negative if not found
int idx = Arrays.binarySearch(arr, 8);
System.out.println(idx); // Output: 4 (index of 8 in sorted array)

// Fill — set all elements to a value
Arrays.fill(arr, 0);
System.out.println(Arrays.toString(arr)); // Output: [0, 0, 0, 0, 0, 0]

// Equals — compare two arrays by content
int[] x = {1, 2, 3};
int[] y = {1, 2, 3};
System.out.println(x == y);             // Output: false (different references)
System.out.println(Arrays.equals(x, y)); // Output: true  (same content) ✅
```

---

### 2D Arrays

```java
// Think of it as a table: rows × columns
// Each element accessed as matrix[row][col]

int[][] matrix = {
    {1, 2, 3},  // row 0
    {4, 5, 6},  // row 1
    {7, 8, 9}   // row 2
};

System.out.println(matrix[1][2]); // Output: 6 (row 1, col 2)

// Traversal:
for (int i = 0; i < matrix.length; i++) {          // matrix.length = number of rows
    for (int j = 0; j < matrix[i].length; j++) {   // matrix[i].length = cols in row i
        System.out.printf("%3d", matrix[i][j]);
    }
    System.out.println();
}
// Output:
//   1  2  3
//   4  5  6
//   7  8  9

// Jagged arrays — rows can have different lengths
int[][] jagged = new int[3][];
jagged[0] = new int[]{1};
jagged[1] = new int[]{2, 3};
jagged[2] = new int[]{4, 5, 6};
// This is valid Java — useful for triangular grids in DP problems

// Print 2D array (deep to string):
System.out.println(Arrays.deepToString(matrix));
// Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
```

---

### Arrays vs ArrayList — When to Use Which

```java
// Array — fixed size, fast, can hold primitives
int[] arr = new int[3];   // size is fixed forever
arr[0] = 1;
// arr[3] = 4; ← ArrayIndexOutOfBoundsException

// ArrayList — dynamic size, slightly slower, no primitives
List<Integer> list = new ArrayList<>();
list.add(1);              // grows automatically
list.add(2);
list.add(3);
list.add(4);              // no problem
list.remove(0);           // removes first element — shifts everything left O(n)
System.out.println(list); // Output: [2, 3, 4]

// Convert array → List
int[] arr2 = {1, 2, 3};
List<Integer> fromArray = Arrays.stream(arr2).boxed().collect(Collectors.toList());

// Convert List → array
Integer[] backToArray = list.toArray(new Integer[0]);
```

| Feature | `int[]` Array | `ArrayList<Integer>` |
|---|---|---|
| Size | Fixed | Dynamic |
| Primitives | ✅ `int`, `long`, etc. | ❌ Must use `Integer` (autoboxing) |
| Performance | Faster (no boxing) | Slightly slower |
| Access | `arr[i]` O(1) | `list.get(i)` O(1) |
| Add at end | Not possible | `list.add()` amortized O(1) |
| Insert/Delete middle | Manual shift | `list.add(i, val)` but O(n) |
| Sorting | `Arrays.sort()` | `Collections.sort()` |
| Utilities | `Arrays.*` methods | `Collections.*` methods |

> **At work rule:** Use `List<T>` (ArrayList) in service/API code for flexibility. Use `int[]` in algorithms and performance-critical inner loops.

---

## 5. Real Company Use Cases

### Use case 1: Parsing CSV from Kafka message

```java
// You receive a CSV line from a Kafka topic and need to extract fields
// Arrays are perfect here — split() returns a String[]

public void processMessage(String csvLine) {
    // "1001,Sanjeev,ACTIVE,50000.00"
    String[] parts = csvLine.split(",");

    if (parts.length < 4) {
        throw new IllegalArgumentException("Invalid CSV: " + csvLine);
    }

    long   userId  = Long.parseLong(parts[0]);      // "1001" → 1001L
    String name    = parts[1];                       // "Sanjeev"
    String status  = parts[2];                       // "ACTIVE"
    double salary  = Double.parseDouble(parts[3]);   // "50000.00" → 50000.0

    if ("ACTIVE".equals(status)) {                   // .equals(), never ==
        userService.save(userId, name, salary);
    }
}
```

### Use case 2: Bitwise flags for permissions (Spring Security style)

```java
// Instead of 5 boolean fields, use 1 int with bit flags
// This is how Unix permissions work, and how many DB-stored permissions work

public class Permission {
    public static final int READ    = 1 << 0; // 0001 = 1
    public static final int WRITE   = 1 << 1; // 0010 = 2
    public static final int DELETE  = 1 << 2; // 0100 = 4
    public static final int ADMIN   = 1 << 3; // 1000 = 8

    private int permissions;

    public void grant(int perm)   { permissions |= perm; }      // set bit
    public void revoke(int perm)  { permissions &= ~perm; }     // clear bit
    public boolean has(int perm)  { return (permissions & perm) != 0; }

    public static void main(String[] args) {
        Permission p = new Permission();
        p.grant(READ | WRITE);      // grant read + write

        System.out.println(p.has(READ));   // Output: true
        System.out.println(p.has(DELETE)); // Output: false

        p.revoke(WRITE);
        System.out.println(p.has(WRITE));  // Output: false
    }
}
```

### Use case 3: Defensive copy in a service (preventing bugs)

```java
// WRONG — returning internal array — caller can modify your state!
public class UserService {
    private int[] activeUserIds = {101, 102, 103};

    public int[] getActiveUsers() {
        return activeUserIds; // ← dangerous reference leak!
    }
}

// After: UserService service = new UserService();
// int[] ids = service.getActiveUsers();
// ids[0] = 999; ← now your internal array is corrupted!

// CORRECT — return a defensive copy
public class UserService {
    private int[] activeUserIds = {101, 102, 103};

    public int[] getActiveUsers() {
        return Arrays.copyOf(activeUserIds, activeUserIds.length); // ✅
    }
}
```

### Use case 4: Sliding window on an array (DSA at work for rate limiting)

```java
// Rate limiter: count requests in a sliding window of last N seconds
// Used in API Gateway, Kafka consumer throttling

public boolean isRateLimited(int[] requestTimestamps, int windowSizeSeconds, int maxRequests) {
    long now = System.currentTimeMillis() / 1000;
    int count = 0;

    for (int timestamp : requestTimestamps) {
        if (now - timestamp <= windowSizeSeconds) {
            count++;
        }
    }
    return count >= maxRequests;
}
```

---

## 6. Interview Quick-Fire

```java
// Q1: Swap two numbers without a temp variable
int a = 5, b = 10;
a = a + b;  // a = 15
b = a - b;  // b = 5  (15 - 10)
a = a - b;  // a = 10 (15 - 5)
System.out.println(a + " " + b); // Output: 10 5

// Q2: Find max in array without Math.max
int[] arr = {3, 7, 2, 9, 1};
int max = arr[0];
for (int val : arr) {
    if (val > max) max = val;
}
System.out.println(max); // Output: 9

// Q3: Reverse an array in-place (two-pointer)
int[] rev = {1, 2, 3, 4, 5};
int left = 0, right = rev.length - 1;
while (left < right) {
    int temp  = rev[left];
    rev[left] = rev[right];
    rev[right] = temp;
    left++;
    right--;
}
System.out.println(Arrays.toString(rev)); // Output: [5, 4, 3, 2, 1]

// Q4: Check if number is prime (efficient — only check up to √n)
int n = 17;
boolean isPrime = n > 1;
for (int i = 2; i <= Math.sqrt(n); i++) {
    if (n % i == 0) { isPrime = false; break; }
}
System.out.println(isPrime); // Output: true

// Q5: What is the output? (String + operator trap)
System.out.println(1 + 2 + "3");  // Output: 33   (int+int=3, then "3"+"3"="33")
System.out.println("1" + 2 + 3);  // Output: 123  ("1"+2="12", "12"+3="123")
System.out.println("1" + (2 + 3));// Output: 15   (parentheses force int addition first)

// Q6: Second largest element in array
int[] arr2 = {3, 7, 2, 9, 1, 9};
int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
for (int val : arr2) {
    if (val > first) {
        second = first;
        first  = val;
    } else if (val > second && val != first) {
        second = val;
    }
}
System.out.println(second); // Output: 7

// Q7: Check if array has duplicate (using XOR won't work here — use Set)
public boolean hasDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int n : nums) {
        if (!seen.add(n)) return true; // Set.add() returns false if already present
    }
    return false;
}

// Q8: What is the output? (integer overflow trap)
System.out.println(Integer.MAX_VALUE + 1); // Output: -2147483648 (not an exception!)
```

---

## 7. Key Rules to Remember

| Rule | Why It Matters |
|---|---|
| Use `.equals()` for String comparison, never `==` | `==` compares references, causes auth/logic bugs |
| Use `BigDecimal` for money, never `float/double` | Floating-point imprecision causes billing errors |
| Integer overflow is **silent** — no exception | Use `long` or `Math.addExact()` for safety |
| Integer division **truncates** — `7/2 = 3` | Cast to `double` before dividing if decimal needed |
| Local variables have **no default** — always initialize | Compiler prevents use but good habit |
| Arrays are **reference types** — assignment shares data | Always use `Arrays.copyOf()` for independent copies |
| `switch` has **fall-through** — always add `break` | Or use switch expressions (Java 14+) to avoid it |
| Short-circuit `&&` and `||` — right side may not run | Use for null-guard before method calls |
| `Arrays.toString()` to print, never raw `.toString()` | Raw prints garbage like `[I@6d06d69c` |
| `for-each` cannot modify collection during iteration | Use iterator or indexed loop instead |

---

## References

- [Oracle Java Docs — Primitive Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Oracle Java Docs — Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Effective Java — Item 28: Prefer lists to arrays](https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997)
- [JLS §15.7 — Evaluation Order](https://docs.oracle.com/javase/specs/jls/se17/html/jls-15.html#jls-15.7)

---

*Next: [Java 01.2 — OOP: Classes, Objects, Inheritance, Polymorphism, Abstraction, Encapsulation](./java-01-2-oop.md)*
