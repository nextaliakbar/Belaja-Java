package classes;

public class StringApp {
    public static void main(String[] args) {
        String name = "Ali Akbar Rafsanjani";
        String nameLowerCase = name.toLowerCase();
        String nameUpperCase = name.toUpperCase();

        System.out.println(name);
        System.out.println(nameLowerCase);
        System.out.println(nameUpperCase);
        System.out.println(name.length());
        System.out.println(name.startsWith("Rafsanjani"));
        System.out.println(name.endsWith("Rafsanjani"));

        String[] names = name.split(" ");
        for(String value : names) {
            System.out.println(value);
        }

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(name.charAt(0));


    }
}
