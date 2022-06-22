class Solution {
    class Pair{
        int i;
        int j;
        int dist = -1;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        Pair p = new Pair(-1, -1);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    p = new Pair(i, j);
                    // grid[i][j] = -1;
                    break;
                }
            }
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        traverse(p.i, p.j, grid, visited, queue);
        
        int dist = 0;
        
        // queue.add(p);
        boolean[][] visited2 = new boolean[grid.length][grid[0].length];
        
        while(queue.size() > 0){
            
            Pair rem = queue.remove();
            
            if(visited2[rem.i][rem.j] == true){
                continue;
            }
            visited2[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1){
                    dist = rem.dist;
                    break;
            }
            
            addNeighbour(rem.i + 1, rem.j, grid, visited2, queue, rem.dist);       
            addNeighbour(rem.i - 1, rem.j, grid, visited2, queue, rem.dist);       
            addNeighbour(rem.i, rem.j + 1, grid, visited2, queue, rem.dist);       
            addNeighbour(rem.i, rem.j - 1, grid, visited2, queue, rem.dist);       
        }
        
        return dist;
    }

    public void traverse(int i, int j, int[][] grid, boolean[][] visited, ArrayDeque<Pair> queue){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        grid[i][j] = -1;
        queue.add(new Pair(i, j));
        
        traverse(i + 1, j, grid, visited, queue);
        traverse(i - 1, j, grid, visited, queue);
        traverse(i, j + 1, grid, visited, queue);
        traverse(i, j - 1, grid, visited, queue);
        
        // visited[i][j] = false;
    }
    
    public void addNeighbour(int i, int j, int[][] grid, boolean[][] visited,  ArrayDeque<Pair> queue, int dist){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true){
          return;  
        }
        
        Pair p = new Pair(i, j);
        p.dist = dist + 1;
        queue.add(p);
    }
}