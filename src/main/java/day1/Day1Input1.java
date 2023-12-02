package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Input1 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day1/input2.txt"));
        //        Scanner scanner = new Scanner(new File("day1/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));


        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            sum = sum + findNumber(line);
            System.out.println(sum);
        }
    }

    public static int findNumber(String input) {
        int result = 0;
        int firstDigit = 0;
        int lastDigit = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                if (firstDigit == 0) {
                    firstDigit = Character.getNumericValue(currentChar);
                }
                lastDigit = Character.getNumericValue(currentChar);
                result = firstDigit * 10 + lastDigit;
            }
        }
        System.out.println(input + " " + firstDigit + " " + lastDigit + " " + result);

        return result;
    }
}

