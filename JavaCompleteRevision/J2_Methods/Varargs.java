//Variable argument passing in Java is facilitated through the varargs feature, allowing methods to accept multiple arguments of the same type. 

class varargs {

    public void childrenName(String... names){
        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
    }
    public static void main(String[] args) {
        varargs v = new varargs();
        v.childrenName("Alice", "Bob", "Charlie");
        v.childrenName("sanjeev", "Gaikwad");
        v.childrenName("John");
        v.childrenName();
    }
}