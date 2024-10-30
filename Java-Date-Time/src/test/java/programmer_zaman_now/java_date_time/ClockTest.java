package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ClockTest {

    @Test
    void testCreate() {
        Clock clock1 = Clock.systemUTC();
        System.out.println(clock1);

        Clock clock2 = Clock.systemDefaultZone();
        System.out.println(clock2);

        Clock clock3 = Clock.system(ZoneId.of("Asia/Jakarta"));
        System.out.println(clock3);
    }

    @Test
    void testInstant() throws Throwable{
        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));
        Instant instant1 = clockJakarta.instant();
        System.out.println(instant1);
        Thread.sleep(1_000);

        Instant instant2 = clockJakarta.instant();
        System.out.println(instant2);
    }

    @Test
    void testFromClock() {
        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));

        Year year = Year.now(clockJakarta);
        System.out.println(year);

        YearMonth yearMonth = YearMonth.now(clockJakarta);
        System.out.println(yearMonth);

        MonthDay monthDay = MonthDay.now(clockJakarta);
        System.out.println(monthDay);

        LocalTime localTime = LocalTime.now(clockJakarta);
        System.out.println(localTime);

        LocalDate localDate = LocalDate.now(clockJakarta);
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now(clockJakarta);
        System.out.println(localDateTime);

        OffsetTime offsetTime = OffsetTime.now(clockJakarta);
        System.out.println(offsetTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now(clockJakarta);
        System.out.println(offsetDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(clockJakarta);
        System.out.println(zonedDateTime);

    }
}
