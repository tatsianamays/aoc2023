package day10;

import day1.Day1Input1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Input1Test {

    /*
    ..F7.
.FJ|.
SJ.L7
|F--J
LJ...
     */

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{new char[][]{{'.','.','.','.','.'}, {'.','S','-','7','.'}, {'.','|','.','|','.'},{'.','L','-','J','.'},{'.','.','.','.','.'}}, 1,1,4},
                new Object[]{new char[][]{{'.','.','F','7','.'}, {'.','F','J','I','.'}, {'S','J','.','L','7'},{'|','F','-','-','J'},{'L','J','.','.','.'}},2,0, 7}
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(char[][] input, int startindex1, int startIndex2, int expected) {
        int actual = Day10Input1.findNumber(startindex1,startIndex2,input);
        assertEquals(expected, actual);

    }

}