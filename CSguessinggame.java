import java.util.Random;
import java.util.Scanner;

public class CSguessinggame {

    static void startgame(String user){

        //Take input from user using scanner class
        Scanner scanner = new Scanner(System.in);

        //Random is used to generate a random number
        Random random = new Random();

        int min_val = 1,max_val = 100,attempt_limit = 5,score = 0;

        System.out.println("Welcome "+user+" to the number guessing game\n");

        while (true) {
            
            //Generate a random number between the minimum and the maximum value 
            int numberToGuess = random.nextInt(max_val - min_val + 1) + min_val;

            int attempts = 0;
            
            System.out.println("Think of a number between " + min_val + " and " + max_val + ".");

            while (attempts < attempt_limit) {
                
                // Prompt the user to enter their guess
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    // Provide feedback if the guessed the number correct
                    System.out.println("Congrats "+user+" your guess was correct");
                    score++;
                    break;
                } 
                else if (userGuess < numberToGuess) {
                    // Provide feedback if the guess is lower that the number to be guessed
                    System.out.println("Try to guess a higher number.");
                } 
                else {
                    // Provide feedback if the guess is higher that the number to be guessed
                    System.out.println("Try to guess a lower number.");
                }
            }

            if (attempts >= attempt_limit) {
                // Inform the user that they are out of attempts
                System.out.println("The attempt limit has been reached, your correct number was " + numberToGuess);
            }

            // Ask the user if they want to play another round
            System.out.print("Play another round (yes(y)/no(n)): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("y")) {
                // Exit the game if the user chooses not to play again
                break;
            }
        }

        // Display the user's final score and thank them for playing
        System.out.println("Your final score is: " + score);
        System.out.println("Thanks for playing the number guessing game");
        scanner.close();
    }

    public static void main(String[] args) {
        //Enter the user's name in the startgame method
        startgame("codsoft");
    }
}
