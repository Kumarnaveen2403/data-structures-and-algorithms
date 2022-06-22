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
   
   if(seta < setb){
       System.out.println(seta);
       System.out.println(setb);
   }else {
       System.out.println(setb);
       System.out.println(seta);
       
   }
  }

}