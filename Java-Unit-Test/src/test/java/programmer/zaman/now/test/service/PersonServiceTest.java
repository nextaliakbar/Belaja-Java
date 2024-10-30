package programmer.zaman.now.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    public void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.getPerson("Person Not Found");
        });
    }

    @Test
    public void testGetPersonSucces() {
       // Menambahkan behavior
        Mockito.when(personRepository.selectById("Akbar")).thenReturn(new Person("Akbar", "Akbar"));
        var person = personService.getPerson("Akbar");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Akbar", person.getId());
        Assertions.assertEquals("Akbar", person.getName());
    }

    @Test
    public void testRegisterPerson() {
        var person = personService.registerPerson("Akbar");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Akbar", person.getName());
        Assertions.assertNotNull(person.getId());

        // Akan error jika function insert tidak dipanggil atau dipanggil lebih dari 1
        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Akbar"));

    }
}
