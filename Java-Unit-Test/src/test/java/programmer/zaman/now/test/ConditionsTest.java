package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionsTest {

    @Test
    public void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {
        System.out.println("Only on windows");
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableRunOnWindows() {
        System.out.println("Disable run on windows");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_20)
    public void testEnableOnJava20() {
        System.out.println("Enable on Java 20");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_20)
    public void testDisableOnJava20() {
        System.out.println("Disable run on Java 20");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_18, max = JRE.JAVA_20)
    public void testEnableForJreRange() {
        System.out.println("Enable run on form java 18 to java 20");
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_18, max = JRE.JAVA_20)
    public void testDisableForJreRange() {
        System.out.println("Disable run form java 18 to java 20");
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testEnableOnJavaVendorOracle() {
        System.out.println("Enable on Java vendor");
    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testDisableOnJavaVendorOracle() {
        System.out.println("Disable run on Java vendor");
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnDevProfile() {
        System.out.println("Enabled run on dev profile");
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisableOnDevProfile() {
        System.out.println("Disable run on dev profile");
    }
}
