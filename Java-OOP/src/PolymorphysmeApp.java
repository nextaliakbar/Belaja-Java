import programmer.zaman.now.annotation.Fancy;

public class PolymorphysmeApp {
    public static void main(String[] args) {
        Employee employee = new Employee("Ali");
        employee.sayHello("Budi");

        employee = new Manager("Akbar");
        employee.sayHello("Budi");

        employee = new VicePresident("Rafsanjani");
        employee.sayHello("Budi");

        sayHello(new Employee("Ali"));
        sayHello(new Manager("Akbar"));
        sayHello(new VicePresident("Rafsanjani"));
    }

    @Fancy(name = "sayHello", tags = {"Application", "Java"})
    static void sayHello(Employee employee) {
        if(employee instanceof VicePresident) {
            VicePresident vicePresident = (VicePresident) employee;
            System.out.println("Hello Vice Precident " + vicePresident.name);
        } else if(employee instanceof Manager) {
            Manager manager = (Manager) employee;
            System.out.println("Helo Manager " + manager.name);
        } else {
            System.out.println(employee.name);
        }
    }
}
