package firstWeb;

import java.util.List;

public class CatchyNumberFinder {

    private static int calculateCatchinessScore(String number) {
        int catchinessScore = 0;

        // Check for repetitive numbers
        char[] digits = number.toCharArray();
        int repetitiveCount = 1;
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == digits[i - 1]) {
                repetitiveCount++;
            } else {
                catchinessScore += repetitiveCount * repetitiveCount; // Higher score for more repetitions
                repetitiveCount = 1;
            }
        }
        catchinessScore += repetitiveCount * repetitiveCount; // Score for the last set of repetitions

        // Check if the first half is equal to the second half
        int length = number.length();
        if (length % 2 == 0) {
            String firstHalf = number.substring(0, length / 2);
            String secondHalf = number.substring(length / 2);
            if (firstHalf.equals(secondHalf)) {
                catchinessScore += 10; // Arbitrary score for equal first and second halves
            }
        }

        return catchinessScore;
    }

    public static String findCatchyNumber(List<String> numbers) {
        String catchyNumber = "";
        int maxCatchinessScore = 0;

        for (String number : numbers) {
            int catchinessScore = calculateCatchinessScore(number);
            if (catchinessScore > maxCatchinessScore) {
                maxCatchinessScore = catchinessScore;
                catchyNumber = number;
            }
        }

        return catchyNumber;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> numbers = List.of("7777777077", "123456789", "111111111", "88888888");
        String catchyNumber = findCatchyNumber(numbers);
        System.out.println("Most catchy number: " + catchyNumber);
    }
}
