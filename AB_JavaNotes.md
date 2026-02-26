### Java Notes For Quick Revision  
#### First Java Program  
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
//Output: Hello World
```
**Skeleton of a Java Program**  
- File Name & Class Name: The .java file name should match the public class name.  
- Import Statements (Optional): Used to include external packages (e.g., java.util.*), though java.lang is imported by default.  
- Class Declaration: All Java code must be written inside a class.  
- Main Method: public static void main(String[] args) is the entry point where program execution begins.  
- public Keyword: Makes the main method accessible to the JVM from anywhere.  
- static Keyword: Allows the main method to run without creating an object of the class.  
- void Keyword: Indicates the main method does not return any value.  
- String[] args: Holds command-line arguments passed to the program.  
- Output Statement: System.out.println() prints text to the console.  
- Compilation Step: javac Main.java converts source code into bytecode (.class).  
- Execution Step: java Main runs the compiled bytecode using the JVM.

# Reading from Keyboard  

## One-line Points
- **Introduction:** Java reads keyboard input using the `Scanner` class (instead of C’s `scanf` or C++’s `cin`).
- **Scanner Class:** `Scanner` (in `java.util`) can read input from keyboard, files, and strings.
- **Import Scanner:** Import it before use.
- **Create Scanner Object:** Create and attach it to `System.in` (keyboard input).
- **Common Methods:** `nextInt()`, `nextDouble()`, `nextLine()`, `next()` read different input types.
- **BufferedReader Option:** `BufferedReader` can be used as an alternative for fast line-based input.
- **How Scanner Works:** It takes user input, parses it, and returns values in the needed data type.

## Importing the Scanner Class
```java
import java.util.Scanner;
