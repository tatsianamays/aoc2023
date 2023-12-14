package day8;

import day2.Day2Input1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Input1Test {

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"1abc2", 12}

        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
//        int actual = Day8Input1.findNumber(input);
//        assertEquals(expected, actual);

    }
}