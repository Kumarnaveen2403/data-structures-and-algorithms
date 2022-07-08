class Solution {
    //using dfs, visited a vertex and mark as 1 and pre order
    //if it is already marked as 1, return false
    //if it is marked with 2, continue
    //if all neighbors are marked 2, return true;
    //if any one of the neighbors is marked 1, return false
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == 0){
                dfs(i, visited, graph);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == 2) list.add(i);
        }
        
        return list;
    }
    
    public boolean dfs(int v, int[] visited, int[][] graph){
        boolean flag = true;
        
        for(int nbr : graph[v]){
            if(visited[nbr] == 2){
                continue;
            }
            
            if(visited[nbr] == 1){
                return false;
            }
            
            visited[nbr] = 1;            
            flag = dfs(nbr, visited, graph);
            
            if(!flag){
                return false;
            }
        }
        
        visited[v] = 2;
        return true;        
        
    }
}