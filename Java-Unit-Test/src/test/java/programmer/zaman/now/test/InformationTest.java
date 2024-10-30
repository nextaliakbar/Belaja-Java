package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

@DisplayName("Information Test")
public class InformationTest {

    @Test
    @Tags({
            @Tag("Tag_One"),
            @Tag("Tag_Two"),
            @Tag("Tag_Three")
    })
    @DisplayName("This is test")
    public void test(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestClass().orElse(null));
        System.out.println(testInfo.getTestMethod().orElse(null));
    }
}
