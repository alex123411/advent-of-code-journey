package org.alex123411;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Day5 day5Tasks = new Day5();
        long startTime = System.currentTimeMillis();
        day5Tasks.part1();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time spent on day4Tasks.part1(): " + elapsedTime + " milliseconds");

        startTime = System.currentTimeMillis();
        day5Tasks.part2();
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Time spent on day4Tasks.part2(): " + elapsedTime + " milliseconds");

    }
}