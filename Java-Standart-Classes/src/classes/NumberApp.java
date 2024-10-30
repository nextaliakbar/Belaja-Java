package classes;

public class NumberApp {
    public static void main(String[] args) {
        Integer intValue = 10;
        Long longValue = intValue.longValue();
        Double doubleValue = longValue.doubleValue();
        Float floatValue = doubleValue.floatValue();
        Short shortValue = floatValue.shortValue();
        System.out.println(shortValue);

        String contoh1 = "10000";
        Integer contohInt = Integer.valueOf(contoh1);
        System.out.println(contohInt);

        String contoh2 = "100.102";
        Double contohDouble = Double.valueOf(contoh2);
        System.out.println(contohDouble);
    }
}
