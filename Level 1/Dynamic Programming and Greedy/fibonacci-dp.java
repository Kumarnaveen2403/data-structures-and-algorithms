import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int fib = fib(n, new int[n + 1]);
    System.out.println(fib);
 }

 public static int fib(int n, int[] strg){
     if(n == 0 || n == 1){
         return n;
     }

    if(strg[n] != 0){
        return strg[n];
    }

     int n1 = fib(n - 1, strg);
     int n2 = fib(n - 2, strg);

     int res = n1 + n2;
     strg[n] = res;

     return res;
 }

}