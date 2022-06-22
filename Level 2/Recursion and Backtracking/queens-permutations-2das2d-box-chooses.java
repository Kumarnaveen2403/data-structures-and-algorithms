import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
         if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();  
            }

            
            return;
        }
        
        int nrow;
        int ncol;
        boolean changeRow;
        
        if(col == tq - 1){
            ncol = 0;
            nrow = row + 1;
            changeRow = true;
            
        } else {
            ncol = col + 1;
            nrow = row;
            changeRow = false;
        }
        
        
        for(int i = 0; i < queens.length; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, nrow, ncol, changeRow == true ? asf + "q" + (i + 1) + "\n" : asf + "q" + (i + 1) + "\t", queens);
                queens[i] = false;
            }
        }
        
        queensPermutations(qpsf, tq, nrow, ncol, changeRow == true ? asf + "-\n" : asf + "-\t", queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}