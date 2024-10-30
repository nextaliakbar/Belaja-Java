package programmer.zaman.now.servlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }
}
