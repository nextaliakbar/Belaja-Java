package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {

    @Test
    void testCreatJsonFromObject() throws JsonProcessingException {
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

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                    {"id":"1",
                      "name":"Akbar",
                      "hobbies":[
                        "Hobbies 1",
                        "Hobbies 2",
                        "Hobbies 3",
                        "Hobbies 4"
                      ],
                      "addres":{
                        "street":"Bangsalsari",
                        "city":"Jember",
                        "country":"Indonesia"}
                    }
                """;

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person.getId());
        System.out.println(person.getName());
        for(String hobbies : person.getHobbies()) {
            System.out.println(hobbies);
        }
        System.out.println(person.getAddres().getStreet());
        System.out.println(person.getAddres().getCity());
        System.out.println(person.getAddres().getCountry());
    }
}
