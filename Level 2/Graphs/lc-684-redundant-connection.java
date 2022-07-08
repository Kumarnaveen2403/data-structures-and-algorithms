class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        int[] ans = new int[2];
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            
            int leadOfA = find(a, parent);
            int leadOfB = find(b, parent);
            
            if(leadOfA != leadOfB){
                union(leadOfA, leadOfB, parent, rank);
            } else {
                ans[0] = a;
                ans[1] = b;
                break;
            }
        }
        
        return ans;
    }
    
    public void union(int a, int b, int[] parent, int[] rank){
        if(rank[a] < rank[b]){
            parent[a] = b;
        } else if(rank[b] < rank[a]){
            parent[b] = a;
        } else {
            parent[a] = b;
            rank[b]++;
        }
    }
    
    public int find(int i, int[] parent){
        if(parent[i] == i){
            return i;
        } else {
            parent[i] = find(parent[i], parent);
            return parent[i];
        }
    }
}