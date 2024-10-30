package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;
import java.util.Locale;

public class LocaleTest {

    @Test
    public void testNewLocale() {
        String language = "id";
        String country = "ID";

        var locale = new Locale(language, country);

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
    }

    @Test
    public void testNewLocaleUs() {
        String language = "en";
        String country = "US";

        var locale = new Locale(language, country);

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
    }
}
