class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = threshold + 1; i <= n; i++){
            for(int m = 1; m * i <= n; m++){
                union(i, m * i);
            }
        }
        
        ArrayList<Boolean> list = new ArrayList<>();
        for(int[] query : queries){
            int x = query[0];
            int y = query[1];
            
            int X = find(x);
            int Y = find(y);
            
            if(X == Y){
                list.add(true);
            } else {
                list.add(false);
            }
        }
        
        return list;
    }
    
    int[] parent;
    int[] rank;
    
    public void union(int A, int B){
        int a = find(A);
        int b = find(B);
        
        if(a == b){
            return;
        }
        
        if(rank[a] < rank[b]){
            parent[a] = b;
        } else if(rank[b] < rank[a]){
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }
    
    public int find(int x){
        if(x == parent[x]){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}