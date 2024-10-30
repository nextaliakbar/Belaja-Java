package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ZoneDateTimeTest {

    @Test
    void testCreate() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime4 = ZonedDateTime.now(ZoneOffset.ofHours(7));

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
        System.out.println(zonedDateTime4);
    }

    @Test
    void testParsing() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("1980-10-10T10:10+05:00[Asia/Jakarta]"); // Zone Offset diignore
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("1980-10-10T10:10+05:00");

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
    }

    @Test
    void testChangeZoneId() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameLocal(ZoneId.of("GMT")); // Merubah time zone nya saja
        System.out.println(zonedDateTime2);

        ZonedDateTime zonedDateTime3 = zonedDateTime1.withZoneSameInstant(ZoneId.of("GMT")); // Merubah time zone beserta waktu
        System.out.println(zonedDateTime3);
    }
}
