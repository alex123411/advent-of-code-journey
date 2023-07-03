package org.alex123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6 {

    private static final String inputPath = "C:\\Users\\alext\\Documents\\GitHub\\advent-of-code-journey\\day6\\src\\main\\java\\org\\alex123411\\input.txt";
    String input;

    Day6() throws FileNotFoundException {
        this.input = readInputFile();
    }

    public void part1() {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        int seqLength = 4;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (i > 3 && map.size() == 4) map.remove(input.charAt(i - seqLength));

            if (map.containsKey(c)) {
                int indexOfPrev = map.get(c);
                for (int j = 0; j < 4 - (i - indexOfPrev); j++) {
                    map.remove(input.charAt(indexOfPrev - j));
                }
            }

            if (map.size() == 3) {
                res = i + 1;
                break;
            }
            map.put(c, i);
        }

        System.out.println("Result: " + res);

    }

    public void part2() {
        String res = "";

        System.out.println("Result: " + res);
    }

    private String readInputFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inputPath));
        String input = "";

        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }

        scanner.close();
        return input;
    }
}
