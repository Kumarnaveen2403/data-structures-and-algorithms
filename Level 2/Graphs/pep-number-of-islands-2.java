import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }
  
  static int[] parent;
  static int[] rank;
  static int count;

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
      List<Integer> list = new ArrayList<>();
      int[][] grid = new int[m][n];
      
      parent = new int[m * n];
      rank = new int[m * n];
      count = 0;
      
      for(int i = 0; i < parent.length; i++){
          parent[i] = i;
          rank[i] = 0;
      }
      
      for(int i = 0; i < positions.length; i++){
          int x = positions[i][0];
          int y = positions[i][1];
          grid[x][y] = 1;
          
          count++;

          findDisjointSet(x + 1, y, grid, x, y);
          findDisjointSet(x - 1, y, grid, x, y);
          findDisjointSet(x, y + 1, grid, x, y);
          findDisjointSet(x, y - 1, grid, x, y);
    
          list.add(count);
      }
      
      return list;
  }
  
  public static void findDisjointSet(int i, int j, int[][] grid, int x, int y){
      if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
          return;
      }
      
      int parNbr = find(i * (grid[0].length) + j);
      int parSrc = find(x * grid[0].length + y);
      
      if(parSrc != parNbr){
          count--;
          union(parSrc, parNbr);
      }
  }
  
  public static void union(int srcLead, int nbrLead){
    if(rank[srcLead] < rank[nbrLead]){
        parent[srcLead] = nbrLead;
    } else if(rank[srcLead] > rank[nbrLead]){
        parent[nbrLead] = srcLead;
    } else {
        parent[srcLead] = nbrLead;
        rank[nbrLead]++;
    }
  }
  
  public static int find(int src){
      if(parent[src] == src){
          return src;
      } else {
          parent[src] = find(parent[src]);
          return parent[src];
      }
  }
  
}