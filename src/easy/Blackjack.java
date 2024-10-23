import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int playerScore,dealerScore;

    public static void main(String[] args) {
        double gains = 0;
        while (true) {    
            System.out.println("Would YOU like to play? Y/N");
            // if user inputs anything except for y
            if (!input.next().equalsIgnoreCase("y")) {
                System.out.println("It's a shame YOU don't want to win big...");
                // exits the program forcefully, so while loop doesn't run
                System.exit(0);
            }

            double wager = 0;
            while (!(wager > 0)) {
                System.out.println("How much do YOU want to wager? It must be a bet greater than 0.");
                wager = input.nextDouble();
            }

            // loop to deal out the hand
            for (int i = 1; i <= 2; i++) {
                int card = hit(playerScore);
                playerScore += card;
                card = hit(dealerScore);
                dealerScore += card;
                if (i == 1) {
                    System.out.println("DEALER'S face-up card: " + card);
                }
            }
            System.out.println("YOUR hand total: " + playerScore);
            while (playerScore < 21) {
                String choice;
                System.out.println("Do YOU want to Hit [H] or Stand [S]?");
                choice = input.next();
                // takes care of all input besides S
                if (!choice.equalsIgnoreCase("s")) {
                    playerScore += hit(playerScore);
                    System.out.println("YOUR hand total: " + playerScore);
                }
                // if the player stands, it leaves the loop
                else {
                    System.out.println("DEALER'S turn! The game ends when the DEALER stands.");
                    break;
                }
            }
            while (dealerScore < 17) {
                int card = hit(dealerScore);
                dealerScore += card;
                System.out.println("DEALER draws " + card);
            }

            if (playerScore > 21) {
                System.out.println("\nBust! Better luck next time.\n");
                gains += outcome(wager, "loss");
                System.out.println("YOUR gains/losses: " + "$" + gains);
            } else if (dealerScore > 21 ) {
                System.out.println("\nThe dealer bust! YOU won.\n");
                gains += outcome(wager, "win");
                System.out.println("YOUR gains/losses: " + "$" + gains);
    
            } else if (playerScore == dealerScore) {
                System.out.println("\nTie game!\n");
                gains += outcome(wager, "tie");
                System.out.println("YOUR gains/losses: " + "$" + gains);
            } else if (playerScore == 21) {
                System.out.println("\n21! YOU win.\n");
                gains += outcome(wager, "win");
                System.out.println("YOUR gains/losses: " + "$" + gains);
            } else if(dealerScore > playerScore) {
                System.out.println("\nDealer won! Better luck next time.\n");
                gains += outcome(wager, "loss");
                System.out.println("YOUR gains/losses: " + "$" + gains);
            } else {
                System.out.println("\nYOU won!\n");
                gains += outcome(wager, "win");
                System.out.println("YOUR gains/losses: " + "$" + gains);
            }
            System.out.println("YOUR hand total: " + playerScore);
            System.out.println("DEALER'S hand total: " + dealerScore + "\n");
            System.out.println("___________________________\n");
            playerScore = 0;
            dealerScore = 0;
        }
    }
    // drawing cards
    public static int hit(int score) {
        int n = rand.nextInt(13-2) + 1; // lowest value is 2, highest is 13
        // give choice of 1 to 11, check if the user inputs something else
        if ((n == 1) && (n + score <= 21)) {
            n = 11;
        }
        if (n == 11 || n == 12 || n == 13) {
            n = 10;
        }
        return n;
    }
   // function to handle the wager for every outcome of the game
   public static double outcome(double wager, String outcome) {
        if (Objects.equals(outcome, "win")) {
            return 2*wager;
        }
        if (Objects.equals(outcome, "tie")) {
            return wager * 0;
        }
        else {
            return -wager;
        }
   }
}
