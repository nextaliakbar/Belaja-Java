package programmer.zaman.now.virtual.thread;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceVirtualApp {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors =
                Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 10_000; i++) {
            executors.execute(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + Thread.currentThread());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.DAYS);
    }
}
