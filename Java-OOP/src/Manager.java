class Manager extends Employee {
    String company;

    Manager(String name, String company) {
        super(name);
        this.company = company;
    }

    Manager(String name) {
        super(name);
    }

    void sayHello(String name) {
        System.out.println("Hello " + name + " My Name is Manager " + this.name);
    }
}

class VicePresident extends Manager {

    VicePresident(String name) {
        super(name, null);
    }

    void sayHello(String name) {
        System.out.println("Hello " + name + " My Name is Vice President " + this.name);
    }
}
