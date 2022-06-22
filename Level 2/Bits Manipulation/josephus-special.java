import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n){
    //write your code here
    int val = maxTwoPower(n);
    
    int l = n - val;
    
    return 2 * l + 1;
  }
  
  public static int maxTwoPower(int n){
      int v = 1;
      
      while(v * 2 <= n){
          v = v * 2;
      }
      
      return v;
  }
  
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }
  

}