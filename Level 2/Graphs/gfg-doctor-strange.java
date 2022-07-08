// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [][] = new int[K][2];
		    for(int i = 0;i<K;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.doctorStrange(N, K, arr);
            System.out.println(ans);
    	    
		}
	}
}



// } Driver Code Ends

//User function Template for Java

//User function Template for Java


class Complete{
    
    // Function for finding maximum and value pair
    public static int doctorStrange (int n, int k, int g[][]) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        
        
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < g.length; i++){
            int v1 = g[i][0] - 1;
            int v2 = g[i][1] - 1;
            
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        
        
        boolean[] aps = new boolean[n];
        boolean[] visited = new boolean[n];
        int[] dis = new int[n];
        int[] reach = new int[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, adj, dis, reach, -1, aps);
            }
        }
        
        int count = 0;
        for(int i = 0; i < aps.length; i++){
            if(aps[i]){
                count++;
            }
        }
        
        return count;
    }
    
    static int time = 0;
    
    public static void dfs(int u, boolean[] visited, ArrayList<Integer>[] adj, int[] dis, int[] reach, int parent, boolean[] aps){
        
        visited[u] = true;
        dis[u] = reach[u] = time++;
        
        int c = 0;
        for(int v : adj[u]){
            if(v == parent){
                continue;
            } else if(visited[v]){
                reach[u] = Math.min(reach[u], dis[v]);
            } else {
                c++;
                dfs(v, visited, adj, dis, reach, u, aps);
                
                reach[u] = Math.min(reach[u], reach[v]);
                
                if(parent != -1 && reach[v] >= dis[u]){
                    aps[u] = true;
                }
            }
        }
        
        if(parent == -1 && c > 1){
            aps[u] = true;
        }
        
    }
}