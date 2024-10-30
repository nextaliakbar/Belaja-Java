public class KonversiNumber {
    public static void main(String[] args) {
//      Konversi Tipe Data Number

//      Widening Casting (Otomatis)
        byte iniByte1 = 10;
        short iniShort1 = iniByte1;
        int iniInt1 = iniShort1;

//      Narrowing Casting (Manual)
        int iniInt2 = 1000;
        byte iniByte2 = (byte) iniInt2;
    }
}
