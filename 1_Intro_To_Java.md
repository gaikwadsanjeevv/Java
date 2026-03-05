## Your First Java Program — Hello World  
``` java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

## Line by Line — Every Word Explained  
## `public class HelloWorld`  

- `class` — In Java, everything lives inside a class. You cannot write a single line of code outside a class.
 Java is 100% object-oriented.  
- `HelloWorld`— This is the class name. It must **exactly match the filename →
file must be saved as `HelloWorld.java`  
- `public`— An access modifier. Means this class is accessible from everywhere.  

> ### ⚠️ Rule:Java is case-sensitive. `HelloWorld` ≠ `helloworld`  

---

### `public static void main(String[] args)`  

This is the **entry point** of every Java program. JVM looks for this exact signature to start execution.  

Let's break each word:  

| Word     | Meaning |  
|------    |---------|  
| `public` | JVM needs to call this from outside the class, so it must be public |  
| `static` | JVM calls `main` without creating an object of the class, so it must be static |  
| `void`   | `main` doesn't return anything |  
| `main`   | The name JVM looks for — hardcoded convention |  
| `String[] args` | Command line arguments passed as an array of Strings |  
 
//`System.out.println("Hello, World!")`  

Break it down:  

System       → a built-in class in java.lang package  
out          → a static field in System class, of type PrintStream  
println()    → a method of PrintStream that prints + adds new line  

Difference between print methods:  
System out.print("Hello");      // prints, NO new line  
System.out.println("Hello");    // prints + moves to next line  
System.out.printf("Age: %d", 25); // formatted print like C  

//How Java Runs — Behind the Scenes

Step 1:  You write  →  HelloWorld.java       (Source code)
Step 2:  javac compiles  →  HelloWorld.class  (Bytecode)
Step 3:  JVM runs  →  Output on screen        (Execution)

javac HelloWorld.java    ← compiles
java HelloWorld          ← runs (no .class extension here)

Why Bytecode? Java's motto is "Write Once, Run Anywhere". Bytecode runs on any OS that has a JVM
 — Windows, Mac, Linux.

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
Q2. What if we remove static from main?
public class Test {
    public void main(String[] args) {  // no static
        System.out.println("Hello");
    }
}
// Output: Error — Main method is not static
// JVM cannot call it without creating an object

Q3. Can main be private?
private static void main(String[] args) { }
// Compiles fine but JVM throws:
// Error: Main method not found — must be declared public

Q4. What does this print?
public class Test {
    public static void main(String[] args) {
        System.out.println("A");
        System.out.print("B");
        System.out.println("C");
    }
}
```
```
A
BC        ← B has no newline, so C joins on same line

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

```
