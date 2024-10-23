import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int playerScore,dealerScore;

    public static void main(String[] args) {
        System.out.println("Would you like to play? Y/N");
        // if user inputs anything except for y
        if (!input.next().toLowerCase().equals("y")) {
            System.out.println("It's a shame you don't want to win big...");
            // exits the program forcefully, so while loop doesn't run
            System.exit(0);
        }
        
        while (playerScore < 21) {
            String choice = "";
            System.out.println("Do you want to Hit [H] or Stand [S]?");
            choice = input.next();
            // takes care of all input besides S
            if (!choice.toLowerCase().equals("s")) {
                playerScore += hit(playerScore);
                System.out.println(playerScore);
            }
            
            // if the player stands
            else {
                
            }
        }
        
        if (playerScore > 21) {
            System.out.println("You went bust! Better luck next time.");
        }
        
        else {
            System.out.println("You won!");
        }
    }
    
    public static int hit(int score) {
        int n = rand.nextInt(12-2) + 2; // lowest value is 2, highest is 11
        // give choice of 1 to 11, check if the user inputs something else
        if ((n == 11) && (n + score > 21)) {
            n = 1;
        }
        return n;
    }
}
