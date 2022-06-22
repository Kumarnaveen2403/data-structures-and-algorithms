import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int v = 1;
        int h = 2;

        for(int i = 3; i <= n; i++){
            int newWays = v + h;
            
            v = h;
            h = newWays;
        }

        System.out.println(h);
    }
}