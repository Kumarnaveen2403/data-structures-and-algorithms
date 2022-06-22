import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      boolean[][] visited = new boolean[m][n];

      int count = 0;

      for(int i = 0; i < arr.length; i++){
         for(int j = 0; j < arr[0].length; j++){

            if(visited[i][j] == false && arr[i][j] == 0){
               getIslands(arr, visited, i, j);
               count++;
            }

         }
      }

      System.out.println(count);

   }

   public static void getIslands(int[][] arr, boolean[][] visited, int i, int j){
      if(i < 0  || j < 0 || i >= arr.length || j >= arr[0].length){
         return;
      }

      if(arr[i][j] == 1 || visited[i][j] == true){
         return;
      }
      
      visited[i][j] = true;

      getIslands(arr, visited, i + 1, j);
      getIslands(arr, visited, i - 1, j);
      getIslands(arr, visited, i, j + 1);
      getIslands(arr, visited, i, j - 1);

   }

}