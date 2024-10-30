public class PersonApp {
    public static void main(String[] args) {
        var person1 = new Person("Ali", "Jember");
        Person person2 = new Person("Budi");
        Person person3;
        person3 = new Person();

//        person1.name = "Akbar";
//        person1.addres = "Jember";
//        person1.country = "Indonesia"; // Tidak bisa dirubah karena final

        System.out.println(person1.name);
        System.out.println(person1.addres);
        System.out.println(person3.country);

        person1.sayHello("Ali");
        person3.name = "Rafsanjani";
        person3.sayHello("Ali");
    }
}
