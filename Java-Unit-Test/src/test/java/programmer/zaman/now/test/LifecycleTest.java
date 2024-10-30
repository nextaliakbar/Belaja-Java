package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

    /** Lifecycle test secara default adalah independen -> yaitu akan dibuat baru
     Contoh
     OrderTest o1 = new OrderTest1();
     OrderTest o2 = new OrderTest1();
     */

    private String name;

    @Test
    public void testA() {
        name = "Ali Akbar";
    }

    @Test
    public void testB() {
        System.out.println(name);
    }
}
