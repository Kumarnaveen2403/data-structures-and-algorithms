//first remove all hit bricks and union all
//keep 0 as union to the stable wall
//add the bricks in reverse order and get the difference between
//number of bricks connected to 0

class Solution {
    int n;
    int m;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        n = grid.length;
        m = grid[0].length;
        
        parent = new int[n * m + 1];
        rank = new int[n * m + 1];
        size = new int[n * m + 1];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int[] hit : hits){
            int i = hit[0];
            int j = hit[1];
            
            if(grid[i][j] == 1){
                grid[i][j] = 2;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    addNeighbors(i, j, grid);
                }
            }
        }
        
        int[] res = new int[hits.length];
        
        for(int i = hits.length - 1; i >= 0; i--){
            int hi = hits[i][0];
            int hj = hits[i][1];
            
            if(grid[hi][hj] == 2){
                grid[hi][hj] = 1;
                
                int bricksBefore = size[find(0)];

                addNeighbors(hi, hj, grid);

                int bricksAfter = size[find(0)];

                if(bricksAfter > bricksBefore){
                    res[i] = bricksAfter - bricksBefore - 1;
                }
            }
            
        }
        
        return res;
    }
    
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void addNeighbors(int i, int j, int[][] grid){
        int bno = i * m + j + 1;
        
        for(int[] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            int nbno = ni * m + nj + 1;
            
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 1){
                union(bno, nbno);
            }
        }
        
        
        if(i == 0){
            union(0, bno);
        }
    }
    
    int[] parent;
    int[] rank;
    int[] size;
    
    public void union(int A, int B){
         int a = find(A);
         int b = find(B);
        
         if(a == b){
             return;
         }
         
        if(rank[a] < rank[b]){
            parent[a] = b;
            size[b] += size[a];
        } else if(rank[b] < rank[a]){
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[b] = a;
            rank[a]++;
            size[a] += size[b];
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}