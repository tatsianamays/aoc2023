package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3Input2 {
//too low
//25423680

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day3/input2.txt"));
//                Scanner scanner = new Scanner(new File("day2/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));


        List<String> lines = new ArrayList<>();
        AtomicInteger sum = new AtomicInteger();
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
            List<List<Integer>> ints = findNumber(new String[]{previouse, current, next});
            ints.forEach( list ->{
                System.out.println("list: " + list);
                if (list.size() == 2) {
                    sum.set(sum.get() + list.get(0) * list.get(1));
                }
            });


        }
        System.out.println("sum: " + sum);

    }

    public static List<List<Integer>>  findNumber(String[] input) {

        String previouse = input[0];
        String current = input[1];
        String next = input[2];
        Integer firstIndexOfDigit = null;
        Integer lastIndexOfDigit = null;
        List<List<Integer>> ints = new ArrayList<>();
        for (int i = 0; i < current.length(); i++) {
            char currentChar = current.charAt(i);
            if (currentChar == '*') {
                ints.add(getDigit(previouse, current, next, i));
                System.out.println("ints: " + ints);
            }
        }

        return ints;


    }

    private static List<Integer> getDigit(String previouse, String current, String next, int index) {
        int firstIndexOfSymbol = 0;
        if (index > 0) {
            firstIndexOfSymbol = index - 1;
        }
        int lastIndexOfSymbol = current.length() - 1;
        if (index < current.length() - 1) {
            lastIndexOfSymbol = index + 1;
        }
        int[] ints = new int[2];
        List<Integer> digitsToAdd = new ArrayList<>();
        String previousePartToCheck = previouse.substring(firstIndexOfSymbol, lastIndexOfSymbol + 1);
        System.out.println("previousePartToCheck: " + previousePartToCheck + " firstIndexOfSymbol: " + firstIndexOfSymbol + " lastIndexOfSymbol: " + lastIndexOfSymbol);
        char[] charArray = previousePartToCheck.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char s = charArray[i];
            if (Character.isDigit(s)) {

                StringBuilder builder = new StringBuilder(Character.getNumericValue(s));
                //look forward and back to Get the rest of the number
                System.out.println(" builder  " + builder);
                lookBack(previouse, firstIndexOfSymbol + i, builder);
                System.out.println(" builder  " + builder);
                lookForward(previouse, firstIndexOfSymbol + i + 1, builder);
                System.out.println(" builder  " + builder);
                digitsToAdd.add(Integer.parseInt(builder.toString()));
                if (charArray[1] == '.' && Character.isDigit(charArray[2])&& Character.isDigit(charArray[0])) {
                    s = charArray[2];
                    builder = new StringBuilder(Character.getNumericValue(s));
                    //look forward and back to Get the rest of the number
                    System.out.println(" builder  " + builder);
                    lookForward(previouse, firstIndexOfSymbol + 2, builder);
                    System.out.println(" builder  " + builder);
                    digitsToAdd.add(Integer.parseInt(builder.toString()));
                    break;

                }
                break;

            }


        }

        String nextPartToCheck = next.substring(firstIndexOfSymbol, lastIndexOfSymbol + 1);
        System.out.println("nextPartToCheck: " + nextPartToCheck + " firstIndexOfSymbol: " + firstIndexOfSymbol + " lastIndexOfSymbol: " + lastIndexOfSymbol);
        charArray = nextPartToCheck.toCharArray();
        for (int q = 0; q < charArray.length; q++) {
            char s = charArray[q];
            if (Character.isDigit(s)) {
                StringBuilder builder = new StringBuilder(Character.getNumericValue(s));
                System.out.println(builder + " nextPartToCheck: " + nextPartToCheck + " firstIndexOfSymbol: " + firstIndexOfSymbol + " lastIndexOfSymbol: " + lastIndexOfSymbol);
                //look forward and back to Get the rest of the number
                System.out.println(" builder  " + builder);
                lookBack(next, firstIndexOfSymbol + q, builder);
                System.out.println(" builder  " + builder);
                lookForward(next, firstIndexOfSymbol + q + 1, builder);
                System.out.println("  builder " + builder);
                digitsToAdd.add(Integer.parseInt(builder.toString()));
                if (charArray[1] == '.' && Character.isDigit(charArray[2])&& Character.isDigit(charArray[0])) {
                    s = charArray[2];
                     builder = new StringBuilder(Character.getNumericValue(s));
                    System.out.println(builder + " nextPartToCheck: " + nextPartToCheck + " firstIndexOfSymbol: " + firstIndexOfSymbol + " lastIndexOfSymbol: " + lastIndexOfSymbol);
                    //look forward and back to Get the rest of the number
                    System.out.println(" builder  " + builder);
                    lookForward(next, firstIndexOfSymbol + q + 2, builder);
                    System.out.println("  builder " + builder);
                    digitsToAdd.add(Integer.parseInt(builder.toString()));
                    break;

                }
                break;

            }

        }


        System.out.println("current.charAt(firstIndexOfSymbol): " + current.charAt(firstIndexOfSymbol) + " current.charAt(lastIndexOfSymbol): " + current.charAt(lastIndexOfSymbol));
        if (index > 0 && Character.isDigit(current.charAt(firstIndexOfSymbol))) {
            StringBuilder builder = new StringBuilder(Character.getNumericValue(current.charAt(firstIndexOfSymbol)));
            //look back
            lookBack(current, firstIndexOfSymbol, builder);
            digitsToAdd.add(Integer.parseInt(builder.toString()));
        }
        if (index < current.length() - 1 && Character.isDigit(current.charAt(lastIndexOfSymbol))) {
            StringBuilder builder = new StringBuilder(Character.getNumericValue(current.charAt(lastIndexOfSymbol)));
            //look forward to Get the rest of the number
            lookForward(current, lastIndexOfSymbol, builder);
            digitsToAdd.add(Integer.parseInt(builder.toString()));

        }
        if (digitsToAdd.size() < 2) {
            return Collections.emptyList();
        }else {
            return digitsToAdd;
        }
    }

    private static void lookForward(String current, int lastIndexOfSymbol, StringBuilder builder) {
        for (int i = lastIndexOfSymbol, k = 1; i < current.length(); i++, k++) {
            if (Character.isDigit(current.charAt(i))) {
                System.out.println(builder + " lookForward adding: " + current.charAt(i));
                builder.append(Character.getNumericValue(current.charAt(i)));
            } else {
                break;
            }
        }
    }

    private static void lookBack(String current, int firstIndexOfSymbol, StringBuilder builder) {
        for (int i = firstIndexOfSymbol; i >= 0; i--) {
            if (Character.isDigit(current.charAt(i))) {
                System.out.println(builder + " lookBack adding: " + current.charAt(i));
                builder.insert(0, Character.getNumericValue(current.charAt(i)));
            } else {
                break;
            }
        }
    }

}