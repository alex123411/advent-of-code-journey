package org.alext123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {
    private Scanner scanner;
    private final String inputPath;

    public Day1(String inputPath) {
        this.inputPath = inputPath;
    }

    public void part1() throws FileNotFoundException {
        this.scanner = new Scanner(new File(this.inputPath));
        int temp = 0;
        int max = 0;

        while (this.scanner.hasNextLine()) {
            String line = this.scanner.nextLine();
            if (line.equals("")) {
                max = Math.max(temp, max);
                temp = 0;
                continue;
            }
            temp += Integer.parseInt(line.trim());
        }
        this.scanner.close();
        System.out.println("Biggest number of calories: " + max);  // Output user input
    }

    public void part2() throws FileNotFoundException {
        this.scanner = new Scanner(new File(this.inputPath));

        int temp = 0;

        List<Integer> arrayOfInts = new ArrayList<>();

        while (this.scanner.hasNextLine()) {
            String line = this.scanner.nextLine();
            if (line.equals("")) {
                arrayOfInts.add(temp);
                temp = 0;
                continue;
            }
            temp += Integer.parseInt(line.trim());
        }
        int res = arrayOfInts.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Top three Elves carrying the most Calories: " + res);
    }


}


