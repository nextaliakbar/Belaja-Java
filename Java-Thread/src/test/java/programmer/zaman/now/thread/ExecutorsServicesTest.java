package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsServicesTest {

    @Test
    void testExecutorsServicesSingle() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            executor.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("Runnabel in Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testExecutorsServicesFix() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("Runnabel in Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testExecutorsChace() throws InterruptedException {
        var executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("Runnabel in Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
