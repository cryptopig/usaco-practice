import java.util.*;
class SquarePasture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dictionary<String, Integer> pasture1 = new Hashtable<>();
        pasture1.put("x1", input.nextInt());
        pasture1.put("y1", input.nextInt());
        pasture1.put("x2", input.nextInt());
        pasture1.put("y2", input.nextInt());
        
        Dictionary<String, Integer> pasture2 = new Hashtable<>();
        pasture2.put("x1", input.nextInt());
        pasture2.put("y1", input.nextInt());
        pasture2.put("x2", input.nextInt());
        pasture2.put("y2", input.nextInt());
        
/* max side length is maximum of largest x minus 
smallest x, largest y minus smallest y */
    int[] x_values = {pasture1.get("x1"), pasture1.get("x2"), pasture2.get("x1"), pasture2.get("x2")};
    int[] y_values = {pasture1.get("y1"), pasture1.get("y2"), pasture2.get("y1"), pasture2.get("y2")};
    
    int min = x_values[0];
    int max = 0;
    for (int i = 0; i < x_values.length; i++) {
        if (x_values[i] < min) min = x_values[i];
        if (x_values[i] > max) max = x_values[i];
    }
    int x_length = max-min;
    
    min = y_values[0];
    max = 0;
    for (int i = 0; i < y_values.length; i++) {
        if (y_values[i] < min) min = x_values[i];
        if (y_values[i] > max) max = x_values[i];
    }
    int y_length = max-min;
    int n = Math.max(y_length,x_length);
    
    System.out.println(n*n);
    }
}
