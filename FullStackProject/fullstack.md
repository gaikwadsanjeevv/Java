<img width="1776" height="622" alt="image" src="https://github.com/user-attachments/assets/53e2eb02-d2d1-48df-982f-ace590a67349" />  
<img width="1664" height="1006" alt="image" src="https://github.com/user-attachments/assets/c3a44b80-6067-47d5-b038-8a41752f59bd" />  
<img width="1622" height="1106" alt="image" src="https://github.com/user-attachments/assets/d91f5415-2c26-47fa-82b0-01782818ed7b" />  
- Java Introduced it to avoid messy concatenations.  
👉 System.out.printf() = Print formatted text to console.  
👉 String.format() = Returns a formatted string (without printing).  
<img width="1318" height="1028" alt="image" src="https://github.com/user-attachments/assets/8e6ad0a3-e079-46dc-82a1-bc39bb2bcf04" />
<img width="1314" height="958" alt="image" src="https://github.com/user-attachments/assets/faf5f4dd-81c2-48fb-b8c8-3de82e15bab8" />
<img width="1314" height="958" alt="image" src="https://github.com/user-attachments/assets/9f6b2425-3f16-4212-89f2-04c89d21a70f" />






Primitive data types are fundamental building blocks in Java, representing basic values like numbers and characters directly in memory. They are efficient and don't have methods. In contrast, wrapper classes are Java objects that encapsulate these primitive types. They provide a way to treat primitives as objects, which is essential for many of Java's features.    <img width="1304" height="582" alt="image" src="https://github.com/user-attachments/assets/ea74e61b-5985-43a7-b78a-fd3be370cffc" />    Autoboxing and Unboxing 📦      

Java simplifies the use of wrappers with autoboxing and unboxing.      
Autoboxing is the automatic conversion of a primitive type to its corresponding wrapper class. For example, Integer myInt = 10; is valid. Java automatically converts the primitive int to an Integer object. Unboxing is the reverse: the automatic conversion of a wrapper object to its corresponding primitive type. For example, int myValue = new Integer(50); automatically extracts the primitive int value from the Integer object. This feature makes it feel like you can use primitives and wrappers interchangeably in many situations.
Application Example  
Consider a scenario where you need to store a list of student scores. If a student hasn't taken a test, their score should be considered "not available."  

Using a primitive int is not a good choice because int must have a value and cannot be null.  

Primitive values (like int, char, or boolean) are single, simple values that are highly efficient to store and use. However, they lack the ability to group related data or have associated behaviors. Objects, on the other hand, are designed to model complex entities. They may have more memory overhead than primitives, but the benefits of encapsulation, inheritance, and polymorphism make them essential for building robust, scalable, and manageable applications.  
5751
