package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    public void testCurrencyIndonesia() {
        var indonesia = new Locale("id", "ID");
        Currency currency = Currency.getInstance(indonesia);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getNumericCode());
    }

    @Test
    public void testCurrencyUSA() {
        var usa = new Locale("en", "US");
        Currency currency = Currency.getInstance(usa);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getNumericCode());
    }

    @Test
    public void testNumberFormatCurrencyIndonesia() {
        var indonesia = new Locale("id", "ID");
        var numberFormat = NumberFormat.getCurrencyInstance(indonesia);

        var format = numberFormat.format(10_000_000.281);
        System.out.println(format);
    }

    @Test
    public void testNumberFormatCurrencyParseIndonesia() {
        var indonesia = new Locale("id", "ID");
        var numberFormat = NumberFormat.getCurrencyInstance(indonesia);

        try {
            var format = numberFormat.parse("Rp900.000,25").doubleValue();
            System.out.println(format);
        } catch(ParseException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
