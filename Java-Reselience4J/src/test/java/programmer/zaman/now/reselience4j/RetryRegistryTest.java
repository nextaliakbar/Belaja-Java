package programmer.zaman.now.reselience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@Slf4j
public class RetryRegistryTest {

    void callMe() {
        log.info("Try call me");
        throw new IllegalArgumentException("Ups Error");
    }

    @Test
    void testRetryRegistry() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();

        Retry retry1 = retryRegistry.retry("name");
        Retry retry2 = retryRegistry.retry("name");

        Assertions.assertSame(retry1, retry2);
    }

    @Test
    void testRetryRegistryConfig() {

        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(1))
                .build();

        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        retryRegistry.addConfiguration("config",config);

        Retry retry1 = retryRegistry.retry("pzn","config");
        Retry retry2 = retryRegistry.retry("pzn","config");

        Assertions.assertSame(retry1, retry2);

        Runnable runnable = Retry.decorateRunnable(retry1, () -> callMe());
        runnable.run();
    }

}
