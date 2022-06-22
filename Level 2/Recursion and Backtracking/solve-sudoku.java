import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
      
    if(i == board.length){
        display(board);
        return;
    }
    
    int ni, nj;
    
    if( j == board[0].length - 1 ){
        ni = i + 1;
        nj = 0;
    } else {
        ni = i;
        nj = j + 1;
    }
    
    if(board[i][j] != 0){
        solveSudoku(board, ni, nj);
    } else {
        for(int val = 1; val <= 9; val++){
            if(isSquareSafe(board, i, j, val) == true){
                board[i][j] = val;
                solveSudoku(board, ni, nj);
                board[i][j] = 0;
            }
        }
    }
  }
  
  public static boolean isSquareSafe(int[][] board, int i, int j, int val){
      
      for(int jj = 0; jj < board[0].length; jj++){
          if(board[i][jj] == val){
              return false;
          }
      }
      
      for(int ii = 0; ii < board.length; ii++){
          if(board[ii][j] == val){
              return false;
          }
      }
      
      int sr = (i / 3) * 3;
      int sc = (j / 3 ) * 3;
      
      for(int ii = sr; ii < sr + 3; ii++){
          for(int jj = sc; jj < sc + 3; jj++){
              if(board[ii][jj] == val){
                  return false;
              }
          }
      }
      
      return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
