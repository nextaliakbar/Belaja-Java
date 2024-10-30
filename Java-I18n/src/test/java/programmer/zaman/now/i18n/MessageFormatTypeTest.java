package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTypeTest {

    @Test
    void testMessageFormatType() {
        var locale = new Locale("id", "ID");
        var resourcesBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourcesBundle.getString("status");
        var messageFormat = new MessageFormat(pattern, locale);

        var format = messageFormat.format(new Object[]{"Akbar", new Date(), 10_000_000});
        System.out.println(format);
    }

    @Test
    void testMessageFormatTypeAmerica() {
        var locale = new Locale("en", "US");
        var resourcesBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourcesBundle.getString("status");
        var messageFormat = new MessageFormat(pattern, locale);

        var format = messageFormat.format(new Object[]{"Akbar", new Date(), 10_000_000});
        System.out.println(format);
    }
}
