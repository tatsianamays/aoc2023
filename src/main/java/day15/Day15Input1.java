package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Day15Input1 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day15/input.txt"));
//        Scanner scanner = new Scanner(new File("day15/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        long sum = 0;
            String line = scanner.next();

        String[] input = line.split(",");
        for(String s : input) {
           sum =  sum + findNumber(s);
        }
        System.out.println(sum);

    }

    /*

    Determine the ASCII code for the current character of the string.
Increase the current value by the ASCII code you just determined.
Set the current value to itself multiplied by 17.
Set the current value to the remainder of dividing itself by 256.
     */
    public static long findNumber(String input) {
        int result = 0;
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            result = result + ascii;
            result = result * 17;
            result = result % 256;
        }
        return result;

    }
}

