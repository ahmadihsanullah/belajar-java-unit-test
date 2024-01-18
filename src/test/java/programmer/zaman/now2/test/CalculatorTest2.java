package programmer.zaman.now2.test;


import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import programmer.zaman.now.test.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test untuk Calculator Test 2")
public class CalculatorTest2 {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("before each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Tes untuk skenario sukses untuk kmethod add(int,int)")
    public void testAddSuccess(){
        int result = calculator.add(10,10);
        assertEquals(20, result);
    }


    @Test
    public void testDivideSuccess(){
        int result = calculator.divide(100, 10);
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

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if(!"DEV".equals(profile)){
            throw new TestAbortedException("dibatalkan karena bukan DEV");
        }
    }

    @Test
    public void testAssumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
        // jika tidak true maka akan throw TestAbortedException() 
    }
    
}
