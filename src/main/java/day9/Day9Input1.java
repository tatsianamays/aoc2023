package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day9Input1 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day9/input.txt"));
//                Scanner scanner = new Scanner(new File("day9/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        long sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            sum = sum + findNumber(line);
            System.out.println(sum);
        }
    }

    public static long findNumber(String input) {
        //0 3 6 9 12 15
        System.out.println(input);
        List<int[]> listOfInts = new ArrayList<>();
        String[] split = input.split(" ");
        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        listOfInts.add(numbers);

        boolean generateNumebrs = true;
        while(generateNumebrs){
            int[] numbersToAdd = getNextRow(numbers);
            System.out.println(Arrays.toString(numbersToAdd));
            listOfInts.add(numbersToAdd);
            for(int i = 0; i < numbersToAdd.length; i++){
                if(numbersToAdd[i] != 0){
                    break;
                }else if(i == numbersToAdd.length-1){
                    generateNumebrs = false;

                }
            }
            numbers = numbersToAdd;
        }


        return calculateTotal(listOfInts);
    }

    private static long calculateTotal(List<int[]> listOfInts) {
        long extrapolatedValue = 0;
         for(int i= listOfInts.size()-1; i >= 0; i--){
             int[] current = listOfInts.get(i);
             extrapolatedValue =  extrapolatedValue + current[current.length-1];
              System.out.println(" current: " + current[current.length-1] + " extrapolatedValue: " + extrapolatedValue );
         }
        return extrapolatedValue;
    }

    private static int[] getNextRow(int[] numbers) {
        int[] numbersToAdd = new int[numbers.length-1];
        for (int i = 0; i < numbers.length-1; i++) {
            int current = numbers[i];
            int next = numbers[i+1];
            numbersToAdd[i] =  next-current;
//            System.out.println("next: " + next + " current: " + current + " numbersToAdd[i]: " + numbersToAdd[i]);

        }
        return numbersToAdd;
    }
}