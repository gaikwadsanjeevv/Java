
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









