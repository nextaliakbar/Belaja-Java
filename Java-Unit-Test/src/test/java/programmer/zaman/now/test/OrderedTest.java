package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // Default -> Instance variable di buat setiap method
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Intance variable dibuat satu kali dan dipanggil berkali - kali , dapat di menggunakan before dan after all
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private String name;
    private String addres;
    private int age;

    @BeforeAll
    public void beforeAll() {
        System.out.println("Before All " + name);
    }

    @AfterAll
    public void afterAll() {
        System.out.println("After All " + name);
    }

    @Test
    @Order(1)
    public void test3() {
        name = "Ali Akbar Rafsanjani";
        age = 21;
    }

    @Test
    @Order(2)
    public void test2() {
        addres = "Jember, Jawa Timur";
    }

    @Test
    @Order(3)
    public void test1() {
        System.out.println("Name " + name + " Addres " + addres + " Age " + age);
    }
}
