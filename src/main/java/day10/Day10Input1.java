package day10;

import day7.CardsComparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Day10Input1 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day10/input.txt"));
//                Scanner scanner = new Scanner(new File("day10/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        long sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
        }


        System.out.println(sum);


    }

    /*
     x,x,x,x,x
	y0,1,3,2
	y5,1,2,5
	y4,3,8,6
     */

    public static int findNumber(int startIndex1, int startIndex2, char[][] grid) {
        printArray(grid);
        int m = grid.length, n = grid[0].length;
        List<Direction> directionList = new ArrayList<>();
        directionList.add(new Direction("East", 1, 0));
        directionList.add(new Direction("West", -1, 0));
        directionList.add(new Direction("South", 0, 1));
        directionList.add(new Direction("North", 0, -1));


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0], Comparator.reverseOrder()));
        pq.add(new int[]{0, startIndex1, startIndex2});//int[step, y, x]
        boolean[][] visited = new boolean[m][n];
        char[][] existingRoute = new char[m][n];
        visited[startIndex1][startIndex2] = true;
        existingRoute[startIndex1][startIndex2] = 'S';
        int step = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll(); //current longest step
            System.out.println("cur " + cur[0] +" "  + cur[1] + "  " + cur[2]);
            printArray(existingRoute);
            for(Direction direction : directionList){
                int y = cur[1] + direction.getY();
                int x = cur[2] + direction.getX();
                //Check the bounderies and if the cell is not visited
                if(y < 0 || y == m || x < 0 || x == n || (visited[y][x])) continue;
                visited[y][x] = true;
                step = cur[0] + 1;
                //Check if its possible to move to the cell
                String direction1 = direction.getDirection();
                System.out.println( direction1 + "  " + grid[y][x] + " step: " + step);
                if(isAllowedMove(direction1, grid[cur[1]][cur[2]], grid[y][x])) {
                    System.out.println( direction1 + " allowed step: " + step + " y " + y + " x " + x);
                    //If we reached back to start
                    if(grid[y][x]=='S') return step;
                    existingRoute[y][x] = grid[y][x];
                    pq.add(new int[]{step , y, x});
                }
            }
        }
        return step;
    }

    private static void printArray(char[][] existingRoute) {
        for(char[] row : existingRoute){
            System.out.println(Arrays.toString(row));
        }

    }

    /*
    | is a vertical pipe connecting north and south.
- is a horizontal pipe connecting east and west.
L is a 90-degree bend connecting north and east.
J is a 90-degree bend connecting north and west.
7 is a 90-degree bend connecting south and west.
F is a 90-degree bend connecting south and east.
. is ground; there is no pipe in this tile.
S is the starting position of the animal; there is a pipe on this tile, but your sketch doesn't show what shape the pipe has.
     */
    private static boolean isAllowedMove(String direction, char current, char next) {
        if(next == '.') return false;
        if(current == 'S' || next == 'S') return true;


        return false;
    }
}