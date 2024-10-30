public class TipeDataBukanPrimitif {
    public static void main(String[] args) {
        Integer iniInteger = 100;
        Long iniLong1 = 10_000L;

        //Byte iniByte; // Error
        Byte iniByte = null;
        System.out.println(iniByte);

        iniByte = 100;
        System.out.println(iniByte);

//      Koversi Tipe Data Primitif -> Bukan Primitif
        int iniInt1 = 10_000;
        Integer iniInt2 = iniInt1;
        System.out.println(iniInt2);

        Integer iniObject = iniInt2;
        short iniShort = iniObject.shortValue();
        float iniFloat = iniObject.floatValue();
        double iniDouble = iniObject.doubleValue();
        long iniLong2 = iniObject.longValue();
        System.out.println("Short " + iniShort);
        System.out.println("Float " + iniFloat);
        System.out.println("Double " + iniDouble);
        System.out.println("Long " + iniLong2);

    }
}
