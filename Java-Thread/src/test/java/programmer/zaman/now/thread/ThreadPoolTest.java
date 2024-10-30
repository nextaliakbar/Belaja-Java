package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    @Test
    void testThreadPool() {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(100);

        var thread = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

    }

    @Test
    void testExecuteRunnable() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(100);

        var thread = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        Runnable runnable = ()-> {
            try {
                Thread.sleep(5000);
                System.out.println("Runnable from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        thread.execute(runnable);
        Thread.sleep(6000);
    }

    @Test
    void testShutdhown() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(1000);

        var thread = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        for (int i = 0; i <1000 ; i++) {
            final var task = i;
            Runnable runnable = ()-> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " From Thread " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
        thread.execute(runnable);
        }

        //thread.shutdown();
        thread.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testRejected() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(10);
        var rejected = new LogRejectedExecutionHandler();

        var thread = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue, rejected);

        for (int i = 0; i <1000 ; i++) {
            final var task = i;
            Runnable runnable = ()-> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " From Thread " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
        thread.execute(runnable);
        }

        //thread.shutdown();
        thread.awaitTermination(1, TimeUnit.DAYS);

    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task " + r + " is rejected");
        }
    }
}
