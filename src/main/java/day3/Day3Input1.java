package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3Input1 {

//461554 too low
    //555514 too high
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day3/input.txt"));
//        Scanner scanner = new Scanner(new File("day3/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        List<String> lines = new ArrayList<>();
        int sum = 0;
        while (scanner.hasNext()) {
            lines.add(scanner.next());
        }


        for (int i = 0; i < lines.size(); i++) {
            String previouse = ".................................................................................................................................................................................................";
            String current = "";
            String next = ".....................................................................................................................................................................................................";
            if (i > 0) {
                previouse = lines.get(i - 1);
            }
            current = lines.get(i);
            if (i < lines.size() - 1) {
                next = lines.get(i + 1);
            }
            System.out.println("current: " + current);
            List<Integer> result = findNumber(new String[]{previouse, current, next});
            System.out.println(result);
            sum = sum + result.stream().mapToInt(Integer::intValue).sum();
        }
        System.out.println("sum: " + sum);

    }

    public static List<Integer> findNumber(String[] input) {
        List<Integer> digitsToAdd = new ArrayList<>();
        String previouse = input[0];
        String current = input[1];
        String next = input[2];
        Integer firstIndexOfDigit = null;
        Integer lastIndexOfDigit = null;
        for (int i = 0; i < current.length(); i++) {
            char currentChar = current.charAt(i);
            if (Character.isDigit(currentChar)) {
                if (firstIndexOfDigit == null) {
                    firstIndexOfDigit = i;
                }
                lastIndexOfDigit = i;
                System.out.println("is digit firstIndexOfDigit: " + firstIndexOfDigit + " lastIndexOfDigit: " + lastIndexOfDigit);
            }
            if((!Character.isDigit(currentChar) || i == current.length()-1) && firstIndexOfDigit != null &&lastIndexOfDigit > 0){
                //Calculate if adjacent to symbol
                ;

                    int number = Integer.parseInt(current.substring(firstIndexOfDigit, lastIndexOfDigit + 1));
                    System.out.println("firstIndexOfDigit: " + firstIndexOfDigit + " lastIndexOfDigit: " + lastIndexOfDigit + " number: " + number);
                    if (isAdjacentToSymbol(previouse, current, next, firstIndexOfDigit, lastIndexOfDigit)) {
                        System.out.println("is adjacent to symbol "+ number);
                        digitsToAdd.add(number);
                    } else {
                        System.out.println("not adjacent to symbol firstIndexOfDigit: " + firstIndexOfDigit + " lastIndexOfDigit: " + lastIndexOfDigit + " number: " + number);
                    }
                    firstIndexOfDigit = null;
                    lastIndexOfDigit = null;


            }
        }

        return digitsToAdd;
    }

    private static boolean isAdjacentToSymbol(String previouse, String current, String next, int firstIndexOfDigit, int lastIndexOfDigit) {
        int firstIndexOfSymbol = 0;
        if (firstIndexOfDigit > 0) {
            firstIndexOfSymbol = firstIndexOfDigit - 1;
        }
        int lastIndexOfSymbol = current.length() - 1;
        if (lastIndexOfDigit < current.length() - 1) {
            lastIndexOfSymbol = lastIndexOfDigit + 1;
        }
        String previousePartToCheck = previouse.substring(firstIndexOfSymbol, lastIndexOfSymbol+1);
        System.out.println("previousePartToCheck: " + previousePartToCheck + " firstIndexOfSymbol: " + firstIndexOfSymbol + " lastIndexOfSymbol: " + lastIndexOfSymbol);
        for (char s : previousePartToCheck.toCharArray()) {
            if ('.' != s) {
                return true;
            }
        }
        String nextPartToCheck = next.substring(firstIndexOfSymbol, lastIndexOfSymbol+1);
        System.out.println("nextPartToCheck: " + nextPartToCheck+ " firstIndexOfSymbol: " + firstIndexOfSymbol + " lastIndexOfSymbol: " + lastIndexOfSymbol);
        for (char s : nextPartToCheck.toCharArray()) {
            if ('.' != s) {
                return true;
            }
        }
        System.out.println("current.charAt(firstIndexOfSymbol): " + current.charAt(firstIndexOfSymbol) + " current.charAt(lastIndexOfSymbol): " + current.charAt(lastIndexOfSymbol));
        if(firstIndexOfDigit > 0 && '.' != current.charAt(firstIndexOfSymbol)){
            return true;
        }
        if( lastIndexOfDigit < current.length() - 1 && '.' != current.charAt(lastIndexOfSymbol)){
            return true;
        }
        return false;
    }
}

