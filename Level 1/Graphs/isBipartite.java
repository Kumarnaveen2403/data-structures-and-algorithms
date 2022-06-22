import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
      static class Pair {
      int vtx;
      int level;

      Pair(int vtx, int level){
         this.vtx = vtx;
         this.level = level;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
        Integer[] visited = new Integer[vtces];

      for(int i = 0; i < graph.length; i++){
         if(visited[i] == null){
            boolean isBipartite = isBipartite(graph, visited, i, 1);
            if(isBipartite == false){
               System.out.println(false);
               return;
            }
         }
      }

      System.out.println(true);
      
   }
   
   public static boolean isBipartite(ArrayList<Edge>[] graph, Integer[] visited, int src, int level){

         ArrayDeque<Pair> queue = new ArrayDeque<>();
         queue.add(new Pair(src, 1));

         while(queue.size() > 0){
            Pair top = queue.remove();

            if(visited[top.vtx] != null){
                int originalVal = visited[top.vtx];
                int newVal = top.level % 2;
               if(originalVal != newVal){
                  return false;
               }
            }

            visited[top.vtx] = top.level % 2;

            for(int i = 0; i < graph[top.vtx].size(); i++){
               Edge e = graph[top.vtx].get(i);

               if(visited[e.nbr] == null){
                  // isBipartite(graph, visited, e.nbr, top.level + 1);
                  queue.add(new Pair(e.nbr, top.level + 1));
               }

            }
         }

         return true;

      }
}