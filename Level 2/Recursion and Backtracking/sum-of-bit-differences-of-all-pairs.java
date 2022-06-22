import java.io.*;
import java.util.*;

public class Main {

  public static long solution(int[] arr){
      long sum = 0;
      
      for(int i = 0; i < 32; i++){
        long onBits = 0;
        long offBits = 0;
        
        for(int j = 0; j < arr.length; j++){
            int num = arr[j];
            
            if( (num & (1 << i) ) > 0){
                onBits++;
            } else {
                offBits++;
            }
        }
        
        sum += onBits * offBits;
      }
      
      
    return sum * 2;
  }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}