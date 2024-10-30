package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class JsonArrayTest {

    @Test
    void testCreateJsonArray() throws JsonProcessingException {
        List<String> hobbies = List.of("Hobbies1", "Hobbies2", "Hobbies3", "Hobbies4");

        ObjectMapper mapper = new ObjectMapper();
        String json1 = mapper.writeValueAsString(hobbies);
        System.out.println(json1);

        List<Map<String, Object>> persons = List.of(
            Map.of(
                    "firstname", "Akbar",
                    "lastname", "Rafsanjani"
            )
        );

        String json2 = mapper.writeValueAsString(persons);
        System.out.println(json2);
    }

    @Test
    void testReadJsonArray() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = """
                ["Hobbies1","Hobbies2","Hobbies3","Hobbies4"]
                """;
        List<String> hobbies = mapper.readValue(json, new TypeReference<List<String>>() {
        });

        System.out.println(hobbies);
    }
}
