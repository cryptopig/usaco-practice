// https://cses.fi/problemset/task/1631/
import java.util.*;

public class ReadingBooks {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int totalBooks = input.nextInt();
        int bookTimes[] = new int[totalBooks];
        // variable array sisze handling
        for (int i = 0; i < totalBooks; i++) bookTimes[i] = input.nextInt();
        // get maximum value in the array
        int maxTime = 0;
        int sum = 0;
        for (int i = 0; i < bookTimes.length; i++) {
            if (bookTimes[i] > maxTime) {
                maxTime = bookTimes[i];
            }
            sum += bookTimes[i];
        }
        // sum - maxTime is sum of all other book times
        if ((sum-maxTime) < maxTime) {
            System.out.println(maxTime*2);
        }
        else {
            System.out.println(sum);
        }
    }
}
