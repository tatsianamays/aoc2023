package day2;

import day1.Day1Input1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day2Input1Test {

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", 1},
                new Object[]{"Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", 2},
                new Object[]{"Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red", 0},
                new Object[]{"Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red", 0},
                new Object[]{"Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green", 5},
                new Object[]{"Game 6: 12 red, 14 blue, 13 green; 2 blue, 1 red, 2 green", 6}
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        int actual = Day2Input1.findNumber(input);
        assertEquals(expected, actual);

    }
}