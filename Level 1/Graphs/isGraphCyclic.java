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
      String psf;

      Pair(int vtx, String psf){
         this.vtx = vtx;
         this.psf = psf;
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
      boolean[] visited = new boolean[vtces];

      for(int i = 0; i < graph.length; i++){
         if(visited[i] == false){
            if(isCyclic(graph, visited, i) == true){
               System.out.println(true);
               return;
            }
         }
      }

      System.out.println(false);
  }

  public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited, int vtx){

     ArrayDeque<Pair> queue = new ArrayDeque<>();
     queue.add(new Pair(vtx, vtx + ""));

     while(queue.size() > 0){
        Pair top = queue.remove();

        if(visited[top.vtx] == true){
           return true;
        }
        visited[top.vtx] = true;

        for(int i = 0; i < graph[top.vtx].size(); i++){
           Edge e = graph[top.vtx].get(i);
           int nbr = e.nbr;

           if(visited[nbr] == false){
              queue.add(new Pair(nbr, top.psf + nbr));
           }
        }

     }

     return false;
  }
}