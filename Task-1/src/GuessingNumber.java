import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;

        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("\n\t Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (roundsWon + 1) + " - Guess the number between " + minRange + " and " + maxRange + ":");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("\n\t Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    roundsWon++;

                    // Ask the user if they want to play another round
                    System.out.print("\nDo you want to play again? (yes/no): ");
                    String playAgain = scanner.next().toLowerCase();

                    if (!playAgain.equals("yes")) {
                        break;
                    }
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again...");
                } else {
                    System.out.println("Too high! Try again...");
                }
            }

            // If user runs out of attempts
            if (attempts == maxAttempts) {
                System.out.println("\n\tSorry, you've run out of attempts. The correct number was: " + targetNumber);
                // Ask the user if they want to play another round
                System.out.print("\nDo you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }

        } while (true);

        // Display user's score
        System.out.println("\nGame Over!");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);

        scanner.close();
    }
}

