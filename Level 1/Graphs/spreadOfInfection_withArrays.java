import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
      int vtx;
      int doi;

      Pair(int vtx, int doi){
         this.vtx = vtx;
         this.doi = doi;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
     
      Integer[][] graph = new Integer[vtces][vtces];

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1][v2] = 1;
         graph[v2][v1] = 1;
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      
      ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      
      boolean[] visited = new boolean[vtces];
      
      int count = 0;
      
      while(q.size() > 0){
        Pair rem = q.remove();
        
         if(visited[rem.vtx] == true){
            continue;
         }
         if(rem.doi > t){
            break;
         }
        
        visited[rem.vtx] = true;
        
        count++;
        
        for(int i = 0; i < graph.length; i++){
            if(graph[i][rem.vtx] != null && visited[i] == false){
                q.add(new Pair(i, rem.doi + 1));
            }
        }
        
      }
      
      System.out.println(count);
      
   }

}