package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorTest {

    @Test
    void testDelayJob() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);

        var futurue = executor.schedule(()-> System.out.println("Hello Schedule"), 4, TimeUnit.SECONDS);

        System.out.println(futurue.getDelay(TimeUnit.MILLISECONDS));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testPeriodicJob() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);

        var futurue = executor.scheduleAtFixedRate(()-> System.out.println("Hello Schedule"), 2, 2,TimeUnit.SECONDS);

        System.out.println(futurue.getDelay(TimeUnit.MILLISECONDS));
//        executor.shutdown();
        executor.awaitTermination(6, TimeUnit.SECONDS);
    }
}
