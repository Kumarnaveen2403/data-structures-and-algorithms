import java.io.*;
import java.util.*;

public class Main {

    public static int coinCombination(int [] deno, int amt){
        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for(int j = 0; j < deno.length; j++){
            for(int i = 1; i < dp.length; i++){
                if(i - deno[j] >= 0){
                    dp[i] += dp[i - deno[j]];
                }
            }
        }

        return dp[amt];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] deno = new int[n];

        for(int i = 0; i < n; i++){
            deno[i] = scn.nextInt();
        }

        int amt = scn.nextInt();

        System.out.println(coinCombination(deno, amt));


    }
}