package org.alex123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {

    private static final String inputPath = "C:\\Users\\alext\\Documents\\GitHub\\advent-of-code-journey\\day4\\src\\main\\java\\org\\alex123411\\input.txt";
    private static List<String> input;

    Day4() throws FileNotFoundException {
        input = readInputFile();
    }

    public void part1() {
        int res = 0;

        for (String s : input) {
            String[] sectionsIntervals = s.split(",");

            String[] firstIntervalIndexes = sectionsIntervals[0].split("-");
            int firstIntervalStart = Integer.parseInt(firstIntervalIndexes[0]);
            int firstIntervalEnd = Integer.parseInt(firstIntervalIndexes[1]);

            String[] secondIntervalIndexes = sectionsIntervals[1].split("-");
            int secondIntervalStart = Integer.parseInt(secondIntervalIndexes[0]);
            int secondIntervalEnd = Integer.parseInt(secondIntervalIndexes[1]);

            if (firstIntervalStart <= secondIntervalStart && firstIntervalEnd >= secondIntervalEnd) res++;
            else if (firstIntervalStart >= secondIntervalStart && firstIntervalEnd <= secondIntervalEnd) res++;
        }

        System.out.println("Result: " + res);
    }

    public void part2() {
        int res = 0;

        for (String s : input) {
            String[] sectionsIntervals = s.split(",");

            String[] firstIntervalIndexes = sectionsIntervals[0].split("-");
            int firstIntervalStart = Integer.parseInt(firstIntervalIndexes[0]);
            int firstIntervalEnd = Integer.parseInt(firstIntervalIndexes[1]);

            String[] secondIntervalIndexes = sectionsIntervals[1].split("-");
            int secondIntervalStart = Integer.parseInt(secondIntervalIndexes[0]);
            int secondIntervalEnd = Integer.parseInt(secondIntervalIndexes[1]);

            if (intervalContainsPoint(firstIntervalStart, secondIntervalStart, secondIntervalEnd)) res++;
            else if (intervalContainsPoint(firstIntervalEnd, secondIntervalStart, secondIntervalEnd)) res++;
            else if (intervalContainsPoint(secondIntervalStart, firstIntervalStart, firstIntervalEnd)) res++;
            else if (intervalContainsPoint(secondIntervalEnd, firstIntervalStart, firstIntervalEnd)) res++;
        }

        System.out.println("Result: " + res);
    }

    private boolean intervalContainsPoint(int point, int intervalStart, int intervalEnd) {
        return intervalStart <= point && point <= intervalEnd;
    }

    private static List<String> readInputFile() throws FileNotFoundException {
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
