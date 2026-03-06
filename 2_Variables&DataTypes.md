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
2.2 Primitive Data Types

// THE CORE IDEA
Java has two categories of data types — primitive and non-primitive (reference types).
Primitive types are the most basic building blocks. They are not objects. They don't have methods.
They live directly on the Stack memory. They are fast, lightweight, and fixed in size.
Java has exactly 8 primitive types — no more, no less. Every other type in Java is built on top of these 8.
Real world connection — when you're building a food delivery app:
int deliveryTimeMinutes = 35;        // whole number — minutes
double distanceKm = 4.7;             // decimal number — kilometers
boolean isRestaurantOpen = true;     // yes/no — open or closed
char orderStatus = 'P';              // single character — P for Pending

All four of these are primitives. Simple, direct, fast.

----------------------------------------------------------------------------------
THE 8 PRIMITIVE TYPES — OVERVIEW
Before going deep into each, here's the full picture.
Instead of a table, think of it like a family tree organized by what they store:
Whole Numbers (integers) — 4 types:
byte → smallest → 1 byte → range -128 to 127
short → small → 2 bytes → range -32,768 to 32,767
int → default → 4 bytes → range -2.1 billion to 2.1 billion
long → large → 8 bytes → range -9.2 quintillion to 9.2 quintillion
Decimal Numbers (floating point) — 2 types:
float → less precise → 4 bytes → ~7 decimal digits of precision
double → more precise → 8 bytes → ~15 decimal digits of precision
Single Character — 1 type:
char → 2 bytes → stores one Unicode character
True/False — 1 type:
boolean → stores only true or false → size not precisely defined by JVM
----------------------------------------------------------------------------------
// INT — THE DEFAULT WHOLE NUMBER
int is the workhorse of Java. When you need a whole number and you're not sure which type to use — use int. Java itself defaults to int for integer literals.
Size is 4 bytes = 32 bits.
Range is -2,147,483,648 to 2,147,483,647 (roughly -2.1 billion to +2.1 billion).
Why that exact range? Because 32 bits, with 1 bit reserved for the sign (positive/negative), gives you 2^31 values in each direction.

int age = 25;
int salary = 75000;
int population = 1400000000;   // 1.4 billion — fits in int
int maxInt = Integer.MAX_VALUE; // 2147483647
int minInt = Integer.MIN_VALUE; // -2147483648

System.out.println(Integer.MAX_VALUE);  // 2147483647
System.out.println(Integer.MIN_VALUE);  // -2147483648

Real world — most counters, ages, quantities, IDs, scores all fit comfortably in int. It's your go-to for whole numbers.
----------------------------------------------------------------------------------
INTEGER OVERFLOW — THE SILENT KILLER
This is one of the most important concepts and a classic interview question. What happens when you go beyond int's range?
Java doesn't throw an error. It doesn't crash. It wraps around silently.
int maxValue = Integer.MAX_VALUE;  // 2147483647
System.out.println(maxValue);      // 2147483647
System.out.println(maxValue + 1);  // -2147483648  ← WRAPS AROUND!

Why? Think of it like a car's odometer. When it hits 999999, the next number is 000000.
Same thing here — when int hits its max (all 32 bits are 1), adding 1 flips all bits and you get the minimum value.
This is called integer overflow and it has caused real disasters in software history.
 The Ariane 5 rocket explosion in 1996 was caused by a numeric overflow. Boeing's 787 had a bug where the electrical generators would lose power after 248 days due to integer overflow.
// Real world danger — calculating file size
int fileSizeBytes = 3 * 1024 * 1024 * 1024;  // trying to store 3GB in bytes
// 3 * 1024 * 1024 * 1024 = 3,221,225,472
// But int max is 2,147,483,647
// Result: -1073741824  ← WRONG! Overflowed silently
System.out.println(fileSizeBytes);  // -1073741824

// Fix — use long
long fileSizeBytesCorrect = 3L * 1024 * 1024 * 1024;
System.out.println(fileSizeBytesCorrect);  // 3221225472 ✅
----------------------------------------------------------------------------------
LONG — WHEN INT IS NOT ENOUGH
Use long when your number exceeds int's ~2.1 billion limit.
Size is 8 bytes = 64 bits.
Range is -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (roughly ±9.2 quintillion).
Critical rule — when assigning a long literal larger than int's range, you MUST add L suffix. Without it, Java reads the number as int first, overflows it, then stores the overflowed value.

long population = 8000000000L;    // 8 billion — needs L suffix
long distanceToSun = 149597870700L; // 149 billion meters — needs L
long normalNumber = 1000;          // ✅ no L needed — fits in int, auto-promoted to long

// Danger without L:
long wrong = 8000000000;   // ❌ COMPILE ERROR — Java reads 8000000000 as int first
                           // 8000000000 doesn't fit in int → compile error

long alsoWrong = 3000000000;  // ❌ same issue
long correct = 3000000000L;   // ✅ L tells Java this is a long literal

Real world uses of long — timestamps (milliseconds since 1970), database primary keys in large systems, file sizes in bytes, phone numbers in some countries, national ID numbers.
long currentTimeMillis = System.currentTimeMillis();  // milliseconds since Jan 1, 1970
System.out.println(currentTimeMillis);  // something like 1708934400000

long phoneNumber = 919876543210L;  // Indian phone with country code
long orderId = 1234567890123L;     // large e-commerce order ID
----------------------------------------------------------------------------------
// BYTE — THE TINY ONE
Size is 1 byte = 8 bits.
Range is -128 to 127.
You'll rarely declare byte variables directly in application code. It's mainly used for:
Raw binary data — reading files, network streams, images
Memory optimization when storing millions of small values in arrays
Working with protocols that specify exact byte sizes
byte age = 25;          // ✅ 25 fits in byte
byte score = 100;       // ✅ 100 fits in byte
byte tooBig = 200;      // ❌ COMPILE ERROR — 200 exceeds byte max of 127

// Common real use — raw data
byte[] imageData = new byte[1024 * 1024];  // 1MB buffer for image
byte[] networkPacket = new byte[512];       // network packet buffer

// Byte overflow example
byte b = 127;
b++;
System.out.println(b);  // -128 — wraps around just like int
----------------------------------------------------------------------------------
SHORT — THE FORGOTTEN ONE
Size is 2 bytes = 16 bits.
Range is -32,768 to 32,767.
Honest truth — short is almost never used in modern Java. It exists mainly for legacy code, interfacing with certain hardware, and protocols that specifically use 16-bit values. The memory savings over int are so small in most applications that it's not worth it.

short year = 2024;         // ✅ fits in short
short temperature = -40;   // ✅ fits in short
short tooBig = 40000;      // ❌ COMPILE ERROR — exceeds short max of 32767
----------------------------------------------------------------------------------
// DOUBLE — THE DEFAULT DECIMAL
double is to decimal numbers what int is to whole numbers — the default choice.
Size is 8 bytes = 64 bits.
Precision is approximately 15-16 significant decimal digits.
Java defaults all decimal literals to double. So 3.14 in your code is automatically a double.
double price = 499.99;
double pi = 3.14159265358979;
double gstRate = 0.18;
double salary = 75000.50;

// Java defaults decimal literals to double
double x = 3.14;    // ✅ 3.14 is a double literal by default

Real world — prices, distances, rates, percentages, coordinates, scientific calculations.
Basically any decimal number in business or science.
// E-commerce calculation
double itemPrice = 1299.00;
double discount = 0.10;        // 10% discount
double discountAmount = itemPrice * discount;   // 129.9
double finalPrice = itemPrice - discountAmount; // 1169.1
double gst = finalPrice * 0.18;                // 210.438
double totalPayable = finalPrice + gst;        // 1379.538
----------------------------------------------------------------------------------
THE FLOATING POINT TRAP — CRITICAL FOR INTERVIEWS
This is the single most important thing to know about doubles and it trips up even experienced developers.
double a = 0.1;
double b = 0.2;
System.out.println(a + b);         // NOT 0.3 — prints 0.30000000000000004
System.out.println(a + b == 0.3);  // false ← SHOCKING but true

Why? Because computers store numbers in binary. And 0.1 cannot be represented exactly in binary — just like 1/3 cannot be represented exactly in decimal (0.333333...). So 0.1 in binary is actually 0.1000000000000000055511151231257827021181583404541015625...
This means never use double for money calculations in production. This is a real bug that has caused financial calculation errors in banking software.
The fix is BigDecimal:
import java.math.BigDecimal;

BigDecimal price = new BigDecimal("0.1");    // NOTE: use String constructor
BigDecimal tax = new BigDecimal("0.2");
BigDecimal total = price.add(tax);
System.out.println(total);  // 0.3  ✅ exact

For interview: if someone asks "how do you handle money in Java?" — answer is always BigDecimal, never double or float.
----------------------------------------------------------------------------------
FLOAT — LESS PRECISE DECIMAL
Size is 4 bytes = 32 bits.
Precision is approximately 6-7 significant decimal digits — roughly half of double.
You MUST add f or F suffix to float literals. Without it, Java treats the decimal as double and you get a compile error trying to store it in a float.
float temperature = 36.6f;    // ✅ f suffix tells Java this is float
float discount = 0.15f;       // ✅
float price = 499.99;         // ❌ COMPILE ERROR — 499.99 is double, can't auto-store in float
float price = 499.99f;        // ✅

// Precision difference
float f = 1.23456789f;
double d = 1.23456789;
System.out.println(f);   // 1.2345679  ← rounded at 7 digits
System.out.println(d);   // 1.23456789 ← full precision

When to use float vs double:
float → graphics/game development (OpenGL coordinates), sensor data, situations where memory is
severely constrained and precision loss is acceptable
double → everything else — scientific, financial (actually BigDecimal), general purpose
Most professional Java code uses double exclusively and avoids float.

----------------------------------------------------------------------------------
CHAR — THE CHARACTER TYPE
char stores a single character. What makes Java's char unique is that it's 2 bytes (16 bits), not 1 byte like in C/C++. This is because Java uses Unicode (UTF-16) to support characters from all languages worldwide — English, Hindi, Chinese, Arabic, emoji.
Range is 0 to 65,535 (unsigned — no negative values).
Character literals use single quotes. Strings use double quotes. Never confuse them.

char grade = 'A';
char symbol = '@';
char digit = '5';     // this is the CHARACTER '5', not the NUMBER 5
char space = ' ';

// Unicode character
char rupee = '₹';     // Indian rupee symbol
char omega = 'Ω';     // Greek letter
char heart = '♥';     // heart symbol

// char is actually stored as an integer (Unicode value)
char c = 'A';
System.out.println(c);           // A
System.out.println((int) c);     // 65  ← Unicode value of 'A'

// You can even do arithmetic on chars
char next = (char) ('A' + 1);
System.out.println(next);        // B

// Iterating alphabet
for (char ch = 'a'; ch <= 'z'; ch++) {
    System.out.print(ch + " ");  // a b c d e f ... z
}

Important Unicode values to memorize for interviews:
'A' is 65, 'Z' is 90
'a' is 97, 'z' is 122
'0' is 48, '9' is 57
These come up constantly in string manipulation problems on LeetCode.

// Convert char digit to int value — classic interview trick
char digitChar = '7';
int digitValue = digitChar - '0';  // 55 - 48 = 7
System.out.println(digitValue);    // 7

// Convert lowercase to uppercase
char lower = 'g';
char upper = (char) (lower - 32);   // 'g'(103) - 32 = 71 = 'G'
System.out.println(upper);          // G
----------------------------------------------------------------------------------
BOOLEAN — TRUE OR FALSE, NOTHING ELSE
boolean stores exactly one of two values — true or false. That's it. No 0 or 1 like in C. No null. No "yes"/"no". Just true or false.
The JVM spec doesn't define an exact size for boolean. In practice, individual booleans are usually stored as a full int (4 bytes) for alignment reasons, but boolean[] arrays use 1 byte per element.

boolean isLoggedIn = true;
boolean hasPremium = false;
boolean isEligible = age >= 18;          // expression result
boolean isWeekend = day.equals("Saturday") || day.equals("Sunday");

// Real world — feature flags in apps
boolean isDarkModeEnabled = true;
boolean isPaymentGatewayLive = false;
boolean showNewDashboard = userGroup.equals("beta");

You cannot assign numbers to boolean in Java — unlike C where 0 is false and anything else is true:
boolean b = 1;      // ❌ COMPILE ERROR — Java doesn't allow this
boolean b = true;   // ✅ only way
int x = 5;
if (x) { }          // ❌ COMPILE ERROR — x is not boolean
if (x != 0) { }     // ✅ this is how Java does it
```

This is actually a safety feature — in C, `if (x = 5)` (assignment instead of comparison) compiles and always evaluates to true. In Java the compiler catches it.

---

## TYPE CASTING — CONVERTING BETWEEN PRIMITIVES

Sometimes you need to convert one primitive type to another. Java handles this in two ways.

**Widening Casting (Automatic)** — going from smaller to larger type. Java does this automatically, no data loss possible.
```
byte → short → int → long → float → double

int myInt = 100;
long myLong = myInt;      // ✅ automatic — int to long, no data loss
double myDouble = myInt;  // ✅ automatic — int to double, no data loss
float myFloat = myInt;    // ✅ automatic — int to float

System.out.println(myLong);    // 100
System.out.println(myDouble);  // 100.0

Narrowing Casting (Manual) — going from larger to smaller type. You must explicitly cast. Data loss may occur — Java warns you by requiring explicit syntax.
double price = 9.99;
int truncated = (int) price;   // manual cast — decimal part chopped off
System.out.println(truncated); // 9  ← 0.99 is GONE, not rounded

long bigNumber = 1234567890123L;
int smallNumber = (int) bigNumber;  // manual cast — data loss
System.out.println(smallNumber);   // 1912276171  ← completely different number!

double d = 3.99;
int i = (int) d;   // truncates, does NOT round
System.out.println(i);  // 3  ← not 4

Important — casting truncates, it does NOT round. (int) 3.99 gives 3, not 4. This trips people up in interviews.
// If you want rounding, use Math.round()
double d = 3.99;
long rounded = Math.round(d);   // 4 ✅
System.out.println(rounded);
----------------------------------------------------------------------------------
DEFAULT VALUES — PRIMITIVES AS INSTANCE VARIABLES
When primitives are instance variables (inside a class, outside methods), Java assigns them default values automatically. When they're local variables (inside a method), NO default — you must initialize.
Instance variable defaults:
byte → 0
short → 0
int → 0
long → 0L
float → 0.0f
double → 0.0
char → '\u0000' (null character)
boolean → false

public class Student {
    int marks;        // default 0
    double gpa;       // default 0.0
    boolean passed;   // default false
    char grade;       // default '\u0000'

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.marks);   // 0
        System.out.println(s.gpa);     // 0.0
        System.out.println(s.passed);  // false
        System.out.println(s.grade);   // (blank — null character)
    }
}
----------------------------------------------------------------------------------
//WRAPPER CLASSES — PRIMITIVES AS OBJECTS
Every primitive has a corresponding Wrapper class in Java. This matters because Java's Collections (ArrayList, HashMap etc.)
cannot store primitives — they need objects.
int → Integer
double → Double
boolean → Boolean
char → Character
byte → Byte
short → Short
long → Long
float → Float

// Can't do this — ArrayList needs objects not primitives
ArrayList<int> numbers = new ArrayList<int>();  // ❌ COMPILE ERROR

// Use wrapper class instead
ArrayList<Integer> numbers = new ArrayList<Integer>();  // ✅
numbers.add(10);   // 10 is auto-boxed to Integer object

Autoboxing — Java automatically converts primitive to wrapper object when needed.
Unboxing — Java automatically converts wrapper object back to primitive when needed.

Integer obj = 42;    // autoboxing — int 42 → Integer object automatically
int val = obj;       // unboxing — Integer object → int automatically

// Behind the scenes Java is doing:
Integer obj = Integer.valueOf(42);   // autoboxing
int val = obj.intValue();            // unboxing
----------------------------------------------------------------------------------
Where Autoboxing Is Required (Very Important)
1️⃣ Java Collections

Collections store objects, not primitives.

Example with ArrayList

import java.util.ArrayList;

public class Example {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);  // Autoboxing: int -> Integer
        list.add(20);

        int value = list.get(0);  // Unboxing: Integer -> int

        System.out.println(value);
    }
}

Without autoboxing:
list.add(Integer.valueOf(10));
int value = list.get(0).intValue();
Autoboxing makes it clean and readable.

Integer obj = 42;    // autoboxing — int 42 → Integer object automatically
int val = obj;       // unboxing — Integer object → int automatically

// Behind the scenes Java is doing:
Integer obj = Integer.valueOf(42);   // autoboxing
int val = obj.intValue();            // unboxing

Useful methods on wrapper classes:
// Parsing strings to numbers — extremely common in real code
int age = Integer.parseInt("25");         // String "25" → int 25
double price = Double.parseDouble("9.99"); // String "9.99" → double 9.99
boolean b = Boolean.parseBoolean("true"); // String "true" → boolean true

// Number to string
String s = Integer.toString(42);   // int 42 → String "42"
String s2 = String.valueOf(42);    // same thing

// Useful constants
System.out.println(Integer.MAX_VALUE);   // 2147483647
System.out.println(Integer.MIN_VALUE);   // -2147483648
System.out.println(Double.MAX_VALUE);    // 1.7976931348623157E308
----------------------------------------------------------------------------------
🔥 TRICKY INTERVIEW QUESTIONS
Q1. What is the output?
int a = Integer.MAX_VALUE;
int b = a + 1;
System.out.println(b);
Output is -2147483648. Integer overflow — MAX_VALUE + 1 wraps to MIN_VALUE. Classic trap.
----------------------------------------------------------------------------------
Q2. What is the output?
double x = 0.1 + 0.2;
System.out.println(x);
System.out.println(x == 0.3);
Output is 0.30000000000000004 and false. Floating point precision issue. 0.1 and 0.2 can't be represented exactly in binary.
Their sum has a tiny error. This is why you never use == to compare doubles.

Correct way to compare doubles:
double x = 0.1 + 0.2;
double epsilon = 0.0000001;
System.out.println(Math.abs(x - 0.3) < epsilon);  // true ✅
----------------------------------------------------------------------------------
Q3. What is the output?
int x = 5;
double y = x;        // widening — automatic
int z = (int) 9.99;  // narrowing — manual cast
System.out.println(y);  // 5.0
System.out.println(z);  // 9 — truncated, NOT rounded

Output is 5.0 and 9. The decimal cast truncates, does not round.
----------------------------------------------------------------------------------
Q4. Will this compile?
byte b = 127;
b = b + 1;

No — compile error. Here's why — b + 1 is evaluated as int + int = int. You can't store int back into byte without explicit cast. Even though the value 128 would just barely overflow a byte, the compiler doesn't evaluate the expression — it just sees "int result going into byte" and refuses.
byte b = 127;
b = (byte)(b + 1);  // ✅ explicit cast — compiles, result is -128 (overflow)
b++;                // ✅ also works — ++ operator handles the cast internally
----------------------------------------------------------------------------------
Q5. What is the size of boolean in Java?
Trick question — the Java specification does not define an exact size for boolean. The JVM spec says it depends on implementation. In most JVMs, a standalone boolean is stored as a 4-byte int for alignment. In a boolean array, each element is typically 1 byte. There is no guaranteed answer — the correct interview answer is "it is implementation dependent, not specified by the JVM spec."
----------------------------------------------------------------------------------
Q6. What is the output?
char c = 'A';
c = (char)(c + 1);
System.out.println(c);  // B

int x = 'A' + 1;
System.out.println(x);  // 66

System.out.println('A' + 1);   // 66 — int result
System.out.println("" + 'A' + 1); // A1 — String concatenation
System.out.println('A' + "" + 1); // A1 — String concatenation

The last two are classic string concatenation traps. Once a String is in the expression, everything after is concatenated as string, not added as numbers.

----------------------------------------------------------------------------------
Q7. What is autoboxing and when can it cause problems?
Autoboxing is automatic conversion between primitive and wrapper class. The problem — it can cause unexpected NullPointerException and performance issues.
Integer count = null;   // wrapper can be null
int value = count;      // ❌ NullPointerException — unboxing null throws exception

// Performance trap
for (int i = 0; i < 1000000; i++) {
    Integer sum = 0;        // using Integer instead of int
    sum = sum + i;          // each iteration: unbox sum, add i, autobox result
}
// Creates 1 million Integer objects unnecessarily — huge GC pressure
// Always use int not Integer for local variables
----------------------------------------------------------------------------------
KEY TAKEAWAYS
Java has exactly 8 primitive types — byte, short, int, long, float, double, char, boolean.
int is the default for whole numbers, double is the default for decimals.
Always add L suffix for long literals beyond int range, and f suffix for float literals.
Integer overflow happens silently — no error, no warning, just wraps around. Real bugs have crashed rockets and caused financial errors.
Never use double or float for money — use BigDecimal with String constructor.
Casting truncates, it does NOT round. (int) 3.99 = 3, not 4.
Widening casting (small to large) is automatic. Narrowing casting (large to small) needs explicit cast and may lose data.
char in Java is 2 bytes (Unicode), not 1 byte like in C/C++. 'A' = 65, 'a' = 97, '0' = 48.
boolean only accepts true or false — not 0/1 like in C.
Every primitive has a wrapper class (int→Integer etc.) needed for Collections and generics.
Autoboxing is automatic but can cause NullPointerException if wrapper is null, and performance issues if overused in loops.
----------------------------------------------------------------------------------
2.3 Type Casting — Converting Between Primitive Types
THE CORE IDEA:
Imagine you're building a shopping app. You have a price stored as double (because prices have decimals),
but at some point you need to display just the whole number part — no decimals.
You need to convert a double into an int. That conversion is called type casting.
Type casting means taking a value of one data type and converting it to another data type.
Java handles this in two completely different ways depending on which direction you're going —
are you going to a bigger type or a smaller type? That single question determines everything.

int myInt = 100;
double myDouble = myInt;    // going bigger — automatic, Java handles it
int back = (int) myDouble;  // going smaller — manual, you handle it
```

----------------------------------------------------------------------------------

## TWO TYPES OF CASTING

Think of it like water and containers.

If you pour water from a small glass into a big bucket — easy, nothing spills, no effort needed. That's **widening**.

If you pour water from a big bucket into a small glass — you have to be careful, some water will spill. 
That's **narrowing**. The spilled water is the lost data.

----------------------------------------------------------------------------------

## WIDENING CASTING — AUTOMATIC

Widening means going from a **smaller type to a larger type**. Java does this **automatically** with no syntax needed. No data is lost because the bigger type can fully contain everything the smaller type holds.

The widening hierarchy goes in one direction only:

byte → short → int → long → float → double

Each arrow means "can be automatically widened to". Left is smaller, right is bigger.
byte b = 42;
short s = b;      // byte → short, automatic
int i = s;        // short → int, automatic
long l = i;       // int → long, automatic
float f = l;      // long → float, automatic
double d = f;     // float → double, automatic

System.out.println(b);  // 42
System.out.println(s);  // 42
System.out.println(i);  // 42
System.out.println(l);  // 42
System.out.println(f);  // 42.0
System.out.println(d);  // 42.0
Real world example — you're tracking scores in a game. Initially you used int but later
realized scores can go beyond 2 billion. You switch to long. All existing int values automatically 
widen to long with no changes needed anywhere.

int currentScore = 150000;
long highScore = currentScore;   // automatic widening — safe, no data loss
System.out.println(highScore);   // 150000

THE SNEAKY PRECISION LOSS IN WIDENING
Here's something almost nobody talks about but interviewers love — 
widening can still cause precision loss when going from long to float or long to double.
Wait, how? If widening is safe, how can there be precision loss?
Because float is 4 bytes and long is 8 bytes. Even though float's range is larger than long's range, float
only has about 7 digits of precision. A long can have up to 19 digits. So large long values lose precision when widened to float.


````
