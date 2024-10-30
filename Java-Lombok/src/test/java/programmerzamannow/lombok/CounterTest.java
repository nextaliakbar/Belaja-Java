package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class CounterTest {

    @Test
    void testSynchronize() throws InterruptedException {

        var counter = new Counter();

        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                for (int j = 0; j < 100; j++) {
                    counter.increment();
                }
            }).start();
        }

        Thread.sleep(1000L);
        System.out.println(counter.getCounter());
    }
}
