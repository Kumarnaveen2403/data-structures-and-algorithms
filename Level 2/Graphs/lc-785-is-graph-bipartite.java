class Solution {
    class Pair {
        int val;
        
        int color;
        
        Pair(int val, int color){
            this.val = val;
            this.color = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        
        int[] visited = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == 0){
                boolean flag = isGraphBipartite(graph, visited, i);
                if(flag == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isGraphBipartite(int[][] graph, int[] visited, int idx){
        
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(idx, -1));
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(visited[rem.val] != 0){
                if(visited[rem.val] != rem.color){
                    return false;
                } else {
                    continue;
                }
            }
            
            visited[rem.val] = rem.color;
            
            for(int i = 0; i < graph[rem.val].length; i++){
                if(visited[graph[rem.val][i]] == 0){
                    queue.add(new Pair(graph[rem.val][i], -1 * rem.color));
                }
            }
        }
        
        return true;    
    }
}