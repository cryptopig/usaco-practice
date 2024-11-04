// https://open.kattis.com/problems/basketballoneonone
import java.util.Scanner;
public class Basketball {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String record = input.nextLine();
        char lastTurn = record.charAt(record.length() - 2);
        System.out.println(lastTurn);
    }
}
