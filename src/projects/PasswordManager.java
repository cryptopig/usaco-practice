import java.util.*;

public class PasswordManager {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        Password password = generator.generate_password(8);
        System.out.println("Password generated.");
        System.out.println(password.getPassword());
    }

}


// pw object to make it easier to deal with 
class Password {
    private String contents = "1s(.jQ]#145v"; // default password = 1s(.jQ]#145v

    public Password(String contents) {
        this.contents = contents;
    }

    public String getPassword() {
        return this.contents;
    }
}

class PasswordGenerator {
    private String numbers = "1234567890";
    private static String letters = "QqwWeErRtTyYuUiIoOpPaAsSdDfFgGhHjJkKlLZzXxCcVvBbNnMm";
    private String characters = "!@#$%^&*()_+{}|:<>?,.-=[]";

    public Password generate_password(int length) {
        String contents = "";
        for (int i = 0; i < length; i++) {
            double charChance = Math.round(Math.random()*3);
            if (charChance == 1) {contents += letters.charAt(random(0, letters.length()));}
            if (charChance == 2) {contents += characters.charAt(random(0, characters.length()));}
            if (charChance == 3) {contents += numbers.charAt(random(0, numbers.length()));}
            
        }


        Password generatedPassword = new Password(contents);
        return generatedPassword;
    }

    public int random(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }

}

/* outline:
 * Password object with length, contents, 
 * Methods: checkStrength()
 * Separate object - password generator; has method for generatePassword()
 * PasswordGenerator has fields for all letters, numbers, special characters
 * 
 * Generating a password:
 * 1. generate a stringn of random letters with integer length
 * 2. Replace a certain % of the string with characters, % of the string with numbers
 * return the password
 */