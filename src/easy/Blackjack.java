import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Sytstem.out.println("Would you like to play? Y/N \n> ");
        
        if (input.nextString().toLowerCase() == "y") {
            System.out.println("What is your name?\n > ");
            String name = input.nextLine();
        }
        
        else {
            System.out.println("It's a shame you don't want to win big 🤑🤑🤑🤑🤑");
        }
    }
}
