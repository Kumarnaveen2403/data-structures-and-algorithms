import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] costs = new int[3][n];

        for(int i = 0; i < n; i++){
            costs[0][i] = scn.nextInt();
            costs[1][i] = scn.nextInt();
            costs[2][i] = scn.nextInt();
        }

        int[][] dp = new int[3][n];

        for(int j = 0; j < n; j++){
            for(int i = 0; i < 3; i++){
                int val = costs[i][j];

                dp[i][j] = val;

                if(j != 0){
                    if(i == 0){
                        dp[i][j] += Math.min(dp[1][j - 1], dp[2][j - 1]);
                    } else if(i == 1){
                        dp[i][j] += Math.min(dp[0][j - 1], dp[2][j - 1]);
                    } else {
                        dp[i][j] += Math.min(dp[0][j - 1], dp[1][j - 1]);
                    }
                }
            }
        }

        System.out.println(Math.min(dp[0][n - 1], Math.min(dp[1][n - 1], dp[2][n - 1])));
    }
}