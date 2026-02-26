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
#### Skeleton of a Java Program — One-line Points  

. File Name & Class Name: The .java file name should match the public class name.  

. Import Statements (Optional): Used to include external packages (e.g., java.util.*), though java.lang is imported by default.  

Class Declaration: All Java code must be written inside a class.  

Main Method: public static void main(String[] args) is the entry point where program execution begins.  

public Keyword: Makes the main method accessible to the JVM from anywhere.  

static Keyword: Allows the main method to run without creating an object of the class.  

void Keyword: Indicates the main method does not return any value.  

String[] args: Holds command-line arguments passed to the program.  

Output Statement: System.out.println() prints text to the console.  

Compilation Step: javac Main.java converts source code into bytecode (.class).  

Execution Step: java Main runs the compiled bytecode using the JVM.  
