package classes;

public class MathApp {
    public static void main(String[] args) {
        int min = Math.min(1000, 2000);
        System.out.println("Min Value " + min);

        int max = Math.max(1000, 2000);
        System.out.println("Max Value " + max);

        boolean cekVal = 3.14 == Math.PI;
        String strCekVal = 3.14 * 3 > Math.PI ? "true" : "false";
        System.out.println(cekVal);
        System.out.println(strCekVal);
    }
}
