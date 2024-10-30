package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationTest {

    @Test
    void testCreate() {
        Duration duration1 = Duration.ofHours(10);
        Duration duration2 = Duration.ofMinutes(10);
        Duration duration3 = Duration.ofSeconds(10);
        Duration duration4 = Duration.ofMillis(10);

        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
        System.out.println(duration4);

    }

    @Test
    void testGet() {
        Duration duration = Duration.ofHours(24);

        System.out.println(duration.toDays());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }

    @Test
    void testBetween() {
        Duration duration1 = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        System.out.println(duration1);
        System.out.println(duration1.toHours());
        System.out.println(duration1.toMinutes());

        Duration duration2 = Duration.between(LocalDateTime.now().plusHours(10), LocalDateTime.now());
        System.out.println(duration2);
        System.out.println(duration2.toHours());
        System.out.println(duration2.toMinutes());
    }
}
