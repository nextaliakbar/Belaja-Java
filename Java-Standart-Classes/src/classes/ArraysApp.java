package classes;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {
        int[] numbers = {1, 4, 456, 3, 67, 9, 100, 87, 95, 74, 78};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.binarySearch(numbers, 7));
        System.out.println(Arrays.binarySearch(numbers, 100));
        System.out.println(Arrays.binarySearch(numbers, 9));

        int[] results1 = Arrays.copyOf(numbers, 5);
        System.out.println(Arrays.toString(results1));
        int[] results2 = Arrays.copyOfRange(numbers, 5, 8);
        System.out.println(Arrays.toString(results2));

        boolean cekArray = Arrays.equals(results1, results2);
        System.out.println(cekArray);
    }
}
