package programmer.zaman.now2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import programmer.zaman.now.test.service.PersonService;

@Extensions({
    @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    void testNotFound(){
        assertThrows(IllegalArgumentException.class, ()->{
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess(){
        //menambah behavior ke mock objeck
        Mockito.when(personRepository.selectById("ahmad")).
            thenReturn(new Person("ahmad", "Ahmad"));
        
        var person = personService.get("ahmad");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("ahmad",person.getId());
        Assertions.assertEquals("Ahmad",person.getName());
    }

    @Test
    void testRegisterSuccess(){
        var person = personService.register("ahmad");

        assertNotNull(person);
        assertEquals("ahmad", person.getName());
        assertNotNull(person.getId());

        //diperlukan veritifikasi dibagian register dikarenakan didalamnya memanggil fungsi lain
        //kita perlu cek apakah fungsi itu ikut terpanggil atau tidak

        verify(personRepository, times(1))
            .insert(new Person(person.getId(), person.getName()));
    }
    
}
