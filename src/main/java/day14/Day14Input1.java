package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day14Input1 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day14/input.txt"));
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
        char[][] result = iterateOverMultiples(charArray);
        System.out.println(        findNumber(result));


    }

    public static long findNumber(char[][] input) {
        long total = 0;
        int rowCount = input.length;
        for (int i = 0; i < input.length; i++) {
            char[] row = input[i];
            for (int j = 0; j < row.length; j++) {
                char current = row[j];
                System.out.println(current + " "+i+ " " + j);
                if (current == 'O') {
                    total = total + rowCount;
                    System.out.println("total = " + total + " rowCount = " + rowCount);
                }

            }
            rowCount--;
        }
        return total;
    }

    public static char[][] iterateOverMultiples(char[][] input) {
        while (true) {
            HolderOfResult holderOfResult = moveRocksOneRow(input);
            if (!holderOfResult.isHadMoves()) {
                break;
            }
        }
        return input;
    }

    public static HolderOfResult moveRocksOneRow(char[][] input) {
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
            System.out.println(Arrays.toString(row));
        }
        return HolderOfResult.builder().input(input).hadMoves(hadMoves).build();
    }
}
