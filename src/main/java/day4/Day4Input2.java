package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4Input2 {


    public static void main(String[] args) throws FileNotFoundException {

//        Scanner scanner = new Scanner(new File("day4/input2.txt"));
        Scanner scanner = new Scanner(new File("day4/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));


        List<LineStats> lines = new ArrayList<>();
        int sum = 0; //first game
        while (scanner.hasNext()) {
            String line = scanner.next();
            String gameNumber = line.substring(4, line.indexOf(":"));
            int gameNumberInt = Integer.parseInt(gameNumber.trim());
            lines.add(new LineStats(gameNumberInt, line, 0));
        }

        for (int i = 0; i < lines.size(); i++) {
            LineStats lineStats = lines.get(i);
            int gameToIncrement = findNumber(lineStats.getLine());
            sum = sum + (lineStats.getSum()*lineStats.getSum()+  lineStats.getSum() );
            //How many games to increment
            for (int j = i + 1; j <= gameToIncrement+1; j++) {
                LineStats lineStatsToUpdate = lines.get(j);
                int sum1 = lineStatsToUpdate.getSum();
                sum1 = sum1 + 1;
                lineStatsToUpdate.setSum(sum1);
                System.out.println("setting game  " + lineStatsToUpdate.getGameNumber() + " sum1 " + sum1);
            }
        }

//        for (LineStats lineStats : lines) {
//            int linesSum = lineStats.getSum();
//            System.out.println(lineStats.getGameNumber() + " " + linesSum);
//                sum = sum +linesSum;
//
//        }

        sum ++; //for the first game
        System.out.println("sum " + sum);

    }

    public static int findNumber(String input) {
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
                    System.out.println("found winningNumber " + winningNumber+ " count " + count );

                }
            }
        }

        return count;
    }
}