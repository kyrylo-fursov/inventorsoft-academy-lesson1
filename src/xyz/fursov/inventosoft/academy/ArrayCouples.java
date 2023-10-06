package xyz.fursov.inventosoft.academy;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

public class ArrayCouples {
    public static void main(String[] args) {
        try {
            int[] arr = getUserInput();
            String result = arrayChallenge(arr);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Get user input from the console
    // Throws an exception if the input is invalid
    public static int[] getUserInput() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an even number of positive integers separated by spaces:");
        String input = scanner.nextLine();
        scanner.close();

        return parseInput(input);
    }

    // Parse user input into an array of integers
    // Throws an exception if the input is invalid
    private static int[] parseInput(String input) throws IllegalArgumentException {
        String[] inputArray = input.split("\\s+");

        int[] arr = new int[inputArray.length];

        try {
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input format. Please enter valid positive integers separated by spaces.");
        }

        return arr;
    }


    // Find the pairs of integers that are not the reverse of another pair
    // Return "yes" if all pairs are the reverse of another pair
    // slowArrayChallenge is a slower implementation of ArrayChallenge
    public static String slowArrayChallenge(int[] arr) throws IllegalArgumentException {
        if (arr.length % 2 != 0 || arr.length == 0) {
            throw new IllegalArgumentException("Input must contain an even number of integers.");
        }


        StringJoiner joiner = new StringJoiner(",");

        for (int i = 0; i < arr.length; i += 2) {
            int first = arr[i];
            int second = arr[i + 1];
            boolean found = false;

            if (first < 1 || second < 1) {
                throw new IllegalArgumentException("All integers must be positive.");
            }


            for (int j = 0; j < arr.length; j += 2) {
                if(i == j) {
                    continue;
                }

                int innerFirst = arr[j];
                int innerSecond = arr[j + 1];

                // Check if the current pair is the reversed pair of another pair
                if ((first == innerSecond) && (second == innerFirst)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                joiner.add(Integer.toString(first)).add(Integer.toString(second));
            }
        }

        return (joiner.length() == 0) ? "yes" : joiner.toString();
    }

    // Find the pairs of integers that are not the reverse of another pair
    // Return "yes" if all pairs are the reverse of another pair
    public static String arrayChallenge(int[] arr) {
        if (arr.length % 2 != 0 || arr.length == 0) {
            throw new IllegalArgumentException("Input must contain an even number of integers.");
        }

        Set<Pair> pairs = new LinkedHashSet<>();
        List<Pair> duplicates = new LinkedList<>();


        for (int i = 0; i < arr.length; i += 2) {
            int first = arr[i];
            int second = arr[i + 1];
            if (first < 1 || second < 1) {
                throw new IllegalArgumentException("All integers must be positive.");
            }

            Pair currentPair  = new Pair(first, second);
            pairs.add(currentPair);

            if(currentPair.isDuplicate()) {
                duplicates.add(currentPair);
            }
        }

        StringJoiner joiner = new StringJoiner(",");
        for(Pair currentPair : pairs) {
            // System.out.println(currentPair + " " + currentPair.getReversedPair() + " " + pairs.contains(currentPair.getReversedPair()));
            if(!pairs.contains(currentPair.getReversedPair())) {
                joiner.add(Integer.toString(currentPair.getFirst())).add(Integer.toString(currentPair.getSecond()));
            }
            if(currentPair.isDuplicate() && Collections.frequency(duplicates, currentPair) == 1) {
                joiner.add(Integer.toString(currentPair.getFirst())).add(Integer.toString(currentPair.getSecond()));
            }
        }

        return (joiner.length() == 0) ? "yes" : joiner.toString();
    }

}

