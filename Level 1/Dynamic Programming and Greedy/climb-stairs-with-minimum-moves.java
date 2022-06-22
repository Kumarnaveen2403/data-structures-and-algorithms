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

        Integer minMoves = climbStairs(n, jumps);

        System.out.println(minMoves);
    }

    public static Integer climbStairs(int n, int[] jumps){
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

         for(int i = n - 1 ; i >= 0 ; i--){
            int noj = jumps[i];

            Integer minMoves = null;
            for(int j = i + 1; j <= Math.min(i + noj, n); j++){
                if(dp[j] == null){
                    if(minMoves == null){
                        continue;
                    } else {
                        dp[j] = minMoves;
                        continue;
                    }
                }

                if(minMoves == null){
                    minMoves = dp[j];
                } else if(dp[j] < minMoves){
                    minMoves = dp[j];
                }

            }

            if(minMoves != null){
                dp[i] = minMoves + 1;
            }
        }
        
        return dp[0];

    }

}