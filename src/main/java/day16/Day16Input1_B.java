package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day16Input1_B {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day16/input.txt"));
//                Scanner scanner = new Scanner(new File("day16/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        int sum = 0;
        char[][] grid   = new char[110][110];
        int i = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            grid[i++] = line.toCharArray();

        }
        boolean[][] visited =        findNumber(grid);
//        printArray(visited);
        for (int j = 0; j < visited.length; j++) {
            for (int k = 0; k < visited[0].length; k++) {
                if(visited[j][k]) {
                    sum++;
                }
            }
        }
        System.out.println("sum " + sum);

    }

    public static boolean[][] findNumber(char[][] grid) {

        int currentX = 0;
        int currentY = 0;
        int nextXmove = 0;
        int nextYmove = 1;

        Queue<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{currentX, currentY, nextXmove, nextYmove});
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Map<Coordinates, List<Coordinates>> directions = new HashMap<>();

        visited[currentX][currentY] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); //current longest step
//            printArray(visited);
            currentX = cur[0];
            currentY =  cur[1];
            nextXmove =  cur[2];
            nextYmove =  cur[3] ;

            int x = currentX + nextXmove;
            int y = currentY + nextYmove;

            System.out.println("cur " + cur[0] + " " + cur[1] + "  " + cur[2] + "  " + cur[3]);
            System.out.println("x " + x + " y " + y);
            boolean hasTraveled = false;
            List<Coordinates> listOfExistingDirecitons = directions.get(new Coordinates(x, y));
            if(listOfExistingDirecitons != null) {
                for(Coordinates coordinates : listOfExistingDirecitons) {
                    if(coordinates.getX() == nextXmove && coordinates.getY() == nextYmove) {
                        hasTraveled = true;
                        break;
                    }
                }
            }else{
                listOfExistingDirecitons = new ArrayList<>();
                listOfExistingDirecitons.add(new Coordinates(nextXmove, nextYmove));
                directions.put(new Coordinates(x, y), listOfExistingDirecitons);
            }
            //Check the bounderies
            if (y < 0 || y == m || x < 0 || x == n  || hasTraveled) continue;
            visited[y][x] = true;
            char sign = grid[y][x];
             /*
        0 ----------x
        |
        |
        |
        |y

        If x changes  and sign is "|" then we split and we increase and decrease  y direction
        If y changes  and sign is "-" then we split and we increase and decrease  x direction
        If x increases   and sign is "\" then we increase  y direction
        If x decreases   and sign is "\" then we decrease  y direction
        If x increases   and sign is "/" then we decrease  y direction
        If x decreases   and sign is "/" then we increase  y direction
        If y increases   and sign is "\" then we increase  x direction
        If y decreases   and sign is "\" then we decrease  x direction
        If y increases   and sign is "/" then we decrease  x direction
        If y decreases   and sign is "/" then we increase  x direction

       */
            if(sign == '|' && nextXmove != 0) {
                //Check if travvled in this direciton
                for(int i = 0; i < 4; i++) {

                }
                //Split
                pq.add(new int[]{x, y, 0, 1});
                pq.add(new int[]{x, y, 0, -1});
            }else if(sign == '-' && nextYmove != 0) {
                //Split
                pq.add(new int[]{x, y, 1, 0});
                pq.add(new int[]{x, y, -1, 0});
            }else if(sign == '\\' && nextXmove > 0) {
                pq.add(new int[]{x, y, 0, 1});
            }else if(sign == '\\' && nextXmove < 0) {
                pq.add(new int[]{x, y, 0, -1});
            }else if(sign == '/' && nextXmove > 0) {
                pq.add(new int[]{x, y, 0, -1});
            }else if(sign == '/' && nextXmove < 0) {
                pq.add(new int[]{x, y, 0, 1});
            }else if(sign == '\\' && nextYmove > 0) {
                pq.add(new int[]{x, y, 1, 0});
            }else if(sign == '\\' && nextYmove < 0) {
                pq.add(new int[]{x, y, -1, 0});
            }else if(sign == '/' && nextYmove > 0) {
                pq.add(new int[]{x, y, -1, 0});
            }else if(sign == '/' && nextYmove < 0) {
                pq.add(new int[]{x, y, 1, 0});
            }else {
                pq.add(new int[]{x, y, nextXmove, nextYmove});
            }


        }
        return visited;
    }

    private static void printArray(boolean[][] existingRoute) {
        for (boolean[] row : existingRoute) {
            for (boolean cell : row) {
                if (cell)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.print("\n");
        }

    }
}

