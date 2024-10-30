package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayOfWeekTest {

    @Test
    void testCreate() {
        DayOfWeek dayOfWeek1 = DayOfWeek.SATURDAY;
        DayOfWeek dayOfWeek2 = dayOfWeek1.plus(7);
        DayOfWeek dayOfWeek3 = dayOfWeek1.plus(1);

        System.out.println(dayOfWeek1.getDisplayName(TextStyle.FULL, new Locale("id", "ID")));
        System.out.println(dayOfWeek2);
        System.out.println(dayOfWeek3);
    }

}
