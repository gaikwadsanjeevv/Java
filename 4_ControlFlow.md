# Section 4 — Control Flow in Java
## 4.1 to 4.11 — Complete Guide

> 📘 *Reference: Java The Complete Reference — Herbert Schildt*

---

## 📌 What is Control Flow?

By default, Java executes code **line by line, top to bottom**.
Control flow statements **change** that order — they let you:
- Make **decisions** (`if`, `switch`)
- **Repeat** code (`for`, `while`, `do-while`)
- **Skip or stop** execution (`break`, `continue`, `return`)

```
Section 4 — Control Flow
├── 4.1  if, if-else, else-if ladder        ← decision
├── 4.2  Nested if                           ← decision inside decision
├── 4.3  switch statement (traditional)     ← multi-way branch
├── 4.4  switch expressions (Java 14+)      ← modern switch
├── 4.5  for loop                           ← counted repetition
├── 4.6  while loop                         ← condition-first repetition
├── 4.7  do-while loop                      ← body-first repetition
├── 4.8  Enhanced for-each loop             ← iterate collections
├── 4.9  break, continue, return            ← jump statements
├── 4.10 Labeled loops                      ← break/continue outer loops
└── 4.11 Tricky loop questions              ← interview traps
```

---

# 4.1 — `if`, `if-else`, `else-if` Ladder

---

## 📌 What is `if`?

The `if` statement runs a block of code **only when a condition is true**.

```
if (condition) {
    // executes ONLY if condition is true
}
```

---

## 🔵 Simple `if`

```java
public class SimpleIf {
    public static void main(String[] args) {

        // ── Basic if ──────────────────────────────────
        int temperature = 38;

        if (temperature > 37) {
            System.out.println("⚠️ Fever detected!");   // printed
        }

        // ── Real world: stock alert ───────────────────
        double stockPrice  = 2850.0;
        double targetPrice = 2800.0;

        if (stockPrice > targetPrice) {
            System.out.println("🔔 Target price crossed! Sell now.");
        }

        // ── Single-line if (no braces — use carefully) ─
        int score = 90;
        if (score >= 90) System.out.println("🏆 Excellent!");
        // ⚠️ Avoid this style — easily causes bugs when adding more lines

        // ── if with complex condition ─────────────────
        int age   = 22;
        boolean hasID = true;
        if (age >= 18 && hasID) {
            System.out.println("✅ Entry allowed");
        }
    }
}
```

---

## 🟢 `if-else`

Runs one block if `true`, another if `false`.

```java
public class IfElse {
    public static void main(String[] args) {

        // ── Basic if-else ─────────────────────────────
        int marks = 35;

        if (marks >= 40) {
            System.out.println("Result: PASS ✅");
        } else {
            System.out.println("Result: FAIL ❌");   // printed (35 < 40)
        }

        // ── Real world 1: ATM withdrawal ──────────────
        double balance    = 5000.0;
        double withdrawal = 6000.0;

        if (withdrawal <= balance) {
            balance -= withdrawal;
            System.out.println("Withdrawn: ₹" + withdrawal);
        } else {
            System.out.println("❌ Insufficient balance! Available: ₹" + balance);
        }

        // ── Real world 2: odd or even ─────────────────
        int num = 7;
        if (num % 2 == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");   // 7 is Odd
        }

        // ── Real world 3: login validation ───────────
        String storedPass = "secure@123";
        String inputPass  = "secure@123";

        if (inputPass.equals(storedPass)) {
            System.out.println("✅ Login successful!");
        } else {
            System.out.println("❌ Wrong password");
        }
    }
}
```

---

## 🟡 `else-if` Ladder

Used when there are **more than 2** possible outcomes.

```java
public class ElseIfLadder {
    public static void main(String[] args) {

        // ── Grade calculator ──────────────────────────
        int score = 73;

        if (score >= 90) {
            System.out.println("Grade: A+ 🌟");
        } else if (score >= 80) {
            System.out.println("Grade: A");
        } else if (score >= 70) {
            System.out.println("Grade: B");    // printed (73 is here)
        } else if (score >= 60) {
            System.out.println("Grade: C");
        } else if (score >= 40) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F ❌");
        }

        // ── Real world 1: shipping cost ───────────────
        double orderAmount = 750.0;
        double shipping;

        if (orderAmount >= 1000) {
            shipping = 0;           // free shipping
        } else if (orderAmount >= 500) {
            shipping = 49;
        } else if (orderAmount >= 200) {
            shipping = 99;
        } else {
            shipping = 149;
        }
        System.out.println("Shipping: ₹" + shipping);   // ₹49

        // ── Real world 2: electricity bill ───────────
        int units = 350;  // units consumed
        double rate;

        if (units <= 100) {
            rate = 3.50;
        } else if (units <= 200) {
            rate = 4.50;
        } else if (units <= 500) {
            rate = 6.00;   // 350 units → this rate
        } else {
            rate = 8.00;
        }
        double bill = units * rate;
        System.out.printf("Units: %d | Rate: ₹%.2f | Bill: ₹%.2f%n",
                           units, rate, bill);
        // Units: 350 | Rate: ₹6.00 | Bill: ₹2100.00

        // ── Real world 3: BMI classifier ─────────────
        double bmi = 26.4;
        String category;

        if      (bmi < 18.5)              category = "Underweight 🔵";
        else if (bmi >= 18.5 && bmi < 25) category = "Normal ✅";
        else if (bmi >= 25 && bmi < 30)   category = "Overweight 🟡";
        else                               category = "Obese 🔴";

        System.out.printf("BMI %.1f → %s%n", bmi, category);  // Overweight 🟡
    }
}
```

---

## ⚠️ Common `if` Mistakes

```java
public class IfMistakes {
    public static void main(String[] args) {

        // ── Mistake 1: = instead of == ───────────────
        int x = 5;
        // if (x = 10) { }   ❌ Compile error in Java (good!)
        if (x == 10) { }     // ✅ correct comparison

        // ── Mistake 2: ; after if (empty body!) ──────
        if (x > 3);   // ← semicolon makes if body EMPTY
        {
            System.out.println("This ALWAYS prints!");  // not controlled by if!
        }

        // ── Mistake 3: floating point comparison ─────
        double d = 0.1 + 0.2;
        // if (d == 0.3) { }    ❌ NEVER do this — floating point imprecision!
        if (Math.abs(d - 0.3) < 1e-9) {   // ✅ compare with epsilon
            System.out.println("Equal (approx)");
        }

        // ── Mistake 4: dangling else ──────────────────
        int a = 5, b = 10;
        // Which if does the else belong to?
        if (a > 0)
            if (b > 20)
                System.out.println("Both conditions met");
            else
                System.out.println("b <= 20");   // else belongs to INNER if!
        // Always use braces to avoid confusion
    }
}
```

---

# 4.2 — Nested `if`

---

## 📌 What is Nested `if`?

An `if` statement **inside another** `if` statement.
Used when a second condition only makes sense after the first is true.

```java
public class NestedIf {
    public static void main(String[] args) {

        // ── Basic nested if ───────────────────────────
        int age    = 22;
        boolean hasVisa    = true;
        boolean hasTicket  = true;

        if (age >= 18) {                        // outer condition
            System.out.println("Age check passed ✅");
            if (hasVisa) {                      // inner condition (only checked if age ok)
                System.out.println("Visa check passed ✅");
                if (hasTicket) {                // innermost
                    System.out.println("🛫 Boarding allowed!");
                } else {
                    System.out.println("❌ No ticket");
                }
            } else {
                System.out.println("❌ No visa");
            }
        } else {
            System.out.println("❌ Must be 18+");
        }

        // ── Real world: ATM system ─────────────────────
        boolean cardInserted = true;
        boolean pinCorrect   = true;
        double  balance      = 8000.0;
        double  requested    = 5000.0;

        if (cardInserted) {
            System.out.println("\n💳 Card detected");
            if (pinCorrect) {
                System.out.println("🔓 PIN verified");
                if (requested <= balance) {
                    balance -= requested;
                    System.out.printf("💵 Dispensing ₹%.0f | Remaining: ₹%.0f%n",
                                       requested, balance);
                } else {
                    System.out.println("❌ Insufficient balance");
                }
            } else {
                System.out.println("❌ Wrong PIN");
            }
        } else {
            System.out.println("❌ Please insert card");
        }

        // ── Real world: e-commerce order ──────────────
        boolean isLoggedIn   = true;
        boolean itemInStock  = true;
        boolean addressSaved = true;
        double  walletBal    = 1200.0;
        double  orderAmount  = 999.0;

        System.out.println();
        if (isLoggedIn) {
            if (itemInStock) {
                if (addressSaved) {
                    if (walletBal >= orderAmount) {
                        walletBal -= orderAmount;
                        System.out.println("✅ Order placed successfully!");
                        System.out.printf("Wallet balance: ₹%.2f%n", walletBal);
                    } else {
                        System.out.println("❌ Add money to wallet");
                    }
                } else {
                    System.out.println("❌ Add delivery address first");
                }
            } else {
                System.out.println("❌ Item out of stock");
            }
        } else {
            System.out.println("❌ Please log in");
        }

        // ── Tip: Flatten deeply nested ifs using early return/continue
        // (shown in 4.9 — return/break)
    }
}
```

---

# 4.3 — `switch` Statement (Traditional)

---

## 📌 What is `switch`?

`switch` tests a **single expression** against multiple constant values.
Cleaner than a long `else-if` ladder when comparing one variable to many values.

```
switch (expression) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    default:
        // code if no case matches
}
```

---

## 🔵 Basic `switch`

```java
public class SwitchBasic {
    public static void main(String[] args) {

        // ── Day of week ───────────────────────────────
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");  // printed
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // ── switch with String (Java 7+) ─────────────
        String season = "summer";

        switch (season) {
            case "spring":
                System.out.println("🌸 Flowers blooming");
                break;
            case "summer":
                System.out.println("☀️ Hot and sunny");   // printed
                break;
            case "autumn":
                System.out.println("🍂 Leaves falling");
                break;
            case "winter":
                System.out.println("❄️ Cold and snowy");
                break;
            default:
                System.out.println("Unknown season");
        }

        // ── switch with char ─────────────────────────
        char grade = 'B';

        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Good job!");    // printed
                break;
            case 'C':
                System.out.println("Average");
                break;
            default:
                System.out.println("Needs improvement");
        }
    }
}
```

---

## ⚡ Fall-Through Behavior

Without `break`, execution **falls through** to the next case!

```java
public class FallThrough {
    public static void main(String[] args) {

        // ── Fall-through (intentional grouping) ──────
        int month = 4;  // April
        String season;

        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Winter ❄️";
                break;
            case 3:
            case 4:    // April falls here
            case 5:
                season = "Spring 🌸";   // April, March, May all get this
                break;
            case 6:
            case 7:
            case 8:
                season = "Summer ☀️";
                break;
            default:
                season = "Autumn 🍂";
        }
        System.out.println("Month " + month + ": " + season); // Spring 🌸

        // ── Unintentional fall-through (bug!) ─────────
        int x = 1;
        switch (x) {
            case 1:
                System.out.println("One");    // printed
                // ← forgot break! falls through!
            case 2:
                System.out.println("Two");    // also printed! (bug)
            case 3:
                System.out.println("Three");  // also printed! (bug)
                break;
            case 4:
                System.out.println("Four");
        }
        // Output: One, Two, Three  ← unintended!
    }
}
```

---

## 🌍 Real World `switch` — Menu System

```java
public class MenuSystem {
    public static void main(String[] args) {

        int choice = 2;   // user's menu selection
        double accountBalance = 10000.0;

        System.out.println("╔══════════════════════════╗");
        System.out.println("║      BANK MENU           ║");
        System.out.println("║  1. Check Balance        ║");
        System.out.println("║  2. Deposit              ║");
        System.out.println("║  3. Withdraw             ║");
        System.out.println("║  4. Exit                 ║");
        System.out.println("╚══════════════════════════╝");
        System.out.println("Your choice: " + choice);
        System.out.println();

        switch (choice) {
            case 1:
                System.out.printf("Balance: ₹%.2f%n", accountBalance);
                break;
            case 2:
                double deposit = 5000.0;
                accountBalance += deposit;
                System.out.printf("✅ Deposited ₹%.2f | New Balance: ₹%.2f%n",
                                   deposit, accountBalance);
                break;   // Output: ✅ Deposited ₹5000.00 | New Balance: ₹15000.00
            case 3:
                double withdraw = 3000.0;
                if (withdraw <= accountBalance) {
                    accountBalance -= withdraw;
                    System.out.printf("💵 Withdrawn ₹%.2f | Remaining: ₹%.2f%n",
                                       withdraw, accountBalance);
                } else {
                    System.out.println("❌ Insufficient funds");
                }
                break;
            case 4:
                System.out.println("👋 Thank you! Goodbye.");
                break;
            default:
                System.out.println("❌ Invalid choice. Enter 1-4.");
        }
    }
}
```

---

# 4.4 — `switch` Expressions (Java 14+)

---

## 📌 What's New in Java 14+?

Java 14 introduced **switch expressions** — a modern, cleaner version:
- Uses `->` arrow syntax (no fall-through by default)
- Can **return a value** directly
- No need for `break` in arrow cases
- `yield` used to return from block cases

```java
public class SwitchExpression {
    public static void main(String[] args) {

        // ── Old switch statement vs new switch expression ──
        int day = 3;

        // OLD way (verbose)
        String dayName;
        switch (day) {
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            default: dayName = "Other";
        }

        // NEW way (Java 14+) — clean arrow syntax
        String dayNameNew = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";   // matched
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };
        System.out.println(dayNameNew);   // Wednesday

        // ── Multiple values per case ──────────────────
        String typeOfDay = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday 💼";    // comma-separated values!
            case 6, 7           -> "Weekend 🎉";
            default             -> "Invalid";
        };
        System.out.println(typeOfDay);   // Weekday 💼

        // ── switch expression with block + yield ──────
        int score = 82;
        String grade = switch (score / 10) {  // integer division for range
            case 10, 9 -> "A+";
            case 8     -> {
                System.out.println("Calculating grade...");
                yield "A";   // yield returns value from block
            }
            case 7     -> "B";
            case 6     -> "C";
            default    -> "F";
        };
        System.out.println("Grade: " + grade);  // Grade: A

        // ── Real world: discount by member type ───────
        String memberType = "premium";
        double discount = switch (memberType) {
            case "premium"   -> 0.20;   // 20% discount
            case "gold"      -> 0.15;
            case "silver"    -> 0.10;
            case "regular"   -> 0.05;
            default          -> 0.0;
        };
        System.out.printf("Discount: %.0f%%%n", discount * 100);  // 20%

        // ── switch with String and block ─────────────
        String command = "start";
        int result = switch (command) {
            case "start" -> {
                System.out.println("🚀 Starting service...");
                yield 1;
            }
            case "stop"  -> {
                System.out.println("🛑 Stopping service...");
                yield 0;
            }
            case "restart" -> {
                System.out.println("🔄 Restarting...");
                yield 2;
            }
            default -> {
                System.out.println("❓ Unknown command");
                yield -1;
            }
        };
        System.out.println("Exit code: " + result);  // 1
    }
}
```

---

## 📊 Old `switch` vs New `switch` Expression

| Feature | Old `switch` (≤ Java 13) | New `switch` (Java 14+) |
|---------|--------------------------|-------------------------|
| Syntax | `case X:` with `:` | `case X ->` with `->` |
| Fall-through | Yes (needs `break`) | No (automatic) |
| Returns value | ❌ No | ✅ Yes |
| Multiple values | ❌ Separate cases | ✅ `case 1, 2, 3 ->` |
| Block return | N/A | `yield` keyword |
| Cleaner code | ❌ Verbose | ✅ Concise |

---

# 4.5 — `for` Loop

---

## 📌 What is a `for` Loop?

The `for` loop repeats a block of code a **known number of times**.
It has 3 parts in the header: **initialize**, **condition**, **update**.

```
for (initialization; condition; update) {
    // body — runs while condition is true
}
```

```
┌──────────────┐
│ Initialization│  ← runs ONCE at the start
└──────┬───────┘
       ↓
┌──────────────┐
│  Condition   │  ← checked BEFORE each iteration
└──────┬───────┘
  true │        false → EXIT loop
       ↓
┌──────────────┐
│  Loop Body   │  ← executes if condition true
└──────┬───────┘
       ↓
┌──────────────┐
│   Update     │  ← runs AFTER each iteration
└──────┘ (back to condition)
```

---

## 🔵 Basic `for` Loop

```java
public class ForLoopBasic {
    public static void main(String[] args) {

        // ── Count 1 to 5 ─────────────────────────────
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");   // 1 2 3 4 5
        }
        System.out.println();

        // ── Count down ────────────────────────────────
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");   // 10 9 8 7 6 5 4 3 2 1
        }
        System.out.println();

        // ── Step by 2 (even numbers) ──────────────────
        for (int i = 0; i <= 20; i += 2) {
            System.out.print(i + " ");   // 0 2 4 6 8 10 12 14 16 18 20
        }
        System.out.println();

        // ── Iterate array ─────────────────────────────
        int[] prices = {450, 280, 390, 175, 520};
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        System.out.println("Total: ₹" + total);   // ₹1815

        // ── Real world: multiplication table ─────────
        int n = 7;
        System.out.println("\nTable of " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %3d%n", n, i, n * i);
        }
        // 7 x  1 =   7
        // 7 x  2 =  14
        // ...
        // 7 x 10 =  70
    }
}
```

---

## 🟢 `for` Loop Variations

```java
public class ForVariations {
    public static void main(String[] args) {

        // ── Multiple variables in for ─────────────────
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.print("(" + i + "," + j + ") ");
        }
        // (0,10) (1,9) (2,8) (3,7) (4,6)
        System.out.println();

        // ── Infinite for loop (use with break) ────────
        int count = 0;
        for (;;) {               // no init, no condition, no update
            count++;
            if (count == 5) break;  // exit when count hits 5
        }
        System.out.println("Count: " + count);   // 5

        // ── Empty body for loop ───────────────────────
        int sum = 0;
        for (int i = 1; i <= 100; i++) sum += i;  // Gauss formula: n(n+1)/2
        System.out.println("Sum 1-100: " + sum);   // 5050

        // ── Reverse array print ───────────────────────
        String[] names = {"Alice", "Bob", "Charlie", "Dave"};
        System.out.print("Reversed: ");
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.print(names[i] + " ");
        }
        // Reversed: Dave Charlie Bob Alice
        System.out.println();
    }
}
```

---

## 🌍 Real World `for` — Sales Report

```java
public class SalesReport {
    public static void main(String[] args) {

        String[] months  = {"Jan","Feb","Mar","Apr","May","Jun"};
        double[] sales   = {45000, 52000, 48000, 61000, 55000, 70000};
        double   target  = 50000;

        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║           SALES REPORT H1             ║");
        System.out.println("╠═══════════╦═══════════╦═══════════════╣");
        System.out.println("║   Month   ║   Sales   ║    Status     ║");
        System.out.println("╠═══════════╬═══════════╬═══════════════╣");

        double totalSales  = 0;
        int    metTarget   = 0;

        for (int i = 0; i < months.length; i++) {
            totalSales += sales[i];
            String status = (sales[i] >= target) ? "✅ Met" : "❌ Missed";
            if (sales[i] >= target) metTarget++;
            System.out.printf("║  %-7s  ║ ₹%8.0f ║  %-12s ║%n",
                              months[i], sales[i], status);
        }

        System.out.println("╠═══════════╬═══════════╬═══════════════╣");
        System.out.printf("║  TOTAL    ║ ₹%8.0f ║  %d/6 Months   ║%n",
                          totalSales, metTarget);
        System.out.println("╚═══════════╩═══════════╩═══════════════╝");
        System.out.printf("Average Monthly Sales: ₹%.2f%n", totalSales / months.length);
    }
}
```

**Output:**
```
╔═══════════════════════════════════════╗
║           SALES REPORT H1             ║
╠═══════════╦═══════════╦═══════════════╣
║   Month   ║   Sales   ║    Status     ║
╠═══════════╬═══════════╬═══════════════╣
║  Jan      ║ ₹   45000 ║  ❌ Missed    ║
║  Feb      ║ ₹   52000 ║  ✅ Met       ║
║  Mar      ║ ₹   48000 ║  ❌ Missed    ║
║  Apr      ║ ₹   61000 ║  ✅ Met       ║
║  May      ║ ₹   55000 ║  ✅ Met       ║
║  Jun      ║ ₹   70000 ║  ✅ Met       ║
╠═══════════╬═══════════╬═══════════════╣
║  TOTAL    ║ ₹  331000 ║  4/6 Months   ║
╚═══════════╩═══════════╩═══════════════╝
Average Monthly Sales: ₹55166.67
```

---

# 4.6 — `while` Loop

---

## 📌 What is a `while` Loop?

Repeats a block **while** a condition is `true`.
Best used when the **number of iterations is NOT known** in advance.

```
while (condition) {
    // body
}
```

Condition is checked **BEFORE** the body executes.
If false initially → body **never runs**.

---

## 🔵 Basic `while` Loop

```java
public class WhileBasic {
    public static void main(String[] args) {

        // ── Basic count ───────────────────────────────
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");   // 1 2 3 4 5
            i++;                          // update — MUST change condition!
        }
        System.out.println();

        // ── Condition false at start → never runs ─────
        int x = 10;
        while (x < 5) {
            System.out.println("Never printed");  // x=10 fails x<5 immediately
        }
        System.out.println("x = " + x);  // x = 10

        // ── Real world 1: user input simulation ───────
        // Simulate reading until sentinel value
        int[] userInputs = {5, 3, 8, 2, -1};  // -1 is sentinel (stop signal)
        int idx = 0;
        int inputSum = 0;

        System.out.println("Reading numbers until -1:");
        while (userInputs[idx] != -1) {
            System.out.println("Read: " + userInputs[idx]);
            inputSum += userInputs[idx];
            idx++;
        }
        System.out.println("Sum: " + inputSum);  // Sum: 18

        // ── Real world 2: digits of a number ─────────
        int number = 12345;
        int digitCount = 0;
        int temp = number;

        while (temp > 0) {
            temp /= 10;       // remove last digit
            digitCount++;
        }
        System.out.println(number + " has " + digitCount + " digits");  // 5 digits

        // ── Real world 3: compound interest until goal ─
        double balance = 10000.0;
        double rate    = 0.08;      // 8% annual
        double goal    = 20000.0;
        int years      = 0;

        while (balance < goal) {
            balance *= (1 + rate);  // apply interest
            years++;
        }
        System.out.printf("Years to double: %d | Final: ₹%.2f%n", years, balance);
        // Years to double: 10 | Final: ₹21589.25
    }
}
```

---

## 🟢 `while` Loop Patterns

```java
public class WhilePatterns {
    public static void main(String[] args) {

        // ── Pattern 1: Reverse digits ─────────────────
        int num = 12345;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;          // extract last digit
            reversed  = reversed * 10 + digit;  // build reversed number
            num      /= 10;               // remove last digit
        }
        System.out.println("Reversed: " + reversed);  // 54321

        // ── Pattern 2: Sum of digits ──────────────────
        int n   = 9876;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;    // add last digit
            n   /= 10;        // remove last digit
        }
        System.out.println("Digit sum: " + sum);  // 9+8+7+6 = 30

        // ── Pattern 3: GCD using Euclidean algorithm ──
        int a = 48, b = 18;
        int tempA = a, tempB = b;
        while (tempB != 0) {
            int r = tempA % tempB;
            tempA = tempB;
            tempB = r;
        }
        System.out.println("GCD(" + a + "," + b + ") = " + tempA);  // 6

        // ── Pattern 4: Binary conversion ─────────────
        int decimal = 13;
        String binary = "";
        int temp = decimal;
        while (temp > 0) {
            binary = (temp % 2) + binary;   // prepend bit
            temp  /= 2;
        }
        System.out.println(decimal + " in binary: " + binary);  // 1101
    }
}
```

---

# 4.7 — `do-while` Loop

---

## 📌 What is `do-while`?

Like `while`, but the body executes **AT LEAST ONCE** — condition checked **AFTER**.

```
do {
    // body — runs at least once
} while (condition);
```

Use when you need the body to run **before checking** the condition —
like showing a menu and then asking if the user wants to continue.

---

## 🔵 Basic `do-while`

```java
public class DoWhileBasic {
    public static void main(String[] args) {

        // ── Basic do-while ────────────────────────────
        int i = 1;
        do {
            System.out.print(i + " ");  // 1 2 3 4 5
            i++;
        } while (i <= 5);
        System.out.println();

        // ── KEY difference: runs even when condition false initially ──
        int x = 10;
        do {
            System.out.println("Runs once even though x=10 > 5");  // prints!
        } while (x < 5);   // false, but body already ran once

        // ── Real world 1: game loop ───────────────────
        int lives  = 3;
        int level  = 1;
        boolean gameOver = false;

        System.out.println("\n🎮 Game Start!");
        do {
            System.out.printf("Level %d | Lives: %d%n", level, lives);
            // simulate losing a life each level
            lives--;
            level++;
            if (lives == 0) gameOver = true;
        } while (!gameOver && level <= 5);

        System.out.println(gameOver ? "💀 Game Over!" : "🏆 You won!");
        // Level 1 | Lives: 3
        // Level 2 | Lives: 2
        // Level 3 | Lives: 1
        // 💀 Game Over!

        // ── Real world 2: PIN verification ───────────
        int[] attempts    = {1234, 9999, 4521};  // simulated inputs
        int   correctPIN  = 4521;
        int   tryIndex    = 0;
        boolean verified  = false;

        System.out.println("\n🔐 PIN Entry:");
        do {
            int entered = attempts[tryIndex++];
            System.out.print("Entered: " + entered + " → ");
            if (entered == correctPIN) {
                verified = true;
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Wrong");
            }
        } while (!verified && tryIndex < attempts.length);

        // ── Real world 3: input validation ────────────
        int[] menuChoices = {9, 0, 2};  // simulated: 9 invalid, 0 invalid, 2 valid
        int ci = 0;
        int validChoice;

        do {
            validChoice = menuChoices[ci++];
            System.out.println("Input: " + validChoice
                             + (validChoice >= 1 && validChoice <= 4 ? " ✅" : " ❌ Invalid"));
        } while (validChoice < 1 || validChoice > 4);

        System.out.println("Valid choice accepted: " + validChoice);  // 2
    }
}
```

---

## 📊 Loop Comparison Table

| Feature | `for` | `while` | `do-while` |
|---------|-------|---------|------------|
| Best use | Known count | Unknown count | At least once |
| Condition check | Before body | Before body | After body |
| Minimum runs | 0 | 0 | **1** |
| Init in header | ✅ Yes | ❌ Separate | ❌ Separate |
| Readability | Best for counting | Best for flags | Best for menus |

---

# 4.8 — Enhanced `for-each` Loop

---

## 📌 What is `for-each`?

The enhanced `for` loop (Java 5+) iterates over **arrays and collections**
without needing an index. Cleaner and less error-prone.

```
for (Type variable : arrayOrCollection) {
    // use variable
}
```

---

## 🔵 `for-each` with Arrays

```java
import java.util.*;

public class ForEachDemo {
    public static void main(String[] args) {

        // ── Basic array iteration ─────────────────────
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Numbers: ");
        for (int n : numbers) {
            System.out.print(n + " ");   // 10 20 30 40 50
        }
        System.out.println();

        // ── String array ──────────────────────────────
        String[] fruits = {"Apple", "Banana", "Mango", "Orange"};
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println("  🍎 " + fruit);
        }

        // ── Sum with for-each ─────────────────────────
        double[] prices = {299.0, 149.0, 499.0, 89.0};
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        System.out.printf("Cart Total: ₹%.2f%n", total);   // ₹1036.00

        // ── for-each with Collections ─────────────────
        List<String> cities = new ArrayList<>();
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Chennai");

        System.out.println("Cities:");
        for (String city : cities) {
            System.out.println("  📍 " + city);
        }

        // ── for-each with Map.entrySet ─────────────────
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Alice",  95);
        scores.put("Bob",    87);
        scores.put("Charlie",91);
        scores.put("Diana",  78);

        System.out.println("\nLeaderboard:");
        int rank = 1;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.printf("  %d. %-10s %d%n",
                              rank++, entry.getKey(), entry.getValue());
        }
        // 1. Alice      95
        // 2. Bob        87
        // 3. Charlie    91
        // 4. Diana      78
    }
}
```

---

## ⚠️ `for-each` Limitations

```java
public class ForEachLimitations {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        // ── Limitation 1: Cannot modify array elements ─
        for (int n : arr) {
            n = n * 2;   // ❌ This does NOT modify the array!
        }
        System.out.println(arr[0]);  // still 10 (not 20)

        // Fix: use index-based for loop
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;   // ✅ modifies actual array
        }
        System.out.println(arr[0]);  // 20 ✅

        // ── Limitation 2: No index available ──────────
        String[] names = {"Alice", "Bob", "Charlie"};
        // Cannot get index in for-each — use regular for if you need it
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ": " + names[i]);   // 0: Alice, 1: Bob...
        }

        // ── Limitation 3: Cannot iterate in reverse ───
        // for-each always goes forward
        // Use regular for loop for reverse iteration

        // ── Limitation 4: Cannot skip elements with index ─
        // Use regular for with conditions
    }
}
```

---

# 4.9 — `break`, `continue`, `return`

---

## 📌 Jump Statements

Java has 3 jump statements that alter loop/method flow:

| Statement | Effect |
|-----------|--------|
| `break` | Exits the **current loop or switch** immediately |
| `continue` | Skips the **rest of current iteration**, goes to next |
| `return` | Exits the **entire method**, optionally returning a value |

---

## 🔵 `break`

```java
public class BreakDemo {
    public static void main(String[] args) {

        // ── break in for loop ─────────────────────────
        System.out.print("Before break: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;          // stop when i hits 6
            System.out.print(i + " ");
        }
        System.out.println();
        // Before break: 1 2 3 4 5

        // ── break in while ────────────────────────────
        int n = 1;
        while (true) {          // infinite loop
            if (n * n > 100) break;  // exit when square exceeds 100
            n++;
        }
        System.out.println("Largest n where n²≤100: " + (n - 1));  // 10

        // ── Real world 1: linear search ──────────────
        int[] arr    = {15, 42, 8, 91, 37, 56};
        int   target = 91;
        int   foundAt = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                foundAt = i;
                break;    // no point continuing after found
            }
        }
        System.out.println("Found " + target + " at index: " + foundAt); // index 3

        // ── Real world 2: find first prime ────────────
        int firstPrime = -1;
        int[] candidates = {9, 15, 4, 11, 21, 7};

        for (int candidate : candidates) {
            if (isPrime(candidate)) {
                firstPrime = candidate;
                break;
            }
        }
        System.out.println("First prime: " + firstPrime);  // 11

        // ── break in switch ───────────────────────────
        int day = 2;
        switch (day) {
            case 1: System.out.println("Mon"); break;
            case 2: System.out.println("Tue"); break;  // printed, then break exits
            case 3: System.out.println("Wed"); break;
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
```

---

## 🟢 `continue`

```java
public class ContinueDemo {
    public static void main(String[] args) {

        // ── Skip specific value ───────────────────────
        System.out.print("Skip 3: ");
        for (int i = 1; i <= 7; i++) {
            if (i == 3) continue;   // skip rest of this iteration
            System.out.print(i + " ");
        }
        System.out.println();
        // Skip 3: 1 2 4 5 6 7

        // ── Print only even numbers ───────────────────
        System.out.print("Evens: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) continue;  // skip odd numbers
            System.out.print(i + " ");
        }
        System.out.println();
        // Evens: 2 4 6 8 10

        // ── Real world 1: skip invalid entries ───────
        double[] readings = {23.5, -1.0, 45.2, -99.0, 38.7, 0.0, 29.1};
        double sum   = 0;
        int validCount = 0;

        for (double r : readings) {
            if (r <= 0) continue;    // skip invalid (negative or zero)
            sum += r;
            validCount++;
        }
        System.out.printf("Avg valid temp: %.2f°C (%d readings)%n",
                           sum / validCount, validCount);
        // Avg valid temp: 34.13°C (4 readings)

        // ── Real world 2: skip blacklisted users ──────
        String[] users  = {"alice", "admin", "bob", "root", "charlie"};
        String[] banned = {"admin", "root"};

        System.out.println("Active users:");
        outer:
        for (String user : users) {
            for (String ban : banned) {
                if (user.equals(ban)) continue outer;  // labeled continue (see 4.10)
            }
            System.out.println("  ✅ " + user);
        }
        // ✅ alice
        // ✅ bob
        // ✅ charlie

        // ── continue in while ─────────────────────────
        int i = 0;
        System.out.print("Odd 1-9: ");
        while (i < 10) {
            i++;
            if (i % 2 == 0) continue;   // skip even
            System.out.print(i + " ");
        }
        System.out.println();
        // Odd 1-9: 1 3 5 7 9
    }
}
```

---

## 🔴 `return`

```java
public class ReturnDemo {
    public static void main(String[] args) {

        // ── return value from method ──────────────────
        System.out.println("Max(5,9): " + max(5, 9));     // 9
        System.out.println("Fact(5): " + factorial(5));   // 120
        System.out.println("isPrime(17): " + isPrime(17)); // true

        // ── Early return pattern (guard clauses) ──────
        // Instead of deeply nested ifs, return early
        System.out.println("\nOrder validations:");
        System.out.println(processOrder(true, true, true, 500, 300));    // ✅ Order placed
        System.out.println(processOrder(false, true, true, 500, 300));   // ❌ Not logged in
        System.out.println(processOrder(true, false, true, 500, 300));   // ❌ Out of stock
        System.out.println(processOrder(true, true, false, 500, 300));   // ❌ No address
        System.out.println(processOrder(true, true, true, 200, 500));    // ❌ Insufficient funds
    }

    // return int
    static int max(int a, int b) {
        if (a > b) return a;   // early return if a is larger
        return b;
    }

    // return long
    static long factorial(int n) {
        if (n <= 1) return 1;           // base case — early return
        return n * factorial(n - 1);   // recursive return
    }

    // return boolean with early return (guard clause pattern)
    static boolean isPrime(int n) {
        if (n < 2)       return false;   // guard: too small
        if (n == 2)      return true;    // guard: 2 is prime
        if (n % 2 == 0)  return false;   // guard: even numbers
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Early return replaces deeply nested if-else
    static String processOrder(boolean loggedIn, boolean inStock,
                               boolean hasAddress, double wallet, double price) {
        if (!loggedIn)           return "❌ Not logged in";
        if (!inStock)            return "❌ Out of stock";
        if (!hasAddress)         return "❌ No delivery address";
        if (wallet < price)      return "❌ Insufficient funds";
        return "✅ Order placed! Charged ₹" + price;
    }
}
```

---

# 4.10 — Labeled Loops

---

## 📌 What are Labeled Loops?

A **label** is a name given to a loop. You can use `break label` or
`continue label` to exit or continue an **outer loop** from inside a nested loop.

```
outerLabel:
for (...) {            // outer loop has a label
    for (...) {        // inner loop
        break outerLabel;    // exits THE OUTER loop
        continue outerLabel; // continues THE OUTER loop
    }
}
```

Without labels, `break` and `continue` only affect the **innermost** loop.

---

```java
public class LabeledLoops {
    public static void main(String[] args) {

        // ── Without label: break exits only inner loop ─
        System.out.println("Without label:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) break;   // only breaks inner loop
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        // (1,1) (2,1) (3,1)   ← inner breaks at j=2 each time, outer continues
        System.out.println();

        // ── With label: break exits OUTER loop ────────
        System.out.println("With label (break outer):");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) break outer;  // exits BOTH loops
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        // (1,1) (1,2) (1,3) (2,1)   ← stops completely when i=2,j=2
        System.out.println();

        // ── continue with label ───────────────────────
        System.out.println("With label (continue outer):");
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) continue outerLoop;   // skip to NEXT outer iteration
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        // (1,1) (2,1) (3,1)  ← only j=1 prints because j=2 triggers continue outer
        System.out.println();

        // ── Real world 1: search in 2D matrix ─────────
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12}
        };
        int searchVal = 7;
        int foundRow = -1, foundCol = -1;

        searchLoop:
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == searchVal) {
                    foundRow = r;
                    foundCol = c;
                    break searchLoop;   // exit both loops once found
                }
            }
        }
        System.out.printf("Found %d at [%d][%d]%n",
                           searchVal, foundRow, foundCol);  // Found 7 at [1][2]

        // ── Real world 2: skip blacklisted combinations ─
        String[] sizes   = {"S", "M", "L"};
        String[] colors  = {"Red", "Blue", "Green"};
        String[] banned  = {"M-Blue", "L-Red"};  // out of stock combos

        System.out.println("\nAvailable combos:");
        nextCombo:
        for (String size : sizes) {
            for (String color : colors) {
                String combo = size + "-" + color;
                for (String ban : banned) {
                    if (combo.equals(ban)) continue nextCombo;  // skip this combo
                }
                System.out.println("  ✅ " + combo);
            }
        }
        // Skips M-Blue and L-Red
    }
}
```

---

# 4.11 — Tricky Loop & Control Flow Interview Questions

---

## 🎯 Full Tricky Question Set

---

### ❓ Q1. What is the output?

```java
for (int i = 0; i < 5; i++) {
    if (i == 3) continue;
    if (i == 4) break;
    System.out.print(i + " ");
}
```

**Answer:** `0 1 2`

- `i=0,1,2`: print normally
- `i=3`: `continue` → skip print, go to `i=4`
- `i=4`: `break` → exit loop (never prints 4)

---

### ❓ Q2. What is the output?

```java
int i = 0;
while (i++ < 3) {
    System.out.print(i + " ");
}
```

**Answer:** `1 2 3`

`i++` is post-increment — condition uses old value, but `i` increments before body:
- Check `0 < 3` (true), then `i` becomes 1 → print `1`
- Check `1 < 3` (true), then `i` becomes 2 → print `2`
- Check `2 < 3` (true), then `i` becomes 3 → print `3`
- Check `3 < 3` (false) → exit

---

### ❓ Q3. What is the output?

```java
for (int i = 0; i < 3; i++) {
    System.out.print(i + " ");
    i++;
}
```

**Answer:** `0 2`

`i` increments TWICE each iteration — once in body (`i++`), once in update (`i++`):
- `i=0`: print 0, body `i++` → 1, update → 2
- `i=2`: print 2, body `i++` → 3, update → 4
- `i=4`: `4 < 3` false → exit

---

### ❓ Q4. What is the output?

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i + j == 3) continue outer;
        System.out.print(i + "" + j + " ");
    }
}
```

**Answer:** `00 01 02 10 11 20`

When `i+j == 3`, we skip to next outer iteration:
- `i=0`: j=0(00) j=1(01) j=2(02) — no skip
- `i=1`: j=0(10) j=1(11) j=2: `1+2=3` → continue outer
- `i=2`: j=0(20) j=1: `2+1=3` → continue outer
- `i=3`: loop ends

---

### ❓ Q5. What is the output?

```java
int x = 10;
do {
    System.out.print(x + " ");
    x -= 3;
} while (x > 0);
```

**Answer:** `10 7 4 1`

- Print 10, x=7; `7>0` true
- Print 7, x=4;  `4>0` true
- Print 4, x=1;  `1>0` true
- Print 1, x=-2; `-2>0` false → exit

---

### ❓ Q6. What is the output?

```java
for (int i = 1; i <= 4; i++) {
    for (int j = 1; j <= 4; j++) {
        if (i == j) continue;
        System.out.print(i + "" + j + " ");
    }
}
```

**Answer:** `12 13 14 21 23 24 31 32 34 41 42 43`

Skips when `i == j` (same index). Prints all pairs where i ≠ j.

---

### ❓ Q7. Will this compile and run? What is the output?

```java
for (int i = 0; ; i++) {
    if (i == 3) break;
    System.out.print(i + " ");
}
```

**Answer:** ✅ Compiles. Output: `0 1 2`

Empty condition in `for` defaults to `true` (infinite loop).
`break` at `i==3` exits. Prints `0 1 2`.

---

### ❓ Q8. What is the output?

```java
int i = 5;
switch (i) {
    case 5:
        System.out.println("Five");
    case 6:
        System.out.println("Six");
    case 7:
        System.out.println("Seven");
        break;
    default:
        System.out.println("Default");
}
```

**Answer:**
```
Five
Six
Seven
```

**Fall-through!** No `break` after case 5 or 6 — execution falls through all cases until `break` at 7.

---

### ❓ Q9. What is the output?

```java
loop:
for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
        if (j == 1) break loop;
        System.out.println(i + " " + j);
    }
}
System.out.println("After loops");
```

**Answer:**
```
0 0
After loops
```

When `i=0, j=1`: `break loop` exits the outer loop entirely.
Only `(0,0)` prints, then execution continues after both loops.

---

### ❓ Q10. What is the output?

```java
for (int i = 0; i < 5; i++) {
    System.out.print(i + " ");
    if (i == 2) {
        i = 0;    // reset i inside loop body!
        continue;
    }
}
```

**Answer:** Infinite loop! 🔄

When `i=2`: print 2, then `i=0` (reset), `continue`, update `i++` → `i=1`.
Then i goes `1, 2` again → reset → infinite.

---

### ❓ Q11. What is the output?

```java
int result = 0;
for (int i = 1; i <= 5; i++) {
    result += i % 2 == 0 ? i : 0;
}
System.out.println(result);
```

**Answer:** `6`

Adds only even numbers: `2 + 4 = 6`. (1,3,5 contribute 0)

---

### ❓ Q12. What is the output?

```java
String[] arr = {"a", "b", "c"};
for (String s : arr) {
    if (s.equals("b")) continue;
    System.out.print(s + " ");
}
```

**Answer:** `a c`

`continue` skips `"b"`. Prints `a` and `c`.

---

### ❓ Q13. What is the output?

```java
int i = 0, j = 10;
while (i < j) {
    i++;
    j--;
}
System.out.println(i + " " + j);
```

**Answer:** `5 5`

They converge: (1,9)→(2,8)→(3,7)→(4,6)→(5,5). At `i=5, j=5`: `5 < 5` is false → exit.

---

### ❓ Q14. How many times does this loop execute?

```java
for (int i = 0; i < 10; i += 3) {
    System.out.print(i + " ");
}
```

**Answer:** `4 times` — outputs `0 3 6 9`

i = 0, 3, 6, 9 → all < 10. Next: 12 → fails condition.

---

### ❓ Q15. What is the output?

```java
int n = 100;
int count = 0;
while (n > 1) {
    n /= 2;
    count++;
}
System.out.println(count);
```

**Answer:** `6`

`100→50→25→12→6→3→1` — divides by 2 six times before reaching 1.
This is essentially `floor(log₂(100)) = 6`. Very common in binary search analysis.

---

## 🌍 Mega Real World Project — Student Grade Management System

```java
public class GradeManagement {
    public static void main(String[] args) {

        // Student data: names, scores for 5 subjects
        String[] students = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[][] scores = {
            {88, 92, 78, 95, 85},    // Alice
            {45, 52, 38, 60, 55},    // Bob
            {72, 68, 80, 74, 70},    // Charlie
            {95, 98, 92, 97, 99},    // Diana
            {60, 55, 70, 65, 58}     // Eve
        };
        String[] subjects = {"Math", "Science", "English", "History", "CS"};
        int passMark = 50;

        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              STUDENT GRADE MANAGEMENT SYSTEM                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");

        double[] averages  = new double[students.length];
        int[]    totalFails = new int[students.length];

        // ── Calculate stats using for loops ───────────
        for (int s = 0; s < students.length; s++) {
            int sum  = 0;
            int fail = 0;
            for (int sub = 0; sub < subjects.length; sub++) {
                sum += scores[s][sub];
                if (scores[s][sub] < passMark) fail++;
            }
            averages[s]   = (double) sum / subjects.length;
            totalFails[s] = fail;
        }

        // ── Print per-student report ──────────────────
        for (int s = 0; s < students.length; s++) {
            System.out.printf("%n┌─ %-10s ─────────────────────────────────┐%n",
                              students[s]);

            // Subject-wise scores with pass/fail
            System.out.print("│  Scores: ");
            for (int sub = 0; sub < subjects.length; sub++) {
                System.out.printf("%s:%d ", subjects[sub], scores[s][sub]);
            }
            System.out.println();

            // Grade using if-else
            String grade;
            if      (averages[s] >= 90) grade = "A+ 🌟";
            else if (averages[s] >= 80) grade = "A";
            else if (averages[s] >= 70) grade = "B";
            else if (averages[s] >= 60) grade = "C";
            else if (averages[s] >= 50) grade = "D";
            else                        grade = "F ❌";

            // Status using ternary + switch-style logic
            String status = (totalFails[s] == 0) ? "PASS ✅" : "FAIL ❌ (" + totalFails[s] + " fails)";

            System.out.printf("│  Average: %.1f | Grade: %-6s | Result: %s%n",
                              averages[s], grade, status);
            System.out.println("└───────────────────────────────────────────────┘");
        }

        // ── Class topper (nested loops with break) ────
        System.out.println("\n📊 CLASS STATISTICS:");
        int topperIdx = 0;
        for (int s = 1; s < students.length; s++) {
            if (averages[s] > averages[topperIdx]) topperIdx = s;
        }
        System.out.printf("  🏆 Topper: %s (%.1f%%)%n", students[topperIdx], averages[topperIdx]);

        // ── Subject toppers using for-each style ──────
        System.out.println("  📚 Subject Toppers:");
        for (int sub = 0; sub < subjects.length; sub++) {
            int best = 0;
            for (int s = 1; s < students.length; s++) {
                if (scores[s][sub] > scores[best][sub]) best = s;
            }
            System.out.printf("     %-10s → %s (%d)%n",
                              subjects[sub], students[best], scores[best][sub]);
        }

        // ── Count pass/fail using while ───────────────
        int passCount = 0;
        int idx = 0;
        while (idx < students.length) {
            if (totalFails[idx] == 0) passCount++;
            idx++;
        }
        System.out.printf("%n  ✅ Passed: %d | ❌ Failed: %d%n",
                           passCount, students.length - passCount);

        // ── Highest subject average ───────────────────
        System.out.println("  📈 Subject Averages:");
        for (int sub = 0; sub < subjects.length; sub++) {
            int subTotal = 0;
            for (int s = 0; s < students.length; s++) {
                subTotal += scores[s][sub];
            }
            double subAvg = (double) subTotal / students.length;
            System.out.printf("     %-10s → %.1f%n", subjects[sub], subAvg);
        }
    }
}
```

**Output:**
```
╔══════════════════════════════════════════════════════════════╗
║              STUDENT GRADE MANAGEMENT SYSTEM                ║
╚══════════════════════════════════════════════════════════════╝

┌─ Alice      ─────────────────────────────────┐
│  Scores: Math:88 Science:92 English:78 History:95 CS:85
│  Average: 87.6 | Grade: A      | Result: PASS ✅
└───────────────────────────────────────────────┘

┌─ Bob        ─────────────────────────────────┐
│  Scores: Math:45 Science:52 English:38 History:60 CS:55
│  Average: 50.0 | Grade: D      | Result: FAIL ❌ (2 fails)
└───────────────────────────────────────────────┘

┌─ Charlie    ─────────────────────────────────┐
│  Scores: Math:72 Science:68 English:80 History:74 CS:70
│  Average: 72.8 | Grade: B      | Result: PASS ✅
└───────────────────────────────────────────────┘

┌─ Diana      ─────────────────────────────────┐
│  Scores: Math:95 Science:98 English:92 History:97 CS:99
│  Average: 96.2 | Grade: A+ 🌟  | Result: PASS ✅
└───────────────────────────────────────────────┘

┌─ Eve        ─────────────────────────────────┐
│  Scores: Math:60 Science:55 English:70 History:65 CS:58
│  Average: 61.6 | Grade: C      | Result: PASS ✅
└───────────────────────────────────────────────┘

📊 CLASS STATISTICS:
  🏆 Topper: Diana (96.2%)
  📚 Subject Toppers:
     Math       → Diana (95)
     Science    → Diana (98)
     English    → Diana (92)
     History    → Diana (97)
     CS         → Diana (99)

  ✅ Passed: 4 | ❌ Failed: 1
  📈 Subject Averages:
     Math       → 72.0
     Science    → 73.0
     English    → 71.6
     History    → 78.2
     CS         → 73.4
```

---

## 📝 Section 4 — Complete Summary

```
CONTROL FLOW QUICK REFERENCE
──────────────────────────────────────────────────────────────────

DECISION STATEMENTS:
✅  if             → single condition check
✅  if-else        → two-way branch
✅  else-if ladder → multi-way branch (top-down, first match wins)
✅  nested if      → condition within condition
✅  switch         → multi-value match on single expression
✅  switch expr    → modern switch with ->, no fall-through, returns value

LOOPS:
✅  for            → known count; init/condition/update in one line
✅  while          → unknown count; condition-first (may run 0 times)
✅  do-while       → always runs at least ONCE; condition-after
✅  for-each       → cleanest for arrays/collections (no index)

JUMP STATEMENTS:
✅  break          → exits current loop/switch immediately
✅  continue       → skips rest of current iteration
✅  return         → exits method (with or without value)

LABELS:
✅  label: for ... → name a loop
✅  break label    → exit outer (named) loop
✅  continue label → jump to next iteration of outer (named) loop

GOLDEN RULES:
✅  Always use braces {} in if/for/while — even for one line
✅  Avoid deeply nested ifs → use early return (guard clauses)
✅  Use switch when comparing one var to many constant values
✅  switch expression (Java 14+) is cleaner → prefer it
✅  for-each is safest for iterating arrays/collections
✅  Never compare doubles with == → use Math.abs(a-b) < epsilon
✅  Don't modify collection inside for-each → use iterator or index loop
✅  Watch out for fall-through in traditional switch
✅  Labeled breaks are for 2D loops / matrix search patterns

LOOP CHOICE GUIDE:
→  Do I know how many times?  YES → for
→  Iterate all elements?      YES → for-each
→  Unknown count/condition?   YES → while
→  Must run at least once?    YES → do-while
```

---

## 🔗 What's Next?

➡️ **Section 5 — Strings in Java**
**5.1 — String class, creation, immutability**

---

*Part of the Java Beginner → Advanced + DSA + System Design Master Course*
