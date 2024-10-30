package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends AbstrackCalculatorTest{
    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        System.out.println(result);
        var expected = a + b;
        System.out.println(expected);
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    public void testRandomRepetition(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        System.out.println(result);
        var expected = a + b;
        System.out.println(expected);
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator info")
    @RepeatedTest(
            value = 10, name = "{displayName}"
    )
    public void testRepetitionInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName()+ " ke " + repetitionInfo.getCurrentRepetition() + " ke " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        System.out.println(result);
        var expected = a + b;
        System.out.println(expected);
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test dengan paramater")
    @ParameterizedTest(name = "{displayName} dengan paramater {0}")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,97,90})
    public void testWithParamaterValueSource(int value) {
        var result = calculator.add(value, value);
        var expected = value + value;
        System.out.println(result);
        System.out.println(expected);
        Assertions.assertEquals(expected, result);
    }

    private static List<Integer> paramaterSource1() {
        return new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @DisplayName("Test dengan paramater")
    @ParameterizedTest(name = "{displayName} dengan paramater {0}")
    @MethodSource(value = {"paramaterSource1"})
    public void testWithParamaterMethodSource(int value) {
        var result = calculator.add(value, value);
        var expected = value + value;
        System.out.println(result);
        System.out.println(expected);
        Assertions.assertEquals(expected, result);
    }
}
