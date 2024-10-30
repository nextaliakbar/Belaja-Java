package classes;

public class StringBuilderApp {
    public static void main(String[] args) {
        String name = "Ali";
        name = name + " " + "Akbar";
        name = name + " " + "Rafsanjani";
        System.out.println(name);

//      Yang terjadi di program java
//      Ali
//      Akbar
//      Rafsanjani

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ali ");
        stringBuilder.append("Akbar ");
        stringBuilder.append("Rafsanjani");

        String builderName = stringBuilder.toString();
        System.out.println(builderName);
    }
}
