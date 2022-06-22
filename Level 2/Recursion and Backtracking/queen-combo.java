import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // write your code here
        if(qpsf == tq){
            for(int ii = 0; ii < chess.length; ii++){
                for(int jj = 0; jj < chess.length; jj++){
                    if(chess[ii][jj] == true){
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            
            System.out.println();
            return;
        }
        
        for(int ii = i; ii < chess.length; ii++){
            for(int jj = (ii == i? j + 1: 0); jj < chess.length; jj++){
                if(chess[ii][jj] == false){
                    chess[ii][jj] = true;
                    queensCombinations(qpsf + 1, tq, chess, ii, jj);
                    chess[ii][jj] = false;
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}