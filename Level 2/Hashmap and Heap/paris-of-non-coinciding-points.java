// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        HashMap<Integer, Integer> forX = new HashMap<>();
        HashMap<Integer, Integer> forY = new HashMap<>();
        HashMap<String, Integer> forXY = new HashMap<>();
        
        int count = 0;
        
        for(int i = 0; i < N; i++){
            int x  = X[i];
            int y = Y[i];
            
            count += forX.getOrDefault(x, 0);
            count += forY.getOrDefault(y, 0);
            
            count -= (forXY.getOrDefault("" + x + "*" + y, 0)) * 2;
            
            forX.put(x, forX.getOrDefault(x, 0) + 1);
            forY.put(y, forY.getOrDefault(y, 0) + 1);
            forXY.put("" + x + "*" + y, forXY.getOrDefault("" + x + "*" + y , 0) + 1);
        }
        
        return count;
        
    }
};