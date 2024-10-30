package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class WhenNew {
        @BeforeAll
        public void setup() {
            queue = new LinkedList<>();
            System.out.println(queue.size());
        }

        @Test
        @Order(1)
        @DisplayName("when offer, size must be 1")
        public void offerNewData() {
            queue.offer("Ali Akbar");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @Order(2)
        @DisplayName("when offer 2 data, size must be 2")
        public void offerMoreData() {
            queue.offer("Rafsanjani");
            Assertions.assertEquals(2, queue.size());
        }

        @AfterEach
        public void afterEach() {
            queue.forEach(values -> System.out.println(values));
        }
    }
}
