// https://cses.fi/problemset/task/1631/
import java.util.*;


public class ReadingBooks {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int totalBooks = input.nextInt();
        int bookTimes[] = {input.nextInt(),input.nextInt(),input.nextInt()};
        
        // get minimum value in the array
        int shortestTime = bookTimes[0];
        int sum = 0;
        for (int i = 0; i < bookTimes.length; i++) {
            if (bookTimes[i] < shortestTime) {
                shortestTime = bookTimes[i];
            }
            sum += bookTimes[i];
        }
        
        System.out.println(sum + shortestTime);
        
        
        
    }
}
