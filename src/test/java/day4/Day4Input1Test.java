package day4;

import day1.Day1Input1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Input1Test {


    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", 8},
                new Object[]{"Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", 2},
                new Object[]{"Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1", 2},
                new Object[]{"Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83", 1},
                new Object[]{"Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",0},
                new Object[]{"Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11", 0}
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, int expected) {
        BigDecimal actual = Day4Input1.findNumber(input);
        assertEquals(BigDecimal.valueOf(expected), actual);

    }

}