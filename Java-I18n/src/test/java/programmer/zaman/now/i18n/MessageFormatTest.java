package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTest {

    @Test
    void testMessageFormat() {
        var pattern = "Hai {0} anda bisa mencari data anda dengan mengetikkan \"{0}\" di pencarian";
        var messageFormat = new MessageFormat(pattern);

        //messageFormat.applyPattern(""); //Merubah pattern

        var format = messageFormat.format(new Object[]{"Akbar"});
        System.out.println(format);
    }

    @Test
    void testMessageFormatResoucesBundle() {
        var local = new Locale("id", "ID");
        var resourcesBundle = ResourceBundle.getBundle("message", local);

        var pattern = resourcesBundle.getString("welcome.message");
        var messageFormat = new MessageFormat(pattern);

        var format = messageFormat.format(new Object[]{"Akbar", "Programmer Zaman Now"});
        System.out.println(format);

    }
}
