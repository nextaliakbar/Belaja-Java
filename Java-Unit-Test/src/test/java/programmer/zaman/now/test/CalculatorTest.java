package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("Test untuk calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll // -> harus static
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll // -> harus static
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }

    @Test
//    @DisplayName("Test skenario sukses untuk method add(Integer, Integer)")
    public void testAddSucces() {
        var result = calculator.add(10, 10);
        // Method manual
        /**
        if(result != null) {
            throw new IllegalArgumentException("Test failed");
        }
         */

        // Method otomatis -> assertion
        assertEquals(20, result);
    }

    @Test
    public void testDevideSucces() {
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDevideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon() {
        // Test coming soon
    }

    @Test
    public void testAbborted() {
        var profile = System.getenv("PROFILE");
        if(!profile.equals("DEV")) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        // unit test untuk DEV
    }

    @Test
    public void testAssumptions() {
        assertTrue("DEV".equals(System.getenv("PROFILE")));
        // unit test untuk DEV
    }
}
