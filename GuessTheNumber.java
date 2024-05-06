import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random ra = new Random();
            int minRange = 1 ;
            int maxRange = 90;
            int maxAttempts = 4;
            int totalA = 0;
            int roundsWon = 0;

            System.out.println("Welcome to Guess the Number game!");

            boolean playAgain = true;
            while (playAgain) {
                int numberToGuess = ra.nextInt(maxRange - minRange + 1) ;
                int attempts = 0;
                boolean gu = false;

                System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                        totalA += attempts;
                        roundsWon++;
                        gu = true;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!gu) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
                }

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                playAgain = playAgainInput.equalsIgnoreCase("yes");
            }

            System.out.println("Game over! You won " + roundsWon + " rounds with an average of " + (double) totalA / roundsWon + " attempts per round.");
        }
    }
}