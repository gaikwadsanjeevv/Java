```java
2.1 What is a Variable?
The Core Idea : 
Imagine you're building a banking app. A customer logs in and you need to store their name, age, account balance,
and whether they're a premium member or not. Where do you store all this while the program is running?
In variables.
A variable is a named container in memory that holds data while your program runs.
The moment your program ends, variables are gone. They live in RAM — fast, temporary storage.
Think of RAM like a huge shelf with millions of tiny boxes. Each box can hold one piece of data.
 A variable is just you saying — "hey JVM, give me one of those boxes, label it 'age', and put the value 25 in it."

int age = 25;
// "Give me a box, label it 'age', put 25 in it"

// What Happens in Memory — For Real

When you write `int age = 25`, Java does three things physically:

Step 1 — sees the type `int` → goes to Stack memory → reserves exactly 4 bytes

Step 2 — labels those 4 bytes with the name `age`

Step 3 — converts 25 to binary and stores it in those 4 bytes

25 in binary = 00000000 00000000 00000000 00011001
               |________|________|________|________|
               byte 4   byte 3   byte 2   byte 1


In Stack memory it looks like this:

Stack Memory (your method's frame):
┌────────────────────────────┐
│  name : age                │
│  type : int (4 bytes)      │
│  value: 25                 │
│  address: 0x7fff5ab2       │  ← you NEVER see this in Java
└────────────────────────────┘


Notice — you never see the memory address. In C/C++ you'd use pointers to access 0x7fff5ab2 directly.
Java hides this completely. The JVM manages memory for you. This is why Java has no memory corruption bugs like C does
— you simply can't access raw addresses.

----------------------------------------------------------------------------------
//Three Things Every Variable Must Have
Every single variable in Java has exactly three things — no exceptions:
Type → what kind of data it holds (int, String, double, boolean...)
Name → what you call it in your code
Value → the actual data stored inside
int    age    =   25;
// ^    ^          ^
// Type Name      Value
And Java is statically typed — meaning the type is fixed at compile time. You declare it once, it stays that type forever.
int age = 25;
age = 30;              // ✅ fine — same type, different value
age = "twenty five";   // ❌ ERROR — type was int, can't store String now

This is different from Python where you can do age = 25 then age = "hello" freely. Java says no — pick a type and stick with it.
 This catches a whole class of bugs at compile time before your code even runs.
----------------------------------------------------------------------------------
// Declaration vs Initialization vs Both
These three terms come up constantly in interviews. Know the difference cold.
Declaration — you're telling Java "this variable exists, this is its type, this is its name.
" No value yet. Just creating the labeled box.
int age;
// box created, labeled 'age', but EMPTY

//Initialization — you're putting a value in for the first time.
age = 25;
// putting 25 into the box for the first time

//Declaration + Initialization together — most common, do both on one line.
int age = 25;
// box created AND filled in one shot


Re-assignment — changing the value after it's already been set.
int age = 25;   // declaration + initialization
age = 30;       // re-assignment — 25 is gone, 30 replaces it

Now here's the critical rule that trips up beginners:
Local variables in Java have NO default value. You MUST initialize them before use.
public static void main(String[] args) {
    int age;
    System.out.println(age);  // ❌ COMPILE ERROR
    // "variable age might not have been initialized"
}
The compiler refuses to run this. It sees age was declared but never given a value, and printing it would be reading garbage memory. Java won't allow that.
Compare this to instance variables (variables inside a class but outside methods) — those DO get default values automatically. int gets 0, boolean gets false, String gets null. We'll cover that in 2.7.
----------------------------------------------------------------------------------
Variable vs Literal vs Expression — Know the Difference
These three terms appear constantly in Java documentation and interviews.
A variable is a named memory location. Its value can change.
A literal is a fixed hardcoded value written directly in your source code. 25, "Rohan", true, 3.14 —
 these are all literals. They're baked into your code, they never change.
An expression is anything that evaluates to a value. It can be a combination of variables, literals, and operators.

int x = 5;          // x is a variable,  5 is a literal
int y = 10;         // y is a variable,  10 is a literal
int z = x + y;      // z is a variable,  x + y is an expression
boolean b = x > 3;  // b is a variable,  x > 3 is an expression (evaluates to true)


Real world connection — in a payment app:
double itemPrice = 499.99;         // variable
double gstRate = 0.18;             // variable
double gst = itemPrice * gstRate;  // expression — evaluates to 89.998
double totalAmount = itemPrice + gst; // expression
----------------------------------------------------------------------------------
//Naming Rules — What the Compiler Enforces
The compiler will flat out reject these — not convention, not preference, hard errors:
int 2fast = 10;       // ❌ cannot start with a digit
int first-name = 10;  // ❌ hyphen is subtraction operator, not allowed in names
int my name = 10;     // ❌ space breaks it into two tokens
int class = 10;       // ❌ 'class' is a reserved keyword
int null = 10;        // ❌ 'null' is a reserved literal
int for = 10;         // ❌ 'for' is a reserved keyword
int my@var = 10;      // ❌ @ is not allowed (only _ and $ are special chars allowed)
----------------------------------------------------------------------------------
//These are technically allowed by the compiler but you should never do them:
int _score = 99;    // compiles, but underscore prefix is for internal/generated code
int $price = 100;   // compiles, but $ is conventionally for generated code (like inner classes)
int NULL = 5;       // compiles — Java is case sensitive so NULL ≠ null, but hugely confusing
----------------------------------------------------------------------------------
A fun interview trick — goto is a reserved keyword in Java even though Java doesn't use goto statements.
It was reserved to prevent confusion for C programmers switching to Java.
int goto = 5;    // ❌ ERROR — reserved keyword, even though Java has no goto
----------------------------------------------------------------------------------
//JAVA IS CASE SENSITIVE - ALWAYS

This burns beginners constantly.
int age = 25;
int Age = 30;
int AGE = 35;
int aGe = 40;

// These are FOUR completely different variables
// Java sees them as totally unrelated
System.out.println(age);  // 25
System.out.println(Age);  // 30
System.out.println(AGE);  // 35
System.out.println(aGe);  // 40
Real world bug this causes — you declare userName but then type username later. Compiler screams. Happens to everyone at least once.
----------------------------------------------------------------------------------
// REASSIGNMENT- Value Changes, Type Never Does
int score = 0;
System.out.println(score);  // 0

score = 50;
System.out.println(score);  // 50

score = score + 10;         // read current value (50), add 10, store back
System.out.println(score);  // 60

score += 5;                 // shorthand — same as score = score + 5
System.out.println(score);  // 65

score++;                    // increment by 1 — same as score = score + 1
System.out.println(score);  // 66
```

What happens in memory during reassignment:
```
int x = 10;   →   Stack: [ x = 10 ]
x = 20;       →   Stack: [ x = 20 ]   // 10 is simply overwritten and gone
For primitives, the old value is just wiped. No trace, no garbage, just replaced.
This is different from objects where things get more interesting (covered in OOP section).
----------------------------------------------------------------------------------
//MULTIPLE VARIABLE
// Separate lines — always prefer this, more readable
int x = 1;
int y = 2;
int z = 3;

// Same line, same type — allowed but only for closely related things
int x = 1, y = 2, z = 3;

// Chain assignment — same value to multiple variables
int a, b, c;
a = b = c = 10;
// Java evaluates right to left:
// c = 10, then b = c (which is 10), then a = b (which is 10)
System.out.println(a + " " + b + " " + c);  // 10 10 10
----------------------------------------------------------------------------------
//VAR - TYPE INFERENCE (JAVA 10+)
Java 10 added var which lets the compiler figure out the type from the right hand side. This is called type inference.
// Old way
int age = 25;
String name = "Rohan";
ArrayList<String> list = new ArrayList<String>();

// With var — compiler sees the right side and infers the type
var age = 25;      // compiler: "25 is an int literal, so age is int"
var name = "Rohan"; // compiler: "string literal, so name is String"
var list = new ArrayList<String>(); // cleaner, type obvious from right side
Critical thing to understand — var is NOT dynamic typing. The type is still locked at compile time. You just don't type it manually.

var age = 25;
age = 30;         // ✅ fine, still int
age = "thirty";   // ❌ ERROR — type was fixed as int the moment you wrote var age = 25

This is completely different from JavaScript's var which is dynamically typed. Don't confuse them.
Where var shines — when the type is long and obvious from context:

// Without var — redundant, you're writing HashMap<String, List<Integer>> twice
HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

// With var — clean, type is obvious from right side
var map = new HashMap<String, List<Integer>>();

Where var hurts readability — when type isn't obvious:
var result = processPayment();  // what type is this? Nobody knows without checking
var x = calculate();            // int? double? String? completely unclear

var only works for local variables — not instance variables, not method parameters, not return types:
public class BankAccount {
    var balance = 1000.0;        // ❌ ERROR — var not allowed for instance variables

    public var getBalance() {    // ❌ ERROR — var not allowed as return type
        var amount = 500.0;      // ✅ fine — local variable inside method
        return amount;
    }
}

//The Reserved Keywords — All 53

You cannot use any of these as variable names. The compiler blocks them all:
abstract   assert     boolean    break      byte
case       catch      char       class      const
continue   default    do         double     else
enum       extends    final      finally    float
for        goto       if         implements import
instanceof int        interface  long       native
new        package    private    protected  public
return     short      static     strictfp   super
switch  synchronized  this       throw      throws
transient  try        var        void       volatile
while      true       false      null

Note — true, false, and null are technically literals not keywords, but you still can't use them as variable names.
Note — const and goto are reserved but unused in Java. They exist purely to prevent C/C++ programmers from accidentally using them thinking they work like in C.

----------------------------------------------------------------------------------
Real World Variable Usage — Bank Account Example
Let's put it all together with something real:
public class BankAccount {

    // Instance variables — get default values (0, false, null)
    private String accountHolder;   // default: null
    private double balance;         // default: 0.0
    private boolean isPremium;      // default: false
    private int transactionCount;   // default: 0

    public static void main(String[] args) {

        // Local variables — MUST be initialized manually
        String customerName = "Rohan Sharma";
        double initialDeposit = 50000.00;
        boolean premiumMember = true;
        int age = 28;

        // var usage — type obvious from right side
        var accountNumber = "ACC-2024-001";  // String
        var minBalance = 500.0;              // double
        var maxTransactions = 100;           // int

        // Expression
        double gst = initialDeposit * 0.18;
        double totalAfterGST = initialDeposit + gst;

        System.out.println("Customer: " + customerName);
        System.out.println("Deposit: " + initialDeposit);
        System.out.println("GST (18%): " + gst);
        System.out.println("Total: " + totalAfterGST);
        System.out.println("Premium: " + premiumMember);
    }
}

// Output:
// Customer: Rohan Sharma
// Deposit: 50000.0
// GST (18%): 9000.0
// Total: 59000.0
// Premium: true

----------------------------------------------------------------------------------
🔥 Tricky Interview Questions
Q1. What is the output?
int x = 5;
int y = x;
y = 10;
System.out.println(x);
System.out.println(y);
Output is 5 and 10.
Why? Because int is a primitive type. When you do y = x, the VALUE of x (which is 5) is copied into y. After that, x and y are completely independent boxes. Changing y has zero effect on x.
This is called pass by value for primitives. This is one of Java's most important concepts and comes up in almost every interview.

----------------------------------------------------------------------------------
Q2. Will this compile?
public static void main(String[] args) {
    int age;
    if (true) {
        age = 25;
    }
    System.out.println(age);
}
This actually DOES compile. The compiler is smart enough to see that if (true) will always execute, so age is definitely initialized before println. But change it to:
public static void main(String[] args) {
    int age;
    if (someCondition) {   // compiler doesn't know if this runs
        age = 25;
    }
    System.out.println(age);  // ❌ ERROR — might not be initialized
}
Now the compiler doesn't know if the if-block runs. age might be uninitialized. Compile error.

----------------------------------------------------------------------------------
Q3. What is the output?
int a, b, c;
a = b = c = 5;
a = 10;
b = b + 1;
System.out.println(a + " " + b + " " + c);

Output: 10 6 5
Chain assignment set all to 5. Then a changed to 10. Then b changed to 6. c was never touched, stays 5. Primitives are independent — changing one never affects another.

----------------------------------------------------------------------------------
Q4. Is var a keyword in Java?
Trick question — var is technically NOT a reserved keyword. It's a context-sensitive identifier (also called a reserved type name). This means you can actually use var as a variable name:

var var = 10;   // ✅ this actually compiles — var used as variable name
int var = 10;   // ✅ also compiles
But this is horrible practice. Never do it. Just know the interview answer — var is NOT a keyword, it's a reserved type name.
----------------------------------------------------------------------------------
Q5. What is the output?
int x = 10;
x = x + x;
x = x * x;
x = x - 50;
System.out.println(x);

Step by step:
x starts as 10
x = 10 + 10 = 20
x = 20 * 20 = 400
x = 400 - 50 = 350
Output: 350

----------------------------------------------------------------------------------
Q6. Which are valid variable names?
int _age = 25;       // ✅ valid (underscore allowed at start)
int $price = 100;    // ✅ valid (dollar sign allowed)
int 1number = 5;     // ❌ starts with digit
int my-var = 5;      // ❌ hyphen is minus operator
int null = 5;        // ❌ null is reserved literal
int NULL = 5;        // ✅ valid — Java is case sensitive! NULL ≠ null
int goto = 5;        // ❌ goto is reserved keyword
int String = 5;      // ✅ valid — String with capital S is a class name not a keyword
                     // but terrible practice obviously
                     
----------------------------------------------------------------------------------
Q7. Real Interview — What's the difference between variable declaration, initialization, and instantiation?
Declaration → int age; — tells compiler variable exists, reserves memory space
Initialization → age = 25; — puts a value into that space for the first time
Instantiation → BankAccount acc = new BankAccount(); — specifically for objects, creates a new object in Heap memory using new keyword
For primitives there's no instantiation — only declaration and initialization. For objects all three steps can happen together:
BankAccount acc = new BankAccount();
//    ^       ^          ^
// declaration  name   instantiation (creates object in Heap)
// (together this is also initialization since acc now points to the object)

----------------------------------------------------------------------------------
Key Takeaways
A variable is a named memory location that stores data temporarily while the program runs.
Every variable needs a type, a name, and a value — type cannot change, value can.
Declaration creates the box. Initialization fills it. Must do both before using a local variable.
Java is statically typed — types are fixed at compile time, not runtime.
Java is case sensitive — age, Age, AGE are three different variables.
Primitive assignment copies the value — two variables become completely independent.
var (Java 10+) is type inference — compiler figures out the type, but it's still static. NOT like Python/JavaScript dynamic typing.
var is not a keyword — it's a context-sensitive identifier (common interview trick question).
Local variables have no default values — must initialize before use. Instance variables do get defaults.
----------------------------------------------------------------------------------

````
