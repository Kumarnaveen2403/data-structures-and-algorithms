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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      boolean[] visited = new boolean[vtces];

      printHamiltonianPath(graph, visited, src, 1, src + "", 0);
      
      
   }
   
   public static void printHamiltonianPath(ArrayList<Edge>[] graph, boolean[] visited, int src, int count, String psf, int orig){
        if(count == graph.length){
            System.out.print(psf);
            
            for(Edge e : graph[orig]){
                if(e.nbr == src){
                    System.out.println("*");
                    return;
                }
            }
            
            System.out.println(".");
            
            return;
        }

        visited[src] = true;
        for(int i = 0; i < graph[src].size(); i++){
            Edge edge = graph[src].get(i);
            int nbr =  edge.nbr;
        
            if(visited[nbr] == false){
                printHamiltonianPath(graph, visited, nbr, count + 1, psf + nbr, orig);
            }
        
        }
        
        visited[src] = false;
        
    }


}