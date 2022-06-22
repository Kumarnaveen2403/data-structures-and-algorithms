import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] jumps = new int[n];

        for(int i = 0; i < n; i++){
            jumps[i] = scn.nextInt();
        }

        int paths = climbStairs(n, jumps);

        System.out.println(paths);
    }

    public static int climbStairs(int n, int[] jumps){
        int[] strg = new int[n + 1];
        strg[n] = 1;

        for(int i = n - 1 ; i >= 0 ; i--){
            int noj = jumps[i];

            int paths = 0;
            for(int j = i + 1; j <= Math.min(i + noj, n); j++){
                paths += strg[j];
            }

            strg[i] = paths;
        }

        
        return strg[0];
    }

}