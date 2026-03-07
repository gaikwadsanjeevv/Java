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
