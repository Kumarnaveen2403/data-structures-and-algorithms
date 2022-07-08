import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t--> 0){
            int cols = scn.nextInt();
            int[] arr1 = new int[cols];
            int[] arr2 = new int[cols];

            for(int i = 0; i < cols; i++){
                arr1[i] = scn.nextInt();
            }

            for(int i = 0; i < cols; i++){
                arr2[i] = scn.nextInt();
            }

            System.out.println(solution(arr1, arr2));
        } 
    }

    static int[] parent;
    static int[] size;

    public static int solution(int[] arr1, int[] arr2){
        parent = new int[arr1.length];
        size = new int[arr1.length];

        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < arr1.length; i++){
            int n1 = arr1[i] - 1;
            int n2 = arr2[i] - 1;

            int leadN1 = find(n1);
            int leadN2 = find(n2);

            if(leadN1 != leadN2){
                union(leadN1, leadN2);
            }
        }

        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                count++;
            }
        }


        int MOD = 1000000007;
        int ans = 1;

        for(int i = 1; i <= count; i++){
            ans = ((ans % MOD) * (2 % MOD)) % MOD;
        }

        return ans;
    }

    public static void union(int a, int b){
        if(size[a] < size[b]){
            parent[a] = b;
            size[b] += size[a];
        } else if(size[b] < size[a]){
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
        }
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}