package classes;

import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama :");
        String nama = scanner.nextLine();
        System.out.print("Umur :");
        Integer umur = scanner.nextInt();
        System.out.println("Hello " + nama + " Umur anda " + umur);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello ");
        stringBuilder.append(nama);
        stringBuilder.append(" Umur anda ");
        stringBuilder.append(umur);
        String builder = stringBuilder.toString();
        System.out.println(builder);
    }
}
