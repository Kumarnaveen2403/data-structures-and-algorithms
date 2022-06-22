import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] values = new int[n];
        int[] wts = new int[n];

        for(int i = 0; i < n; i++){
            values[i] = scn.nextInt();
        }

        for(int i = 0; i < n; i++){
            wts[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        int[][] dp = new int[n + 1][tar + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int wt = wts[i - 1];
                int val = values[i - 1];

                int included = 0;
                int excluded = dp[i - 1][j];

                if(j - wt >= 0){
                    included = dp[i - 1][j - wt] + val;
                }

                dp[i][j] = Math.max(excluded, included);
            }
        }

        int max = dp[0][tar];
        for(int i = 1; i < dp.length; i++){
            if(dp[i][tar] > max){
                max = dp[i][tar];
            }
        }

        System.out.println(max);
    }
}