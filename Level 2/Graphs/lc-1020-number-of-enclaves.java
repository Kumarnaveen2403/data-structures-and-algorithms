class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int ans = 0;
        
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(visited[i][j] == false && grid[i][j] == 1){
                    int size = traversal(grid, visited, i, j);
                    
                    if(size > 0){
                        ans += size;
                    }
                }
            }
        }
        
        return ans;
    }
    
    public int traversal(int[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0;
        } else if(grid[i][j] == 0 || visited[i][j] == true){
            return 0;
        }
            
        if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
            if(grid[i][j] == 1){
                return -1;
            } else {
                return 0;
            }
        }
        
        visited[i][j] = true;
        
        int s1 = traversal(grid, visited, i + 1, j);
        int s2 = traversal(grid, visited, i - 1, j);
        int s3 = traversal(grid, visited, i, j + 1);
        int s4 = traversal(grid, visited, i, j - 1);
        
        if(s1 == -1 || s2 == -1 || s3 == -1 || s4 == -1){
            return -1;
        }
        
        return s1 + s2 + s3 + s4 + 1;
    }
}