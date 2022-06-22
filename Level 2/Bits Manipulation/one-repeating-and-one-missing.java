import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here
   
   int res = 0;
   
   for(int val : arr){
       res = res ^ val;
   }
   
   for(int i = 1; i <= arr.length; i++){
       res = res ^ i;
   }
   
   int rmb = (res & -res);
   
   int seta = 0;
   int setb = 0;
   
   for(int val : arr){
       if((rmb & val) == 0){
           seta = seta ^ val;
       } else {
           setb = setb ^ val;
       }
   }
   
   for(int i = 1; i <= arr.length; i++){
       if((rmb & i) == 0){
           seta = seta ^ i;
       } else {
           setb = setb ^ i;
       }
   }
   
  for(int val : arr){
      if(val == seta){
          System.out.println("Missing Number -> " + setb);
          System.out.println("Repeating Number -> " + seta);
        break;     
           
      } else if(val == setb){
          System.out.println("Missing Number -> " + seta);
          System.out.println("Repeating Number -> " + setb);
          break;
      }
  }
   
  }

}