public class Variable {
    public static void main(String[] args) {
//      Inisiasi tidak langsung
        String name;
        name = "Ali Akbar Rafsanjani";
        System.out.println(name);

//      Inisiasi langsung
        int age = 20;
        String addres = "Indonesia";
        System.out.println(age);
        System.out.println(addres);

//      Mengganti value variable
        name = "Budi Nugraha";
        System.out.println(name);

//      Kata Kunci Var
        var firstName = "Ali Akbar";
        var lastName = "Rafsanjani";
        var fullName = firstName + " " + lastName;
        System.out.println(fullName);

//      Kata Kunci Final / Tidak Bisa Diubah
        final String application = "Belajar Java";
        // application = "Belajar PHP"; // Error
    }
}
