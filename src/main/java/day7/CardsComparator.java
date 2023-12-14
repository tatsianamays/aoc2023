package day7;

import java.util.*;

public class CardsComparator implements Comparator<String> {
    Map<String, Integer> map = new HashMap<>();

    {
        map.put("Five of a kind", 7);
        map.put("Four of a kind", 6);
        map.put("Full house", 5);
        map.put("Three of a kind", 4);
        map.put("Two pair", 3);
        map.put("One pair", 2);
        map.put("High card", 1);
    }

    Map<Character, Integer> mapOfChars = new HashMap<>();

    {
        mapOfChars.put('A', 14);
        mapOfChars.put('K', 13);
        mapOfChars.put('Q', 12);
        mapOfChars.put('J', 11);
        mapOfChars.put('T', 10);
        mapOfChars.put('9', 9);
        mapOfChars.put('8', 8);
        mapOfChars.put('7', 7);
        mapOfChars.put('6', 6);
        mapOfChars.put('5', 5);
        mapOfChars.put('4', 4);
        mapOfChars.put('3', 3);
        mapOfChars.put('2', 2);

    }

    @Override
    public int compare(String a, String b) {
        String aType = getType(a);
        String bType = getType(b);
        if(map.get(aType) > map.get(bType)){
            return 1;
        }else if(map.get(aType) < map.get(bType)){
            return -1;
        }  else {
            //Compare the cards
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            for (int i = 0; i < aChars.length; i++) {
                if(mapOfChars.get(aChars[i]) > mapOfChars.get(bChars[i])){
                    return 1;
                }else if(mapOfChars.get(aChars[i]) < mapOfChars.get(bChars[i])){
                    return -1;
                }
            }
            System.out.println("EQUAL a: " + a + " b: " + b);
            return 0;
        }
    }

    /*
    Every hand is exactly one type. From strongest to weakest, they are:

Five of a kind, where all five cards have the same label: AAAAA
Four of a kind, where four cards have the same label and one card has a different label: AA8AA
Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
High card, where all cards' labels are distinct: 23456

     */
    public static String getType(String card){
        char[] chars = card.toCharArray();
        int firstOccurances = 0;
        int secondOccurances = 0;
        int thirdOccurances = 0;
        int fourthOccurances = 0;
        int fifthOccurances = 0;
        char firstChar = chars[0];
        char secondChar = chars[1];
        char thirdChar = chars[2];
        char fourthChar = chars[3];
        char fifthChar = chars[4];

        firstOccurances = getOccurances(chars, firstChar);
        if(firstChar!= secondChar){
            secondOccurances = getOccurances(chars, secondChar);
        }
        if(firstChar!= thirdChar && secondChar != thirdChar){
            thirdOccurances = getOccurances(chars, thirdChar);
        }
        if(firstChar!= fourthChar && secondChar != fourthChar && thirdChar != fourthChar){
            fourthOccurances = getOccurances(chars, fourthChar);
        }
        if(firstChar!= fifthChar && secondChar != fifthChar && thirdChar != fifthChar && fourthChar != fifthChar){
            fifthOccurances = getOccurances(chars, fifthChar);
        }

        Integer[] occurances = {firstOccurances, secondOccurances, thirdOccurances, fourthOccurances,fifthOccurances};
        Arrays.sort(occurances, Collections.reverseOrder());

        if(occurances[0] == 5){
            return "Five of a kind";
        }else if(occurances[0] == 4 && occurances[1] == 1){
            return "Four of a kind";
        }else if(occurances[0] == 3 && occurances[1] == 2){
            return "Full house";
        }else if(occurances[0] == 3 && occurances[1] == 1 && occurances[2] == 1){
            return "Three of a kind";
        }else if(occurances[0] == 2 && occurances[1] == 2 && occurances[2] == 1){
            return "Two pair";
        }else if(occurances[0] == 2 && occurances[1] == 1 && occurances[2] == 1 && occurances[3] == 1){
            return "One pair";
        }else{
            return "High card";
        }



    }

    private static int getOccurances(char[] chars, char firstChar) {
        int firstOccurances;
        firstOccurances = 0;
        for (char aChar : chars) {
            if (aChar == firstChar) {
                firstOccurances++;
            }
        }
//        System.out.println("firstChar: " + firstChar  + " firstOccurances: " + firstOccurances);

        return firstOccurances;
    }

    /*
32T3K
T55J5
KK677
KTJJT
QQQJA
     */




}
