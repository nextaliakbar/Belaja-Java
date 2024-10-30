package programmer.zaman.now.sealed;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.sealed.data.Employee;
import programmer.zaman.now.sealed.data.Manager;
import programmer.zaman.now.sealed.data.VicePrecident;

public class ClassTest {

    @Test
    void testEmployee() {
        Employee employee = new Employee();
        Manager manager = new Manager();
        manager.setId("1");
        manager.setName("Ali Akbar Rafsanjani");
        manager.setDepartement("Technology Information");
        VicePrecident vicePrecident = new VicePrecident();
        vicePrecident.setId("2");
        System.out.println(vicePrecident.getId());
    }
}
