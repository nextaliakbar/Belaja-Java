package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.*;

public class InstantTest {

    @Test
    void testInstant() {
        Instant instant1 = Instant.now();
        System.out.println(instant1);

        Instant instant2 = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant2);

        Instant instant3 = Instant.ofEpochMilli(0);
        System.out.println(instant3);
    }

    @Test
    void testManipulation() {
        Instant instant1 = Instant.now();
        Instant instant2 = instant1.plusMillis(1000000);
        Instant instant3 = instant1.minusMillis(1000000);

        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
    }

    @Test
    void testGet() {
        Instant instant1 = Instant.now();
        System.out.println(instant1.toEpochMilli());
        System.out.println(instant1.getEpochSecond());
        System.out.println(instant1.getNano());
    }

    @Test
    void testFromInstant() {
        Instant instant1 = Instant.now();

        ZoneId zoneId = ZoneId.of("Asia/Jakarta");

        LocalTime localTime = LocalTime.ofInstant(instant1, zoneId);
        System.out.println(localTime);

        LocalDate localDate = LocalDate.ofInstant(instant1, zoneId);
        System.out.println(localDate);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant1, zoneId);
        System.out.println(zonedDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant1, zoneId);
        System.out.println(offsetDateTime);

    }

    @Test
    void testToInstant() {
        Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(7));
        System.out.println(instant1);

        Instant instant2 = ZonedDateTime.now().toInstant();
        System.out.println(instant2);

        Instant instant3 = OffsetDateTime.now().toInstant();
        System.out.println(instant3);
    }
}
