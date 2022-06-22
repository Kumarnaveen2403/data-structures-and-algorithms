import java.io.*;
import java.util.*;

public class Main {

  public static boolean isReflected(int[][] points) {
    //Code Here
    HashSet<String> set = new HashSet<>();
    
    int xmax = Integer.MIN_VALUE;
    int xmin = Integer.MAX_VALUE;
    
    for(int i = 0; i < points.length; i++){
        int x = points[i][0];
        int y = points[i][1];
        
        set.add(x + "#" + y);
        
        xmax = Math.max(x, xmax);
        xmin = Math.min(x, xmin);
    }
    
    int twiceMid = xmax + xmin;
    
    for(String point : set){
        String[] temp = point.split("#");
        
        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
        
        String pair = (twiceMid - x) + "#" + y;
        if(set.contains(pair) == false){
            return false;
        }
    }
    
    return true;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][] points = new int[n][2];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[0].length; j++) {
        points[i][j] = scn.nextInt();
      }
    }

    System.out.println(isReflected(points));
  }

}