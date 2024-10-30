package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    @Test
    void testThreadLocal() throws InterruptedException {
        final var random = new Random();
        final var threadLocal = new UsersService();
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    threadLocal.setUser("User " + index);
                    Thread.sleep(1000 + random.nextInt(3000));
                    threadLocal.doAction();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();;
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
