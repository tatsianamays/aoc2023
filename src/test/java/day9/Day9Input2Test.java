package day9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day9Input2Test {
    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"0 3 6 9 12 15", -3},
                new Object[]{"1 3 6 10 15 21", 0},
                new Object[]{"10 13 16 21 30 45", 5}
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        long actual = Day9Input2.findNumber(input);
        assertEquals(expected, actual);

    }

}