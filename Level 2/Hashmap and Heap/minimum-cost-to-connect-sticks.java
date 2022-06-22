import java.io.*;
import java.util.*;

public class Main {

  public static int connectSticks(int[] sticks) {

    //Code Here
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    for(int val : sticks){
        queue.add(val);
    }
    
    int cost = 0;
    
    while(queue.size() > 1){
        int s1 = queue.remove();
        int s2 = queue.remove();
        
        queue.add(s1 + s2);
        
        cost += s1 + s2;
    }
    
    return cost;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] sticks = new int[n];
    for (int i = 0; i < sticks.length; i++) {
      sticks[i] = scn.nextInt();
    }

    System.out.println(connectSticks(sticks));
  }

}