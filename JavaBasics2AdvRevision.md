<img width="1297" height="572" alt="image" src="https://github.com/user-attachments/assets/a49c48ef-c6f7-4bbf-baa8-c803bbdb3194" />  

<img width="1210" height="502" alt="image" src="https://github.com/user-attachments/assets/a784b05e-f4d6-46dd-9811-a69eaafe2983" />  

<img width="1297" height="571" alt="image" src="https://github.com/user-attachments/assets/d44f5c2a-d69d-4750-a067-aaaa37a5a8dc" />  
<img width="1177" height="581" alt="image" src="https://github.com/user-attachments/assets/fc1aca1f-624f-44a1-924c-8cabfe15338d" />  
<img width="1275" height="537" alt="image" src="https://github.com/user-attachments/assets/79f4382c-af9e-465b-9604-0702b040bcb5" />  
<img width="1322" height="476" alt="image" src="https://github.com/user-attachments/assets/019481a7-3f4f-4213-b205-a1f34af00b87" />  
<img width="1227" height="498" alt="image" src="https://github.com/user-attachments/assets/5516b12f-1ec9-49fe-86a0-ace415315d7e" />  
<img width="1291" height="533" alt="image" src="https://github.com/user-attachments/assets/1add837d-ddf0-4382-b2ea-9c3d1bf8a1d6" />  
<img width="1232" height="618" alt="image" src="https://github.com/user-attachments/assets/dc7a32fc-1819-4ecd-814f-35cc1aa2b4b6" />  

```java
public class TypeConversionDemo {
    public static void main(String[] args) {
        // Widening
        int num = 10;
        double d = num;
        System.out.println("Widening: " + d);

        // Narrowing
        double pi = 3.14;
        int intPi = (int) pi;
        System.out.println("Narrowing: " + intPi);

        // char to int
        char ch = 'A';
        int ascii = ch;
        System.out.println("Char to int: " + ascii);

        // int to char
        char ch2 = (char) 66;
        System.out.println("Int to char: " + ch2);
    }
}
```
<img width="1272" height="367" alt="image" src="https://github.com/user-attachments/assets/5260a4c4-b1ac-40ba-a77f-3217bd6efb54" />  

<img width="1282" height="590" alt="image" src="https://github.com/user-attachments/assets/dcb1b51c-d65a-482d-807c-b255c555dd44" />  
Increment/Decrement difference:   
int x = 5;  
System.out.println(++x); // 6 (pre-increment: increment, then use)    
System.out.println(x++); // 6 (post-increment: use, then increment)    

<img width="1258" height="545" alt="image" src="https://github.com/user-attachments/assets/290e2e2f-4acc-43ab-811b-cece164351c9" />  

```java
int a = 10, b = 20;
System.out.println(a > b); // false
System.out.println(a != b); // true
```
<img width="1227" height="662" alt="image" src="https://github.com/user-attachments/assets/3259a901-16c4-43a0-a1d5-316ae99980cf" />  
<img width="1221" height="322" alt="image" src="https://github.com/user-attachments/assets/03e8def8-0836-41ba-999d-7978bd7eae91" />  
```java
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 5;

        // Arithmetic
        System.out.println("a + b = " + (a + b));
        System.out.println("a % b = " + (a % b));

        // Relational
        System.out.println("a > b: " + (a > b));
        System.out.println("a == b: " + (a == b));

        // Logical
        boolean cond1 = (a > b);
        boolean cond2 = (a < 20);
        System.out.println("cond1 && cond2: " + (cond1 && cond2));
        System.out.println("cond1 || cond2: " + (cond1 || cond2));
        System.out.println("!cond1: " + (!cond1));
    }
}
```  
<img width="1192" height="565" alt="image" src="https://github.com/user-attachments/assets/d4ef8552-51d0-4c2c-b565-5ee45eac90ab" />  
<img width="1157" height="683" alt="image" src="https://github.com/user-attachments/assets/2b075a93-c043-414b-8b02-0f46066750e8" />  
<img width="1162" height="507" alt="image" src="https://github.com/user-attachments/assets/3bc8a534-3324-4827-891b-1061572df234" />  
```java
int marks = 75;
if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else if (marks >= 50) {
    System.out.println("Grade C");
} else {
    System.out.println("Fail");
}
```
<img width="1167" height="725" alt="image" src="https://github.com/user-attachments/assets/3b2e4ff2-d76a-4c2f-b35e-847c6b62debe" />  
<img width="1157" height="571" alt="image" src="https://github.com/user-attachments/assets/95b39103-79f4-4990-9e90-171f3f150ebf" />  
<img width="1115" height="752" alt="image" src="https://github.com/user-attachments/assets/b44f667d-1d25-42b3-81b4-93c761557768" />  
<img width="1171" height="662" alt="image" src="https://github.com/user-attachments/assets/7330bb11-9b21-4dc9-b965-6ef5e50ecfdb" />  

##### Combined example.  
```java
public class ConditionsDemo {
    public static void main(String[] args) {
        int score = 85;

        // if-else
        if (score >= 90) {
            System.out.println("Excellent");
        } else {
            System.out.println("Keep improving");
        }

        // if-else-if
        if (score >= 90) {
            System.out.println("A Grade");
        } else if (score >= 75) {
            System.out.println("B Grade");
        } else if (score >= 50) {
            System.out.println("C Grade");
        } else {
            System.out.println("Fail");
        }

        // ternary
        String passStatus = (score >= 50) ? "Pass" : "Fail";
        System.out.println(passStatus);

        // switch
        int day = 3;
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Other Day");
        }
    }
}
```
Another Example.  
```java
public class ConditionsDemo {
    public static void main(String[] args) {
        int score = 85;

        // if-else
        if (score >= 90) {
            System.out.println("Excellent");
        } else {
            System.out.println("Keep improving");
        }

        // if-else-if
        if (score >= 90) {
            System.out.println("A Grade");
        } else if (score >= 75) {
            System.out.println("B Grade");
        } else if (score >= 50) {
            System.out.println("C Grade");
        } else {
            System.out.println("Fail");
        }

        // ternary
        String passStatus = (score >= 50) ? "Pass" : "Fail";
        System.out.println(passStatus);

        // switch
        int day = 3;
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Other Day");
        }
    }
}
```  
yield is like return for switch expressions, used only when you have a multi-line block and need to send a value back to the expression.  
```java
String day = "FRIDAY";
String type = switch (day) {
    case "MONDAY" -> "Start";
    case "FRIDAY" -> {
        System.out.println("Processing Friday logic...");
        yield "Almost weekend"; // Explicit return from this block
    }
    default -> "Other day";
};
System.out.println(type);
```
In Java 14+ switch expressions,  
No yield is needed for single-line -> cases.  
yield is mandatory in multi-line { ... } case blocks to provide the return value.  
break is not used in switch expressions at all.  

<img width="1163" height="741" alt="image" src="https://github.com/user-attachments/assets/4e1e26b1-88b6-419c-84a1-5bad9a5c9f0e" />  
<img width="1157" height="553" alt="image" src="https://github.com/user-attachments/assets/7ad6f792-130d-487e-a52e-958b1b79f373" />  
<img width="1138" height="562" alt="image" src="https://github.com/user-attachments/assets/20c40153-f497-4739-b9f7-1545c2e0eed3" />  
<img width="1142" height="551" alt="image" src="https://github.com/user-attachments/assets/43f98046-57ca-4c6a-8b58-b63ab974bfa5" />  
<img width="1168" height="402" alt="image" src="https://github.com/user-attachments/assets/80dc157c-648e-4eb6-9a0e-0682a7feb91f" />  
<img width="1176" height="513" alt="image" src="https://github.com/user-attachments/assets/6477dbc2-f711-4a3e-bca1-aa7cb8f416b4" />  
<img width="1121" height="755" alt="image" src="https://github.com/user-attachments/assets/3929dfb4-43a0-478b-b85d-5a7d6c233e61" />  
<img width="1235" height="432" alt="image" src="https://github.com/user-attachments/assets/320c72d1-b284-468c-8cd1-0a48a8612679" />  

Class definitions go to Method Area.  
Objects go to Heap.  
Local variables & references go to Stack.  
When method ends, its stack frame is destroyed — but object in Heap stays until Garbage Collection.  
Multiple references can point to the same object in Heap.  

<img width="1041" height="775" alt="image" src="https://github.com/user-attachments/assets/e559541f-55d7-486b-846c-355508747abc" />  
<img width="1132" height="648" alt="image" src="https://github.com/user-attachments/assets/7706c2c1-8862-4611-b7a2-7ffe600fd166" />  

 Interview Tricky Points  
Is JVM platform-independent? → No. JVM is platform-dependent; bytecode is platform-independent.  
Can you run Java without JDK? → Yes, if the .class file is already compiled, you just need JRE.  
Does JDK include JRE? → Yes, but in newer Java versions (Java 11+), JRE is not a separate download; it’s part of JDK.  
Why JDK is larger than JRE? → It includes compiler and dev tools.  

<img width="1112" height="488" alt="image" src="https://github.com/user-attachments/assets/90a7f4fd-b4d9-4cb9-b58d-2dabb953ca76" />  

```java
public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    void greet() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3)); // 8
        calc.greet(); // Hello!
    }
}

Types of Methods
Predefined Methods – from Java libraries (e.g., Math.sqrt(), System.out.println()).
User-defined Methods – methods you create in your own classes.

Method Components
Modifier → Access level (public, private, protected, default)
Return Type → Type of value returned (or void if nothing returned)
Method Name → Should follow camelCase naming
Parameters → Optional; input to the method

Method Body → Code that runs when method is called

2. Method Overloading
Definition
Method Overloading means having multiple methods in the same class with the same name but different parameter lists (different number, order, or types of parameters).

Decided at compile-time → also called Compile-Time Polymorphism.

Rules for Method Overloading
Must have same method name.
Must differ in parameter list (number, type, or order of parameters).
Can have different return types (but not enough alone to overload — parameters must differ).
Can have different access modifiers.

class MathOperations {
    // Method 1: Two int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Three int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: Two double parameters
    double add(double a, double b) {
        return a + b;
    }
}

public class Test {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();

        System.out.println(obj.add(5, 3));       // Calls int add(int, int)
        System.out.println(obj.add(5, 3, 2));    // Calls int add(int, int, int)
        System.out.println(obj.add(5.5, 3.2));   // Calls double add(double, double)
    }
}

Why Use Method Overloading?
Improves readability — same logical method name for similar operations.

Avoids creating different names for similar tasks (e.g., addInt, addDouble).

Makes code cleaner and more maintainable.
```
<img width="1130" height="583" alt="image" src="https://github.com/user-attachments/assets/45e5347e-c8fe-4c36-905b-d7c9d17c38fe" />  

```java
Method Overriding

1. Method Overriding
Definition
Method Overriding happens when a subclass provides its own implementation of a method that is already defined in its superclass,
with the same name, same parameters, and same return type (or covariant return type).

Purpose
To modify or extend the behavior of an inherited method.
Achieves Run-Time Polymorphism.

Rules for Method Overriding
Same method signature: name, parameter list, and return type must be the same.
Access modifier: Cannot be more restrictive than the superclass method.

public → must remain public

protected → can be protected or public

Return type: Must be the same or a subtype (covariant return type).

Static, final, and private methods cannot be overridden.

The method being overridden must be inherited by the subclass.

Use @Override annotation for better readability and compile-time checking.

Exception rules:

If superclass method does not throw a checked exception, the overriding method cannot throw a new checked exception.
It can throw unchecked exceptions (RuntimeException).



class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal obj = new Dog(); // Upcasting
        obj.sound(); // Dog barks (runtime polymorphism)
    }
}
//Dog Barks
```

<img width="1148" height="622" alt="image" src="https://github.com/user-attachments/assets/bcb493bf-4962-40ef-aae9-3d9492abcb71" />  

3. Special Tricky Points for Interviews  
Static method "overriding" is actually method hiding, not true overriding.  
Constructors cannot be overridden.  
Private methods are not visible to subclasses, so they cannot be overridden — but they can be re-declared in the subclass (this is a new method, not overriding).  
Overloading works even in constructors — you can have multiple constructors in one class.

























  
