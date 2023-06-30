package org.alex123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {

    private static final String inputPath = "C:\\Users\\alext\\Documents\\GitHub\\advent-of-code-journey\\day3\\src\\main\\java\\org\\alex123411\\input.txt";

    public void part1() throws FileNotFoundException {
        List<String> input = readInputFile();
        Map<Character, Character> firstHalfMap = new HashMap<>();

        int res = 0;

        for (String s : input) {
            char[] charArr = s.toCharArray();
            int charArrLength = charArr.length;

            for (int i = 0; i < charArrLength; i++) {
                char c = charArr[i];

                if (i < charArrLength / 2) {
                    if (!firstHalfMap.containsKey(c)) firstHalfMap.put(c, c);
                    continue;
                }
                if (firstHalfMap.containsKey(c)) {
                    res += getAlphabeticCounter(c);
                    break;
                }
            }
            firstHalfMap.clear();
        }
        System.out.println("Result: " + res);
    }

    public void part2() throws FileNotFoundException {
        List<String> input = readInputFile();

        int res = 0;
        for (int i = 0; i < input.size(); i += 3)
            res += findCommonCharacter(input.get(i), input.get(i + 1), input.get(i + 2));

        System.out.println("Result: " + res);
    }

    public static int findCommonCharacter(String s1, String s2, String s3) {
        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            if (s2.indexOf(currentChar) != -1 && s3.indexOf(currentChar) != -1) {
                return getAlphabeticCounter(currentChar);
            }
        }
        System.out.println("NOT FOUND");
        return 0; // If no common character is found
    }

    public static int getAlphabeticCounter(char c) {
        char uppercaseChar = Character.toUpperCase(c);
        int alphabeticCounter = uppercaseChar - 'A' + 1;
        return alphabeticCounter + (Character.isUpperCase(c) ? 26 : 0);
    }

    private List<String> readInputFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inputPath));
        List<String> input = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            input.add(line);
        }

        scanner.close();
        return input;
    }
}
