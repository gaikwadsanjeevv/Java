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

## What Happens in Memory — For Real

When you write `int age = 25`, Java does three things physically:

Step 1 — sees the type `int` → goes to Stack memory → reserves exactly 4 bytes

Step 2 — labels those 4 bytes with the name `age`

Step 3 — converts 25 to binary and stores it in those 4 bytes
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
