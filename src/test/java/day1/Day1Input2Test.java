package day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day1Input2Test {

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"two1nine", 29},
                new Object[]{"eightwothree", 83},
                new Object[]{"abcone2threexyz", 13},
                new Object[]{"xtwone3four", 24},
                new Object[]{"4nineeightseven2", 42},
                new Object[]{"zoneight234", 14},
                new Object[]{"7pqrstsixteen", 76},
                new Object[]{"pcg91vqrfpxxzzzoneightzt", 98},
                new Object[]{"1", 11},
                 new Object[]{"one", 11}



        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        int actual = Day1Input2.findNumber(input);
        assertEquals(expected, actual);

    }
}