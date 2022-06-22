///////////////APPROACH 1
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
   
   for(int i = 1; i <= 32; i++){
       int mask = 1 << i;
       int countOfOne = 0;
       
       for(int val : arr){
         if((mask & val) != 0){
            countOfOne++;
         }  
       }
       
       if(countOfOne % 3 != 0){
           res = res | mask;
       }
   }
   
   System.out.println(res);
   
  }

}

///////////////////APPROACH 2

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
   int tn = -1;
   int tn1 = 0;
   int tn2 = 0;
   
   for(int val : arr){
       int cbwtn = tn & val; 
       int cbwtn1 = tn1 & val; 
       int cbwtn2 = tn2 & val; 
       
       tn = tn & ~cbwtn;
       tn1 = tn1 | cbwtn;
       
       tn1 = tn1 & ~cbwtn1;
       tn2 = tn2 | cbwtn1;
       
       tn2 = tn2 & ~cbwtn2;
       tn = tn | cbwtn2;
       
   }
   
   
   System.out.println(tn1);
   
  }

}