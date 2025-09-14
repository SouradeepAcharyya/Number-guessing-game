 import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create Scanner and Random instances
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        int maxAttempts = 7;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("🔢 I have picked a number between 1 and 100.");
        System.out.println("💡 You have " + maxAttempts + " tries to guess it.\n");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess;

            // Validate input
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❗ Please enter a valid number.");
                continue;
            }

            attempts++;

            if (userGuess == numberToGuess) {
                guessed = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("⬆️ Too low!");
            } else {
                System.out.println("⬇️ Too high!");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (guessed) {
            System.out.println("\n🎉 Congratulations! You guessed the number in " + attempts + " tries.");
        } else {
            System.out.println("\n❌ You've used all your attempts. The number was: " + numberToGuess);
        }

        scanner.close();
    }
}
