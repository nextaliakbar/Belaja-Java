package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class ZoneTest {

    @Test
    void testCreateZoneId() {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        ZoneId zoneIdGMT = ZoneId.of("GMT");
        System.out.println(zoneIdGMT);

        Set<String> avaibleZoneIDs =  ZoneId.getAvailableZoneIds();
        avaibleZoneIDs.forEach(value -> System.out.println(value));
    }

    @Test
    void testCreateZoneOffset() {
        ZoneOffset zoneOffset1 = ZoneOffset.UTC;
        ZoneOffset zoneOffset2 = ZoneOffset.of("+07:00");
        ZoneOffset zoneOffset3 = ZoneOffset.ofHours(7);
        ZoneOffset zoneOffset4 = ZoneOffset.ofHoursMinutes(7,30);

        System.out.println(zoneOffset1);
        System.out.println(zoneOffset2);
        System.out.println(zoneOffset3);
        System.out.println(zoneOffset4);
    }
}
