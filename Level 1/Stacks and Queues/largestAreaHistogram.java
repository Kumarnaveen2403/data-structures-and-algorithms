import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code

    //left bounds
    int[] leftBound = new int[a.length];
    leftBound[0] = -1;

    Stack<Integer> ls = new Stack<>();
    ls.push(0);

    for(int i = 1; i < a.length; i++){
      while(ls.size() > 0 && a[i] <= a[ls.peek()]){
        ls.pop();
      }

      if(ls.size() == 0){
        leftBound[i] = -1;
      } else {
        leftBound[i] = ls.peek();
      }

      ls.push(i);
    }

   //right bounds
   int[] rightBound = new int[a.length];

   rightBound[a.length - 1] = a.length;

   Stack<Integer> rs = new Stack<>();
   rs.push(a.length - 1);

   for(int i = a.length - 2; i >= 0; i--){
     while(rs.size() > 0 && a[i] <= a[rs.peek()]){
       rs.pop();
     }

     if(rs.size() == 0){
       rightBound[i] = a.length;
     } else {
       rightBound[i] = rs.peek();
     }

     rs.push(i);
   }

   int maxArea = 0;

   for(int i = 0; i < a.length; i++){
     int lb = leftBound[i];
     int rb = rightBound[i];

     int area = (rb - lb - 1) * a[i];     

     if(area > maxArea){
       maxArea = area;
     }
   }

   System.out.println(maxArea);


  }
}