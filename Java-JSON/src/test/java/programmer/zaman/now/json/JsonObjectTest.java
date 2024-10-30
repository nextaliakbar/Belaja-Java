package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JsonObjectTest {

    @Test
    void testCreateJSon() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
        "firstName", "Ali",
        "lastName", "Akbar",
        "age", 21,
        "married", false,
        "adders", Map.of(
                "distric", "bangsalsari",
                "city","Jember",
                "country", "indonesia"
        )
        );

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void testReadJson() throws JsonProcessingException {
        String json = """
                {"firstName":"Ali",
                  "lastName":"Akbar",
                  "married":false,
                  "age":21,
                  "addres":{
                    "distric":"bangsalsari",
                    "city":"Jember",
                    "country":"indonesia"}
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> person = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
        Assertions.assertEquals("Ali", person.get("firstName"));
        Assertions.assertEquals("Akbar", person.get("lastName"));
        System.out.println(person.get("firstName"));
        System.out.println(person.get("lastName"));
        System.out.println(person.get("married"));
        System.out.println(person.get("age"));
        System.out.println("================");
        System.out.println(person.get("addres"));

    }

    @Test
    void testReadJsonFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Path.of("contoh.json");
        BufferedReader reader = Files.newBufferedReader(path);
        Map<String, Object> person = mapper.readValue(reader, new TypeReference<Map<String, Object>>() {
        });

        person.forEach((key, value) -> {
            System.out.println("key: " + key + " value: " + value);
        });
    }
}
