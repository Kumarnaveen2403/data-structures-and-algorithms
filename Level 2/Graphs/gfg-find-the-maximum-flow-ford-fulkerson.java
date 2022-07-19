// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    {
        int maxFlow = 0;
        
        int[][] graph = new int[N + 1][N + 1];
        int[][] rgraph = new int[N + 1][N + 1];
        
        for(ArrayList<Integer> edge : Edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            
            graph[u][v] += w;
            graph[v][u] += w;
            
            rgraph[u][v] += w;
            rgraph[v][u] += w;
        }
        
        int[] par = new int[N + 1];
        while(pathFound(par, rgraph) == true){
            int flow = Integer.MAX_VALUE;
            
            int v = N;
            while(v != 1){
                int pv = par[v];
                if(rgraph[pv][v] < flow){
                    flow = rgraph[pv][v];
                }
                
                v = pv;
            }
            
            v = N;
            while(v != 1){
                int pv = par[v];
                rgraph[pv][v] -= flow;
                rgraph[v][pv] += flow;
                
                v = pv;
            }                        
            
            maxFlow += flow;
        }
        
        
        
        return maxFlow;
    }
    
    boolean pathFound(int[] par, int[][] rgraph){
        boolean[] vis = new boolean[par.length];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        
        while(queue.size() > 0){
            int rem = queue.remove();
            
            if(vis[rem] == true){
                continue;
            }
            vis[rem] = true;
            
            if(rem == par.length - 1){
                return true;
            }
            
            for(int i = 1; i < rgraph[rem].length; i++){
                if(rgraph[rem][i] > 0 && !vis[i]){
                    queue.add(i);
                    par[i] = rem;
                }
            }
            
        }
        
        
        return false;
    }
}