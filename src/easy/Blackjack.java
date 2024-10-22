import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int playerScore,dealerScore;

    public static void main(String[] args) {
        System.out.print("Would you like to play? Y/N \n> ");
        
        
        if (input.next().toLowerCase().equals("y")) {
            System.out.print("What is your name?\n> ");
            String name = input.nextLine();
            System.out.println("Hello, " + name + ".");
        }
        
        else {
            System.out.println("It's a shame you don't want to win big...");
            System.exit(0);
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
