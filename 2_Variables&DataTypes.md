# 2.1 What is a Variable?

---

## THE CORE IDEA

Imagine you're building a banking app. A customer logs in and you need to store their name, age, account balance, and whether they're a premium member or not. Where do you store all this while the program is running?

**In variables.**

A variable is a **named container in memory** that holds data while your program runs. The moment your program ends, variables are gone. They live in RAM — fast, temporary storage.

Think of RAM like a huge shelf with millions of tiny boxes. Each box can hold one piece of data. A variable is just you saying — *"hey JVM, give me one of those boxes, label it 'age', and put the value 25 in it."*

```java
int age = 25;
// "Give me a box, label it 'age', put 25 in it"
```

---

## WHAT HAPPENS IN MEMORY — FOR REAL

When you write `int age = 25`, Java does three things physically:

**Step 1** — sees the type `int` → goes to Stack memory → reserves exactly 4 bytes

**Step 2** — labels those 4 bytes with the name `age`

**Step 3** — converts 25 to binary and stores it in those 4 bytes

```
25 in binary = 00000000 00000000 00000000 00011001
               |________|________|________|________|
               byte 4   byte 3   byte 2   byte 1
```

In Stack memory it looks like this:

```
Stack Memory (your method's frame):
┌────────────────────────────┐
│  name : age                │
│  type : int (4 bytes)      │
│  value: 25                 │
│  address: 0x7fff5ab2       │  ← you NEVER see this in Java
└────────────────────────────┘
```

> **Notice** — you never see the memory address. In C/C++ you'd use pointers to access `0x7fff5ab2` directly. Java hides this completely. The JVM manages memory for you. This is why Java has no memory corruption bugs like C does — you simply can't access raw addresses.

---

## THREE THINGS EVERY VARIABLE MUST HAVE

Every single variable in Java has exactly **three things** — no exceptions:

- **Type** → what kind of data it holds (`int`, `String`, `double`, `boolean`...)
- **Name** → what you call it in your code
- **Value** → the actual data stored inside

```java
int    age    =   25;
// ^    ^          ^
// Type Name      Value
```

Java is **statically typed** — meaning the type is fixed at compile time. You declare it once, it stays that type forever.

```java
int age = 25;
age = 30;              // ✅ fine — same type, different value
age = "twenty five";   // ❌ ERROR — type was int, can't store String now
```

> This is different from Python where you can do `age = 25` then `age = "hello"` freely. Java says no — pick a type and stick with it. This catches a whole class of bugs at compile time **before your code even runs**.

---

## DECLARATION VS INITIALIZATION VS BOTH

These three terms come up **constantly in interviews**. Know the difference cold.

**Declaration** — you're telling Java *"this variable exists, this is its type, this is its name."* No value yet. Just creating the labeled box.

```java
int age;
// box created, labeled 'age', but EMPTY
```

**Initialization** — you're putting a value in for the first time.

```java
age = 25;
// putting 25 into the box for the first time
```

**Declaration + Initialization together** — most common, do both on one line.

```java
int age = 25;
// box created AND filled in one shot
```

**Re-assignment** — changing the value after it's already been set.

```java
int age = 25;   // declaration + initialization
age = 30;       // re-assignment — 25 is gone, 30 replaces it
```

Now here's the **critical rule** that trips up beginners:

> **Local variables in Java have NO default value. You MUST initialize them before use.**

```java
public static void main(String[] args) {
    int age;
    System.out.println(age);  // ❌ COMPILE ERROR
    // "variable age might not have been initialized"
}
```

The compiler refuses to run this. It sees `age` was declared but never given a value, and printing it would be reading garbage memory. Java won't allow that.

> Compare this to **instance variables** (variables inside a class but outside methods) — those DO get default values automatically. `int` gets `0`, `boolean` gets `false`, `String` gets `null`. We'll cover that in **2.7**.

---

## VARIABLE VS LITERAL VS EXPRESSION — KNOW THE DIFFERENCE

These three terms appear constantly in Java documentation and interviews.

- **Variable** → a named memory location. Its value can change.
- **Literal** → a fixed hardcoded value written directly in your source code. `25`, `"Rohan"`, `true`, `3.14` — these are all literals. They're baked into your code, they never change.
- **Expression** → anything that evaluates to a value. It can be a combination of variables, literals, and operators.

```java
int x = 5;           // x is a variable,  5 is a literal
int y = 10;          // y is a variable,  10 is a literal
int z = x + y;       // z is a variable,  x + y is an expression
boolean b = x > 3;   // b is a variable,  x > 3 is an expression (evaluates to true)
```

**Real world connection** — in a payment app:

```java
double itemPrice = 499.99;            // variable
double gstRate = 0.18;                // variable
double gst = itemPrice * gstRate;     // expression — evaluates to 89.998
double totalAmount = itemPrice + gst; // expression
```

---

## NAMING RULES — WHAT THE COMPILER ENFORCES

The compiler will flat out reject these — not convention, not preference, **hard errors**:

```java
int 2fast = 10;       // ❌ cannot start with a digit
int first-name = 10;  // ❌ hyphen is subtraction operator, not allowed in names
int my name = 10;     // ❌ space breaks it into two tokens
int class = 10;       // ❌ 'class' is a reserved keyword
int null = 10;        // ❌ 'null' is a reserved literal
int for = 10;         // ❌ 'for' is a reserved keyword
int my@var = 10;      // ❌ @ is not allowed (only _ and $ are special chars allowed)
```

These are technically **allowed** by the compiler but you should **never** do them:

```java
int _score = 99;    // compiles, but underscore prefix is for internal/generated code
int $price = 100;   // compiles, but $ is conventionally for generated code (like inner classes)
int NULL = 5;       // compiles — Java is case sensitive so NULL ≠ null, but hugely confusing
```

> **Fun interview trick** — `goto` is a reserved keyword in Java even though Java doesn't use goto statements. It was reserved to prevent confusion for C programmers switching to Java.

```java
int goto = 5;    // ❌ ERROR — reserved keyword, even though Java has no goto
```

---

## JAVA IS CASE SENSITIVE — ALWAYS

This burns beginners constantly.

```java
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
```

> **Real world bug this causes** — you declare `userName` but then type `username` later. Compiler screams. Happens to everyone at least once.

---

## REASSIGNMENT — VALUE CHANGES, TYPE NEVER DOES

```java
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
```

> For **primitives**, the old value is just wiped. No trace, no garbage, just replaced. This is different from objects where things get more interesting — covered in the OOP section.

---

## MULTIPLE VARIABLES

```java
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
```

---

## VAR — TYPE INFERENCE (JAVA 10+)

Java 10 added `var` which lets the compiler **figure out the type** from the right hand side. This is called **type inference**.

```java
// Old way — explicit types
int age = 25;
String name = "Rohan";
ArrayList<String> list = new ArrayList<String>();

// With var — compiler infers the type from the right side
var age = 25;       // compiler: "25 is an int literal, so age is int"
var name = "Rohan"; // compiler: "string literal, so name is String"
var list = new ArrayList<String>(); // cleaner, type obvious from right side
```

**Critical thing to understand** — `var` is **NOT** dynamic typing. The type is still locked at compile time. You just don't type it manually.

```java
var age = 25;
age = 30;          // ✅ fine — still int
age = "thirty";    // ❌ ERROR — type was fixed as int the moment you wrote var age = 25
```

> This is completely different from JavaScript's `var` which is dynamically typed. **Don't confuse them.**

**Where `var` shines** — when the type is long and obvious from context:

```java
// Without var — redundant, writing HashMap<String, List<Integer>> twice
HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

// With var — clean, type is obvious from right side
var map = new HashMap<String, List<Integer>>();
```

**Where `var` hurts readability** — when type isn't obvious:

```java
var result = processPayment();  // what type is this? Nobody knows without checking
var x = calculate();            // int? double? String? completely unclear
```

`var` only works for **local variables** — not instance variables, not method parameters, not return types:

```java
public class BankAccount {
    var balance = 1000.0;        // ❌ ERROR — var not allowed for instance variables

    public var getBalance() {    // ❌ ERROR — var not allowed as return type
        var amount = 500.0;      // ✅ fine — local variable inside method
        return amount;
    }
}
```

---

## THE 53 RESERVED KEYWORDS — CANNOT USE AS VARIABLE NAMES

```
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
```

> **Note** — `true`, `false`, and `null` are technically **literals** not keywords, but you still can't use them as variable names.

> **Note** — `const` and `goto` are reserved but **unused** in Java. They exist purely to prevent C/C++ programmers from accidentally using them thinking they work like in C.

---

## REAL WORLD VARIABLE USAGE — BANK ACCOUNT EXAMPLE

```java
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

        // Expressions
        double gst = initialDeposit * 0.18;
        double totalAfterGST = initialDeposit + gst;

        System.out.println("Customer: "  + customerName);    // Rohan Sharma
        System.out.println("Deposit: "   + initialDeposit);  // 50000.0
        System.out.println("GST (18%): " + gst);             // 9000.0
        System.out.println("Total: "     + totalAfterGST);   // 59000.0
        System.out.println("Premium: "   + premiumMember);   // true
    }
}
```

---

## 🔥 TRICKY INTERVIEW QUESTIONS

### Q1. What is the output?

```java
int x = 5;
int y = x;
y = 10;
System.out.println(x);
System.out.println(y);
```

**Output: 5 and 10**

Because `int` is a **primitive type**. When you do `y = x`, the **VALUE** of x (which is 5) is copied into y. After that, x and y are completely independent boxes. Changing y has zero effect on x.

> This is called **pass by value** for primitives. One of Java's most important concepts and comes up in almost every interview.

---

### Q2. Will this compile?

```java
public static void main(String[] args) {
    int age;
    if (true) {
        age = 25;
    }
    System.out.println(age);
}
```

**Yes — this compiles.** The compiler is smart enough to see that `if (true)` will **always** execute, so `age` is definitely initialized. But change it to:

```java
public static void main(String[] args) {
    int age;
    if (someCondition) {          // compiler doesn't know if this runs
        age = 25;
    }
    System.out.println(age);      // ❌ ERROR — might not be initialized
}
```

Now the compiler doesn't know if the if-block runs. Compile error.

---

### Q3. What is the output?

```java
int a, b, c;
a = b = c = 5;
a = 10;
b = b + 1;
System.out.println(a + " " + b + " " + c);
```

**Output: `10 6 5`**

Chain assignment set all three to 5. Then `a` changed to 10. Then `b` changed to 6. `c` was never touched — stays 5. Primitives are independent — changing one never affects another.

---

### Q4. Is `var` a keyword in Java?

**Trick question** — `var` is technically **NOT** a reserved keyword. It's a **context-sensitive identifier** (also called a reserved type name). This means you can actually use `var` as a variable name:

```java
var var = 10;   // ✅ this actually compiles — var used as variable name
int var = 10;   // ✅ also compiles
```

But this is horrible practice. Never do it. Just know the interview answer — **`var` is NOT a keyword, it's a reserved type name.**

---

### Q5. What is the output?

```java
int x = 10;
x = x + x;
x = x * x;
x = x - 50;
System.out.println(x);
```

**Step by step:**

```
x starts as 10
x = 10 + 10 = 20
x = 20 * 20 = 400
x = 400 - 50 = 350
```

**Output: `350`**

---

### Q6. Which are valid variable names?

```java
int _age = 25;       // ✅ valid — underscore allowed at start
int $price = 100;    // ✅ valid — dollar sign allowed
int 1number = 5;     // ❌ starts with digit
int my-var = 5;      // ❌ hyphen is minus operator
int null = 5;        // ❌ null is reserved literal
int NULL = 5;        // ✅ valid — Java is case sensitive, NULL ≠ null (but terrible practice)
int goto = 5;        // ❌ goto is reserved keyword
int String = 5;      // ✅ valid — String with capital S is a class name not a keyword
                     //    (but obviously terrible practice)
```

---

### Q7. What is the difference between variable declaration, initialization, and instantiation?

- **Declaration** → `int age;` — tells compiler variable exists, reserves memory space

- **Initialization** → `age = 25;` — puts a value into that space for the first time

- **Instantiation** → `BankAccount acc = new BankAccount();` — specifically for objects, creates a new object in Heap memory using the `new` keyword

For **primitives** there's no instantiation — only declaration and initialization. For **objects** all three steps can happen together:

```java
BankAccount acc = new BankAccount();
//    ^       ^          ^
// declaration  name   instantiation (creates object in Heap)
// (together this is also initialization since acc now points to the object)
```

---

## KEY TAKEAWAYS

- A variable is a **named memory location** that stores data temporarily while the program runs.

- Every variable needs a **type, a name, and a value** — type cannot change, value can.

- **Declaration** creates the box. **Initialization** fills it. Must do both before using a local variable.

- Java is **statically typed** — types are fixed at compile time, not runtime.

- Java is **case sensitive** — `age`, `Age`, `AGE` are three completely different variables.

- **Primitive assignment copies the value** — two variables become completely independent after copy.

- `var` (Java 10+) is **type inference** — compiler figures out the type, but it's still static typing. NOT like Python/JavaScript dynamic typing.

- `var` is **not a keyword** — it's a context-sensitive identifier. Common interview trick question.

- **Local variables have no default values** — must initialize before use. Instance variables do get defaults.

- `goto` and `const` are **reserved keywords** in Java even though they are unused — reserved to prevent C programmer confusion.

# 2.3 Type Casting — Converting Between Primitive Types

---

## THE CORE IDEA

Imagine you're building a shopping app. You have a price stored as `double` (because prices have decimals), but at some point you need to display just the whole number part — no decimals. You need to convert a `double` into an `int`. That conversion is called **type casting**.

**Type casting means taking a value of one data type and converting it to another data type.**

Java handles this in two completely different ways depending on which direction you're going — are you going to a bigger type or a smaller type? That single question determines everything.

```java
int myInt = 100;
double myDouble = myInt;    // going bigger — automatic, Java handles it
int back = (int) myDouble;  // going smaller — manual, you handle it
```

---

## TWO TYPES OF CASTING

Think of it like water and containers.

If you pour water from a **small glass** into a **big bucket** — easy, nothing spills, no effort needed. That's **Widening**.

If you pour water from a **big bucket** into a **small glass** — you have to be careful, some water will spill. That's **Narrowing**. The spilled water is the **lost data**.

---

## WIDENING CASTING — AUTOMATIC

Widening means going from a **smaller type to a larger type**. Java does this **automatically** with no syntax needed. No data is lost because the bigger type can fully contain everything the smaller type holds.

The widening hierarchy goes in one direction only:

```
byte → short → int → long → float → double
```

Each arrow means **"can be automatically widened to"**. Left is smaller, right is bigger.

```java
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
```

**Real world example** — you're tracking scores in a game. Initially you used `int` but later realized scores can go beyond 2 billion. You switch to `long`. All existing `int` values automatically widen to `long` with no changes needed anywhere.

```java
int currentScore = 150000;
long highScore = currentScore;   // automatic widening — safe, no data loss
System.out.println(highScore);   // 150000
```

---

## THE SNEAKY PRECISION LOSS IN WIDENING

Here's something almost nobody talks about but interviewers love — **widening can still cause precision loss** when going from `long` to `float` or `long` to `double`.

Wait, how? If widening is safe, how can there be precision loss?

Because `float` is 4 bytes and `long` is 8 bytes. Even though float's **range** is larger than long's range, float only has about **7 digits of precision**. A long can have up to **19 digits**. So large long values lose precision when widened to float.

```java
long bigLong = 1234567890123456789L;   // 19 digit number
float f = bigLong;                     // widening — but float only has 7 digit precision
double d = bigLong;                    // widening — double has 15 digit precision

System.out.println(bigLong);  // 1234567890123456789   ← exact
System.out.println(f);        // 1.23456794E18         ← precision lost after 7 digits
System.out.println(d);        // 1.2345678901234568E18 ← precision lost after 15 digits
```

> **Key insight** — Widening never throws an error and never overflows, but it **can still lose precision silently** when floating point types are involved. This is the automatic widening trap nobody warns you about.

---

## NARROWING CASTING — MANUAL

Narrowing means going from a **larger type to a smaller type**. Java forces you to write an explicit cast using parentheses. This is Java's way of saying — *"I know you know data might be lost. You're taking responsibility."*

**Syntax** — the target type in parentheses before the value:

```java
double price = 9.99;
int truncated = (int) price;     // explicit cast — (int) is the cast operator
System.out.println(truncated);   // 9 — decimal part is GONE
```

The narrowing direction is the reverse of widening:

```
double → float → long → int → short → byte
```

Going in this direction **always requires explicit cast**.

```java
double d = 9.78;
float f = (float) d;     // double → float
long l = (long) d;       // double → long  — truncates decimal
int i = (int) d;         // double → int   — truncates decimal
short s = (short) i;     // int → short    — possible overflow
byte b = (byte) i;       // int → byte     — possible overflow

System.out.println(f);   // 9.78
System.out.println(l);   // 9
System.out.println(i);   // 9
System.out.println(s);   // 9
System.out.println(b);   // 9
```

---

## TRUNCATION — NOT ROUNDING

This is the **single most important thing** to understand about casting decimals to integers. Java **truncates** — it chops off the decimal part entirely. It does **NOT round**.

```java
int a = (int) 3.2;   // 3   — decimal chopped
int b = (int) 3.5;   // 3   — NOT 4, still truncated
int c = (int) 3.9;   // 3   — NOT 4, still truncated
int d = (int) 3.99;  // 3   — NOT 4, still truncated
int e = (int) -3.9;  // -3  — truncates toward zero, NOT -4

System.out.println(a);  // 3
System.out.println(b);  // 3
System.out.println(c);  // 3
System.out.println(d);  // 3
System.out.println(e);  // -3
```

> **Rule** — Truncation always goes **toward zero**. So `-3.9` becomes `-3`, not `-4`.

If you actually want rounding, use `Math.round()`:

```java
double value = 3.7;
int truncated = (int) value;            // 3  — truncation
long rounded = Math.round(value);       // 4  — proper rounding

double negative = -3.7;
int truncatedNeg = (int) negative;      // -3 — toward zero
long roundedNeg = Math.round(negative); // -4 — proper rounding

System.out.println(truncated);          // 3
System.out.println(rounded);            // 4
System.out.println(truncatedNeg);       // -3
System.out.println(roundedNeg);         // -4
```

**Real world connection** — you're building an e-commerce app. A product costs ₹299.99 and you're splitting the cost equally among 3 people. You need to display each person's share as a whole number.

```java
double totalCost = 299.99;
int people = 3;
double exactShare = totalCost / people;           // 99.99666...
int displayShare = (int) exactShare;              // 99  — truncated
long roundedShare = Math.round(exactShare);       // 100 — rounded

System.out.println("Exact: "     + exactShare);    // 99.99666...
System.out.println("Truncated: " + displayShare);  // 99
System.out.println("Rounded: "   + roundedShare);  // 100
```

---

## NARROWING WITH OVERFLOW — THE DANGEROUS PART

What happens when you narrow cast a value that's **too large** for the target type? No error, no exception — Java wraps it around using the binary representation, giving you a completely unexpected number.

```java
int bigValue = 130;
byte b = (byte) bigValue;    // byte range is -128 to 127, 130 doesn't fit
System.out.println(b);       // -126 ← wraps around

int anotherBig = 1000;
byte b2 = (byte) anotherBig;
System.out.println(b2);      // -24  ← unpredictable result
```

**Why -126?** Java takes the binary representation of 130 and fits it into 8 bits:

```
130 in 32-bit binary:  00000000 00000000 00000000 10000010
Keep only last 8 bits:                             10000010
10000010 in signed 8-bit = -126
```

> **This is why narrowing is dangerous and requires explicit cast** — Java is making you acknowledge you understand the risk.

**Real world bug** — this exact issue has appeared in image processing code where pixel values (0–255) stored as `int` get incorrectly cast to `byte`, resulting in corrupted image colors.

```java
// Image processing bug
int pixelValue = 200;               // valid pixel 0-255
byte pixelByte = (byte) pixelValue; // 200 > 127 (byte max)
System.out.println(pixelByte);      // -56 ← WRONG, image corrupted

// Fix — use int array, not byte array, or handle range properly
```

---

## CHAR CASTING — THE SPECIAL CASE

`char` is a special primitive because it is **unsigned** (range 0 to 65535) unlike all the integer types which are signed. This makes char casting behave uniquely.

```java
// int to char — gives you the character at that Unicode position
int unicode = 65;
char c = (char) unicode;
System.out.println(c);    // A  ← Unicode 65 is 'A'

int unicode2 = 9829;
char heart = (char) unicode2;
System.out.println(heart);  // ♥  ← Unicode 9829 is heart symbol

// char to int — gives you the Unicode value
char ch = 'A';
int value = ch;             // automatic widening — char to int
System.out.println(value);  // 65

char lower = 'z';
int lowerVal = lower;
System.out.println(lowerVal);  // 122
```

The char-to-int conversion is used **constantly in DSA problems**:

```java
// Convert char digit to its numeric value
char digitChar = '7';
int digitInt = digitChar - '0';    // 55 - 48 = 7
System.out.println(digitInt);       // 7

// Convert uppercase to lowercase
char upper = 'G';
char lower2 = (char)(upper + 32);   // 71 + 32 = 103 = 'g'
System.out.println(lower2);         // g

// Convert lowercase to uppercase
char lowerCh = 'g';
char upperCh = (char)(lowerCh - 32); // 103 - 32 = 71 = 'G'
System.out.println(upperCh);          // G

// Check if char is a digit
char test = '5';
boolean isDigit = test >= '0' && test <= '9';   // true

// Check if char is uppercase letter
char testLetter = 'B';
boolean isUpper = testLetter >= 'A' && testLetter <= 'Z';  // true
```

> **Memorize these Unicode values** — they appear in almost every string manipulation problem on LeetCode:
> - `'A'` = 65, `'Z'` = 90
> - `'a'` = 97, `'z'` = 122
> - `'0'` = 48, `'9'` = 57

---

## CASTING IN EXPRESSIONS — THE HIDDEN TRAP

Java has specific rules about how types behave in expressions. This is where many bugs hide.

### Rule 1 — Arithmetic Promotes byte/short/char to int

Any expression involving `int` or **smaller** types produces an **int** result.

```java
byte a = 10;
byte b = 20;
byte c = a + b;          // ❌ COMPILE ERROR
// a + b is evaluated as int + int = int
// Can't store int in byte without explicit cast

byte c = (byte)(a + b);  // ✅ explicit cast — output: 30
```

> Java automatically promotes `byte`, `short`, and `char` to `int` in **any arithmetic expression** before calculating.

### Rule 2 — If One Operand is long, Result is long

```java
int x = 1000000;
int y = 3000000;
long result = x * y;           // ❌ WRONG — x * y is int * int = int, overflows THEN stores in long
System.out.println(result);    // -2589934592 ← wrong!

long result2 = (long) x * y;  // ✅ cast x to long FIRST, then long * int = long
System.out.println(result2);   // 3000000000 ← correct
```

> **Classic interview trap** — the multiplication happens as `int` first (overflows), then the overflowed int gets widened to `long`. Casting one operand to `long` **before** the operation fixes it.

### Rule 3 — If One Operand is double, Result is double

```java
int a = 7;
int b = 2;
System.out.println(a / b);             // 3   — integer division, decimal part lost
System.out.println((double) a / b);    // 3.5 — cast a to double first
System.out.println(a / (double) b);    // 3.5 — cast b to double first
System.out.println((double)(a / b));   // 3.0 — WRONG WAY, division happens first then cast
```

> **The last line is the classic mistake** — casting the result instead of an operand. By the time you cast, integer division has already happened and the `.5` is gone.

**Real world** — calculating percentages:

```java
int correct = 45;
int total = 60;

// Wrong way
double percentage = correct / total * 100;    // 0.0 ← integer division first
System.out.println(percentage);               // 0.0 ← WRONG

// Correct way
double percentage2 = (double) correct / total * 100;
System.out.println(percentage2);              // 75.0 ✅
```

---

## STRING TO PRIMITIVE AND BACK — PRACTICAL CONVERSION

This is **everyday real world Java**. User input comes as Strings. You need numbers. You parse them.

```java
// String to primitive — parsing
String ageInput = "25";
int age = Integer.parseInt(ageInput);           // String → int
System.out.println(age + 5);                    // 30

String priceInput = "499.99";
double price = Double.parseDouble(priceInput);  // String → double
System.out.println(price * 1.18);              // 589.9882

String flagInput = "true";
boolean flag = Boolean.parseBoolean(flagInput); // String → boolean
System.out.println(flag);                       // true

// What if the String isn't a valid number?
String bad = "hello";
int x = Integer.parseInt(bad);  // ❌ throws NumberFormatException at runtime
```

```java
// Primitive to String — conversion
int num = 42;
String s1 = String.valueOf(num);       // ✅ recommended way
String s2 = Integer.toString(num);     // ✅ also fine
String s3 = "" + num;                  // works but bad practice — creates extra object

System.out.println(s1);  // "42"
System.out.println(s2);  // "42"
```

---

## COMPLETE CASTING SUMMARY VISUAL

```
WIDENING — automatic, no syntax, safe (may lose float precision)
byte → short → int → long → float → double
char → int (special case)

NARROWING — manual, use (type), may truncate or overflow
double → float → long → int → short → byte
int → char (special case)
```

---

## 🔥 TRICKY INTERVIEW QUESTIONS

### Q1. What is the output?

```java
int x = 257;
byte b = (byte) x;
System.out.println(b);
```

**Output: 1**

Why? 257 in binary is `100000001`. Keeping only the last 8 bits gives `00000001` = **1**.

```
257 = 1 00000001  (9 bits)
byte keeps last 8 bits: 00000001 = 1
```

---

### Q2. What is the output?

```java
System.out.println(1 / 2);
System.out.println(1.0 / 2);
System.out.println(1 / 2.0);
System.out.println((double) 1 / 2);
System.out.println((double)(1 / 2));
```

**Output:**

```
0       — integer division, both operands int
0.5     — one operand double, result double
0.5     — one operand double, result double
0.5     — cast makes first operand double before division
0.0     — division happens first (0), then cast to double (0.0)
```

> The last two lines are the classic trap. **Position of the cast matters enormously.**

---

### Q3. Will this compile? What is the output?

```java
byte x = 10;
byte y = 20;
byte z = x + y;
System.out.println(z);
```

**No — compile error.** `x + y` is promoted to `int` before addition. Result is `int`. Can't store `int` in `byte` without explicit cast.

**Fix:**

```java
byte z = (byte)(x + y);  // ✅ compiles — output: 30
```

---

### Q4. What is the output?

```java
int a = 2000000;
int b = 2000000;
long result = a * b;
System.out.println(result);
```

**Output: -1651507200** — wrong answer despite storing in `long`.

The multiplication `a * b` happens as `int * int` first. 2,000,000 × 2,000,000 = 4,000,000,000,000 which **overflows int**. The overflowed int is then stored in `long`.

**Fix:**

```java
long result = (long) a * b;   // cast one operand to long BEFORE multiplication
System.out.println(result);   // 4000000000000 ✅
```

---

### Q5. What is the output?

```java
double d = 7.9999999;
int i = (int) d;
long l = Math.round(d);
System.out.println(i);
System.out.println(l);
```

**Output:**

```
7   — casting truncates
8   — Math.round() rounds
```

> Casting truncates. `Math.round()` rounds. Two different behaviors, completely different results.

---

### Q6. What happens here?

```java
char c = 'a';
c = c + 1;          // ❌ COMPILE ERROR
c = (char)(c + 1);  // ✅ outputs 'b'
c++;                // ✅ also outputs 'b' — ++ handles cast internally
```

`c + 1` promotes `c` to `int` (Rule 1 — arithmetic promotes to int). Result is `int`. Can't store `int` back in `char` without explicit cast. However, the `++` operator is special — it handles the implicit cast internally.

---

## KEY TAKEAWAYS

- **Widening casting** goes from smaller → larger type — automatic, no syntax needed, no data loss (except precision in `long` → `float`/`double`).

- **Narrowing casting** goes from larger → smaller type — manual, write `(type)`, data may be lost silently through truncation or overflow.

- **Casting truncates decimals, it does NOT round.** `(int) 3.9` = 3. Use `Math.round()` for rounding.

- **Truncation goes toward zero** — `(int) -3.9` = -3, not -4.

- In arithmetic expressions, `byte`/`short`/`char` are **automatically promoted to int** before calculation. This means `byte + byte = int`, not byte.

- **Cast one operand before multiplication** to prevent overflow — `(long) a * b`, not `(long)(a * b)`.

- For **integer division to give decimal result**, cast at least one operand to `double` before division — `(double) a / b`, not `(double)(a / b)`.

- **`char` is unsigned** (0 to 65535). `char` → `int` is automatic widening. `int` → `char` needs explicit cast.

- **String to primitive** uses parse methods — `Integer.parseInt()`, `Double.parseDouble()`. These throw `NumberFormatException` for invalid input.

- **Overflow in narrowing cast is silent** — Java keeps only the rightmost N bits and gives you whatever number that represents. No error, no warning.

# 2.4 — `var` Keyword in Java (Java 10+)

> 📘 *Reference: Java The Complete Reference — Herbert Schildt | Java 10 JEP 286*

---

## 📌 What is `var`?

Introduced in **Java 10**, `var` is a **local variable type inference** keyword.

It tells the Java compiler:
> *"You figure out the type — I don't want to write it explicitly."*

Java was always a **statically typed** language — meaning every variable must have a declared type. With `var`, you still get static typing, but the **compiler infers the type automatically** from the right-hand side of the assignment.

> ⚠️ `var` is **NOT** a new data type. It is just a shorthand that lets the compiler do the type-declaration work for you.

---

## 🔍 Syntax

```java
// Without var (traditional)
String name = "Alice";
int age = 25;
ArrayList<String> list = new ArrayList<>();

// With var (Java 10+)
var name = "Alice";       // compiler infers String
var age = 25;             // compiler infers int
var list = new ArrayList<String>();  // compiler infers ArrayList<String>
```

The type is **locked at compile time** — it does NOT change at runtime.

---

## ✅ Where `var` CAN be used

### 1. Local variables inside methods

```java
public class VarDemo {
    public static void main(String[] args) {

        var message = "Hello, Java 10!";   // String
        var count = 100;                    // int
        var price = 99.99;                  // double
        var isActive = true;                // boolean

        System.out.println(message);
        System.out.println(count);
        System.out.println(price);
        System.out.println(isActive);
    }
}
```

**Output:**
```
Hello, Java 10!
100
99.99
true
```

---

### 2. Inside `for` loops

```java
public class VarLoopDemo {
    public static void main(String[] args) {

        // Traditional
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // With var
        for (var i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // Enhanced for-each with var
        var fruits = new String[]{"Apple", "Banana", "Mango"};
        for (var fruit : fruits) {
            System.out.println(fruit);  // fruit is inferred as String
        }
    }
}
```

---

### 3. With Collections and Generics

```java
import java.util.*;

public class VarCollections {
    public static void main(String[] args) {

        // Without var — verbose
        HashMap<String, List<Integer>> map1 = new HashMap<String, List<Integer>>();

        // With var — clean
        var map2 = new HashMap<String, List<Integer>>();

        map2.put("scores", List.of(90, 85, 92));
        System.out.println(map2);
    }
}
```

---

### 4. With try-with-resources (Java 10+)

```java
import java.io.*;

public class VarTryDemo {
    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new FileReader("file.txt"))) {
            var line = reader.readLine();
            System.out.println(line);
        }
    }
}
```

---

## ❌ Where `var` CANNOT be used

This is very important — these rules are tested in interviews!

### 1. ❌ Class fields (instance variables)

```java
public class Person {
    var name = "Alice";  // ❌ COMPILE ERROR — var not allowed for fields
}
```

### 2. ❌ Method parameters

```java
public void greet(var name) {  // ❌ COMPILE ERROR
    System.out.println(name);
}
```

### 3. ❌ Method return types

```java
public var getName() {  // ❌ COMPILE ERROR
    return "Alice";
}
```

### 4. ❌ Without initialization

```java
var x;        // ❌ COMPILE ERROR — compiler can't infer type without value
var y = null; // ❌ COMPILE ERROR — null has no type info
```

### 5. ❌ Lambda expressions

```java
var lambda = () -> System.out.println("Hi");  // ❌ COMPILE ERROR
```

### 6. ❌ Array initializer shorthand

```java
var arr = {1, 2, 3};           // ❌ COMPILE ERROR
var arr = new int[]{1, 2, 3};  // ✅ This works fine
```

---

## 🔁 `var` is STILL statically typed — proof

Once `var` infers a type, **it cannot change**:

```java
var score = 100;      // inferred as int
score = "hundred";    // ❌ COMPILE ERROR — can't assign String to int
score = 200;          // ✅ Fine — still int
```

This is very different from JavaScript's `var` which is dynamic. **Java's `var` is compile-time, not runtime.**

---

## 🧠 How the Compiler Infers Types

The compiler looks at the **right-hand side** of the assignment:

| Code | Inferred Type |
|------|--------------|
| `var x = 10;` | `int` |
| `var x = 10L;` | `long` |
| `var x = 10.5;` | `double` |
| `var x = 10.5f;` | `float` |
| `var x = 'A';` | `char` |
| `var x = true;` | `boolean` |
| `var x = "Hello";` | `String` |
| `var x = new ArrayList<>();` | `ArrayList<Object>` ⚠️ |
| `var x = new ArrayList<String>();` | `ArrayList<String>` ✅ |
| `var x = List.of(1, 2, 3);` | `List<Integer>` |

> ⚠️ **Important:** `new ArrayList<>()` with diamond operator gives `ArrayList<Object>` — always specify the generic type when using `var`.

---

## 📊 `var` vs Explicit Type — When to Use What?

| Situation | Use `var`? | Reason |
|-----------|-----------|--------|
| Simple types (`int`, `String`) | ✅ Optional | Both are fine, readability same |
| Complex generics (`Map<String, List<Integer>>`) | ✅ Recommended | Reduces verbosity |
| When type is obvious from RHS | ✅ Yes | `var list = new ArrayList<String>()` is clear |
| When type is NOT obvious from RHS | ❌ No | `var result = compute();` — reader can't tell the type |
| Public APIs / method signatures | ❌ No | Not allowed anyway |
| Loop variables | ✅ Yes | Clean & readable |

---

## 💡 Real World Example — Before vs After `var`

### Before Java 10 (verbose)
```java
import java.util.*;
import java.util.stream.*;

public class BeforeVar {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        Map<Integer, List<String>> groupedByLength = names.stream()
            .collect(Collectors.groupingBy(String::length));

        for (Map.Entry<Integer, List<String>> entry : groupedByLength.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

### After Java 10 (with `var`)
```java
import java.util.*;
import java.util.stream.*;

public class AfterVar {
    public static void main(String[] args) {
        var names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        var groupedByLength = names.stream()
            .collect(Collectors.groupingBy(String::length));

        for (var entry : groupedByLength.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

**Output (both same):**
```
3 -> [Bob, Dave]
5 -> [Alice]
7 -> [Charlie]
```

Much cleaner, same behavior.

---

## 🎯 Tricky Questions & Answers

---

### ❓ Q1. What is the output?

```java
var x = 5;
var y = 10.0;
var z = x + y;
System.out.println(z);
System.out.println(((Object)z).getClass().getSimpleName());
```

**Answer:**
```
15.0
Double
```
**Explanation:** `int + double = double`. So `z` is inferred as `double`. Autoboxing to `Double` for `.getClass()`.

---

### ❓ Q2. Will this compile?

```java
var list = new ArrayList<>();
list.add("Hello");
list.add(123);
list.add(3.14);
System.out.println(list);
```

**Answer:** ✅ Yes, it compiles!
`new ArrayList<>()` without type → inferred as `ArrayList<Object>`, so it accepts anything.
Output: `[Hello, 123, 3.14]`

> This is why you should always write `new ArrayList<String>()` with `var`.

---

### ❓ Q3. What's wrong here?

```java
var a = 10;
var b = 20;
var c;
c = a + b;
System.out.println(c);
```

**Answer:** ❌ Compile error on `var c;`
`var` must be initialized at declaration. Compiler cannot infer type from nothing.

**Fix:**
```java
var c = 0;  // initialize with a value
c = a + b;
```

---

### ❓ Q4. Is `var` a reserved keyword?

**Answer:** No! `var` is a **reserved type name**, NOT a keyword.

This means you can still use `var` as a variable name (though you shouldn't!):

```java
var var = "confusing";  // ✅ compiles but terrible practice
System.out.println(var); // prints: confusing
```

You **cannot** use it as a class name though:
```java
class var {}  // ❌ COMPILE ERROR in Java 10+
```

---

### ❓ Q5. What does `var` infer here?

```java
var num = 10_000_000;
System.out.println(num);
```

**Answer:** `int` — the underscore is just a numeric separator (Java 7+), doesn't change the type.
Output: `10000000`

---

### ❓ Q6. Will this compile? What is the type?

```java
var result = true ? "yes" : 42;
System.out.println(result);
```

**Answer:** ✅ Compiles. Type is `Object` (common supertype of `String` and `Integer`).
Output: `yes`

---

### ❓ Q7. Spot the mistake:

```java
public class Test {
    var name = "Alice";

    public static void main(String[] args) {
        var t = new Test();
        System.out.println(t.name);
    }
}
```

**Answer:** ❌ Compile error — `var name = "Alice"` is an **instance variable (field)**, and `var` is **not allowed for fields**, only local variables.

---

## 📝 Summary Table

| Feature | Details |
|---------|---------|
| Introduced in | Java 10 |
| Full name | Local Variable Type Inference |
| Is it a keyword? | No — it's a reserved type name |
| Typing | Static (compile-time), NOT dynamic |
| Allowed in | Local variables, for loops, try-with-resources |
| NOT allowed in | Fields, method params, return types, lambda, uninitialized vars |
| Performance impact | None — compiled to exact type |
| Readability | Better for complex generics, same for simple types |

---


