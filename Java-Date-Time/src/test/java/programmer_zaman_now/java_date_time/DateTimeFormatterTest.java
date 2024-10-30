package programmer_zaman_now.java_date_time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest {

    @Test
    void testParsing() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2024 07 21", formatter);
        System.out.println(localDate);

        String date = localDate.format(formatter);
        System.out.println(date);
    }

    @Test
    void testDefaultFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate localDate = LocalDate.parse("2024-07-21", formatter);
        System.out.println(localDate);
    }

    @Test
    void testI18N() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", new Locale("id", "ID"));
        LocalDate localDate = LocalDate.now();
        String date = localDate.format(formatter);
        System.out.println(date);
    }
}
