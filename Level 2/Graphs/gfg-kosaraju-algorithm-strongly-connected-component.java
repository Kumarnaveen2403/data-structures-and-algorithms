// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                traverse1(i, adj, visited, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        
        for(int v = 0; v < V; v++){
            tsp.add(new ArrayList<>());
        }
        
        for(int v = 0; v < V; v++){
            for(int vtx : adj.get(v)){
                tsp.get(vtx).add(v);
            }
        }
        
        visited = new boolean[V];
        int count = 0;
        
        while(st.size() > 0){
            int v = st.pop();
            
            if(visited[v] == false){
                traverse2(v, tsp, visited);
                count++;
            }
        }
        
        return count;
    }
    
    public void traverse2(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if(visited[v] == true){
            return;
        }
        
        visited[v] = true;
        
        for(int vtx: adj.get(v)){
            if(visited[vtx] == false){
                traverse2(vtx, adj, visited);
            }
        }
        
    }
    
    public void traverse1(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        if(visited[v] == true){
            return;
        }
        
        visited[v] = true;
        
        for(int vtx: adj.get(v)){
            if(visited[vtx] == false){
                traverse1(vtx, adj, visited, st);
            }
        }
        
        st.push(v);
    }
}
