import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int cii = 0;
        int cij = k;
        int total = k;

        for(int i = 2; i <= n; i++){
            int newCii = cij;
            int newCij = total * (k - 1);

            cii = newCii;
            cij = newCij;

            total = cii + cij;
        }

        System.out.println(total);
    }
}