class Person {
    String name;
    String addres;
    final String country = "Indonesia";

    Person(String name, String addres) {
        this.name = name;
        this.addres = addres;
    }

    Person(String name) {
        this(name, null);
    }

    Person() {
        this(null);
    }

    void sayHello(String name) {
        System.out.println("Hello " + name + " My Name is " + this.name);
    }
}
