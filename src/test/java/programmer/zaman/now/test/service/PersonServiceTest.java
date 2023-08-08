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

import static org.mockito.Mockito.when;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetDataNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            personService.get("not found");
        });
    }

    @Test
    void testGetDataSuccess() {
        when(personRepository.selectById("eko")).thenReturn(new Person("eko", "Eko"));

        var result = personService.get("eko");
        Assertions.assertEquals("eko", result.getId());
        Assertions.assertEquals("Eko", result.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("eko");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("eko", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1)).
                insert(new Person(person.getId(), person.getName()));
    }
}
