package classes;

import java.util.Random;

public class RandomApp {
    public static void main(String[] args) {
        Random rands = new Random();
        for (int i = 0; i < 100 ; i++) {
            int rand = rands.nextInt(1000000);
            System.out.println(rand);
        }
    }
}
