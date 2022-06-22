import java.io.*;
import java.util.*;

public class Main {

    public static boolean targetSumSubset(int[] arr, int tar){
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if( i == 0 && j == 0 ){

                    dp[i][j] = true;

                } else if(i == 0){ 

                    dp[i][j] = false;

                } else if(j == 0){
                    
                    dp[i][j] = true;

                } else {

                    boolean b1 = false, b2 = false;

                    //include value
                    if(j - arr[i - 1] >= 0){
                        b1 = dp[i - 1][j - arr[i - 1]];
                    }
                    
                    //exclude value
                    b2 = dp[i - 1][j];

                    dp[i][j] = b1 || b2;
                }
            }
        }

        return dp[arr.length][tar];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        System.out.println(targetSumSubset(arr, tar));   
    }
}