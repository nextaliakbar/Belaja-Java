package programmer.zaman.now.record.data;

public record Customer(String id, String name, String email, String phone) implements SayHello{

    // Canonical Constructor
    public Customer(String id, String name, String email, String phone) {
        System.out.println("Create Customer");
        this.id = id.toLowerCase();
        this.name = name;
        this.email = email != null ? email.toLowerCase() : null;
        this.phone = phone != null ? phone.toLowerCase() : null;
    }

    public Customer(String id, String name, String email) {
        this(id, name, email, null);
    }

    public Customer(String id, String name) {
        this(id, name, null);
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name + " My full name is " + this.name);
    }
}
