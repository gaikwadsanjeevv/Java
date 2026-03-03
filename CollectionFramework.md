## Collection Framework  
#### Most high-performance collections in Java are hash-based, and understanding hashing explains how collections achieve O(1) performance.  
### Set and Hashing Techniques  
- Hashing is a fundamental technique widely used in Java for fast data retrieval and storage. Many of Java’s collection classes, such as HashSet, HashMap, LinkedHashSet, and LinkedHashMap, utilize hashing to achieve efficient lookup and insertion operations.
#### What is Hashing?  
Hashing is a process of mapping data to a fixed-size value using a function known as a hash function. In Java:  

- The hash function determines the location (or bucket) where data should be stored.  
- When a value is inserted, the hash function calculates its index in the hash table.  
- For lookups, the same hash function is used to quickly locate the value.  
    - Constant Time Lookup: Ideally, insertions and searches using hash functions operate in constant time, O(1).  
    - Efficiency: Hashing is efficient as it reduces the time complexity for searching data compared to linear search methods.
#### Hash Tables & Buckets  
A hash table is a data structure that stores data in an array-like format. Each slot in the hash table is commonly referred to as a bucket.  

- Buckets: Each bucket can hold a single value, a key-value pair, or multiple entries (in case of collisions).  
- Dynamic Sizing: Many Java classes start with a default size (often 16) and resize dynamically as needed to maintain efficiency.  

#### Operation	Description	Time Complexity  
Insertion → Uses the hash function to determine the index and inserts the element.→ O(1) (amortized)  
Search --> 	Computes bucket index and retrieves element. --> 	O(1) (amortized)  
Collision --> 	If a bucket is occupied, a resolution method is applied.	--> O(n) worst-case  
 
