import java.util.Random;
import java.util.Scanner;

public class NumberGame
 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalAttempts = 0;
        int roundsWon = 0;

     do 
     {
        int min = 1;
        int max = 100;
        int randomNum = random.nextInt(max - min + 1) + min;
        int maxAttempts = 10;
        int attempts = 0;
        System.out.println(" Guess the number between 1 and 100");

        while (attempts < maxAttempts) 
        {
            int userGuess = getUserGuess(scanner);
            compareGuess(randomNum, userGuess);
            attempts++;
            if (userGuess == randomNum)
            {
                break;
            }
        }

        if (attempts < maxAttempts)
        {
             System.out.println("You guessed the number in " + attempts + " attempts.");
            roundsWon++;
        } 
        else 
        {
            System.out.println("You ran out of attempts. The correct number was: " + randomNum);
        }
        totalAttempts += attempts;
        System.out.println("Do you want to play again? (yes/no)");
     } 

     while (scanner.next().toLowerCase().equals("yes"));
     {
        System.out.println("\nYour total score: " + totalAttempts + " attempts in " + roundsWon + " rounds.");
        scanner.close();
     }
    }
    public static int getUserGuess(Scanner scanner) 
    {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }
    public static void compareGuess(int randomNumber, int userGuess) 
    {
         if (userGuess == randomNumber) {
            System.out.println( "Your guess is correct.");
        } else if (userGuess < randomNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    }
}