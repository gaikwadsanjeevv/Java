# Section 3 — Operators in Java
## 3.1 — Arithmetic Operators

> 📘 *Reference: Java The Complete Reference — Herbert Schildt*

---

## 📌 What are Operators?

Operators are **special symbols** that perform operations on variables and values.
Java has a rich set of operators divided into categories:

```
Section 3 — Operators
├── 3.1  Arithmetic operators          ← YOU ARE HERE
├── 3.2  Relational operators
├── 3.3  Logical operators
├── 3.4  Bitwise operators
├── 3.5  Assignment operators
├── 3.6  Ternary operator
├── 3.7  instanceof operator
└── 3.8  Operator precedence & tricky expressions
```

---

## 📌 What are Arithmetic Operators?

Arithmetic operators perform **mathematical calculations** — addition, subtraction,
multiplication, division and remainder.

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `+` | Addition | `10 + 3` | `13` |
| `-` | Subtraction | `10 - 3` | `7` |
| `*` | Multiplication | `10 * 3` | `30` |
| `/` | Division | `10 / 3` | `3` (integer division!) |
| `%` | Modulus (Remainder) | `10 % 3` | `1` |
| `++` | Increment | `x++` or `++x` | `x + 1` |
| `--` | Decrement | `x--` or `--x` | `x - 1` |

---

## ➕ 1. Addition Operator `+`

The `+` operator works differently depending on the types involved:
- With numbers → mathematical addition
- With Strings → concatenation

```java
public class AdditionDemo {
    public static void main(String[] args) {

        // --- Basic number addition ---
        int a = 15;
        int b = 7;
        int sum = a + b;
        System.out.println("Sum: " + sum);          // Sum: 22

        // --- Adding different types (type promotion) ---
        int x = 10;
        double y = 3.5;
        double result = x + y;                       // int promoted to double
        System.out.println("Int + Double: " + result); // Int + Double: 13.5

        // --- String concatenation with + ---
        String firstName = "James";
        String lastName  = "Gosling";                // creator of Java!
        String fullName  = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName); // Full Name: James Gosling

        // --- Mixed: number + String (left to right evaluation) ---
        System.out.println(10 + 20 + " Java");       // 30 Java  (10+20=30 first, then concat)
        System.out.println("Java " + 10 + 20);       // Java 1020 (String first, then concat)

        // --- Real world: calculating total price ---
        double itemPrice  = 499.99;
        double taxRate    = 0.18;                    // 18% GST
        double tax        = itemPrice * taxRate;
        double totalPrice = itemPrice + tax;
        System.out.printf("Item: %.2f | Tax: %.2f | Total: %.2f%n",
                           itemPrice, tax, totalPrice);
        // Item: 499.99 | Tax: 90.00 | Total: 589.99
    }
}
```

---

## ➖ 2. Subtraction Operator `-`

```java
public class SubtractionDemo {
    public static void main(String[] args) {

        // --- Basic subtraction ---
        int price    = 1000;
        int discount = 250;
        int finalPrice = price - discount;
        System.out.println("Final Price: " + finalPrice);   // Final Price: 750

        // --- Negative result ---
        int balance = 500;
        int withdrawal = 800;
        int remaining = balance - withdrawal;
        System.out.println("Balance: " + remaining);        // Balance: -300

        // --- Real world: countdown timer ---
        int totalSeconds = 3600;    // 1 hour in seconds
        int elapsed      = 1245;    // seconds elapsed
        int remaining2   = totalSeconds - elapsed;

        int minutes = remaining2 / 60;    // integer division gives minutes
        int seconds = remaining2 % 60;    // remainder gives leftover seconds
        System.out.printf("Time Left: %d min %d sec%n", minutes, seconds);
        // Time Left: 39 min 15 sec

        // --- Real world: stock market change ---
        double openPrice  = 2450.75;   // stock opening price
        double closePrice = 2389.50;   // stock closing price
        double change     = closePrice - openPrice;
        System.out.printf("Stock Change: %.2f%n", change);  // Stock Change: -61.25
    }
}
```

---

## ✖️ 3. Multiplication Operator `*`

```java
public class MultiplicationDemo {
    public static void main(String[] args) {

        // --- Basic multiplication ---
        int length = 12;
        int width  = 8;
        int area   = length * width;
        System.out.println("Rectangle Area: " + area);   // Rectangle Area: 96

        // --- Real world: EMI calculation ---
        double loanAmount  = 500000.0;   // ₹5 lakhs loan
        double monthlyRate = 0.01;       // 1% monthly interest
        double emi         = loanAmount * monthlyRate;
        System.out.printf("Monthly Interest: ₹%.2f%n", emi); // Monthly Interest: ₹5000.00

        // --- Real world: multiplication table ---
        int number = 7;
        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", number, i, number * i);
        }
        // 7 x 1 = 7
        // 7 x 2 = 14
        // ... 7 x 10 = 70

        // --- Overflow trap: always watch for large multiplications ---
        int bigNum = 100000;
        long safeResult = (long) bigNum * bigNum;    // cast to long BEFORE multiplying
        System.out.println("Safe Result: " + safeResult);  // Safe Result: 10000000000
        // Without cast: int overflow → wrong answer!
    }
}
```

---

## ➗ 4. Division Operator `/`

Division behaves differently for `int` vs `double` — this is a very common trap!

```java
public class DivisionDemo {
    public static void main(String[] args) {

        // --- Integer division (truncates decimal, does NOT round) ---
        int a = 10;
        int b = 3;
        int result = a / b;
        System.out.println("10 / 3 = " + result);        // 10 / 3 = 3  (NOT 3.33!)

        int c = 7;
        int d = 2;
        System.out.println("7 / 2 = " + (c / d));        // 7 / 2 = 3   (NOT 3.5!)

        // --- Double division (gives decimal result) ---
        double x = 10.0;
        double y = 3.0;
        System.out.println("10.0 / 3.0 = " + (x / y));  // 10.0 / 3.0 = 3.3333333333333335

        // --- Trick: force decimal result from int division ---
        System.out.println((double) a / b);               // 3.3333333333333335 ✅
        System.out.println((double)(a / b));              // 3.0 ❌ (division happens first as int!)

        // --- Division by zero ---
        // int division by zero → ArithmeticException
        // double division by zero → Infinity (no exception)
        double inf = 5.0 / 0.0;
        System.out.println("5.0 / 0.0 = " + inf);        // 5.0 / 0.0 = Infinity

        // --- Real world: calculate average score ---
        int totalMarks  = 437;
        int subjects    = 5;
        double average  = (double) totalMarks / subjects; // cast to get decimal avg
        System.out.printf("Average Score: %.2f%%%n", average); // Average Score: 87.40%

        // --- Real world: split bill among friends ---
        double billTotal = 1250.0;
        int friends      = 4;
        double perPerson = billTotal / friends;
        System.out.printf("Each person pays: ₹%.2f%n", perPerson); // Each person pays: ₹312.50
    }
}
```

---

## 〰️ 5. Modulus Operator `%` (Remainder)

The modulus operator returns the **remainder** after division.
One of the most used operators in DSA and real-world programming!

```java
public class ModulusDemo {
    public static void main(String[] args) {

        // --- Basic modulus ---
        System.out.println("10 % 3 = " + (10 % 3));     // 10 % 3 = 1
        System.out.println("10 % 2 = " + (10 % 2));     // 10 % 2 = 0  (even number!)
        System.out.println("10 % 10 = " + (10 % 10));   // 10 % 10 = 0
        System.out.println("5 % 10 = " + (5 % 10));     // 5 % 10 = 5  (dividend < divisor)

        // --- Negative modulus (important!) ---
        System.out.println("-10 % 3 = " + (-10 % 3));   // -10 % 3 = -1  (sign follows dividend)
        System.out.println("10 % -3 = " + (10 % -3));   // 10 % -3 = 1   (sign follows dividend)

        // --- Real world 1: check even or odd ---
        int[] numbers = {1, 2, 7, 12, 15, 20};
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.println(num + " → Even");
            } else {
                System.out.println(num + " → Odd");
            }
        }
        // 1 → Odd, 2 → Even, 7 → Odd, 12 → Even, 15 → Odd, 20 → Even

        // --- Real world 2: clock / circular indexing ---
        // Convert 24-hour format to 12-hour format
        int hour24 = 15;                          // 3 PM in 24hr format
        int hour12 = hour24 % 12;                 // 15 % 12 = 3
        String period = (hour24 < 12) ? "AM" : "PM";
        System.out.println(hour24 + ":00 → " + hour12 + ":00 " + period); // 15:00 → 3:00 PM

        // --- Real world 3: circular queue / ring buffer ---
        // Used in arrays to wrap around
        int[] ringBuffer = {10, 20, 30, 40, 50};
        int size = ringBuffer.length;
        for (int i = 0; i < 8; i++) {
            int index = i % size;                 // wraps: 0,1,2,3,4,0,1,2
            System.out.print(ringBuffer[index] + " ");
        }
        // 10 20 30 40 50 10 20 30 (cycles through!)
        System.out.println();

        // --- Real world 4: check divisibility ---
        // FizzBuzz (famous interview question!)
        for (int i = 1; i <= 20; i++) {
            if (i % 15 == 0)      System.out.print("FizzBuzz ");  // divisible by both 3 & 5
            else if (i % 3 == 0)  System.out.print("Fizz ");      // divisible by 3
            else if (i % 5 == 0)  System.out.print("Buzz ");      // divisible by 5
            else                  System.out.print(i + " ");
        }
        // 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz
    }
}
```

---

## ⬆️ 6. Increment `++` and Decrement `--` Operators

These are **unary operators** — they work on a single variable.
Come in two forms: **pre** (before variable) and **post** (after variable).

```java
public class IncrementDecrementDemo {
    public static void main(String[] args) {

        // ─────────────────────────────────────────
        // PRE-INCREMENT (++x): increment FIRST, then use
        // ─────────────────────────────────────────
        int a = 5;
        int b = ++a;    // a becomes 6 first, then b = 6
        System.out.println("Pre-increment:");
        System.out.println("a = " + a);  // a = 6
        System.out.println("b = " + b);  // b = 6

        // ─────────────────────────────────────────
        // POST-INCREMENT (x++): use FIRST, then increment
        // ─────────────────────────────────────────
        int x = 5;
        int y = x++;    // y = 5 (original value used), THEN x becomes 6
        System.out.println("\nPost-increment:");
        System.out.println("x = " + x);  // x = 6
        System.out.println("y = " + y);  // y = 5

        // ─────────────────────────────────────────
        // PRE-DECREMENT (--x): decrement FIRST, then use
        // ─────────────────────────────────────────
        int p = 10;
        int q = --p;    // p becomes 9 first, then q = 9
        System.out.println("\nPre-decrement:");
        System.out.println("p = " + p);  // p = 9
        System.out.println("q = " + q);  // q = 9

        // ─────────────────────────────────────────
        // POST-DECREMENT (x--): use FIRST, then decrement
        // ─────────────────────────────────────────
        int m = 10;
        int n = m--;    // n = 10 (original value used), THEN m becomes 9
        System.out.println("\nPost-decrement:");
        System.out.println("m = " + m);  // m = 9
        System.out.println("n = " + n);  // n = 10

        // ─────────────────────────────────────────
        // Real world: shopping cart item count
        // ─────────────────────────────────────────
        int cartItems = 0;

        cartItems++;   // add item 1
        cartItems++;   // add item 2
        cartItems++;   // add item 3
        System.out.println("\nCart Items: " + cartItems);  // Cart Items: 3

        cartItems--;   // remove one item
        System.out.println("After removal: " + cartItems); // After removal: 2

        // ─────────────────────────────────────────
        // Real world: loop control
        // ─────────────────────────────────────────
        System.out.println("\nCountdown:");
        for (int i = 5; i >= 1; i--) {   // decrement in loop
            System.out.print(i + " ");     // 5 4 3 2 1
        }
        System.out.println("Go!");
    }
}
```

---

## 🧮 7. Compound Assignment Operators

These are shorthand — they combine arithmetic with assignment:

| Operator | Equivalent | Example |
|----------|-----------|---------|
| `+=` | `x = x + y` | `x += 5` |
| `-=` | `x = x - y` | `x -= 3` |
| `*=` | `x = x * y` | `x *= 2` |
| `/=` | `x = x / y` | `x /= 4` |
| `%=` | `x = x % y` | `x %= 3` |

```java
public class CompoundAssignment {
    public static void main(String[] args) {

        int score = 100;

        score += 50;    // score = score + 50 = 150
        System.out.println("After += 50: " + score);   // 150

        score -= 30;    // score = score - 30 = 120
        System.out.println("After -= 30: " + score);   // 120

        score *= 2;     // score = score * 2 = 240
        System.out.println("After *= 2: " + score);    // 240

        score /= 4;     // score = score / 4 = 60
        System.out.println("After /= 4: " + score);    // 60

        score %= 7;     // score = score % 7 = 4
        System.out.println("After %= 7: " + score);    // 4

        // ─────────────────────────────────────────
        // Hidden implicit cast in compound assignment!
        // ─────────────────────────────────────────
        byte b = 100;
        b += 50;        // ✅ works! compound op has implicit (byte) cast
                        // equivalent to: b = (byte)(b + 50) → b = (byte)150 → -106 (overflow!)
        System.out.println("byte after += 50: " + b);  // -106

        // vs regular assignment:
        // b = b + 50;  ❌ compile error — b+50 is int, can't assign to byte
    }
}
```

---

## 🌍 Real World Mini-Projects

### 📱 Project 1 — Simple Calculator

```java
public class SimpleCalculator {
    public static void main(String[] args) {

        double num1 = 250.0;
        double num2 = 45.0;

        // Performing all arithmetic operations
        System.out.println("=== Simple Calculator ===");
        System.out.printf("Numbers: %.1f and %.1f%n%n", num1, num2);

        System.out.printf("Addition:       %.1f + %.1f = %.2f%n", num1, num2, num1 + num2);
        System.out.printf("Subtraction:    %.1f - %.1f = %.2f%n", num1, num2, num1 - num2);
        System.out.printf("Multiplication: %.1f * %.1f = %.2f%n", num1, num2, num1 * num2);
        System.out.printf("Division:       %.1f / %.1f = %.4f%n", num1, num2, num1 / num2);
        System.out.printf("Modulus:        %.1f %% %.1f = %.2f%n", num1, num2, num1 % num2);
    }
}
```

**Output:**
```
=== Simple Calculator ===
Numbers: 250.0 and 45.0

Addition:       250.0 + 45.0 = 295.00
Subtraction:    250.0 - 45.0 = 205.00
Multiplication: 250.0 * 45.0 = 11250.00
Division:       250.0 / 45.0 = 5.5556
Modulus:        250.0 % 45.0 = 25.00
```

---

### 🏦 Project 2 — Bank Account Operations

```java
public class BankAccount {
    public static void main(String[] args) {

        double balance = 10000.00;   // starting balance
        double interest = 0.065;     // 6.5% annual interest rate

        System.out.println("=== Bank Account Statement ===");
        System.out.printf("Opening Balance:  ₹%.2f%n", balance);

        // Deposit
        double deposit = 5000.00;
        balance += deposit;          // compound assignment
        System.out.printf("Deposit (+):      ₹%.2f%n", deposit);
        System.out.printf("Balance:          ₹%.2f%n", balance);

        // Withdrawal
        double withdrawal = 3500.00;
        balance -= withdrawal;       // compound assignment
        System.out.printf("Withdrawal (-):   ₹%.2f%n", withdrawal);
        System.out.printf("Balance:          ₹%.2f%n", balance);

        // Annual interest earned
        double interestEarned = balance * interest;
        balance += interestEarned;
        System.out.printf("Interest Earned:  ₹%.2f%n", interestEarned);
        System.out.printf("Closing Balance:  ₹%.2f%n", balance);
    }
}
```

**Output:**
```
=== Bank Account Statement ===
Opening Balance:  ₹10000.00
Deposit (+):      ₹5000.00
Balance:          ₹15000.00
Withdrawal (-):   ₹3500.00
Balance:          ₹11500.00
Interest Earned:  ₹747.50
Closing Balance:  ₹12247.50
```

---

### ⏱️ Project 3 — Time Converter (Using / and %)

```java
public class TimeConverter {
    public static void main(String[] args) {

        int totalSeconds = 9875;    // convert this to hours, minutes, seconds

        // Integer division and modulus do the heavy lifting
        int hours   = totalSeconds / 3600;         // 3600 seconds in an hour
        int minutes = (totalSeconds % 3600) / 60;  // remaining seconds ÷ 60
        int seconds = totalSeconds % 60;           // leftover seconds

        System.out.printf("%d seconds = %d hours, %d minutes, %d seconds%n",
                          totalSeconds, hours, minutes, seconds);
        // 9875 seconds = 2 hours, 44 minutes, 35 seconds
    }
}
```

---

## 🎯 Tricky Interview Questions

---

### ❓ Q1. What is the output?

```java
int a = 10;
int b = 3;
System.out.println(a / b);
System.out.println(a % b);
System.out.println((double) a / b);
```

**Answer:**
```
3
1
3.3333333333333335
```
`10 / 3` = integer division = `3`. Remainder `10 % 3` = `1`. Cast to double gives decimal.

---

### ❓ Q2. What is the output?

```java
int x = 5;
System.out.println(x++);   // post-increment
System.out.println(++x);   // pre-increment
System.out.println(x);
```

**Answer:**
```
5
7
7
```
`x++` → prints `5`, then x becomes `6`.
`++x` → x becomes `7` first, then prints `7`.
Final x = `7`.

---

### ❓ Q3. What is the output?

```java
int a = 10;
int b = 3;
double result = a / b;
System.out.println(result);
```

**Answer:** `3.0`

Trap! `a / b` is integer division → `3`. Then `3` (int) is assigned to `double` → `3.0`.
To get `3.333...`, you need: `double result = (double) a / b;`

---

### ❓ Q4. What is the output?

```java
System.out.println(5 % 3);
System.out.println(-5 % 3);
System.out.println(5 % -3);
System.out.println(-5 % -3);
```

**Answer:**
```
2
-2
2
-2
```
In Java, the **sign of the remainder follows the sign of the dividend** (left operand).

---

### ❓ Q5. What is the output?

```java
int i = 10;
i = i++ + ++i;
System.out.println(i);
```

**Answer:** `22`

Step by step:
1. `i++` → uses `10`, then i becomes `11`
2. `++i` → i becomes `12`, then uses `12`
3. `i = 10 + 12 = 22`

---

### ❓ Q6. Real interview question — What's wrong?

```java
double price = 99.9;
double tax   = 0.1;
double total = price + tax;
if (total == 100.0) {
    System.out.println("Price is exactly 100");
} else {
    System.out.println("Not exactly 100: " + total);
}
```

**Answer:** Prints `Not exactly 100: 99.99999999999999`

Floating point arithmetic is imprecise. `99.9 + 0.1` is NOT exactly `100.0` in binary.

**Fix:** Use a small tolerance (epsilon):
```java
if (Math.abs(total - 100.0) < 0.0001) {
    System.out.println("Price is exactly 100");
}
```
OR use `BigDecimal` for exact decimal math.

---

### ❓ Q7. Can `%` be used on doubles?

```java
System.out.println(10.5 % 3.2);
```

**Answer:** ✅ Yes! Output: `0.8999999999999995`

`%` works on floating-point numbers too. Result has the same floating-point precision issue.

---

## 📝 Summary

```
ARITHMETIC OPERATORS QUICK REFERENCE
──────────────────────────────────────────────────────────────────
 +   Addition / String concat     10 + 3 = 13  |  "Hi" + 5 = "Hi5"
 -   Subtraction                  10 - 3 = 7
 *   Multiplication               10 * 3 = 30
 /   Division                     10 / 3 = 3   (int!) | 10.0/3 = 3.333
 %   Modulus (remainder)          10 % 3 = 1
 ++  Increment (pre/post)         ++x (incr first) | x++ (use first)
 --  Decrement (pre/post)         --x (decr first) | x-- (use first)

KEY RULES TO REMEMBER:
✅  int / int        → integer division (truncates)
✅  cast to double   → (double) a / b  NOT (double)(a/b)
✅  sign of %        → follows the dividend (left operand)
✅  0.1 + 0.2 ≠ 0.3 → use BigDecimal for exact money math
✅  pre (++x)        → increment then use
✅  post (x++)       → use then increment
✅  compound ops     → include implicit narrowing cast
```

---
# 3.2 — Relational Operators in Java

> 📘 *Reference: Java The Complete Reference — Herbert Schildt*

---

## 📌 What are Relational Operators?

Relational operators **compare two values** and always return a `boolean`
result — either `true` or `false`.

They are the backbone of every `if` condition, loop, and decision in Java.

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `==` | Equal to | `5 == 5` | `true` |
| `!=` | Not equal to | `5 != 3` | `true` |
| `>` | Greater than | `5 > 3` | `true` |
| `<` | Less than | `5 < 3` | `false` |
| `>=` | Greater than or equal | `5 >= 5` | `true` |
| `<=` | Less than or equal | `3 <= 5` | `true` |

---

## ✅ 1. Equal To `==`

Checks if two values are **equal**.

```java
public class EqualToDemo {
    public static void main(String[] args) {

        // --- Comparing primitives ---
        int a = 10;
        int b = 10;
        int c = 20;

        System.out.println(a == b);    // true  (same value)
        System.out.println(a == c);    // false (different value)

        // --- Comparing with expressions ---
        int x = 5;
        System.out.println(x * 2 == 10);   // true  (5*2 = 10)
        System.out.println(x + 1 == 5);    // false (6 != 5)

        // --- Real world: login PIN check ---
        int storedPIN  = 4521;
        int enteredPIN = 4521;
        if (enteredPIN == storedPIN) {
            System.out.println("Access Granted ✅");   // Access Granted ✅
        } else {
            System.out.println("Wrong PIN ❌");
        }

        // --- Real world: check if number is even ---
        int number = 42;
        boolean isEven = (number % 2 == 0);            // remainder 0 means even
        System.out.println(number + " is even: " + isEven); // 42 is even: true

        // ⚠️ WARNING: == on Objects compares REFERENCES, not content!
        String s1 = new String("Java");
        String s2 = new String("Java");
        System.out.println(s1 == s2);       // false ❌ (different objects in heap)
        System.out.println(s1.equals(s2));  // true  ✅ (same content)
    }
}
```

> 🔑 **Rule:** Use `==` for **primitives**. Use `.equals()` for **Objects (Strings, etc.)**

---

## ❌ 2. Not Equal To `!=`

Checks if two values are **NOT equal**.

```java
public class NotEqualDemo {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println(a != b);     // true  (10 is not equal to 20)
        System.out.println(a != 10);    // false (10 IS equal to 10)

        // --- Real world: check if a field is not empty ---
        String username = "alice";
        if (username != null && !username.isEmpty()) {
            System.out.println("Username is valid: " + username); // Username is valid: alice
        }

        // --- Real world: skip a specific value in loop ---
        System.out.println("Numbers except 3:");
        for (int i = 1; i <= 5; i++) {
            if (i != 3) {                        // skip 3
                System.out.print(i + " ");       // 1 2 4 5
            }
        }
        System.out.println();

        // --- Real world: vending machine ---
        int selectedItem  = 5;
        int availableItem = 3;
        if (selectedItem != availableItem) {
            System.out.println("Item " + selectedItem + " not available. Try item " + availableItem);
            // Item 5 not available. Try item 3
        }
    }
}
```

---

## ⬆️ 3. Greater Than `>`

Checks if the left value is **strictly greater than** the right.

```java
public class GreaterThanDemo {
    public static void main(String[] args) {

        System.out.println(10 > 5);     // true
        System.out.println(5 > 10);     // false
        System.out.println(5 > 5);      // false (strict — not equal)

        // --- Real world: age eligibility check ---
        int age = 20;
        if (age > 18) {
            System.out.println("Eligible to vote ✅");   // Eligible to vote ✅
        }

        // --- Real world: stock price alert ---
        double currentPrice = 2850.50;
        double targetPrice  = 2800.00;
        if (currentPrice > targetPrice) {
            System.out.printf("🔔 Alert! Stock crossed target: ₹%.2f > ₹%.2f%n",
                               currentPrice, targetPrice);
            // 🔔 Alert! Stock crossed target: ₹2850.50 > ₹2800.00
        }

        // --- Real world: find maximum of three numbers ---
        int x = 45, y = 82, z = 61;
        int max;
        if (x > y && x > z) {
            max = x;
        } else if (y > z) {
            max = y;
        } else {
            max = z;
        }
        System.out.println("Maximum: " + max);   // Maximum: 82

        // --- Real world: temperature warning ---
        double bodyTemp = 103.5;   // Fahrenheit
        if (bodyTemp > 100.4) {
            System.out.println("⚠️ Fever detected! Temp: " + bodyTemp + "°F");
            // ⚠️ Fever detected! Temp: 103.5°F
        }
    }
}
```

---

## ⬇️ 4. Less Than `<`

Checks if the left value is **strictly less than** the right.

```java
public class LessThanDemo {
    public static void main(String[] args) {

        System.out.println(5 < 10);     // true
        System.out.println(10 < 5);     // false
        System.out.println(5 < 5);      // false (strict — not equal)

        // --- Real world: low battery alert ---
        int batteryLevel = 15;          // percentage
        if (batteryLevel < 20) {
            System.out.println("🔋 Low battery! Charge now. Level: " + batteryLevel + "%");
            // 🔋 Low battery! Charge now. Level: 15%
        }

        // --- Real world: minimum age restriction ---
        int userAge = 15;
        if (userAge < 18) {
            System.out.println("❌ Access denied. Must be 18+");  // ❌ Access denied. Must be 18+
        }

        // --- Real world: disk space warning ---
        double freeSpaceGB = 1.8;
        double thresholdGB = 2.0;
        if (freeSpaceGB < thresholdGB) {
            System.out.printf("💾 Low disk space! Only %.1f GB remaining%n", freeSpaceGB);
            // 💾 Low disk space! Only 1.8 GB remaining
        }

        // --- Real world: find minimum in array ---
        int[] prices = {450, 280, 390, 175, 520};
        int minPrice = prices[0];                   // assume first is minimum
        for (int price : prices) {
            if (price < minPrice) {                 // if current is smaller, update
                minPrice = price;
            }
        }
        System.out.println("Cheapest item: ₹" + minPrice);  // Cheapest item: ₹175
    }
}
```

---

## ✳️ 5. Greater Than or Equal To `>=`

Checks if left is **greater than OR equal to** right.

```java
public class GreaterEqualDemo {
    public static void main(String[] args) {

        System.out.println(10 >= 10);   // true  (equal case)
        System.out.println(11 >= 10);   // true  (greater case)
        System.out.println(9  >= 10);   // false

        // --- Real world: exam pass/fail ---
        int marks = 40;
        int passMark = 40;
        if (marks >= passMark) {
            System.out.println("Result: PASS ✅ (" + marks + "/" + passMark + ")");
            // Result: PASS ✅ (40/40)
        } else {
            System.out.println("Result: FAIL ❌");
        }

        // --- Real world: grade calculator ---
        int score = 78;
        String grade;
        if (score >= 90)      grade = "A+";
        else if (score >= 80) grade = "A";
        else if (score >= 70) grade = "B";
        else if (score >= 60) grade = "C";
        else if (score >= 40) grade = "D";
        else                  grade = "F";
        System.out.println("Score: " + score + " → Grade: " + grade);  // Score: 78 → Grade: B

        // --- Real world: free shipping threshold ---
        double orderAmount  = 599.0;
        double freeShipping = 500.0;
        if (orderAmount >= freeShipping) {
            System.out.println("🎉 Free shipping applied!");     // 🎉 Free shipping applied!
        } else {
            System.out.printf("Add ₹%.2f more for free shipping%n",
                               freeShipping - orderAmount);
        }
    }
}
```

---

## ✳️ 6. Less Than or Equal To `<=`

Checks if left is **less than OR equal to** right.

```java
public class LessEqualDemo {
    public static void main(String[] args) {

        System.out.println(10 <= 10);   // true  (equal case)
        System.out.println(9  <= 10);   // true  (less than case)
        System.out.println(11 <= 10);   // false

        // --- Real world: speed limit check ---
        int vehicleSpeed = 80;
        int speedLimit   = 80;
        if (vehicleSpeed <= speedLimit) {
            System.out.println("✅ Speed OK: " + vehicleSpeed + " km/h");
            // ✅ Speed OK: 80 km/h
        } else {
            System.out.println("🚨 Overspeeding! " + vehicleSpeed + " km/h");
        }

        // --- Real world: age group categories ---
        int personAge = 14;
        if (personAge <= 12) {
            System.out.println("Category: Child");
        } else if (personAge <= 17) {
            System.out.println("Category: Teenager");   // Category: Teenager
        } else if (personAge <= 59) {
            System.out.println("Category: Adult");
        } else {
            System.out.println("Category: Senior");
        }

        // --- Real world: countdown loop ---
        System.out.println("Rocket Launch Countdown:");
        for (int i = 10; i >= 1; i--) {             // <= would also work with reverse logic
            System.out.print(i + "... ");
        }
        System.out.println("🚀 Liftoff!");
        // 10... 9... 8... 7... 6... 5... 4... 3... 2... 1... 🚀 Liftoff!
    }
}
```

---

## 🔗 Chaining Comparisons in Real Code

```java
public class ChainingComparisons {
    public static void main(String[] args) {

        // --- Range check: is number between 1 and 100? ---
        int num = 75;
        // ⚠️ Java does NOT support: 1 <= num <= 100  (like maths)
        // Must use AND: (num >= 1) && (num <= 100)
        boolean inRange = (num >= 1) && (num <= 100);
        System.out.println(num + " is in range [1-100]: " + inRange); // true

        // --- Real world: valid password length ---
        String password = "mySecret@123";
        int len = password.length();
        if (len >= 8 && len <= 20) {
            System.out.println("✅ Valid password length: " + len);  // ✅ Valid password length: 12
        } else {
            System.out.println("❌ Password must be 8-20 characters");
        }

        // --- Real world: BMI calculator ---
        double weightKg = 70.0;
        double heightM  = 1.75;
        double bmi      = weightKg / (heightM * heightM);

        System.out.printf("BMI: %.2f → ", bmi);    // BMI: 22.86 →

        if      (bmi < 18.5)              System.out.println("Underweight");
        else if (bmi >= 18.5 && bmi < 25) System.out.println("Normal weight ✅");  // Normal weight ✅
        else if (bmi >= 25 && bmi < 30)   System.out.println("Overweight");
        else                              System.out.println("Obese");

        // --- Real world: valid triangle check ---
        int a = 5, b2 = 7, c = 9;
        // Triangle inequality: each side must be less than sum of other two
        boolean isTriangle = (a + b2 > c) && (b2 + c > a) && (a + c > b2);
        System.out.println("Valid triangle (" + a + "," + b2 + "," + c + "): " + isTriangle);
        // Valid triangle (5,7,9): true
    }
}
```

---

## ⚠️ Common Pitfall — `==` vs `.equals()` for Objects

This is one of the **most common bugs** in Java. Must know for interviews!

```java
public class EqualsPitfall {
    public static void main(String[] args) {

        // ── STRINGS ──────────────────────────────────
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1 == s2);        // true  (both from String pool)
        System.out.println(s1 == s3);        // false (s3 is new heap object)
        System.out.println(s1.equals(s3));   // true  (same content) ✅

        // ── INTEGERS (wrapper class) ──────────────────
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);        // true  (Integer cache: -128 to 127)
        System.out.println(i3 == i4);        // false (200 is outside cache range!)
        System.out.println(i3.equals(i4));   // true  ✅

        // ── CUSTOM OBJECTS ────────────────────────────
        // Two different object references
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println(arr1 == arr2);                          // false (different references)
        System.out.println(java.util.Arrays.equals(arr1, arr2));   // true  ✅

        // ── RULE OF THUMB ─────────────────────────────
        // Primitives   → use ==
        // Objects      → use .equals()
        // null check   → use == null  (not .equals() — NullPointerException!)
        String name = null;
        System.out.println(name == null);    // true  ✅ safe
        // System.out.println(name.equals(null)); ❌ NullPointerException!
    }
}
```

---

## 🌍 Real World Project — Student Report Card

```java
public class StudentReportCard {
    public static void main(String[] args) {

        // Student details
        String studentName = "Rahul Sharma";
        int    rollNumber  = 42;
        int    marks[]     = {85, 72, 90, 68, 78};   // 5 subjects
        String subjects[]  = {"Math", "English", "Science", "History", "Computer"};

        int    total   = 0;
        int    highest = marks[0];
        int    lowest  = marks[0];

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       STUDENT REPORT CARD    ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("Name: " + studentName);
        System.out.println("Roll: " + rollNumber);
        System.out.println("──────────────────────────────");

        for (int i = 0; i < marks.length; i++) {
            total += marks[i];

            // Using relational operators to find highest and lowest
            if (marks[i] > highest) highest = marks[i];   // >  finds max
            if (marks[i] < lowest)  lowest  = marks[i];   // <  finds min

            // Grade using >= and <=
            String grade;
            if      (marks[i] >= 90) grade = "A+";
            else if (marks[i] >= 80) grade = "A";
            else if (marks[i] >= 70) grade = "B";
            else if (marks[i] >= 60) grade = "C";
            else if (marks[i] >= 40) grade = "D";
            else                     grade = "F";

            System.out.printf("%-10s: %3d  [%s]%n", subjects[i], marks[i], grade);
        }

        double average = (double) total / marks.length;  // cast for decimal avg

        System.out.println("──────────────────────────────");
        System.out.printf("Total:    %d / %d%n", total, marks.length * 100);
        System.out.printf("Average:  %.2f%%%n", average);
        System.out.println("Highest:  " + highest);
        System.out.println("Lowest:   " + lowest);

        // Final result using >= relational operator
        String result = (average >= 40) ? "PASS ✅" : "FAIL ❌";
        System.out.println("Result:   " + result);
    }
}
```

**Output:**
```
╔══════════════════════════════╗
║       STUDENT REPORT CARD    ║
╚══════════════════════════════╝
Name: Rahul Sharma
Roll: 42
──────────────────────────────
Math      :  85  [A]
English   :  72  [B]
Science   :  90  [A+]
History   :  68  [C]
Computer  :  78  [B]
──────────────────────────────
Total:    393 / 500
Average:  78.60%
Highest:  90
Lowest:   68
Result:   PASS ✅
```

---

## 🎯 Tricky Interview Questions

---

### ❓ Q1. What is the output?

```java
System.out.println(5 == 5.0);
```

**Answer:** `true`

`5` (int) is promoted to `5.0` (double) before comparison. Both represent the same value.

---

### ❓ Q2. What is the output?

```java
char c = 'A';
System.out.println(c == 65);
```

**Answer:** `true`

`'A'` has Unicode value `65`. `char` is promoted to `int`, so `65 == 65` → `true`.

---

### ❓ Q3. What is the output?

```java
String a = "Java";
String b = "Java";
String c = new String("Java");

System.out.println(a == b);
System.out.println(a == c);
System.out.println(a.equals(c));
System.out.println(a.equalsIgnoreCase("JAVA"));
```

**Answer:**
```
true
false
true
true
```
`a` and `b` share String pool → `==` is `true`.
`c` is a new heap object → `==` is `false`.
`.equals()` compares content → `true`.
`.equalsIgnoreCase()` ignores case → `true`.

---

### ❓ Q4. What is the output?

```java
int x = 5;
boolean result = x > 3 > 1;  // is this valid?
```

**Answer:** ❌ Compile error!

Java does NOT support chained comparisons like `x > 3 > 1`.
`x > 3` gives `true` (boolean), and then `true > 1` is invalid — you can't compare boolean with int.

**Fix:**
```java
boolean result = x > 3 && x > 1;  // ✅
```

---

### ❓ Q5. What is the output?

```java
Integer a = 127;
Integer b = 127;
Integer c = 128;
Integer d = 128;

System.out.println(a == b);
System.out.println(c == d);
```

**Answer:**
```
true
false
```
Integer cache stores values **-128 to 127**. `127` reuses cached object → `==` is `true`.
`128` creates new objects → `==` is `false`. Always use `.equals()` for Integer comparison!

---

### ❓ Q6. What is the output?

```java
double a = Double.NaN;
double b = Double.NaN;
System.out.println(a == b);
System.out.println(a != b);
```

**Answer:**
```
false
true
```
`NaN` is **never equal to anything, including itself**. `NaN == NaN` is always `false`.
So `NaN != NaN` is always `true`. Use `Double.isNaN(a)` to check for NaN.

---

### ❓ Q7. What is the output?

```java
System.out.println('a' > 'A');
System.out.println('z' - 'a');
```

**Answer:**
```
true
25
```
`'a'` = 97, `'A'` = 65. So `97 > 65` = `true`.
`'z'` = 122, `'a'` = 97. `122 - 97 = 25` (number of letters from a to z).

---

### ❓ Q8. Will this compile?

```java
boolean result = (1 < 2 < 3);
```

**Answer:** ❌ Compile error — same as Q4.

`1 < 2` evaluates to `true` (boolean), then `true < 3` is invalid.

**Fix:**
```java
boolean result = (1 < 2) && (2 < 3);  // ✅ true
```

---

## 📝 Summary

```
RELATIONAL OPERATORS QUICK REFERENCE
──────────────────────────────────────────────────────────────────
 ==   Equal to             → use .equals() for objects/strings!
 !=   Not equal to         → opposite of ==
 >    Greater than         → strict, does NOT include equal
 <    Less than            → strict, does NOT include equal
 >=   Greater or equal     → includes the equal case
 <=   Less or equal        → includes the equal case

ALL return boolean: true or false

KEY RULES:
✅  primitives       → use == safely
✅  objects/Strings  → always use .equals()
✅  null check       → use == null  (never .equals() on null!)
✅  NaN              → use Double.isNaN(), never ==
✅  Integer wrapper  → .equals() for values outside -128 to 127
✅  char comparison  → promoted to int (Unicode values compared)
✅  chained compare  → must use && / ||  (no  1 < x < 10)
```

---
# 3.3 — Logical Operators in Java

> 📘 *Reference: Java The Complete Reference — Herbert Schildt*

---

## 📌 What are Logical Operators?

Logical operators work on **boolean values** and combine multiple conditions
to produce a single `true` or `false` result.

They are the decision-making engine of every real application —
login systems, validations, filters, access control — all rely on logical operators.

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `&&` | Logical AND (short-circuit) | `true && false` | `false` |
| `\|\|` | Logical OR (short-circuit) | `true \|\| false` | `true` |
| `!` | Logical NOT | `!true` | `false` |
| `^` | Logical XOR | `true ^ false` | `true` |
| `&` | Bitwise AND (non-short-circuit) | `true & false` | `false` |
| `\|` | Bitwise OR (non-short-circuit) | `true \| false` | `true` |

---

## 🧠 Truth Tables — The Foundation

Before diving into code, understand these truth tables by heart:

### AND `&&` — Both must be true

| A | B | A && B |
|---|---|--------|
| true | true | **true** |
| true | false | false |
| false | true | false |
| false | false | false |

> 💡 Think of `&&` as: **"ALL conditions must pass"**

---

### OR `||` — At least one must be true

| A | B | A \|\| B |
|---|---|--------|
| true | true | **true** |
| true | false | **true** |
| false | true | **true** |
| false | false | false |

> 💡 Think of `||` as: **"ANY one condition passing is enough"**

---

### NOT `!` — Flips the value

| A | !A |
|---|----|
| true | false |
| false | true |

> 💡 Think of `!` as: **"opposite of"**

---

### XOR `^` — Exactly one must be true

| A | B | A ^ B |
|---|---|-------|
| true | true | false |
| true | false | **true** |
| false | true | **true** |
| false | false | false |

> 💡 Think of `^` as: **"one or the other, but NOT both"**

---

## ✅ 1. AND Operator `&&`

Returns `true` only when **ALL conditions** are `true`.
Uses **short-circuit evaluation** — if the first condition is `false`,
the second is **never evaluated**.

```java
public class ANDOperatorDemo {
    public static void main(String[] args) {

        // --- Basic AND ---
        boolean hasTicket   = true;
        boolean hasID       = true;
        boolean canEnter    = hasTicket && hasID;   // both must be true
        System.out.println("Can Enter: " + canEnter);    // Can Enter: true

        boolean hasTicket2  = true;
        boolean hasID2      = false;
        boolean canEnter2   = hasTicket2 && hasID2;  // one is false → false
        System.out.println("Can Enter: " + canEnter2);   // Can Enter: false

        // --- Real world 1: Login validation ---
        String  correctUser = "admin";
        String  correctPass = "pass123";
        String  inputUser   = "admin";
        String  inputPass   = "pass123";

        // Both username AND password must match
        if (inputUser.equals(correctUser) && inputPass.equals(correctPass)) {
            System.out.println("✅ Login successful!");      // ✅ Login successful!
        } else {
            System.out.println("❌ Invalid credentials");
        }

        // --- Real world 2: Loan eligibility ---
        int    age          = 28;
        double salary       = 55000.0;    // monthly salary
        int    creditScore  = 720;

        // All three conditions must pass for loan approval
        boolean eligible = (age >= 21) && (salary >= 30000) && (creditScore >= 700);
        System.out.println("Loan Eligible: " + eligible);   // Loan Eligible: true

        // --- Real world 3: Safe array access (null check before use) ---
        String name = "Alice";
        // Check name is not null AND not empty — both with &&
        if (name != null && name.length() > 0) {
            System.out.println("Hello, " + name + "!");     // Hello, Alice!
        }
        // If name were null, name.length() would throw NullPointerException
        // Short-circuit saves us — if first condition (name != null) is false,
        // second condition (name.length() > 0) is NEVER evaluated

        // --- Real world 4: Range check ---
        int temperature = 37;
        // Is temperature in normal human range?
        if (temperature >= 36 && temperature <= 37) {
            System.out.println("Temperature normal ✅: " + temperature + "°C");
            // Temperature normal ✅: 37°C
        }

        // --- Real world 5: Triangle validity ---
        int a = 5, b = 7, c = 9;
        // All three triangle inequality conditions
        boolean isTriangle = (a + b > c) && (b + c > a) && (a + c > b);
        System.out.println("Valid Triangle: " + isTriangle);   // Valid Triangle: true
    }
}
```

---

## ✅ 2. OR Operator `||`

Returns `true` when **at least one condition** is `true`.
Uses **short-circuit evaluation** — if the first condition is `true`,
the second is **never evaluated**.

```java
public class OROperatorDemo {
    public static void main(String[] args) {

        // --- Basic OR ---
        boolean isWeekend = true;
        boolean isHoliday = false;
        boolean isDayOff  = isWeekend || isHoliday;  // at least one true → true
        System.out.println("Day Off: " + isDayOff);    // Day Off: true

        boolean isWeekend2 = false;
        boolean isHoliday2 = false;
        boolean isDayOff2  = isWeekend2 || isHoliday2;  // both false → false
        System.out.println("Day Off: " + isDayOff2);   // Day Off: false

        // --- Real world 1: Access control ---
        boolean isAdmin   = false;
        boolean isManager = true;
        // Either admin OR manager can approve
        if (isAdmin || isManager) {
            System.out.println("✅ Access granted to approve");   // ✅ Access granted to approve
        }

        // --- Real world 2: Payment gateway fallback ---
        boolean upiAvailable   = false;
        boolean cardAvailable  = false;
        boolean netBanking     = true;
        // At least one payment method available
        if (upiAvailable || cardAvailable || netBanking) {
            System.out.println("💳 Payment method available");   // 💳 Payment method available
        }

        // --- Real world 3: Input validation (check for invalid input) ---
        String userInput = "";
        if (userInput == null || userInput.isEmpty()) {
            System.out.println("⚠️ Input cannot be empty!");    // ⚠️ Input cannot be empty!
        }
        // Short-circuit: if userInput is null, .isEmpty() is NEVER called
        // (avoids NullPointerException!)

        // --- Real world 4: Discount eligibility ---
        int    customerAge      = 65;
        boolean isStudentCard   = false;
        boolean isSeniorCitizen = customerAge >= 60;
        // Either student OR senior citizen gets discount
        if (isStudentCard || isSeniorCitizen) {
            System.out.println("🎉 10% discount applied!");     // 🎉 10% discount applied!
        }

        // --- Real world 5: Vowel checker ---
        char letter = 'E';
        char lower  = Character.toLowerCase(letter);
        if (lower == 'a' || lower == 'e' || lower == 'i'
                         || lower == 'o' || lower == 'u') {
            System.out.println(letter + " is a Vowel ✅");      // E is a Vowel ✅
        } else {
            System.out.println(letter + " is a Consonant");
        }
    }
}
```

---

## ✅ 3. NOT Operator `!`

**Flips** (inverts) a boolean value. `true` becomes `false`, `false` becomes `true`.

```java
public class NOTOperatorDemo {
    public static void main(String[] args) {

        // --- Basic NOT ---
        boolean isOnline = false;
        System.out.println("Is online: "  + isOnline);    // Is online: false
        System.out.println("Is offline: " + !isOnline);   // Is offline: true

        // --- Real world 1: toggle switch ---
        boolean lightOn = true;
        System.out.println("Light is: " + (lightOn ? "ON" : "OFF"));  // Light is: ON

        lightOn = !lightOn;   // toggle — flip the state
        System.out.println("Light is: " + (lightOn ? "ON" : "OFF"));  // Light is: OFF

        lightOn = !lightOn;   // toggle again
        System.out.println("Light is: " + (lightOn ? "ON" : "OFF"));  // Light is: ON

        // --- Real world 2: check invalid input with ! ---
        String email = "alice@example.com";
        boolean isValidEmail = email.contains("@") && email.contains(".");

        if (!isValidEmail) {                                // if NOT valid
            System.out.println("❌ Invalid email");
        } else {
            System.out.println("✅ Valid email: " + email); // ✅ Valid email: alice@example.com
        }

        // --- Real world 3: while loop with ! ---
        boolean gameOver = false;
        int lives = 3;
        System.out.println("\n🎮 Game Started!");

        while (!gameOver) {                  // loop while game is NOT over
            System.out.println("Lives: " + lives);
            lives--;
            if (lives == 0) {
                gameOver = true;             // set flag to end loop
            }
        }
        System.out.println("💀 Game Over!");
        // 🎮 Game Started!
        // Lives: 3
        // Lives: 2
        // Lives: 1
        // 💀 Game Over!

        // --- Real world 4: isEmpty check negation ---
        java.util.List<String> cart = new java.util.ArrayList<>();
        cart.add("Apple");
        cart.add("Banana");

        if (!cart.isEmpty()) {               // if cart is NOT empty
            System.out.println("🛒 Items in cart: " + cart.size()); // 🛒 Items in cart: 2
        }
    }
}
```

---

## ✅ 4. XOR Operator `^`

Returns `true` only when **exactly ONE** operand is `true` (not both, not neither).

```java
public class XOROperatorDemo {
    public static void main(String[] args) {

        // --- Basic XOR ---
        System.out.println(true  ^ true);    // false (both true  → false)
        System.out.println(true  ^ false);   // true  (one true   → true)
        System.out.println(false ^ true);    // true  (one true   → true)
        System.out.println(false ^ false);   // false (none true  → false)

        // --- Real world 1: one-time password (OTP) entry ---
        // User should enter OTP exactly once (not never, not twice)
        boolean enteredFirstTime  = true;
        boolean enteredSecondTime = false;
        // XOR ensures it was entered exactly ONCE
        if (enteredFirstTime ^ enteredSecondTime) {
            System.out.println("✅ OTP entered once — valid!");   // ✅ OTP entered once — valid!
        } else {
            System.out.println("❌ OTP error");
        }

        // --- Real world 2: exactly one checkbox must be selected ---
        boolean optionA = false;
        boolean optionB = true;
        if (optionA ^ optionB) {
            System.out.println("✅ Exactly one option selected"); // ✅ Exactly one option selected
        } else {
            System.out.println("❌ Select exactly one option");
        }

        // --- Real world 3: swap two numbers WITHOUT temp variable (XOR trick!) ---
        int x = 10;
        int y = 25;
        System.out.println("\nBefore swap: x=" + x + ", y=" + y);  // x=10, y=25

        x = x ^ y;   // x = 10 ^ 25 = 19 (XOR both)
        y = x ^ y;   // y = 19 ^ 25 = 10 (recovers original x)
        x = x ^ y;   // x = 19 ^ 10 = 25 (recovers original y)

        System.out.println("After swap:  x=" + x + ", y=" + y);    // x=25, y=10
        // Numbers are swapped without any temporary variable!

        // --- Real world 4: find the odd-one-out (DSA trick!) ---
        // Array has every number twice except one — find the unique number
        int[] nums = {4, 3, 2, 4, 1, 3, 2};  // 1 appears once, rest twice
        int unique = 0;
        for (int n : nums) {
            unique ^= n;    // XOR of same numbers cancels out (a^a = 0)
        }
        System.out.println("\nUnique number: " + unique);   // Unique number: 1
        // 0^4^3^2^4^1^3^2 = (4^4)^(3^3)^(2^2)^1 = 0^0^0^1 = 1
    }
}
```

---

## ⚡ 5. Short-Circuit vs Non-Short-Circuit

This is one of the **most important concepts** — and a top interview topic!

```java
public class ShortCircuitDemo {
    public static void main(String[] args) {

        // ──────────────────────────────────────────────────────
        // SHORT-CIRCUIT AND (&&) — stops at first false
        // ──────────────────────────────────────────────────────
        int x = 5;

        // First condition is false → second is NEVER evaluated
        // x++ in second part does NOT execute
        boolean result1 = (x > 10) && (x++ < 20);
        System.out.println("result1: " + result1);   // false
        System.out.println("x after &&: " + x);      // 5 (x++ was NEVER executed!)

        // First condition is true → second IS evaluated
        x = 5;
        boolean result2 = (x > 3) && (x++ < 20);
        System.out.println("result2: " + result2);   // true
        System.out.println("x after &&: " + x);      // 6 (x++ WAS executed)

        // ──────────────────────────────────────────────────────
        // NON-SHORT-CIRCUIT AND (&) — ALWAYS evaluates both sides
        // ──────────────────────────────────────────────────────
        x = 5;
        boolean result3 = (x > 10) & (x++ < 20);   // & not &&
        System.out.println("result3: " + result3);   // false
        System.out.println("x after &: " + x);       // 6 (x++ was STILL executed!)

        // ──────────────────────────────────────────────────────
        // SHORT-CIRCUIT OR (||) — stops at first true
        // ──────────────────────────────────────────────────────
        x = 5;
        // First condition is true → second is NEVER evaluated
        boolean result4 = (x > 3) || (x++ < 20);
        System.out.println("result4: " + result4);   // true
        System.out.println("x after ||: " + x);      // 5 (x++ was NEVER executed!)

        // First condition is false → second IS evaluated
        x = 5;
        boolean result5 = (x > 10) || (x++ < 20);
        System.out.println("result5: " + result5);   // true
        System.out.println("x after ||: " + x);      // 6 (x++ WAS executed)

        // ──────────────────────────────────────────────────────
        // NON-SHORT-CIRCUIT OR (|) — ALWAYS evaluates both sides
        // ──────────────────────────────────────────────────────
        x = 5;
        boolean result6 = (x > 3) | (x++ < 20);    // | not ||
        System.out.println("result6: " + result6);   // true
        System.out.println("x after |: " + x);       // 6 (x++ was STILL executed!)
    }
}
```

### Summary of Short-Circuit Behavior:

| Operator | Short-Circuit? | Skips right side when? |
|----------|---------------|----------------------|
| `&&` | ✅ Yes | Left is `false` |
| `\|\|` | ✅ Yes | Left is `true` |
| `&` | ❌ No | Never — always evaluates both |
| `\|` | ❌ No | Never — always evaluates both |

---

## 🔗 Combining Logical Operators

```java
public class CombinedLogicDemo {
    public static void main(String[] args) {

        // --- Real world 1: flight booking eligibility ---
        int    age        = 25;
        boolean hasPassport = true;
        boolean hasVisa     = true;
        boolean isBlacklist = false;

        // Must have passport AND visa AND NOT be blacklisted
        boolean canFly = hasPassport && hasVisa && !isBlacklist;
        System.out.println("Can Fly: " + canFly);    // Can Fly: true

        // --- Real world 2: e-commerce discount rules ---
        boolean isPremiumMember = true;
        boolean isFirstPurchase = false;
        double  orderAmount     = 1500.0;

        // Premium OR first purchase, AND order above ₹1000
        boolean getsDiscount = (isPremiumMember || isFirstPurchase)
                                && (orderAmount > 1000);
        System.out.println("Gets Discount: " + getsDiscount);  // Gets Discount: true

        // --- Real world 3: security system ---
        boolean motionDetected = true;
        boolean doorOpen       = false;
        boolean systemArmed    = true;
        boolean ownerHome      = false;

        // Alert if: (motion OR door) AND system is armed AND owner NOT home
        boolean triggerAlert = (motionDetected || doorOpen)
                                && systemArmed
                                && !ownerHome;
        System.out.println("Alert Triggered: " + triggerAlert);  // Alert Triggered: true

        // --- Real world 4: leap year logic ---
        int year = 2024;
        // Leap year: divisible by 4, but not 100, UNLESS also by 400
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0)
                              || (year % 400 == 0);
        System.out.println(year + " is leap year: " + isLeapYear);  // 2024 is leap year: true

        // Test with different years
        int[] years = {1900, 2000, 2023, 2024, 2100};
        for (int y : years) {
            boolean leap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
            System.out.println(y + ": " + (leap ? "Leap ✅" : "Not Leap ❌"));
        }
        // 1900: Not Leap ❌  (divisible by 100 but not 400)
        // 2000: Leap ✅      (divisible by 400)
        // 2023: Not Leap ❌  (not divisible by 4)
        // 2024: Leap ✅      (divisible by 4, not by 100)
        // 2100: Not Leap ❌  (divisible by 100 but not 400)
    }
}
```

---

## 🌍 Real World Project — User Registration Validator

```java
public class RegistrationValidator {
    public static void main(String[] args) {

        // --- Simulated user input ---
        String  username    = "alice_99";
        String  email       = "alice@gmail.com";
        String  password    = "SecureP@ss1";
        int     age         = 20;
        boolean agreedToTOS = true;    // Terms of Service

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      REGISTRATION VALIDATOR      ║");
        System.out.println("╚══════════════════════════════════╝");

        // ── Validation 1: username length (3–20 chars, not null) ──
        boolean validUsername = (username != null)
                                 && (username.length() >= 3)
                                 && (username.length() <= 20);
        System.out.println("Username valid:   " + validUsername);       // true

        // ── Validation 2: email must contain @ and . ──
        boolean validEmail = (email != null)
                              && email.contains("@")
                              && email.contains(".");
        System.out.println("Email valid:      " + validEmail);          // true

        // ── Validation 3: password (min 8 chars, has uppercase, has digit) ──
        boolean hasMinLength  = password.length() >= 8;
        boolean hasUppercase  = !password.equals(password.toLowerCase()); // has uppercase
        boolean hasDigit      = password.matches(".*\\d.*");              // contains digit
        boolean validPassword = hasMinLength && hasUppercase && hasDigit;
        System.out.println("Password valid:   " + validPassword);        // true

        // ── Validation 4: age must be 13 or above ──
        boolean validAge = (age >= 13);
        System.out.println("Age valid:        " + validAge);             // true

        // ── Validation 5: must agree to Terms of Service ──
        System.out.println("TOS agreed:       " + agreedToTOS);         // true

        // ── Final: ALL validations must pass ──
        boolean canRegister = validUsername
                               && validEmail
                               && validPassword
                               && validAge
                               && agreedToTOS;

        System.out.println("──────────────────────────────────");
        if (canRegister) {
            System.out.println("✅ Registration Successful! Welcome, " + username);
        } else {
            System.out.println("❌ Registration Failed. Please fix errors.");
        }
    }
}
```

**Output:**
```
╔══════════════════════════════════╗
║      REGISTRATION VALIDATOR      ║
╚══════════════════════════════════╝
Username valid:   true
Email valid:      true
Password valid:   true
Age valid:        true
TOS agreed:       true
──────────────────────────────────
✅ Registration Successful! Welcome, alice_99
```

---

## 🎯 Tricky Interview Questions

---

### ❓ Q1. What is the output?

```java
int x = 10;
boolean result = (x > 5) || (x++ > 20);
System.out.println(x);
System.out.println(result);
```

**Answer:**
```
10
true
```
First condition `x > 5` is `true`. Short-circuit `||` — second condition `x++ > 20`
is **never evaluated**. So `x` stays `10`.

---

### ❓ Q2. What is the output?

```java
int x = 10;
boolean result = (x > 5) | (x++ > 20);
System.out.println(x);
System.out.println(result);
```

**Answer:**
```
11
true
```
`|` is **non-short-circuit** — BOTH sides are always evaluated.
So `x++` executes → `x` becomes `11`.

---

### ❓ Q3. What is the output?

```java
System.out.println(true && false || true);
System.out.println(true || false && false);
```

**Answer:**
```
true
true
```
`&&` has higher precedence than `||`.

Line 1: `(true && false) || true` = `false || true` = `true`
Line 2: `true || (false && false)` = `true || false` = `true`

---

### ❓ Q4. What is the output?

```java
boolean a = true;
boolean b = false;
System.out.println(a ^ b);
System.out.println(a ^ a);
System.out.println(b ^ b);
```

**Answer:**
```
true
false
false
```
XOR: different values → `true`. Same values → `false`.
`a ^ a` = `true ^ true` = `false` (same).
`b ^ b` = `false ^ false` = `false` (same).

---

### ❓ Q5. What is the output?

```java
int a = 5;
if ((a > 3) && (a > 4) && (a > 5)) {
    System.out.println("All true");
} else {
    System.out.println("Not all true");
}
```

**Answer:** `Not all true`

`a > 3` → `true`, `a > 4` → `true`, `a > 5` → `false`.
All three must be `true` for `&&` to give `true`. Third fails → `false`.

---

### ❓ Q6. Is this safe? What happens?

```java
String str = null;
if (str != null && str.length() > 5) {
    System.out.println("Long string");
} else {
    System.out.println("Short or null");
}
```

**Answer:** ✅ Safe. Output: `Short or null`

`str != null` is `false`. Short-circuit `&&` skips `str.length()`.
If we used `&` instead, `str.length()` would be called on `null` → **NullPointerException**.

---

### ❓ Q7. What is the output?

```java
boolean x = true;
boolean y = false;
boolean z = true;

System.out.println(x || y && z);   // line 1
System.out.println((x || y) && z); // line 2
```

**Answer:**
```
true
true
```
Line 1: `&&` has higher precedence → `x || (y && z)` = `true || false` = `true`
Line 2: parentheses force `||` first → `(true || false) && true` = `true && true` = `true`

Both happen to give same result here, but the evaluation order differs!

---

### ❓ Q8. How do you find a unique number in an array using XOR?

```java
int[] arr = {3, 5, 3, 4, 5};    // find the unique number (4)
int unique = 0;
for (int n : arr) {
    unique ^= n;
}
System.out.println("Unique: " + unique);
```

**Answer:** `Unique: 4`

XOR trick: `a ^ a = 0` (same number cancels itself).
`0 ^ 3 ^ 5 ^ 3 ^ 4 ^ 5` = `(3^3) ^ (5^5) ^ 4` = `0 ^ 0 ^ 4` = `4`

This is a famous **DSA interview question** solved in O(n) time and O(1) space!

---

### ❓ Q9. What is De Morgan's Law in Java?

**Answer:** De Morgan's Law is a logical rule to simplify NOT expressions:

```
!(A && B)  ==  (!A || !B)
!(A || B)  ==  (!A && !B)
```

```java
int age    = 15;
boolean hasParent = false;

// Original
boolean cannotEnter = !(age >= 18 && hasParent);

// De Morgan's equivalent
boolean cannotEnter2 = (age < 18 || !hasParent);

System.out.println(cannotEnter);    // true
System.out.println(cannotEnter2);   // true (same result!)
```

Very useful for simplifying complex conditions in real code.

---

## 📝 Summary

```
LOGICAL OPERATORS QUICK REFERENCE
──────────────────────────────────────────────────────────────────
 &&    AND  (short-circuit)    All must be true
 ||    OR   (short-circuit)    At least one must be true
 !     NOT                     Flips the boolean value
 ^     XOR                     Exactly ONE must be true
 &     AND  (non-short-circuit) Evaluates BOTH sides always
 |     OR   (non-short-circuit) Evaluates BOTH sides always

SHORT-CIRCUIT RULES:
 &&   → skips right side if LEFT is false
 ||   → skips right side if LEFT is true
 &    → ALWAYS evaluates both sides
 |    → ALWAYS evaluates both sides

PRECEDENCE (high to low):
 !   →  &&   →  ^   →  ||

KEY PATTERNS:
✅  null-safe check      →  obj != null && obj.method()
✅  null-safe OR         →  obj == null || obj.isEmpty()
✅  toggle boolean       →  flag = !flag
✅  range check          →  x >= low && x <= high
✅  find unique (XOR)    →  unique ^= n  (pairs cancel out)
✅  De Morgan's Law      →  !(A && B) == (!A || !B)
```

---
# 3.4 — Bitwise Operators in Java

> 📘 *Reference: Java The Complete Reference — Herbert Schildt*

---

## 📌 What are Bitwise Operators?

Bitwise operators work directly on the **binary (bit-level) representation**
of numbers. Instead of working on the whole number, they manipulate
**individual bits** (0s and 1s).

They are heavily used in:
- 🎮 Game development (flags, permissions)
- 🌐 Networking (IP masking, subnet)
- 🔐 Cryptography & security
- ⚡ Performance-critical code (faster than multiply/divide)
- 💡 DSA problems (finding unique elements, subsets, etc.)

| Operator | Name | Example |
|----------|------|---------|
| `&` | Bitwise AND | `5 & 3` → `1` |
| `\|` | Bitwise OR | `5 \| 3` → `7` |
| `^` | Bitwise XOR | `5 ^ 3` → `6` |
| `~` | Bitwise NOT (complement) | `~5` → `-6` |
| `<<` | Left Shift | `5 << 1` → `10` |
| `>>` | Signed Right Shift | `5 >> 1` → `2` |
| `>>>` | Unsigned Right Shift | `-1 >>> 1` → `2147483647` |

---

## 🧠 Binary Refresher (Must Know!)

Every integer is stored as **32 bits** in Java.

```
Decimal    Binary (32-bit, showing last 8 bits for clarity)
────────   ──────────────────────────────────────────────
  0      = 0000 0000
  1      = 0000 0001
  2      = 0000 0010
  3      = 0000 0011
  4      = 0000 0100
  5      = 0000 0101
  6      = 0000 0110
  7      = 0000 0111
  8      = 0000 1000
 10      = 0000 1010
 15      = 0000 1111
 -1      = 1111 1111 1111 1111 1111 1111 1111 1111  (all bits set)
```

```java
// Useful methods to see binary representation
System.out.println(Integer.toBinaryString(5));   // 101
System.out.println(Integer.toBinaryString(10));  // 1010
System.out.println(Integer.toBinaryString(-1));  // 11111111111111111111111111111111
```

---

## 🔵 1. Bitwise AND `&`

Compares each bit of two numbers.
Result bit is `1` only if **BOTH** corresponding bits are `1`.

```
Bit Rule:  0 & 0 = 0
           0 & 1 = 0
           1 & 0 = 0
           1 & 1 = 1   ← only this gives 1
```

```java
public class BitwiseANDDemo {
    public static void main(String[] args) {

        int a = 5;    //  5 = 0000 0101
        int b = 3;    //  3 = 0000 0011
        int result = a & b;
        //                    0000 0101
        //                  & 0000 0011
        //                  ──────────
        //                    0000 0001  = 1
        System.out.println("5 & 3 = " + result);   // 5 & 3 = 1

        // --- Real world 1: Check if number is EVEN or ODD ---
        // Even numbers always have last bit = 0
        // Odd  numbers always have last bit = 1
        // So:  n & 1 == 0 → even,  n & 1 == 1 → odd
        int[] nums = {4, 7, 12, 9, 20, 15};
        System.out.println("\nEven/Odd check using & 1:");
        for (int n : nums) {
            if ((n & 1) == 0) {
                System.out.println(n + " → Even");   // 4→Even, 12→Even, 20→Even
            } else {
                System.out.println(n + " → Odd");    // 7→Odd, 9→Odd, 15→Odd
            }
        }
        // This is FASTER than n % 2 == 0 because bit ops skip division!

        // --- Real world 2: Check if specific bit is SET ---
        // Is bit position 2 (value 4) set in a number?
        int flags = 13;    // 13 = 1101 in binary
        int mask  = 4;     //  4 = 0100 in binary (checking bit position 2)
        boolean isBitSet = (flags & mask) != 0;
        System.out.println("\nBit 2 set in " + flags + "? " + isBitSet);  // true

        // --- Real world 3: Permission system (like Unix file permissions) ---
        // Permissions stored as bits: READ=4(100), WRITE=2(010), EXECUTE=1(001)
        final int READ    = 4;   // 100
        final int WRITE   = 2;   // 010
        final int EXECUTE = 1;   // 001

        int userPermission = 6;  // 110 = READ + WRITE (no execute)

        System.out.println("\nPermission Check:");
        System.out.println("Can Read:    " + ((userPermission & READ)    != 0));  // true
        System.out.println("Can Write:   " + ((userPermission & WRITE)   != 0));  // true
        System.out.println("Can Execute: " + ((userPermission & EXECUTE) != 0));  // false

        // --- Real world 4: Extract lower 4 bits (nibble) ---
        int number = 0b11011010;    // 218 in decimal
        int lowerNibble = number & 0x0F;   // 0x0F = 0000 1111 (mask lower 4 bits)
        System.out.println("\nLower nibble of " + number + " = " + lowerNibble);  // 10
    }
}
```

---

## 🟢 2. Bitwise OR `|`

Result bit is `1` if **AT LEAST ONE** of the corresponding bits is `1`.

```
Bit Rule:  0 | 0 = 0
           0 | 1 = 1
           1 | 0 = 1
           1 | 1 = 1   ← both 1 also gives 1
```

```java
public class BitwiseORDemo {
    public static void main(String[] args) {

        int a = 5;    //  5 = 0000 0101
        int b = 3;    //  3 = 0000 0011
        int result = a | b;
        //                    0000 0101
        //                  | 0000 0011
        //                  ──────────
        //                    0000 0111  = 7
        System.out.println("5 | 3 = " + result);   // 5 | 3 = 7

        // --- Real world 1: SET a specific bit ---
        // Set bit at position 1 (value = 2 = 010)
        int value  = 5;    // 101
        int setBit = 2;    // 010
        int after  = value | setBit;
        //           101
        //         | 010
        //         ─────
        //           111  = 7
        System.out.println("\nSet bit 1 in 5: " + after);  // 7

        // --- Real world 2: Combine permissions ---
        final int READ    = 4;  // 100
        final int WRITE   = 2;  // 010
        final int EXECUTE = 1;  // 001

        // Grant READ and EXECUTE permissions
        int permissions = READ | EXECUTE;
        //                 100
        //               | 001
        //               ─────
        //                 101  = 5
        System.out.println("\nREAD | EXECUTE = " + permissions);  // 5

        // Now add WRITE permission later
        permissions = permissions | WRITE;
        //              101
        //            | 010
        //            ─────
        //              111  = 7  (full permissions!)
        System.out.println("After adding WRITE: " + permissions);  // 7

        // --- Real world 3: Convert lowercase to uppercase (for ASCII letters) ---
        // Uppercase letters: 65-90,  Binary: 0100 0001 to 0101 1010
        // Lowercase letters: 97-122, Binary: 0110 0001 to 0111 1010
        // Difference: bit 5 (value 32) is set in lowercase
        // Set bit 5 → convert to lowercase:  char | 32
        char upper = 'A';  // 65 = 0100 0001
        char lower = (char)(upper | 32);
        //            0100 0001
        //          | 0010 0000
        //          ──────────
        //            0110 0001  = 97 = 'a'
        System.out.println("\n'A' | 32 = '" + lower + "'");  // 'a'
    }
}
```

---

## 🟡 3. Bitwise XOR `^`

Result bit is `1` if bits are **DIFFERENT**, `0` if they are the **SAME**.

```
Bit Rule:  0 ^ 0 = 0   (same → 0)
           0 ^ 1 = 1   (different → 1)
           1 ^ 0 = 1   (different → 1)
           1 ^ 1 = 0   (same → 0)
```

```java
public class BitwiseXORDemo {
    public static void main(String[] args) {

        int a = 5;    //  5 = 0000 0101
        int b = 3;    //  3 = 0000 0011
        int result = a ^ b;
        //                    0000 0101
        //                  ^ 0000 0011
        //                  ──────────
        //                    0000 0110  = 6
        System.out.println("5 ^ 3 = " + result);   // 5 ^ 3 = 6

        // --- Key XOR Properties ---
        int x = 42;
        System.out.println("\nXOR Properties:");
        System.out.println("x ^ 0  = " + (x ^ 0));    // 42 (XOR with 0 = same number)
        System.out.println("x ^ x  = " + (x ^ x));    // 0  (XOR with itself = 0)
        System.out.println("x ^ ~x = " + (x ^ ~x));   // -1 (all bits set)

        // --- Real world 1: SWAP without temp variable ---
        int p = 15;
        int q = 27;
        System.out.println("\nBefore swap: p=" + p + ", q=" + q);  // p=15, q=27

        p = p ^ q;   // p = 15 ^ 27
        q = p ^ q;   // q = (15^27) ^ 27 = 15  (original p!)
        p = p ^ q;   // p = (15^27) ^ 15 = 27  (original q!)

        System.out.println("After  swap: p=" + p + ", q=" + q);    // p=27, q=15

        // --- Real world 2: Find single non-duplicate in array (DSA!) ---
        // Every number appears TWICE except one — find it in O(n), O(1) space
        int[] arr = {2, 4, 6, 4, 2, 7, 6};  // 7 is unique
        int unique = 0;
        for (int n : arr) {
            unique ^= n;    // duplicates cancel: n^n = 0
        }
        System.out.println("\nUnique number: " + unique);  // 7

        // --- Real world 3: Toggle a specific bit ---
        int num    = 0b1010;    // 10 in decimal
        int toggle = 0b0010;    //  2 — toggle bit 1
        int toggled = num ^ toggle;
        //              1010
        //            ^ 0010
        //            ──────
        //              1000  = 8 (bit 1 was 1, now 0 — toggled!)
        System.out.println("\n1010 ^ 0010 = " + Integer.toBinaryString(toggled)
                           + " (" + toggled + ")");   // 1000 (8)

        // Toggle again to restore
        int restored = toggled ^ toggle;
        System.out.println("Toggled back:  " + Integer.toBinaryString(restored)
                           + " (" + restored + ")");  // 1010 (10)

        // --- Real world 4: Simple encryption/decryption ---
        // XOR with same key twice restores original value!
        int data = 72;    // secret data
        int key  = 53;    // encryption key

        int encrypted = data ^ key;       // encrypt
        int decrypted = encrypted ^ key;  // decrypt (XOR again with same key)

        System.out.println("\nOriginal:  " + data);        // 72
        System.out.println("Encrypted: " + encrypted);    // 121
        System.out.println("Decrypted: " + decrypted);    // 72 (restored!)
    }
}
```

---

## ⚫ 4. Bitwise NOT `~` (Complement)

**Flips ALL bits** — every `0` becomes `1`, every `1` becomes `0`.

```
~0 = 1
~1 = 0
```

**Formula:** `~n = -(n + 1)`  ← always!

```java
public class BitwiseNOTDemo {
    public static void main(String[] args) {

        int a = 5;    //  5 = 0000 0000 0000 0000 0000 0000 0000 0101
        int result = ~a;
        //         ~5 = 1111 1111 1111 1111 1111 1111 1111 1010 = -6
        System.out.println("~5 = " + result);    // ~5 = -6

        // Formula: ~n = -(n+1)
        System.out.println("~0  = " + ~0);    // -1
        System.out.println("~1  = " + ~1);    // -2
        System.out.println("~-1 = " + ~-1);   //  0
        System.out.println("~7  = " + ~7);    // -8

        // --- Real world: create bit masks using ~ ---
        // Clear (turn off) a specific bit using AND NOT
        int flags  = 0b1111;   // 15 — all bits on
        int bitPos = 2;
        int mask   = ~(1 << bitPos);   // create mask with bit 2 cleared
        int cleared = flags & mask;
        //   1111  (flags)
        // & 1011  (mask — bit 2 cleared)
        // ──────
        //   1011  = 11
        System.out.println("\nAfter clearing bit 2: " + cleared);   // 11

        // --- DSA use: ~i as (-(i+1)) for special values ---
        // indexOf returns -1 when not found
        // Using ~result to check: ~(-1) = 0 = false, ~(any valid index) ≠ 0 = true
        String text = "Hello Java";
        int index   = text.indexOf("Java");     // found at index 6
        if (~index != 0) {                      // ~6 = -7 ≠ 0 → true = found
            System.out.println("\n'Java' found at index: " + index);   // 6
        }

        int index2 = text.indexOf("Python");    // not found → -1
        if (~index2 == 0) {                     // ~(-1) = 0 → true = not found
            System.out.println("'Python' not found");   // Python not found
        }
    }
}
```

---

## 🔴 5. Left Shift `<<`

Shifts all bits to the **LEFT** by specified positions.
Fills empty positions on the right with `0`.

**Effect:** `n << k` = `n × 2ᵏ`  ← multiplying by powers of 2!

```java
public class LeftShiftDemo {
    public static void main(String[] args) {

        int a = 5;    //  5 = 0000 0101
        // << 1
        //   0000 1010  = 10  (shifted left by 1, filled 0 on right)
        System.out.println("5 << 1 = " + (a << 1));   // 10  (5 * 2^1 = 10)
        System.out.println("5 << 2 = " + (a << 2));   // 20  (5 * 2^2 = 20)
        System.out.println("5 << 3 = " + (a << 3));   // 40  (5 * 2^3 = 40)

        // Left shift = multiply by 2 per shift
        System.out.println("\n1 << 0  = " + (1 << 0));   //   1
        System.out.println("1 << 1  = " + (1 << 1));     //   2
        System.out.println("1 << 2  = " + (1 << 2));     //   4
        System.out.println("1 << 3  = " + (1 << 3));     //   8
        System.out.println("1 << 4  = " + (1 << 4));     //  16
        System.out.println("1 << 10 = " + (1 << 10));    // 1024

        // --- Real world 1: Fast power of 2 ---
        // n << k is MUCH faster than Math.pow(2, k)
        int twoToThe8 = 1 << 8;    // 256 — fast!
        System.out.println("\n2^8 = " + twoToThe8);   // 256

        // --- Real world 2: Set a bit at position k ---
        // To set bit at position k: original | (1 << k)
        int num  = 0b1010;   // 10
        int pos  = 2;
        int setB = num | (1 << pos);
        //   1010
        // | 0100  (1 << 2 = 4 = 0100)
        // ──────
        //   1110  = 14
        System.out.println("\nSet bit 2 in 1010: " + Integer.toBinaryString(setB)
                           + " (" + setB + ")");   // 1110 (14)

        // --- Real world 3: Create byte flags ---
        // Each feature stored as a single bit
        int DARK_MODE   = 1 << 0;   // bit 0 = 1
        int NOTIFICATIONS = 1 << 1; // bit 1 = 2
        int AUTO_SAVE   = 1 << 2;   // bit 2 = 4
        int SYNC        = 1 << 3;   // bit 3 = 8

        int settings = 0;
        settings |= DARK_MODE;      // turn on dark mode
        settings |= AUTO_SAVE;      // turn on auto save

        System.out.println("\nSettings value: " + settings);               // 5 (0101)
        System.out.println("Dark Mode on?   " + ((settings & DARK_MODE)   != 0)); // true
        System.out.println("Notifs on?      " + ((settings & NOTIFICATIONS) != 0)); // false
        System.out.println("Auto Save on?   " + ((settings & AUTO_SAVE)   != 0)); // true
        System.out.println("Sync on?        " + ((settings & SYNC)        != 0)); // false
    }
}
```

---

## 🟠 6. Signed Right Shift `>>`

Shifts all bits to the **RIGHT** by specified positions.
Fills empty positions on the LEFT with the **sign bit** (0 for positive, 1 for negative).

**Effect:** `n >> k` = `n / 2ᵏ`  ← dividing by powers of 2 (rounds toward negative infinity)

```java
public class SignedRightShiftDemo {
    public static void main(String[] args) {

        int a = 20;    // 20 = 0001 0100
        // >> 1
        //     0000 1010  = 10  (shifted right by 1, filled 0 on left — positive)
        System.out.println("20 >> 1 = " + (a >> 1));   // 10  (20 / 2^1 = 10)
        System.out.println("20 >> 2 = " + (a >> 2));   //  5  (20 / 2^2 = 5)
        System.out.println("20 >> 3 = " + (a >> 3));   //  2  (20 / 2^3 = 2, truncated)

        // Sign bit preserved for negative numbers
        int neg = -20;
        System.out.println("\n-20 >> 1 = " + (neg >> 1));   // -10
        System.out.println("-20 >> 2 = " + (neg >> 2));     // -5
        // Fills with 1s on the left (sign bit = 1 for negative)

        // --- Real world 1: Fast integer division by 2 ---
        int big = 1024;
        System.out.println("\n1024 >> 1 = " + (big >> 1));    // 512
        System.out.println("1024 >> 2 = " + (big >> 2));    // 256
        System.out.println("1024 >> 10 = " + (big >> 10));  //   1

        // --- Real world 2: Middle index (binary search midpoint) ---
        int low  = 0;
        int high = 100;
        int mid  = (low + high) >> 1;    // same as (low+high)/2 but safer for large values
        System.out.println("\nMidpoint of [" + low + "," + high + "] = " + mid);  // 50

        // --- Real world 3: Extract individual bytes from an int ---
        int rgba = 0xFF8800AA;    // packed color: R=FF, G=88, B=00, A=AA
        int alpha = (rgba >> 24) & 0xFF;    // shift right 24, keep last 8 bits
        int red   = (rgba >> 16) & 0xFF;
        int green = (rgba >> 8)  & 0xFF;
        int blue  =  rgba        & 0xFF;
        System.out.println("\nPacked RGBA: 0xFF8800AA");
        System.out.printf("Alpha: 0x%02X (%d)%n", alpha, alpha);   // Alpha: 0xFF (255)
        System.out.printf("Red:   0x%02X (%d)%n", red,   red);     // Red:   0x88 (136)
        System.out.printf("Green: 0x%02X (%d)%n", green, green);   // Green: 0x00 (0)
        System.out.printf("Blue:  0x%02X (%d)%n", blue,  blue);    // Blue:  0xAA (170)
    }
}
```

---

## 🔵 7. Unsigned Right Shift `>>>`

Shifts bits to the RIGHT. Always fills with **`0`** on the left —
regardless of the sign bit. So even negative numbers become positive.

```java
public class UnsignedRightShiftDemo {
    public static void main(String[] args) {

        // Positive number — same as >>
        int pos = 20;
        System.out.println("20  >>> 1 = " + (pos >>> 1));   // 10  (same as >>)

        // Negative number — DIFFERENT from >>
        int neg = -20;
        System.out.println("-20 >> 1  = " + (neg >> 1));    // -10 (sign preserved)
        System.out.println("-20 >>> 1 = " + (neg >>> 1));   // 2147483638 (huge positive!)

        // Extreme case: -1
        System.out.println("\n-1 >> 1  = " + (-1 >> 1));    // -1  (all 1s shifted right, still -1)
        System.out.println("-1 >>> 1 = " + (-1 >>> 1));     // Integer.MAX_VALUE = 2147483647

        // --- How it works for -1 ---
        // -1  = 1111 1111 1111 1111 1111 1111 1111 1111  (all bits 1)
        // >>> 1 fills with 0:
        //       0111 1111 1111 1111 1111 1111 1111 1111  = 2147483647

        // --- Real world: safe midpoint calculation in binary search ---
        int low  = 0;
        int high = Integer.MAX_VALUE;   // extreme case!

        // Overflow-safe midpoint using >>>
        int mid = (low + high) >>> 1;   // even if low+high overflows, >>> makes it correct
        System.out.println("\nSafe midpoint: " + mid);   // 1073741823 ✅

        // Unsafe version:
        int unsafeMid = (low + high) / 2;   // low+high overflows → negative → wrong!
        System.out.println("Unsafe midpoint: " + unsafeMid);  // -1073741824 ❌
    }
}
```

---

## 🌍 Real World Project — Bit Flags Settings System

```java
public class AppSettingsSystem {
    public static void main(String[] args) {

        // Define each setting as a unique bit position
        final int DARK_MODE       = 1 << 0;   // 0000 0001 = 1
        final int NOTIFICATIONS   = 1 << 1;   // 0000 0010 = 2
        final int AUTO_SAVE       = 1 << 2;   // 0000 0100 = 4
        final int LOCATION        = 1 << 3;   // 0000 1000 = 8
        final int ANALYTICS       = 1 << 4;   // 0001 0000 = 16
        final int BIOMETRIC_LOGIN = 1 << 5;   // 0010 0000 = 32

        // Start with default settings (all OFF)
        int settings = 0;

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║     APP SETTINGS SYSTEM        ║");
        System.out.println("╚════════════════════════════════╝");

        // ── Turn ON settings using OR ──
        settings |= DARK_MODE;          // turn on dark mode
        settings |= AUTO_SAVE;          // turn on auto save
        settings |= NOTIFICATIONS;      // turn on notifications
        System.out.println("\n[After initial setup]");
        printSettings(settings, DARK_MODE, NOTIFICATIONS, AUTO_SAVE,
                      LOCATION, ANALYTICS, BIOMETRIC_LOGIN);

        // ── Turn OFF a setting using AND with NOT ──
        settings &= ~NOTIFICATIONS;     // turn off notifications
        System.out.println("\n[After turning off Notifications]");
        printSettings(settings, DARK_MODE, NOTIFICATIONS, AUTO_SAVE,
                      LOCATION, ANALYTICS, BIOMETRIC_LOGIN);

        // ── Toggle a setting using XOR ──
        settings ^= DARK_MODE;          // toggle dark mode (was ON → now OFF)
        System.out.println("\n[After toggling Dark Mode]");
        printSettings(settings, DARK_MODE, NOTIFICATIONS, AUTO_SAVE,
                      LOCATION, ANALYTICS, BIOMETRIC_LOGIN);

        // ── Check if a setting is ON using AND ──
        System.out.println("\n[Specific checks]");
        System.out.println("Is Dark Mode ON?     " + ((settings & DARK_MODE) != 0));
        System.out.println("Is Auto Save ON?     " + ((settings & AUTO_SAVE) != 0));
        System.out.println("Is Location ON?      " + ((settings & LOCATION) != 0));

        // ── Count how many settings are ON ──
        int bitsSet = Integer.bitCount(settings);   // Java built-in popcount
        System.out.println("\nTotal active settings: " + bitsSet);
    }

    static void printSettings(int s, int dm, int notif, int as, int loc, int an, int bio) {
        System.out.println("  Dark Mode:       " + (((s & dm)    != 0) ? "ON  ✅" : "OFF ❌"));
        System.out.println("  Notifications:   " + (((s & notif) != 0) ? "ON  ✅" : "OFF ❌"));
        System.out.println("  Auto Save:       " + (((s & as)    != 0) ? "ON  ✅" : "OFF ❌"));
        System.out.println("  Location:        " + (((s & loc)   != 0) ? "ON  ✅" : "OFF ❌"));
        System.out.println("  Analytics:       " + (((s & an)    != 0) ? "ON  ✅" : "OFF ❌"));
        System.out.println("  Biometric Login: " + (((s & bio)   != 0) ? "ON  ✅" : "OFF ❌"));
        System.out.printf ("  Settings byte: %8s%n", Integer.toBinaryString(s));
    }
}
```

**Output:**
```
╔════════════════════════════════╗
║     APP SETTINGS SYSTEM        ║
╚════════════════════════════════╝

[After initial setup]
  Dark Mode:       ON  ✅
  Notifications:   ON  ✅
  Auto Save:       ON  ✅
  Location:        OFF ❌
  Analytics:       OFF ❌
  Biometric Login: OFF ❌
  Settings byte:      111

[After turning off Notifications]
  Dark Mode:       ON  ✅
  Notifications:   OFF ❌
  Auto Save:       ON  ✅
  ...
  Settings byte:      101

[After toggling Dark Mode]
  Dark Mode:       OFF ❌
  Notifications:   OFF ❌
  Auto Save:       ON  ✅
  ...
  Settings byte:      100
```

---

## 🎯 Tricky Interview Questions

---

### ❓ Q1. What is the output?

```java
System.out.println(5 & 3);
System.out.println(5 | 3);
System.out.println(5 ^ 3);
System.out.println(~5);
```

**Answer:**
```
1
7
6
-6
```
`5=101, 3=011`
`101 & 011 = 001 = 1`
`101 | 011 = 111 = 7`
`101 ^ 011 = 110 = 6`
`~5 = -(5+1) = -6`

---

### ❓ Q2. How to check if a number is a power of 2?

```java
int n = 16;
boolean isPowerOf2 = (n > 0) && ((n & (n - 1)) == 0);
System.out.println(isPowerOf2);   // true
```

**Answer:** `true`

Powers of 2 in binary have exactly **one bit set**:
`16 = 10000`, `n-1 = 01111`. `n & (n-1) = 0` → power of 2!

Non-power: `12 = 1100`, `11 = 1011`. `1100 & 1011 = 1000 ≠ 0`

---

### ❓ Q3. What is the output?

```java
System.out.println(-1 >> 1);
System.out.println(-1 >>> 1);
```

**Answer:**
```
-1
2147483647
```
`>>` preserves sign bit — `-1` stays `-1`.
`>>>` fills with `0` — all 1s become `0111...1` = `Integer.MAX_VALUE`.

---

### ❓ Q4. How to get the `n`th bit of a number?

```java
int num = 13;   // 1101
int n   = 2;    // check bit position 2
int bit = (num >> n) & 1;
System.out.println("Bit " + n + " of " + num + " = " + bit);
```

**Answer:** `Bit 2 of 13 = 1`

Shift right by `n` to bring bit `n` to position 0, then AND with `1` to isolate it.
`13 >> 2 = 3 = 11`, `11 & 01 = 01 = 1` ✅

---

### ❓ Q5. What is the output?

```java
int x = 0xFF;
System.out.println(x);
System.out.println(x >> 4);
System.out.println(x & 0x0F);
```

**Answer:**
```
255
15
15
```
`0xFF = 255 = 1111 1111`
`255 >> 4 = 0000 1111 = 15` (upper nibble)
`255 & 0x0F = 0000 1111 = 15` (lower nibble)

---

### ❓ Q6. Count the number of 1-bits (set bits) in an integer?

```java
// Method 1: Built-in
int n = 13;   // 1101 — three 1-bits
System.out.println(Integer.bitCount(n));  // 3

// Method 2: Manual using & 1
int count = 0;
while (n != 0) {
    count += (n & 1);   // check last bit
    n >>= 1;            // shift right
}
System.out.println(count);   // 3
```

**Answer:** `3` (both methods)
`13 = 1101` → three `1` bits. This is the **Hamming Weight / popcount** problem.

---

### ❓ Q7. What does `n & (n-1)` do?

**Answer:** It **clears the rightmost set bit** of `n`.

```java
int n = 12;   // 1100
System.out.println(Integer.toBinaryString(n & (n-1)));  // 1000 (cleared rightmost 1-bit)

// Use case: count set bits efficiently
int num = 13;   // 1101
int bits = 0;
while (num != 0) {
    num &= (num - 1);   // clear rightmost set bit each iteration
    bits++;
}
System.out.println("Set bits: " + bits);   // 3
```

---

## 📝 Summary

```
BITWISE OPERATORS QUICK REFERENCE
──────────────────────────────────────────────────────────────────
 &    AND      Both bits must be 1    → turn OFF / check / mask
 |    OR       At least one bit is 1  → turn ON / combine flags
 ^    XOR      Bits must differ       → toggle / swap / encrypt
 ~    NOT      Flip all bits          → complement, ~n = -(n+1)
 <<   Left     Shift left, fill 0s    → multiply by 2^k (fast!)
 >>   Right    Shift right, fill sign → divide  by 2^k (fast!)
 >>>  Unsigned Shift right, fill 0s   → always positive result

BIT MANIPULATION CHEAT SHEET:
✅  Check if even       →  (n & 1) == 0
✅  Set bit k           →  n | (1 << k)
✅  Clear bit k         →  n & ~(1 << k)
✅  Toggle bit k        →  n ^ (1 << k)
✅  Get bit k           →  (n >> k) & 1
✅  Power of 2 check    →  n > 0 && (n & (n-1)) == 0
✅  Swap without temp   →  a^=b; b^=a; a^=b
✅  Find unique element →  XOR all elements
✅  Count set bits      →  Integer.bitCount(n)
✅  Clear rightmost 1   →  n & (n-1)
✅  Multiply by 2^k     →  n << k
✅  Divide by 2^k       →  n >> k
✅  Safe midpoint       →  (low + high) >>> 1
```

---

# 3.6 — Ternary Operator in Java

> 📘 *Reference: Java The Complete Reference — Herbert Schildt*

---

## 📌 What is the Ternary Operator?

The ternary operator is Java's only **3-operand operator**.
It is a shorthand for a simple `if-else` statement that returns a value.

```
condition ? valueIfTrue : valueIfFalse
    ▲              ▲            ▲
 boolean       returned      returned
expression    if true       if false
```

It is called "ternary" because it takes **three operands**:
1. A condition (boolean expression)
2. Value/expression if condition is `true`
3. Value/expression if condition is `false`

---

## 🔵 Syntax & Basic Usage

```java
public class TernaryBasic {
    public static void main(String[] args) {

        // ── Basic syntax ──────────────────────────────
        int a = 10;
        int b = 20;

        // Traditional if-else
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        System.out.println("Max (if-else): " + max);   // 20

        // Same using ternary — cleaner, one line
        int maxT = (a > b) ? a : b;
        System.out.println("Max (ternary): " + maxT);  // 20

        // ── Assign result to variable ─────────────────
        int age     = 20;
        String type = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Type: " + type);            // Adult

        // ── Use directly in print ─────────────────────
        int score = 75;
        System.out.println("Result: " + (score >= 40 ? "PASS" : "FAIL")); // PASS

        // ── With different data types ─────────────────
        boolean isRaining = true;
        String  advice    = isRaining ? "Carry umbrella ☂" : "Enjoy sunshine ☀";
        System.out.println(advice);   // Carry umbrella ☂

        double  price     = 1500.0;
        double  discount  = (price > 1000) ? 0.10 : 0.05;  // 10% or 5%
        System.out.println("Discount: " + (discount * 100) + "%");  // Discount: 10.0%
    }
}
```

---

## ✅ 2. Ternary vs if-else — When to Use What

```java
public class TernaryVsIfElse {
    public static void main(String[] args) {

        int temperature = 38;

        // ── if-else (use for complex / multi-line logic) ──
        String weatherMsg;
        if (temperature > 35) {
            weatherMsg = "Very Hot 🔥";
            System.out.println("Sending heat alert...");   // side effect
        } else {
            weatherMsg = "Comfortable 😊";
        }
        System.out.println(weatherMsg);

        // ── ternary (use for simple single-value selection) ──
        // Clean, no side effects, inline
        String msg = (temperature > 35) ? "Very Hot 🔥" : "Comfortable 😊";
        System.out.println(msg);   // Very Hot 🔥

        // ── Rule of thumb ──────────────────────────────────
        // ✅ Use ternary when:
        //    - choosing between 2 simple values
        //    - result fits on one readable line
        //    - no side effects needed
        //
        // ✅ Use if-else when:
        //    - multiple statements per branch
        //    - side effects (print, method calls, assignments)
        //    - more than 2 branches (use else-if or switch)
    }
}
```

---

## 🟢 3. Ternary with All Data Types

```java
public class TernaryDataTypes {
    public static void main(String[] args) {

        // ── With int ──────────────────────────────────
        int x = 7;
        int absVal = (x >= 0) ? x : -x;       // absolute value
        System.out.println("Absolute value: " + absVal);   // 7

        int y = -15;
        int absY = (y >= 0) ? y : -y;
        System.out.println("Absolute value: " + absY);     // 15

        // ── With double ───────────────────────────────
        double balance = 2500.0;
        double interest = (balance >= 5000) ? balance * 0.08   // 8% for high balance
                                            : balance * 0.04;  // 4% for low balance
        System.out.printf("Interest: ₹%.2f%n", interest);   // ₹100.00

        // ── With String ───────────────────────────────
        int hour = 14;   // 2 PM in 24-hour format
        String greeting = (hour < 12) ? "Good Morning 🌅"
                        : (hour < 17) ? "Good Afternoon ☀"
                        :               "Good Evening 🌙";
        System.out.println(greeting);   // Good Afternoon ☀

        // ── With boolean ─────────────────────────────
        int num = 42;
        boolean isEven = (num % 2 == 0) ? true : false;
        // Simpler: boolean isEven = (num % 2 == 0);  ← but ternary works too
        System.out.println(num + " is even: " + isEven);   // true

        // ── With char ────────────────────────────────
        int marks = 85;
        char grade = (marks >= 90) ? 'A'
                   : (marks >= 80) ? 'B'
                   : (marks >= 70) ? 'C'
                   : (marks >= 60) ? 'D' : 'F';
        System.out.println("Grade: " + grade);   // B

        // ── In method return (very common in real code) ──
        System.out.println("5 is " + (isPrime(5) ? "Prime" : "Not Prime"));     // Prime
        System.out.println("10 is " + (isPrime(10) ? "Prime" : "Not Prime"));   // Not Prime
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```

---

## 🟡 4. Nested Ternary Operator

You can nest ternary operators for multiple conditions —
but use sparingly as deep nesting hurts readability.

```java
public class NestedTernary {
    public static void main(String[] args) {

        // ── Grade calculator using nested ternary ──────
        int score = 73;

        String grade = (score >= 90) ? "A+" :
                       (score >= 80) ? "A"  :
                       (score >= 70) ? "B"  :
                       (score >= 60) ? "C"  :
                       (score >= 40) ? "D"  : "F";

        System.out.println("Score: " + score + " → Grade: " + grade);  // B

        // ── Classify number ────────────────────────────
        int n = 0;
        String category = (n > 0) ? "Positive"
                        : (n < 0) ? "Negative"
                        :           "Zero";
        System.out.println(n + " is " + category);   // Zero

        // ── Traffic light logic ────────────────────────
        String light = "yellow";
        String action = light.equals("green")  ? "Go ✅"  :
                        light.equals("yellow") ? "Slow ⚠" :
                                                 "Stop 🛑";
        System.out.println("Light: " + light + " → " + action);  // Slow ⚠

        // ── BMI category ───────────────────────────────
        double bmi = 22.5;
        String bmiCategory = (bmi < 18.5) ? "Underweight 🔵" :
                             (bmi < 25.0) ? "Normal ✅"      :
                             (bmi < 30.0) ? "Overweight 🟡"  :
                                            "Obese 🔴";
        System.out.printf("BMI %.1f → %s%n", bmi, bmiCategory);  // Normal ✅

        // ── ⚠️ Avoid deep nesting — hard to read ───────
        // Bad practice — too many levels:
        int val = 50;
        String result = (val > 100) ? "Very High" :
                        (val > 75)  ? "High"       :
                        (val > 50)  ? "Medium"     :
                        (val > 25)  ? "Low"         :
                        (val > 0)   ? "Very Low"    : "Zero or Negative";
        System.out.println("Value category: " + result);  // Low
        // If more than 3-4 levels → switch or if-else is better!
    }
}
```

---

## 🔴 5. Ternary in Common Programming Patterns

```java
import java.util.*;

public class TernaryPatterns {
    public static void main(String[] args) {

        // ── Pattern 1: Null-safe default value ─────────
        // Very common in production code!
        String username = null;
        String display  = (username != null) ? username : "Guest";
        System.out.println("Welcome, " + display);   // Welcome, Guest

        String name = "Alice";
        String displayName = (name != null) ? name : "Guest";
        System.out.println("Welcome, " + displayName);   // Welcome, Alice

        // ── Pattern 2: Absolute value ───────────────────
        int num = -42;
        int abs = (num < 0) ? -num : num;
        System.out.println("Absolute: " + abs);   // 42

        // ── Pattern 3: Min and Max ──────────────────────
        int a = 15, b = 28;
        int min = (a < b) ? a : b;
        int max = (a > b) ? a : b;
        System.out.println("Min: " + min + ", Max: " + max);   // Min: 15, Max: 28

        // ── Pattern 4: Clamp a value in range ──────────
        // Ensure value stays between min and max
        int value = 150;
        int clampMin = 0;
        int clampMax = 100;
        int clamped  = (value < clampMin) ? clampMin
                     : (value > clampMax) ? clampMax
                     : value;
        System.out.println("Clamped: " + clamped);   // 100

        // ── Pattern 5: Pluralization ────────────────────
        int items = 1;
        System.out.println(items + " item" + (items == 1 ? "" : "s") + " in cart");
        // 1 item in cart

        items = 5;
        System.out.println(items + " item" + (items == 1 ? "" : "s") + " in cart");
        // 5 items in cart

        // ── Pattern 6: Alternate row colors (tables/UI) ─
        System.out.println("\nTable rows:");
        for (int i = 0; i < 5; i++) {
            String color = (i % 2 == 0) ? "white" : "light-gray";
            System.out.printf("Row %d → background: %s%n", i + 1, color);
        }
        // Row 1 → background: white
        // Row 2 → background: light-gray
        // Row 3 → background: white ...

        // ── Pattern 7: Ternary as method argument ───────
        int age = 17;
        System.out.println(getTicketPrice(age >= 18 ? "adult" : "child"));
        // Ticket price: ₹150.0

        // ── Pattern 8: Short-circuit behavior ──────────
        // Right side is only evaluated when condition is true/false
        int divisor = 0;
        // Safe division: avoid divide-by-zero
        double result = (divisor != 0) ? (100.0 / divisor) : 0.0;
        System.out.println("Safe division: " + result);   // 0.0
    }

    static double getTicketPrice(String type) {
        double price = type.equals("adult") ? 300.0 : 150.0;
        System.out.print("Ticket price: ₹" + price + "  → ");
        return price;
    }
}
```

---

## 🌍 Real World Project — Dynamic Pricing Engine

```java
public class DynamicPricingEngine {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        DYNAMIC PRICING ENGINE            ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // Order details
        String  memberType    = "premium";   // "premium", "regular", "guest"
        boolean isFirstOrder  = false;
        int     itemCount     = 8;
        double  basePrice     = 2400.0;
        boolean isWeekend     = true;
        int     stockLeft     = 3;           // low stock!

        System.out.printf("Base Price:     ₹%.2f%n", basePrice);
        System.out.printf("Member Type:    %s%n",     memberType);
        System.out.printf("Items:          %d%n",     itemCount);
        System.out.println("─────────────────────────────────────────");

        // ── Step 1: Member discount using ternary ──────
        double memberDiscount = memberType.equals("premium") ? 0.15 :
                                memberType.equals("regular") ? 0.05 : 0.0;
        double afterMember    = basePrice * (1 - memberDiscount);
        System.out.printf("Member Discount (%.0f%%): -₹%.2f → ₹%.2f%n",
                          memberDiscount * 100,
                          basePrice * memberDiscount,
                          afterMember);

        // ── Step 2: First order bonus ──────────────────
        double firstOrderDiscount = isFirstOrder ? 0.10 : 0.0;
        double afterFirstOrder    = afterMember * (1 - firstOrderDiscount);
        System.out.printf("First Order (%.0f%%):     -₹%.2f → ₹%.2f%n",
                          firstOrderDiscount * 100,
                          afterMember * firstOrderDiscount,
                          afterFirstOrder);

        // ── Step 3: Bulk discount ──────────────────────
        double bulkDiscount = (itemCount >= 10) ? 0.08 :
                              (itemCount >= 5)  ? 0.04 : 0.0;
        double afterBulk    = afterFirstOrder * (1 - bulkDiscount);
        System.out.printf("Bulk Discount (%.0f%%):   -₹%.2f → ₹%.2f%n",
                          bulkDiscount * 100,
                          afterFirstOrder * bulkDiscount,
                          afterBulk);

        // ── Step 4: Weekend surge pricing ─────────────
        double surgeMultiplier = isWeekend ? 1.05 : 1.0;   // 5% extra on weekends
        double afterSurge      = afterBulk * surgeMultiplier;
        System.out.printf("Weekend Surge (+%.0f%%):  +₹%.2f → ₹%.2f%n",
                          (surgeMultiplier - 1) * 100,
                          afterBulk * (surgeMultiplier - 1),
                          afterSurge);

        // ── Step 5: Low stock premium ──────────────────
        double stockMultiplier = (stockLeft <= 5) ? 1.10 : 1.0;   // 10% if low stock
        double finalPrice      = afterSurge * stockMultiplier;
        System.out.printf("Low Stock (+%.0f%%):      +₹%.2f → ₹%.2f%n",
                          (stockMultiplier - 1) * 100,
                          afterSurge * (stockMultiplier - 1),
                          finalPrice);

        // ── Step 6: Shipping ───────────────────────────
        double shipping = (finalPrice >= 1000) ? 0.0 : 99.0;
        System.out.println("─────────────────────────────────────────");
        System.out.printf("Shipping:        ₹%.2f  %s%n",
                          shipping,
                          shipping == 0 ? "(Free! 🎉)" : "");
        System.out.printf("FINAL PRICE:     ₹%.2f%n", finalPrice + shipping);

        // ── Summary label ──────────────────────────────
        double savings       = basePrice - finalPrice;
        String savingsLabel  = (savings > 0)   ? String.format("You saved ₹%.2f! 🎉", savings)
                             : (savings < 0)   ? String.format("Price increased by ₹%.2f", -savings)
                             :                   "No change in price";
        System.out.println(savingsLabel);
    }
}
```

**Output:**
```
╔══════════════════════════════════════════╗
║        DYNAMIC PRICING ENGINE            ║
╚══════════════════════════════════════════╝
Base Price:     ₹2400.00
Member Type:    premium
Items:          8
─────────────────────────────────────────
Member Discount (15%): -₹360.00 → ₹2040.00
First Order (0%):      -₹0.00   → ₹2040.00
Bulk Discount (4%):    -₹81.60  → ₹1958.40
Weekend Surge (+5%):   +₹97.92  → ₹2056.32
Low Stock (+10%):      +₹205.63 → ₹2261.95
─────────────────────────────────────────
Shipping:        ₹0.00  (Free! 🎉)
FINAL PRICE:     ₹2261.95
You saved ₹138.05! 🎉
```

---

## 🎯 Tricky Interview Questions

---

### ❓ Q1. What is the output?

```java
int a = 5, b = 10;
int result = (a > b) ? a++ : b++;
System.out.println("result=" + result + " a=" + a + " b=" + b);
```

**Answer:** `result=10 a=5 b=11`

`a > b` is `false` → `b++` executes (post-increment: returns `10`, then b becomes `11`).
`a++` is **never evaluated** — ternary short-circuits like `if-else`.

---

### ❓ Q2. What is the output?

```java
int x = 10;
String s = (x > 5) ? "Big" : "Small";
System.out.println(s.length());
```

**Answer:** `3`

`x > 5` is `true` → returns `"Big"` → `.length()` = `3`.

---

### ❓ Q3. Will this compile?

```java
int x = 5;
int result = (x > 3) ? "Yes" : 10;
```

**Answer:** ❌ Compile error — **incompatible types**.

Both branches of ternary must have **compatible types**.
`"Yes"` is `String`, `10` is `int` — no common type for `int result`.

Fix: `String result = (x > 3) ? "Yes" : "No";` or `Object result = (x > 3) ? "Yes" : 10;`

---

### ❓ Q4. What is the output?

```java
int a = 10, b = 20, c = 30;
int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
System.out.println("Max: " + max);
```

**Answer:** `Max: 30`

Outer ternary: `a > b` (10 > 20) → `false` → evaluate `(b > c) ? b : c`.
Inner: `b > c` (20 > 30) → `false` → returns `c = 30`.

---

### ❓ Q5. What is the output?

```java
boolean flag = true;
int result = flag ? flag ? 1 : 2 : 3;
System.out.println(result);
```

**Answer:** `1`

Outer ternary: `flag` is `true` → evaluate left: `flag ? 1 : 2`.
Inner: `flag` is `true` → returns `1`.

---

### ❓ Q6. What type does this ternary return?

```java
int    i = 5;
double d = 2.5;
var    result = (i > 3) ? i : d;
System.out.println(result);
```

**Answer:** `5.0` — type is `double`

When ternary branches have different numeric types, Java promotes to the
wider type. `int` and `double` → result is `double`. So `i = 5` is promoted
to `5.0`.

---

### ❓ Q7. What is the output?

```java
String s = null;
int len = (s != null) ? s.length() : -1;
System.out.println(len);
```

**Answer:** `-1`

`s != null` is `false` → `s.length()` is **never evaluated** (short-circuit).
Returns `-1` safely — no `NullPointerException`.

---

### ❓ Q8. What is the output?

```java
int x = 5;
System.out.println(x > 3 ? x < 7 ? "in range" : "too high" : "too low");
```

**Answer:** `in range`

Outer: `x > 3` → `true` → evaluate: `x < 7 ? "in range" : "too high"`.
Inner: `x < 7` (5 < 7) → `true` → `"in range"`.

---

## 📝 Summary

```
TERNARY OPERATOR QUICK REFERENCE
──────────────────────────────────────────────────────────────────
Syntax:  condition ? valueIfTrue : valueIfFalse

✅  Returns a VALUE — can assign, pass, print directly
✅  Short-circuits — only one branch is evaluated
✅  Both branches must have compatible types
✅  Can be nested (use sparingly — 2-3 levels max)

COMMON PATTERNS:
✅  Null-safe default  →  (x != null) ? x : "default"
✅  Absolute value     →  (n < 0) ? -n : n
✅  Min / Max          →  (a < b) ? a : b
✅  Clamp value        →  (v < min) ? min : (v > max) ? max : v
✅  Pluralize          →  count + (count == 1 ? "" : "s")
✅  Safe divide        →  (b != 0) ? a/b : 0
✅  Grade to letter    →  nested ternary chains

TERNARY vs IF-ELSE:
✅  Use ternary  → simple 2-way value selection, one line
✅  Use if-else  → multiple statements, side effects, 3+ branches
```

---







