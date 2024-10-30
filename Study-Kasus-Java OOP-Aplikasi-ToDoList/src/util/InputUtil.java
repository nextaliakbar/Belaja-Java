package util;

import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputData(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }
}
