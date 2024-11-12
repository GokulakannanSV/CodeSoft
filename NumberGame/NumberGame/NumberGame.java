package NumberGame;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int roundsWon = 0;
        int totalRounds = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between " + lowerBound + " and " + upperBound + ".");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! " + attemptsLeft + " attempts left.");
                } else {
                    System.out.println("Too high! " + attemptsLeft + " attempts left.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            totalRounds++;
            System.out.println("\nRounds won: " + roundsWon + "/" + totalRounds);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Final score: " + roundsWon + " out of " + totalRounds + " rounds.");
        scanner.close();
    }
}

