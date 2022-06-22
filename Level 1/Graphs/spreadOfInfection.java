import java.io.*; 
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

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
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      
      queue.add(new Pair(src, 1));

      int count = 0;

      boolean[] visited = new boolean[vtces];

      while(queue.size() > 0) {
         Pair rm = queue.remove();

         if(visited[rm.vtx] == true){
            continue;
         }
         if(rm.doi > t){
            break;
         }

         visited[rm.vtx] = true;

         count++;
         
         for(Edge e : graph[rm.vtx]) {
            int nbr = e.nbr;
            if(visited[nbr] == false){
               queue.add(new Pair(nbr, rm.doi + 1));
            }
         }
      }

      System.out.println(count);

   }

}