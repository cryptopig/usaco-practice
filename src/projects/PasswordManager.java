public class PasswordManager {

}

// pw object to make it easier to deal with 
class Password {
    private int length = 12; // default length = 12
    private String contents = "1s(.jQ]#145v"; // default password = 1s(.jQ]#145v

    public Password(int length, String contents) {
        this.length = length;
        this.contents = contents;
    }
}

class PasswordGenerator {
    private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private String letters = "qwertyuiopasdfghjklzxcvbnm";
    private String characters = "!@#$%^&*()_+{}|:<>?,.-=[]";

    public static Passsword generate_password(int length) {
        String contents = "";


        Password generatedPassword = new Password(length, contents);
        return generatedPassword;
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