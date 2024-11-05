import java.util.*;
class SquarePasture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dictionary<String, Integer> pasture_1 = new Hashtable<>();
        pasture_1.put("x1", input.nextInt());
        pasture_1.put("y1", input.nextInt());
        pasture_1.put("x2", input.nextInt());
        pasture_1.put("y2", input.nextInt());
        
        Dictionary<String, Integer> pasture_2 = new Hashtable<>();
        pasture_2.put("x1", input.nextInt());
        pasture_2.put("y1", input.nextInt());
        pasture_2.put("x2", input.nextInt());
        pasture_2.put("y2", input.nextInt());
        
        // max side length
        int x_length = Math.abs(pasture_2.get("x2") - pasture_1.get("x1"));
        int y_length = Math.abs(pasture_2.get("y2") - pasture_1.get("y1"));
        System.out.println(Math.max(x_length, y_length));
        
    }
}
