package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest {

    @Test
    void testCreate() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(1980, 8, 10, 10, 9, 10, 456_000_000);
        LocalDateTime localDateTime3 = LocalDateTime.parse("1980-08-10T10:09:10");

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    void testWith() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.withYear(1980).withMonth(12);
        LocalDateTime localDateTime3 = localDateTime1.withYear(1980).withHour(9);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    void testManipulation() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.plusYears(5).plusHours(5);
        LocalDateTime localDateTime3 = localDateTime1.minusYears(5).plusHours(5);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    void testGet() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime1.getMonth());
        System.out.println(localDateTime1.getMonthValue());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getHour());
        System.out.println(localDateTime1.getMinute());
        System.out.println(localDateTime1.getSecond());
        System.out.println(localDateTime1.getNano());
    }

    @Test
    void testToLocaDate() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        LocalDate localDate1 = localDateTime1.toLocalDate();
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDate1.atTime(10,10,10);
        System.out.println(localDateTime2);
    }

    @Test
    void testToLocalDateTime() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        LocalTime localTime1 = localDateTime1.toLocalTime();
        System.out.println(localTime1);

        LocalDateTime localDateTime2 = localTime1.atDate(LocalDate.now());
        System.out.println(localDateTime2);
    }
}
