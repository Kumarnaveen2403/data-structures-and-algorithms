import java.io.*;
import java.util.*;

public class Main {

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

        //maze traversal

        int[][] dp = new int[n][m];

        for(int i = arr.length - 1; i >= 0; i--){

            for(int j = arr[0].length - 1; j >= 0; j--){

                if(i == arr.length - 1 && j == arr[0].length - 1){

                    dp[i][j] = arr[i][j];

                } else if(j == arr[0].length - 1){

                    dp[i][j] = arr[i][j] +  dp[i + 1][j];

                } else if(i == arr.length - 1){

                    dp[i][j] = arr[i][j] + dp[i][j + 1];

                } else {

                    dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);

                }

            }
        }

        System.out.println(dp[0][0]);

    }

}