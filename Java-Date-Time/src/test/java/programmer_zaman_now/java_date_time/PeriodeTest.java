package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodeTest {

    @Test
    void testCreate() {
        Period period1 = Period.ofDays(10);
        Period period2 = Period.ofWeeks(10);
        Period period3 = Period.ofMonths(10);
        Period period4 = Period.ofYears(10);
        Period period5 = Period.of(10,10,10);

        System.out.println(period1);
        System.out.println(period2);
        System.out.println(period3);
        System.out.println(period4);
        System.out.println(period5);
    }

    @Test
    void testGet() {
        Period period = Period.of(10,10,10);
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
        System.out.println(period.getDays());

    }

    @Test
    void testBetween() {
        Period period = Period.between(LocalDate.of(2003, 7,2),
                LocalDate.now());
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
