package org.alex123411;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {

    private static final String inputPath = "C:\\Users\\alext\\Documents\\GitHub\\advent-of-code-journey\\day5\\src\\main\\java\\org\\alex123411\\input.txt";
    List<String> input;
    private final List<Stack<Character>> stacksList;

    Day5() throws FileNotFoundException {
        this.input = readInputFile();
        this.stacksList = initializeArrayOfStacks();
    }

    public void part1() {
        List<Stack<Character>> clonedList  = CloneListOfStacks();

        for (String s : input) {
            if (s.isEmpty()) continue;

            if (s.charAt(0) == 'm') {
                String[] strings = s.split(" ");

                int numberOfMoves = Integer.parseInt(strings[1]);
                int fromStackIndex = Integer.parseInt(strings[3]) - 1;
                int toStackIndex = Integer.parseInt(strings[5]) - 1;

                for (int i = 0; i < numberOfMoves; i++) {
                    clonedList .get(toStackIndex).push(clonedList .get(fromStackIndex).pop());
                }
            }
        }
        StringBuilder res = new StringBuilder();

        for (Stack<Character> stack : clonedList ) {
            if (!stack.empty()) res.append(stack.peek());
        }

        System.out.println("Result: " + res);
    }

    public void part2() {
        List<Stack<Character>> clonedList  = CloneListOfStacks();

        for (String s : input) {
            if (s.isEmpty()) continue;

            if (s.charAt(0) == 'm') {
                String[] strings = s.split(" ");
                Stack<Character> temp = new Stack<>();

                int numberOfMoves = Integer.parseInt(strings[1]);
                int fromStackIndex = Integer.parseInt(strings[3]) - 1;
                int toStackIndex = Integer.parseInt(strings[5]) - 1;

                for (int i = 0; i < numberOfMoves; i++)
                    temp.push(clonedList.get(fromStackIndex).pop());

                for (int i = 0; i < numberOfMoves; i++)
                    clonedList.get(toStackIndex).push(temp.pop());
            }
        }
        StringBuilder res = new StringBuilder();

        for (Stack<Character> stack : clonedList) {
            res.append(stack.peek());
        }

        System.out.println("Result: " + res);
    }


    private List<Stack<Character>> CloneListOfStacks (){
        // Clone the list of stacks
        List<Stack<Character>> clonedList = new ArrayList<>();
        for (Stack<Character> originalStack : stacksList) {
            Stack<Character> clonedStack = new Stack<>();
            clonedStack.addAll(originalStack);
            clonedList.add(clonedStack);
        }

        return clonedList;
    }

    private List<Stack<Character>> initializeArrayOfStacks() {
        List<Stack<Character>> stacksList = new LinkedList<>();
        int numberOfLinesBeforeMoves = 0;

        for (String s : input) {
            numberOfLinesBeforeMoves++;
            if (s.isEmpty()) continue;
            if (s.charAt(0) == '[') {

                char[] chars = s.toCharArray();
                int charsGap = 4;

                for (int j = 1; j < chars.length; j += charsGap) {
                    int listIndex = (j - 1) / charsGap;
                    if (stacksList.size() < listIndex + 1) stacksList.add(new Stack<>());

                    char charToPushIntoStack = chars[j];
                    if (charToPushIntoStack != ' ') {
                        stacksList.get(listIndex).add(charToPushIntoStack);
                    }
                }
            } else if (s.charAt(1) == '1') {
                stacksList.replaceAll(this::reverseCharacterStack);
                break;
            }

        }

        input = input.subList(numberOfLinesBeforeMoves, input.size());

        return stacksList;
    }

    private <T> Stack<T> reverseCharacterStack(Stack<T> inputStack) {
        Queue<T> queue = new LinkedList<>();
        while (!inputStack.isEmpty()) {
            queue.add(inputStack.pop());
        }
        while (!queue.isEmpty()) {
            inputStack.add(queue.remove());
        }
        return inputStack;
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
