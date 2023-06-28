package org.alext123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please input file path where we can find a list of calories you got from elves.");
        Scanner filePathInput = new Scanner(System.in);
        String path = "";

        if (filePathInput.hasNextLine()) path = filePathInput.nextLine();

        Scanner scanner = new Scanner(new File(path));  // Reading file from path

        int temp = 0;
        int max = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                max = Math.max(temp, max);
                temp = 0;
                continue;
            }
            temp += Integer.parseInt(line.trim());
        }

        scanner.close();
        System.out.println("Biggest number of calories: " + max);  // Output user input
    }
}