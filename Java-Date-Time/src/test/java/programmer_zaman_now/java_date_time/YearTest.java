package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.*;

public class YearTest {

    @Test
    void testCreate() {
        Year year1 = Year.now();
        Year year2 = Year.of(1980);
        Year year3 = Year.parse("1980");

        System.out.println(year1);
        System.out.println(year2);
        System.out.println(year3);

        YearMonth yearMonth1 = YearMonth.now();
        YearMonth yearMonth2 = YearMonth.of(1980, Month.DECEMBER);
        YearMonth yearMonth3 = YearMonth.parse("1980-10");

        System.out.println(yearMonth1);
        System.out.println(yearMonth2);
        System.out.println(yearMonth3);

        MonthDay monthDay1 = MonthDay.now();
        MonthDay monthDay2 = MonthDay.of(12, 30);
        MonthDay monthDay3 = MonthDay.parse("--12-09");

        System.out.println(monthDay1);
        System.out.println(monthDay2);
        System.out.println(monthDay3);
    }

    @Test
    void testConvert() {
        Year year1 = Year.now();
        System.out.println(year1);

        YearMonth yearMonth1 = year1.atMonth(Month.DECEMBER);
        System.out.println(yearMonth1);

        LocalDate localDate1 = yearMonth1.atDay(30);
        System.out.println(localDate1);

        MonthDay monthDay1 = MonthDay.from(localDate1);
        System.out.println(monthDay1);
    }

    @Test
    void testGet() {
        Year year1 = Year.now();
        YearMonth yearMonth1 = YearMonth.now();
        MonthDay monthDay1 = MonthDay.now();

        System.out.println(year1.getValue());
        System.out.println(yearMonth1.getYear());
        System.out.println(yearMonth1.getMonthValue());
        System.out.println(monthDay1.getMonth());
        System.out.println(monthDay1.getMonthValue());
        System.out.println(monthDay1.getDayOfMonth());
    }
}
