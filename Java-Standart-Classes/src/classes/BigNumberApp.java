package classes;

import java.math.BigInteger;

public class BigNumberApp {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("20000000000000000000");
        BigInteger b = new BigInteger("10000000000000000000");

        BigInteger resultPlus = a.add(b);
        BigInteger resultMin = a.subtract(b);
        System.out.println(resultPlus);
        System.out.println(resultMin);
    }
}
