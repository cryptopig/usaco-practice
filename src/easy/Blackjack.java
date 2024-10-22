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
            System.out.println("Hello, " + name + ".")
            
            
            
        }
        
        
        
        else {
            System.out.println("It's a shame you don't want to win big...");
        }
    }
    
    public static int hit() {
        int n = rand.nextInt(12-2) + 2; // lowest value is 2, highest is 11
        // give choice of 1 to 11, check if the user inputs something else
        if (n == 11) {
            while (n == 1 || n == 11) {
                System.out.print("Do you want a 1 or 11?");
                n = input.nextInt();
            }
        }
        return n;
    }
}
