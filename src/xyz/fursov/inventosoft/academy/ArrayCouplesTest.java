package xyz.fursov.inventosoft.academy;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static xyz.fursov.inventosoft.academy.ArrayCouples.arrayChallenge;
import static xyz.fursov.inventosoft.academy.ArrayCouples.getUserInput;
import static xyz.fursov.inventosoft.academy.ArrayCouples.slowArrayChallenge;

// no junit dependency to keep the project simple
public class ArrayCouplesTest {
    public static void main(String[] args) {
        testArrayChallenge();
        testArrayChallengeWithUserInput();
        testMillionArrayChallenge();
    }

    // Test arrayChallenge(arr) with a few test cases
    public static void testArrayChallenge() {
        int[] arr0 = {6, 2, 2, 6, 5, 14, 14, 1};
        String result0 = arrayChallenge(arr0);
        System.out.println("Input: [6, 2, 2, 6, 5, 14, 14, 1]");
        System.out.println("Expected Output: 5,14,14,1");
        System.out.println("Actual Output: " + result0);
        System.out.println("Test Result: " + (result0.equals("5,14,14,1") ? "Pass" : "Fail"));
        System.out.println();

        int[] arr1 = {2, 1, 1, 2, 3, 3};
        String result1 = arrayChallenge(arr1);
        System.out.println("Input: [2, 1, 1, 2, 3, 3]");
        System.out.println("Expected Output: 3,3");
        System.out.println("Actual Output: " + result1);
        System.out.println("Test Result: " + (result1.equals("3,3") ? "Pass" : "Fail"));
        System.out.println();

        int[] arr2 = {5, 4, 6, 7, 7, 6, 4, 5};
        String result2 = arrayChallenge(arr2);
        System.out.println("Input: [5, 4, 6, 7, 7, 6, 4, 5]");
        System.out.println("Expected Output: yes");
        System.out.println("Actual Output: " + result2);
        System.out.println("Test Result: " + (result2.equals("yes") ? "Pass" : "Fail"));
        System.out.println();

        int[] arr3 = {}; // Empty input
        String result3;
        try {
            result3 = arrayChallenge(arr3);
        } catch (IllegalArgumentException e) {
            result3 = "An error occurred: " + e.getMessage();
        }
        System.out.println("Input: []");
        System.out.println("Expected Output: An error occurred: Input must contain an even number of integers.");
        System.out.println("Actual Output: " + result3);
        System.out.println("Test Result: " + (result3.equals("An error occurred: Input must contain an even number of integers.") ? "Pass" : "Fail"));
        System.out.println();

        int[] arr4 = {6, 2, 2, 6, 5, 14, 14}; // Missing one pair
        String result4;
        try {
            result4 = arrayChallenge(arr4);
        } catch (IllegalArgumentException e) {
            result4 = "An error occurred: " + e.getMessage();
        }
        System.out.println("Input: [6, 2, 2, 6, 5, 14, 14]");
        System.out.println("Expected Output: An error occurred: Input must contain an even number of integers.");
        System.out.println("Actual Output: " + result4);
        System.out.println("Test Result: " + (result4.equals("An error occurred: Input must contain an even number of integers.") ? "Pass" : "Fail"));
        System.out.println();

        int[] arr5 = {7, 7, 6, 2, 2, 6, 5, 14, 14, 5, 2, 3, 7, 7}; // Missing one pair
        String result5;
        try {
            result5 = arrayChallenge(arr5);
        } catch (IllegalArgumentException e) {
            result5 = "An error occurred: " + e.getMessage();
        }
        System.out.println("Input: [7, 7, 6, 2, 2, 6, 5, 14, 14, 5, 2, 3, 7, 7]");
        System.out.println("Expected Output: 2,3");
        System.out.println("Actual Output: " + result5);
        System.out.println("Test Result: " + (result5.equals("2,3") ? "Pass" : "Fail"));
        System.out.println();
    }

    // Test the performance of arrayChallenge(arr) and slowArrayChallenge(arr) with a large array
    public static void testMillionArrayChallenge() {
        // Generate a random array of 1 million integers
        int arrayLength = 1000000;
        int[] arr = generateRandomArray(arrayLength);

        // Test the fast method
        long startTime = System.currentTimeMillis(); // Record the start time
        String result = arrayChallenge(arr);


        long endTime = System.currentTimeMillis(); // Record the end time
        long totalTime = endTime - startTime; // Calculate the total time
        System.out.println("Total execution time of arrayChallenge(arr): " + totalTime + " milliseconds");


        // Test the slow method
        long slowStartTime = System.currentTimeMillis(); // Record the start time
        String slowResult = slowArrayChallenge(arr);


        long slowEndTime = System.currentTimeMillis(); // Record the end time
        long slowTotalTime = slowEndTime - slowStartTime; // Calculate the total time

        System.out.println("Total execution time of slowArrayChallenge(arr): " + slowTotalTime + " milliseconds");
    }

    // Test arrayChallenge(arr) with user input
    public static void testArrayChallengeWithUserInput() {
        // Test case 1: Simulate user input "2 1 1 2 3 3\n" (followed by Enter)
        String input1 = "2 1 1 2 3 3\n";
        simulateUserInput(input1);
        String result1 = arrayChallenge(getUserInput());
        System.out.println("Input: [2, 1, 1, 2, 3, 3]");
        System.out.println("Expected Output: 3,3");
        System.out.println("Actual Output: " + result1);
        System.out.println("Test Result: " + (result1.equals("3,3") ? "Pass" : "Fail"));
        System.out.println();

        // Test case 2: Simulate user input "5 4 6 7 7 6 4 5\n" (followed by Enter)
        String input2 = "5 4 6 7 7 6 4 5\n";
        simulateUserInput(input2);
        String result2 = arrayChallenge(getUserInput());
        System.out.println("Input: [5, 4, 6, 7, 7, 6, 4, 5]");
        System.out.println("Expected Output: yes");
        System.out.println("Actual Output: " + result2);
        System.out.println("Test Result: " + (result2.equals("yes") ? "Pass" : "Fail"));
        System.out.println();

        // Test case 3: Simulate user input "6, 2, 2, 6, 5, 14, 14, 1\n" (followed by Enter)
        String input3 = "6 2 2 6 5 14 14 1\n";
        simulateUserInput(input3);
        String result3 = arrayChallenge(getUserInput());
        System.out.println("Input: [6, 2, 2, 6, 5, 14, 14, 1]");
        System.out.println("Expected Output: 5,14,14,1");
        System.out.println("Actual Output: " + result3);
        System.out.println("Test Result: " + (result3.equals("5,14,14,1") ? "Pass" : "Fail"));
        System.out.println();
    }

    // Simulate user input
    private static void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    // Generate a random array of integers
    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100) + 1; // Generates random integers between 1 and 100
        }

        return arr;
    }
}
