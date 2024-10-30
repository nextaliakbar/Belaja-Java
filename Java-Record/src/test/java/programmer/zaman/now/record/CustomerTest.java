package programmer.zaman.now.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.record.data.Customer;

import java.lang.reflect.RecordComponent;

public class CustomerTest {

    @Test
    void testCreateNewRecord() {
        Customer customer =
                new Customer("1", "Ali Akbar Rafsanjani",
                        "akbar@gmail.com", "08123456789");
        System.out.println(customer);
        customer.sayHello("Akbar");

    }

    @Test
    void testGetProperty() {
        Customer customer =
                new Customer("1", "Ali Akbar Rafsanjani",
                        "akbar@gmail.com", "08123456789");
        System.out.println(customer.id());
        System.out.println(customer.name());
        System.out.println(customer.email());
        System.out.println(customer.phone());
    }

    @Test
    void testConstructor() {
        Customer customer1 = new Customer("1", "Ali Akbar", "akbar@gmail.com");
        Customer customer2 = new Customer("2", "Akbar");
        System.out.println(customer1);
        System.out.println(customer2);
    }

    @Test
    void testCanonicalConstructor() {
        Customer customer =
                new Customer("AKBAR", "Ali Akbar Rafsanjani",
                        "AKBAR@GMAIL.COM", "08123456789");
        System.out.println(customer);
    }

    @Test
    void testRecordEquals() {
        Customer customer1 = new Customer("1", "Akbar", "akbar@gmail.com");
        Customer customer2 = new Customer("1", "Akbar", "akbar@gmail.com");
        System.out.println(customer1.equals(customer2));
        System.out.println(customer1.hashCode());
        System.out.println(customer2.hashCode());
        Assertions.assertTrue(customer1.equals(customer2));
        Assertions.assertEquals(customer1.hashCode(), customer2.hashCode());
        Assertions.assertEquals(customer1.toString(), customer2.toString());
    }

    @Test
    void testRecordComponent() {
        Assertions.assertTrue(Customer.class.isRecord());
        RecordComponent[] components = Customer.class.getRecordComponents();
        for (var component : components) {
            System.out.println(component.getName());
            System.out.println(component.getType());
        }
    }
}
