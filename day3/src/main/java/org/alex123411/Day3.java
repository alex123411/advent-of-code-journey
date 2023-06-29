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

        System.out.println("Result: " + "");
    }

    public static int getAlphabeticCounter(char c) {
        char uppercaseC = Character.toUpperCase(c);

        int alphabeticCounter = uppercaseC - 'A' + 1;
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
