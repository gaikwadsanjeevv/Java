# Java Introduction (Complete)  
```
1.1 What is Java? History & Features
What is Java?
Java is a high-level, object-oriented, platform-independent programming language developed by James Gosling at Sun Microsystems in 1995. Later acquired by Oracle in 2010.
Originally designed for interactive television and embedded systems. Ended up becoming one of the most widely used languages in the world — used in Android apps, enterprise backends, banking systems, and more.

Official motto: "Write Once, Run Anywhere" (WORA)

// Key Features of Java
1. Platform Independent
Java code → compiles to Bytecode → runs on any OS with JVM
Windows, Mac, Linux — same .class file runs everywhere

2. Object Oriented
Everything in Java is a class or object
Follows OOP principles: Encapsulation, Inheritance, Polymorphism, Abstraction

3. Strongly Typed
int age = "twenty";   // ❌ ERROR — can't assign String to int
int age = 20;         // ✅ correct
// Java checks types at compile time — catches errors early
```

**4. Automatic Memory Management**
```
Java has a Garbage Collector
You don't manually allocate/free memory like C/C++
JVM automatically reclaims unused objects
```

**5. Multithreading Built-in**
```
Java has native support for multithreading
Can run multiple tasks simultaneously
Built into the language with Thread class and java.util.concurrent
```

**6. Robust & Secure**
```
Strong exception handling
No pointers (prevents memory corruption)
Bytecode verifier checks code before execution
Security manager controls runtime permissions
```

**7. Rich Standard Library**
```
java.lang   → core (String, Math, System, Thread)
java.util   → Collections, Scanner, Date
java.io     → File handling, streams
java.net    → Networking
java.sql    → Database connectivity
```

**8. High Performance (via JIT)**
```
JIT Compiler converts hot bytecode to native machine code at runtime
Java gets FASTER the longer it runs
```

---

## 1.2 How Java Works — JDK, JRE, JVM

These three are the **most confused** concepts for beginners. Let's kill the confusion permanently.

---

### The Relationship
```
┌─────────────────────────────────────┐
│               JDK                   │
│  (Java Development Kit)             │
│                                     │
│  ┌───────────────────────────────┐  │
│  │            JRE                │  │
│  │   (Java Runtime Environment)  │  │
│  │                               │  │
│  │   ┌─────────────────────┐    │  │
│  │   │        JVM           │    │  │
│  │   │ (Java Virtual Mach.) │    │  │
│  │   └─────────────────────┘    │  │
│  │   + Core Libraries            │  │
│  └───────────────────────────────┘  │
│  + Compiler (javac)                 │
│  + Debugger (jdb)                   │
│  + Other dev tools                  │
└─────────────────────────────────────┘
```

---

### JVM — Java Virtual Machine

- An **abstract computing machine** — it's not physical hardware, it's software
- **Executes bytecode** — reads `.class` files and runs them
- Provides **platform independence** — same bytecode runs on any OS because each OS has its own JVM implementation
- Handles **memory management, garbage collection, security**
- JVM is **platform dependent** (different JVM for Windows, Mac, Linux) but bytecode is platform independent
```
Java Source Code (.java)
         ↓  javac compiles
    Bytecode (.class)
         ↓  JVM executes
   Machine Code / Output
```

**JVM Internal Components:**
```
ClassLoader Subsystem   → loads .class files into memory
Runtime Data Areas      → Heap, Stack, Method Area, PC Register
Execution Engine        → Interpreter + JIT Compiler + GC
Native Method Interface → connects to native C/C++ libraries
```

---

### JRE — Java Runtime Environment

- Everything needed to **run** a Java program
- = **JVM + Core Class Libraries** (java.lang, java.util, etc.)
- If someone just wants to **run** Java apps (not develop), they install JRE
- Does NOT include compiler (`javac`)
```
User wants to RUN a Java app  →  needs JRE
Developer wants to BUILD apps →  needs JDK
```

---

### JDK — Java Development Kit

- Everything needed to **develop** Java programs
- = **JRE + Development Tools**

**Development tools included:**

| Tool | Purpose |
|------|---------|
| `javac` | Java compiler — converts `.java` to `.class` |
| `java` | JVM launcher — runs `.class` files |
| `jdb` | Java debugger |
| `javadoc` | Generates HTML documentation from comments |
| `jar` | Creates `.jar` archive files |
| `javap` | Disassembler — shows bytecode of `.class` files |
| `jconsole` | JVM monitoring tool |

---

### Quick Comparison Table

| | JVM | JRE | JDK |
|-|-----|-----|-----|
| Runs Java programs | ✅ | ✅ | ✅ |
| Includes core libraries | ❌ | ✅ | ✅ |
| Includes `javac` compiler | ❌ | ❌ | ✅ |
| Includes dev tools | ❌ | ❌ | ✅ |
| Who needs it | internally used | end users | developers |

---

// 1.3 Compilation vs Interpretation — Bytecode Explained

 Two Ways to Execute Code

Compiled Languages (C, C++)**

Source Code → Compiler → Machine Code (.exe)
Machine code runs DIRECTLY on OS
Fast execution, but platform specific
Windows .exe won't run on Linux

Interpreted Languages (Python, JavaScript)**

Source Code → Interpreter reads line by line → Executes immediately
No compilation step, runs directly
Slower execution (interpreted every time)
Platform independent (interpreter handles differences)

//Java — Hybrid (Both)**

Source Code → Compiler (javac) → Bytecode → JVM Interprets/JIT Compiles → Executes

What is Bytecode?
Bytecode is intermediate code — not machine code, not source code. It sits in between.
// Your source code (HelloWorld.java):
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}


After `javac HelloWorld.java`, the `.class` file contains bytecode. If you run `javap -c HelloWorld` to inspect it:

// Bytecode inside HelloWorld.class (human-readable view):
public static void main(java.lang.String[]);
    Code:
       0: getstatic     #7   // Field System.out
       3: ldc           #13  // String "Hello"
       5: invokevirtual #15  // Method println
       8: return


> This bytecode is the same on ALL platforms. The JVM on each platform translates it to that platform's machine code.

---

### JIT Compiler — Why Java is Fast

**Problem with pure interpretation:**

Same bytecode interpreted again and again → slow


**JIT Compiler solves this:**

JVM monitors which code runs frequently ("hot code")
          ↓
JIT compiles that hot code to native machine code
          ↓
Next time that code runs → executes native code directly
          ↓
Much faster — no interpretation needed anymore

First run  → Interpreted (slower)
After warmup → JIT compiled (as fast as C++)


This is why Java is used for **high-frequency trading systems, large backends** — it warms up and becomes extremely fast.

---

### Compilation Flow — Complete Picture

Step 1: Write code
        HelloWorld.java

Step 2: Compile
        javac HelloWorld.java
        → produces HelloWorld.class (bytecode)

Step 3: Run
        java HelloWorld
        → JVM loads HelloWorld.class
        → ClassLoader links dependencies
        → Execution Engine runs bytecode
        → JIT compiles hot paths to native code
        → Output appears on screen


---

### Why Not Compile Directly to Machine Code?

If Java compiled to machine code like C++:
    Windows .exe → only runs on Windows
    Linux binary → only runs on Linux

With Bytecode approach:
    HelloWorld.class → runs on Windows JVM ✅
    HelloWorld.class → runs on Linux JVM   ✅
    HelloWorld.class → runs on Mac JVM     ✅
    HelloWorld.class → runs on Android JVM ✅

Same file. Everywhere.

1.4 Setting Up Environment (JDK + IntelliJ/VS Code)
Step 1 — Install JDK
Download:

Go to: https://adoptium.net (Eclipse Temurin — free, open source)
OR: https://www.oracle.com/java/technologies/downloads
Choose Java 21 LTS (latest stable long-term support)
Pick your OS: Windows / macOS / Linux

Verify installation:
java -version
# Should output something like:
# openjdk version "21.0.1" 2023-10-17

javac -version
# Should output:
# javac 21.0.1

> If `java -version` works but `javac -version` doesn't → you installed JRE not JDK. Reinstall JDK.

---

### Step 2 — Set JAVA_HOME (Windows)

1. Search "Environment Variables" in Windows search
2. Click "Edit the system environment variables"
3. Click "Environment Variables"
4. Under System Variables → New
   Variable name:  JAVA_HOME
   Variable value: C:\Program Files\Java\jdk-21  (your JDK install path)
5. Find "Path" in System Variables → Edit → New
   Add: %JAVA_HOME%\bin
6. Click OK → restart terminal

🔥 Tricky Questions — 1.1 to 1.4

Q1. Is Java fully platform independent?**
> Not 100%. The bytecode is platform independent, but the **JVM itself is platform dependent —
> there's a different JVM for Windows, Mac, Linux. Also things like file paths (`\` vs `/`), GUI rendering, and system calls can behave differently.

Q2. Can Java run without JVM?**
> Technically yes — **GraalVM Native Image** can compile Java directly to machine code,
> skipping JVM entirely. Used for serverless/cloud where JVM startup time is a problem.

Q3. What is the difference between `java` and `javac`?
javac = Java Compiler → converts .java to .class (bytecode)
java  = JVM Launcher  → loads and executes .class files

Q4. If JVM is platform dependent, how is Java platform independent?

Great interview question. Java achieves platform independence through two-step execution:

Step 1: javac compiles to bytecode — same bytecode everywhere
Step 2: Each platform has its own JVM that understands that platform's machine code
The bytecode is universal, the JVM is the translator for each platform
You ship the bytecode. Oracle/OpenJDK ships the JVM for each OS.


Q5. What happens if JDK is installed but JAVA_HOME is not set?

Java will still work from terminal if bin folder is in PATH. But many tools like Maven, Gradle, Tomcat, 
Android Studio specifically look for JAVA_HOME environment variable and will fail or show errors without it.

🧠 Key Takeaways — 1.1 to 1.4

Java was created by James Gosling at Sun Microsystems in 1995, acquired by Oracle in 2010
JDK ⊃ JRE ⊃ JVM — each contains the previous one
JVM executes bytecode, handles memory, GC — it is platform dependent
JRE = JVM + core libraries — for running Java apps
JDK = JRE + dev tools (javac, jdb, etc.) — for building Java apps
Java is hybrid — compiled to bytecode, then interpreted/JIT compiled at runtime
Bytecode is the secret of WORA — same .class file runs on any OS with a JVM
JIT Compiler makes Java fast by converting hot bytecode to native machine code
Use JDK 21 LTS + IntelliJ IDEA Community for learning
Always verify with java -version and javac -version after installation

----------------------------------------------------------------------------------
## Your First Java Program — Hello World  
java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// Line by Line — Every Word Explained  
// `public class HelloWorld`  

- `class` — In Java, everything lives inside a class. You cannot write a single line of code outside a class.
 Java is 100% object-oriented.  
- `HelloWorld`— This is the class name. It must **exactly match the filename →
file must be saved as `HelloWorld.java`  
- `public`— An access modifier. Means this class is accessible from everywhere.  

> // ⚠️ Rule:Java is case-sensitive. `HelloWorld` ≠ `helloworld`  

----------------------------------------------------------------------------------

// `public static void main(String[] args)`  

This is the **entry point** of every Java program. JVM looks for this exact signature to start execution.  

Let's break each word:  

| Word     | Meaning |  
|------    |---------|  
| `public` | JVM needs to call this from outside the class, so it must be public |  
| `static` | JVM calls `main` without creating an object of the class, so it must be static |  
| `void`   | `main` doesn't return anything |  
| `main`   | The name JVM looks for — hardcoded convention |  
| `String[] args` | Command line arguments passed as an array of Strings |  
---------------------------------------------------------------------------------- 
//`System.out.println("Hello, World!")`  

Break it down:  

System       → a built-in class in java.lang package  
out          → a static field in System class, of type PrintStream  
println()    → a method of PrintStream that prints + adds new line  

Difference between print methods:  
System out.print("Hello");      // prints, NO new line  
System.out.println("Hello");    // prints + moves to next line  
System.out.printf("Age: %d", 25); // formatted print like C  
----------------------------------------------------------------------------------
//How Java Runs — Behind the Scenes

Step 1:  You write  →  HelloWorld.java       (Source code)
Step 2:  javac compiles  →  HelloWorld.class  (Bytecode)
Step 3:  JVM runs  →  Output on screen        (Execution)

javac HelloWorld.java    ← compiles
java HelloWorld          ← runs (no .class extension here)

Why Bytecode? Java's motto is "Write Once, Run Anywhere". Bytecode runs on any OS that has a JVM
 — Windows, Mac, Linux.
----------------------------------------------------------------------------------
//Using args — Command Line Arguments
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0]);
    }
}

Run it:
java HelloWorld Rohan
// Output: Hello, Rohan
args[0] is the first argument you pass. args is just an array of Strings.

// ❌ Wrong — class name doesn't match filename
public class hello {  // file saved as HelloWorld.java — ERROR
}

// ❌ Wrong — missing static
public void main(String[] args) { }  // JVM can't call it — ERROR

// ❌ Wrong — case mistake
system.out.println("hi");  // 'system' should be 'System' — ERROR

// ✅ Correct
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
----------------------------------------------------------------------------------
🔥 Tricky Questions
Q1. Can we have multiple main methods in Java?
// Yes! — through method OVERLOADING. But JVM only calls main(String[] args)
public class Test {
    public static void main(String[] args) {
        System.out.println("JVM calls this");
    }
    public static void main(int a) {
        System.out.println("This won't be called by JVM");
    }
}
----------------------------------------------------------------------------------
Q2. What if we remove static from main?
public class Test {
    public void main(String[] args) {  // no static
        System.out.println("Hello");
    }
}
// Output: Error — Main method is not static
// JVM cannot call it without creating an object
----------------------------------------------------------------------------------
Q3. Can main be private?
private static void main(String[] args) { }
// Compiles fine but JVM throws:
// Error: Main method not found — must be declared public
----------------------------------------------------------------------------------
Q4. What does this print?
public class Test {
    public static void main(String[] args) {
        System.out.println("A");
        System.out.print("B");
        System.out.println("C");
    }
}
A
BC        ← B has no newline, so C joins on same line
----------------------------------------------------------------------------------
Q5. Can a Java file have multiple classes?
// Yes — but only ONE class can be public, and filename must match that public class
class A {  }          // allowed — no public
class B {  }          // allowed — no public
public class Test {   // filename must be Test.java
    public static void main(String[] args) { }
}
🧠 Key Takeaways

Every Java program needs a class and a main method
public static void main(String[] args) is the exact JVM entry signature
Java compiles to bytecode (.class), not machine code directly
System.out.println = System class → out field → println method
Filename must match the public class name exactly
----------------------------------------------------------------------------------
1.6 How main() Method Works InternallyThe Big Picture — What happens when you run java HelloWorld?
Most people think Java just "runs" the program. But there's a whole machinery working behind the scenes. Let's go deep.
java HelloWorld
      ↓
   JVM starts
      ↓
   ClassLoader loads HelloWorld.class
      ↓
   Bytecode Verifier checks the bytecode
      ↓
   JIT Compiler / Interpreter executes
      ↓
   main() is found & called
      ↓
   Program runs
----------------------------------------------------------------------------------
Step 1 — JVM Starts Up
When you type java HelloWorld in terminal:

OS launches the JVM process
JVM allocates memory — Heap, Stack, Method Area, etc.
JVM then hands control to the ClassLoader
----------------------------------------------------------------------------------
Step 2 — ClassLoader Subsystem
The ClassLoader is responsible for finding, loading, and linking your .class file into memory.
It works in 3 phases:
2a. Loading
Finds HelloWorld.class file on disk
↓
Reads the bytecode
↓
Creates a Class object in Heap memory representing HelloWorld
//There are 3 built-in ClassLoaders, working in a parent-child chain:
Bootstrap ClassLoader        ← loads core Java classes (java.lang.*, etc.)
       ↓
Extension ClassLoader        ← loads from jre/lib/ext
       ↓
Application ClassLoader      ← loads YOUR classes (HelloWorld.class)

Key rule — Parent Delegation Model:
Before loading a class, each ClassLoader asks its parent to load it first.
Only if parent can't find it, the child loads it.
This prevents you from accidentally overriding core Java classes.

2b. Linking
Three sub-steps:
Verification  → Is the bytecode valid & safe? (security check)
Preparation   → Allocates memory for static variables, sets default values
Resolution    → Replaces symbolic references with actual memory references

2c. Initialization
Static variables get their actual assigned values
Static blocks execute (in order, top to bottom)
public class HelloWorld {
    static int x = 10;         // initialized here (Step 2c)
    static {
        System.out.println("Static block runs first!");
    }
    public static void main(String[] args) {
        System.out.println("main runs second!");
    }
}
Output:
Static block runs first!
main runs second!

----------------------------------------------------------------------------------

## Step 3 — Memory Areas (Runtime Data Areas)

JVM divides memory into distinct areas. Knowing this is **critical for interviews.
┌─────────────────────────────────────────┐
│              JVM MEMORY                 │
│                                         │
│  ┌─────────────┐  ┌─────────────────┐  │
│  │ Method Area │  │      Heap        │  │
│  │(class data, │  │  (all objects,  │  │
│  │static vars) │  │  instance vars) │  │
│  └─────────────┘  └─────────────────┘  │
│                                         │
│  ┌──────────────────────────────────┐  │
│  │         Stack (per thread)        │  │
│  │  ┌────────────────────────────┐  │  │
│  │  │  main() Stack Frame        │  │  │
│  │  │  - args, local variables   │  │  │
│  │  └────────────────────────────┘  │  │
│  └──────────────────────────────────┘  │
│                                         │
│  ┌──────────┐  ┌──────────────────┐   │
│  │ PC Reg.  │  │  Native Method   │   │
│  │(curr ins)│  │  Stack           │   │
│  └──────────┘  └──────────────────┘   │
└─────────────────────────────────────────┘

| Memory Area        | What lives here |
|-------------       |----------------|
| Method Area        | Class structure, method bytecode, static variables |
| Heap               | All objects created with `new`, instance variables |
| Stack              | One per thread — stores stack frames (local vars, method calls) |
| PC Register        | Tracks which instruction is currently executing |
| Native Method Stack| For native (C/C++) method calls |

----------------------------------------------------------------------------------

// Step 4 — How `main()` Gets Called

Once the class is loaded and initialized:
JVM asks: "Does HelloWorld have public static void main(String[] args)?"
↓
YES → JVM creates a Stack Frame for main()
↓
Pushes the frame onto the Main Thread's Stack
↓
Execution begins line by line

A Stack Frame contains:

Local variable array (args lives here)
Operand stack (for intermediate calculations)
Reference to the constant pool
public static void main(String[] args) {
    int x = 5;           // x goes into Stack Frame's local variable array
    int y = 10;          // y goes into Stack Frame's local variable array
    int z = x + y;       // operand stack used for addition
    System.out.println(z);
}

----------------------------------------------------------------------------------

## Step 5 — Execution Engine

The bytecode inside `main()` is now executed by the **Execution Engine**, which has two parts:

### Interpreter
- Reads and executes bytecode **line by line**
- Fast to start but **slow overall** (re-interprets same code repeatedly)

### JIT Compiler (Just-In-Time)
- Monitors which code runs **frequently** (called "hot spots")
- Compiles those hot spots to **native machine code**
- Next time that code runs → executes native code directly (much faster)
- This is why Java gets **faster over time** as it runs
Bytecode
   ↓
Interpreter (runs immediately, slower)
   ↓ (if code is "hot" / runs often)
JIT Compiler (compiles to native code, blazing fast)

> This is why Java is called **"compiled + interpreted"** — both happen!

----------------------------------------------------------------------------------

## Step 6 — `main()` finishes → JVM shuts down
main() returns
↓
Stack Frame for main() is popped off the Stack
↓
No more user threads running
↓
JVM calls shutdown hooks (if any registered)
↓
Garbage Collector runs final cleanup
↓
JVM process exits

----------------------------------------------------------------------------------

## Full Flow — Visual Summary
java HelloWorld
      │
      ▼
  JVM Starts
      │
      ▼
  ClassLoader
  ├── Loading    → reads HelloWorld.class
  ├── Linking    → verify + prepare + resolve
  └── Init       → static blocks + static vars
      │
      ▼
  main() found?
  ├── NO  → Error: Main method not found
  └── YES → Stack Frame created for main()
                │
                ▼
           Execution Engine
           ├── Interpreter (line by line)
           └── JIT Compiler (hot code → native)
                │
                ▼
           main() completes
                │
                ▼
           JVM shuts down
----------------------------------------------------------------------------------
🔥 Tricky Questions
Q1. What runs BEFORE main()?
public class Test {
    static int x;

    static {
        x = 100;
        System.out.println("Static block! x = " + x);
    }

    public static void main(String[] args) {
        System.out.println("main()! x = " + x);
    }
}
Output:
Static block! x = 100
main()! x = 100
// Static blocks run before main() during class initialization.
----------------------------------------------------------------------------------
Q2. Can you run Java without main()?

In older Java (before Java 7) — YES, using only static blocks (it would print then throw error)
From Java 7 onwards — NO. JVM explicitly checks for main() and throws error if missing.
// Java 6 — this would print "Hello" then crash
// Java 7+ — Error immediately: Main method not found
public class Test {
    static {
        System.out.println("Hello");
        System.exit(0);  // used to prevent crash in Java 6
    }
}
----------------------------------------------------------------------------------
Q3. What is a Stack Overflow Error?
public class Test {
    public static void main(String[] args) {
        main(args);   // calls itself forever
    }
}
// Output: Exception in thread "main" java.lang.StackOverflowError
> Each call to `main()` creates a new Stack Frame. Stack memory fills up → **StackOverflowError**. This is literally what the website stackoverflow.com is named after!

----------------------------------------------------------------------------------

Q4. How many threads does JVM start minimum?

Even for a simple Hello World, JVM starts **multiple threads** internally:

| Thread | Purpose |
|--------|---------|
| `main` thread | Runs your `main()` method |
| `Finalizer` thread | Runs `finalize()` on objects before GC |
| `Signal Dispatcher` | Handles OS signals |
| `Garbage Collector` threads | Memory cleanup |

----------------------------------------------------------------------------------

Q5. What happens to memory after `main()` ends?

Local variables in main() → Stack Frame is destroyed → memory freed instantly
Objects created inside main() → Still in Heap until Garbage Collector collects them
Static variables → Freed only when JVM shuts down

Key Takeaways

java HelloWorld triggers a 6-step pipeline: JVM start → ClassLoader → Memory setup → main() found → Execution Engine → Shutdown
Static blocks run before main() during class initialization
main() lives on the Stack as a Stack Frame; objects live on the Heap
JVM uses both an Interpreter and JIT Compiler — Java is both compiled and interpreted
StackOverflowError = too many nested/recursive method calls filling up Stack memory
Even a Hello World program spawns multiple JVM threads internally
----------------------------------------------------------------------------------
1.7 Java Naming Conventions & Code Structure
Why Naming Conventions MatterNaming conventions are not enforced by the compiler —
your code will run even if you break them. But they are followed by every professional
Java developer worldwide including at Google and Microsoft.
Clean, consistent naming = readable code = maintainable code = you getting hired.

1. Class Names — PascalCaseEvery word starts with a capital letter. No underscores.
// ✅ Correct
class HelloWorld { }
class BankAccount { }
class StudentManagementSystem { }
class MyClass { }

// ❌ Wrong
class helloworld { }
class bankAccount { }       // that's camelCase — for variables
class bank_account { }      // underscores not used in class names
class BANKACCOUNT { }       // all caps = wrong
Rule of thumb: Class names are nouns — they represent a thing.
----------------------------------------------------------------------------------
2. Method Names — camelCase
First word lowercase, every subsequent word capitalized. No underscores.
// ✅ Correct
void calculateSalary() { }
void getUserName() { }
void printDetails() { }
boolean isEligible() { }      // boolean methods start with is/has/can
int getTotalMarks() { }       // getters start with get
void setAge(int age) { }      // setters start with set

// ❌ Wrong
void CalculateSalary() { }    // PascalCase is for classes
void calculate_salary() { }   // underscores not used
void CALCULATESALARY() { }    // all caps = wrong
Rule of thumb: Method names are verbs — they represent an action.
----------------------------------------------------------------------------------
3. Variable Names — camelCase
Same as methods — camelCase. Should be meaningful, not single letters (except loop counters).
// ✅ Correct
int studentAge = 20;
String firstName = "Rohan";
double accountBalance = 50000.00;
boolean isLoggedIn = true;

// Loop counters — single letters are fine here
for (int i = 0; i < 10; i++) { }

// ❌ Wrong
int StudentAge = 20;          // PascalCase = class names only
int student_age = 20;         // underscores not used
int a = 20;                   // meaningless name (outside loops)
int STUDENTAGE = 20;          // all caps = constants only
----------------------------------------------------------------------------------
4. Constants — UPPER_SNAKE_CASE
All capitals, words separated by underscores. Always declared static final.
// ✅ Correct
static final int MAX_SIZE = 100;
static final double PI = 3.14159;
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
static final int MIN_AGE = 18;

// ❌ Wrong
static final int maxSize = 100;        // looks like a variable
static final int MaxSize = 100;        // looks like a class
----------------------------------------------------------------------------------
5. Package Names — all lowercase
All lowercase, usually reverse domain name of your company.
// ✅ Correct
package com.google.search;
package com.microsoft.azure;
package com.mycompany.project.utils;
package org.springframework.core;

// ❌ Wrong
package Com.Google.Search;     // no capitals
package com.google_search;     // underscores avoided
----------------------------------------------------------------------------------
6. Interface Names — PascalCase (like classes)
Usually adjectives or ability-describing words.
// ✅ Correct
interface Runnable { }
interface Serializable { }
interface Printable { }
interface Comparable { }
interface UserService { }      // Service interfaces common in real projects

// ❌ Wrong
interface runnable { }
interface IRunnable { }        // 'I' prefix is a C# convention, NOT Java
----------------------------------------------------------------------------------
7. Enum Names — PascalCase, values in UPPER_SNAKE_CASE
// ✅ Correct
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Status {
    ACTIVE, INACTIVE, PENDING, DELETED
}
----------------------------------------------------------------------------------
// Java Naming Convention Cheat Sheet

Class        : PascalCase       -> BankAccount
Interface    : PascalCase       -> Serializable
Method       : camelCase        -> calculateSalary()
Variable     : camelCase        -> studentAge
Constant     : UPPER_SNAKE_CASE -> MAX_SIZE
Package      : lowercase        -> com.company.project
Enum         : PascalCase       -> Day
Enum Value   : UPPER_SNAKE_CASE -> MONDAY
----------------------------------------------------------------------------------
Code Structure — Anatomy of a Java File
A well-structured Java file follows this exact order:
// 1. Package declaration (first line, if any)
package com.myapp.models;

// 2. Import statements
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

// 3. Class declaration
public class BankAccount {

    // 4. Constants (static final)
    static final double MIN_BALANCE = 500.0;

    // 5. Static variables
    static int totalAccounts = 0;

    // 6. Instance variables (private — encapsulation)
    private String accountHolder;
    private double balance;
    private String accountNumber;

    // 7. Constructors
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++;
    }

    // 8. Static methods
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // 9. Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= MIN_BALANCE) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // 10. Getters & Setters
    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    // 11. toString() — for printing object details
    @Override
    public String toString() {
        return "Account[" + accountHolder + " | Balance: " + balance + "]";
    }
}
----------------------------------------------------------------------------------
Code Formatting Rules
Indentation
// ✅ 4 spaces (or 1 tab) per level
public class Test {
    public static void main(String[] args) {
        if (true) {
            System.out.println("indented correctly");
        }
    }
}

// ❌ Inconsistent indentation
public class Test {
  public static void main(String[] args) {   // 2 spaces
      if (true) {                             // 6 spaces — messy
System.out.println("bad");                   // no indent
    }
  }
}
----------------------------------------------------------------------------------
Braces — Egyptian Style (Java standard)
// ✅ Correct — opening brace on SAME line
public class Test {
    public static void main(String[] args) {
        if (true) {
            // code
        }
    }
}

// ❌ Wrong for Java — opening brace on NEW line (this is C# style)
public class Test
{
    public static void main(String[] args)
    {
    }
}
----------------------------------------------------------------------------------
One Statement Per Line
// ✅ Correct
int x = 5;
int y = 10;
int z = x + y;

// ❌ Wrong
int x = 5; int y = 10; int z = x + y;   // cramped, hard to read
----------------------------------------------------------------------------------
Line Length
// ✅ Keep lines under ~80-100 characters
// If too long, break it:
String result = someObject
        .methodOne()
        .methodTwo()
        .methodThree();
----------------------------------------------------------------------------------
Meaningful Names — The Most Important Rule
// ❌ Bad — what does this even do?
int d = 86400;
void calc(int x, int y) {
    int r = x * y;
}

// ✅ Good — self-documenting code
int secondsInADay = 86400;
void calculateArea(int length, int width) {
    int area = length * width;
}
Good code reads like English. If you need a comment to explain what a variable is, the variable name is wrong.
----------------------------------------------------------------------------------
Comments — When and How
// Single line comment — for quick explanations

/*
 * Multi-line comment
 * Used for longer explanations
 */

/**
 * Javadoc comment — used to generate documentation
 * @param amount  the amount to deposit
 * @return        the new balance after deposit
 */
public double deposit(double amount) {
    balance += amount;
    return balance;
}
Rule: Don't comment WHAT the code does — write code so clear it explains itself.
Comment WHY you made a decision if it's not obvious.
// ❌ Useless comment
int age = 25;   // setting age to 25

// ✅ Useful comment
// Using int instead of byte because age can exceed 127 in edge cases
int age = 25;
----------------------------------------------------------------------------------
🔥 Tricky Questions
Q1. Will this compile?
package com.test;
import java.util.ArrayList;
public class test {          // class name lowercase
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
✅ Yes it compiles — but only if the filename is test.java (lowercase).
Convention is broken but compiler doesn't care. However — in real projects
this would be rejected in code review immediately.
----------------------------------------------------------------------------------
Q2. What's wrong here?
public class BankAccount {
    public double Balance;          // 1
    public static final int min = 100;  // 2
    
    public void CalculateInterest() {   // 3
        // code
    }
}
1. Balance → should be 'balance' (camelCase) + should be private
2. min → should be MIN (UPPER_SNAKE_CASE for constants)
3. CalculateInterest() → should be calculateInterest() (camelCase for methods)

----------------------------------------------------------------------------------
Q3. Which is the correct package name for a company called "TechCorp" with project "PayrollSystem"?
// ❌
package TechCorp.PayrollSystem;
package techcorp.PayrollSystem;

// ✅
package com.techcorp.payrollsystem;
// or
package com.techcorp.payroll.system;
----------------------------------------------------------------------------------
Q4. What is wrong with these variable names?
int 1stRank = 1;          // ❌ can't start with number
int first-rank = 1;       // ❌ hyphen not allowed
int class = 1;            // ❌ 'class' is a reserved keyword
int $money = 100;         // ✅ valid but bad practice ($ allowed technically)
int _score = 99;          // ✅ valid but bad practice (_ allowed technically)
int firstName = "Rohan";  // ❌ type mismatch — int can't hold String
----------------------------------------------------------------------------------
🧠 Key Takeaways

Classes & Interfaces → PascalCase (nouns)
Methods & Variables → camelCase (methods = verbs, variables = nouns)
Constants → UPPER_SNAKE_CASE, always static final
Packages → all lowercase, reverse domain style
Java uses Egyptian brace style — opening brace on same line
4 spaces per indentation level
Names should be self-documenting — code should read like English
Conventions aren't enforced by compiler but are enforced by every real-world team

```
