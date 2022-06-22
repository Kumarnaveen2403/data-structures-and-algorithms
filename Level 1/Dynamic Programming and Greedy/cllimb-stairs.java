import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int numOfPaths = climbPaths(n, new int[n + 1]);
        System.out.println(numOfPaths);
    }

    public static int climbPaths(int n, int[] strg){
        if(n < 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        if(strg[n] != 0){
            return strg[n];
        }

        int n1 = climbPaths(n - 1,strg);
        int n2 = climbPaths(n - 2,strg);
        int n3 = climbPaths(n - 3,strg);

        int paths = n1 + n2 + n3;
        strg[n] = paths;

        return paths;
    }

}