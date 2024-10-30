package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarierTest {

    @Test
    void testCyclicBarier() throws InterruptedException {
        var cyclicBarier = new CyclicBarrier(5);
        var executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 5; i++) {
            executor.execute(()-> {
                try {
                    System.out.println("Waiting");
                    cyclicBarier.await();
                    System.out.println("Done Awaiting from" + Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
