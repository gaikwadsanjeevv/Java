// Pass by Reference Explanation in Java
// Note: Java does NOT have true pass by reference like C++
// Java ALWAYS passes by value, but the VALUE can be a reference (memory address)
import java.util.*;
class PassByReference {

    // Example 1: Attempting pass by reference with objects
    public static void modifyArray(int[] array) {
        // We can modify the array contents (because array reference is copied)
        array[0] = 999;
        System.out.println("Inside method - array[0]: " + array[0]);
        
        // But we CANNOT change what the reference points to (from caller's perspective)
        array = new int[]{1, 2, 3, 4, 5};  // This doesn't affect original
        System.out.println("Inside method - after reassignment: " + array.length);
    }

    // Example 2: What if Java had true pass by reference? (Hypothetical)
    // This would require syntax like: public static void modify(int& num) { ... }
    // Java doesn't support this syntax

    // Example 3: Why object properties can be modified
    public static void modifyPerson(Person person) {
        // Multiple operations on the object
        person.name = "Updated Name";
        person.age = 30;
        person.updateAddress("New York");
        
        System.out.println("Inside method - Person: " + person);
        
        // Reassignment doesn't work
        person = new Person("Different Person", 25);
        System.out.println("Inside method - after reassignment: " + person);
    }

    // Example 4: Demonstration of reference copy
    public static void showReferenceCopy(List list) {
        System.out.println("Reference in method: " + System.identityHashCode(list));
        list.add("New Item");  // Affects original
        
        list = new ArrayList();  // This doesn't affect the original list reference
        list.add("Won't appear");
    }

    public static void main(String[] args) {
        
        System.out.println("===== TEST 1: Array Modification =====");
        int[] numbers = {1, 2, 3};
        System.out.println("Before method: " + numbers[0]);
        System.out.println("Reference ID before: " + System.identityHashCode(numbers));
        modifyArray(numbers);
        System.out.println("After method: " + numbers[0]);  // 999 (modified)
        System.out.println("Reference ID after: " + System.identityHashCode(numbers));
        System.out.println("Array length: " + numbers.length);  // Still 3 (not changed)
        
        System.out.println("\n===== TEST 2: Object Modification =====");
        Person person = new Person("John", 25);
        System.out.println("Before method: " + person);
        System.out.println("Reference ID before: " + System.identityHashCode(person));
        modifyPerson(person);
        System.out.println("After method: " + person);  // Properties modified
        System.out.println("Reference ID after: " + System.identityHashCode(person));
        
        System.out.println("\n===== TEST 3: List Modification =====");
        List<String> list = new ArrayList<>();
        list.add("Original");
        System.out.println("Before method: " + list);
        System.out.println("Reference ID before: " + System.identityHashCode(list));
        showReferenceCopy(list);
        System.out.println("After method: " + list);  // New item added
        System.out.println("Reference ID after: " + System.identityHashCode(list));
    }
}

class Person {
    String name;
    int age;
    String address;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "Unknown";
    }
    
    void updateAddress(String newAddress) {
        this.address = newAddress;
    }
    
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}