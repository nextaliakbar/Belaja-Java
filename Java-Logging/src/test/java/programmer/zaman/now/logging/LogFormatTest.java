package programmer.zaman.now.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFormatTest {

    private static final Logger log = LoggerFactory.getLogger(LogFormatTest.class);

    @Test
    void testLogFormat() {
        log.info("With out paramater");
        log.info("{} + {} = {}", 10,10,(10+10));
        log.error("Ups", new NullPointerException());
    }
}
