package day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day3Input2Test {

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{new String[]{ "467..114..", "...*......", "..35..633."}, List.of(List.of(467,35))},
                new Object[]{new String[]{"...*......", "..35..633.", "......#..."},  List.of(List.of())},
                new Object[]{new String[]{"......#...", "617*......", ".....+.58."},  List.of(List.of())},
                new Object[]{new String[]{"617*......", ".....+.58.", "..592....."},  List.of(List.of())},
                new Object[]{new String[]{".....+.58.", "..592.....", "......755."},  List.of(List.of())},
                new Object[]{new String[]{"..592.....", "......755.", "...$.*...."},  List.of(List.of())},
                new Object[]{new String[]{"......755.", "...$.*....", ".664.598.."},  List.of(List.of(755, 598))},
                new Object[]{new String[]{"......#...", "6*12....", ".....+.58."}, List.of(List.of(6,12))},
               new Object[]{new String[]{"222.......", ".....*170.", "..243....."}, List.of(List.of(243,170))},
                new Object[]{new String[]{"............", "408*954.84..", "............"}, List.of(List.of(408,954))},
                new Object[]{new String[]{".....", "...*.", "348.5"}, List.of(List.of(348,5))},
                new Object[]{new String[]{"348.5", "...*.", "....."}, List.of(List.of(348,5))},
                new Object[]{new String[]{"11...", "22*..", "....."}, List.of(List.of(11,22))}


        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void testMethod(String[] input,  List<List<Integer>>  expected) {
        List<List<Integer>> numbers = Day3Input2.findNumber(input);
        assertEquals(expected, numbers);

    }
}