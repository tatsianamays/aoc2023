package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8Input1 {

    static Map<String, Integer> possible = Map.of("red", 12, "green", 13, "blue", 14);

    /*
    map
AAA = (BBB, CCC)
BBB = (DDD, EEE)
CCC = (ZZZ, GGG)
DDD = (DDD, DDD)
EEE = (EEE, EEE)
GGG = (GGG, GGG)
ZZZ = (ZZZ, ZZZ)
     */

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day8/input.txt"));
//        Scanner scanner = new Scanner(new File("day8/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        Map<String, Node> input = new HashMap<>();
        String instructions = "LRRLRRLRLLLRLLRLRRLRRLRRLRRLLRLLRRRLRRRLRRLLLRLRRLLLLLRRRLRRRLRRRLRRLRRLRLRLRLRLRRRLRRRLRRRLRRLRRLRLRLRRLLRRRLLRRLRRLRRRLRLLRRLRRLRRRLRRRLRRRLRRRLRRLLLRRRLLRRLLLRRLRRLLRRLRRRLRRLRRLRRRLRRLLLRLRRRLLRRRLRLRRLRLRLRLRRRLRLRLRRLLRRLRRLRRLRRLLRLRLRRRLRRLRRLRRLRLRRRLRRLRLLRRLLRRLRLLLRLLRRRLRLRLLRRRR";
        while (scanner.hasNext()) {
            String line = scanner.next();
            input.put(line.substring(0,3), new Node(line.substring(7,10), line.substring(12,15)));
        }

        System.out.println(findNumber(instructions, input));
    }

    public static int findNumber(String instructions , Map<String, Node> input) {
        int countSteps = 0;

        char[] instructionsArray = instructions.toCharArray();
        String next = "FLG";

        for (int i = 0; i < instructionsArray.length ; i++) {
            char current = instructionsArray[i];
            Node node = input.get(next);
            if (current == 'R') {
                next = node.getRight();
                countSteps = countSteps + 1;
            } else if (current == 'L') {
                next = node.getLeft();
                countSteps = countSteps + 1;
            }
//            System.out.println(next);
            if(next.equals("ZZZ")){
                break;
            }
            if(i+1 == instructionsArray.length){
                i = 0;
            }

        }

        return countSteps;
    }
}

