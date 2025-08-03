
- Asymptotic notation is an important tool applied to the analysis of algorithms.
- One of AN is Big O notation.
<img width="1256" height="235" alt="image" src="https://github.com/user-attachments/assets/fb073790-1aab-4373-9608-cbecf86af1bd" />
<img width="1262" height="293" alt="image" src="https://github.com/user-attachments/assets/fc5f5bd3-77d5-46cc-b502-9ef8848571e3" />
<img width="1282" height="296" alt="image" src="https://github.com/user-attachments/assets/0d372f42-3aa7-49cb-8c5d-2228bbed918a" />

<img width="1211" height="417" alt="image" src="https://github.com/user-attachments/assets/6e2b650a-8287-4bca-9bf1-9f82ee55b868" />  
<img width="1232" height="321" alt="image" src="https://github.com/user-attachments/assets/eafe75c5-c3b8-4481-beb3-78d797c228dc" />  

```java
class NestedLoop {
	public static void main(String[] args) {
		int n = 10; // O(time complexity of the called function)
		int sum = 0; //O(1)
		double pie = 3.14; //O(1)
		int var = 1;

	
		while(var < n) {  // O(log n)
			System.out.println("Pie: " + pie); // O(log n)
			
			for (int j = 0; j < var; j++) {  // 2n
				sum++;  //  (2n-1)
			}
			var *= 2; // O(log n)
		} //end of while loop
		
		System.out.println("Sum: " + sum); //O(1)
	} //end of main
} //end of class
```
Big O.  
``` answer
<img width="1235" height="417" alt="image" src="https://github.com/user-attachments/assets/aab4ad2a-6d6c-4df0-9acd-db826eb7a603" />
<img width="1255" height="572" alt="image" src="https://github.com/user-attachments/assets/1008e008-7f79-4dc1-8a1f-deebeec7a804" />

```
<img width="1331" height="255" alt="image" src="https://github.com/user-attachments/assets/8a5d58c9-59d1-476e-9f9e-a8f79cee5946" />  
<img width="1277" height="502" alt="image" src="https://github.com/user-attachments/assets/9ee3ca67-0f4b-4c4c-b50c-6d7627b21a56" />  
<img width="1263" height="597" alt="image" src="https://github.com/user-attachments/assets/11308b96-eb7b-4b48-87bb-81fe329a9b12" />  
<img width="1248" height="382" alt="image" src="https://github.com/user-attachments/assets/141df67d-d46c-48fd-a3aa-a879ded144a6" />  
<img width="1255" height="515" alt="image" src="https://github.com/user-attachments/assets/365a015e-8253-4943-bfb3-49c08c03e948" />  

What is a Stack?  
- We are all familiar with the famous Undo option, which is present in almost every application. Have you ever wondered how it works? The idea is that you store the previous states of your work (which are limited to a specific number), in the memory in such an order that the last one appears first. This can’t be done just by using arrays, which is why the Stack comes in handy.  
- You can think of the Stack as a container, in which we can add items and remove them. Only the top of this container is open, so the item we put in first will be taken out last, and the items we put in last will be taken out first. This is called the last in first out (LIFO) ordering.

<img width="1106" height="627" alt="image" src="https://github.com/user-attachments/assets/fbca44ff-8301-4f3d-9254-56aec787f849" />  
<img width="1293" height="547" alt="image" src="https://github.com/user-attachments/assets/57034478-00dd-4242-9f3a-fac731f80034" />  

- Stacks can either be implemented using arrays or linked lists. Stacks are generally implemented using arrays because it takes less space; we don’t need to store an additional pointer like in a linked list.
-  Java doesn’t allow direct creation of generic arrays like new V[maxSize]. You must do unchecked casts (like with generic arrays), Only use it when you're sure the cast won't cause runtime errors.
-  <img width="1263" height="267" alt="image" src="https://github.com/user-attachments/assets/ad503feb-77cb-467b-999f-7816ddcf5966" />
```java
 how to construct the Stack class:
public class Stack <V> {
    private int maxSize;
    private int top;
    private V arr[];

    /*
    Java does not allow generic type arrays. So we have used an 
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1; //initially when stack is empty
        arr = (V[]) new Object[max_size];//type casting Object[] to V[]
    }
    public int getCapacity() {
        return maxSize;
    }

}
```
code for stacks with the new helper methods.
```java
public class Stack <V> {
    private int maxSize;
    private int top;
    private V array[];

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //returns the maximum size capacity
    public int getMaxSize() {
        return maxSize;
    }

    //returns true if Stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    //returns true if Stack is full
    public boolean isFull(){
        return top == maxSize -1;
    }

    //returns the value at top of Stack
    public V top(){
        if(isEmpty())
            return null;
        return array[top];
    }
}
```
add and remove some elements from this stack by using these two functions.

```java
public class Stack <V> {
    private int maxSize;
    private int top;
    private V array[];

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //returns the maximum size capacity
    public int getMaxSize() {
        return maxSize;
    }

    //returns true if Stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    //returns true if Stack is full
    public boolean isFull(){
        return top == maxSize -1;
    }

    //returns the value at top of Stack
    public V top(){
        if(isEmpty())
            return null;
        return array[top];
    }

    //inserts a value to the top of Stack
    public void push(V value){
        if(isFull()) {
            System.err.println("Stack is Full!");
            return;
        }
        array[++top] = value; //increments the top and adds value to updated top
    }

    //removes a value from top of Stack and returns
    public V pop(){
        if(isEmpty())
            return null;
        return array[top--]; //returns value and top and decrements the top
    }

}
```

If you look at the output of the code, you can see that the elements popped out of the stack in the exact reverse order as they were pushed in. That means our Stack works perfectly.  









