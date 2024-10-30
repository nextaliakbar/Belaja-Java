package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {

    @Test
    void testConcurrentMap() throws InterruptedException {
        final var countDownLatch = new CountDownLatch(100);
        final var map = new ConcurrentHashMap<Integer, String>();
        final var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final var index = i;
            executor.execute(()-> {
                try {
                    Thread.sleep(1000);
                    map.putIfAbsent(index, " Data " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(()-> {
            try {
                countDownLatch.await();
                map.forEach((integer, string) -> System.out.println(integer + " : " + string));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
        executor.shutdown();
    }

    @Test
    void testCollection() {
        List<String> list = List.of("Ali", "Akbar", "Rafsanjani");
        List<String> synchronizeList = Collections.synchronizedList(list);

    }
}
