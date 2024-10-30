public class TipeDataNumber {
    public static void main(String[] args) {
//      Integer Number
        byte iniByte = 100; // -127 -> 127 = 1bytes
        short iniShort = 1000; // -32000 -> 32000 = 2bytes
        int initInt = 10000000; // -2M -> 2M = 3bytes
        long iniLong1 = 1000000000; // -9M -> 9M = 4bytes
        long iniLong2 = 1000000000L; // -9M -> 9M = 8bytes

//      Floating Point Number
        float iniFloat = 10.10f; // 3.4e-038 -> 3.4e+038 = 4bytes
        double iniDouble = 10.10; //1.7e-038 -> 1.7e+038 = 8bytes

//      Literals Number
        int decimalInt = 25; // decimal
        int hexaDecimal = 0xfffff; // hexadecimal
        int binDecimal = 0b010101; // binary

//      Undescore / Pemisah
        int amount = 1_000_000_000;

    }
}
