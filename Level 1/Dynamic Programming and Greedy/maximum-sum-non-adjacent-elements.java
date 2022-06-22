import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int incl = arr[0];
        int excl = 0;

        for(int i = 1; i < arr.length; i++){
            int newIncl = excl + arr[i];
            int newExcl = Math.max(incl, excl);

            incl = newIncl;
            excl = newExcl;
        }

        System.out.println(Math.max(incl, excl));
    }
}