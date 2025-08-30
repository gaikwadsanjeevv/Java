#### Collection Framework  
- Is one of data structure. 
- Any group of individual objects which are represented as a single unit is known as collection of the  object.
- A framework is a set of classes and interfaces which provide ready made architecture.
- Ex Integer, Floats, Students, Books, Customers, products, Accounts, Movies, Friends.
- Collection is also arranging the data in the memory and giving to the java programme.
- Array is static and fixed, so many operations cant be performed, so we need solutions and we use collections.
- Because the size fixed sometimes we dont know how much data is getting pulled so we need dynamic array.
- Due to limitations of array on certian requirements we have collections for them.
   - Variable size collection : ArrayList, LinkedList.  
   - Distinct collection : Set
   - Sorted Collection : SortedSet
     ** Doing below operations require shifting of elements in array which we have to take care off so collections help more better.  
   - Insert  
   - delete  
   - Search

- Java provide collections in form of interfaces and classes.
3. Why implement the interface in the class?  
A class that implements Vehicle is promising:
“I will provide my own version of drive().”  
Without this, the class wouldn’t compile.

- @Override is an annotation that tells the compiler: “This method is overriding a parent class or interface method. @Override is mainly for safety & readability.
- When we use @override?
   - When implementing an interface
   - When overriding methods from a parent class.
   - when overriding toString(), equals(), hashCode() in own classes.
  - When we override, we are not stopping the parent’s method.

- We are replacing (or redefining) the parent’s behavior with our own custom implementation.  
The method signature (name + parameters) must stay the same.  
The body (implementation) can be different.

- We can define Interface in follwing ways:
   1) Abstract Methods (the original way). Declared without a body. Must be implemented by the class.
  ``java
interface Vehicle {
void drive();
void stop();
//Any class implementing Vehicle must give its own implementation of drive() and stop().
}
```
2) Default Methods (Java 8+) Interfaces can now have methods with a body (implementation). They are marked with default. Useful when you want to provide a common default behavior, but allow overriding if needed.

```java
interface Vehicle {
    void drive(); // abstract

    default void honk() { // default method with body
        System.out.println("Beep beep!");
    }
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Car driving...");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.drive(); // Car driving...
        v.honk();  // Beep beep! (from interface)
    }
}
```
3. Static Methods(java 8+)
   Interfaces can also have static methods (with body). Called on the interface itself, not on the object.
   ```java
   interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        int sum = MathUtils.add(5, 7); // call directly on interface
        System.out.println("Sum = " + sum);
    }
}

   ```
4. Private Methods (Java 9+): Interfaces can have private methods for internal code reuse inside the interface.Cannot be called outside; only used by other default or static methods in the same interface.
```java
interface Logger {
    default void logInfo(String msg) {
        log("INFO", msg); // calls private helper
    }
    default void logError(String msg) {
        log("ERROR", msg); // calls private helper
    }

    // private helper method
    private void log(String level, String msg) {
        System.out.println("[" + level + "] " + msg);
    }
}

class App implements Logger {}

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.logInfo("System started");  // [INFO] System started
        app.logError("Something went wrong"); // [ERROR] Something went wrong
    }
}
```
Examples of @Override.  
Example 1:  Interface  
```java
interface Vehicle {
    void drive(); // only a contract, no body
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car drives on 4 wheels");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Bike drives on 2 wheels");
    }
}

```

Example 2 :  Inheritance  
```java
class Animal {
    void sound() {
        System.out.println("Some generic sound...");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark Bark!");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow Meow!");
    }
}
The parent Animal has a default sound().
But each child overrides it with a specialized sound.
```
Overloading = same method name but different parameters (compile-time decision).  

Overriding = same method signature but different implementation (runtime decision, polymorphism).  

