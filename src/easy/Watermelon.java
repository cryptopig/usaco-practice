import java.util.*;
class Watermelon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        if (n % 2 == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
