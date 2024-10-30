package programmer.zaman.now.reselience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CircuitBreakerTest {

    void callMe() {
        log.info("Call me");
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void testCircuitBreaker() {
        // Default error adalah 100 rate eksekusi, jika error lebih dari 50% maka circuit breaker akan menjadi state OPEN dan semua request akan ditolak
        CircuitBreaker breaker = CircuitBreaker.ofDefaults("psz");

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(breaker, () -> callMe());
                runnable.run();
            } catch(Exception exception) {
                log.error("Error {}", exception.getMessage());
            }
        }
    }

    @Test
    void testCircuitBreakerConfig() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();


        CircuitBreaker breaker = CircuitBreaker.of("psz", config);

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(breaker, () -> callMe());
                runnable.run();
            } catch(Exception exception) {
                log.error("Error {}", exception.getMessage());
            }
        }
    }

    @Test
    void testCircuitBreakeRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        CircuitBreaker breaker = registry.circuitBreaker("pzn","config");

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(breaker, () -> callMe());
                runnable.run();
            } catch(Exception exception) {
                log.error("Error {}", exception.getMessage());
            }
        }
    }

}
