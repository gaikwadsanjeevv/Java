public class MethodOverloading {
    
    // Method with no parameters
    public void display() {
        System.out.println("Hello! This is a method with no parameters.");
    }

    // Method with one parameter
    public void display(String name) {
        System.out.println("Hello, " + name + "! This is a method with one parameter.");
    }

    // Method with two parameters
    public void display(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old. This is a method with two parameters.");
    }

    // Method with different parameter types
    public void display(int number) {
        System.out.println("The number you entered is: " + number);
    }

    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();
        
        mo.display();  // Calls the method with no parameters
        mo.display("Alice");  // Calls the method with one String parameter
        mo.display("Bob", 30);  // Calls the method with String and int parameters
        mo.display(42);  // Calls the method with an int parameter
    }
}
