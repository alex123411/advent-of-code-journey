package org.alex123411;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Day3 day3Tasks = new Day3();

        long startTime = System.currentTimeMillis();
        day3Tasks.part2();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time spent on day4Tasks.part1(): " + elapsedTime + " milliseconds");

        startTime = System.currentTimeMillis();
        day3Tasks.part2();
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Time spent on day4Tasks.part2(): " + elapsedTime + " milliseconds");
    }


}