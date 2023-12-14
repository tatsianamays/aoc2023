package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Day7Input1 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day7/input.txt"));
//                Scanner scanner = new Scanner(new File("day7/a_sample.txt"));
        scanner.useDelimiter(System.getProperty("line.separator"));

        TreeMap<String, Integer> mapOfCards = new TreeMap<>(new CardsComparator());

        while (scanner.hasNext()) {
            String line = scanner.next();
            mapOfCards.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
        }

        AtomicInteger i = new AtomicInteger(1);
        AtomicInteger sum = new AtomicInteger(0);
        mapOfCards.forEach((k, v) -> {
            int i1 = i.get();
            sum.addAndGet(v * i1);
            i.incrementAndGet();
            System.out.println(k + " " + v + " "+ i1 + " " + sum);

            }
        );

            System.out.println(sum);


    }




}