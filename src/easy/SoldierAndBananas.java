// https://codeforces.com/problemset/problem/546/A

import java.util.Scanner;
public class SoldierAndBananas {
    public static void main(String[] args ) {
        Scanner input = new Scanner(System.in);
        int cost_i = input.nextInt();
        int owned = input.nextInt();
        int total = input.nextInt();
        int sum = 0;
        for (int i = 1; i <= total; i++) {
            sum += i;
        } 
        System.out.println((sum*cost_i) - owned);
        input.close();
    }
}

