// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        int[] dis = new int[V];
        int[] reach = new int[V];
        points = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                dfs(i, adj, visited, -1, dis, reach);
            }
        }
        
        int counter = 0;
        for(int i = 0; i < points.length; i++){
            if(points[i] == true){
                counter++;
            }
        }
        
        if(counter == 0){
            return new int[] {-1};
        } else {
            int[] artPoints = new int[counter];
            
            counter = 0;
            for(int i = 0; i < points.length; i++){
                if(points[i] == true){
                    artPoints[counter] = i;
                    counter++;
                }
            }
            
            return artPoints;
        }
        
    }
    
    int time = 0;
    boolean[] points;
    
    public void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent, int[] dis, int[] reach){
        
        visited[u] = true;
        dis[u] = reach[u] = time++;
        
        int c = 0;
        for(int v : adj.get(u)){
            if(v == parent){
                continue;
            } else if(visited[v] == true){
                reach[u] = Math.min(dis[v], reach[u]);
            } else {
                c++;
                dfs(v, adj, visited, u, dis, reach);
                
                reach[u] = Math.min(reach[v], reach[u]);
                
                if(parent != -1 && reach[v] >= dis[u]){
                    points[u] = true;
                }
            }
        }
                
        if(parent == -1 && c > 1){
            points[u] = true;
        }              
                
    }
}