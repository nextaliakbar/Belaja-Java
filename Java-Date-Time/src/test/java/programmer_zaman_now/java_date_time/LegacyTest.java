package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class LegacyTest {

    @Test
    void testFromLegacy() {
        Date date = new Date();
        System.out.println(date);

        Instant instant1 = date.toInstant();
        System.out.println(instant1);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Instant instant2 = calendar.toInstant();
        System.out.println(instant2);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);

        ZoneId zoneId = timeZone.toZoneId();
        System.out.println(zoneId);
    }

    @Test
    void testToLegacy() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        Date date = Date.from(zonedDateTime.toInstant());

        Calendar calendar = GregorianCalendar.from(zonedDateTime);

        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.systemDefault());

        System.out.println(date);
        System.out.println(calendar);
        System.out.println(timeZone);
    }
}
