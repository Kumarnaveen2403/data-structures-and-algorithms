import java.io.*;
import java.util.*;

public class Main {
    
  public static void printNQueens(int row, int qpsf, int n, boolean[][] chess, boolean[] cols, boolean[] ndiag, boolean[] rdiag){

    if(qpsf == n){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(chess[i][j] == true){
                    System.out.print(i + "-" + j + ", ");
                }
            }
        }
        System.out.println(".");
        
        return;
    }
    
    for(int i = 0; i < n; i++){
        if(cols[i] == false && ndiag[row + i] == false && rdiag[row - i + n - 1] == false){
            
            chess[row][i] = true;
            
            cols[i] = true;
            ndiag[row + i] = true;
            rdiag[row - i + n - 1] = true;
            
            printNQueens(row + 1, qpsf + 1, n, chess, cols, ndiag, rdiag);
            
            chess[row][i] = false;
            
            cols[i] = false;
            ndiag[row + i] = false;
            rdiag[row - i + n - 1] = false;
            
        }
    }
      
      
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    
    boolean[] cols = new boolean[n];
    boolean[] ndiag = new boolean[2 * n - 1];
    boolean[] rdiag = new boolean[2 * n - 1];
    
    printNQueens(0, 0, n, board, cols, ndiag, rdiag);
    
  }

}