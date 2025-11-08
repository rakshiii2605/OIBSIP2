import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int score = 0;
        char playAgain;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        do {
            int randomNumber = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 5;
            boolean guessedCorrect = false;

            System.out.println("\nI have generated a number between 1 to 100.");
            System.out.println("You have " + attempts + " attempts to guess it.");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + " - Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("✅ Correct! You guessed the number.");
                    guessedCorrect = true;
                    score += (attempts - i + 1) * 10; // more points for fewer attempts
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("⬇ Your guess is too high!");
                } else {
                    System.out.println("⬆ Your guess is too low!");
                }
            }

            if (!guessedCorrect) {
                System.out.println("❌ Out of attempts! The correct number was: " + randomNumber);
            }

            System.out.println("🏆 Current Score: " + score);

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\n🎉 Final Score: " + score);
        System.out.println("👋 Thanks for playing!");
        sc.close();
    }
}
