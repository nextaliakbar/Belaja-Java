package programmer.zaman.now.reselience4j;

import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

@Slf4j
public class MetricTest {

    private String hello() {
        throw new IllegalArgumentException("Ups Error");
    }

    @Test
    void testRetry() {
        Retry retry = Retry.ofDefaults("pzn");

        try {
            Supplier<String> supplier = Retry.decorateSupplier(retry, () -> hello());
            System.out.println(supplier.get());
        } catch(Exception ex) {
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt());
        }
    }
}
