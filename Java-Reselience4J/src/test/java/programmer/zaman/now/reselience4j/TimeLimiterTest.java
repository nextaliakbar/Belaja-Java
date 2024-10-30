package programmer.zaman.now.reselience4j;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class TimeLimiterTest {

    @SneakyThrows
    String slow() {
        log.info("slow");
        Thread.sleep(5000);
        return "slow";
    }

    @Test
    void testTimeLimiter() throws Exception {

        ExecutorService executors = Executors.newSingleThreadExecutor();

        Future<String> future = executors.submit(() -> slow());

        TimeLimiter limiter = TimeLimiter.ofDefaults("pzn"); // default 1 detik

        Callable<String> callable = TimeLimiter.decorateFutureSupplier(limiter, ()->future);

        callable.call();

    }

    @Test
    void testTimeLimiterConfig() throws Exception {

        ExecutorService executors = Executors.newSingleThreadExecutor();

        Future<String> future = executors.submit(() -> slow());

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10))
                .cancelRunningFuture(true)
                .build();

        TimeLimiter limiter = TimeLimiter.of("pzn", config);

        Callable<String> callable = TimeLimiter.decorateFutureSupplier(limiter, ()->future);

        callable.call();

    }

    @Test
    void testTimeLimiterRegistry() throws Exception {

        ExecutorService executors = Executors.newSingleThreadExecutor();

        Future<String> future = executors.submit(() -> slow());

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10))
                .cancelRunningFuture(true)
                .build();

        TimeLimiterRegistry registry = TimeLimiterRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        TimeLimiter limiter = registry.timeLimiter("pzn", "config");

        Callable<String> callable = TimeLimiter.decorateFutureSupplier(limiter, ()->future);

        callable.call();

    }
}
