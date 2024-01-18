package programmer.zaman.now2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import programmer.zaman.now.test.Calculator;
import programmer.zaman.now2.test.dependecy_injection.RandomResolver;

@Extensions({
    @ExtendWith(RandomResolver.class)
})
public class AbstractCalculatorTest {
    protected Calculator calculator = new Calculator();

    @BeforeEach
    void setUp(){
        System.out.println("before each");
    }

}
