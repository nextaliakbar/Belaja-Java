package programmer.zaman.now.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectMapperTest {

    @Test
    void testCreateObjecMrapper() {
        ObjectMapper mapper = new ObjectMapper();

        Assertions.assertNotNull(mapper);
    }
}
