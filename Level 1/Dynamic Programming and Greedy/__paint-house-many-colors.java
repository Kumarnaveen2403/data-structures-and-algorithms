import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int houses = scn.nextInt();
        int colors = scn.nextInt();

        int[][] costs = new int[colors][houses];

        for(int j = 0; j < houses; j++){
            for(int i = 0; i < colors; i++){
                costs[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[colors][houses];

        for(int j = 0; j < dp[0].length; j++){
            for(int i = 0; i < dp.length; i++){
                int val = costs[i][j];

                dp[i][j] = val;

                if(j != 0){
                    int minCost = 0;

                    for(int k = 0; k < dp.length; k++){
                        if(k != i) {
                            minCost = Math.min(minCost, dp[k][j - 1]);
                        }
                    }

                    dp[i][j] += minCost;
                }

            }
        }


        int min = dp[0][houses - 1];

        for(int k = 1; k < dp.length; k++){
            if(dp[k][houses - 1] < min){
                min = dp[k][houses - 1];
            }
        }

        System.out.println(min);
    }
}