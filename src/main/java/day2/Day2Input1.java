package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Day2Input1 {

    static Map<String, Integer> possible = Map.of("red", 12, "green", 13, "blue", 14);

    public static void main(String[] args) throws FileNotFoundException {

//        Scanner scanner = new Scanner(new File("day2/input.txt"));
        Scanner scanner = new Scanner(new File("day2/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            sum = sum + findNumber(line);
        }
    }

    public static int findNumber(String input) {
        String[] game = input.split(":");
        int gameNumber = Integer.parseInt(game[0].split(" ")[1]);
        System.out.println("Game " + gameNumber);
        for (String string : game[1].split(";")) {
            for (String s : string.split(",")) {
                String[] score = s.trim().split(" ");
                int scoreNumber = Integer.parseInt(score[0]);
                String scoreColor = score[1];
                System.out.println(scoreNumber + " " + scoreColor);
                if (possible.get(scoreColor) < scoreNumber) {
                    System.out.println(scoreNumber + " greater " + possible.get(scoreColor));
                    return 0;
                }
            }
        }
        return gameNumber;
    }
}

