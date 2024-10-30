package programmer.zaman.now.application;

public class EqualsApp {
    public static void main(String[] args) {
        String first = "Ali";
        first = first + " "+"Akbar";
        System.out.println(first);

        String second = "Ali Akbar";
        System.out.println(second);

//      Karena Objek nya berbeda dan optimasi memory berbeda
        System.out.println(first == second);

        String third = "Ali Akbar";

        System.out.println(second == third);

        System.out.println(first.equals(second));
        System.out.println(first.equals(third));
    }
}
