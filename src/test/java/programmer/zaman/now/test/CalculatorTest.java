package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.test.generator.SimpleDisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayName.class)
//@DisplayName("Test untuk class Calculator")
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }
    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }


//    @DisplayName("fungsi untuk testAdd di CalculatorTest")
    @Test
    public void testAddSuccess(){
       var result =  calculator.add(10, 10);
       assertEquals(20, result);
    }
    @Test
    public void testDivideSuccess(){
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }
    @Test
    public void testDivideThrowException(){
        assertThrows(IllegalArgumentException.class, ()->{
            var result = calculator.divide(100, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon(){

    }

    //untuk membatalkan unit test ketika berjalan dapat menggunakan TestAbortedException();
    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if(!"DEV".equals(profile)){
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }
    }

    @Test
    public void assumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
