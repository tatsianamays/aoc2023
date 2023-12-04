package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Day4Input1 {

    static Map<String, Integer> possible = Map.of("red", 12, "green", 13, "blue", 14);

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day4/input.txt"));
//        Scanner scanner = new Scanner(new File("day4/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        BigDecimal sum = BigDecimal.ZERO;
        while (scanner.hasNext()) {
            String line = scanner.next();
            sum = sum.add(findNumber(line));
            System.out.println(sum);
        }
        System.out.println(sum);

    }

    public static BigDecimal findNumber(String input) {
        String[] game = input.split(":");
        System.out.println(input);
        String winNumebrs = input.substring(input.indexOf(":") + 1, input.indexOf("|"));
        String numbersForLooking = input.substring(input.indexOf("|") + 1, input.length());
        String[] arrayOfWinNumbers = winNumebrs.trim().split(" ");
        String[] arrayOfLookingNumbers = numbersForLooking.trim().split(" ");

        int count = 0;
        for (String winningNumber : arrayOfWinNumbers) {
            for (String myNumber : arrayOfLookingNumbers ) {
//                System.out.println("looking for  " + winningNumber+ " myNumber " + myNumber + " count " + count );
                if (!winningNumber.isEmpty() &&  winningNumber.trim().equals(myNumber.trim())) {
                    count++;
                    System.out.println("found winningNumber" + winningNumber+ " count " + count );

                }
            }
        }

        if (count < 2) {
            return BigDecimal.valueOf(count);
        }
        int powers = count - 1;

        System.out.println(" powers " + powers);
        return BigDecimal.valueOf(2).pow(powers);
    }
}

