package org.alext123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Day2 {
    private final Scanner filePathInput = new Scanner(System.in);
    private final Map<String, Integer> opponentSigns = Map.of(
            "A", 1,
            "B", 2,
            "C", 3
    );
    private final Map<String, Integer> mySigns = Map.of(
            "X", 1,
            "Y", 2,
            "Z", 3
    );

    public void part1() throws FileNotFoundException {
        Scanner scanner = getInput();
        int finalScore = 0;

        while (scanner.hasNextLine()) {
            String[] signs = scanner.nextLine().split(" ");

            String opponentSign = signs[0];
            String mySign = signs[1];
            finalScore += mySigns.get(mySign);

            if (opponentSigns.get(opponentSign) == mySigns.get(mySign)) finalScore += 3;

            if (opponentSign.equals("A") && mySign.equals("Y")) finalScore += 6;
            if (opponentSign.equals("B") && mySign.equals("Z")) finalScore += 6;
            if (opponentSign.equals("C") && mySign.equals("X")) finalScore += 6;

        }
        scanner.close();
        System.out.println("Based on encrypted strategy guide you gave me, I can say that your final score will be: " + finalScore);
    }

    public void part2() throws FileNotFoundException {
        Scanner scanner = getInput();
        int finalScore = 0;

        while (scanner.hasNextLine()) {
            String[] signs = scanner.nextLine().split(" ");

            String opponentSign = signs[0];
            String mySign = signs[1];

            if (mySign.equals("X")) {
                if (opponentSign.equals("A")) finalScore += 3;
                if (opponentSign.equals("B")) finalScore += 1;
                if (opponentSign.equals("C")) finalScore += 2;
            }
            if (mySign.equals("Y")) finalScore += 3 + opponentSigns.get(opponentSign);
            if (mySign.equals("Z")) {
                finalScore += 6;
                if (opponentSign.equals("A")) finalScore += 2;
                if (opponentSign.equals("B")) finalScore += 3;
                if (opponentSign.equals("C")) finalScore += 1;
            }

        }
        scanner.close();
        System.out.println("Based on encrypted strategy guide you gave me, I can say that your final score will be: " + finalScore);
    }

    private Scanner getInput() throws FileNotFoundException {
        System.out.println("Please input file path where we can find an encrypted strategy guide you got from elves.");
        String path = "";

        if (filePathInput.hasNextLine()) path = filePathInput.nextLine();

        return new Scanner(new File(path));  // Reading file from path
    }

}
