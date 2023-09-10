import java.util.Random;
import java.util.Scanner;

public class CSguessinggame {

    static void startgame(String user){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min_val = 1, max_val = 100, attempt_limit = 5, user_score = 0;

        System.out.println("Welcome " + user + " to the number guessing game\n");

        while (true) {
            int numberToGuess = random.nextInt(max_val - min_val + 1) + min_val;
            int attempts = 0;
            
            System.out.println("Think of a number between " + min_val + " and " + max_val + ".");

            while (attempts < attempt_limit) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congrats " + user + " your guess was correct");
                    user_score++;
                    break;
                } 
                else if (userGuess < numberToGuess) {
                    System.out.println("Try to guess a higher number.");
                } 
                else {
                    System.out.println("Try to guess a lower number.");
                }
            }

            if (attempts >= attempt_limit) {
                System.out.println("The attempt limit has been reached, your correct number was " + numberToGuess);
            }

            System.out.print("Play another round (yes(y)/no(n)): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Your final score is: " + user_score);
        System.out.println("Thanks for playing the number guessing game");
        scanner.close();
    }

    public static void main(String[] args) {
        startgame("codsoft");
    }
}
