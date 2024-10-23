import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int playerScore,dealerScore;

    public static void main(String[] args) {
        System.out.println("Would you like to play? Y/N");
        // if user inputs anything except for y
        if (!input.next().equalsIgnoreCase("y")) {
            System.out.println("It's a shame you don't want to win big...");
            // exits the program forcefully, so while loop doesn't run
            System.exit(0);
        }

        System.out.println("How much do you want to wager?");
        double wager = input.nextDouble();

        // loop to deal out the hand
        for (int i = 1; i <= 2; i++) {
            int card = hit(playerScore);
            playerScore += card;

            card = hit(dealerScore);
            dealerScore += card;
            if (i == 1) {
                System.out.println("Dealer's face-up card: " + card);
            }
        }
        System.out.println("Your hand total: " + playerScore);

        while (playerScore < 21) {
            String choice;
            System.out.println("Do you want to Hit [H] or Stand [S]?");
            choice = input.next();
            // takes care of all input besides S
            if (!choice.equalsIgnoreCase("s")) {
                playerScore += hit(playerScore);
                System.out.println("Your hand total: " + playerScore);
            }
            
            // if the player stands, it leaves the loop
            else {
                System.out.println("Dealers turn! The game ends when the dealer stands.");
                break;
            }
        }
        while (dealerScore < 17) {
            dealerScore += hit(dealerScore);
        }

        if (playerScore > 21) {
            System.out.println("\nBust! Better luck next time.\n");
            System.out.println("You walk out of this game with: " + outcome(wager, "loss" + " dollars"));
        } else if (dealerScore > 21 ) {
            System.out.println("\nThe dealer bust! You won.\n");
            System.out.println("You walk out of this game with: $" + outcome(wager, "win"));

        } else if (playerScore == dealerScore) {
            System.out.println("\nTie game!\n");
            System.out.println("You walk out of this game with: $" + outcome(wager, "draw"));
        } else if (playerScore == 21) {
            System.out.println("\n21! You win.\n");
            System.out.println("You walk out of this game with: $" + outcome(wager, "win"));
        } else if(dealerScore > playerScore) {
            System.out.println("\nDealer won! Better luck next time.\n");
            System.out.println("You walk out of this game with: " + outcome(wager, "loss") + " dollars");
        } else {
            System.out.println("\nYou won!\n");
            System.out.println("You walk out of this game with: $" + outcome(wager, "win"));
        }

        System.out.println("Your hand total: " + playerScore);
        System.out.println("Dealer's hand total: " + dealerScore);
    }

    // drawing cards
    public static int hit(int score) {
        int n = rand.nextInt(12-2) + 2; // lowest value is 2, highest is 11
        // give choice of 1 to 11, check if the user inputs something else
        if ((n == 11) && (n + score > 21)) {
            n = 1;
        }
        return n;
    }

   // function to handle the wager for every outcome of the game
   public static double outcome(double wager, String outcome) {
        if (Objects.equals(outcome, "win")) {
            return 2*wager;
        }
        if (Objects.equals(outcome, "draw")) {
            return wager * 0;
        }
        else {
            return -wager;
        }
   }
}
