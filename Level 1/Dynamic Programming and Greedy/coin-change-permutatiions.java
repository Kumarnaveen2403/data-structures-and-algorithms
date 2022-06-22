import java.io.*;
import java.util.*;

public class Main {

    public static int coinPerms(int [] deno, int amt){
        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){

            int perms = 0;

            for(int j = 0; j < deno.length; j++){
                if(i - deno[j] >= 0){
                    perms += dp[i - deno[j]];
                }
            }

            dp[i] = perms;
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

        System.out.println(coinPerms(deno, amt));


    }
}