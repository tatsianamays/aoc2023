package day9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day9Input1Test {
    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"0 3 6 9 12 15", 18},
                new Object[]{"1 3 6 10 15 21", 28},
                new Object[]{"10 13 16 21 30 45", 68}
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        long actual = Day9Input1.findNumber(input);
        assertEquals(expected, actual);

    }

}