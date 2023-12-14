package day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Input2Test {

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"1abc2", 12}

        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        int actual = Day8Input2.findNumber(input);
        assertEquals(expected, actual);

    }
}