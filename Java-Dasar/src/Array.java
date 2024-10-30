public class Array {
    public static void main(String[] args) {
//      Deklarasi Array
//      Cara 1
        String[] stringArray1;
        stringArray1 = new String[3];
        stringArray1[0] = "Ali";
        stringArray1[1] = "Akbar";
        stringArray1[2] = "Rafsanjani";

        System.out.println(stringArray1[0]);
        System.out.println(stringArray1[1]);
        System.out.println(stringArray1[2]);

        stringArray1[0] = "Budi";
        System.out.println(stringArray1[0]);

        String[] stringArray2 = new String[3];

//      Cara 2
        String[] fullName = new String[]{"Ali", "Akbar", "Rafsanjani"};
//      Cara 3
        int[] arrayInt = {1,2,3,4,5,6,7,8,9};

//      Mengubah data array
        fullName[0] = null;
        arrayInt[0] = 0;

        System.out.println(arrayInt.length); // melihat panjang array
        System.out.println(arrayInt[0]);
        System.out.println(fullName[0]);

//      Array Multidimensi
        String[][] members = new String[][]{
                {"Ali", "Akbar"},
                {"Budi","Nugraha"},
                {"Rudi"}
        };
        System.out.println(members[0][1]);
        System.out.println(members[2][0]);
    }
}
