package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day14Input2 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day14/input2.txt"));
//                Scanner scanner = new Scanner(new File("day14/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        List<String> input = new ArrayList<>();

        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            input.add(line);
        }

        char[][] charArray = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            charArray[i] = input.get(i).toCharArray();
        }
        long iterations = 1000000000;
        char[][] result = new char[input.size()][input.get(0).length()];
        while(iterations > 0){
            result = iterateOverMultiples(charArray);
            iterations--;
        }
        System.out.println(        findNumber(result));


    }

    public static long findNumber(char[][] input) {
        long total = 0;
        int rowCount = input.length;
        for (int i = 0; i < input.length; i++) {
            char[] row = input[i];
            for (int j = 0; j < row.length; j++) {
                char current = row[j];
//                System.out.println(current + " "+i+ " " + j);
                if (current == 'O') {
                    total = total + rowCount;
//                    System.out.println("total = " + total + " rowCount = " + rowCount);
                }

            }
            rowCount--;
        }
        return total;
    }

    public static char[][] iterateOverMultiples(char[][] input) {
        while (true) {
            HolderOfResult holderOfResult = moveRocksOnceNorth(input);
            if (!holderOfResult.isHadMoves()) {
                break;
            }
        }
        while (true) {
            HolderOfResult holderOfResult = moveRocksOnceWest(input);
            if (!holderOfResult.isHadMoves()) {
                break;
            }
        }

        while (true) {
            HolderOfResult holderOfResult = moveRocksOnceSouth(input);
            if (!holderOfResult.isHadMoves()) {
                break;
            }
        }
        while (true) {
            HolderOfResult holderOfResult = moveRocksOnceEast(input);
            if (!holderOfResult.isHadMoves()) {
                break;
            }
        }
        return input;
    }

    public static HolderOfResult moveRocksOnceNorth(char[][] input) {
        boolean hadMoves = false;
        for (int i = input.length - 1; i >= 0; i--) {
            char[] row = input[i];
            for (int j = 0; j < row.length; j++) {
                char current = row[j];
                //Move 0 to the top
                if (current == 'O' && i - 1 >= 0 && input[i - 1][j] == '.') {
                    input[i - 1][j] = 'O';
                    input[i][j] = '.';
                    hadMoves = true;
                }
            }
//            System.out.println(Arrays.toString(row));
        }
        return HolderOfResult.builder().input(input).hadMoves(hadMoves).build();
    }

    public static HolderOfResult moveRocksOnceWest(char[][] input) {
        boolean hadMoves = false;
        int width = input[0].length;
        for (int j = width-1; j >=0; j--) {
            for (int i = 0; i < input.length; i++) {
                char current = input[i][j];
                //Move 0 to the east
                if (current == 'O' && j-1>=0 && input[i ][j-1] == '.') {
                    input[i ][j-1] = 'O';
                    input[i][j] = '.';
                    hadMoves = true;
                }
            }
        }
        return HolderOfResult.builder().input(input).hadMoves(hadMoves).build();
    }
    public static HolderOfResult moveRocksOnceEast(char[][] input) {
        boolean hadMoves = false;
        int width = input[0].length;
            for (int j = 0; j < width; j++) {
                for (int i = 0; i < input.length; i++) {
                    char current = input[i][j];
                //Move 0 to the east
                if (current == 'O' && j+1< width && input[i ][j+1] == '.') {
                    input[i ][j+1] = 'O';
                    input[i][j] = '.';
                    hadMoves = true;
                }
            }
        }
        return HolderOfResult.builder().input(input).hadMoves(hadMoves).build();
    }
    public static HolderOfResult moveRocksOnceSouth(char[][] input) {
        boolean hadMoves = false;
        for (int i = 0; i < input.length; i++) {
            char[] row = input[i];
            for (int j = 0; j < row.length; j++) {
                char current = row[j];
                //Move 0 to the top
                if (current == 'O' && i + 1< input.length && input[i + 1][j] == '.') {
                    input[i + 1][j] = 'O';
                    input[i][j] = '.';
                    hadMoves = true;
                }
            }
//            System.out.println(Arrays.toString(row));
        }
        return HolderOfResult.builder().input(input).hadMoves(hadMoves).build();
    }
}
