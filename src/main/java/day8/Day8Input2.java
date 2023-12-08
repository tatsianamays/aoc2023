package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8Input2 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day8/input2.txt"));
//                Scanner scanner = new Scanner(new File("day8/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            sum = sum + findNumber(line);
            System.out.println(sum);
        }
    }

    public static int findNumber(String input) {
       return 0;
    }
}