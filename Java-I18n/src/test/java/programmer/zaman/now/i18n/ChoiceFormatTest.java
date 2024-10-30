package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatTest {

    @Test
    void testChoiceFormat() {
        String pattern = "-1#negatif | 0#kosong | 1#satu | 1<banyak"; // key#value atau key<value
        ChoiceFormat choiceFormat = new ChoiceFormat(pattern);

        System.out.println(choiceFormat.format(-2));
        System.out.println(choiceFormat.format(-1));
        System.out.println(choiceFormat.format(0));
        System.out.println(choiceFormat.format(1));
        System.out.println(choiceFormat.format(2));
        System.out.println(choiceFormat.format(3));

    }

    @Test
    void testChoiceFormatInMessageFormat() {
        var locale = new Locale("id", "ID");
        var resourcesBundle = ResourceBundle.getBundle("message", locale);
        var pattern = resourcesBundle.getString("balance");

        var messageFormat = new MessageFormat(pattern, locale);
        System.out.println(messageFormat.format(new Object[]{-1_000_000}));
        System.out.println(messageFormat.format(new Object[]{0}));
        System.out.println(messageFormat.format(new Object[]{1_000_000}));

    }

    @Test
    void testChoiceFormatInMessageFormatAmerica() {
        var locale = new Locale("en", "US");
        var resourcesBundle = ResourceBundle.getBundle("message", locale);
        var pattern = resourcesBundle.getString("balance");

        var messageFormat = new MessageFormat(pattern, locale);
        System.out.println(messageFormat.format(new Object[]{-1_000_000}));
        System.out.println(messageFormat.format(new Object[]{0}));
        System.out.println(messageFormat.format(new Object[]{1_000_000}));

    }
}
