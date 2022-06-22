import java.io.*;
import java.util.*;

public class Main {

    public static int goldMine(int[][] arr){
        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

        int n = arr.length, m = arr[0].length;

        int[][] dp = new int[n][m];

        for(int j = m - 1; j >= 0; j--){
            for(int i = n - 1; i >= 0; i--){

                if(j == arr[0].length - 1){
                    dp[i][j] = arr[i][j];
                    continue;
                }

                int maxGold = 0;

                for(int d = 0; d < dir.length; d++){

                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if( r >= 0 && r < arr.length && c >= 0 && c < arr[0].length ){
                        maxGold = Math.max(maxGold, arr[i][j] + dp[r][c]);
                    }
                }

                dp[i][j] = maxGold;
            }
        }

        int maxGold = 0;
        for(int i = 0; i < arr.length; i++){
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;

    }

    public static void main(String[] args) throws Exception {
        // write your code here
         Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println(goldMine(arr));
    }

}