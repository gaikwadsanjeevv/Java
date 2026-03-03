package JavaCompleteRevision.J3_Classes;

public class Accessibility {
    public int publicVar = 10;  // Accessible from anywhere
    protected int protectedVar = 20;  // Accessible within the same package and subclasses
    int defaultVar = 30;  // Accessible within the same package (default access)
    private int privateVar = 40;  // Accessible only within this class

    public void publicMethod() {
        System.out.println("Public method");
    }

    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    void defaultMethod() {
        System.out.println("Default method");
    }

    private void privateMethod() {
        System.out.println("Private method");
    }

    public static void main(String[] args) {
        Accessibility obj = new Accessibility();
        
        // Accessing variables
        System.out.println("Public Variable: " + obj.publicVar);
        System.out.println("Protected Variable: " + obj.protectedVar);
        System.out.println("Default Variable: " + obj.defaultVar);
        // System.out.println("Private Variable: " + obj.privateVar); // Not accessible
        
        // Accessing methods
        obj.publicMethod();
        obj.protectedMethod();
        obj.defaultMethod();
        // obj.privateMethod(); // Not accessible
    }
}
