package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTest {

    @Test
    void testCreate() {
        var date1 = new Date();
        var date2 = new Date(System.currentTimeMillis());
        var date3 = new Date(339958800000L);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }
}
