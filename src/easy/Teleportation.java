/* PROBLEM:
One of the farming chores Farmer John dislikes the most is hauling around lots of cow manure. In order to streamline this process, he comes up with a brilliant invention: the manure teleporter! Instead of hauling manure between two points in a cart behind his tractor, he can use the manure teleporter to instantly transport manure from one location to another.
Farmer John's farm is built along a single long straight road, so any location on his farm can be described simply using its position along this road (effectively a point on the number line). A teleporter is described by two numbers x
 and y
, where manure brought to location x
 can be instantly transported to location y
, or vice versa.

Farmer John wants to transport manure from location a
 to location b
, and he has built a teleporter that might be helpful during this process (of course, he doesn't need to use the teleporter if it doesn't help). Please help him determine the minimum amount of total distance he needs to haul the manure using his tractor.

INPUT FORMAT (file teleport.in):
The first and only line of input contains four space-separated integers: a
 and b
, describing the start and end locations, followed by x
 and y
, describing the teleporter. All positions are integers in the range 0…100
, and they are not necessarily distinct from each-other.
OUTPUT FORMAT (file teleport.out):
Print a single integer giving the minimum distance Farmer John needs to haul manure in his tractor.
SAMPLE INPUT:
3 10 8 2
SAMPLE OUTPUT:
3
*/

import java.util.Scanner;

public class Teleportation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int loc[] = {input.nextInt(), input.nextInt()};
        int teleporter[] = {input.nextInt(), input.nextInt()};
        int distance_1 = Math.abs(Math.max(loc[0], loc[1]) - Math.max(teleporter[0], teleporter[1]));
        int distance_2 = Math.abs(Math.min(loc[0], loc[1]) - Math.min(teleporter[0], teleporter[1]));
        System.out.println(distance_1 + distance_2);
    }
}
