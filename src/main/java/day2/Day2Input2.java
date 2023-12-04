package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Input2 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day2/input2.txt"));
//                Scanner scanner = new Scanner(new File("day2/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            sum = sum + findNumber(line);
            System.out.println(sum);
        }
    }

    public static int findNumber(String input) {
        String[] game = input.split(":");
        int gameNumber = Integer.parseInt(game[0].split(" ")[1]);
        System.out.println("Game " + gameNumber);
        Map<String, Integer> max = new HashMap<>(Map.of("red", 0, "green", 0, "blue", 0));
        for (String string : game[1].split(";")) {
            for (String s : string.split(",")) {
                String[] score = s.trim().split(" ");
                int scoreNumber = Integer.parseInt(score[0]);
                String scoreColor = score[1];
                if (max.get(scoreColor) < scoreNumber) {
                    max.put(scoreColor, scoreNumber);
                    System.out.println(scoreColor + " " + max.get(scoreColor) + " " + scoreNumber + " adding");
                }
            }
        }
        return max.get("red") * max.get("green") * max.get("blue");
    }
}