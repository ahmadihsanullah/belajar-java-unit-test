package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends  AbstractCalculatorTest {

    @Test
    void randomCalculator(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var expected = a + b;
        var result = calculator.add(a, b);

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Random Calculator Test")
    @RepeatedTest(
            value=10,
            name= "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void randomCalculatorRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var expected = a + b;
        var result = calculator.add(a, b);

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Random Calculator Test")
    @RepeatedTest(value=10, name="{displayName}")
    void randomCalculatorRepeatWithInfo(Random random, TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var expected = a + b;
        var result = calculator.add(a, b);

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Calculator Test")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = {1,2,3,4,5,6})
    void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(result, expected);
    }


    public static List<Integer> valueSource(){
        return List.of(1,2,4,5,66,34,32);
    }



    @DisplayName("Calculator Test")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @MethodSource({"valueSource"})
    void testWithMethodParam(Integer value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(result, expected);
    }
}
