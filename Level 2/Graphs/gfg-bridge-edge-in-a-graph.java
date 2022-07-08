// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        boolean[] visited = new boolean[V];
        int[] discovery = new int[V];
        int[] reach = new int[V];
        
        time = 0;
        isBridge = 0;
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, discovery, reach, -1, adj, c, d);
            }
        }
        
        return isBridge;
    }
    
    static int time = 0;
    static int isBridge = 0;
    
    public static void dfs(int u, boolean[] visited, int[] discovery, int[] reach, int parent, ArrayList<ArrayList<Integer>> adj, int c, int d){
        
        visited[u] = true;
        discovery[u] = reach[u] = time++;
        
        for(int v : adj.get(u)){
            if(v == parent){
                
                continue;
                
            } else if(visited[v]){
                
                reach[u] = Math.min(reach[u], discovery[v]);
                
            } else {
                
                dfs(v, visited, discovery, reach, u, adj, c, d);
                
                reach[u] = Math.min(reach[u], reach[v]);
                
                if(reach[v] > discovery[u] && ((c == u && d == v) || (c == v && d == u))){
                    isBridge = 1;
                }
                
            }
            
        }
        
    }
}