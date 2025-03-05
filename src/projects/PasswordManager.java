import java.util.*;

public class PasswordManager {


    static Scanner input = new Scanner(System.in); // TODO: implement user choice later
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        System.out.println("Would you like to [g] generate, or \n[c] to check password strength?");
        String choice = input.nextLine();

        if (choice.toLowerCase() == "g" || choice.toLowerCase() == "generate") {
            System.out.println("How long would you like the password to be?");
            Password password = new Password(generator.generate_password(input.nextInt()));
            System.out.println("Your password: " + password.toString() + ".");
            
        }

        else {
            System.out.print("Input your password here:\n> ");
            Password password = new Password(input.nextLine());
            password.checkStrength();
        }
        

        input.close();
    }

}

// pw object to make it easier to deal with 
class Password {
    // constants that define a secure password
    final int MIN_PASSWORD_LENGTH = 8;
    final int MIN_CHARACTERS = 2;
    final int MIN_NUMBERS = 3;

    private String contents = "1s(.jQ]#145v"; // default password = 1s(.jQ]#145v

    public Password(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return contents;
    }

    // list of reasons why password is unsecure so user can improve password
    // if string argument is provided
    public ArrayList<String> checkStrength(String contents) {
        ArrayList<String> reasons = new ArrayList<>();
        int numCount = 0;
        int charCount = 0;

        if (contents.length() < MIN_PASSWORD_LENGTH) {
            reasons.add("Minimum length is 8. ");
        }

        for (int i = 0; i < contents.length(); i++) {

            /* takes the numbers list from password generator instead of reinitializing it 
             * then checks if the current character is in the list of numbers/characters/etc.
             * and adds to number count/character count/whatever
            */ 
            
            if (PasswordGenerator.numbers.indexOf(contents.charAt(i)) != -1) {
                numCount++;
            }

            else if (PasswordGenerator.characters.indexOf(contents.charAt(i)) != -1) {
                charCount++;
            }
        }
        
        if (numCount < MIN_NUMBERS) {
            reasons.add("You need at least " + MIN_NUMBERS + "numbers. ");
        }

        if (charCount < MIN_CHARACTERS) {
            reasons.add("You need at least " + MIN_CHARACTERS + "characters. ");
        }

        return reasons;
    }

    // method overloading if string argument is not provided
    public ArrayList<String> checkStrength() {
        ArrayList<String> reasons = new ArrayList<>();

        reasons = checkStrength(this.contents);
        return reasons;
    }
}

class PasswordGenerator {
    public static String numbers = "1234567890";
    public static String letters = "QqwWeErRtTyYuUiIoOpPaAsSdDfFgGhHjJkKlLZzXxCcVvBbNnMm";
    public static String characters = "!@#$%^&*()_+{}|:<>?,.-=[]";

    public String generate_password(int length) {
        String contents = "";
        for (int i = 0; i < length; i++) {
            double charChance = Math.round(Math.random()*6);
            if (charChance <= 4) {contents += letters.charAt(random(0, letters.length()));}
            if (charChance == 5) {contents += characters.charAt(random(0, characters.length()));}
            if (charChance == 6) {contents += numbers.charAt(random(0, numbers.length()));}
            
        }
        return contents;
    }

    public int random(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }
}