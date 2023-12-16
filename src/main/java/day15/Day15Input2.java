package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day15Input2 {


    static Map<Integer, List<SequenceObject>> map = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day15/input2.txt"));
//        Scanner scanner = new Scanner(new File("day15/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        long sum = 0;
            String line = scanner.next();

        String[] input = line.split(",");
        for(String s : input) {
           process(s);
        }
//        sum = calculate(map);
        System.out.println(map);
//        System.out.println(sum);

    }

    private static long calculate(Map<Integer, List<SequenceObject>> map) {
        long result = 0;
        //GEt map entry index + 1
        //Get list indexes
        //Get focal lengh

        for(Map.Entry<Integer, List<SequenceObject>> entry : map.entrySet()) {
            List<SequenceObject> list = entry.getValue();
            Integer mapIndex = entry.getKey();
            for(int i = 0; i < list.size(); i++) {
                SequenceObject so = list.get(i);
                int focalLength = so.getFocalLength();
                int index = i + 1;
                int box = mapIndex + 1;
                int singleValue = box * index * focalLength;
                System.out.println(so + " box: " + box  + " slot: " + index + " focalLength: " + focalLength + " result: " + result + " singleValue: " + singleValue);

                result = result + singleValue;
            }
        }
        return result;
    }

    private static void process(String s) {
        if(s.contains("=")) {

            String[] split = s.split("=");
            String chars = split[0];
            int focalLength = Integer.parseInt(split[1]);
            Integer mapKey = findNumber(chars);
            SequenceObject sequenceObject = new SequenceObject(chars, focalLength);
            List<SequenceObject> list = map.get(mapKey);
            if(list == null) {
                list = new java.util.ArrayList<>();
                list.add(sequenceObject);
                map.put(mapKey, list);
            }else {
                //Check if exist
                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    SequenceObject oldSo = list.get(i);
                    if (oldSo.getChars().equals(chars)) {
                        //found
                        //do something
                        list.set(i, sequenceObject);
                        System.out.println( "Updated " + oldSo + " to " + sequenceObject);
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    list.add(sequenceObject);
                    System.out.println("New: " + sequenceObject);
                }
            }

        } else {
            //Remove
            String[] split = s.split("-");
            String chars = split[0];
            Integer mapKey = findNumber(chars);
            if(map.get(mapKey) != null) {
                List<SequenceObject> list = map.get(mapKey);
                list.removeIf(so -> so.getChars().equals(chars));
                System.out.println("Removed " + chars);
            }

        }


    }

    /*

    Determine the ASCII code for the current character of the string.
Increase the current value by the ASCII code you just determined.
Set the current value to itself multiplied by 17.
Set the current value to the remainder of dividing itself by 256.
     */
    public static Integer findNumber(String input) {
        int result = 0;
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            result = result + ascii;
            result = result * 17;
            result = result % 256;
        }
        return result;

    }
}

