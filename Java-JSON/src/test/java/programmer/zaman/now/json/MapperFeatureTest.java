package programmer.zaman.now.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapperFeatureTest {

    @Test
    void testMapperFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                    {
                        "ID":"1",
                        "Name":"Akbar"
                    }
                """;
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person.getId());
        System.out.println(person.getName());
    }

    @Test
    void testDezerealitationFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String json = """
                    {
                        "ID":"1",
                        "Name":"Akbar",
                        "age":21,
                        "hobbies": ["hobbie 1","hobbie 2"]
                    }
                """;
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getHobbies());
    }

    @Test
    void testSerealizationFeature() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Akbar");
        person.setHobbies(List.of(
                "Hobbies 1",
                "Hobbies 2",
                "Hobbies 3",
                "Hobbies 4"
        ));

        Addres addres = new Addres();
        addres.setStreet("Bangsalsari");
        addres.setCity("Jember");
        addres.setCountry("Indonesia");
        person.setAddres(addres);

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void testSerealizationInclusion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Akbar");

        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
}
