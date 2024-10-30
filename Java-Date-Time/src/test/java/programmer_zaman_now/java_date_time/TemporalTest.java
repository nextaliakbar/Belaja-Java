package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class TemporalTest {

    @Test
    void testTemporal() {
        Temporal temporal1 = LocalDate.now();
        Temporal temporal2 = LocalTime.now();
        Temporal temporal3 = LocalDateTime.now();
        Temporal temporal4 = ZonedDateTime.now();
        Temporal temporal5 = OffsetDateTime.now();

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
        System.out.println(temporal5);
    }

    @Test
    void testTemporalAmount() {
        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
        Temporal temporal3 = temporal1.plus(Duration.ofDays(10));

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
    }

    @Test
    void testTemporalUnit() {
        long temporalUnit1 = ChronoUnit.DAYS.between(LocalDate.now(), LocalDateTime.now().plusHours(24));
        System.out.println(temporalUnit1);

    }

    @Test
    void testTemporalField() {
        LocalDateTime temporal = LocalDateTime.now();

        System.out.println(temporal.get(ChronoField.YEAR));
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND));
        System.out.println(temporal.get(ChronoField.NANO_OF_SECOND));
    }

    @Test
    void testTemporalQuery() {
        Temporal temporal1 = LocalDateTime.now();

        List<Integer> integers = temporal1.query(temporal -> {
           List<Integer> list = new ArrayList<>();
           list.add(temporal.get(ChronoField.YEAR));
           list.add(temporal.get(ChronoField.MONTH_OF_YEAR));
           list.add(temporal.get(ChronoField.DAY_OF_MONTH));
           return list;
        });

        integers.forEach(value -> System.out.println(value));

    }

    @Test
    void testTemporalAdjuster() {
        LocalDate temporal1 = LocalDate.now();
        Temporal temporal2 = temporal1.with(temporalAdujster -> {
            return LocalDate.of(temporalAdujster.get(ChronoField.YEAR),
            temporalAdujster.get(ChronoField.MONTH_OF_YEAR),
            1);
        });

        System.out.println(temporal2);

        Temporal temporal3 = temporal1.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(temporal3);

        Temporal temporal4 = temporal1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(temporal4);
    }
}
