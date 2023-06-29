package org.alext123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final String path = "C:\\Users\\alext\\Documents\\GitHub\\advent-of-code-journey\\day1\\src\\main\\java\\org\\alext123411\\input.txt";
        Day1 day1Tasks = new Day1(path);

        day1Tasks.part1();
        day1Tasks.part2();

    }
}