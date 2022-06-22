class Solution {
    class Pair{
        int i;
        int j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int[][] ans = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ans[i][j] = grid[i][j];
            }
        }
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int oldColor = grid[row][col];
        
        queue.add(new Pair(row, col));
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        while(queue.size() > 0){
            
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            
            visited[rem.i][rem.j] = true;
            
            if( isAtBorder(rem.i, rem.j, grid) == true ){
                ans[rem.i][rem.j] = -1 * (ans[rem.i][rem.j]);
            }
            
            addNeighbours(rem.i + 1, rem.j, visited, ans, queue, grid[rem.i][rem.j]);
            addNeighbours(rem.i - 1, rem.j, visited, ans, queue, grid[rem.i][rem.j]);
            addNeighbours(rem.i, rem.j + 1, visited, ans, queue, grid[rem.i][rem.j]);
            addNeighbours(rem.i, rem.j - 1, visited, ans, queue, grid[rem.i][rem.j]);

        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(ans[i][j] < 0){
                    ans[i][j] = color;
                }
            }
        }
        
        return ans;
    }
    
    public void addNeighbours(int i, int j, boolean[][] visited, int[][] ans, ArrayDeque<Pair> queue, int oldVal){
        if(i < 0 || i >= visited.length || j < 0 || j >= visited[0].length){
            return;
        } else if(visited[i][j] == true){
            return;
        } if(Math.abs(ans[i][j]) != oldVal){
            return;
        }
        
        queue.add(new Pair(i, j)); 
    }
    
    public boolean isAtBorder(int row, int col, int[][] grid){
        if(row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1){
            return true;
        }
        
        if(grid[row][col] != grid[row + 1][col] ||
            grid[row][col] != grid[row - 1][col] || 
            grid[row][col] != grid[row][col + 1] ||
            grid[row][col] != grid[row][col - 1]
          ){
            return true;
        }
        
        return false;
    }
}