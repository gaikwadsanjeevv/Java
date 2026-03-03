// Pass by Value in Java - Explained with Examples

class PassByValue {

    // Example 1: Pass by value with Primitive Types
    public static void changePrimitive(int num) {
        num = 100;  // This change does NOT affect the original variable
        System.out.println("Inside method: " + num);
    }

    // Example 2: Pass by value with Objects (reference is copied)
    public static void changeObject(Person person) {
        // Modifying object properties WILL affect the original object
        person.name = "Modified Name";
        System.out.println("Inside method - name: " + person.name);
        
        // Reassigning the reference does NOT affect the original reference
        person = new Person("NewPerson");
        System.out.println("Inside method - after reassignment: " + person.name);
    }

    // Example 3: Pass by value with String (Strings are immutable)
    public static void changeString(String str) {
        str = "Changed String";  // This does NOT affect the original
        System.out.println("Inside method: " + str);
    }

    public static void main(String[] args) {
        
        // TEST 1: Primitive Type
        System.out.println("===== TEST 1: Primitive Type =====");
        int original = 50;
        System.out.println("Before method call: " + original);
        changePrimitive(original);
        System.out.println("After method call: " + original);  // Still 50
        
        System.out.println("\n===== TEST 2: Object Reference =====");
        Person person = new Person("John");
        System.out.println("Before method call: " + person.name);
        changeObject(person);
        System.out.println("After method call: " + person.name);  // "Modified Name" (changed)
        
        System.out.println("\n===== TEST 3: String =====");
        String str = "Original String";
        System.out.println("Before method call: " + str);
        changeString(str);
        System.out.println("After method call: " + str);  // Still "Original String"
    }
}

// Helper class
class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
}
