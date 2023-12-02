package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Day1Input2 {

    static Map<String, Integer> digits = Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day1/input2.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        long sum = 0;
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
            } else if (Character.isAlphabetic(currentChar)) {
                String currentString = Character.toString(currentChar);
                for (int k = i + 1, j = 0; k < input.length() && j < 5; k++, j++) {
                    if (Character.isAlphabetic(currentChar)) {
                        System.out.println("currentString: " + currentString);
                        currentString = currentString + input.charAt(k);
                        if (digits.containsKey(currentString)) {
                            if (firstDigit == 0) {
                                firstDigit = digits.get(currentString);
                            }
                            lastDigit = digits.get(currentString);
                            result = firstDigit * 10 + lastDigit;
//                            i++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(input + " " + firstDigit + " " + lastDigit + " " + result);

        return result;
    }
}