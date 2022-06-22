import java.io.*;
import java.util.*;

public class Main {

  public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
    
    if(board.length == row){
        System.out.println(asf + ".");
        return;
    }
    
    for(int i = 0; i < board.length; i++){
        if( (cols & (1 << i)) == 0 && (ndiag & (1 << (row + i))) == 0 && (rdiag & (1 << (row - i + board.length - 1))) == 0){
        
            board[row][i] = true;
            
            cols = cols | (1 << i);
            ndiag = ndiag | (1 << (row + i));
            rdiag = rdiag | (1 << (row - i + board.length - 1));
            
            solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + i + ", ");
            
            board[row][i] = false;
            
            cols = cols & ~(1 << i);
            ndiag = ndiag & ~(1 << (row + i));
            rdiag = rdiag & ~(1 << (row - i + board.length - 1));           
            
        }
    }
    
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
  }

}