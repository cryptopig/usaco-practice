import java.util.*;
public class PasswordManager {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        System.out.print("Would you like to [g] generate, or \n[c] to check password strength? \n> ");
        String choice = input.next();

        if (choice.toLowerCase().equals("g") || choice.toLowerCase().equals("generate")) {
            System.out.print("How long would you like the password to be? \n> ");
            int length = input.nextInt();
            Password password = new Password(generator.generate_password(length));
            System.out.println("Your password: " + password.toString() + ".");
        }
        else {
            System.out.print("Input your password here: \n> ");
            choice = input.next();
            Password password = new Password(choice);
            System.out.println("Your password: " + password.toString());
            password.checkStrength();
        }
        input.close();
    }
}
// made password an object for practice
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
    public void checkStrength(String contents) {
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
            reasons.add("You need at least " + MIN_NUMBERS + " numbers. ");
        }
        if (charCount < MIN_CHARACTERS) {
            reasons.add("You need at least " + MIN_CHARACTERS + " characters. ");
        }

        if (reasons.size() != 0) {
            for (int i = 0; i < reasons.size(); i++) {
                System.out.println(reasons.get(i));
            }
        }
        else {
            System.out.println("Your password is strong!");
        }
    }
    // method overloading if string argument is not provided
    public void checkStrength() {
        checkStrength(this.contents);
    }
}
class PasswordGenerator {
    public static String numbers = "1234567890";
    public static String letters = "QqwWeErRtTyYuUiIoOpPaAsSdDfFgGhHjJkKlLZzXxCcVvBbNnMm";
    public static String characters = "!@#$%^&*()_+{}|:<>?,.-=[]";

    public String generate_password(int length) {
        String contents = "";
        // initialization - random letters
        for (int i = 0; i < length; i++) {
            contents += letters.charAt(random(0, letters.length() - 1));
        }

        char[] contentsArray = contents.toCharArray();

        // characters
        for (int i = 0; i < length / 3; i++) {
            int index = random(0, contentsArray.length - 1);
            contentsArray[index] = numbers.charAt(random(0, numbers.length() - 1));
        }

        // numbers
        for (int i = 0; i < length / 4 ; i++) {
            int index = random(0, contentsArray.length - 1);
            contentsArray[index] = characters.charAt(random(0, characters.length() - 1));
        }
        
        contents = String.valueOf(contentsArray);
        return contents;
    }
    public int random(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }
}