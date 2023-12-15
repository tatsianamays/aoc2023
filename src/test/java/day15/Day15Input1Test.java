package day15;

import day1.Day1Input1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day15Input1Test {
    /*
    rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
     */
    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{"HASH", 52},
                new Object[]{"rn=1", 30},
                new Object[]{"cm-", 253},
                new Object[]{"qp=3", 97},
                new Object[]{"cm=2", 47},
                new Object[]{"qp-", 14},
                new Object[]{"pc=4", 180},
                new Object[]{"ot=9", 9},
                new Object[]{"rn", 0},
                new Object[]{"cm", 0},
                new Object[]{"qp", 1},
                new Object[]{"pc", 3}

        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String input, long expected) {
        long actual = Day15Input1.findNumber(input);
        assertEquals(expected, actual);

    }

}