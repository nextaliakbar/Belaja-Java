package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountdownTest {

    @Test
    void testCountdown() throws InterruptedException {
        final var countDownLatch = new CountDownLatch(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
               try {
                   System.out.println("Start Task");
                   Thread.sleep(2000);
                   System.out.println("Finish Task");
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
                System.out.println("Finis All Task");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
