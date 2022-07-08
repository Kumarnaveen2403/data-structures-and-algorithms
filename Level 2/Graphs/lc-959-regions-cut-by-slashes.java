class Solution {
    int[] parent;
    int[] rank;
    
    public int regionsBySlashes(String[] grid) {
        parent = new int[4 * grid.length * grid.length];
        rank = new int[4 * grid.length * grid.length];
        
        for(int i = 0; i < parent.length; i++){
            parent[i]  = i;
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                int bno = i * grid.length + j;
                
                if(grid[i].charAt(j) != '/'){
                    unionHelper(bno * 4 + 0, bno * 4 + 1);
                    unionHelper(bno * 4 + 2, bno * 4 + 3);
                }
                
                if(grid[i].charAt(j) != '\\'){
                    unionHelper(bno * 4 + 0, bno * 4 + 3);
                    unionHelper(bno * 4 + 1, bno * 4 + 2);
                }
                
                if(i > 0){
                    unionHelper(bno * 4 + 0, ((i - 1) * grid.length + j) * 4 + 2);
                }
                
                if(j > 0){
                    unionHelper(bno * 4 + 3, (i * grid.length + (j - 1)) * 4 + 1);
                }
                
                if(i < grid.length - 1){
                    unionHelper(bno * 4 + 2, ((i + 1) * grid.length + j) * 4 + 0);
                }
                
                if(j < grid.length - 1){
                    unionHelper(bno * 4 + 1, (i * grid.length + (j + 1)) * 4 + 3);
                }
            }
        }
                                
        int count = 0;
                     
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                count++;
            }
        }                                

        return count;
    }
    
    public void union(int x, int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        } else if(rank[y] < rank[x]){
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }
    
    public int find(int x){
        if ( parent[x] == x ) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl != yl){
            union(xl, yl);
        }
    }
}