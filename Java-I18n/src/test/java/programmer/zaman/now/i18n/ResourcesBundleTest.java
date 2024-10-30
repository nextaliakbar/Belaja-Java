package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourcesBundleTest {

    @Test
    public void testResourceBundle() {
        var resourcesBundle = ResourceBundle.getBundle("message");
        System.out.println(resourcesBundle.getString("hello"));
        System.out.println(resourcesBundle.getString("goodbye"));
    }

    @Test
    public void testResourceBundleIndonesia() {
        var indonesia = new Locale("id", "ID");

        var resourcesBundle = ResourceBundle.getBundle("message", indonesia);
        System.out.println(resourcesBundle.getString("hello"));
        System.out.println(resourcesBundle.getString("goodbye"));
    }

    @Test
    public void testResourceBundleNotFound() {
        var notFound = new Locale("en", "US");

        var resourcesBundle = ResourceBundle.getBundle("message", notFound);
        System.out.println(resourcesBundle.getString("hello"));
        System.out.println(resourcesBundle.getString("goodbye"));
    }

    @Test
    public void testResourceBundleMultipleTimes() {
        var notFound = new Locale("en", "US");

        var resourcesBundle1 = ResourceBundle.getBundle("message", notFound);
        var resourcesBundle2 = ResourceBundle.getBundle("message", notFound);

        System.out.println(resourcesBundle1 == resourcesBundle2);

        System.out.println(resourcesBundle1.getString("hello"));
        System.out.println(resourcesBundle1.getString("goodbye"));
    }
}
