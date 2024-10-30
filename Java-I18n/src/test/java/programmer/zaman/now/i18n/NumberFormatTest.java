package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    @Test
    public void testNumberFormat() {
        var indonesia = new Locale("id", "ID");
        var numberFormat = NumberFormat.getInstance(indonesia);
        String format = numberFormat.format(10_000_000.255);
        System.out.println(format);
    }

    @Test
    public void testParseNumberFormat() {
        var indonesia = new Locale("id", "ID");
        var numberFormat = NumberFormat.getInstance(indonesia);
        try {
            var result = numberFormat.parse("10.000.000,255").doubleValue();
            System.out.println(result);
        } catch(ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
