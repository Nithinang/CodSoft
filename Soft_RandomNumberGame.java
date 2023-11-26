import java.util.Random;
import java.util.Scanner;

public class Soft_RandomNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int totalattempts = 0;
        int totalRoundsWon = 0;
        int maxRounds = 3;
        while(totalRoundsWon < maxRounds){        
            int RandomNumber = random.nextInt(100);
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessrandomNumber = false;
            System.out.println("Task 1 from the CodeSoft!");
            System.out.println("Welcome to random number guessing game!");
            System.out.println();
            while(!guessrandomNumber && attempts < maxAttempts){
                System.out.print(RandomNumber);
                System.out.println("Enter the guess Number(1 - 100): ");
                int userGuess = sc.nextInt();
                attempts++;
                if(userGuess > 100 || userGuess < 0){
                    System.out.println("Invalid Input");
                }else if(userGuess < RandomNumber){
                    System.out.println("Your guess is too low");
                }else if(userGuess > RandomNumber){
                    System.out.println("Your guess is too high");
                }else{
                    System.out.println("Congratulation you have guessed it right in " + attempts + " attempts The number was "+RandomNumber+".");
                    guessrandomNumber = true;
                    totalattempts += attempts;
                    totalRoundsWon++;
                }
            }
            if (!guessrandomNumber) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + RandomNumber);
            }

            if (totalRoundsWon < maxRounds) {
                int ans = totalRoundsWon;
                System.out.println("Round " + (ans) + " completed. You can play " + (maxRounds - ans) + " more rounds.");
                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgainInput = sc.next().toLowerCase();
                if (playAgainInput.equals("no")) {
                    break;
                }
            } else {
                System.out.println("You've won " + totalRoundsWon + " rounds!");
            }



        }
        System.out.println("Thank you for playing! Your total score is " + totalRoundsWon + " rounds won with an average of " + (totalattempts / totalRoundsWon) + " attempts per round.");
        sc.close();
    }
}
