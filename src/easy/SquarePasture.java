import java.util.Scanner;
public class SquarePasture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // storing coordinates for each pasture in two arrays.
        int[] pasture1 = {input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt()};
        
        int[] pasture2 = {input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt()};
        
        // store side lengths in another  array
        int[] pasture1_lengths = {(pasture1[3] - pasture1[1]), (pasture1[2] - pasture1[0])};
        int[] pasture2_lengths = {(pasture2[3] - pasture2[1]), (pasture2[2] - pasture2[0])};
        
        // finding the largest side length
    
        int side_length = 
        Math.max(
            Math.max(
                pasture1_lengths[0], pasture1_lengths[1]
            );
            
        );
        
        
    }
}
