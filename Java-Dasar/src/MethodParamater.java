public class MethodParamater {
    public static void main(String[] args) {
        sayHello("Ali", "Akbar");
        sayHello("Budi", "Nugraha");
    }

    static void sayHello(String firstName, String lastName) {
        System.out.println("Hello " + firstName + " " + lastName);
    }
}
