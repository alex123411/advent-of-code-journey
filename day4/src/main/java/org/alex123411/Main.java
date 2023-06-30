package org.alex123411;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Day4 day4Tasks = new Day4();

        long startTime = System.currentTimeMillis();
        day4Tasks.part2();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time spent on day4Tasks.part1(): " + elapsedTime + " milliseconds");

        startTime = System.currentTimeMillis();
        day4Tasks.part2();
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Time spent on day4Tasks.part2(): " + elapsedTime + " milliseconds");
    }
}