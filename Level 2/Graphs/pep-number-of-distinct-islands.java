import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  public static StringBuilder psf = new StringBuilder();

  public static int numDistinctIslands(int[][] arr) {
    boolean[][] visited = new boolean[arr.length][arr[0].length];
    HashSet<String> set = new HashSet<>();
        
    for(int i = 0; i < arr.length; i++){
        for(int j = 0; j < arr[0].length; j++){
            if(visited[i][j] == false && arr[i][j] == 1){
                helper(arr, visited, i, j, "S");
                
                if(set.contains(psf.toString()) == false){
                    set.add(psf.toString());
                }
                
                psf = new StringBuilder();
            }
        }
    }
    
    return set.size();
  }
  
   public static void helper(int[][] arr, boolean[][] visited, int i, int j, String path){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
            return;
        }
        
        if(arr[i][j] == 0 || visited[i][j] == true){
            return;
        }
        
        psf.append(path);
        visited[i][j] = true;
        
        helper(arr, visited, i + 1, j, path + "D");
        helper(arr, visited, i - 1, j, path + "U");
        helper(arr, visited, i, j + 1, path + "R");
        helper(arr, visited, i, j - 1, path + "L");
        
        psf.append("B");
        
    }
}