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
















  
