package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    @Test
    public void testDateFormatIndonesia() {
        String pattern = "EEEE dd MMMM yyyy";
        String languange = "ID";
        String country = "id";
        Locale indonesia = new Locale(languange, country);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, indonesia);
        String date = sdf.format(new Date());
        System.out.println(date);
    }

    @Test
    public void testDateFormatJapan() {
        String pattern = "EEEE dd MMMM yyyy";
        String languange = "ja";
        String country = "JP";
        Locale japan = new Locale(languange, country);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, japan);
        String date = sdf.format(new Date());
        System.out.println(date);
    }

    @Test
    public void testDateFormatParseIndonesia() {
        String pattern = "EEEE dd MMMM yyyy";
        String languange = "ID";
        String country = "id";
        Locale indonesia = new Locale(languange, country);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, indonesia);

        try {
            Date date = sdf.parse("Sabtu 20 Juli 2024");
            System.out.println(date);
        } catch(ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testDateFormatParseJapan() {
        String pattern = "EEEE dd MMMM yyyy";
        String languange = "ja";
        String country = "JP";
        Locale japan = new Locale(languange, country);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, japan);

        try {
            Date date = sdf.parse("土曜日 20 7月 2024");
            System.out.println(date);
        } catch(ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
