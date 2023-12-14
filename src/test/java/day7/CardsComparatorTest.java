package day7;

import day9.Day9Input1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CardsComparatorTest {



    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"AAAAA", "Five of a kind"},
                new Object[]{"AA8AA", "Four of a kind"},
                new Object[]{"23332", "Full house"},
                new Object[]{"TTT98", "Three of a kind"},
                new Object[]{"89TTT", "Three of a kind"},
                new Object[]{"23432", "Two pair"},
                new Object[]{"A23A4", "One pair"},
                new Object[]{"23A44", "One pair"},
                new Object[]{"23456", "High card"}

        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void compare(String input,String expected) {
        String actual = CardsComparator.getType(input);
        assertEquals(expected, actual);

    }

    public static Stream<Object> inputCompare() {
        return Stream.of(
                new Object[]{"32T3K", "T55J5", -1},
                new Object[]{"KK677", "KTJJT", 1},
                new Object[]{"KK677", "77JKK", 1},
                new Object[]{"KTJJT", "QQQJA", -1},
                new Object[]{"T55J5", "QQQJA", -1},
                new Object[]{"QQQJA", "QQQJA", 0}

        );
    }

    @ParameterizedTest
    @MethodSource("inputCompare")
    void compare(String input,String input2,  int expected) {
        int actual = new CardsComparator().compare(input, input2);
        assertEquals(expected, actual);

    }

}