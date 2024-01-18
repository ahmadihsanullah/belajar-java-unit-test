package programmer.zaman.now2.test;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import programmer.zaman.now.test.Calculator;

public class RandomCalculatorTest extends AbstractCalculatorTest {

    @Test
    void testRandomCalculator(Random random){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        Integer expected = a+b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomCalculatorRepeated(Random random, TestInfo testInfo){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        Integer expected = a+b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomCalculatorRepeatedWithInfo(Random random, TestInfo testInfo, RepetitionInfo repetitionInfo){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        Integer expected = a+b;

        Assertions.assertEquals(expected, result);
    }


    // test parameter dengan value source
    @DisplayName("Test random calculator")
    @ParameterizedTest(
        name = "{displayName} ke  dari {0}"
    )
    @ValueSource(ints = {1,2,3,4,5,12,242,421})
    void testRandomCalculatorParameter(int value){
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    // test parameter dengan method

    static List<Integer> parameterSource(){
        return List.of(1,2,3,42,45,121);
    }
    
    @DisplayName("Test random calculator")
    @ParameterizedTest(
        name = "{displayName} ke  dari {0}"
    )
    @MethodSource({"parameterSource"})
    void testRandomCalculatorParameterMethodSource(int value){
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}
