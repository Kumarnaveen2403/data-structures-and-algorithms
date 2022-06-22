class Solution {
    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    helper(grid, visited, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    public void helper(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        
        if(grid[i][j] == '0' || visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        
        helper(grid, visited, i + 1, j);
        helper(grid, visited, i, j + 1);
        helper(grid, visited, i - 1, j);
        helper(grid, visited, i, j - 1);
        
    }
}
