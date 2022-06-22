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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int v = 0; v < V; v++){
            if(visited[v] == false){
                dfs(v, visited, adj, st);
            }
            
            if(st.size() == V){
                break;
            }
            
        }
        
        // int mv = -1;
        visited = new boolean[V];
        
        dfs2(st.peek(), visited, adj);
        
        for(int v = 0; v < V; v++){
            if(visited[v] == false){
                return -1;
            }
        }

        return st.peek();
    }
    
     public void dfs2(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        if(visited[v] == true){
            return;
        }
        
        visited[v] = true;
        
        for(int vtx: adj.get(v)){
            if(visited[vtx] == false){
                dfs2(vtx, visited, adj);
            }
        }
        
    }
    
    public void dfs(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        if(visited[v] == true){
            return;
        }
        
        visited[v] = true;
        
        for(int vtx: adj.get(v)){
            if(visited[vtx] == false){
                dfs(vtx, visited, adj, st);
            }
        }
        
        st.push(v);
    }
}