package day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day1Input1Test {


    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"1abc2", 12},
                new Object[]{"pqr3stu8vwx", 38},
                new Object[]{"a1b2c3d4e5f", 15},
                new Object[]{"treb7uchet", 77},
                new Object[]{"1", 11}

        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        int actual = Day1Input1.findNumber(input);
        assertEquals(expected, actual);

    }

}