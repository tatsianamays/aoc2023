package day3;

import day2.Day2Input1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day3Input1Test {

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{new String[]{"...........", "467..114..", "...*......"}, List.of(467)},
                new Object[]{new String[]{"...*......", "..35..633.", "......#..."}, List.of(35, 633)},
                new Object[]{new String[]{"......#...", "617*......", ".....+.58."}, List.of(617)},
                new Object[]{new String[]{"617*......", ".....+.58.", "..592....."}, List.of()},
                new Object[]{new String[]{".....+.58.", "..592.....", "......755."}, List.of(592)},
                new Object[]{new String[]{"..592.....", "......755.", "...$.*...."}, List.of(755)},
                new Object[]{new String[]{"...$.*....", ".664.598..", "..........."}, List.of(664, 598)},
                new Object[]{new String[]{"....*...", ".....277", "...806...."}, List.of(277)},
                new Object[]{new String[]{"............", "408*954.84..", "............"}, List.of(408,954)},
                new Object[]{new String[]{".........", "...515", "........."}, List.of()}

        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String[] input, List<Integer> expected) {
        List<Integer> numbers = Day3Input1.findNumber(input);
        assertEquals(expected, numbers);

    }
}