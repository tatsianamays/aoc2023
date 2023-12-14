package day14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Input2Test {

/*



 */

    public static Stream<Object> input() {
        return Stream.of(
                new Object[]{new char[][]{{'#','.','.','.','.','#','#','#','.','.'}, {'#','O','O','.','.','#','.','.','.','.'}}, new char[][]{{'#','O','O','.','.','#','#','#','.','.'}, {'#','.','.','.','.','#','.','.','.','.'}} },
                new Object[]{new char[][]{{'.','.','.','.','.','.','.','O','.','.'},{'#','.','.','.','.','#','#','#','.','.'}, {'#','O','O','.','.','#','.','.','.','.'}},
                new char[][]{{'.','O','O','.','.','.','.','O','.','.'},{'#','.','.','.','.','#','#','#','.','.'}, {'#','.','.','.','.','#','.','.','.','.'}} },
                new Object[]{new char[][]{
                        {'O','.','.','.','.','#','.','.','.','.'},
                        {'O','.','O','O','#','.','.','.','.','#'},
                        {'.','.','.','.','.','#','#','.','.','.'},
                        {'O','O','.','#','O','.','.','.','.','O'},
                        {'.','O','.','.','.','.','.','O','#','.'},
                        {'O','.','#','.','.','O','.','#','.','#'},
                        {'.','.','O','.','.','#','O','.','.','O'},
                        {'.','.','.','.','.','.','.','O','.','.'},
                        {'#','.','.','.','.','#','#','#','.','.'},
                        {'#','O','O','.','.','#','.','.','.','.'}},
               new char[][]{
                       {'O','O','O','O','.','#','.','O','.','.'},
                       {'O','O','.','.','#','.','.','.','.','#'},
                       {'O','O','.','.','O','#','#','.','.','O'},
                       {'O','.','.','#','.','O','O','.','.','.'},
                       {'.','.','.','.','.','.','.','.','#','.'},
                       {'.','.','#','.','.','.','.','#','.','#'},
                       {'.','.','O','.','.','#','.','O','.','O'},
                       {'.','.','O','.','.','.','.','.','.','.'},
                       {'#','.','.','.','.','#','#','#','.','.'},
                       {'#','.','.','.','.','#','.','.','.','.'}}}



        );
    }
    @ParameterizedTest
    @MethodSource("input")
    void moveRocksOneRow(char[][] input,char[][] expected) {
        char[][] actual = Day14Input2.moveRocksOnceNorth(input).getInput();
        assertArrayEquals(expected, actual);

    }


    public static Stream<Object> input2() {
        return Stream.of(
                new Object[]{new char[][]{
                        {'O','.','.','.','.','#','.','.','.','.'},
                        {'O','.','O','O','#','.','.','.','.','#'},
                        {'.','.','.','.','.','#','#','.','.','.'},
                        {'O','O','.','#','O','.','.','.','.','O'},
                        {'.','O','.','.','.','.','.','O','#','.'},
                        {'O','.','#','.','.','O','.','#','.','#'},
                        {'.','.','O','.','.','#','O','.','.','O'},
                        {'.','.','.','.','.','.','.','O','.','.'},
                        {'#','.','.','.','.','#','#','#','.','.'},
                        {'#','O','O','.','.','#','.','.','.','.'}},
                        new char[][]{
                                {'.','.','.','.','.','#','.','.','.','.'},
                                {'.','.','.','.','#','.','.','.','O','#'},
                                {'.','.','.','O','O','#','#','.','.','.'},
                                {'.','O','O','#','.','.','.','.','.','.'},
                                {'.','.','.','.','.','O','O','O','#','.'},
                                {'.','O','#','.','.','.','O','#','.','#'},
                                {'.','.','.','.','O','#','.','.','.','.'},
                                {'.','.','.','.','.','.','O','O','O','O'},
                                {'#','.','.','.','O','#','#','#','.','.'},
                                {'#','.','.','O','O','#','.','.','.','.'}}},
                new Object[]{new char[][]{
                        {'.','.','.','.','.','#','.','.','.','.'},
                        {'.','.','.','.','#','.','.','.','O','#'},
                        {'.','.','.','O','O','#','#','.','.','.'},
                        {'.','O','O','#','.','.','.','.','.','.'},
                        {'.','.','.','.','.','O','O','O','#','.'},
                        {'.','O','#','.','.','.','O','#','.','#'},
                        {'.','.','.','.','O','#','.','.','.','.'},
                        {'.','.','.','.','.','.','O','O','O','O'},
                        {'#','.','.','.','O','#','#','#','.','.'},
                        {'#','.','.','O','O','#','.','.','.','.'}},
                        new char[][]{
                                {'.','.','.','.','.','#','.','.','.','.'},
                                {'.','.','.','.','#','.','.','.','O','#'},
                                {'.','.','.','O','O','#','#','.','.','.'},
                                {'.','O','O','#','.','.','.','.','.','.'},
                                {'.','.','.','.','.','O','O','O','#','.'},
                                {'.','O','#','.','.','.','O','#','.','#'},
                                {'.','.','.','.','O','#','.','.','.','.'},
                                {'.','.','.','.','.','.','O','O','O','O'},
                                {'#','.','.','.','O','#','#','#','.','.'},
                                {'#','.','.','O','O','#','.','.','.','.'}}
                }



        );
    }
 /*

    Input
    .......O..
    #....###..
    #OO..#....

    Output
    .00....O..
    #....###..
    #....#....

     */

    @ParameterizedTest
    @MethodSource("input2")
    void iterateOverMultiples(char[][] input,char[][] expected) {
        char[][] actual = Day14Input2.iterateOverMultiples(input);
        assertArrayEquals(expected, actual);

    }

    /*
{'.','.','.','.','.','#','.','.','.','.'},
{'.','.','.','.','#','.','.','.','O','#'},
{'.','.','.','O','O','#','#','.','.','.'},
{'.','O','O','#','.','.','.','.','.','.'},
{'.','.','.','.','.','O','O','O','#','.'},
{'.','O','#','.','.','.','O','#','.','#'},
{'.','.','.','.','O','#','.','.','.','.'},
{'.','.','.','.','.','.','O','O','O','O'},
{'#','.','.','.','O','#','#','#','.','.'},
{'#','.','.','O','O','#','.','.','.','.'},
     */
    public static Stream<Object> input3() {
        return Stream.of(
                new Object[]{new char[][]{
                                {'O','O','O','O','.','#','.','O','.','.'},
                                {'O','O','.','.','#','.','.','.','.','#'},
                                {'O','O','.','.','O','#','#','.','.','O'},
                                {'O','.','.','#','.','O','O','.','.','.'},
                                {'.','.','.','.','.','.','.','.','#','.'},
                                {'.','.','#','.','.','.','.','#','.','#'},
                                {'.','.','O','.','.','#','.','O','.','O'},
                                {'.','.','O','.','.','.','.','.','.','.'},
                                {'#','.','.','.','.','#','#','#','.','.'},
                                {'#','.','.','.','.','#','.','.','.','.'}}, 136},
                new Object[]{ new char[][]{{'#','O','O','.','.','#','#','#','.','.'}, {'#','.','.','.','.','#','.','.','.','.'}}, 4 }



        );
    }
    @ParameterizedTest
    @MethodSource("input3")
    void findNumber(char[][] input,long expected) {
        long actual = Day14Input2.findNumber(input);
        assertEquals(expected, actual);

    }


}