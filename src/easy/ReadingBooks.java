// https://cses.fi/problemset/task/1631/
import java.util.*;


public class ReadingBooks {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int totalBooks = input.nextInt();
        int bookTimes[] = new int[totalBooks];
        // variable array sisze handling
        for (int i = 0; i < totalBooks; i++) bookTimes[i] = input.nextInt();
        // get minimum value in the array
        int shortestTime = bookTimes[0];
        int sum = 0;
        for (int i = 0; i < bookTimes.length; i++) {
            if (bookTimes[i] < shortestTime) {
                shortestTime = bookTimes[i];
            }
        }
    }
}
