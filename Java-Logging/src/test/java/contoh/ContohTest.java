package contoh;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContohTest {

    private static final Logger log = LoggerFactory.getLogger(ContohTest.class);

    @Test
    void testLog() {
        log.error("Contoh Error");
        log.info("Contoh Info");
    }
}
