## Your First Java Program — Hello World  
``` java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

---

// Line by Line — Every Word Explained

// `public class HelloWorld`

- **`class`** — In Java, everything lives inside a class. You cannot write a single line of code outside a class. Java is 100% object-oriented.
- **`HelloWorld`** — This is the class name. It must **exactly match the filename** → file must be saved as `HelloWorld.java`
- **`public`** — An access modifier. Means this class is accessible from everywhere.

> ⚠️ **Rule:** Java is case-sensitive. `HelloWorld` ≠ `helloworld`

---

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

//`System.out.println("Hello, World!")`

Break it down:

System       → a built-in class in java.lang package
out          → a static field in System class, of type PrintStream
println()    → a method of PrintStream that prints + adds new line

Difference between print methods:
System out.print("Hello");      // prints, NO new line
System.out.println("Hello");    // prints + moves to next line
System.out.printf("Age: %d", 25); // formatted print like C
```

---

//How Java Runs — Behind the Scenes

Step 1:  You write  →  HelloWorld.java       (Source code)
Step 2:  javac compiles  →  HelloWorld.class  (Bytecode)
Step 3:  JVM runs  →  Output on screen        (Execution)

javac HelloWorld.java    ← compiles
java HelloWorld          ← runs (no .class extension here)

Why Bytecode? Java's motto is "Write Once, Run Anywhere". Bytecode runs on any OS that has a JVM — Windows, Mac, Linux.

//Using args — Command Line Arguments

```
